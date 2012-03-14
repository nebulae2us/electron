/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nebulae2us.electron;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Trung Phan
 *
 */
public class Converter {
	
	private static final List<Class<?>> SCALAR_TYPES = 
			Arrays.asList(new Class<?>[]{int.class, short.class, byte.class, long.class, double.class, float.class, char.class, boolean.class,
					Integer.class, Short.class, Byte.class, Long.class, 
					Double.class, Float.class, Character.class, Boolean.class,
					BigDecimal.class, BigInteger.class,
					String.class, Date.class});

	private final Map<Object, Object> builders;
	
	private final Object builder;
	
	public Converter(Object builder) {
		this(new IdentityHashMap<Object, Object>(), builder);
	}
	
	private Converter(Map<Object, Object> builders, Object builder) {
		if (builder == null) {
			throw new NullPointerException();
		}
		
		this.builder = builder;
		this.builders = builders;
	}
	
	public static <T> T convert(Class<T> objectClass, Object builder) {
	
		IdentityHashMap<Object, Object> builders = new IdentityHashMap<Object, Object>();
		Converter converter = new Converter(builders, builder);
		return converter.to(objectClass);
	
	}

	private static <T> T defaultPrimityValue(Class<?> objectClass) {
		Object result = null;
		
		if (objectClass == int.class) {
			result = Integer.valueOf(0);
		}
		else if (objectClass == byte.class) {
			result = Byte.valueOf((byte)0);
		}
		else if (objectClass == short.class) {
			result = Short.valueOf((short)0);
		}
		else if (objectClass == long.class) {
			result = Long.valueOf(0L);
		}
		else if (objectClass == double.class) {
			result = Double.valueOf(0.0D);
		}
		else if (objectClass == float.class) {
			result = Float.valueOf(0.0f);
		}
		else if (objectClass == boolean.class) {
			result = Boolean.FALSE;
		}
		else if (objectClass == char.class) {
			result = Character.valueOf((char)0);
		}

		return (T)result;
	}
	
	public static <T> T convertBasicType(Class<?> objectClass, Object builder) {
		Object result = null;

		if (builder instanceof String) {
			if (objectClass == String.class) {
				result = builder;
			}
		}
		else if (builder instanceof Character ) {
			if (objectClass == Character.class || objectClass == char.class) {
				result = builder;
			}
		}
		else if (builder instanceof Number) {
			result = builder;
			
		}
		else if (builder instanceof Boolean) {
			if (objectClass == Boolean.class || objectClass == boolean.class ) {
				result = builder;
			}
		}
		else if (builder instanceof Date) {
			if (objectClass == Date.class) {
				result = new Date(((Date)builder).getTime());
			}
		}
		
		if (result == null) {
			result = defaultPrimityValue(objectClass);
		}
		
		return (T)result;
	}
	
	public <T> T to(Class<T> objectClass) {

		if (SCALAR_TYPES.contains(builder.getClass()) || SCALAR_TYPES.contains(objectClass)) {
			return convertBasicType(objectClass, builder);
		}
		
		T result = (T)this.builders.get(this.builder);
		if (result != null) {
			return result; 
		}

		
		
		Constructor<T> constructor = null;
		try {
			constructor = objectClass.getConstructor(Converter.class);
		} catch (Exception e) {}
		
		if (constructor != null) {
			try {
				result = constructor.newInstance(this);
				
				if (!this.builders.containsKey(this.builder)) {
					this.builders.put(this.builder, result);
				}
				
				return result;
			} catch (Exception e) {
				throw new RuntimeException("Failed to instantiate " + objectClass, e);
			}
		}
		else {
			
			try {
				result = objectClass.newInstance();
			} catch (Exception e) {
				return null;
			}
			
			this.builders.put(this.builder, result);
			
			for (Field field : builder.getClass().getDeclaredFields()) {
				Field friendField = getField(objectClass, field.getName());
				if (friendField == null)
					continue;

				field.setAccessible(true);
				friendField.setAccessible(true);

				
				if (SCALAR_TYPES.contains(field.getType())) {
					if (field.getType() == friendField.getType()) {
						Object value = getValue(field, builder);
						if (field.getType() == Date.class && value != null) {
							value = new Date(((Date)value).getTime());
						}
						setValue(friendField, result, value);
					}
				}
				else if ( List.class.isAssignableFrom( field.getType() )) {
					if (friendField.getType() == List.class ) {

						List valueList = (List)getValue(field, builder);
						if (valueList == null) {
							setValue(friendField, result, null);
						}
						else {
							List newList = new ArrayList();
							setValue(friendField, result, newList);
							
							ParameterizedType friendSubType = (ParameterizedType)friendField.getGenericType();
							Class<?> friendFieldSubClass = (Class<?>)friendSubType.getActualTypeArguments()[0];
							
							for (Object o : valueList) {
								Object newValue = new Converter(builders, o).to(friendFieldSubClass);
								newList.add(newValue);
							}
						}
					}
				}
				else if (!field.getType().isInterface() && !field.getType().isInterface()) {
					if (!friendField.getType().isInterface() && !friendField.getType().isInterface()) {
						
						Object value = getValue(field, builder);
						Object newValue = null;
						if (value != null) {
							newValue = new Converter(this.builders, value).to(friendField.getType());
						}
						setValue(friendField, result, newValue);
					}
					
				}
			}
			
			return result;
		}
	}
	
	private static Field getField(Class c, String fieldName) {
		try {
			Field result = c.getDeclaredField(fieldName);
			return result;
		} catch (Exception e) {
			if (c != Object.class && c.getSuperclass() != null) {
				return getField(c.getSuperclass(), fieldName);
			}
			else {
				return null;
			}
		}
	}
	
	private static Object getValue(Field field, Object object) {
		try {
			field.setAccessible(true);
			return field.get(object);
		} catch (Exception e) {
			return null;
		}
	}
	
	private static void setValue(Field field, Object object, Object value) {
		try {
			field.setAccessible(true);
			field.set(object, value);
		} catch (Exception e) {
		}
	}
	
	@SuppressWarnings("unchecked")
	public <T> T to(Class<T> objectClass, String fieldName) {

		Object builderObject = getValue(fieldName);
		
		
		if (builderObject == null) {
			return null;
		}
		T result = (T)builders.get(builderObject);
		if (result == null) {
			Converter converter = new Converter(builders, builderObject);
			result = (T)converter.to(objectClass);
		}
		
		return result;
	}
	
	public <T> List<T> toListOf(Class<T> objectClass, String fieldName) {
		
		Field field = getField(builder.getClass(), fieldName);
		Object value = getValue(field, builder);
		
		if (value instanceof List) {
			List<T> result = new ArrayList<T>();
			
			List valueList = (List)value;
			for (Object o : valueList) {
				
				T convertedValue = new Converter(this.builders, o).to(objectClass);
				result.add(convertedValue);
			}
			
			return result;
		}
		
		return null;
	}
	
	public Object getValue(String fieldName) {
		Field field = getField(builder.getClass(), fieldName);
		return getValue(field, builder);
	}

	public String getString(String fieldName) {
		return convertBasicType(String.class, getValue(fieldName));
	}

	public Integer getInteger(String fieldName) {
		return convertBasicType(Integer.class, getValue(fieldName));
	}
	
	public int intValue(String fieldName) {
		return convertBasicType(int.class, getValue(fieldName));
	}

	public Long getLong(String fieldName) {
		return convertBasicType(Long.class, getValue(fieldName));
	}
	
	public long longValue(String fieldName) {
		return convertBasicType(long.class, getValue(fieldName));
	}

	public Short getShort(String fieldName) {
		return convertBasicType(Short.class, getValue(fieldName));
	}
	
	public short shortValue(String fieldName) {
		return convertBasicType(short.class, getValue(fieldName));
	}

	public Byte getByte(String fieldName) {
		return convertBasicType(Byte.class, getValue(fieldName));
	}
	
	public byte byteValue(String fieldName) {
		return convertBasicType(byte.class, getValue(fieldName));
	}

	public Double getDouble(String fieldName) {
		return convertBasicType(Double.class, getValue(fieldName));
	}
	
	public double doubleValue(String fieldName) {
		return convertBasicType(double.class, getValue(fieldName));
	}

	public Float getFloat(String fieldName) {
		return convertBasicType(Float.class, getValue(fieldName));
	}
	
	public float floatValue(String fieldName) {
		return convertBasicType(float.class, getValue(fieldName));
	}

	public Boolean getBoolean(String fieldName) {
		return convertBasicType(Boolean.class, getValue(fieldName));
	}
	
	public boolean booleanValue(String fieldName) {
		return convertBasicType(boolean.class, getValue(fieldName));
	}

	public Character getCharacter(String fieldName) {
		return convertBasicType(Character.class, getValue(fieldName));
	}
	
	public char charValue(String fieldName) {
		return convertBasicType(char.class, getValue(fieldName));
	}


	public void register(Object object) {
		this.builders.put(builder, object);
	}
	
	
	
}

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
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.nebulae2us.electron.util.ImmutableList;
import org.nebulae2us.electron.util.ImmutableSet;

import static org.nebulae2us.electron.Constants.*;

/**
 * @author Trung Phan
 *
 */
public class Converter {
	

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
	
	public static class ConvertGroupBuilder {
		
		private List<Class<?>> classes = new ArrayList<Class<?>>();
		private List<Object> objects = new ArrayList<Object>();
		
		public class ConvertBuilder {
			private final Object[] _objects;
			private ConvertBuilder(Object[] _objects) {
				this._objects = _objects;
			}
			public ConvertGroupBuilder to(Class<?> newClass) {
				for (Object object : _objects) {
					classes.add(newClass);
					objects.add(object);
				}
				return ConvertGroupBuilder.this;
			}
		}
		
		public ConvertBuilder convert(Object ... objects) {
			return new ConvertBuilder(objects);
		}
		
		public Map<?, ?> getValues() {
			
			IdentityHashMap<Object, Object> builders = new IdentityHashMap<Object, Object>();
			for (int i = 0; i < objects.size(); i++) {
				Converter converter = new Converter(builders, objects.get(i));
				converter.to(classes.get(i));
			}
			
			return builders;
		}
	}
	
	public static ConvertGroupBuilder convertGroup() {
		return new ConvertGroupBuilder();
	}

	private static <T> T defaultPrimitiveValue(Class<?> objectClass) {
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
	
	public static <T> T convertBasicType(Class<T> objectClass, Object builder) {
		if (builder == null) {
			return defaultPrimitiveValue(objectClass);
		}
		if (builder.getClass() == objectClass) {
			return (T)builder;
		}
		
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
			else if (objectClass == int.class || objectClass == Integer.class) {
				result = (int)((Character)builder).charValue();
			}
			else if (objectClass == short.class || objectClass == Short.class) {
				result = (short)((Character)builder).charValue();
			}
			else if (objectClass == byte.class || objectClass == Byte.class) {
				result = (byte)((Character)builder).charValue();
			}
			else if (objectClass == long.class || objectClass == Long.class) {
				result = (long)((Character)builder).charValue();
			}
		}
		else if (builder instanceof Number) {
			Number n = (Number)builder;
			if (objectClass == char.class || objectClass == Character.class) {
				result = (char)n.intValue();
			}
			else if (objectClass == int.class || objectClass == Integer.class) {
				result = n.intValue();
			}
			else if (objectClass == short.class || objectClass == Short.class) {
				result = n.shortValue();
			}
			else if (objectClass == byte.class || objectClass == Byte.class) {
				result = n.byteValue();
			}
			else if (objectClass == long.class || objectClass == Long.class) {
				result = n.longValue();
			}
			else if (objectClass == double.class || objectClass == Double.class) {
				result = n.doubleValue();
			}
			else if (objectClass == float.class || objectClass == Float.class) {
				result = n.floatValue();
			}
			else if (objectClass == BigInteger.class) {
				if (builder instanceof BigInteger) {
					result = builder;
				}
				else if (builder instanceof BigDecimal) {
					result = ((BigDecimal)builder).toBigInteger();
				}
				else {
					result = BigInteger.valueOf(n.longValue());
				}
			}
			else if (objectClass == BigDecimal.class) {
				if (builder instanceof BigDecimal) {
					result = builder;
				}
				else if (builder instanceof BigInteger) {
					result = new BigDecimal((BigInteger)builder);
				}
				else {
					result = BigDecimal.valueOf(n.doubleValue());
				}
			}
			
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
			result = defaultPrimitiveValue(objectClass);
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
			
			for (Field field : getFields(builder.getClass())) {
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
	
	private static List<Field> getFields(Class<?> c) {
		List<Field> result = new ArrayList<Field>();
		for (Field field : c.getDeclaredFields()) {
			if ((field.getModifiers() & Modifier.STATIC) == 0) {
				result.add(field);
			}
		}
		
		if (c != Object.class && c.getSuperclass() != null) {
			result.addAll(getFields(c.getSuperclass()));
		}
		
		return result;
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

		Object builderObject = toObject(fieldName);
		
		
		if (builderObject == null) {
			if (objectClass.isPrimitive()) {
				return defaultPrimitiveValue(objectClass);
			}
			else {
				return null;
			}
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
		
        if (value instanceof Collection) {
			List<T> result = new ArrayList<T>();
			
			Collection<?> valueList = (Collection<?>)value;
			for (Object o : valueList) {
				
				T convertedValue = new Converter(this.builders, o).to(objectClass);
				result.add(convertedValue);
			}
			
			return new ImmutableList<T>(result);
		}
		
		return null;
	}

	public <T> Set<T> toSetOf(Class<T> objectClass, String fieldName) {
		
		Field field = getField(builder.getClass(), fieldName);
		Object value = getValue(field, builder);
		
        if (value instanceof Collection) {
			List<T> result = new ArrayList<T>();
			
			Collection<?> valueList = (Collection<?>)value;
			for (Object o : valueList) {
				
				T convertedValue = new Converter(this.builders, o).to(objectClass);
				result.add(convertedValue);
			}
			
			return new ImmutableSet<T>(result);
		}
		
		return null;
	}
	
	
	public Object toObject(String fieldName) {
		Field field = getField(builder.getClass(), fieldName);
		return field == null ? null : getValue(field, builder);
	}

	public String toString(String fieldName) {
		return convertBasicType(String.class, toObject(fieldName));
	}

	public Integer toInteger(String fieldName) {
		return convertBasicType(Integer.class, toObject(fieldName));
	}
	
	public int toIntValue(String fieldName) {
		return convertBasicType(int.class, toObject(fieldName));
	}

	public Long toLong(String fieldName) {
		return convertBasicType(Long.class, toObject(fieldName));
	}
	
	public long toLongValue(String fieldName) {
		return convertBasicType(long.class, toObject(fieldName));
	}

	public Short toShort(String fieldName) {
		return convertBasicType(Short.class, toObject(fieldName));
	}
	
	public short toShortValue(String fieldName) {
		return convertBasicType(short.class, toObject(fieldName));
	}

	public Byte toByte(String fieldName) {
		return convertBasicType(Byte.class, toObject(fieldName));
	}
	
	public byte toByteValue(String fieldName) {
		return convertBasicType(byte.class, toObject(fieldName));
	}

	public Double toDouble(String fieldName) {
		return convertBasicType(Double.class, toObject(fieldName));
	}
	
	public double toDoubleValue(String fieldName) {
		return convertBasicType(double.class, toObject(fieldName));
	}

	public Float toFloat(String fieldName) {
		return convertBasicType(Float.class, toObject(fieldName));
	}
	
	public float toFloatValue(String fieldName) {
		return convertBasicType(float.class, toObject(fieldName));
	}

	public Boolean toBoolean(String fieldName) {
		return convertBasicType(Boolean.class, toObject(fieldName));
	}
	
	public boolean toBooleanValue(String fieldName) {
		return convertBasicType(boolean.class, toObject(fieldName));
	}

	public Character toCharacter(String fieldName) {
		return convertBasicType(Character.class, toObject(fieldName));
	}
	
	public char toCharValue(String fieldName) {
		return convertBasicType(char.class, toObject(fieldName));
	}


	public void register(Object object) {
		this.builders.put(builder, object);
	}
	
	
	
}

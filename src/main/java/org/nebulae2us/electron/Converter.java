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

import static org.nebulae2us.electron.Constants.SCALAR_TYPES;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.nebulae2us.electron.internal.util.ClassUtils;
import org.nebulae2us.electron.util.ImmutableList;
import org.nebulae2us.electron.util.ImmutableSet;

import static org.nebulae2us.electron.internal.util.ClassUtils.*;

/**
 * @author Trung Phan
 *
 */
public class Converter {

	private final ConverterOption option;
	
	public Converter() {
		this( new ConverterOption() );
	}

	public Converter(ConverterOption option) {
		this.option = option != null ? option : new ConverterOption();
	}
	

	public class ConvertBuilder {
		private final Object object;
		
		public ConvertBuilder(Object object) {
			this.object = object;
		}
		
		public <T> T to(Class<T> destClass) {
			if (this.object == null) {
				return defaultPrimitiveValue(destClass);
			}
			
			return (T)new MirrorImpl(this.object, option).to(destClass);
		}
	}
	
	public ConvertBuilder convert(Object object) {
		return new ConvertBuilder(object);
	}
	
	
	public class ConvertListBuilder {
		
		private final List<Object> objects = new ArrayList<Object>();
		
		private ConvertListBuilder(Object ... objects) {
			for (Object object : objects) {
				this.objects.add(object);
			}
		}
		
		private ConvertListBuilder(Collection<?> objects) {
			for (Object object : objects) {
				this.objects.add(object);
			}
		}

		@SuppressWarnings("unchecked")
		public <T> List<T> toListOf(Class<T> destClass) {
			IdentityHashMap<Object, Object> builders = new IdentityHashMap<Object, Object>();
			for (int i = 0; i < objects.size(); i++) {
				MirrorImpl converter = new MirrorImpl(builders, objects.get(i), option);
				converter.to(destClass);
			}

			List<T> result = new ArrayList<T>();
			for (Object object : this.objects) {
				result.add((T)builders.get(object));
			}
			
			return result;
		}

		@SuppressWarnings("unchecked")
		public <T> Set<T> toSetOf(Class<T> destClass) {
			IdentityHashMap<Object, Object> builders = new IdentityHashMap<Object, Object>();
			for (int i = 0; i < objects.size(); i++) {
				MirrorImpl converter = new MirrorImpl(builders, objects.get(i), option);
				converter.to(destClass);
			}

			Set<T> result = new HashSet<T>();
			for (Object object : this.objects) {
				result.add((T)builders.get(object));
			}
			
			return result;
		}
		
	}
	

	public class ConvertGroupBuilder {
		
		private List<Class<?>> destClasses = new ArrayList<Class<?>>();
		
		private List<Object> objects = new ArrayList<Object>();
		
		public class ConvertBuilder {
			
			private final List<Object> localObjects = new ArrayList<Object>();
			
			private ConvertBuilder(Object ... localObjects) {
				for (Object object : localObjects) {
					this.localObjects.add(object);
				}
			}

			private ConvertBuilder(Collection<?> localObjects) {
				for (Object object : localObjects) {
					this.localObjects.add(object);
				}
			}
			
			public ConvertGroupBuilder to(Class<?> destClass) {
				for (Object object : localObjects) {
					ConvertGroupBuilder.this.destClasses.add(destClass);
					ConvertGroupBuilder.this.objects.add(object);
				}
				return ConvertGroupBuilder.this;
			}
		}
		
		public ConvertBuilder convert(Object ... objects) {
			return new ConvertBuilder(objects);
		}
		
		public ConvertBuilder convert(Collection<?> objects) {
			return new ConvertBuilder(objects);
		}
		
		public Map<?, ?> getValues() {
			
			IdentityHashMap<Object, Object> builders = new IdentityHashMap<Object, Object>();
			for (int i = 0; i < objects.size(); i++) {
				MirrorImpl converter = new MirrorImpl(builders, objects.get(i), option);
				converter.to(destClasses.get(i));
			}
			
			return builders;
		}
	}
	
	public ConvertGroupBuilder convertGroup() {
		return new ConvertGroupBuilder();
	}

	private static <T> T defaultPrimitiveValue(Class<T> objectClass) {
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
	
	private static <T> T convertBasicType(Class<T> objectClass, Object builder) {
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


	public final static class MirrorImpl implements Mirror {
		
		private final Map<Object, Object> builders;
		
		private final Object builder;
		
		private final ConverterOption option;
		
		private MirrorImpl(Object builder, ConverterOption option) {
			this(new IdentityHashMap<Object, Object>(), builder, option);
		}
		
		private MirrorImpl(Map<Object, Object> builders, Object builder, ConverterOption option) {
			if (builder == null) {
				throw new NullPointerException();
			}
			
			this.builder = builder;
			this.builders = builders;
			this.option = option;
		}
		
		
		private static Collection<?> createMutableCollection(Class<?> c) {
			if (List.class.isAssignableFrom(c)) {
				
				return new ArrayList();
					
			}
			
			return new HashSet();
		}
		
		private Collection convertCollectionType(Type type, Object builder) {
			if (ClassUtils.isCollectionType(type) && builder instanceof Collection) {
				Class<?> destClass = ClassUtils.getClass(type);

				Type subType = ClassUtils.getGenericSubType(type);
				Class<?> subClass = subType != null ? ClassUtils.getClass(subType) : Object.class;

				Collection result = createMutableCollection(destClass);
				for (Object o : (Collection<?>)builder) {
					Object newValue = new MirrorImpl(builders, o, option).to(subClass);
					result.add(newValue);
				}
				return result;
			}

			return null;
		}
		
		@SuppressWarnings("rawtypes")
		private Object to(Type type) {

			if (SCALAR_TYPES.contains(builder.getClass()) || SCALAR_TYPES.contains(type)) {
				return convertBasicType((Class<?>)type, builder);
			}
			
			if (this.builders.containsKey(this.builder)) {
				return this.builders.get(this.builder);
			}

			if (ClassUtils.isCollectionType(type)) {
				if (ClassUtils.isCollectionType(builder.getClass())) {
					return convertCollectionType(type, builder);
				}
				return null;
			}
			
			Class<?> destClass = this.option.findBestDestinationClass(builder.getClass(), ClassUtils.getClass(type));
			
			Constructor<?> constructor = ClassUtils.getConverterConstructor(destClass);

			if (constructor != null) {
				try {
					Object result = constructor.newInstance(this);
					this.builders.put(this.builder, result);
					
					return result;
				} catch (Exception e) {
					throw new RuntimeException("Failed to instantiate " + destClass, e);
				}
			}
			else {

				Object result = instantiate(destClass);
				if (result == null) {
					return destClass.isPrimitive() ? defaultPrimitiveValue(destClass) : null;
				}
				this.builders.put(this.builder, result);
				
				
				for (Field field : getFields(builder.getClass())) {
					Field friendField = getField(destClass, field.getName());
					if (friendField == null)
						continue;

					field.setAccessible(true);
					friendField.setAccessible(true);

					
					if (SCALAR_TYPES.contains(field.getType())) {
						Object value = convertBasicType(friendField.getType(), getValue(field, builder));
						setValue(friendField, result, value);
					}
					else {
							
						Object value = getValue(field, builder);
						if (value != null) {
							Object newValue = new MirrorImpl(this.builders, value, option).to(friendField.getGenericType());
							setValue(friendField, result, newValue);
						}
					}
				}
				
				return result;
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
				MirrorImpl converter = new MirrorImpl(builders, builderObject, option);
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
					
					T convertedValue = (T)new MirrorImpl(this.builders, o, option).to(objectClass);
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
					
					T convertedValue = (T)new MirrorImpl(this.builders, o, option).to(objectClass);
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

}

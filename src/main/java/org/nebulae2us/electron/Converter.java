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

import static org.nebulae2us.electron.Constants.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
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

import org.nebulae2us.electron.internal.util.ClassHolder;
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
		this( ConverterOptions.EMPTY_MUTABLE_OPTION );
	}

	public Converter(ConverterOption option) {
		this.option = option != null ? option : ConverterOptions.EMPTY_MUTABLE_OPTION;
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
			
			return (T)new MirrorImpl(Converter.this, this.object, option).to(ClassHolder.newInstance(destClass));
		}
	}
	
	public ConvertBuilder convert(Object object) {
		return new ConvertBuilder(object);
	}
	
	
	public ConvertListBuilder convert(Object ... objects) {
		return new ConvertListBuilder(objects);
	}
	
	public ConvertListBuilder convert(Collection<?> objects) {
		return new ConvertListBuilder(objects);
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
			IdentityHashMap<Object, Object> convertedObjects = new IdentityHashMap<Object, Object>();
			for (int i = 0; i < objects.size(); i++) {
				MirrorImpl converter = new MirrorImpl(Converter.this, convertedObjects, objects.get(i), option);
				converter.to(ClassHolder.newInstance(destClass));
			}

			List<T> result = new ArrayList<T>();
			for (Object object : this.objects) {
				result.add((T)convertedObjects.get(object));
			}
			
			if (option.isImmutable()) {
				return new ImmutableList<T>(result);
			}
			else {
				return result;
			}
		}

		@SuppressWarnings("unchecked")
		public <T> Set<T> toSetOf(Class<T> destClass) {
			IdentityHashMap<Object, Object> convertedObjects = new IdentityHashMap<Object, Object>();
			for (int i = 0; i < objects.size(); i++) {
				MirrorImpl converter = new MirrorImpl(Converter.this, convertedObjects, objects.get(i), option);
				converter.to(ClassHolder.newInstance(destClass));
			}

			Set<T> result = new HashSet<T>();
			for (Object object : this.objects) {
				result.add((T)convertedObjects.get(object));
			}
			
			return option.isImmutable() ? new ImmutableSet<T>(result) : result;
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
			
			IdentityHashMap<Object, Object> convertedObjects = new IdentityHashMap<Object, Object>();
			for (int i = 0; i < objects.size(); i++) {
				MirrorImpl converter = new MirrorImpl(Converter.this, convertedObjects, objects.get(i), option);
				converter.to(ClassHolder.newInstance(destClasses.get(i)));
			}
			
			return convertedObjects;
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
	
	private static <T> T convertBasicType(Class<T> objectClass, Object srcObject) {
		if (srcObject == null) {
			return defaultPrimitiveValue(objectClass);
		}
		if (srcObject.getClass() == objectClass) {
			return (T)srcObject;
		}
		
		Object result = null;

		if (srcObject instanceof String) {
			if (objectClass == String.class) {
				result = srcObject;
			}
		}
		else if (srcObject instanceof Character ) {
			if (objectClass == Character.class || objectClass == char.class) {
				result = srcObject;
			}
			else if (objectClass == int.class || objectClass == Integer.class) {
				result = (int)((Character)srcObject).charValue();
			}
			else if (objectClass == short.class || objectClass == Short.class) {
				result = (short)((Character)srcObject).charValue();
			}
			else if (objectClass == byte.class || objectClass == Byte.class) {
				result = (byte)((Character)srcObject).charValue();
			}
			else if (objectClass == long.class || objectClass == Long.class) {
				result = (long)((Character)srcObject).charValue();
			}
		}
		else if (srcObject instanceof Number) {
			Number n = (Number)srcObject;
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
				if (srcObject instanceof BigInteger) {
					result = srcObject;
				}
				else if (srcObject instanceof BigDecimal) {
					result = ((BigDecimal)srcObject).toBigInteger();
				}
				else {
					result = BigInteger.valueOf(n.longValue());
				}
			}
			else if (objectClass == BigDecimal.class) {
				if (srcObject instanceof BigDecimal) {
					result = srcObject;
				}
				else if (srcObject instanceof BigInteger) {
					result = new BigDecimal((BigInteger)srcObject);
				}
				else {
					result = BigDecimal.valueOf(n.doubleValue());
				}
			}
			
		}
		else if (srcObject instanceof Boolean) {
			if (objectClass == Boolean.class || objectClass == boolean.class ) {
				result = srcObject;
			}
		}
		else if (srcObject instanceof Date) {
			if (objectClass == Date.class) {
				result = new Date(((Date)srcObject).getTime());
			}
		}
		
		if (result == null) {
			result = defaultPrimitiveValue(objectClass);
		}
		
		return (T)result;
	}

	/**
	 * 
	 * The boolean flag is to tell if this new object is a complete object, so no need to populate the field
	 * 
	 * @param objectClass
	 * @param mirror
	 * @return
	 */
	protected <T> Pair<T, Boolean> instantiateDestObject(Class<T> destClass, Class<?> srcClass, Object srcObject, Mirror mirror) {
		
		if (destClass == null) {
			throw new NullPointerException();
		}
		
		if (srcClass == null) {
			throw new NullPointerException();
		}
		
		
		Constructor<?> constructor = ClassUtils.getConverterConstructor(destClass);

		if (constructor != null) {
			try {
				T result = (T)constructor.newInstance(mirror);
				
				return new Pair<T, Boolean>(result, Boolean.TRUE);
			} catch (RuntimeException e) {
				throw e;
			} catch (InvocationTargetException e) {
				Throwable t = e.getTargetException();
				if (t instanceof RuntimeException) {
					throw (RuntimeException)t;
				}
				throw new RuntimeException("Failed to instantiate " + destClass, t);
			} catch (Exception e) {
				throw new RuntimeException("Failed to instantiate " + destClass, e);
			}
		}

		try {
			T result = destClass.newInstance();
			return new Pair<T, Boolean>(result, Boolean.FALSE);
		} catch (Exception e) {
			e.printStackTrace();
			return new Pair<T, Boolean>(null, Boolean.TRUE);
		}
	}
	

	public final static class MirrorImpl implements Mirror {
		
		private final Map<Object, Object> convertedObjects;

		private final Object srcObject;
		
		private final ConverterOption option;
		
		private final Converter converter;
		
		private MirrorImpl(Converter converter, Object srcObject, ConverterOption option) {
			this(converter, new IdentityHashMap<Object, Object>(), srcObject, option);
		}
		
		private MirrorImpl(Converter converter, Map<Object, Object> convertedObjects, Object srcObject, ConverterOption option) {
			if (srcObject == null) {
				throw new NullPointerException();
			}
			
			this.converter = converter;
			this.srcObject = srcObject;
			this.convertedObjects = convertedObjects;
			this.option = option;
		}
		
		
		private static Collection<?> createMutableCollection(Class<?> c) {
			if (List.class.isAssignableFrom(c)) {
				
				return new ArrayList<Object>();
					
			}
			
			return new HashSet<Object>();
		}
		
		private Collection convertCollectionType(ClassHolder classHolder, Object srcObject) {
			Class<?> destClass = classHolder.getRawClass();
			if (Collection.class.isAssignableFrom(destClass) && srcObject instanceof Collection) {

				Class<?> subClass = classHolder.getArgumentClasses().size() > 0 ? classHolder.getArgumentClasses().get(0).getRawClass() : Object.class;
				
				Collection result = createMutableCollection(destClass);
				for (Object o : (Collection<?>)srcObject) {
					Object newValue = new MirrorImpl(this.converter, convertedObjects, o, option).to(ClassHolder.newInstance(subClass));
					result.add(newValue);
				}
				
				if (option.isImmutable()) {
					if (List.class.isAssignableFrom(result.getClass())) {
						return new ImmutableList<Object>(result);
					}
					else if (Set.class.isAssignableFrom(result.getClass())) {
						return new ImmutableSet<Object>(result);
					}
					else {
						return new ImmutableList<Object>(result);
					}
				}
				
				return result;
			}

			return null;
		}
		
		private Object to(ClassHolder classHolder) {

			Class<?> requestedClass = classHolder.getRawClass();

			if (SCALAR_TYPES.contains(srcObject.getClass()) || SCALAR_TYPES.contains(requestedClass)) {
				return convertBasicType(requestedClass, srcObject);
			}
			
			if (requestedClass.isEnum()	|| IMMUTABLE_TYPES.contains(requestedClass) ) {
				if (srcObject.getClass() == requestedClass) {
					return srcObject;
				}
				else {
					return null;
				}
			}
			
			if (this.convertedObjects.containsKey(this.srcObject)) {
				return this.convertedObjects.get(this.srcObject);
			}

			if (Collection.class.isAssignableFrom(requestedClass)) {
				if (ClassUtils.isCollectionType(srcObject.getClass())) {
					return convertCollectionType(classHolder, srcObject);
				}
				return null;
			}
			
			if (srcObject instanceof Convertable && ((Convertable) srcObject).convertableTo(requestedClass)) {
				return ((Convertable)srcObject).convertTo(requestedClass);
			}
			
			Class<?> destClass = this.option.findBestDestinationClass(srcObject.getClass(), requestedClass);
			
			Pair<?, Boolean> pair = this.converter.instantiateDestObject(destClass, srcObject.getClass(), srcObject, this);
			Object result = pair.getItem1();
			if (destClass.isPrimitive()) {
				return result == null ? defaultPrimitiveValue(destClass) : null;
			}
			this.convertedObjects.put(this.srcObject, result);

			if (pair.getItem2() == Boolean.FALSE) {
				for (Field field : getFields(srcObject.getClass())) {
					Field friendField = getField(destClass, field.getName());
					if (friendField == null)
						continue;

					field.setAccessible(true);
					friendField.setAccessible(true);

					
					if (SCALAR_TYPES.contains(field.getType())) {
						Object value = convertBasicType(friendField.getType(), getValue(field, srcObject));
						setValue(friendField, result, value);
					}
					else {
							
						Object value = getValue(field, srcObject);
						if (value != null) {
							Object newValue = new MirrorImpl(this.converter, this.convertedObjects, value, option).to(ClassHolder.newInstance(friendField.getGenericType()));
							setValue(friendField, result, newValue);
						}
					}
				}
				
			}
			return result;
		}
		
		@SuppressWarnings("unchecked")
		public <T> T to(Class<T> objectClass, String fieldName) {

			Object srcObject = toObject(fieldName);
			
			
			if (srcObject == null) {
				if (objectClass.isPrimitive()) {
					return defaultPrimitiveValue(objectClass);
				}
				else {
					return null;
				}
			}
			
			T destObject = (T)convertedObjects.get(srcObject);
			if (destObject == null) {
				MirrorImpl converter = new MirrorImpl(this.converter, convertedObjects, srcObject, option);
				destObject = (T)converter.to(ClassHolder.newInstance(objectClass));
			}
			
			return destObject;
		}
		
		private void verifyFieldExist(String fieldName, Field field) {
			if (field == null) {
				throw new IllegalArgumentException("Field " + fieldName + " does not exist for " + srcObject.getClass());
			}
		}
		
		public <T> List<T> toListOf(Class<T> objectClass, String fieldName) {
			Field field = getField(srcObject.getClass(), fieldName);
			verifyFieldExist(fieldName, field);
			
			Object value = getValue(field, srcObject);

			if (value == null) {
				return this.option.isImmutable() ? new ImmutableList<T>() : new ArrayList<T>();
			}
			
			return (List<T>)new MirrorImpl(this.converter, this.convertedObjects, value, option).to(ClassHolder.newInstance(List.class, objectClass));
		}

		public <T> Set<T> toSetOf(Class<T> objectClass, String fieldName) {
			Field field = getField(srcObject.getClass(), fieldName);
			verifyFieldExist(fieldName, field);
			
			Object value = getValue(field, srcObject);

			if (value == null) {
				return this.option.isImmutable() ? new ImmutableSet<T>() : new HashSet<T>();
			}
			
			return (Set<T>)new MirrorImpl(this.converter, this.convertedObjects, value, option).to(ClassHolder.newInstance(Set.class, objectClass));
			
		}
		
		public boolean exists(String fieldName) {
			return getField(srcObject.getClass(), fieldName) != null;
		}
		
		public Object toObject(String fieldName) {
			Field field = getField(srcObject.getClass(), fieldName);
			verifyFieldExist(fieldName, field);
			
			return getValue(field, srcObject);
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


		public void bind(Object object) {
			this.convertedObjects.put(srcObject, object);
		}

		
		
		
	}	

}

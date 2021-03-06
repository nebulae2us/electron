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
import java.math.*;
import java.util.*;
import java.util.Map.Entry;

import org.nebulae2us.electron.reflect.TypeHolder;
import org.nebulae2us.electron.internal.util.ClassUtils;
import org.nebulae2us.electron.util.IdentityEqualityComparator;
import org.nebulae2us.electron.util.ImmutableList;
import org.nebulae2us.electron.util.ImmutableMap;
import org.nebulae2us.electron.util.ImmutableSet;
import org.nebulae2us.electron.util.ImmutableSortedMap;
import org.nebulae2us.electron.util.ImmutableSortedSet;
import org.nebulae2us.electron.util.Immutables;
import org.nebulae2us.electron.util.MapBuilder;
import org.nebulae2us.electron.util.NaturalComparator;
import org.nebulae2us.electron.util.ObjectEqualityComparator;

import static org.nebulae2us.electron.internal.util.ClassUtils.*;

/**
 * @author Trung Phan
 *
 */
public class Converter {

	private boolean immutable;
	
	public boolean isImmutable() {
		return this.immutable;
	}
	
	public Converter() {
		this(null, false, Collections.EMPTY_LIST );
	}

	private final DestinationClassResolver destinationClassResolver;
	
	private final List<Class<?>> ignoredTypes;
	
	public Converter(DestinationClassResolver destinationClassResolver, boolean immutable, List<Class<?>> ignoredTypes) {
		this.destinationClassResolver = destinationClassResolver;
		this.immutable = immutable;
		this.ignoredTypes = Immutables.$(ignoredTypes);
	}
	
	public DestinationClassResolver getDestinationClassResolver() {
		return destinationClassResolver;
	}


	public class ConvertBuilder {
		private final Object object;
		
		public ConvertBuilder(Object object) {
			this.object = object;
		}
		
		public <T> T to(Class<T> destClass) {
			if (this.object == null) {
				return defaultValue(destClass);
			}
			
			return (T)new MirrorImpl(Converter.this, this.object, destinationClassResolver, immutable, ignoredTypes).to(TypeHolder.newInstance(destClass));
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
				MirrorImpl converter = new MirrorImpl(Converter.this, convertedObjects, objects.get(i), destinationClassResolver, immutable, ignoredTypes);
				converter.to(TypeHolder.newInstance(destClass));
			}

			List<T> result = new ArrayList<T>();
			for (Object object : this.objects) {
				result.add((T)convertedObjects.get(object));
			}
			
			if (immutable) {
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
				MirrorImpl converter = new MirrorImpl(Converter.this, convertedObjects, objects.get(i), destinationClassResolver, immutable, ignoredTypes);
				converter.to(TypeHolder.newInstance(destClass));
			}

			Set<T> result = new HashSet<T>();
			for (Object object : this.objects) {
				result.add((T)convertedObjects.get(object));
			}
			
			return immutable ? new ImmutableSet<T>(result) : result;
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
				MirrorImpl converter = new MirrorImpl(Converter.this, convertedObjects, objects.get(i), destinationClassResolver, immutable, ignoredTypes);
				converter.to(TypeHolder.newInstance(destClasses.get(i)));
			}
			
			return convertedObjects;
		}
	}
	
	public ConvertGroupBuilder convertGroup() {
		return new ConvertGroupBuilder();
	}

	public static <T> T defaultValue(Class<T> objectClass) {
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
	
	public static <T> T convertToBasicType(Class<T> destClass, Object srcObject) {
		if (srcObject == null) {
			return defaultValue(destClass);
		}
		if (destClass.isInstance(srcObject)) {
			return (T)srcObject;
		}
		
		Object result = null;

		if (srcObject instanceof String) {
			if (destClass == String.class) {
				result = srcObject;
			}
		}
		else if (srcObject instanceof Character ) {
			if (destClass == Character.class || destClass == char.class) {
				result = srcObject;
			}
			else if (destClass == int.class || destClass == Integer.class) {
				result = (int)((Character)srcObject).charValue();
			}
			else if (destClass == short.class || destClass == Short.class) {
				result = (short)((Character)srcObject).charValue();
			}
			else if (destClass == byte.class || destClass == Byte.class) {
				result = (byte)((Character)srcObject).charValue();
			}
			else if (destClass == long.class || destClass == Long.class) {
				result = (long)((Character)srcObject).charValue();
			}
		}
		else if (srcObject instanceof Number) {
			Number n = (Number)srcObject;
			if (destClass == char.class || destClass == Character.class) {
				result = (char)n.intValue();
			}
			else if (destClass == int.class || destClass == Integer.class) {
				result = n.intValue();
			}
			else if (destClass == short.class || destClass == Short.class) {
				result = n.shortValue();
			}
			else if (destClass == byte.class || destClass == Byte.class) {
				result = n.byteValue();
			}
			else if (destClass == long.class || destClass == Long.class) {
				result = n.longValue();
			}
			else if (destClass == double.class || destClass == Double.class) {
				result = n.doubleValue();
			}
			else if (destClass == float.class || destClass == Float.class) {
				result = n.floatValue();
			}
			else if (destClass == BigInteger.class) {
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
			else if (destClass == BigDecimal.class) {
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
			if (destClass == Boolean.class || destClass == boolean.class ) {
				result = srcObject;
			}
		}
		else if (srcObject instanceof Date) {
			if (destClass == Date.class) {
				result = new Date(((Date)srcObject).getTime());
			}
		}
		
		if (result == null) {
			result = defaultValue(destClass);
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
		else {
			constructor = ClassUtils.getDefaultConstructor(destClass);
			
			if (constructor != null) {
				try {
					T result = destClass.newInstance();
					return new Pair<T, Boolean>(result, Boolean.FALSE);
				} catch (Exception e) {
					// TODO show warning
					return new Pair<T, Boolean>(null, Boolean.TRUE);
				}
				
			}
			else if (destClass.isInstance(srcObject)) {
				return new Pair<T, Boolean>((T)srcObject, Boolean.TRUE);
			}
			else {
				return new Pair<T, Boolean>(null, Boolean.TRUE);
			}
			
		}

		
	}
	

	public final static class MirrorImpl implements Mirror {
		
		private final Map<Object, Object> convertedObjects;

		private final Object srcObject;
		
		private final Converter converter;
		
		private final boolean immutable;
		
		private final DestinationClassResolver destinationClassResolver;
		
		private final List<Class<?>> ignoredTypes;
		
		private MirrorImpl(Converter converter, Object srcObject, DestinationClassResolver destinationClassResolver, boolean immutable, List<Class<?>> ignoredTypes) {
			this(converter, new IdentityHashMap<Object, Object>(), srcObject, destinationClassResolver, immutable, ignoredTypes);
		}
		
		private MirrorImpl(Converter converter, Map<Object, Object> convertedObjects, Object srcObject, DestinationClassResolver destinationClassResolver, boolean immutable, List<Class<?>> ignoredTypes) {
			if (srcObject == null) {
				throw new NullPointerException();
			}
			
			this.converter = converter;
			this.srcObject = srcObject;
			this.convertedObjects = convertedObjects;
			this.destinationClassResolver = destinationClassResolver;
			this.immutable = immutable;
			this.ignoredTypes = Immutables.$(ignoredTypes);
		}
		
		
		private static Collection<?> createMutableCollection(Class<?> c) {
			if (List.class.isAssignableFrom(c)) {
				
				return new ArrayList<Object>();
					
			}
			
			return new HashSet<Object>();
		}
		
		private boolean isIgnored(Class<?> srcClass) {
			for (Class<?> c : ignoredTypes) {
				if (c.isAssignableFrom(srcClass)) {
					return true;
				}
			}
			return false;
		}
		
		private Object to(TypeHolder classHolder) {

			Class<?> srcClass = srcObject.getClass();
			Class<?> requestedClass = classHolder.getRawClass();
			
			if (SCALAR_TYPES.contains(srcClass) || SCALAR_TYPES.contains(requestedClass)) {
				return convertToBasicType(requestedClass, srcObject);
			}
			
			if (srcClass.isEnum() || IMMUTABLE_TYPES.contains(srcClass) || isIgnored(srcClass)) {
				return requestedClass.isAssignableFrom(srcClass) ? srcObject :
					requestedClass.isPrimitive() ? defaultValue(requestedClass) :
					null;
			}
			
			if (this.convertedObjects.containsKey(this.srcObject)) {
				return this.convertedObjects.get(this.srcObject);
			}
			
			if (Collection.class.isAssignableFrom(srcClass)) {
				Collection result = instantiateMutableCollection((Class<? extends Collection>)requestedClass, srcClass);
				if (result == null) {
					return null;
				}

				for (Object o : (Collection)srcObject) {
					Object newValue = new MirrorImpl(this.converter, convertedObjects, o, destinationClassResolver, immutable, ignoredTypes).to(
							classHolder.getTypeParams().size() > 0 ? classHolder.getTypeParams().get(0) : TypeHolder.newInstance(Object.class)
							);
					result.add(newValue);
				}

				if (immutable) {
					Class<?> expectedType = List.class;
					
					if (Collection.class.isAssignableFrom(requestedClass) && requestedClass != Collection.class) {
						expectedType = requestedClass;
					}
					else if (srcObject instanceof List) {
						expectedType = List.class;
					}
					else if (srcObject instanceof SortedSet) {
						expectedType = SortedSet.class;
					}
					else if (srcObject instanceof Set) {
						expectedType = Set.class;
					}
					result = Immutables.toImmutableCollection((Class<? extends Collection>)expectedType, result);
				}
				
				this.convertedObjects.put(srcObject, result);
				
				return result;
			}

			if (Map.class.isAssignableFrom(srcClass)) {
				Map result = instantiateMutableMap(requestedClass, srcClass);
				if (result == null) {
					return null;
				}
				
				for (Entry<?, ?> entry : ((Map<?, ?>)srcObject).entrySet()) {
					Object newKey = entry.getKey() == null ? null : new MirrorImpl(this.converter, convertedObjects, entry.getKey(), destinationClassResolver, immutable, ignoredTypes).to(
							classHolder.getTypeParams().size() > 1 ? classHolder.getTypeParams().get(0) : TypeHolder.newInstance(Object.class)
							);
					
					Object newValue = entry.getValue() == null ? null : new MirrorImpl(this.converter, convertedObjects, entry.getValue(), destinationClassResolver, immutable, ignoredTypes).to(
							classHolder.getTypeParams().size() > 0 ? classHolder.getTypeParams().get(1) : TypeHolder.newInstance(Object.class)
							);
					result.put(newKey, newValue);
				}

				if (immutable) {
					if (result instanceof IdentityHashMap) {
						result = new ImmutableMap(result, IdentityEqualityComparator.getInstance());
					}
					else {
						Class<? extends Map> expectedType = Map.class;
						if (Map.class.isAssignableFrom(requestedClass)) {
							expectedType = (Class<? extends Map>)requestedClass;
						}
						else if (srcObject instanceof SortedMap) {
							expectedType = SortedMap.class;
						}

						result = Immutables.toImmutableMap(expectedType, result);
					}
				}
				
				this.convertedObjects.put(srcObject, result);
				
				return result;
			}
			
			if (srcObject instanceof Wrappable && ((Wrappable)srcObject).getWrappedObject() != null ) {
				return ((Wrappable)srcObject).getWrappedObject();
			}
			
			Class<?> destClass = destinationClassResolver != null ? destinationClassResolver.getDestinationClass(srcClass, requestedClass) :
					requestedClass;

			Pair<?, Boolean> pair = this.converter.instantiateDestObject(destClass, srcClass, srcObject, this);
			Object result = pair.getItem1();
			if (destClass.isPrimitive()) {
				return result == null ? defaultValue(destClass) : null;
			}
			this.convertedObjects.put(this.srcObject, result);

			if (pair.getItem2() == Boolean.FALSE) {
				for (Field field : getFields(srcClass)) {
					Field friendField = getField(destClass, field.getName());
					if (friendField == null)
						continue;

					field.setAccessible(true);
					friendField.setAccessible(true);

					
					if (SCALAR_TYPES.contains(field.getType())) {
						Object value = convertToBasicType(friendField.getType(), getValue(field, srcObject));
						setValue(friendField, result, value);
					}
					else {
							
						Object value = getValue(field, srcObject);
						if (value != null) {
							Object newValue = new MirrorImpl(this.converter, this.convertedObjects, value, destinationClassResolver, immutable, ignoredTypes).to(TypeHolder.newInstance(friendField.getGenericType()));
							setValue(friendField, result, newValue);
						}
					}
				}
				
			}
			return result;
		}
		
		/**
		 * Try to instantiate mutable collection based on the requested returned type.
		 * If the returned type is so generic (such as Object.class or Collection.class),
		 * source class is considered to make result as close as source class.
		 * 
		 * @param requestedType
		 * @param srcClass
		 * @return
		 */
		private Collection instantiateMutableCollection(Class<?> requestedType, Class<?> srcClass) {
			Collection result = null;
			
			if (requestedType.isAssignableFrom(Collection.class)) {
				if (List.class.isAssignableFrom(srcClass)) {
					result = new ArrayList();
				}
				else if (SortedSet.class.isAssignableFrom(srcClass)) {
					result = new TreeSet();
				}
				else if (Set.class.isAssignableFrom(srcClass)) {
					result = new HashSet();
				}
				else {
					result = new ArrayList();
				}
			}
			else if (requestedType.isAssignableFrom(List.class) || requestedType.isAssignableFrom(ArrayList.class)) {
				result = new ArrayList();
			}
			else if (requestedType.isAssignableFrom(Set.class) || requestedType.isAssignableFrom(HashSet.class)) {
				result = new HashSet();
			}
			else if (requestedType.isAssignableFrom(NavigableSet.class) || requestedType.isAssignableFrom(TreeSet.class)) {
				result = new TreeSet();
			}
			else if (requestedType.isAssignableFrom(LinkedList.class)) {
				result = new LinkedList();
			}
			else if (requestedType.isAssignableFrom(LinkedHashSet.class)) {
				result = new LinkedHashSet();
			}
			else if (requestedType.isAssignableFrom(Vector.class)) {
				result = new Vector();
			}
			
			return result;
		}
		
		/**
		 * Try to instantiate mutable map based on the requested returned type.
		 * If the returned type is generic (such as Object.class or Map.class),
		 * source class is considered to make result as close as source class.
		 * 
		 * @param requestedClass
		 * @param srcClass
		 * @return
		 */
		private Map instantiateMutableMap(Class<?> requestedClass, Class<?> srcClass) {
			Map result = null;
			
			if (requestedClass.isAssignableFrom(Map.class)) {
				if (SortedMap.class.isAssignableFrom(srcClass)) {
					result = new TreeMap();
				}
				else if (IdentityHashMap.class.isAssignableFrom(srcClass)) {
					result = new IdentityHashMap();
				}
				else {
					result = new HashMap();
				}
			}
			else if (requestedClass.isAssignableFrom(NavigableMap.class) || requestedClass.isAssignableFrom(TreeMap.class)) {
				result = new TreeMap();
			}
			else if (requestedClass.isAssignableFrom(HashMap.class)) {
				result = new HashMap();
			}
			else if (requestedClass.isAssignableFrom(LinkedHashMap.class)) {
				result = new LinkedHashMap();
			}
			else if (requestedClass.isAssignableFrom(Hashtable.class)) {
				result = new Hashtable();
			}
			else if (requestedClass.isAssignableFrom(IdentityHashMap.class)) {
				result = new IdentityHashMap();
			}
			else if (requestedClass.isAssignableFrom(WeakHashMap.class)) {
				result = new WeakHashMap();
			}
			else if (requestedClass.isAssignableFrom(ImmutableMap.class)) {
				result = new HashMap();
			}
			else if (requestedClass.isAssignableFrom(ImmutableSortedMap.class)) {
				result = new TreeMap();
			}
			
			return result;
		}
		
		
		@SuppressWarnings("unchecked")
		public <T> T to(Class<T> objectClass, String fieldName) {

			Object srcObject = toObject(fieldName);
			
			
			if (srcObject == null) {
				if (objectClass.isPrimitive()) {
					return defaultValue(objectClass);
				}
				else {
					return null;
				}
			}
			
			T destObject = (T)convertedObjects.get(srcObject);
			if (destObject == null) {
				MirrorImpl converter = new MirrorImpl(this.converter, convertedObjects, srcObject, destinationClassResolver, immutable, ignoredTypes);
				destObject = (T)converter.to(TypeHolder.newInstance(objectClass));
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
				return immutable ? new ImmutableList<T>() : new ArrayList<T>();
			}
			
			List<T> result = (List<T>)new MirrorImpl(this.converter, this.convertedObjects, value, destinationClassResolver, immutable, ignoredTypes).to(TypeHolder.newInstance(List.class, objectClass));
			return result;
		}

		public <T> Set<T> toSetOf(Class<T> objectClass, String fieldName) {
			Field field = getField(srcObject.getClass(), fieldName);
			verifyFieldExist(fieldName, field);
			
			Object value = getValue(field, srcObject);

			if (value == null) {
				return immutable ? new ImmutableSet<T>() : new HashSet<T>();
			}
			
			return (Set<T>)new MirrorImpl(this.converter, this.convertedObjects, value, destinationClassResolver, immutable, ignoredTypes).to(TypeHolder.newInstance(Set.class, objectClass));
			
		}

		public <T> NavigableSet<T> toSortedSetOf(Class<T> destClass, String fieldName) {
			throw new UnsupportedOperationException();
		}
		
		public <K, V> Map<K, V> toMapOf(Class<K> keyClass, Class<V> valueClass, String fieldName) {
			Field field = getField(srcObject.getClass(), fieldName);
			verifyFieldExist(fieldName, field);
			
			Object value = getValue(field, srcObject);

			if (value == null) {
				return immutable ? new ImmutableMap<K, V>() : new HashMap<K, V>();
			}
			
			Map<K, V> result = (Map<K, V>)new MirrorImpl(this.converter, this.convertedObjects, value, destinationClassResolver, immutable, ignoredTypes).to(TypeHolder.newInstance(Map.class, keyClass, valueClass));
			return result;
		}

		public <K, V> Map<K, List<V>> toMultiValueMapOf(Class<K> keyClass, Class<V> valueClass, String fieldName) {
			Field field = getField(srcObject.getClass(), fieldName);
			verifyFieldExist(fieldName, field);
			
			Object value = getValue(field, srcObject);

			if (value == null) {
				return immutable ? new ImmutableMap<K, List<V>>() : new HashMap<K, List<V>>();
			}
			
			Map<K, List<V>> result = (Map<K, List<V>>)new MirrorImpl(this.converter, this.convertedObjects, value, destinationClassResolver, immutable, ignoredTypes).to(
					TypeHolder.newInstance(Map.class,
					TypeHolder.newInstance(keyClass),
					TypeHolder.newInstance(List.class, valueClass)));
			return result;
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
			return convertToBasicType(String.class, toObject(fieldName));
		}

		public Integer toInteger(String fieldName) {
			return convertToBasicType(Integer.class, toObject(fieldName));
		}
		
		public int toIntValue(String fieldName) {
			return convertToBasicType(int.class, toObject(fieldName));
		}

		public Long toLong(String fieldName) {
			return convertToBasicType(Long.class, toObject(fieldName));
		}
		
		public long toLongValue(String fieldName) {
			return convertToBasicType(long.class, toObject(fieldName));
		}

		public Short toShort(String fieldName) {
			return convertToBasicType(Short.class, toObject(fieldName));
		}
		
		public short toShortValue(String fieldName) {
			return convertToBasicType(short.class, toObject(fieldName));
		}

		public Byte toByte(String fieldName) {
			return convertToBasicType(Byte.class, toObject(fieldName));
		}
		
		public byte toByteValue(String fieldName) {
			return convertToBasicType(byte.class, toObject(fieldName));
		}

		public Double toDouble(String fieldName) {
			return convertToBasicType(Double.class, toObject(fieldName));
		}
		
		public double toDoubleValue(String fieldName) {
			return convertToBasicType(double.class, toObject(fieldName));
		}

		public Float toFloat(String fieldName) {
			return convertToBasicType(Float.class, toObject(fieldName));
		}
		
		public float toFloatValue(String fieldName) {
			return convertToBasicType(float.class, toObject(fieldName));
		}

		public Boolean toBoolean(String fieldName) {
			return convertToBasicType(Boolean.class, toObject(fieldName));
		}
		
		public boolean toBooleanValue(String fieldName) {
			return convertToBasicType(boolean.class, toObject(fieldName));
		}

		public Character toCharacter(String fieldName) {
			return convertToBasicType(Character.class, toObject(fieldName));
		}
		
		public char toCharValue(String fieldName) {
			return convertToBasicType(char.class, toObject(fieldName));
		}


		public void bind(Object object) {
			this.convertedObjects.put(srcObject, object);
		}



		
		
		
	}	

}

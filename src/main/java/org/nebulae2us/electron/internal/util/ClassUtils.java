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
package org.nebulae2us.electron.internal.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.nebulae2us.electron.Mirror;

/**
 * @author Trung Phan
 *
 */
public class ClassUtils {
	
	private static int getLevelOfInheritance(Class<?> c) {
		if (c.getSuperclass() == null) {
			return 1;
		}
		return 1 + getLevelOfInheritance(c.getSuperclass());
	}
	
	public static List<Class<?>> sortClassesByLevelOfInheritance(Collection<Class<?>> classes) {
		List<Class<?>> result = new ArrayList<Class<?>>(classes);
		Collections.sort(result, new Comparator<Class<?>>() {
			public int compare(Class<?> c1, Class<?> c2) {
				int l1 = getLevelOfInheritance(c1);
				int l2 = getLevelOfInheritance(c2);
				
				if (l1 < l2) {
					return -1;
				}
				else if (l1 > l2) {
					return 1;
				}
				else {
					return c1.getName().compareTo(c2.getName());
				}
			}
		});
		
		return result;
	}
	
	public static List<Field> getFields(Class<?> c) {
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
	
	public static Field getField(Class<?> c, String fieldName) {
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
	
	public static Object getValue(Field field, Object object) {
		try {
			field.setAccessible(true);
			return field.get(object);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static void setValue(Field field, Object object, Object value) {
		field.setAccessible(true);

		try {
			field.set(object, value);
		} catch (Exception e) {}
		
	}

	public static <T> T instantiate(Class<T> objectClass) {
		try {
			T result = objectClass.newInstance();
			return result;
		} catch (Exception e) {
			return null;
		}
	}
	
	public static Class<?> getClass(Type type) {
		if (type instanceof Class) {
			return (Class<?>)type;
		}
		
		if (type instanceof ParameterizedType) {
			ParameterizedType paramType = (ParameterizedType)type;
			return getClass(paramType.getRawType());
		}
		else if (type instanceof WildcardType) {
			WildcardType wildcardType = (WildcardType)type;
			if (wildcardType.getLowerBounds() != null && wildcardType.getLowerBounds().length > 0) {
				return getClass(wildcardType.getLowerBounds()[0]);
			}
			
			if (wildcardType.getUpperBounds() != null && wildcardType.getUpperBounds().length > 0) {
				return getClass(wildcardType.getUpperBounds()[0]);
			}
		}

		return null;
	}
	
	public static Type getGenericSubType(Type type) {
		if (type instanceof ParameterizedType) {
			ParameterizedType paramType = (ParameterizedType)type;
			Type[] subTypes = paramType.getActualTypeArguments();
			return subTypes.length > 0 ? subTypes[0] : null;
		}
		return null;
	}
	
	public static boolean isCollectionType(Type type) {
		
		Class<?> c = getClass(type);
		return c != null && Collection.class.isAssignableFrom(c);
	}

	public static Constructor<?> getConverterConstructor(Class<?> destClass) {
		Constructor<?> constructor = null;
		try {
			constructor = destClass.getConstructor(Mirror.class);
			return constructor;
		} catch (Exception e) {
			return null;
		}
		
	}

	public static Constructor<?> getDefaultConstructor(Class<?> destClass) {
		Constructor<?> constructor = null;
		try {
			constructor = destClass.getConstructor();
			return constructor;
		} catch (Exception e) {
			return null;
		}
		
	}

}

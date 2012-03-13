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
import java.util.List;
import java.util.WeakHashMap;

/**
 * @author Trung Phan
 *
 */
public class Converter {

	private final WeakHashMap<Object, Object> builders;
	
	private final Object builder;
	
	public Converter(Object builder) {
		this.builder = builder;
		this.builders = new WeakHashMap<Object, Object>();
	}
	
	private Converter(WeakHashMap<Object, Object> builders, Object builder) {
		this.builder = builder;
		this.builders = builders;
	}
	
	public static <T> T convert(Class<T> objectClass, Object builder) {
		
		Converter converter = new Converter(builder);
		Constructor<T> constructor = null;
		try {
			constructor = objectClass.getConstructor(Converter.class);
		} catch (Exception e) {}
		
		if (constructor != null) {
			try {
				return constructor.newInstance(converter);
			} catch (Exception e) {
				throw new RuntimeException("Failed to instantiate " + objectClass);
			}
		}
		else {
			try {
				T result = objectClass.newInstance();
				return result;
			} catch (Exception e) {
				throw new RuntimeException("Failed to instantiate " + objectClass);
			}
		}
	}
	
	public <T> T to(Class<T> objectClass) {
		return null;
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
		return null;
	}
	
	public Object getValue(String fieldName) {
		try {
			Field field = builder.getClass().getDeclaredField(fieldName);
			field.setAccessible(true);
			
			Object result = field.get(builder);
			
			return result;
			
		} catch (Exception e) {
			throw new RuntimeException("The field does not exist: " + fieldName);
		}
	}

	public String getString(String fieldName) {
		return (String)getValue(fieldName);
	}

	public Integer getInteger(String fieldName) {
		Number n = ((Number)getValue(fieldName));
		return n == null ? null : n.intValue();
	}
	
	public int intValue(String fieldName) {
		Number n = ((Number)getValue(fieldName));
		return n == null ? 0 : n.intValue();
	}

	public Long getLong(String fieldName) {
		Number n = ((Number)getValue(fieldName));
		return n == null ? null : n.longValue();
	}
	
	public long longValue(String fieldName) {
		Number n = ((Number)getValue(fieldName));
		return n == null ? 0L : n.longValue();
	}

	public Short getShort(String fieldName) {
		Number n = ((Number)getValue(fieldName));
		return n == null ? null : n.shortValue();
	}
	
	public short shortValue(String fieldName) {
		Number n = ((Number)getValue(fieldName));
		return n == null ? 0 : n.shortValue();
	}

	public Byte getByte(String fieldName) {
		Number n = ((Number)getValue(fieldName));
		return n == null ? null : n.byteValue();
	}
	
	public byte byteValue(String fieldName) {
		Number n = ((Number)getValue(fieldName));
		return n == null ? 0 : n.byteValue();
	}

	public Double getDouble(String fieldName) {
		Number n = ((Number)getValue(fieldName));
		return n == null ? null : n.doubleValue();
	}
	
	public double doubleValue(String fieldName) {
		Number n = ((Number)getValue(fieldName));
		return n == null ? 0 : n.doubleValue();
	}

	public Float getFloat(String fieldName) {
		Number n = ((Number)getValue(fieldName));
		return n == null ? null : n.floatValue();
	}
	
	public float floatValue(String fieldName) {
		Number n = ((Number)getValue(fieldName));
		return n == null ? 0 : n.floatValue();
	}

	public Boolean getBoolean(String fieldName) {
		return (Boolean)getValue(fieldName);
	}
	
	public boolean booleanValue(String fieldName) {
		Boolean b = (Boolean)getValue(fieldName);
		return b == null ? false : b.booleanValue();
	}

	public Character getCharacter(String fieldName) {
		return (Character)getValue(fieldName);
	}
	
	public char charValue(String fieldName) {
		Character c = (Character)getValue(fieldName);
		return c == null ? 0 : c.charValue();
	}


	public void register(Object object) {
		this.builders.put(builder, object);
	}
	
	
	
}

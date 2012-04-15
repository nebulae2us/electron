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

import java.lang.reflect.Field;

/**
 * @author Trung Phan
 *
 */
public class WrapHelper {

	public static Object getValue(Object target, Class<?> type, String fieldName) {
		try {
			Field field = type.getDeclaredField(fieldName);
			field.setAccessible(true);
			return field.get(target);
		} catch (Exception e) {
			throw new IllegalStateException("Cannot get value from field " + fieldName);
		}
	}
	
	public static boolean valueNotSet(Object target, Class<?> type) {
		if (target == null) {
			return true;
		}
		
		if (type.isPrimitive()) {
			return target == Boolean.FALSE ||
					target == Integer.valueOf(0) ||
					target == Long.valueOf(0L) ||
					target == Short.valueOf((short)0) ||
					target == Byte.valueOf((byte)0) ||
					target == Double.valueOf(0.0) ||
					target == Float.valueOf(0.0f) ||
					target == Character.valueOf((char)0);
					
		}
		
		return false;
	}
	
}

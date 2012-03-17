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

import java.util.IdentityHashMap;
import java.util.Map;

/**
 * @author Trung Phan
 *
 */
public class ConverterOption {

	private final Map<Class<?>, Class<?>> associates = new IdentityHashMap<Class<?>, Class<?>>();
	
	
	public ConverterOption associate(Class<?> class1, Class<?> class2) {
		if (class1 == null || class2 == null) {
			throw new NullPointerException();
		}

		assertClassInstantiatable(class1);
		assertClassInstantiatable(class2);
		
		associates.put(class1, class2);
		associates.put(class2, class1);
		
		return this;
	}
	
	private void assertClassInstantiatable(Class<?> c) {
	}

	@SuppressWarnings("unchecked")
	public <T> Class<T> findBestDestinationClass(Class<?> src, Class<T> dest) {
		
		Class<?> c = src;
		while (c != null && c != Object.class) {
			Class<?> candidateDest = associates.get(c);
			if (candidateDest != null && dest.isAssignableFrom(candidateDest)) {
				return (Class<T>)candidateDest;
			}
			c = c.getSuperclass();
		}
		
		return dest;
		
	}
	
	
}

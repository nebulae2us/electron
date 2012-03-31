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

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.nebulae2us.electron.util.IdentityEqualityComparator;
import org.nebulae2us.electron.util.ImmutableMap;

/**
 * @author Trung Phan
 *
 */
public class ConverterOption {

	//TODO change the structure to support the override concept, i.e. latter option will override earlier options
	
	private final Map<Class<?>, Class<?>> associates;
	private final Map<Class<?>, Class<?>> inverseAssociates;

	/**
	 * Immutable flag determines what Collection is used (ImmutableList vs ArrayList)
	 */
//	private final boolean immutable;
	
	@SuppressWarnings("unchecked")
	public ConverterOption() {
		this(Collections.EMPTY_MAP);
	}
	
	public ConverterOption(Map<Class<?>, Class<?>> associates) {
		this.associates = new ImmutableMap<Class<?>, Class<?>>(associates, new IdentityEqualityComparator<Class<?>>());
		
		Map<Class<?>, Class<?>> inverseAssociates = new IdentityHashMap<Class<?>, Class<?>>();
		for (Entry<Class<?>, Class<?>> entry : associates.entrySet()) {
			inverseAssociates.put(entry.getValue(), entry.getKey());
		}
		this.inverseAssociates = new ImmutableMap<Class<?>, Class<?>>(inverseAssociates, new IdentityEqualityComparator<Class<?>>());
	}

	public Map<Class<?>, Class<?>> getAssociates() {
		return associates;
	}

	public ConverterOption merge(ConverterOption otherOption) {

		Map<Class<?>, Class<?>> associates;
		if (this.associates.size() == 0) {
			associates = otherOption.associates;
		}
		else if (otherOption.associates.size() == 0) {
			associates = this.associates;
		}
		else {
			associates = new IdentityHashMap<Class<?>, Class<?>>(this.associates);
			associates.putAll(otherOption.associates);
		}
		return new ConverterOption(associates);
	}

	private void assertClassInstantiatable(Class<?> c) {
	}

	@SuppressWarnings("unchecked")
	public <T> Class<T> findBestDestinationClass(Class<?> src, Class<T> dest) {
		
		Class<?> c = src;
		while (c != null && c != Object.class) {
			Class<?> candidateDest = associates.get(c);
			if (candidateDest == null) {
				candidateDest = inverseAssociates.get(c);
			}
			
			if (candidateDest != null && dest.isAssignableFrom(candidateDest)) {
				return (Class<T>)candidateDest;
			}
			c = c.getSuperclass();
		}
		
		return dest;
		
	}
	
	
}

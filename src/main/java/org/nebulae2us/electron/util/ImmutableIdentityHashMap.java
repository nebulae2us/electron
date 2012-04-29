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
package org.nebulae2us.electron.util;

import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Trung Phan
 *
 */
public final class ImmutableIdentityHashMap<K, V> extends IdentityHashMap<K, V> {

	private static final long serialVersionUID = 1593227809905738117L;
	
	private final ImmutableMap<K, V> data;
	
	public ImmutableIdentityHashMap(Map<? extends K, ? extends V> m) {
		this.data = new ImmutableMap<K, V>(m, IdentityEqualityComparator.getInstance());
	}
	
	@Override
	public void clear() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object clone() {
		return super.clone();
	}

	@Override
	public boolean containsKey(Object key) {
		return data.containsKey(key);
	}

	@Override
	public boolean containsValue(Object o) {
		return data.containsValue(o);
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		return data.entrySet();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o instanceof ImmutableIdentityHashMap) {
			return data.equals(((ImmutableIdentityHashMap<?, ?>)o).data);
		}
		return data.equals(o);
	}

	@Override
	public V get(Object key) {
		return data.get(key);
	}

	@Override
	public int hashCode() {
		return data.hashCode();
	}

	@Override
	public boolean isEmpty() {
		return data.isEmpty();
	}

	@Override
	public Set<K> keySet() {
		return data.keySet();
	}

	@Override
	public V put(K key, V value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		throw new UnsupportedOperationException();
	}

	@Override
	public V remove(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int size() {
		return data.size();
	}

	@Override
	public Collection<V> values() {
		return data.values();
	}

	@Override
	public String toString() {
		return data.toString();
	}

}

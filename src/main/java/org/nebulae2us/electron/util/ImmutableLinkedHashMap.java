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
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author Trung Phan
 *
 */
public final class ImmutableLinkedHashMap<K, V> extends LinkedHashMap<K, V> implements ImmutableMapAware<K, V> {

	private static final long serialVersionUID = 8070724328849837500L;
	
	private final ImmutableMap<K, V> data;

	public ImmutableLinkedHashMap(Map<? extends K, ? extends V> m) {
		this.data = new ImmutableMap<K, V>(m, ObjectEqualityComparator.getInstance());
	}
	
	@Override
	public void clear() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean containsValue(Object value) {
		return data.containsValue(value);
	}

	@Override
	public V get(Object key) {
		return data.get(key);
	}

	@Override
	public boolean containsKey(Object key) {
		return data.containsKey(key);
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		return data.entrySet();
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
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (o instanceof ImmutableLinkedHashMap) {
			return this.data.equals(((ImmutableLinkedHashMap<?, ?>)o).data);
		}
		return this.data.equals(o);
	}

	@Override
	public int hashCode() {
		return data.hashCode();
	}

	@Override
	public String toString() {
		return data.toString();
	}

	public ImmutableMap<K, V> getImmutableMap() {
		return data;
	}

	

}

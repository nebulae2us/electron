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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author Trung Phan
 *
 */
public final class ImmutableHashMap<K, V> extends HashMap<K, V> {

	private static final long serialVersionUID = 1089435676026499050L;
	
	private final ImmutableSet<Entry<K, V>> entrySet;

	private final ImmutableSet<K> keySet = new ImmutableSet<K>(super.keySet());
	
	private final ImmutableList<V> values = new ImmutableList<V>(this.values());

	public ImmutableHashMap(Map<? extends K, ? extends V> m) {
		super(m);
		List<Entry<K, V>> entries = new ArrayList<Entry<K, V>>();
		
		for (Entry<K, V> entry : this.entrySet()) {
			entries.add(new ImmutableEntry<K, V>(entry));
		}
		
		entrySet = new ImmutableSet<Entry<K, V>>(entries);
	}
	
	@Override
	public void clear() {
		throw new UnsupportedOperationException();
	}

	@Override
	public ImmutableSet<Entry<K, V>> entrySet() {
		return entrySet;
	}

	@Override
	public ImmutableSet<K> keySet() {
		return keySet;
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
	public V remove(Object key) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ImmutableList<V> values() {
		return values;
	}

}

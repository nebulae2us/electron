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
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author Trung Phan
 *
 */
public class ImmutableTreeMap<K, V> extends TreeMap<K, V> {

	private static final long serialVersionUID = 2565430344565812032L;

	private final ImmutableSortedMap<K, V> data;

	public ImmutableTreeMap(SortedMap<K, V> m) {
		this.data = new ImmutableSortedMap<K, V>(m);
	}
	
	@Override
	public NavigableSet<K> keySet() {
		return data.keySet();
	}

	@Override
	public Entry<K, V> ceilingEntry(K key) {
		return data.ceilingEntry(key);
	}

	@Override
	public K ceilingKey(K key) {
		return data.ceilingKey(key);
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException();
	}

	@Override
	public NavigableSet<K> descendingKeySet() {
		return data.descendingKeySet();
	}

	@Override
	public NavigableMap<K, V> descendingMap() {
		return data.descendingMap();
	}

	@Override
	public ImmutableSortedSet<Entry<K, V>> entrySet() {
		return data.entrySet();
	}

	@Override
	public Entry<K, V> firstEntry() {
		return data.firstEntry();
	}

	@Override
	public Entry<K, V> floorEntry(K key) {
		return data.floorEntry(key);
	}

	@Override
	public NavigableMap<K, V> headMap(K toKey, boolean inclusive) {
		return data.headMap(toKey, inclusive);
	}

	@Override
	public SortedMap<K, V> headMap(K key) {
		return data.headMap(key);
	}

	@Override
	public Entry<K, V> higherEntry(K key) {
		return data.higherEntry(key);
	}

	@Override
	public Entry<K, V> lastEntry() {
		return data.lastEntry();
	}

	@Override
	public Entry<K, V> lowerEntry(K key) {
		return data.lowerEntry(key);
	}

	@Override
	public NavigableSet<K> navigableKeySet() {
		return data.navigableKeySet();
	}

	@Override
	public Entry<K, V> pollFirstEntry() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Entry<K, V> pollLastEntry() {
		throw new UnsupportedOperationException();
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
	public NavigableMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive) {
		return data.subMap(fromKey, fromInclusive, toKey, toInclusive);
	}

	@Override
	public SortedMap<K, V> subMap(K fromKey, K toKey) {
		return data.subMap(fromKey, toKey);
	}

	@Override
	public NavigableMap<K, V> tailMap(K fromKey, boolean inclusive) {
		return data.tailMap(fromKey, inclusive);
	}

	@Override
	public SortedMap<K, V> tailMap(K fromKey) {
		return data.tailMap(fromKey);
	}

	@Override
	public Collection<V> values() {
		return data.values();
	}

}

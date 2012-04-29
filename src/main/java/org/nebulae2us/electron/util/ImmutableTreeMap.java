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
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author Trung Phan
 *
 */
public final class ImmutableTreeMap<K, V> extends TreeMap<K, V> {

	private static final long serialVersionUID = 2565430344565812032L;

	private final ImmutableSortedMap<K, V> data;
	
	public ImmutableTreeMap(Map<? extends K, ? extends V> m) {
		this.data = new ImmutableSortedMap<K, V>(m, NaturalComparator.getInstance());
	}
	
	public ImmutableTreeMap(Map<? extends K, ? extends V> m, Comparator<? super K> comparator) {
		this.data = new ImmutableSortedMap<K, V>(m, comparator);
	}

	public ImmutableTreeMap(SortedMap<? extends K, ? extends V> m) {
		this.data = new ImmutableSortedMap<K, V>(m);
	}

	@Override
	public int size() {
		return data.size();
	}

	@Override
	public boolean containsKey(Object key) {
		return data.containsKey(key);
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
	public Comparator<? super K> comparator() {
		return data.comparator();
	}

	@Override
	public K firstKey() {
		return data.firstKey();
	}

	@Override
	public K lastKey() {
		return data.lastKey();
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> map) {
		throw new UnsupportedOperationException();
	}

	@Override
	public V put(K key, V value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public V remove(Object key) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException();
	}

	@Override
	public java.util.Map.Entry<K, V> firstEntry() {
		return data.firstEntry();
	}

	@Override
	public java.util.Map.Entry<K, V> lastEntry() {
		return data.lastEntry();
	}

	@Override
	public java.util.Map.Entry<K, V> pollFirstEntry() {
		throw new UnsupportedOperationException();
	}

	@Override
	public java.util.Map.Entry<K, V> pollLastEntry() {
		throw new UnsupportedOperationException();
	}

	@Override
	public java.util.Map.Entry<K, V> lowerEntry(K key) {
		return data.lowerEntry(key);
	}

	@Override
	public K lowerKey(K key) {
		return data.lowerKey(key);
	}

	@Override
	public java.util.Map.Entry<K, V> floorEntry(K key) {
		return data.floorEntry(key);
	}

	@Override
	public K floorKey(K key) {
		return data.floorKey(key);
	}

	@Override
	public java.util.Map.Entry<K, V> ceilingEntry(K key) {
		return data.ceilingEntry(key);
	}

	@Override
	public K ceilingKey(K key) {
		return data.ceilingKey(key);
	}

	@Override
	public java.util.Map.Entry<K, V> higherEntry(K key) {
		return data.higherEntry(key);
	}

	@Override
	public K higherKey(K key) {
		return data.higherKey(key);
	}

	@Override
	public Set<K> keySet() {
		return data.keySet();
	}

	@Override
	public NavigableSet<K> navigableKeySet() {
		return data.navigableKeySet();
	}

	@Override
	public NavigableSet<K> descendingKeySet() {
		return data.descendingKeySet();
	}

	@Override
	public Collection<V> values() {
		return data.values();
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		return data.entrySet();
	}

	@Override
	public NavigableMap<K, V> descendingMap() {
		return data.descendingMap();
	}

	@Override
	public NavigableMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey,
			boolean toInclusive) {
		return data.subMap(fromKey, fromInclusive, toKey, toInclusive);
	}

	@Override
	public NavigableMap<K, V> headMap(K toKey, boolean inclusive) {
		return data.headMap(toKey, inclusive);
	}

	@Override
	public NavigableMap<K, V> tailMap(K fromKey, boolean inclusive) {
		return data.tailMap(fromKey);
	}

	@Override
	public SortedMap<K, V> subMap(K fromKey, K toKey) {
		return data.subMap(fromKey, toKey);
	}

	@Override
	public SortedMap<K, V> headMap(K toKey) {
		return data.headMap(toKey);
	}

	@Override
	public SortedMap<K, V> tailMap(K fromKey) {
		return data.tailMap(fromKey);
	}

	@Override
	public boolean isEmpty() {
		return data.isEmpty();
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (o instanceof ImmutableTreeMap) {
			return this.data.equals(((ImmutableTreeMap)o).data);
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


}

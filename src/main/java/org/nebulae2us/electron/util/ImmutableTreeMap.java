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
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author Trung Phan
 *
 */
public class ImmutableTreeMap<K, V> extends TreeMap<K, V> {

	private static final long serialVersionUID = 2565430344565812032L;
	
	private final ImmutableSortedSet<K> keySet;

	public ImmutableTreeMap(SortedMap<K, V> m) {
		super(m);
		
		Comparator<? super K> comparator = this.comparator();
		if (comparator == null) {
			comparator = NaturalComparator.getInstance();
		}
		
		this.keySet = new ImmutableSortedSet<K>(navigableKeySet());
	}
	
	@Override
	public ImmutableSortedSet<K> keySet() {
		return keySet;
	}

	@Override
	public Entry<K, V> ceilingEntry(K arg0) {
		// TODO Auto-generated method stub
		return super.ceilingEntry(arg0);
	}

	@Override
	public K ceilingKey(K arg0) {
		// TODO Auto-generated method stub
		return super.ceilingKey(arg0);
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException();
	}

	@Override
	public ImmutableSortedSet<K> descendingKeySet() {
		return keySet.descendingSet();
	}

	@Override
	public NavigableMap<K, V> descendingMap() {
		// TODO Auto-generated method stub
		return super.descendingMap();
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return super.entrySet();
	}

	@Override
	public Entry<K, V> firstEntry() {
		// TODO Auto-generated method stub
		return super.firstEntry();
	}

	@Override
	public Entry<K, V> floorEntry(K arg0) {
		// TODO Auto-generated method stub
		return super.floorEntry(arg0);
	}

	@Override
	public NavigableMap<K, V> headMap(K arg0, boolean arg1) {
		// TODO Auto-generated method stub
		return super.headMap(arg0, arg1);
	}

	@Override
	public SortedMap<K, V> headMap(K arg0) {
		// TODO Auto-generated method stub
		return super.headMap(arg0);
	}

	@Override
	public Entry<K, V> higherEntry(K arg0) {
		// TODO Auto-generated method stub
		return super.higherEntry(arg0);
	}

	@Override
	public Entry<K, V> lastEntry() {
		// TODO Auto-generated method stub
		return super.lastEntry();
	}

	@Override
	public Entry<K, V> lowerEntry(K arg0) {
		// TODO Auto-generated method stub
		return super.lowerEntry(arg0);
	}

	@Override
	public NavigableSet<K> navigableKeySet() {
		return keySet;
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
	public NavigableMap<K, V> subMap(K arg0, boolean arg1, K arg2, boolean arg3) {
		// TODO Auto-generated method stub
		return super.subMap(arg0, arg1, arg2, arg3);
	}

	@Override
	public SortedMap<K, V> subMap(K arg0, K arg1) {
		// TODO Auto-generated method stub
		return super.subMap(arg0, arg1);
	}

	@Override
	public NavigableMap<K, V> tailMap(K arg0, boolean arg1) {
		// TODO Auto-generated method stub
		return super.tailMap(arg0, arg1);
	}

	@Override
	public SortedMap<K, V> tailMap(K arg0) {
		// TODO Auto-generated method stub
		return super.tailMap(arg0);
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return super.values();
	}

}

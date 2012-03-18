/*
 * Copyright 2011 the original author or authors.
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

import java.util.*;

/**
 * @author Trung Phan
 */
public class ImmutableSortedMap<K, V> extends AbstractImmutableMap<K, V> implements NavigableMap<K, V> {

    private final List<InternalEntry>  data;

    private final ImmutableSortedUniqueList<K> keys;

    public ImmutableSortedMap(Map<K, V> data, Comparator<? super K> comparator) {
        keys = new ImmutableSortedUniqueList<K>(data.keySet(), comparator);

        ArrayList<InternalEntry> _data = new ArrayList<ImmutableSortedMap<K,V>.InternalEntry>(keys.size());
        
        for (Entry<K, V> entry : data.entrySet()) {
            InternalEntry newEntry = new InternalEntry(entry.getKey(), entry.getValue());
            _data.set(keys.indexOf(entry.getKey()), newEntry);
        }
        
        this.data = new ImmutableList<ImmutableSortedMap<K,V>.InternalEntry>(_data);
    }

    public ImmutableSortedMap(SortedMap<K, V> map) {
        this(map, map.comparator());
    }

    public ImmutableSortedMap(ImmutableSortedMap<K, V> cloned, boolean descending) {
        this.data = cloned.data;
        this.keys = descending ? cloned.keys.descendingList() : cloned.keys;
    }

    public Entry<K, V> lowerEntry(K key) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public K lowerKey(K key) {
        return keys.lower(key);
    }

    public Entry<K, V> floorEntry(K key) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public K floorKey(K key) {
        return keys.floor(key);
    }

    public Entry<K, V> ceilingEntry(K key) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public K ceilingKey(K key) {
        return keys.ceiling(key);
    }

    public Entry<K, V> higherEntry(K key) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public K higherKey(K key) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Entry<K, V> firstEntry() {
        return data.size() == 0 ? null : data.get(0);
    }

    public Entry<K, V> lastEntry() {
        return data.size() == 0 ? null : data.get(keys.size() - 1);
    }

    public final Entry<K, V> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    public final Entry<K, V> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    public NavigableMap<K, V> descendingMap() {
    	return new ImmutableSortedMap<K, V>(this, true);
    }

    public NavigableSet<K> navigableKeySet() {
        return keys;
    }

    public NavigableSet<K> descendingKeySet() {
        return keys.descendingSet();
    }

    public NavigableMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public NavigableMap<K, V> headMap(K toKey, boolean inclusive) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public NavigableMap<K, V> tailMap(K fromKey, boolean inclusive) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Comparator<? super K> comparator() {
        return keys.comparator();
    }

    public SortedMap<K, V> subMap(K fromKey, K toKey) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public SortedMap<K, V> headMap(K toKey) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public SortedMap<K, V> tailMap(K fromKey) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public K firstKey() {
        return keys.get(0);
    }

    public K lastKey() {
        return keys.get(keys.size() - 1);
    }

    public int size() {
        return keys.size();
    }

    public boolean isEmpty() {
        return keys.isEmpty();
    }

    public boolean containsKey(Object key) {
        return keys.contains(key);
    }

    public boolean containsValue(Object value) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public V get(Object key) {
//        int i = Collections.binarySearch(keys, (K)key, comparator);
//        return i >= 0 ? this.data[i].getValue() : null;
        return null;
    }

    public Set<K> keySet() {
        return keys;
    }

    public Collection<V> values() {
        return new ValueCollection();
    }

    public Set<Entry<K, V>> entrySet() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    private class InternalEntry implements Entry<K, V> {

        private final K key;

        private final V value;

        private InternalEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V value) {
            throw new UnsupportedOperationException();
        }
    }

    private class ValueCollection extends AbstractImmutableCollection<V> implements Collection<V> {

        public int size() {
            return keys.size();
        }

        public boolean isEmpty() {
            return keys.isEmpty();
        }

        public boolean contains(Object o) {
            return false;  //To change body of implemented methods use File | Settings | File Templates.
        }

        public Iterator<V> iterator() {
            return new ValueIterator();
        }
    }

    private class EntryIterator implements Iterator<Entry<K, V>> {

        private int index;

        private EntryIterator(int index) {
            this.index = index;
        }

        public boolean hasNext() {
            return this.index < keys.size();
        }

        public Entry<K, V> next() {
            return data.get(this.index ++);
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class ValueIterator implements Iterator<V> {

        private final EntryIterator entryIterator = new EntryIterator(0);

        public boolean hasNext() {
            return entryIterator.hasNext();
        }

        public V next() {
            return entryIterator.next().getValue();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}

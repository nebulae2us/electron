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
public class ImmutableMap<K, V> extends AbstractImmutableMap<K, V> implements Map<K, V> {

    private final int size;

    private final List<InternalEntry>[] data;

    private final EqualityComparator<Object> equalityComparator;

    public ImmutableMap(Map<? extends K, ? extends V> m, EqualityComparator<K> equalityComparator) {

        int capacity = 1;
        while (capacity < m.size())
            capacity <<= 1;
    	
        this.equalityComparator = (EqualityComparator<Object>)equalityComparator;

        int calcSize = 0;
        data = new List[capacity];
        
        
        for (Map.Entry<? extends K, ? extends V> e : m.entrySet()) {
        	
            int h = equalityComparator.hashCode(e.getKey());
            int i = indexFor(h);
            List<InternalEntry> list = data[i];
            if (list == null) {
                list = new ArrayList<InternalEntry>();
                data[i] = list;
            }

            boolean contains = false;
            for (InternalEntry entry : list) {
                if (equalityComparator.equal(entry.getKey(), e.getKey())) {
                    contains = true;
                    break;
                }
            }
            if (!contains) {
            	InternalEntry entry = new InternalEntry(e.getKey(), e.getValue());
                list.add(entry);
                calcSize++;
            }
        }
        
        size = calcSize;

        for (int i = 0; i < data.length; i++) {
            List<InternalEntry> list = data[i];
            if (list != null) {
                data[i] = new ImmutableList<InternalEntry>(list);
            }
        }
        
        
    }

    ImmutableMap(Collection<K> c, EqualityComparator<K> equalityComparator) {

        int capacity = 1;
        while (capacity < c.size())
            capacity <<= 1;
        
        this.equalityComparator = (EqualityComparator<Object>)equalityComparator;

        int calcSize = 0;
        
        data = new List[capacity];
        for (K k : c) {
            int h = equalityComparator.hashCode(k);
            int i = indexFor(h);
            List<InternalEntry> list = data[i];
            if (list == null) {
                data[i] = new ArrayList<InternalEntry>();
                list = data[i];
            }
            boolean contains = false;
            for (InternalEntry entry : list) {
            	if (equalityComparator.equal(entry.getKey(), k)) {
            		contains = true;
            		break;
            	}
            }
            if (!contains) {
                InternalEntry entry = new InternalEntry(k, null);
                list.add(entry);
                calcSize++;
            }
        }

        for (int i = 0; i < data.length; i++) {
            List<InternalEntry> list = data[i];
            if (list != null) {
                data[i] = new ImmutableList<InternalEntry>(list);
            }
        }

        size = calcSize;
    }

    private int indexFor(int hashCode) {
        return hashCode & (data.length-1);
    }

    public Iterator<K> keyIterator() {
        return new KeyIterator();
    }

    public Iterator<Map.Entry<K, V>> entryIterator() {
        return new EntryIterator();
    }

    public boolean containsValue(Object o) {
        Iterator<Map.Entry<K, V>> iterator = entryIterator();
        while (iterator.hasNext()) {
            Map.Entry<K, V> entry = iterator.next();
            if (entry.getValue().equals(o)) {
                return true;
            }
        }
        return false;
    }

    public V get(Object key) {
        Entry<K, V> entry = getEntry(key);
        return entry != null ? entry.getValue() : null;
    }

    public Set<K> keySet() {
        return new KeySet();
    }

    public Collection<V> values() {
        return new ValueCollection();
    }

    public Set<Entry<K, V>> entrySet() {
        return new EntrySet();
    }

    public Iterator<V> valueIterator() {
        return new ValueIterator();
    }

    
    private class InternalEntry implements Map.Entry<K, V> {

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

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean containsKey(Object key) {
        return getEntry(key) != null;
    }

    protected InternalEntry getEntry(Object key) {
        int h = equalityComparator.hashCode(key);
        int tableIndex = indexFor(h);
        List<InternalEntry> list = data[tableIndex];
        
        if (list == null) {
            return null;
        }
        else {
        	int length = list.size();
            for (int i = 0; i < length; i++) {
                InternalEntry entry = list.get(i);
                K k = entry.getKey();

                if (equalityComparator.hashCode(k) == h && equalityComparator.equal(k, key)) {
                    return entry;
                }
            }
        }
        return null;
    }

    private class KeyIterator extends AbstractImmutableIterator<K> implements Iterator<K> {

        private final EntryIterator iterator = new EntryIterator();

        private KeyIterator() {}

        public boolean hasNext() {
            return iterator.hasNext();
        }

        public K next() {
            Map.Entry<K, V> entry = iterator.next();
            return entry.getKey();
        }
    }

    private class ValueIterator extends AbstractImmutableIterator<V> implements Iterator<V> {

        private final EntryIterator iterator = new EntryIterator();

        private ValueIterator() {}

        public boolean hasNext() {
            return iterator.hasNext();
        }

        public V next() {
            Map.Entry<K, V> entry = iterator.next();
            return entry.getValue();
        }
    }

    private class EntryIterator extends AbstractImmutableIterator<Map.Entry<K, V>> implements Iterator<Map.Entry<K, V>> {

        private int index;
        private int subIndex;

        private EntryIterator() {
            subIndex = 0;
            index = 0;
            while (index < data.length && (data[index] == null || data[index].size() == 0 )) {
                index++;
            }
        }

        public boolean hasNext() {
            return index < data.length;
        }

        public Map.Entry<K, V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            List<InternalEntry> list = data[index];
            Map.Entry<K, V> result = list.get(subIndex);

            if (subIndex < list.size() - 1) {
                subIndex++;
            }
            else {
                subIndex = 0;
                index++;
                while (index < data.length && (data[index] == null || data[index].size() == 0 )) {
                    index++;
                }
            }

            return result;
        }
    }

    private class ValueCollection extends DerivedCollection<V> implements Collection<V> {

        public boolean contains(Object o) {
            return containsValue(o);
        }

        public Iterator<V> iterator() {
            return new ValueIterator();
        }
    }

    private class EntrySet extends DerivedCollection<Entry<K, V>> implements Set<Entry<K, V>> {

        private EntrySet() {}

        public boolean contains(Object o) {
            if (!(o instanceof Entry)) {
                return false;
            }
            Entry<?, ?> e = (Entry<?, ?>)o;


            Entry<K, V> entry = getEntry(e.getKey());
            if (entry == null) {
                return false;
            }
            return entry.getValue().equals(e.getValue());
        }

        public Iterator<Entry<K, V>> iterator() {
            return new EntryIterator();
        }
    }



    private class KeySet extends DerivedCollection<K> implements Set<K> {

        private KeySet() {}

        public boolean contains(Object o) {
            return containsKey(o);
        }

        public Iterator<K> iterator() {
            return new KeyIterator();
        }
    }

    private abstract class DerivedCollection<T> extends AbstractImmutableCollection<T> {

        private DerivedCollection() {}

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }
}

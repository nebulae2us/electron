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
public final class ImmutableMap<K, V> extends AbstractImmutableMap<K, V> implements Map<K, V>, ImmutableMapAware<K, V>  {

    private final int size;

    private final InternalEntry<K, V>[] data;

    private final EqualityComparator<Object> equalityComparator;

    @SuppressWarnings("unchecked")
	public ImmutableMap() {
    	this.size = 0;
    	data = new InternalEntry[0];
    	this.equalityComparator = ObjectEqualityComparator.getInstance();
    }
    
    public ImmutableMap(Map<? extends K, ? extends V> m) {
    	this(m, ObjectEqualityComparator.getInstance());
    }
    
    public ImmutableMap(Map<? extends K, ? extends V> m, EqualityComparator<? super K> equalityComparator) {

        int capacity = 1;
        while (capacity < m.size())
            capacity <<= 1;
    	
        this.equalityComparator = (EqualityComparator<Object>)equalityComparator;

        int calcSize = 0;
        data = new InternalEntry[capacity];
        
        
        for (Map.Entry<? extends K, ? extends V> e : m.entrySet()) {
        	
            int h = equalityComparator.hashCode(e.getKey());
            int i = indexFor(h);

            boolean contains = false;
            InternalEntry<K, V> entry = data[i];
            while (entry != null) {
            	if (equalityComparator.hashCode(entry.getKey()) == h && equalityComparator.compare(entry.getKey(), e.getKey())) {
            		contains = true;
            		break;
            	}
            	entry = entry.next;
            }
            if (!contains) {
            	data[i] = new InternalEntry<K, V>(e.getKey(), e.getValue(), data[i]);
                calcSize++;
            }
        }
        
        size = calcSize;
    }

    ImmutableMap(Collection<? extends K> c, EqualityComparator<? super K> equalityComparator) {

        int capacity = 1;
        while (capacity < c.size())
            capacity <<= 1;
        
        this.equalityComparator = (EqualityComparator<Object>)equalityComparator;

        int calcSize = 0;
        
        data = new InternalEntry[capacity];
        for (K k : c) {
            int h = equalityComparator.hashCode(k);
            int i = indexFor(h);

            boolean contains = false;
            InternalEntry<K, V> entry = data[i];
            while (entry != null) {
            	if (equalityComparator.hashCode(entry.getKey()) == h && equalityComparator.compare(entry.getKey(), k)) {
            		contains = true;
            		break;
            	}
            	entry = entry.next;
            }
            if (!contains) {
            	data[i] = new InternalEntry<K, V>(k, null, data[i]);
                calcSize++;
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

    
    private static class InternalEntry<K, V> implements Map.Entry<K, V> {

        private final K key;
        private final V value;
        private final InternalEntry<K, V> next;

        private InternalEntry(K key, V value, InternalEntry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
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

    protected InternalEntry<K, V> getEntry(Object key) {
        int h = equalityComparator.hashCode(key);
        int tableIndex = indexFor(h);
        InternalEntry<K, V> entry = data[tableIndex];

        while (entry != null) {
        	if (this.equalityComparator.hashCode(entry.getKey()) == h && this.equalityComparator.compare(entry.getKey(), key)) {
        		return entry;
        	}
        	entry = entry.next;
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
        private InternalEntry<K, V> entry;

        private EntryIterator() {
            index = 0;
            while (index < data.length && data[index] == null) {
                index++;
            }
            if (index < data.length) {
                entry = data[index];
            }
        }

        public boolean hasNext() {
        	return entry != null;
        }

        public Map.Entry<K, V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            InternalEntry<K, V> result = entry;
        	entry = entry.next;
            if (entry == null) {
            	index++;
            	while (index < data.length && data[index] == null) {
            		index++;
            	}
            	if (index < data.length) {
            		entry = data[index];
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



    private class KeySet extends AbstractImmutableSet<K> {

        private KeySet() {}

        public boolean contains(Object o) {
            return containsKey(o);
        }

        public Iterator<K> iterator() {
            return new KeyIterator();
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
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

	public ImmutableMap<K, V> getImmutableMap() {
		return this;
	}
}

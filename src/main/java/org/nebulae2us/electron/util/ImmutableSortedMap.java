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
public final class ImmutableSortedMap<K, V> extends AbstractImmutableMap<K, V> implements NavigableMap<K, V> {

    private final ImmutableSortedSet<ImmutableEntry<K, V>>  data;
	
    private final Comparator<Object> keyComparator;


    public ImmutableSortedMap() {
    	this.data = new ImmutableSortedSet<ImmutableEntry<K, V>>();
    	this.keyComparator = NaturalComparator.getInstance();
    }
    
    public ImmutableSortedMap(Map<K, V> data, final Comparator<? super K> comparator) {
    	this.keyComparator = comparator == null ? NaturalComparator.getInstance() : (Comparator<Object>)comparator;
    	
        ArrayList<ImmutableEntry<K,V>> _data = new ArrayList<ImmutableEntry<K,V>>();
        
        for (Entry<K, V> entry : data.entrySet()) {
        	
        	if (entry.getKey() == null) {
        		continue;
        	}
        	
            ImmutableEntry<K, V> newEntry = new ImmutableEntry<K, V>(entry.getKey(), entry.getValue());
            _data.add(newEntry);
        }

        Comparator<ImmutableEntry<K, V>> entryComparator = new Comparator<ImmutableEntry<K,V>>() {
    		public int compare(ImmutableEntry<K, V> entry1, ImmutableEntry<K, V> entry2) {
    			return keyComparator.compare(entry1.getKey(), entry2.getKey());
    		}
    	};
        
        this.data = new ImmutableSortedSet<ImmutableEntry<K,V>>(_data, entryComparator);
    }

    public ImmutableSortedMap(SortedMap<K, V> map) {
        this(map, map.comparator());
    }

    public ImmutableSortedMap(ImmutableSortedMap<K, V> cloned, boolean descending) {
        this.data = descending ? cloned.data.descendingSet() : cloned.data;
        this.keyComparator = cloned.keyComparator;
    }
    
    private ImmutableSortedMap(ImmutableSortedSet<ImmutableEntry<K,V>> data, Comparator<Object> keyComparator) {
    	this.data = data;
    	this.keyComparator = keyComparator;
    }

    public Entry<K, V> lowerEntry(K key) {
    	return this.data.lower(new ImmutableEntry<K, V>(key, null));
    }

    public K lowerKey(K key) {
    	Entry<K, V> lowerEntry = lowerEntry(key);
    	return lowerEntry != null ? lowerEntry.getKey() : null;
    }

    public Entry<K, V> floorEntry(K key) {
    	return this.data.floor(new ImmutableEntry<K, V>(key, null));
    }

    public K floorKey(K key) {
    	Entry<K, V> floorEntry = floorEntry(key);
    	return floorEntry != null ? floorEntry.getKey() : null;
    }

    public Entry<K, V> ceilingEntry(K key) {
    	return this.data.ceiling(new ImmutableEntry<K, V>(key, null));
    }

    public K ceilingKey(K key) {
    	Entry<K, V> ceilingEntry = ceilingEntry(key);
        return ceilingEntry != null ? ceilingEntry.getKey() : null;
    }

    public Entry<K, V> higherEntry(K key) {
    	return this.data.higher(new ImmutableEntry<K, V>(key, null));
    }

    public K higherKey(K key) {
    	Entry<K, V> higherEntry = higherEntry(key);
    	return higherEntry != null ? higherEntry.getKey() : null;
    }

    public Entry<K, V> firstEntry() {
        return data.size() == 0 ? null : data.get(0);
    }

    public Entry<K, V> lastEntry() {
        return data.size() == 0 ? null : data.get(data.size() - 1);
    }

    public final Entry<K, V> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    public final Entry<K, V> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    public ImmutableSortedMap<K, V> descendingMap() {
    	return new ImmutableSortedMap<K, V>(this, true);
    }

    public NavigableSet<K> navigableKeySet() {
    	return new InternalSortedSet();
    }

    public NavigableSet<K> descendingKeySet() {
        return new ImmutableSortedMap<K, V>(this, true).navigableKeySet();
    }

    public ImmutableSortedMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive) {
    	int fromIndex = fromInclusive ? data.ceilingIndex(new ImmutableEntry<K, V>(fromKey, null)) : data.higherIndex(new ImmutableEntry<K, V>(fromKey, null));
    	if (fromIndex < 0) {
    		return new ImmutableSortedMap<K, V>();
    	}
    	
    	int toIndex = toInclusive ? data.floorIndex(new ImmutableEntry<K, V>(toKey, null)) : data.lowerIndex(new ImmutableEntry<K, V>(toKey, null));
    	if (toIndex < 0 || toIndex + 1 < fromIndex) {
    		return new ImmutableSortedMap<K, V>();
    	}
    	
        return new ImmutableSortedMap<K, V>(this.data.subSet(fromIndex, toIndex), this.keyComparator);
    }

    public ImmutableSortedMap<K, V> headMap(K toKey, boolean inclusive) {
    	int toIndex = inclusive ? data.floorIndex(new ImmutableEntry<K, V>(toKey, null)) : data.lowerIndex(new ImmutableEntry<K, V>(toKey, null));
    	if (toIndex < 0) {
    		return new ImmutableSortedMap<K, V>();
    	}
    	return new ImmutableSortedMap<K, V>(this.data.subSet(0, toIndex), this.keyComparator);
    }

    public ImmutableSortedMap<K, V> tailMap(K fromKey, boolean inclusive) {
    	int fromIndex = inclusive ? data.ceilingIndex(new ImmutableEntry<K, V>(fromKey, null)) : data.higherIndex(new ImmutableEntry<K, V>(fromKey, null));
    	if (fromIndex < 0) {
    		return new ImmutableSortedMap<K, V>();
    	}
    	return new ImmutableSortedMap<K, V>(this.data.subSet(fromIndex), this.keyComparator);
    }

    public Comparator<? super K> comparator() {
        return this.keyComparator == NaturalComparator.getInstance() ? null : this.keyComparator;
    }

    public ImmutableSortedMap<K, V> subMap(K fromKey, K toKey) {
    	return subMap(fromKey, true, toKey, false);
    }

    public ImmutableSortedMap<K, V> headMap(K toKey) {
    	return headMap(toKey, false);
    }

    public ImmutableSortedMap<K, V> tailMap(K fromKey) {
    	return tailMap(fromKey, true);
    }

    public K firstKey() {
        return data.size() == 0 ? null : data.get(0).getKey();
    }

    public K lastKey() {
        return data.size() == 0 ? null : data.get(data.size() - 1).getKey();
    }

    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public boolean containsKey(Object key) {
        return data.contains(new ImmutableEntry<K, V>((K)key, null));
    }

    public boolean containsValue(Object value) {
    	for (ImmutableEntry<K, V> entry : this.data) {
    		if (value == null) {
    			if (entry.getValue() == null) {
    				return true;
    			}
    		}
    		else if (value.equals(entry.getValue())) {
    			return true;
    		}
    	}
    	return false;
    }

    public V get(Object key) {
    	int idx = data.indexOf(new ImmutableEntry<K, V>((K)key, null));
    	return idx < 0 ? null : this.data.get(idx).getValue();
    }

    public NavigableSet<K> keySet() {
        return navigableKeySet();
    }

    public Collection<V> values() {
        return new ValueCollection();
    }

    @SuppressWarnings("unchecked")
	public ImmutableSortedSet<Entry<K, V>> entrySet() {
    	return (ImmutableSortedSet<Entry<K, V>>)(ImmutableSortedSet<? extends Entry<K, V>>)this.data;
    }

    private class ValueCollection extends AbstractImmutableCollection<V> implements Collection<V> {

        public int size() {
            return data.size();
        }

        public boolean isEmpty() {
            return data.isEmpty();
        }

        public boolean contains(Object o) {
        	return ImmutableSortedMap.this.containsValue(o);
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
            return this.index < data.size();
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
    
    private static class InternalIterator<K, V> implements Iterator<K> {

    	private final Iterator<ImmutableEntry<K, V>> entryIterator;
    	
		private InternalIterator(Iterator<ImmutableEntry<K, V>> entryIterator) {
			this.entryIterator = entryIterator;
		}

		public boolean hasNext() {
			return entryIterator.hasNext();
		}

		public K next() {
			return entryIterator.next().getKey();
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
		
    }
    
    private class InternalSortedSet extends AbstractImmutableSortedSet<K> {

		public Comparator<? super K> comparator() {
			return ImmutableSortedMap.this.keyComparator;
		}

		public K first() {
			return ImmutableSortedMap.this.firstKey();
		}

		public K last() {
			return ImmutableSortedMap.this.lastKey();
		}

		public int size() {
			return ImmutableSortedMap.this.size();
		}

		public boolean isEmpty() {
			return ImmutableSortedMap.this.isEmpty();
		}

		public boolean contains(Object o) {
			return ImmutableSortedMap.this.containsKey(o);
		}

		public K lower(K e) {
			return ImmutableSortedMap.this.lowerKey(e);
		}

		public K floor(K e) {
			return ImmutableSortedMap.this.floorKey(e);
		}

		public K ceiling(K e) {
			return ImmutableSortedMap.this.ceilingKey(e);
		}

		public K higher(K e) {
			return ImmutableSortedMap.this.higherKey(e);
		}

		public Iterator<K> iterator() {
			return new InternalIterator<K, V>(ImmutableSortedMap.this.data.iterator());
		}

		public NavigableSet<K> descendingSet() {
			return ImmutableSortedMap.this.descendingKeySet();
		}

		public Iterator<K> descendingIterator() {
			return new InternalIterator<K, V>(ImmutableSortedMap.this.data.descendingIterator());
		}

		public NavigableSet<K> subSet(K fromElement, boolean fromInclusive, K toElement, boolean toInclusive) {
			return ImmutableSortedMap.this.subMap(fromElement, fromInclusive, toElement, toInclusive).keySet();
		}

		public NavigableSet<K> headSet(K toElement, boolean inclusive) {
			return ImmutableSortedMap.this.headMap(toElement, inclusive).keySet();
		}

		public NavigableSet<K> tailSet(K fromElement, boolean inclusive) {
			return ImmutableSortedMap.this.tailMap(fromElement, inclusive).keySet();
		}

		public SortedSet<K> subSet(K fromElement, K toElement) {
			return ImmutableSortedMap.this.subMap(fromElement, toElement).keySet();
		}

		public SortedSet<K> headSet(K toElement) {
			return ImmutableSortedMap.this.headMap(toElement).keySet();
		}

		public SortedSet<K> tailSet(K fromElement) {
			return ImmutableSortedMap.this.tailMap(fromElement).keySet();
		}
    	
    }
}

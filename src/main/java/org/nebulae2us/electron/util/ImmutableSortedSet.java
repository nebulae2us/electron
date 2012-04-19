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

import java.io.Serializable;
import java.util.*;

/**
 * @author Trung Phan
 */
public final class ImmutableSortedSet<E> extends AbstractImmutableSortedSet<E> implements NavigableSet<E>, RandomAccess, Cloneable, Serializable {

	private static final long serialVersionUID = 1804056996695224851L;
	
	private final ImmutableList<E> data;

    public ImmutableSortedSet() {
    	this.data = new ImmutableList<E>(Collections.EMPTY_LIST, NaturalComparator.getInstance(), true);
    }
	
    public ImmutableSortedSet(Collection<E> c, Comparator<? super E> comparator) {
    	this.data = new ImmutableList<E>(c, comparator, true);
    }
    
    public ImmutableSortedSet(SortedSet<? extends E> sortedSet) {
    	Comparator<?> comparator = sortedSet.comparator();
    	if (comparator == null) {
    		comparator = NaturalComparator.getInstance();
    	}
    	this.data = new ImmutableList<E>(sortedSet, (Comparator<? super E>)comparator, false);
    }
    
    public ImmutableSortedSet(Collection<E> c) {
    	this(c, c instanceof ImmutableList ? (Comparator<Object>)((ImmutableList<E>)c).comparator() : NaturalComparator.getInstance());
    }
    
    public ImmutableSortedSet(E ... elements) {
    	this(NaturalComparator.getInstance(), elements);
    }
    
    public ImmutableSortedSet(Comparator<? super E> comparator, E ... elements) {
    	this(Arrays.asList(elements), comparator);
    }
    
    private ImmutableSortedSet(ImmutableList<E> internalData) {
    	this.data = internalData;
    }
    
    public int indexOf(Object o) {
    	return data.indexOf(o);
    }
    
    public E get(int index) {
    	return data.get(index);
    }

    public int lowerIndex(E e) {
    	if (e == null) {
    		return -1;
    	}
    	
    	int idx = data.binarySearch(e);
    	if (idx == -1 || idx == 0) {
    		return -1;
    	}
    	else if (idx < - 1) {
    		return - idx - 2;
    	}
    	else {
    		return idx - 1;
    	}
    }
    
    public E lower(E e) {
    	int idx = lowerIndex(e);
    	return idx < 0 ? null : data.get(idx);
    }

    public int floorIndex(E e) {
    	if (e == null) {
    		return -1;
    	}
    	
    	int idx = data.binarySearch(e);
    	if (idx == -1) {
    		return -1;
    	}
    	else if (idx < - 1) {
    		return - idx - 2;
    	}
    	else {
    		return idx;
    	}
    }
    
    public E floor(E e) {
    	int idx = floorIndex(e);
    	return idx < 0 ? null : data.get(idx);
    }

    public int ceilingIndex(E e) {
    	if (e == null) {
    		return -1;
    	}
    	
    	int idx = data.binarySearch(e);
    	if (idx == -1 - size()) {
    		return -1;
    	}
    	else if (idx < 0) {
    		return -idx - 1;
    	}
    	else {
    		return idx;
    	}
    }
    
    public E ceiling(E e) {
    	int idx = ceilingIndex(e);
    	return idx < 0 ? null : data.get(idx);
    }

    public int higherIndex(E e) {
    	if (e == null) {
    		return -1;
    	}
    	
    	int idx = data.binarySearch(e);
    	if (idx == size() - 1 || idx == -1 - size()) {
    		return -1;
    	}
    	else if (idx < 0) {
    		return -idx - 1;
    	}
    	else {
    		return idx + 1;
    	}    	
    }
    
    public E higher(E e) {
    	int idx = higherIndex(e);
    	return idx < 0 ? null : data.get(idx);
    }

    public ImmutableSortedSet<E> descendingSet() {
        return new ImmutableSortedSet<E>(data.descendingList());
    }

    public ImmutableSortedSet<E> subSet(int fromIndex) {
    	return new ImmutableSortedSet<E>(data.subList(fromIndex));
    }
    
    public ImmutableSortedSet<E> subSet(int fromIndex, int toIndex) {
    	return new ImmutableSortedSet<E>(data.subList(fromIndex, toIndex));
    }

    public ImmutableSortedSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
    	
    	int lowerIndex = fromInclusive ? floorIndex(fromElement) : lowerIndex(fromElement);
    	if (lowerIndex < 0) {
    		return new ImmutableSortedSet<E>();
    	}
    	int higherIndex = toInclusive ? ceilingIndex(toElement) : higherIndex(toElement);
    	if (higherIndex <= lowerIndex) {
    		return new ImmutableSortedSet<E>();
    	}
    	
    	return new ImmutableSortedSet<E>(data.subList(lowerIndex, higherIndex));
    }

    public ImmutableSortedSet<E> headSet(E toElement, boolean inclusive) {
    	if (isEmpty()) {
    		return this;
    	}
    	
    	int higherIndex = inclusive ? ceilingIndex(toElement) : higherIndex(toElement);
    	if (higherIndex <= 0) {
    		return new ImmutableSortedSet<E>();
    	}

        return new ImmutableSortedSet<E>(data.subList(0, higherIndex));
    }

    public ImmutableSortedSet<E> tailSet(E fromElement, boolean inclusive) {
    	if (isEmpty()) {
    		return this;
    	}
    	
    	int lowerIndex = inclusive ? floorIndex(fromElement) : lowerIndex(fromElement);
    	if (lowerIndex < 0) {
    		return new ImmutableSortedSet<E>();
    	}
    	return new ImmutableSortedSet<E>(data.subList(lowerIndex, size()));
    }

    public ImmutableSortedSet<E> subSet(E fromElement, E toElement) {
    	return subSet(fromElement, true, toElement, true);
    }

    public ImmutableSortedSet<E> headSet(E toElement) {
    	return headSet(toElement, true);
    }

    public ImmutableSortedSet<E> tailSet(E fromElement) {
    	return tailSet(fromElement, true);
    }

    public E first() {
        return size() == 0 ? null : data.get(0);
    }

    public E last() {
        return size() == 0 ? null : data.get(size() - 1);
    }

	@Override
	public boolean equals(Object o) {
		if (o == this)
		    return true;

		if (!(o instanceof Set))
		    return false;
		
		Set<?> set = (Set<?>) o;

		if (set.size() != size())
		    return false;

		try {
            return containsAll(set);
        } catch (ClassCastException unused)   {
            return false;
        } catch (NullPointerException unused) {
            return false;
        }
		
	}
	
	@Override
	public int hashCode() {
		int h = 0;
		Iterator<E> i = iterator();
		while (i.hasNext()) {
		    E obj = i.next();
	            if (obj != null)
	                h += obj.hashCode();
	        }
		return h;
	}

	public Comparator<? super E> comparator() {
		return data.comparator();
	}

	public boolean contains(Object o) {
		return data.contains(o);
	}

	public int size() {
		return data.size();
	}

	public Iterator<E> descendingIterator() {
		return data.descendingIterator();
	}

	public Iterator<E> iterator() {
		return data.iterator();
	}


}

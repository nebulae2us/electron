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
import java.lang.reflect.Array;
import java.util.*;

/**
 * @author Trung Phan
 */
public class ImmutableList<E> extends AbstractImmutableList<E> implements List<E>, RandomAccess, Cloneable, Serializable {

	private static final long serialVersionUID = -2955135267976316366L;

	private final Object[] data;

    private final int fromIndex;

    private final int size;

    private final boolean descending;

    private final Comparator<Object> comparator;

    private final EqualityComparator<E> equalityComparator;


    public ImmutableList(ImmutableList<E> c) {
        this.fromIndex = c.fromIndex;
        data = c.data;
        this.size = c.size();
        this.descending = c.descending;
        this.comparator = c.comparator;
        this.equalityComparator = c.equalityComparator;
    }

    @SuppressWarnings("unchecked")
	public ImmutableList() {
        this(Collections.EMPTY_LIST);
    }

    public ImmutableList(E ... elements) {
        this(Arrays.asList(elements));
    }

    public ImmutableList(Comparator<? super E> comparator, E ... elements) {
        this(Arrays.asList(elements), comparator, false);
    }

    public ImmutableList(EqualityComparator<E> equalityComparator, E ... elements) {
        this(Arrays.asList(elements), equalityComparator, false);
    }

    @SuppressWarnings("unchecked")
	public ImmutableList(Collection<? extends E> c, EqualityComparator<E> equalityComparator, boolean unique) {
        this.fromIndex = 0;
        this.descending = false;
        this.comparator = null;
        this.equalityComparator = equalityComparator;

    	if (unique) {
    		List<E> uniqueList = new ArrayList<E>(c.size());
    		for (E e : c) {
    			boolean dup = false;
    			for (E elementOfUniqueList : uniqueList) {
    				if (equalityComparator.equal(e, elementOfUniqueList)) {
    					dup = true;
    					break;
    				}
    			}
    			if (!dup) {
    				uniqueList.add(e);
    			}
    		}
    		c = uniqueList;
    	}
    	
        data = new Object[c.size()];
        c.toArray(data);
        this.size = c.size();
    }
    
    public ImmutableList(Collection<? extends E> c) {
        this(c, new ObjectEqualityComparator<E>(), false);
    }

    protected ImmutableList(Collection<? extends E> c, Comparator<? super E> comparator, boolean unique) {
        this.fromIndex = 0;
        this.descending = false;
        this.comparator = (Comparator<Object>)comparator;

        if (unique) {
    		List<E> uniqueList = new ArrayList<E>(c.size());
    		for (E e : c) {
    			boolean dup = false;
    			for (E elementOfUniqueList : uniqueList) {
    				if (comparator.compare(e, elementOfUniqueList) == 0) {
    					dup = true;
    					break;
    				}
    			}
    			if (!dup) {
    				uniqueList.add(e);
    			}
    		}
    		c = uniqueList;
    	}
    	
        Object[] newData = new Object[c.size()];
        c.toArray(newData);
        Arrays.sort(newData, this.comparator);
        data = newData;

        this.size = c.size();
        this.equalityComparator = null;
    }

    protected ImmutableList(ImmutableList<E> cloned, int fromIndex, int toIndex) {
        if (fromIndex < 0 || fromIndex >= cloned.size ||
            toIndex < 0 || toIndex > cloned.size || toIndex < fromIndex  ) {
            throw new IllegalArgumentException("fromIndex or toIndex is not valid.");
        }

        this.fromIndex = cloned.fromIndex + fromIndex;
        this.data = cloned.data;
        this.size = cloned.fromIndex + toIndex - this.fromIndex;
        this.descending = cloned.descending;
        this.comparator = cloned.comparator;
        this.equalityComparator = cloned.equalityComparator;
    }

    protected ImmutableList(ImmutableList<E> cloned, boolean descending) {
        this.fromIndex = cloned.fromIndex;
        this.data = cloned.data;
        this.size = cloned.size;
        this.descending = descending ? !cloned.descending : cloned.descending;
        this.comparator = cloned.comparator;
        this.equalityComparator = cloned.equalityComparator;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        return (E)data[descending ? fromIndex + size - index - 1 : fromIndex + index];
    }

    private int indexOf(Object o, boolean descending) {
        boolean realDesc = this.descending ? !descending : descending;

        if (comparator != null) {
            int idx = Arrays.binarySearch(data, fromIndex, fromIndex + size, o, comparator);
            return idx < 0 ? -1 : idx;
        }
        else if (equalityComparator != null) {
            for (int i = 0; i < size; i++) {
                if (equalityComparator.equal((E)o, (E)data[realDesc ? fromIndex + size - i - 1 : fromIndex + i]))
                    return i;
            }
        }
        return -1;
    }

    public int indexOf(Object o) {
        return indexOf(o, false);
    }

    public int lastIndexOf(Object o) {
        return indexOf(o, true);
    }

    public ImmutableList<E> subList(int fromIndex, int toIndex) {
        return new ImmutableList<E>(this, fromIndex, toIndex);
    }

    public Object[] toArray() {
        Object[] result = new Object[size];
        if (descending) {
            for (int i = size - 1; i >= 0; i--) {
                result[i] = data[fromIndex + i];
            }
        }
        else {
            for (int i = 0; i < size; i++) {
                result[i] = data[fromIndex + i];
            }
        }
        return result;
    }

    public <T> T[] toArray(T[] a) {
    	
    	T[] result = a;
    	
    	if (result.length < size) {
    		result = (T[])Array.newInstance(a.getClass(), size);
    	}
    	
    	if (descending) {
    		for (int i = size - 1; i >= 0; i--) {
    			result[i] = (T)data[fromIndex + i];
    		}
    	}
    	else {
    		for (int i = 0; i < size; i++) {
    			result[i] = (T)data[fromIndex + i];
    		}
    	}
    	
        if (result.length > size)
            result[size] = null;

        return result;
    }

    public Iterator<E> iterator() {
        return new InternalListIterator(0, false);
    }
    
	public Iterator<E> descendingIterator() {
		return new InternalListIterator(0, true);
	}
    

    public Comparator<? super E> comparator() {
        return comparator;
    }

    private final class InternalListIterator extends AbstractImmutableListIterator<E> implements ListIterator<E> {

        private int index;
        
        private final boolean descending;

        private InternalListIterator(int index, boolean descending) {
            this.descending = descending;
            this.index = descending ? ImmutableList.this.size - 1 - index : index;
        }

        public boolean hasNext() {
            return this.descending ? index >= 0 : index < ImmutableList.this.size;
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return ImmutableList.this.get(this.descending ? index-- : index ++);
        }

        public boolean hasPrevious() {
            return this.descending ? index < ImmutableList.this.size - 1 : index > 0;
        }

        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            return ImmutableList.this.get(this.descending ? ++index : --index);
        }

        public int nextIndex() {
            return index;
        }

        public int previousIndex() {
            return this.descending ? index + 1 : index - 1;
        }
    }

    public ListIterator<E> listIterator() {
        return new InternalListIterator(0, false);
    }

    public ListIterator<E> descendingListIterator() {
        return new InternalListIterator(0, true);
    }
    
    public ListIterator<E> listIterator(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return new InternalListIterator(index, false);
    }

    public ListIterator<E> descendingListIterator(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return new InternalListIterator(index, true);
    }
    
    public ImmutableList<E> descendingList() {
        return new ImmutableList<E>(this, true);
    }

    protected int binarySearch(Object o) {
        if (comparator == null) {
            throw new NullPointerException();
        }
        if (comparator.getClass() == NaturalComparator.class) {
            return Arrays.binarySearch(this.data, this.fromIndex, this.fromIndex + this.size, o);
        }
        else {
            return Arrays.binarySearch(this.data, this.fromIndex, this.fromIndex + this.size, o, comparator);
        }
    }

}

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
public class ImmutableList<E> extends AbstractImmutableList<E> implements List<E>, RandomAccess, Cloneable, Serializable {

	private static final long serialVersionUID = -2955135267976316366L;

	private final E[] data;

    private final int fromIndex;

    private final int size;

    private final boolean descending;

    private final Comparator<? super E> comparator;

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
        this(Arrays.asList(elements), comparator);
    }

    public ImmutableList(EqualityComparator<E> equalityComparator, E ... elements) {
        this(Arrays.asList(elements), equalityComparator);
    }

    @SuppressWarnings("unchecked")
	public ImmutableList(Collection<? extends E> c, EqualityComparator<E> equalityComparator) {
        this.fromIndex = 0;
        data = (E[]) new Object[c.size()];
        c.toArray(data);
        this.size = c.size();
        this.descending = false;
        this.comparator = null;
        this.equalityComparator = equalityComparator;
    }

    public ImmutableList(Collection<? extends E> c) {
        this(c, new ObjectEqualityComparator<E>());
    }

    protected ImmutableList(Collection<? extends E> c, Comparator<? super E> comparator) {
        this.fromIndex = 0;

        E[] newData = (E[])new Object[c.size()];
        c.toArray(newData);
        Arrays.sort(newData, comparator);
        data = newData;

        this.size = c.size();
        this.descending = false;
        this.comparator = comparator;
        this.equalityComparator = null;
    }

    private ImmutableList(ImmutableList<E> cloned, int fromIndex, int toIndex) {
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

    private ImmutableList(ImmutableList<E> cloned, boolean descending) {
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

        return data[descending ? fromIndex + size - index - 1 : fromIndex + index];
    }

    private int indexOf(Object o, boolean descending) {
        boolean realDesc = this.descending ? !descending : descending;

        if (comparator != null) {
            return Arrays.binarySearch(data, fromIndex, fromIndex + size, comparator);
        }
        else if (equalityComparator != null) {
            for (int i = 0; i < size; i++) {
                if (equalityComparator.equal((E)o, data[realDesc ? fromIndex + size - i - 1 : fromIndex + i]))
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

    public List<E> subList(int fromIndex, int toIndex) {
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
        return null;
    }

    public Iterator<E> iterator() {
        return new InternalListIterator(0);
    }

    public Comparator<? super E> comparator() {
        return comparator;
    }

    private final class InternalListIterator extends AbstractImmutableListIterator<E> implements ListIterator<E> {

        private int index;

        private InternalListIterator(int index) {
            this.index = index;
        }

        public boolean hasNext() {
            return index < ImmutableList.this.size;
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return ImmutableList.this.get(index ++);
        }

        public boolean hasPrevious() {
            return index > 0;
        }

        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            return ImmutableList.this.get(--index);
        }

        public int nextIndex() {
            return index;
        }

        public int previousIndex() {
            return index - 1;
        }
    }

    public ListIterator<E> listIterator() {
        return new InternalListIterator(0);
    }

    public ListIterator<E> listIterator(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return new InternalListIterator(index);
    }

    public ImmutableList<E> descendingList() {
        return new ImmutableList<E>(this, true);
    }

    protected int binarySearch(Object o) {
        if (comparator == null) {
            throw new NullPointerException();
        }
        return Arrays.binarySearch(this.data, this.fromIndex, this.fromIndex + this.size, comparator);
    }

}

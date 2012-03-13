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
public class ImmutableSortedUniqueList<E> extends AbstractImmutableList<E>
    implements List<E>, NavigableSet<E>, RandomAccess, Cloneable, Serializable {

	private static final long serialVersionUID = 1804056996695224851L;

	private final ImmutableSortedList<E> keys;

    public ImmutableSortedUniqueList(Collection<E> c, Comparator<? super E> comparator) {
        List<E> keyList = new ArrayList<E>();
        for (E e : c) {
            int i = Collections.binarySearch(keyList, e, comparator);
            if (i < 0) {
                keyList.add(-i-1, e);
            }
        }

        keys = new ImmutableSortedList<E>(keyList, comparator);
    }

    private ImmutableSortedUniqueList(ImmutableSortedUniqueList<E> cloned, boolean descending) {
        this.keys = descending ? cloned.keys.descendingList() : cloned.keys;
    }

    public int indexOf(Object o) {
        return keys.indexOf(o);
    }

    public int lastIndexOf(Object o) {
        return keys.lastIndexOf(o);
    }

    public ListIterator<E> listIterator() {
        return keys.listIterator();
    }

    public ListIterator<E> listIterator(int index) {
        return keys.listIterator(index);
    }

    public List<E> subList(int fromIndex, int toIndex) {
        return keys.subList(fromIndex, toIndex);
    }

    public E lower(E e) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public E floor(E e) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public E ceiling(E e) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public E higher(E e) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public E pollFirst() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public E pollLast() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int size() {
        return keys.size();
    }

    public boolean isEmpty() {
        return keys.size() == 0;
    }

    public boolean contains(Object o) {
        return keys.contains(o);
    }

    public Iterator<E> iterator() {
        return keys.iterator();
    }

    public Object[] toArray() {
        return keys.toArray();
    }

    public <T> T[] toArray(T[] a) {
        return keys.toArray(a);
    }

    public boolean containsAll(Collection<?> c) {
        return keys.containsAll(c);
    }

    public E get(int index) {
        return keys.get(index);
    }

    public ImmutableSortedUniqueList<E> descendingSet() {
        return new ImmutableSortedUniqueList<E>(this, true);
    }

    public Iterator<E> descendingIterator() {
        return descendingSet().iterator();
    }

    public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public NavigableSet<E> headSet(E toElement, boolean inclusive) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Comparator<? super E> comparator() {
        return keys.comparator();
    }

    public SortedSet<E> subSet(E fromElement, E toElement) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public SortedSet<E> headSet(E toElement) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public SortedSet<E> tailSet(E fromElement) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public E first() {
        return keys.get(0);
    }

    public E last() {
        return keys.get(keys.size() - 1);
    }
}

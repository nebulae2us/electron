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
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author Trung Phan
 *
 */
public final class ImmutableTreeSet<E> extends TreeSet<E> {

	private static final long serialVersionUID = 1555011942707861208L;

	private final ImmutableSortedSet<E> data;
	
	public ImmutableTreeSet(SortedSet<? extends E> c) {
		this.data = new ImmutableSortedSet<E>(c);
	}

	@Override
	public boolean add(E e) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public E ceiling(E e) {
		return data.ceiling(e);
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object clone() {
		return super.clone();
	}

	@Override
	public Comparator<? super E> comparator() {
		return data.comparator() == NaturalComparator.getInstance() ? null : data.comparator();
	}

	@Override
	public boolean contains(Object o) {
		return data.contains(o);
	}

	@Override
	public Iterator<E> descendingIterator() {
		return data.descendingIterator();
	}

	@Override
	public NavigableSet<E> descendingSet() {
		return data.descendingSet();
	}

	@Override
	public E first() {
		return data.first();
	}

	@Override
	public E floor(E e) {
		return data.floor(e);
	}

	@Override
	public SortedSet<E> headSet(E toElement) {
		return data.headSet(toElement);
	}

	@Override
	public NavigableSet<E> headSet(E toElement, boolean inclusive) {
		return data.headSet(toElement, inclusive);
	}

	@Override
	public E higher(E e) {
		return data.higher(e);
	}

	@Override
	public boolean isEmpty() {
		return data.isEmpty();
	}

	@Override
	public Iterator<E> iterator() {
		return data.iterator();
	}

	@Override
	public E last() {
		return data.last();
	}

	@Override
	public E lower(E e) {
		return data.lower(e);
	}

	@Override
	public E pollFirst() {
		throw new UnsupportedOperationException();
	}

	@Override
	public E pollLast() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int size() {
		return data.size();
	}

	@Override
	public SortedSet<E> subSet(E fromElement, E toElement) {
		return data.subSet(fromElement, toElement);
	}

	@Override
	public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
		return data.subSet(fromElement, fromInclusive, toElement, toInclusive);
	}

	@Override
	public SortedSet<E> tailSet(E fromElement) {
		return data.tailSet(fromElement);
	}

	@Override
	public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
		return data.tailSet(fromElement, inclusive);
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (o == null || o.getClass() != this.getClass()) {
			return false;
		}
		return this.data.equals(((ImmutableTreeSet<?>)o).data);
	}

	@Override
	public int hashCode() {
		return data.hashCode();
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return data.containsAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object[] toArray() {
		return data.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return data.toArray(a);
	}

	@Override
	public String toString() {
		return data.toString();
	}

}

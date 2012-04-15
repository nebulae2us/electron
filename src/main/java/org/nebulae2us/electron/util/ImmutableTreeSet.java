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
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author Trung Phan
 *
 */
public class ImmutableTreeSet<E> extends TreeSet<E> {

	private static final long serialVersionUID = 1555011942707861208L;

	public ImmutableTreeSet(Collection<? extends E> collection) {
		super(collection);
	}
	
	public ImmutableTreeSet(SortedSet<E> sortedSet) {
		super(sortedSet);
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
	public void clear() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Iterator<E> descendingIterator() {
		return new ImmutableIterator<E>(super.descendingIterator());
	}

	@Override
	public NavigableSet<E> descendingSet() {
		return new ImmutableTreeSet<E>(super.descendingSet());
	}

	@Override
	public NavigableSet<E> headSet(E toElement, boolean inclusive) {
		return new ImmutableTreeSet<E>(super.headSet(toElement, inclusive));
	}

	@Override
	public SortedSet<E> headSet(E toElement) {
		return new ImmutableTreeSet<E>(super.headSet(toElement));
	}

	@Override
	public Iterator<E> iterator() {
		return new ImmutableIterator<E>(super.iterator());
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
	public boolean remove(Object element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
		return new ImmutableTreeSet<E>(super.subSet(fromElement, fromInclusive, toElement, toInclusive));
	}

	@Override
	public SortedSet<E> subSet(E fromElement, E toElement) {
		return new ImmutableTreeSet<E>(super.subSet(fromElement, toElement));
	}

	@Override
	public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
		return new ImmutableTreeSet<E>(super.tailSet(fromElement, inclusive));
	}

	@Override
	public SortedSet<E> tailSet(E fromElement) {
		return new ImmutableTreeSet<E>(super.tailSet(fromElement));
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

}

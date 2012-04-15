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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * @author Trung Phan
 *
 */
public final class ImmutableArrayList<E> extends ArrayList<E> {

	private static final long serialVersionUID = -68339846306694866L;

	public ImmutableArrayList(Collection<? extends E> collection) {
		super(collection);
	}
	
	@Override
	public Iterator<E> iterator() {
		return new ImmutableIterator<E>(super.iterator());
	}

	@Override
	public ListIterator<E> listIterator() {
		return new ImmutableListIterator<E>(super.listIterator());
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		return new ImmutableListIterator<E>(super.listIterator(index));
	}

	@Override
	public ImmutableList<E> subList(int fromIndex, int toIndex) {
		return new ImmutableList<E>(super.subList(fromIndex, toIndex));
	}

	@Override
	public boolean add(E e) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void add(int index, E e) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void ensureCapacity(int capacity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public E remove(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	protected void removeRange(int fromIndex, int toIndex) {
		throw new UnsupportedOperationException();
	}

	@Override
	public E set(int index, E e) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void trimToSize() {
		throw new UnsupportedOperationException();
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

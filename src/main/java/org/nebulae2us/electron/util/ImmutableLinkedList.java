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
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @author Trung Phan
 *
 */
public class ImmutableLinkedList<E> extends LinkedList<E> {

	private static final long serialVersionUID = -3581086529474852600L;

	public ImmutableLinkedList(Collection<? extends E> collection) {
		super(collection);
	}
	
	@Override
	public void addFirst(E arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void addLast(E arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Iterator<E> descendingIterator() {
		return new ImmutableIterator<E>(super.descendingIterator());
	}

	@Override
	public boolean offer(E arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean offerFirst(E arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean offerLast(E arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void push(E arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public E remove() {
		throw new UnsupportedOperationException();
	}

	@Override
	public E removeFirst() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeFirstOccurrence(Object arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public E removeLast() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeLastOccurrence(Object arg0) {
		throw new UnsupportedOperationException();
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
	public boolean add(E arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void add(int arg0, E arg1) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(Collection<? extends E> arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(int arg0, Collection<? extends E> arg1) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException();
	}

	@Override
	public E remove(int arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean remove(Object arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	protected void removeRange(int arg0, int arg1) {
		throw new UnsupportedOperationException();
	}

	@Override
	public E set(int arg0, E arg1) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		throw new UnsupportedOperationException();
	}

}

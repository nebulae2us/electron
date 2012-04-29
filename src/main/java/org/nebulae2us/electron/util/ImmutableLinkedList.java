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
import java.util.List;
import java.util.ListIterator;

/**
 * @author Trung Phan
 *
 */
public final class ImmutableLinkedList<E> extends LinkedList<E> {

	private static final long serialVersionUID = -3581086529474852600L;
	
	private final ImmutableList<E> data;

	public ImmutableLinkedList(Collection<? extends E> collection) {
		this.data = new ImmutableList<E>(collection);
	}

	@Override
	public E getFirst() {
		return data.size() == 0 ? null : data.get(0);
	}

	@Override
	public E getLast() {
		return data.size() == 0 ? null : data.get(data.size() - 1);
	}

	@Override
	public E removeFirst() {
		throw new UnsupportedOperationException();
	}

	@Override
	public E removeLast() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void addFirst(E e) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void addLast(E e) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean contains(Object o) {
		return data.contains(o);
	}

	@Override
	public int size() {
		return data.size();
	}

	@Override
	public boolean add(E e) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean remove(Object o) {
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
	public E get(int index) {
		return data.get(index);
	}

	@Override
	public E set(int index, E element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void add(int index, E element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public E remove(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int indexOf(Object o) {
		return data.indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o) {
		return data.lastIndexOf(o);
	}

	@Override
	public E peek() {
		return data.size() == 0 ? null : data.get(0);
	}

	@Override
	public E element() {
		return data.size() == 0 ? null : data.get(0);
	}

	@Override
	public E poll() {
		throw new UnsupportedOperationException();
	}

	@Override
	public E remove() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean offer(E e) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean offerFirst(E e) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean offerLast(E e) {
		throw new UnsupportedOperationException();
	}

	@Override
	public E peekFirst() {
		return data.size() == 0 ? null : data.get(0);
	}

	@Override
	public E peekLast() {
		return data.size() == 0 ? null : data.get(data.size() - 1);
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
	public void push(E e) {
		throw new UnsupportedOperationException();
	}

	@Override
	public E pop() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeFirstOccurrence(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeLastOccurrence(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		return data.listIterator(index);
	}

	@Override
	public Iterator<E> descendingIterator() {
		return data.descendingIterator();
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
	public Iterator<E> iterator() {
		return data.iterator();
	}

	@Override
	public ListIterator<E> listIterator() {
		return data.listIterator();
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		return data.subList(fromIndex, toIndex);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		return data.equals(o);
	}

	@Override
	public int hashCode() {
		return data.hashCode();
	}

	@Override
	protected void removeRange(int fromIndex, int toIndex) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isEmpty() {
		return data.isEmpty();
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return data.containsAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String toString() {
		return data.toString();
	}
	
	


}

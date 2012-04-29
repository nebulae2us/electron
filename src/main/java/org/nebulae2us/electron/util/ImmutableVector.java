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
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

/**
 * @author Trung Phan
 *
 */
public final class ImmutableVector<E> extends Vector<E> {

	private static final long serialVersionUID = 4392194772175824819L;

	private final ImmutableList<E> data;
	
	public ImmutableVector(Collection<? extends E> data) {
		this.data = new ImmutableList<E>(data);
	}

	@Override
	public synchronized void copyInto(Object[] anArray) {
		if (anArray == null) {
			throw new NullPointerException();
		}
		if (anArray.length < data.size()) {
			throw new IndexOutOfBoundsException();
		}
		
		data.toArray(anArray);
	}

	@Override
	public synchronized void trimToSize() {
		throw new UnsupportedOperationException();
	}

	@Override
	public synchronized void ensureCapacity(int minCapacity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public synchronized void setSize(int newSize) {
		throw new UnsupportedOperationException();
	}

	@Override
	public synchronized int capacity() {
		return data.size();
	}

	@Override
	public synchronized int size() {
		return data.size();
	}

	@Override
	public synchronized boolean isEmpty() {
		return data.isEmpty();
	}

	@Override
	public Enumeration<E> elements() {
		return data.elements();
	}

	@Override
	public boolean contains(Object o) {
		return data.contains(o);
	}

	@Override
	public int indexOf(Object o) {
		return data.indexOf(o);
	}

	@Override
	public synchronized int indexOf(Object o, int index) {
		return data.indexOf(o, index);
	}

	@Override
	public synchronized int lastIndexOf(Object o) {
		return data.lastIndexOf(o);
	}

	@Override
	public synchronized int lastIndexOf(Object o, int index) {
		return data.lastIndexOf(o, index);
	}

	@Override
	public synchronized E elementAt(int index) {
		return data.get(index);
	}

	@Override
	public synchronized E firstElement() {
		return data.size() == 0 ? null : data.get(0);
	}

	@Override
	public synchronized E lastElement() {
		return data.size() == 0 ? null : data.get(data.size() - 1);
	}

	@Override
	public synchronized void setElementAt(E obj, int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public synchronized void removeElementAt(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public synchronized void insertElementAt(E obj, int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public synchronized void addElement(E obj) {
		throw new UnsupportedOperationException();
	}

	@Override
	public synchronized boolean removeElement(Object obj) {
		throw new UnsupportedOperationException();
	}

	@Override
	public synchronized void removeAllElements() {
		throw new UnsupportedOperationException();
	}

	@Override
	public synchronized Object[] toArray() {
		return data.toArray();
	}

	@Override
	public synchronized <T> T[] toArray(T[] a) {
		return data.toArray(a);
	}

	@Override
	public synchronized E get(int index) {
		return data.get(index);
	}

	@Override
	public synchronized E set(int index, E element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public synchronized boolean add(E e) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void add(int index, E element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public synchronized E remove(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException();
	}

	@Override
	public synchronized boolean containsAll(Collection<?> c) {
		return data.containsAll(c);
	}

	@Override
	public synchronized boolean addAll(Collection<? extends E> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public synchronized boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public synchronized boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public synchronized boolean addAll(int index, Collection<? extends E> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public synchronized boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		return data.equals(o);
	}

	@Override
	public synchronized int hashCode() {
		return data.hashCode();
	}

	@Override
	public synchronized String toString() {
		return data.toString();
	}

	@Override
	public synchronized List<E> subList(int fromIndex, int toIndex) {
		return data.subList(fromIndex, toIndex);
	}

	@Override
	protected synchronized void removeRange(int fromIndex, int toIndex) {
		throw new UnsupportedOperationException();
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
	public ListIterator<E> listIterator(int index) {
		return data.listIterator(index);
	}
	
	
}

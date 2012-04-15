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

import java.util.ListIterator;

/**
 * @author Trung Phan
 *
 */
public final class ImmutableListIterator<E> implements ListIterator<E> {

	private final ListIterator<E> listIterator;
	
	public ImmutableListIterator(ListIterator<E> listIterator) {
		if (listIterator == null) {
			throw new NullPointerException();
		}
		this.listIterator = listIterator;
	}
	
	public void add(E arg0) {
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see java.util.ListIterator#hasNext()
	 */
	public boolean hasNext() {
		return listIterator.hasNext();
	}

	/* (non-Javadoc)
	 * @see java.util.ListIterator#hasPrevious()
	 */
	public boolean hasPrevious() {
		return listIterator.hasPrevious();
	}

	public E next() {
		return listIterator.next();
	}

	/* (non-Javadoc)
	 * @see java.util.ListIterator#nextIndex()
	 */
	public int nextIndex() {
		return listIterator.nextIndex();
	}

	/* (non-Javadoc)
	 * @see java.util.ListIterator#previous()
	 */
	public E previous() {
		return listIterator.previous();
	}

	/* (non-Javadoc)
	 * @see java.util.ListIterator#previousIndex()
	 */
	public int previousIndex() {
		return listIterator.previousIndex();
	}

	/* (non-Javadoc)
	 * @see java.util.ListIterator#remove()
	 */
	public void remove() {
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see java.util.ListIterator#set(java.lang.Object)
	 */
	public void set(E arg0) {
		throw new UnsupportedOperationException();
	}

}

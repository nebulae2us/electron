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

import java.util.Collection;
import java.util.Iterator;

/**
 * @author Trung Phan
 */
public abstract class AbstractImmutableCollection<E> implements Collection<E> {

    protected AbstractImmutableCollection() {

    }

    public Object[] toArray() {
        return new Object[0];  //To change body of implemented methods use File | Settings | File Templates.
    }

    public <T> T[] toArray(T[] a) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    public final boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    public boolean containsAll(Collection<?> c) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public final boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    public final boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    public final boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    public final void clear() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public String toString() {
        Iterator<E> i = iterator();
			if (! i.hasNext())
			    return "[]";
		
			StringBuilder sb = new StringBuilder();
			sb.append('[');
			for (;;) {
			    E e = i.next();
			    sb.append(e == this ? "(this Collection)" : e);
			    if (! i.hasNext())
				return sb.append(']').toString();
			    sb.append(", ");
			}
    }
    
}

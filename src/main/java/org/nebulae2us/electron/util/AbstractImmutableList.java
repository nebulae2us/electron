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
import java.util.List;

/**
 * @author Trung Phan
 */
public abstract class AbstractImmutableList<E> extends AbstractImmutableCollection<E> implements List<E> {

    protected AbstractImmutableList() {

    }

    public final boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    public final E set(int index, E element) {
        throw new UnsupportedOperationException();
    }

    public final void add(int index, E element) {
        throw new UnsupportedOperationException();
    }

    public final E remove(int index) {
        throw new UnsupportedOperationException();
    }

    public boolean equals(Object o) {
    	if (o == this) {
    		return true;
    	}
    	if ( !(o instanceof List)) {
    		return false;
    	}
    	
    	List<?> list = (List<?>)o;
    	if (size() != list.size()) {
    		return false;
    	}

		Iterator<E> e1 = iterator();
		Iterator<?> e2 = list.iterator();
		while(e1.hasNext() && e2.hasNext()) {
		    E o1 = e1.next();
		    Object o2 = e2.next();
		    
		    if (!(o1==null ? o2==null : o1.equals(o2))) {
				return false;
		    }
		}
		return !(e1.hasNext() || e2.hasNext());
    }
    
    @Override
    public int hashCode() {
    	int hashCode = 1;
    	Iterator<E> i = iterator();
    	while (i.hasNext()) {
    	    E obj = i.next();
    	    hashCode = 31*hashCode + (obj==null ? 0 : obj.hashCode());
    	}
    	return hashCode;
    }
}

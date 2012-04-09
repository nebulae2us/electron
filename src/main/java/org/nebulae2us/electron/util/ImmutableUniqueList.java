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

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

/**
 * 
 * @author Trung Phan
 * 
 */
public class ImmutableUniqueList<E> extends ImmutableList<E> {

	private static final long serialVersionUID = -5866251847193233328L;

	public ImmutableUniqueList() {
		super();
    }

	public ImmutableUniqueList(EqualityComparator<E> equalityComparator, E ... elements) {
        super(Arrays.asList(elements), equalityComparator, true);
    }
	
	public ImmutableUniqueList(Comparator<? super E> comparator, E ... elements) {
        super(Arrays.asList(elements), comparator, true);
    }
	
	public ImmutableUniqueList(E ... elements) {
		super(Arrays.asList(elements), ObjectEqualityComparator.getInstance(), true);
	}

    public ImmutableUniqueList(Collection<? extends E> c, EqualityComparator<E> equalityComparator) {
        super(c, equalityComparator, true);
    }
	
    public ImmutableUniqueList(Collection<? extends E> c, Comparator<? super E> comparator) {
        super(c, comparator, true);
    }

    public ImmutableUniqueList(Collection<? extends E> c) {
        super(c, ObjectEqualityComparator.getInstance(), true);
    }
    
    protected ImmutableUniqueList(ImmutableUniqueList<E> cloned, int fromIndex, int toIndex) {
    	super(cloned, fromIndex, toIndex);
    }
    
    protected ImmutableUniqueList(ImmutableUniqueList<E> cloned, boolean descending) {
    	super(cloned, descending);
    }

    
    @Override
    public ImmutableUniqueList<E> descendingList() {
        return new ImmutableUniqueList<E>(this, true);
    }
    
    @Override
    public ImmutableUniqueList<E> subList(int fromIndex, int toIndex) {
    	return new ImmutableUniqueList<E>(this, fromIndex, toIndex);
    }
}

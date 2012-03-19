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
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Trung Phan
 */
public class ImmutableSet<E> extends AbstractImmutableSet<E> implements Set<E> {

    private final ImmutableMap<E, ?> hashes;

    public ImmutableSet() {
    	this(Collections.EMPTY_LIST);
    }
    
    public ImmutableSet(Collection<E> c, EqualityComparator<E> equalityComparator) {
        hashes = new ImmutableMap<E, Object>(c, equalityComparator);
    }

    public ImmutableSet(Collection<E> c) {
        this(c, new ObjectEqualityComparator<E>());
    }

    public int size() {
        return hashes.size();
    }

    public boolean contains(Object o) {
        return hashes.containsKey(o);
    }

    public Iterator<E> iterator() {
        return hashes.keyIterator();
    }

}

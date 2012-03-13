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

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

/**
 * @author Trung Phan
 */
public class ImmutableSortedList<E> extends ImmutableList<E> {

	private static final long serialVersionUID = -788944480471939780L;

	public ImmutableSortedList(Comparator<? super E> comparator, E ... elements) {
        super(Arrays.asList(elements), comparator);
    }

    public ImmutableSortedList(Collection<? extends E> c, Comparator<? super E> comparator) {
        super(c, comparator);
    }

    private ImmutableSortedList(ImmutableList<E> l) {
        super(l);
    }

    @Override
    public ImmutableSortedList<E> descendingList() {
        return new ImmutableSortedList<E>(super.descendingList());
    }

    @Override
    public int binarySearch(Object o) {
        return super.binarySearch(o);
    }
}

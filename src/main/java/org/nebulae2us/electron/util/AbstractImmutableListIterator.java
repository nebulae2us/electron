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

import java.util.ListIterator;

/**
 * @author Trung Phan
 */
public abstract class AbstractImmutableListIterator<E> extends AbstractImmutableIterator<E> implements ListIterator<E> {

    protected AbstractImmutableListIterator() {}

    public final void set(E e) {
        throw new UnsupportedOperationException();
    }

    public final void add(E e) {
        throw new UnsupportedOperationException();
    }
}

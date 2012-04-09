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

import java.io.Serializable;

/**
 * @author Trung Phan
 */
public final class IdentityEqualityComparator implements EqualityComparator<Object>, Serializable {
	
	private static final long serialVersionUID = -3312476095589954550L;
	
	private final static IdentityEqualityComparator equalityComparator = new IdentityEqualityComparator();
	
	public static IdentityEqualityComparator getInstance() {
		return equalityComparator;
	}
	
	private IdentityEqualityComparator() {}
	
    public int hashCode(Object element) {
        return System.identityHashCode(element);
    }

    public boolean compare(Object element1, Object element2) {
        return element1 == element2;
    }

}

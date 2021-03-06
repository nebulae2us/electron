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
import java.util.HashSet;
import java.util.Set;

/**
 * @author Trung Phan
 *
 */
public class SetBuilder<E> {
	
	private Set<E> result = new HashSet<E>();
	
	public SetBuilder() {
		
	}
	
	public SetBuilder(E ...elements) {
		add(elements);
	}
	
	public SetBuilder<E> add(E ... elements) {
		if (elements != null) {
			for (E element : elements) {
				result.add(element);
			}
		}
		return this;
	}
	
	public SetBuilder<E> add(Collection<E> elements) {
		if (elements != null) {
			for (E element : elements) {
				result.add(element);
			}
		}
		return this;
	}
	
	public Set<E> toSet() {
		return new ImmutableSet<E>(result);
	}
	
	public Set<E> toMutableSet() {
		return result;
	}
}

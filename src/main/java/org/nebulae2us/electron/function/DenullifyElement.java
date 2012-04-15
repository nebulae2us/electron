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
package org.nebulae2us.electron.function;

import org.nebulae2us.electron.ElementContext;
import org.nebulae2us.electron.Function1;

/**
 * @author Trung Phan
 *
 */
public class DenullifyElement<E> implements Function1<E, ElementContext<E>> {

	private final E nullValue;
	
	public DenullifyElement(E nullValue) {
		if (nullValue == null) {
			throw new NullPointerException();
		}
		this.nullValue = nullValue;
	}
	
	public E execute(ElementContext<E> context) {
		return context.getElement() == null ? nullValue : context.getElement();
	}
	

}

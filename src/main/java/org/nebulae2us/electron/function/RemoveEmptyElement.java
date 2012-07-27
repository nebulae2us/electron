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

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

import org.nebulae2us.electron.ElementContext;
import org.nebulae2us.electron.Function1;

/**
 * @author Trung Phan
 *
 */
public class RemoveEmptyElement<E> implements Function1<E, ElementContext<E>> {

	public E execute(ElementContext<E> context) {
		E element = context.getElement();
		if (element == null ||
				(element instanceof String && ((String)element).length() == 0) ||
				(element instanceof StringBuilder && ((StringBuilder)element).length() == 0) ||
				(element instanceof StringBuffer && ((StringBuffer)element).length() == 0) ||
				(element instanceof Collection && ((Collection<?>)element).size() == 0) ||
				(element instanceof Map && ((Map<?,?>)element).size() == 0) ||
				(element.getClass().isArray() && Array.getLength(element) == 0)
			) {
			context.setAction(ElementContext.ACTION_SKIP_ELEMENT);
		}
		
		return element;
	}

	
	
}

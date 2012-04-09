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
public class SubstringElement<E> implements Function1<String, ElementContext<E>> {

	private final int fromIndex;
	
	private final int toIndex;
	
	public SubstringElement(int fromIndex, int toIndex) {
		this.fromIndex = fromIndex;
		this.toIndex = toIndex;
	}
	
	public String execute(ElementContext<E> context) {
		
		String element = context.getElement() != null ? context.getElement().toString() : "";

		int from = this.fromIndex;
		if (from < 0) {
			from = element.length() + from;
			if (from < 0)
				from = 0;
		}
		else if (from > element.length()) {
			from = element.length();
		}
		
		int to = this.toIndex;
		if (to < 0) {
			to = element.length() + 1 + to;
			if (to < 0) {
				to = 0;
			}
			if (to < from) {
				to = from;
			}
		}
		else if (to > element.length()) {
			to = element.length();
		}
		
		return element.substring(from, to);
	}

	

}

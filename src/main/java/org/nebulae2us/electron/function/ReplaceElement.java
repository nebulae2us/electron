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
public class ReplaceElement<E> implements Function1<String, ElementContext<E>> {

	private final String substring;
	
	private final String newString;
	
	private final int replacementCount;
	
	private final boolean reverse;
	
	public ReplaceElement(String substring, String newString, int replacementCount, boolean reverse) {
		if (substring == null) {
			throw new NullPointerException();
		}
		if (newString == null) {
			throw new NullPointerException();
		}
		this.substring = substring;
		this.newString = newString;
		this.replacementCount = replacementCount;
		this.reverse = reverse;
	}
	
	public String execute(ElementContext<E> context) {
		String element = context.getElement() == null ? "" : context.getElement().toString();
		return this.reverse ? replaceReverse(element) :
				replaceForward(element);
	}

	private String replaceForward(String element) {
		StringBuilder result = new StringBuilder();
		
		int length = substring.length();
		int count = this.replacementCount;

		String lastSegment = element;

		int index = -1;
		while ( count != 0 && lastSegment.length() > 0 &&
				(index = lastSegment.indexOf(this.substring)) > -1) {
			
			if (index > 0) {
				result.append(lastSegment.subSequence(0, index));
			}

			result.append(newString);

			lastSegment = lastSegment.substring(index + length);
			
			if (count > 0)
				count--;
		}
		
		return result.toString();
	}

	private String replaceReverse(String element) {

		StringBuilder result = new StringBuilder();
		
		int length = substring.length();
		int count = this.replacementCount;

		String lastSegment = element;

		int index = -1;
		while ( count != 0 && lastSegment.length() > 0 &&
				(index = lastSegment.lastIndexOf(this.substring)) > -1) {
			
			result.insert(0, newString + lastSegment.substring(index + length));

			lastSegment = lastSegment.substring(0, index);
			
			if (count > 0)
				count--;
		}
		
		return result.toString();
	}
	
}

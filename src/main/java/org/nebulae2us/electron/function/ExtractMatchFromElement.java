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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.nebulae2us.electron.ElementContext;
import org.nebulae2us.electron.Function1;

/**
 * @author Trung Phan
 *
 */
public class ExtractMatchFromElement<E> implements Function1<String, ElementContext<E>> {

	private final Pattern pattern;
	
	private final int group;
	
	public ExtractMatchFromElement(Pattern pattern, int group) {
		if (pattern == null) {
			throw new NullPointerException();
		}
		if (group < 0) {
			throw new IllegalArgumentException();
		}
		
		this.pattern = pattern;
		this.group = group;
	}
	
	
	public String execute(ElementContext<E> context) {
		
		E element = context.getElement();
		
		if (element == null) {
			return null;
		}
		
		Matcher matcher = pattern.matcher(element.toString());
		
		if (matcher.matches()) {
			if (group > matcher.groupCount()) {
				return null;
			}
			return matcher.group(group);
		}

		return null;
	}

}

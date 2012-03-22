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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.nebulae2us.electron.Function;

/**
 * 
 * @author Trung Phan
 *
 */
public class ReverseListFunction<E> implements Function<List<E>> {

	@SuppressWarnings("unchecked")
	public List<E> execute(Object... arguments) {
		List<E> originalList = (List<E>)arguments[0];
		List<E> newList = new ArrayList<E>(originalList);
		Collections.reverse(newList);
		return newList;
	}
	
}

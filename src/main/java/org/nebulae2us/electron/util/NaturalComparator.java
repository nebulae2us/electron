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

import java.util.Comparator;

/**
 * 
 * @author Trung Phan
 *
 */
public class NaturalComparator implements Comparator<Object> {

	private NaturalComparator() {
	}
	
	private static final NaturalComparator instance = new NaturalComparator();
	
	public static NaturalComparator getInstance() {
		return instance;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public int compare(Object e1, Object e2) {
		if (!(e1 instanceof Comparable)) {
			throw new IllegalArgumentException("Elements are not comparable.");
		}
		if (!(e2 instanceof Comparable)) {
			throw new IllegalArgumentException("Elements are not comparable.");
		}
		Comparable c1 = (Comparable) e1;
		return c1.compareTo(e2);
	}

}

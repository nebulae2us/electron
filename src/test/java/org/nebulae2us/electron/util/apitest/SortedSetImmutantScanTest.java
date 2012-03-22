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
package org.nebulae2us.electron.util.apitest;

import java.util.NavigableSet;

/**
 * 
 * @author Trung Phan
 *
 */
public class SortedSetImmutantScanTest<E> extends SetImmutantScanTest<E> {

	private final NavigableSet<E> control;
	private final NavigableSet<E> test;
	
	public SortedSetImmutantScanTest(Class<E> elementClass,
			NavigableSet<E> control, NavigableSet<E> test) {

		super(elementClass, control, test);

		this.control = control;
		this.test = test;
	}
	
	@Override
	public void runTests() {
		super.runTests();
	}
	
	

}

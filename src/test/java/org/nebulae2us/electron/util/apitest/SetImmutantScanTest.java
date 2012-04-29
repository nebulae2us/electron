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

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Set;

/**
 * 
 * @author Trung Phan
 *
 */
public class SetImmutantScanTest<E> extends CollectionImmutantScanTest<E> {

	private final Set<E> control;
	private final Set<E> test;
	
	public SetImmutantScanTest(Class<E> elementClass, Set<E> control, Set<E> test) {
		super(elementClass, control, test);
		this.control = control;
		this.test = test;
	}
	
	@Override
	public void runTests() {
		super.runTests();
		
		testImmutantFunctionality();
	}
	
	private void testImmutantFunctionality() {
		assertTrue(control.equals(test));
		assertTrue(test.equals(control));
		testToArray();
	}
	
	public void testToArray() {
		Object[] testArray = test.toArray();
		assertEquals(control.size(), testArray.length);
		assertTrue(control.containsAll(Arrays.asList(testArray)));
		
		E[] testArray2 = test.toArray((E[])new Object[0]);
		assertEquals(control.size(), testArray2.length);
		assertTrue(control.containsAll(Arrays.asList(testArray2)));
	}	
}

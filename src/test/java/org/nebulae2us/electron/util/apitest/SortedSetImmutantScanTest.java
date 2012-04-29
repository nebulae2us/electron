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

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;

/**
 * 
 * @author Trung Phan
 *
 */
public class SortedSetImmutantScanTest<E> extends SetImmutantScanTest<E> {

	private final NavigableSet<E> control;
	private final NavigableSet<E> test;
	private final boolean testInverse;
	
	public SortedSetImmutantScanTest(Class<E> elementClass, NavigableSet<E> control, NavigableSet<E> test) {
		this(elementClass, control, test, true);
	}	
	public SortedSetImmutantScanTest(Class<E> elementClass, NavigableSet<E> control, NavigableSet<E> test, boolean testInverse) {
		super(elementClass, control, test);

		this.control = control;
		this.test = test;
		this.testInverse = testInverse;
	}
	
	@Override
	public void runTests() {
		super.runTests();
		testImmutableFunctionality();
		
		if (this.testInverse) {
			new SortedSetImmutantScanTest<E>(elementClass, control.descendingSet(), test.descendingSet(), false).runTests();
		}
	}
	
	private void testImmutableFunctionality() {
		testDescendingIterator();
	}
	
	private void testDescendingIterator() {
		Iterator<E> iControl = control.descendingIterator();
		Iterator<E> iTest = test.descendingIterator();
		
		while (iControl.hasNext()) {
			assertTrue(iTest.hasNext());
			
			assertEquals(iControl.next(), iTest.next());
			
		}
		assertFalse(iTest.hasNext());
		
		try {
			iControl.next();
			fail();
		}
		catch(Exception ex) {
			assertTrue(ex instanceof NoSuchElementException);
		}
		
		try {
			iTest.next();
			fail();
		}
		catch(Exception ex) {
			assertTrue(ex instanceof NoSuchElementException);
		}		
	}
}

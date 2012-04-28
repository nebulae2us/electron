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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author Trung Phan
 *
 */
public class CollectionImmutantScanTest<E> {

	protected final Class<E> elementClass;
	
	private final Collection<E> control;
	
	private final Collection<E> test;
	
	public CollectionImmutantScanTest(Class<E> elementClass, Collection<E> control, Collection<E> test) {
		this.elementClass = elementClass;
		this.control = control;
		this.test = test;
	}
	
	public void runTests() {
		testImmutantFunctionality();
	}
	
	private void testImmutantFunctionality() {
		assertEquals(control.size(), test.size());
		assertEquals(control.isEmpty(), test.isEmpty());
		assertTrue(control.containsAll(test));
		assertTrue(test.containsAll(control));
		testContains();

		testIterator();
	}

	private void testContains() {
		for (E e : control) {
			assertTrue(test.contains(e));
		}
		for (E e : test) {
			assertTrue(test.contains(e));
			assertTrue(control.contains(e));
		}
	}
	
	private void testIterator() {
		
		Iterator<E> iControl = control.iterator();
		Iterator<E> iTest = test.iterator();
		
		while (iControl.hasNext()) {
			assertTrue(iTest.hasNext());
			
			iControl.next();
			iTest.next();
			
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

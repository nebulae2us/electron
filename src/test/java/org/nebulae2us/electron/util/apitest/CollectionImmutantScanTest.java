package org.nebulae2us.electron.util.apitest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

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
		assertTrue(control.equals(test));
		assertTrue(test.equals(control));
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

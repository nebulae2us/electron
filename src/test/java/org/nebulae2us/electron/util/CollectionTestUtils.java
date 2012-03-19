package org.nebulae2us.electron.util;

import java.util.Collection;
import java.util.Iterator;

import static org.junit.Assert.*;

public class CollectionTestUtils {


	public static <E> void assertCollectionFunctionality(Class<E> elementClass, Collection<E> control, Collection<E> test) {
		
		testImmutantFunctionality(elementClass, control, test);

	}

	private static <E> void testImmutantFunctionality(Class<E> elementClass, Collection<E> control, Collection<E> test) {
		assertEquals(control.size(), test.size());
		assertEquals(control.isEmpty(), test.isEmpty());
		assertTrue(control.equals(test));
		assertTrue(test.equals(control));
		assertTrue(control.containsAll(test));
		assertTrue(test.containsAll(control));
		testContains(control, test);

		testIterator(control, test);
		
	}
	
	private static <E> void testContains(Collection<E> control, Collection<E> test) {
		for (E e : control) {
			assertTrue(test.contains(e));
		}
		for (E e : test) {
			assertTrue(test.contains(e));
			assertTrue(control.contains(e));
		}
	}
	
	private static <E> void testIterator(Collection<E> control, Collection<E> test) {
		
		Iterator<E> iControl = control.iterator();
		Iterator<E> iTest = test.iterator();
		
		while (iControl.hasNext()) {
			assertTrue(iTest.hasNext());
			
			iControl.next();
			iTest.next();
			
		}
		assertFalse(iTest.hasNext());
		
		Exception exControl = null;
		try {
			iControl.next();
			fail();
		}
		catch(Exception ex) {
			exControl = ex;
		}
		
		Exception exTest = null;
		try {
			iTest.next();
			fail();
		}
		catch(Exception ex) {
			exTest = ex;
		}
		
		assertTrue(exControl.getClass() == exTest.getClass());
		
		
	}
	
	
}

package org.nebulae2us.electron.util;

import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.nebulae2us.electron.Function;

import static org.nebulae2us.electron.util.CollectionTestUtils.*;

public class ListTestUtils {

	
	public static <E> void assertFunctionality(Class<E> elementClass, List<E> control, Function<List<E>> reverseControl, List<E> test, Function<List<E>> reverseTest) {
		
		testImmutantFunctionality(elementClass, control, test);
		testImmutantFunctionality(elementClass, reverseControl.execute(control), reverseTest.execute(test));
		testSubList(elementClass, control, reverseControl, test, reverseTest);

	}

	private static <E> void testImmutantFunctionality(Class<E> elementClass, List<E> control, List<E> test) {
		
		assertCollectionFunctionality(elementClass, control, test);
		
		testToArray(elementClass, control, test);
		testListIterator(control, test);
		testListIteratorWithIndex(control, test);
		testIndexOf(control, test);
		testLastIndexOf(control, test);
		testGet(control, test);
		
		testIterator(control, test);
		
	}

	public static <E> void testSubList(Class<E> elementClass, List<E> control, Function<List<E>> reverseControl, List<E> test, Function<List<E>> reverseTest) {
		
		int size = control.size();
		
		if (size > 0) {
			for (int i = 0; i < size; i++) {
				for (int j = i; j < size + 1; j++) {
					if (i == j || size == 0 || ( i == 0 && j == size)) {
						testImmutantFunctionality(elementClass, control.subList(i, j), test.subList(i, j));
					}
					else {
						assertFunctionality(elementClass, control.subList(i, j), reverseControl, test.subList(i, j), reverseTest);
					}
				}
			}
		}
		
	}
	
	
	
	private static <E> void testGet(List<E> control, List<E> test) {
		for (int i = -2; i < control.size(); i++) {
			Exception exControl = null;
			Exception exTest = null;
			
			E eControl = null;
			try {
				eControl = control.get(i);
			}
			catch (Exception ex) {
				exControl = ex;
			}
			
			E eTest = null;
			try {
				eTest = test.get(i);
			}
			catch (Exception ex) {
				exTest = ex;
			}
			
			if (exControl != null) {
				assertNotNull(exTest);
				assertTrue(exControl instanceof IndexOutOfBoundsException);
				assertTrue(exTest instanceof IndexOutOfBoundsException);
			}
			else {
				assertNull(exTest);
				assertNotNull(eControl);
				assertNotNull(eTest);
				
				assertEquals(eControl, eTest);
				
			}
		}
	}
	
	private static <E> void testIndexOf(List<E> control, List<E> test) {
		int idx = 0;
		for (int i = -1000; i < 1000; i++) {
			try {
				idx = test.indexOf(i);
				assertEquals("i: " + i + " of " + test.toString(), control.indexOf(i), idx);
			}
			catch (ClassCastException ex) {}

			try {
				idx = test.indexOf((long)i);
				assertEquals(control.indexOf((long)i), idx);
			}
			catch (ClassCastException ex) {}
			
			try {
				idx = test.indexOf((short)i);
				assertEquals(control.indexOf((short)i), idx);
			}
			catch (ClassCastException ex) {}

			try {
				idx = test.indexOf((byte)i);
				assertEquals(control.indexOf((byte)i), idx);
			}
			catch (ClassCastException ex) {}
	
			try {
				idx = test.indexOf((double)i);
				assertEquals(control.indexOf((double)i), idx);
			}
			catch (ClassCastException ex) {}

			try {
				idx = test.indexOf((double)(i+0.5));
				assertEquals(control.indexOf((double)(i+0.5)), idx);
			}
			catch (ClassCastException ex) {}

			try {
				idx = test.indexOf((float)i);
				assertEquals(control.indexOf((float)i), idx);
			}
			catch (ClassCastException ex) {}

			try {
				idx = test.indexOf((float)(i+0.5));
				assertEquals(control.indexOf((float)(i+0.5)), idx);
			}
			catch (ClassCastException ex) {}
			
			try {
				idx = test.indexOf("s" + i);
				assertEquals(control.indexOf("s" + i), idx);
			}
			catch (ClassCastException ex) {}
		}
	}

	private static <E> void testLastIndexOf(List<E> control, List<E> test) {
		int idx = 0;
		for (int i = -1000; i < 1000; i++) {
			try {
				idx = test.lastIndexOf(i);
				assertEquals("i: " + i, control.lastIndexOf(i), idx);
			}
			catch (ClassCastException ex) {}

			try {
				idx = test.lastIndexOf((long)i);
				assertEquals(control.lastIndexOf((long)i), idx);
			}
			catch (ClassCastException ex) {}
			
			try {
				idx = test.lastIndexOf((short)i);
				assertEquals(control.lastIndexOf((short)i), idx);
			}
			catch (ClassCastException ex) {}

			try {
				idx = test.lastIndexOf((byte)i);
				assertEquals(control.lastIndexOf((byte)i), idx);
			}
			catch (ClassCastException ex) {}
	
			try {
				idx = test.lastIndexOf((double)i);
				assertEquals(control.lastIndexOf((double)i), idx);
			}
			catch (ClassCastException ex) {}

			try {
				idx = test.lastIndexOf((double)(i+0.5));
				assertEquals(control.lastIndexOf((double)(i+0.5)), idx);
			}
			catch (ClassCastException ex) {}

			try {
				idx = test.lastIndexOf((float)i);
				assertEquals(control.lastIndexOf((float)i), idx);
			}
			catch (ClassCastException ex) {}

			try {
				idx = test.lastIndexOf((float)(i+0.5));
				assertEquals(control.lastIndexOf((float)(i+0.5)), idx);
			}
			catch (ClassCastException ex) {}
			
			try {
				idx = test.lastIndexOf("s" + i);
				assertEquals(control.lastIndexOf("s" + i), idx);
			}
			catch (ClassCastException ex) {}
		}
	}

	@SuppressWarnings("unchecked")
	public static <E> void testToArray(Class<E> elementClass, Collection<E> control, Collection<E> test) {
		
		assertArrayEquals(control.toArray(), test.toArray());
		assertArrayEquals(control.toArray(new Object[0]), test.toArray(new Object[0]));
		assertArrayEquals(control.toArray(new Object[control.size()]), test.toArray(new Object[control.size()]));
		assertArrayEquals(control.toArray((E[])Array.newInstance(elementClass, control.size()) ), test.toArray((E[])Array.newInstance(elementClass, control.size()) ));
		assertArrayEquals(control.toArray((E[])Array.newInstance(elementClass, 0) ), test.toArray((E[])Array.newInstance(elementClass, 0) ));
	}
	
	private static <E> void testIterator(Collection<E> control, Collection<E> test) {
		
		Iterator<E> iControl = control.iterator();
		Iterator<E> iTest = test.iterator();
		
		while (iControl.hasNext()) {
			assertTrue(iTest.hasNext());
			
			assertEquals(iControl.next(), iTest.next());
			
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
	
	private static <E> void testListIterator(List<E> control, List<E> test) {
		
		ListIterator<E> iControl = control.listIterator();
		ListIterator<E> iTest = test.listIterator();

		assertFalse(iControl.hasPrevious());
		assertFalse(iTest.hasPrevious());
		
		assertEquals(iControl.previousIndex(), iTest.previousIndex());
		assertEquals(iControl.nextIndex(), iTest.nextIndex());
		
		while (iControl.hasNext()) {
			assertTrue(iTest.hasNext());

			E eControl = iControl.next();
			E eTest = iTest.next();

			assertEquals(iControl.previousIndex(), iTest.previousIndex());
			assertEquals(iControl.nextIndex(), iTest.nextIndex());
			
			assertEquals(eControl, eTest);
		}
		assertFalse(iTest.hasNext());

		assertEquals(iControl.previousIndex(), iTest.previousIndex());
		assertEquals(iControl.nextIndex(), iTest.nextIndex());
		
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
		
		while (iControl.hasPrevious()) {
			assertTrue(iTest.hasPrevious());

			E eControl = iControl.previous();
			E eTest = iTest.previous();

			assertEquals(iControl.previousIndex(), iTest.previousIndex());
			assertEquals(iControl.nextIndex(), iTest.nextIndex());
			
			assertEquals(eControl, eTest);
		}
		assertFalse(iTest.hasPrevious());
		
		exControl = null;
		try {
			iControl.previous();
			fail();
		}
		catch(Exception ex) {
			exControl = ex;
		}
		
		exTest = null;
		try {
			iTest.previous();
			fail();
		}
		catch(Exception ex) {
			exTest = ex;
		}
		
		assertTrue(exControl.getClass() == exTest.getClass());
		
		
	}

	private static <E> void testListIteratorWithIndex(List<E> control, List<E> test) {
		
		for (int i = -2; i < control.size() + 2; i++) {
			Exception exControl = null;
			Exception exTest = null;
			
			ListIterator<E> iControl = null;
			try {
				iControl = control.listIterator(i);
			}
			catch (Exception ex) {
				exControl = ex;
			}
			
			ListIterator<E> iTest = null;
			try {
				iTest = test.listIterator(i);
			}
			catch (Exception ex) {
				exTest = ex;
			}
			
			if (exControl != null) {
				assertNotNull(exTest);
				assertEquals(exControl.getClass(), exTest.getClass());
			}
			else {
				assertNull(exTest);
				assertNotNull(iControl);
				assertNotNull(iTest);
				
				assertEquals(iControl.hasPrevious(), iTest.hasPrevious());
				assertEquals(iControl.previousIndex(), iTest.previousIndex());
				assertEquals(iControl.hasNext(), iTest.hasNext());
				assertEquals(iControl.nextIndex(), iTest.nextIndex());
				
				if (iControl.hasNext()) {
					assertEquals(iControl.next(), iTest.next());
					assertTrue(iControl.hasPrevious());
					assertTrue(iTest.hasPrevious());
					assertEquals(iControl.previous(), iTest.previous());
				}
				
				if (iControl.hasPrevious()) {
					assertEquals(iControl.previous(), iTest.previous());
					assertTrue(iControl.hasNext());
					assertTrue(iTest.hasNext());
					assertEquals(iControl.next(), iTest.next());
				}
				
			}
			
			
		}
		
	}
	
}

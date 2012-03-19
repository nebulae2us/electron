package org.nebulae2us.electron.util;

import static org.nebulae2us.electron.util.SetTestUtils.*;

import java.util.NavigableSet;

public class SortedSetTestUtils {

	public static <E> void assertSortedSetFunctionality(Class<E> elementClass, NavigableSet<E> control, NavigableSet<E> test) {
		
		testImmutantFunctionality(elementClass, control, test);

	}
	
	private static <E> void testImmutantFunctionality(Class<E> elementClass, NavigableSet<E> control, NavigableSet<E> test) {
		assertSetFunctionality(elementClass, control, test);
		
	
	}

	
	
	
}

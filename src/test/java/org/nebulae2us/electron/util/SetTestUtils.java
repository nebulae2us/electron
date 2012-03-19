package org.nebulae2us.electron.util;

import java.util.Set;

import static org.nebulae2us.electron.util.CollectionTestUtils.assertCollectionFunctionality;

public class SetTestUtils {

	public static <E> void assertSetFunctionality(Class<E> elementClass, Set<E> control, Set<E> test) {
		
		testImmutantFunctionality(elementClass, control, test);

	}
	
	private static <E> void testImmutantFunctionality(Class<E> elementClass, Set<E> control, Set<E> test) {
		assertCollectionFunctionality(elementClass, control, test);

	
	}
	
	
	
}

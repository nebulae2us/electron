package org.nebulae2us.electron.util;

import java.util.Arrays;
import java.util.NavigableSet;
import java.util.TreeSet;

import org.junit.Test;
import org.nebulae2us.electron.util.apitest.SortedSetImmutantScanTest;

public class SortedSetFunctionalityTest {

	@Test
	public void immutable_sorted_set_of_integer() {
		
		NavigableSet<Integer> control = new TreeSet<Integer>(Arrays.asList(3, 7, 5, 9));
		ImmutableSortedSet<Integer> test = new ImmutableSortedSet<Integer>(Arrays.asList(3, 7, 5, 5, 7, 9));
		
		new SortedSetImmutantScanTest<Integer>(Integer.class,
				control,
				test).runTests();
	}
	
	
	
}

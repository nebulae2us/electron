package org.nebulae2us.electron.util;

import java.util.Arrays;
import java.util.NavigableSet;
import java.util.TreeSet;

import org.junit.Test;

import static org.nebulae2us.electron.util.SortedSetTestUtils.*;

public class SortedSetFunctionalityTest {

	@Test
	public void immutable_sorted_set_of_integer() {
		
		NavigableSet<Integer> control = new TreeSet<Integer>(Arrays.asList(3, 7, 5, 9));
		ImmutableSortedUniqueList<Integer> test = new ImmutableSortedUniqueList<Integer>(Arrays.asList(3, 7, 5, 5, 7, 9));
		
		assertSortedSetFunctionality(Integer.class,
				control,
				test);		
	}
	
	
	
}

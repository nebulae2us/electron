package org.nebulae2us.electron.util;

import static org.nebulae2us.electron.util.SetTestUtils.assertSetFunctionality;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class SetFunctionalityTest {
	
	@Test
	public void immutable_set_of_integer() {
		
		Set<Integer> control = new HashSet<Integer>(Arrays.asList(3, 7, 5, 9));
		ImmutableSet<Integer> test = new ImmutableSet<Integer>(Arrays.asList(3, 7, 5, 5, 7, 9));
		
		assertSetFunctionality(Integer.class,
				control,
				test);		
	}

}

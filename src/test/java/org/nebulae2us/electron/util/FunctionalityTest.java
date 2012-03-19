package org.nebulae2us.electron.util;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.nebulae2us.electron.util.CollectionTestUtils.*;

public class FunctionalityTest {

	
	
	
	@Test
	public void immutable_sorted_unique_list_of_integer() {
		
		List<Integer> control = Arrays.asList(3, 5, 7, 9);
		ImmutableSortedUniqueList<Integer> test = new ImmutableSortedUniqueList<Integer>(control);
		
		assertFunctionality(Integer.class,
				control,
				new ReverseListFunction<Integer>(),
				test,
				new ReverseImmutableListFunction<Integer>());
		
		
	}
	
	
	@Test
	public void immutable_sorted_unique_list_of_string() {
		
		List<String> control = Arrays.asList("s3", "s5", "s7", "s9");
		ImmutableSortedUniqueList<String> test = new ImmutableSortedUniqueList<String>(control);
		
		assertFunctionality(String.class,
				control,
				new ReverseListFunction<String>(),
				test,
				new ReverseImmutableListFunction<String>());
		
		
	}
	
	@Test
	public void immutable_list_of_integer() {
		
		List<Integer> control = Arrays.asList(3, 7, 5, 5, 7, 9);
		ImmutableList<Integer> test = new ImmutableList<Integer>(control);
		
		assertFunctionality(Integer.class,
				control,
				new ReverseListFunction<Integer>(),
				test,
				new ReverseImmutableListFunction<Integer>());
		
		
	}
	
	
	@Test
	public void immutable_list_of_string() {
		
		List<String> control = Arrays.asList("s3", "s7", "s5", "s5", "s7", "s9");
		ImmutableList<String> test = new ImmutableList<String>(control);
		
		assertFunctionality(String.class,
				control,
				new ReverseListFunction<String>(),
				test,
				new ReverseImmutableListFunction<String>());
		
		
	}
	

	
}

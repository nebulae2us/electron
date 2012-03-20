package org.nebulae2us.electron.util;

import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableSortedSetTest {

	@Test
	public void must_remove_dup_value() {
		
		ImmutableSortedSet<Integer> fixture = new ImmutableSortedSet<Integer>(1, 3, 3, 5);
		
		assertEquals(3, fixture.size());
		assertEquals(Arrays.asList(1, 3, 5), fixture);
	}
	
	@Test
	public void floor() {
		
		ImmutableSortedSet<Integer> fixture = new ImmutableSortedSet<Integer>(1, 3, 5);
		
		assertEquals(Integer.valueOf(3), fixture.floor(3));
		assertEquals(Integer.valueOf(3), fixture.floor(4));
		assertEquals(Integer.valueOf(5), fixture.floor(6));
		assertEquals(Integer.valueOf(5), fixture.floor(5));
		assertEquals(Integer.valueOf(1), fixture.floor(1));
		assertEquals(Integer.valueOf(1), fixture.floor(2));
		assertNull(fixture.floor(0));
		
	}

	@Test
	public void lower() {
		
		ImmutableSortedSet<Integer> fixture = new ImmutableSortedSet<Integer>(1, 3, 5);
		
		assertNull(fixture.lower(0));
		assertNull(fixture.lower(1));
		assertEquals(Integer.valueOf(1), fixture.lower(2));
		assertEquals(Integer.valueOf(1), fixture.lower(3));
		assertEquals(Integer.valueOf(3), fixture.lower(4));
		assertEquals(Integer.valueOf(3), fixture.lower(5));
		assertEquals(Integer.valueOf(5), fixture.lower(6));
		
	}
	
	@Test
	public void higher() {
		
		ImmutableSortedSet<Integer> fixture = new ImmutableSortedSet<Integer>(1, 3, 5);
		
		assertEquals(Integer.valueOf(1), fixture.higher(0));
		assertEquals(Integer.valueOf(3), fixture.higher(1));
		assertEquals(Integer.valueOf(3), fixture.higher(2));
		assertEquals(Integer.valueOf(5), fixture.higher(3));
		assertEquals(Integer.valueOf(5), fixture.higher(4));
		assertNull(fixture.higher(5));
		assertNull(fixture.higher(6));
		
	}

	@Test
	public void ceiling() {
		
		ImmutableSortedSet<Integer> fixture = new ImmutableSortedSet<Integer>(1, 3, 5);
		
		assertEquals(Integer.valueOf(1), fixture.ceiling(0));
		assertEquals(Integer.valueOf(1), fixture.ceiling(1));
		assertEquals(Integer.valueOf(3), fixture.ceiling(2));
		assertEquals(Integer.valueOf(3), fixture.ceiling(3));
		assertEquals(Integer.valueOf(5), fixture.ceiling(4));
		assertEquals(Integer.valueOf(5), fixture.ceiling(5));
		assertNull(fixture.ceiling(6));
		
	}
	
}

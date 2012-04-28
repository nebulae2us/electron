package org.nebulae2us.electron.util;

import java.util.Map;
import java.util.TreeMap;

import org.junit.*;
import org.nebulae2us.electron.util.apitest.SortedMapImmutantScanTest;

import static org.junit.Assert.*;

/**
 *
 */
public class ImmutableSortedMapTest {

	private <K> void scan(Class<K> keyClass, K ... keys) {

		TreeMap<K, Object> control = new TreeMap<K, Object>();
		for (K key : keys) {
			control.put(key, new Object());
		}
		
		new SortedMapImmutantScanTest<K, Object>(keyClass, Object.class, control, new ImmutableSortedMap<K, Object>(control)).runTests();
	}
	
	@Test
	public void scan_immutant_methods_of_lists() {
		scan(Integer.class);
		scan(Integer.class, 3, 7, 5, 5, 7, 9, 3, 2, 53, 41, 12, 15);
		scan(String.class, "s3", "s7", "s5", "s7", "s9", "s4", "s15", "s82", "s2", "s8");
	}

	
}
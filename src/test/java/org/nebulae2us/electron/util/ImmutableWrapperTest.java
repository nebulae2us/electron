/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nebulae2us.electron.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

import org.junit.Test;
import org.nebulae2us.electron.util.apitest.ListImmutantScanTest;
import org.nebulae2us.electron.util.apitest.MapImmutantScanTest;
import org.nebulae2us.electron.util.apitest.SetImmutantScanTest;
import org.nebulae2us.electron.util.apitest.SortedMapImmutantScanTest;
import org.nebulae2us.electron.util.apitest.SortedSetImmutantScanTest;

/**
 * @author Trung Phan
 *
 */
public class ImmutableWrapperTest {

	private <E> void scanList(Class<E> elementClass, E ... elements) {

		List<E> control = new ArrayList<E>(Arrays.asList(elements));
		
		new ListImmutantScanTest<E>(elementClass, control, null, new ImmutableArrayList<E>(control), null).runTests();

		control = new LinkedList<E>(Arrays.asList(elements));

		new ListImmutantScanTest<E>(elementClass, control, null, new ImmutableLinkedList<E>(control), null).runTests();
		
		control = new Vector<E>(Arrays.asList(elements));

		new ListImmutantScanTest<E>(elementClass, control, null, new ImmutableVector<E>(control), null).runTests();
		
		Set<E> controlSet = new HashSet<E>(Arrays.asList(elements));
		
		new SetImmutantScanTest<E>(elementClass, controlSet, new ImmutableHashSet<E>(Arrays.asList(elements))).runTests();

		controlSet = new LinkedHashSet<E>(Arrays.asList(elements));
		
		new SetImmutantScanTest<E>(elementClass, controlSet, new ImmutableLinkedHashSet<E>(Arrays.asList(elements))).runTests();
	
	}
	
	@Test
	public void scan_immutant_methods_of_lists() {
		scanList(Object.class);
		scanList(Integer.class, 3, 7, 5, 5, 7, 9, 3, 2);
		scanList(String.class, "s3", "s7", "s5", "s7", "s9", "s4");
		scanList(Object.class, new Object(), new Object(), new Object(), new Object(), new Object(), new Object());
	}

	private <E> void scanSortedSet(Class<E> elementClass, E ... elements) {
		NavigableSet<E> controlSortedSet = new TreeSet<E>(Arrays.asList(elements));
		new SortedSetImmutantScanTest<E>(elementClass, controlSortedSet, new ImmutableTreeSet<E>(elements)).runTests();
	}	

	@Test
	public void scan_immutant_methods_of_sorted_sets() {
		scanSortedSet(Integer.class);
		scanSortedSet(Integer.class, 3, 7, 5, 5, 7, 9, 3, 2);
		scanSortedSet(String.class, "s3", "s7", "s5", "s7", "s9", "s4");
	}
	
	private <K> void scanMap(Class<K> keyClass, K ... keys) {
		
		Map<K, Object> controlMap = new HashMap<K, Object>();
		for (K key : keys) {
			controlMap.put(key, new Object());
		}
		
		new MapImmutantScanTest<K, Object>(keyClass, Object.class, controlMap, new ImmutableHashMap<K, Object>(controlMap)).runTests();

		controlMap = new LinkedHashMap<K, Object>();
		for (K key : keys) {
			controlMap.put(key, new Object());
		}
		
		new MapImmutantScanTest<K, Object>(keyClass, Object.class, controlMap, new ImmutableLinkedHashMap<K, Object>(controlMap)).runTests();
	
		controlMap = new IdentityHashMap<K, Object>();
		for (K key : keys) {
			controlMap.put(key, new Object());
		}
		
		new MapImmutantScanTest<K, Object>(keyClass, Object.class, controlMap, new ImmutableIdentityHashMap<K, Object>(controlMap)).runTests();
	
	}	
	
	@Test
	public void scan_immutant_methods_of_map() {
		scanMap(Object.class);
		scanMap(Integer.class, 3, 7, 5, 5, 7, 9, 3, 2);
		scanMap(String.class, "s3", "s7", "s5", "s7", "s9", "s4");
		scanMap(Object.class, new Object(), new Object(), new Object(), new Object(), new Object(), new Object());
	}

	private <K> void scanSortedMap(Class<K> keyClass, K ... keys) {
		
		Map<K, Object> map = new HashMap<K, Object>();
		for (K key : keys) {
			map.put(key, new Object());
		}
		
		NavigableMap<K, Object> controlMap = new TreeMap<K, Object>(map);
		
		new SortedMapImmutantScanTest<K, Object>(keyClass, Object.class, controlMap, new ImmutableTreeMap<K, Object>(map)).runTests();
	}	
	
	@Test
	public void scan_immutant_methods_of_sorted_map() {
		scanSortedMap(Integer.class);
		scanSortedMap(Integer.class, 3, 7, 5, 5, 7, 9, 3, 2);
		scanSortedMap(String.class, "s3", "s7", "s5", "s7", "s9", "s4");
	}
}

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
package org.nebulae2us.electron.util.apitest;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.Map.Entry;

/**
 * @author Trung Phan
 *
 */
public class MapImmutantScanTest<K, V> {

	protected final Class<K> keyClass;
	
	protected final Class<V> valueClass;
	
	private final Map<K, V> control;

	private final Map<K, V> test;
	
	public MapImmutantScanTest(Class<K> keyClass, Class<V> valueClass, Map<K, V> control, Map<K, V> test) {
		this.control = control;
		this.test = test;
		this.keyClass = keyClass;
		this.valueClass = valueClass;
	}
	
	public void runTests() {
		testImmutantFunctionality();
	}

	private void testImmutantFunctionality() {
		assertEquals(control.size(), test.size());
		assertEquals(control.isEmpty(), test.isEmpty());
		assertEquals(control, test);
		assertEquals(test, control);

		new SetImmutantScanTest<K>(keyClass, control.keySet(), test.keySet()).runTests();
		new CollectionImmutantScanTest<V>(valueClass, control.values(), test.values()).runTests();
		
		testContains();
		testGet();
	}
	

	private void testGet() {
		for (Entry<K, V> entry : control.entrySet()) {
			assertTrue(test.get(entry.getKey()) == control.get(entry.getKey()));
		}

		assertNull(test.get(new Object()));
		
		try {
			// this should either throw NullPointerException or return null
			assertNull(test.get(null));
		}
		catch (NullPointerException e) {}
	}

	private void testContains() {
		
		for (Entry<K, V> entry : control.entrySet()) {
			assertTrue(test.containsKey(entry.getKey()));
			assertTrue(test.containsValue(entry.getValue()));
		}
		for (Entry<K, V> entry : test.entrySet()) {
			assertTrue(test.containsKey(entry.getKey()));
			assertTrue(test.containsValue(entry.getValue()));
			assertTrue(control.containsKey(entry.getKey()));
			assertTrue(control.containsValue(entry.getValue()));
		}
	}

}

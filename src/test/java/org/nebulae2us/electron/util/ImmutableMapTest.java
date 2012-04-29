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

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.nebulae2us.electron.util.apitest.MapImmutantScanTest;

/**
 * @author Trung Phan
 *
 */
public class ImmutableMapTest {

	private <K> void scan(Class<K> keyClass, K ... keys) {

		Map<K, Object> control = new HashMap<K, Object>();
		for (K key : keys) {
			control.put(key, new Object());
		}
		
		new MapImmutantScanTest<K, Object>(keyClass, Object.class, control, new ImmutableMap<K, Object>(control)).runTests();
	}
	
	@Test
	public void scan_immutant_methods_of_lists() {
		scan(Integer.class);
		scan(Integer.class, 3, 7, 5, 5, 7, 9, 3, 2, 53, 41, 12, 15);
		scan(String.class, "s3", "s7", "s5", "s7", "s9", "s4", "s15", "s82", "s2", "s8");
	}
	
	
}

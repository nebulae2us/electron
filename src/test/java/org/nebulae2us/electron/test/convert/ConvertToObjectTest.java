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
package org.nebulae2us.electron.test.convert;

import java.util.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.nebulae2us.electron.*;
import org.nebulae2us.electron.test.builder1.model.Gender;
import org.nebulae2us.electron.util.*;

import static org.junit.Assert.*;

/**
 * @author Trung Phan
 *
 */
@RunWith(Parameterized.class)
public class ConvertToObjectTest {

	private Converter converter;
	
	public ConvertToObjectTest(boolean immutable) {
		converter = new Converter(null, immutable, Collections.EMPTY_LIST);
	}
	
	@Parameters
	public static Collection<Boolean[]> data() {
		return Arrays.asList(
				new Boolean[] {Boolean.FALSE}, 
				new Boolean[] {Boolean.TRUE});
	}
	
	@Test
	public void convert_scalar() {
		Integer src = Integer.valueOf(1);
		Object result = converter.convert(src).to(Object.class);
		
		assertTrue(result instanceof Integer);
	}
	
	@Test
	public void convert_enum() {
		Gender gender = Gender.MALE;
		
		Object result = converter.convert(gender).to(Object.class);
		
		assertTrue(result == gender);
	}
	
	@Test
	public void convert_list_of_scalars() {
		Collection<Integer> numbers = Arrays.asList(1, 2, 3);
		
		Object result = converter.convert((Object)numbers).to(Object.class);
		
		assertTrue(result instanceof List);
		assertTrue(converter.isImmutable() ? result instanceof ImmutableList : result instanceof ArrayList);
		assertEquals(numbers, result);
		
	}
	
	@Test
	public void convert_set_of_scalars() {
		Collection<Integer> numbers = new HashSet<Integer>(Arrays.asList(1, 2, 3));
		
		Object result = converter.convert((Object)numbers).to(Object.class);
		
		assertTrue(result instanceof Set);
		assertEquals(numbers, result);
		assertTrue(converter.isImmutable() ?
				result instanceof ImmutableSet : result instanceof HashSet);
	}
	
	@Test
	public void convert_sorted_set_of_scalar() {
		Collection<Integer> numbers = new TreeSet<Integer>(Arrays.asList(1, 2, 3));
		
		Object result = converter.convert((Object)numbers).to(Object.class);
		
		assertTrue(result instanceof SortedSet);
		assertEquals(numbers, result);

		assertTrue(converter.isImmutable() ?
				result instanceof ImmutableSortedSet : result instanceof TreeSet);
	}

	@Test
	public void convert_map_of_scalar() {
		Map<Integer, Boolean> oddNumbers = new HashMap<Integer, Boolean>();
		oddNumbers.put(1, true);
		oddNumbers.put(2, false);
		oddNumbers.put(3, true);
		oddNumbers.put(null, false);
		
		Object result = converter.convert(oddNumbers).to(Object.class);
		
		assertTrue(result instanceof Map);
		assertEquals(oddNumbers, result);
		
		if (converter.isImmutable()) {
			assertTrue(result instanceof ImmutableMap);
			assertTrue( ((ImmutableMap)result).containsKey(new Integer(1)) );
		}
		else {
			assertTrue(result instanceof HashMap);
		}
		
	}
	
	@Test
	public void convert_identity_map_of_scalar() {
		Map<Integer, Boolean> oddNumbers = new IdentityHashMap<Integer, Boolean>();
		oddNumbers.put(1, true);
		oddNumbers.put(2, false);
		oddNumbers.put(3, true);
		oddNumbers.put(null, false);
		
		Object result = converter.convert(oddNumbers).to(Object.class);
		
		assertTrue(result instanceof Map);
		assertEquals(oddNumbers, result);
		
		if (converter.isImmutable()) {
			assertTrue(result instanceof ImmutableMap);
			assertFalse( ((ImmutableMap)result).containsKey(new Integer(1)) );
		}
		else {
			assertTrue(result instanceof IdentityHashMap);
		}
		
	}
	
	@Test
	public void convert_sorted_map_of_scalar() {
		Map<Integer, Boolean> oddNumbers = new TreeMap<Integer, Boolean>();
		oddNumbers.put(1, true);
		oddNumbers.put(2, false);
		oddNumbers.put(3, true);
		
		Object result = converter.convert(oddNumbers).to(Object.class);
		
		assertTrue(result instanceof Map);
		assertEquals(3, ((Map)result).size());
		assertEquals(oddNumbers, result);
		
		if (converter.isImmutable()) {
			assertTrue(result instanceof ImmutableSortedMap);
			assertTrue( ((ImmutableSortedMap)result).containsKey(new Integer(1)) );
		}
		else {
			assertTrue(result instanceof TreeMap);
		}
	}
	
	@Test
	public void convert_mix_of_collection() {
		
		Map<Integer, Set<List<String>>> fixture = new HashMap<Integer, Set<List<String>>>();
		fixture.put(1, new HashSet<List<String>>());
		fixture.get(1).add(Arrays.asList("a", "b", "c"));
		fixture.get(1).add(Arrays.asList("d", "e"));
		fixture.put(2, new HashSet<List<String>>());
		fixture.get(2).add(Arrays.asList("h", "i", "j"));
		fixture.get(2).add(Arrays.asList("k", "m"));
		
		Object result = converter.convert(fixture).to(Object.class);
		
		assertTrue(result instanceof Map);
		assertEquals(fixture, result);
		
		
	}
	
}

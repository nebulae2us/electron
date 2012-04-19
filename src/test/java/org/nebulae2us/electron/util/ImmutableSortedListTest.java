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
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Trung Phan
 *
 */
public class ImmutableSortedListTest {

	@Test
	public void indexOf() {
		
		ImmutableList<Integer> fixture = new ImmutableList<Integer>(Arrays.asList(3, 3, 3, 1, 5), NaturalComparator.getInstance(), false);

		assertEquals(Arrays.asList(1, 3, 3, 3, 5), fixture);
		
		assertEquals(1, fixture.indexOf(3));
		assertEquals(3, fixture.lastIndexOf(3));
	}
	
	@Test
	public void subList_indexOf() {
		ImmutableList<Integer> fixture = new ImmutableList<Integer>(Arrays.asList(3, 3, 3, 0, 1, 5, 7), NaturalComparator.getInstance(), false).subList(1, 6);

		assertEquals(Arrays.asList(1, 3, 3, 3, 5), fixture);
		
		assertEquals(1, fixture.indexOf(3));
		assertEquals(3, fixture.lastIndexOf(3));
	}
	
	@Test
	public void subList_binarySearch() {

		ImmutableList<Integer> fixture = new ImmutableList<Integer>(Arrays.asList(1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25), NaturalComparator.getInstance(), false);
		
		for (int fromIndex = 0; fromIndex < 4; fromIndex++)
			for (int toIndex = 10; toIndex < 13; toIndex++) {
				
				ImmutableList<Integer> newList = fixture.subList(fromIndex, toIndex);
				ArrayList<Integer> control = new ArrayList<Integer>(newList);
				Collections.sort(control);
				
				assertEquals(control, newList);
				
				for (int i = 0; i < 26; i++) {
					assertEquals(Collections.binarySearch(control, i), newList.binarySearch(i) );
				}
			}
		
	}

	@Test
	public void subList_binarySearch_reverse() {

		ImmutableList<Integer> fixture = new ImmutableList<Integer>(Arrays.asList(1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25), NaturalComparator.getInstance(), false);
		
		for (int fromIndex = 0; fromIndex < 4; fromIndex++)
			for (int toIndex = 10; toIndex < 13; toIndex++) {
				
				ImmutableList<Integer> newList = fixture.subList(fromIndex, toIndex).descendingList();
				ArrayList<Integer> control = new ArrayList<Integer>(newList);
				Collections.sort(control, Collections.reverseOrder());
				
				assertEquals(control, newList);
				
				for (int i = 0; i < 26; i++) {
					assertEquals(Collections.binarySearch(control, i, Collections.reverseOrder()), newList.binarySearch(i) );
				}
			}
	}
	
	
}

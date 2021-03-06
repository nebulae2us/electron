/*
 * Copyright 2011 the original author or authors.
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

import org.junit.Test;
import org.nebulae2us.electron.util.apitest.ListImmutantScanTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;

import static org.junit.Assert.*;

/**
 * @author Trung Phan
 */
public class ImmutableListTest {

	private <E> void scan(Class<E> elementClass, E ... elements) {
		ReverseListFunction<E> rev = new ReverseListFunction<E>();
		ReverseImmutableListFunction<E> revTest = new ReverseImmutableListFunction<E>();

		List<E> control = new ArrayList<E>(Arrays.asList(elements));
		new ListImmutantScanTest<E>(elementClass, control, rev, new ImmutableList<E>(control), revTest).runTests();

		if (Comparable.class.isAssignableFrom(elementClass)) {
	 		Collections.sort(control, NaturalComparator.getInstance());
			new ListImmutantScanTest<E>(elementClass, control, rev, new ImmutableList<E>(control).toSortedList(), revTest);
		}
		
		control = new ArrayList<E>(new LinkedHashSet<E>(Arrays.asList(elements)));
		new ListImmutantScanTest<E>(elementClass, control, rev, new ImmutableList<E>(control).toUniqueList(), revTest);
	}
	
	@Test
	public void scan_immutant_methods_of_lists() {
		scan(Object.class);
		scan(Integer.class, 3, 7, 5, 5, 7, 9, 3, 2);
		scan(String.class, "s3", "s7", "s5", "s7", "s9", "s4");
		scan(Object.class, new Object(), new Object(), new Object(), new Object(), new Object(), new Object());
	}
	
    @Test
    public void can_create_list() {
        List<Integer> source = Arrays.asList(1, 2, 3);
        ImmutableList<Integer> list = new ImmutableList<Integer>(source);

        assertEquals(source, list);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void cannot_add_element() {
        List<Integer> source = Arrays.asList(1, 2, 3);
        final ImmutableList<Integer> list = new ImmutableList<Integer>(source);
        list.add(5);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void cannot_remove_element() {
        List<Integer> source = Arrays.asList(1, 2, 3);
        final ImmutableList<Integer> list = new ImmutableList<Integer>(source);
        list.remove(0);
    }

    @Test
    public void can_sub_list() {
        List<Integer> source = Arrays.asList(1, 2, 3, 4, 5, 6);

        final List<Integer> list = new ImmutableList<Integer>(source);
        final List<Integer> subList = list.subList(1, 3);

        assertEquals(source.subList(1, 3), subList);


    }
    
    @Test
    public void iterator() {
    	
    	List<Integer> source = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    	
    	ImmutableList<Integer> fixture =
    			new ImmutableList<Integer>(source)
    			.subList(1, 8).descendingList().subList(0, 6);
    	
    	assertEquals(Arrays.asList(8, 7, 6, 5, 4, 3), fixture);
    	
    	Iterator<Integer> i = fixture.iterator();
    	assertEquals(Integer.valueOf(8), i.next());
    	assertEquals(Integer.valueOf(7), i.next());
    	assertEquals(Integer.valueOf(6), i.next());
    	assertEquals(Integer.valueOf(5), i.next());
    	assertEquals(Integer.valueOf(4), i.next());
    	assertEquals(Integer.valueOf(3), i.next());
    	assertFalse(i.hasNext());
    	
    	ListIterator<Integer> iList = fixture.listIterator();
    	assertFalse(iList.hasPrevious());
    	assertEquals(0, iList.nextIndex());
    	assertEquals(-1, iList.previousIndex());
    	assertEquals(Integer.valueOf(8), iList.next());
    	assertEquals(1, iList.nextIndex());
    	assertEquals(0, iList.previousIndex());
    	assertEquals(Integer.valueOf(7), iList.next());
    	assertEquals(2, iList.nextIndex());
    	assertEquals(1, iList.previousIndex());
    	assertEquals(Integer.valueOf(6), iList.next());
    	assertEquals(3, iList.nextIndex());
    	assertEquals(2, iList.previousIndex());
    	assertEquals(Integer.valueOf(5), iList.next());
    	assertEquals(4, iList.nextIndex());
    	assertEquals(3, iList.previousIndex());
    	assertEquals(Integer.valueOf(4), iList.next());
    	assertEquals(5, iList.nextIndex());
    	assertEquals(4, iList.previousIndex());
    	assertEquals(Integer.valueOf(3), iList.next());
    	assertEquals(6, iList.nextIndex());
    	assertEquals(5, iList.previousIndex());
    	assertFalse(iList.hasNext());
    	
    	assertEquals(Integer.valueOf(3), iList.previous());
    	assertEquals(5, iList.nextIndex());
    	assertEquals(4, iList.previousIndex());
    	assertEquals(Integer.valueOf(4), iList.previous());
    	assertEquals(4, iList.nextIndex());
    	assertEquals(3, iList.previousIndex());
    	assertEquals(Integer.valueOf(5), iList.previous());
    	assertEquals(3, iList.nextIndex());
    	assertEquals(2, iList.previousIndex());
    	assertEquals(Integer.valueOf(6), iList.previous());
    	assertEquals(2, iList.nextIndex());
    	assertEquals(1, iList.previousIndex());
    	assertEquals(Integer.valueOf(7), iList.previous());
    	assertEquals(1, iList.nextIndex());
    	assertEquals(0, iList.previousIndex());
    	assertEquals(Integer.valueOf(8), iList.previous());
    	assertEquals(0, iList.nextIndex());
    	assertEquals(-1, iList.previousIndex());
    	assertFalse(iList.hasPrevious());
    	
    	
    	iList = fixture.listIterator(0);
    	assertFalse(iList.hasPrevious());
    	assertEquals(Integer.valueOf(8), iList.next());
    	
    	iList = fixture.listIterator(5);
    	assertEquals(Integer.valueOf(3), iList.next());
    	assertFalse(iList.hasNext());
    	
    	iList = fixture.listIterator(6);
    	assertFalse(iList.hasNext());
    	
    	try {
    		iList = fixture.listIterator(-1);
    		fail();
    	}
    	catch (IndexOutOfBoundsException e) {}
    	
    	try {
        	iList = fixture.listIterator(7);
        	fail();
    	}
    	catch (IndexOutOfBoundsException e) {}

    	
    }
    
    @Test
    public void revisit_iterator_contract() {
    	List<Integer> fixture = Arrays.asList(8, 7, 6, 5, 4, 3);
    	
    	Iterator<Integer> i = fixture.iterator();
    	assertEquals(Integer.valueOf(8), i.next());
    	assertEquals(Integer.valueOf(7), i.next());
    	assertEquals(Integer.valueOf(6), i.next());
    	assertEquals(Integer.valueOf(5), i.next());
    	assertEquals(Integer.valueOf(4), i.next());
    	assertEquals(Integer.valueOf(3), i.next());
    	assertFalse(i.hasNext());
    	
    	ListIterator<Integer> iList = fixture.listIterator();
    	assertFalse(iList.hasPrevious());
    	assertEquals(0, iList.nextIndex());
    	assertEquals(-1, iList.previousIndex());
    	assertEquals(Integer.valueOf(8), iList.next());
    	assertEquals(1, iList.nextIndex());
    	assertEquals(0, iList.previousIndex());
    	assertEquals(Integer.valueOf(7), iList.next());
    	assertEquals(2, iList.nextIndex());
    	assertEquals(1, iList.previousIndex());
    	assertEquals(Integer.valueOf(6), iList.next());
    	assertEquals(3, iList.nextIndex());
    	assertEquals(2, iList.previousIndex());
    	assertEquals(Integer.valueOf(5), iList.next());
    	assertEquals(4, iList.nextIndex());
    	assertEquals(3, iList.previousIndex());
    	assertEquals(Integer.valueOf(4), iList.next());
    	assertEquals(5, iList.nextIndex());
    	assertEquals(4, iList.previousIndex());
    	assertEquals(Integer.valueOf(3), iList.next());
    	assertEquals(6, iList.nextIndex());
    	assertEquals(5, iList.previousIndex());
    	assertFalse(iList.hasNext());
    	
    	assertEquals(Integer.valueOf(3), iList.previous());
    	assertEquals(5, iList.nextIndex());
    	assertEquals(4, iList.previousIndex());
    	assertEquals(Integer.valueOf(4), iList.previous());
    	assertEquals(4, iList.nextIndex());
    	assertEquals(3, iList.previousIndex());
    	assertEquals(Integer.valueOf(5), iList.previous());
    	assertEquals(3, iList.nextIndex());
    	assertEquals(2, iList.previousIndex());
    	assertEquals(Integer.valueOf(6), iList.previous());
    	assertEquals(2, iList.nextIndex());
    	assertEquals(1, iList.previousIndex());
    	assertEquals(Integer.valueOf(7), iList.previous());
    	assertEquals(1, iList.nextIndex());
    	assertEquals(0, iList.previousIndex());
    	assertEquals(Integer.valueOf(8), iList.previous());
    	assertEquals(0, iList.nextIndex());
    	assertEquals(-1, iList.previousIndex());
    	assertFalse(iList.hasPrevious());
    	
    	
    	iList = fixture.listIterator(0);
    	assertFalse(iList.hasPrevious());
    	assertEquals(Integer.valueOf(8), iList.next());
    	
    	iList = fixture.listIterator(5);
    	assertEquals(Integer.valueOf(3), iList.next());
    	assertFalse(iList.hasNext());
    	
    	iList = fixture.listIterator(6);
    	assertFalse(iList.hasNext());
    	
    	try {
    		iList = fixture.listIterator(-1);
    		fail();
    	}
    	catch (IndexOutOfBoundsException e) {}
    	
    	try {
        	iList = fixture.listIterator(7);
        	fail();
    	}
    	catch (IndexOutOfBoundsException e) {}
    	
    }

    @Test
    public void descendingIterator() {
    	
    	List<Integer> source = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    	
    	ImmutableList<Integer> fixture =
    			new ImmutableList<Integer>(source)
    			.subList(1, 8).descendingList().subList(0, 6);
    	
    	assertEquals(Arrays.asList(8, 7, 6, 5, 4, 3), fixture);
    	
    	Iterator<Integer> i = fixture.descendingIterator();
    	assertEquals(Integer.valueOf(3), i.next());
    	assertEquals(Integer.valueOf(4), i.next());
    	assertEquals(Integer.valueOf(5), i.next());
    	assertEquals(Integer.valueOf(6), i.next());
    	assertEquals(Integer.valueOf(7), i.next());
    	assertEquals(Integer.valueOf(8), i.next());
    	assertFalse(i.hasNext());
    	
    	ListIterator<Integer> iList = fixture.descendingListIterator();
    	assertFalse(iList.hasPrevious());
    	assertEquals(5, iList.nextIndex());
    	assertEquals(6, iList.previousIndex());
    	assertEquals(Integer.valueOf(3), iList.next());
    	assertEquals(4, iList.nextIndex());
    	assertEquals(5, iList.previousIndex());
    	assertEquals(Integer.valueOf(4), iList.next());
    	assertEquals(3, iList.nextIndex());
    	assertEquals(4, iList.previousIndex());
    	assertEquals(Integer.valueOf(5), iList.next());
    	assertEquals(2, iList.nextIndex());
    	assertEquals(3, iList.previousIndex());
    	assertEquals(Integer.valueOf(6), iList.next());
    	assertEquals(1, iList.nextIndex());
    	assertEquals(2, iList.previousIndex());
    	assertEquals(Integer.valueOf(7), iList.next());
    	assertEquals(0, iList.nextIndex());
    	assertEquals(1, iList.previousIndex());
    	assertEquals(Integer.valueOf(8), iList.next());
    	assertEquals(-1, iList.nextIndex());
    	assertEquals(0, iList.previousIndex());
    	assertFalse(iList.hasNext());
    	
    	assertEquals(Integer.valueOf(8), iList.previous());
    	assertEquals(0, iList.nextIndex());
    	assertEquals(1, iList.previousIndex());
    	assertEquals(Integer.valueOf(7), iList.previous());
    	assertEquals(1, iList.nextIndex());
    	assertEquals(2, iList.previousIndex());
    	assertEquals(Integer.valueOf(6), iList.previous());
    	assertEquals(2, iList.nextIndex());
    	assertEquals(3, iList.previousIndex());
    	assertEquals(Integer.valueOf(5), iList.previous());
    	assertEquals(3, iList.nextIndex());
    	assertEquals(4, iList.previousIndex());
    	assertEquals(Integer.valueOf(4), iList.previous());
    	assertEquals(4, iList.nextIndex());
    	assertEquals(5, iList.previousIndex());
    	assertEquals(Integer.valueOf(3), iList.previous());
    	assertEquals(5, iList.nextIndex());
    	assertEquals(6, iList.previousIndex());
    	assertFalse(iList.hasPrevious());
    	
    	iList = fixture.descendingListIterator(0);
    	assertFalse(iList.hasPrevious());
    	assertEquals(Integer.valueOf(3), iList.next());
    	
    	iList = fixture.descendingListIterator(5);
    	assertEquals(Integer.valueOf(8), iList.next());
    	assertFalse(iList.hasNext());
    	
    	iList = fixture.descendingListIterator(6);
    	assertFalse(iList.hasNext());
    	
    	try {
    		iList = fixture.descendingListIterator(-1);
    		fail();
    	}
    	catch (IndexOutOfBoundsException e) {}
    	
    	try {
        	iList = fixture.descendingListIterator(7);
        	fail();
    	}
    	catch (IndexOutOfBoundsException e) {}    	
    }

    @Test
    public void sort_on_sorted_list_should_return_the_same_list() {
    	ImmutableList<Integer> list = new ImmutableList<Integer>(1, 3, 7, 2, 4);
    	
    	ImmutableList<Integer> sortedList = list.toSortedList();
    	
    	assertTrue(sortedList == sortedList.toSortedList());
    }
    
    

	



}

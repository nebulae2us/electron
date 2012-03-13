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

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Trung Phan
 */
public class ImmutableListTest {

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



}

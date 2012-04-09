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

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

import static org.nebulae2us.electron.util.Immutables.*;

/**
 * @author Trung Phan
 *
 */
public class ImmutablesTest {

	@Test
	public void formatElement() {
		
		List<Integer> list = Arrays.asList(1, null, 3);
		
		assertEquals("Element value is: 1, Element value is: 0, Element value is: 3",
			$(list).denullify(0).formatElement("Element value is: %d").join(", ")) ;
		
		assertEquals("1, 3", $(list).removeNull().join(", "));
	}
	
}

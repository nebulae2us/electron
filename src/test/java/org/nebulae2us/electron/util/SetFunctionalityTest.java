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
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.nebulae2us.electron.util.apitest.SetImmutantScanTest;

/**
 * 
 * @author Trung Phan
 *
 */
public class SetFunctionalityTest {
	
	@Test
	public void immutable_set_of_integer() {
		
		Set<Integer> control = new HashSet<Integer>(Arrays.asList(3, 7, 5, 9));
		ImmutableSet<Integer> test = new ImmutableSet<Integer>(Arrays.asList(3, 7, 5, 5, 7, 9));
		
		new SetImmutantScanTest<Integer>(Integer.class,
				control,
				test).runTests();
	}

}

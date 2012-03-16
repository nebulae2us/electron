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
package org.nebulae2us.electron.test.builder1;

import org.junit.Test;
import org.nebulae2us.electron.test.builder1.model.Person;

import static org.nebulae2us.electron.test.builder1.Builders.*;
import static org.junit.Assert.*;

/**
 * @author Trung Phan
 *
 */
public class ModifyImmutableTest {

	@Test
	public void change_person_name() {
		
		Person person = person().name("Washington").toPerson();
		
		assertEquals("Washington", person.getName());
		
		person = person$copyFrom(person)
			.name("Jr Washington")
			.toPerson();
		
		assertEquals("Jr Washington", person.getName());
	}
	
	
}

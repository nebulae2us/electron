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

import org.junit.Test;
import org.nebulae2us.electron.test.builder1.model.Person;
import org.nebulae2us.electron.test.builder1.model.PersonBuilder;

import static org.nebulae2us.electron.test.builder1.model.Builders.*;
import static org.junit.Assert.*;

/**
 * @author Trung Phan
 *
 */
public class ConvertMutableTest {

	@Test
	public void edit_person() {
		
		Person person = person()
			.name("Person 1")
			.hobbies(
				hobby().name("Hobby 1")
			)
			.toPerson();
		
		PersonBuilder personBuilder = person$copyFrom(person);
		
		personBuilder
			.hobbies(
				hobby().name("Hobby 2")
			);
		
		assertEquals(2, personBuilder.getHobbies().size());
	
		person = personBuilder.toPerson();
		
		try {
			person.getHobbies().add(
					hobby().name("Hobby 3").toHobby()
					);
			fail();
		}
		catch (UnsupportedOperationException e) {
			
		}
		
	}
	
}

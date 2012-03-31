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
import org.nebulae2us.electron.BuilderRepository;
import org.nebulae2us.electron.WrapConverter;
import org.nebulae2us.electron.test.builder1.model.Person;
import org.nebulae2us.electron.test.builder1.model.PersonBuilder;
import org.nebulae2us.electron.test.builder1.model.Student;
import org.nebulae2us.electron.test.builder1.model.StudentBuilder;

import static org.nebulae2us.electron.test.builder1.model.Builders.*;
import static org.junit.Assert.*;

/**
 * @author Trung Phan
 *
 */
public class WrapConverterTest {

	@Test
	public void wrap_person() {
		
		Person person = 
		person()
			.name("Person 1")
			.toPerson();
		
		PersonBuilder personWrap = new WrapConverter(CONVERTER_OPTIONS).convert(person).to(PersonBuilder.class);
		assertTrue(personWrap.getWrappedObject() == person);
		assertEquals(person.getName(), personWrap.getName());
	}
	
	@Test
	public void wrap_student() {
		Student student = 
		student()
			.name("Person 1")
			.toPerson();
		
		StudentBuilder studentWrap = new WrapConverter(CONVERTER_OPTIONS).convert(student).to(StudentBuilder.class);
		assertTrue(studentWrap.getWrappedObject() == student);
		assertEquals(student.getName(), studentWrap.getName());
		
	}
	
	@Test
	public void one_to_many() {
		
		BuilderRepository repo = new BuilderRepository();
		
		Person person =
				person()
					.storeTo(repo, 1)
					.name("Person 1")
					.speeches(
						speech().name("Speech 1").owner$restoreFrom(repo, 1),
						speech().name("Speech 2").owner$restoreFrom(repo, 1)
					)
					.toPerson();
		
		PersonBuilder personWrap = new WrapConverter(CONVERTER_OPTIONS).convert(person).to(PersonBuilder.class);

		assertTrue(personWrap.getWrappedObject() == person);
		assertTrue(personWrap.getSpeeches().get(0).getWrappedObject() == person.getSpeeches().get(0));
		assertTrue(personWrap.getSpeeches().get(1).getWrappedObject() == person.getSpeeches().get(1));
		
		assertEquals("Speech 1", personWrap.getSpeeches().get(0).getName());
	}
	
	
}

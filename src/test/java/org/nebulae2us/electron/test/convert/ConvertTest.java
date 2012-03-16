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

import java.util.ArrayList;

import org.junit.Test;
import org.nebulae2us.electron.Converter;
import org.nebulae2us.electron.test.convert.mode.Hobby1;
import org.nebulae2us.electron.test.convert.mode.Hobby2;
import org.nebulae2us.electron.test.convert.mode.Person1;
import org.nebulae2us.electron.test.convert.mode.Person2;
import org.nebulae2us.electron.test.convert.mode.Speech2;
import org.nebulae2us.electron.test.convert.mode.Teacher1;
import org.nebulae2us.electron.test.convert.mode.Teacher2;

import static org.junit.Assert.*;

/**
 * @author Trung Phan
 *
 */
public class ConvertTest {

	private Converter converter = new Converter();
	
	@Test
	public void convert_one_object() {
		
		Hobby2 hobby2 = new Hobby2();
		hobby2.setName("Walking");
		
		Hobby1 hobby1 = converter.convert(hobby2).to(Hobby1.class);
		
		assertEquals("Walking", hobby1.getName());
		assertNull(hobby1.getPeople());
		
		hobby2 = converter.convert(hobby1).to(Hobby2.class);
		
		assertEquals("Walking", hobby2.getName());
		assertNull(hobby2.getPeople());
		
	}
	
	@Test
	public void test_many_to_many() {
		Person2 person2_1 = new Person2();
		person2_1.setName("George Washington");
		person2_1.setHobbies(new ArrayList<Hobby2>());
		
		Hobby2 hobby2_1 = new Hobby2();
		hobby2_1.setName("Fishing");
		hobby2_1.setPeople(new ArrayList<Person2>());
		
		Hobby2 hobby2_2 = new Hobby2();
		hobby2_2.setName("Walking");
		hobby2_2.setPeople(new ArrayList<Person2>());
		
		Person2 person2_2 = new Person2();
		person2_2.setName("John Kennedy");
		person2_2.setHobbies(new ArrayList<Hobby2>());

		person2_1.getHobbies().add(hobby2_1);
		person2_1.getHobbies().add(hobby2_2);
		
		person2_2.getHobbies().add(hobby2_1);
		
		hobby2_1.getPeople().add(person2_1);
		hobby2_1.getPeople().add(person2_2);
		
		hobby2_2.getPeople().add(person2_1);
		
		Person1 person1 = converter.convert(person2_1).to(Person1.class);
		
		assertEquals(person2_1.getHobbies().size(), person1.getHobbies().size());
		for (int i = 0; i < person2_1.getHobbies().size(); i++) {
			assertEquals(person2_1.getHobbies().get(i).getName(), person1.getHobbies().get(i).getName());
			assertEquals(person2_1.getHobbies().get(i).getPeople().size(), person1.getHobbies().get(i).getPeople().size());
			assertTrue(person1.getHobbies().get(i).getPeople().contains(person1));
		}
		
		
		person2_1 = converter.convert(person1).to(Person2.class);

		assertEquals(person2_1.getHobbies().size(), person1.getHobbies().size());
		for (int i = 0; i < person2_1.getHobbies().size(); i++) {
			assertEquals(person2_1.getHobbies().get(i).getName(), person1.getHobbies().get(i).getName());
			assertEquals(person2_1.getHobbies().get(i).getPeople().size(), person1.getHobbies().get(i).getPeople().size());
			assertTrue(person2_1.getHobbies().get(i).getPeople().contains(person2_1));
		}
	}
	
	@Test
	public void test_one_to_many() {
		Person2 person2 = new Person2();
		person2.setSpeeches(new ArrayList<Speech2>());
		
		Speech2 speech2_1 = new Speech2();
		speech2_1.setOwner(person2);
		
		Speech2 speech2_2 = new Speech2();
		speech2_2.setOwner(person2);
		
		person2.getSpeeches().add(speech2_1);
		person2.getSpeeches().add(speech2_2);
		
		Person1 person1 = converter.convert(person2).to(Person1.class);
		
		assertEquals(person1, person1.getSpeeches().get(0).getOwner());
		assertEquals(person1, person1.getSpeeches().get(1).getOwner());
		
		person2 = converter.convert(person1).to(Person2.class);
		
		assertEquals(person2, person2.getSpeeches().get(0).getOwner());
		assertEquals(person2, person2.getSpeeches().get(1).getOwner());
		
	}
	
	@Test
	public void test_self_reference() {
		
		Person2 person2 = new Person2();
		person2.setParent(person2);
		
		Person1 person1 = converter.convert(person2).to(Person1.class);
		
		assertTrue(person1.getParent() == person1);
		
		person2 = converter.convert(person1).to(Person2.class);
		
		assertTrue(person2.getParent() == person2);
		
	}
	
	@Test
	public void test_self_reference_2() {
		Person2 person2 = new Person2();
		person2.setChildren(new ArrayList<Person2>());
		person2.getChildren().add(new Person2());
		person2.getChildren().add(new Person2());
		person2.getChildren().get(0).setParent(person2);
		person2.getChildren().get(1).setParent(person2);
		
		Person1 person1 = converter.convert(person2).to(Person1.class);
		
		assertEquals(person2.getChildren().size(), person1.getChildren().size());
		assertTrue(person1.getChildren().get(0).getParent() == person1);
		assertTrue(person1.getChildren().get(1).getParent() == person1);
		
		person2 = converter.convert(person1).to(Person2.class);
		
		assertEquals(person2.getChildren().size(), person1.getChildren().size());
		assertTrue(person2.getChildren().get(0).getParent() == person2);
		assertTrue(person2.getChildren().get(1).getParent() == person2);
		
		
	}
	
	
	@Test
	public void test_sub_class() {
		
		Teacher2 teacher2 = new Teacher2();
		teacher2.setName("Teacher");
		teacher2.setAge(30);
		teacher2.setSalary(10.0);
		
		Teacher1 teacher1 = converter.convert(teacher2).to(Teacher1.class);
		
		assertEquals(teacher2.getAge(), teacher1.getAge());
		assertEquals(teacher2.getName(), teacher1.getName());
		assertEquals(teacher2.getSalary(), teacher1.getSalary(), 0);
		
	}
	
}

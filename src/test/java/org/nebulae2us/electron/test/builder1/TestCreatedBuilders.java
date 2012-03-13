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

import java.util.Arrays;

import org.junit.Test;
import org.nebulae2us.electron.BuilderRepository;
import org.nebulae2us.electron.test.builder1.model.*;

import static org.nebulae2us.electron.test.builder1.Builders.*;
import static org.junit.Assert.*;

/**
 * @author Trung Phan
 *
 */
public class TestCreatedBuilders {

	
	@Test
	public void aaa() {
		
		
	}
	
	@Test
	public void create_person() {
		
		PersonBuilder<?> personBuilder = person()
				.name("John Deere")
				.age(30)
				.child()
					.name("Joe Deere").age(12)
				.end()
				.child()
					.name("Hannah Deere").age(3)
				.end()
				;
		
		assertEquals("John Deere", personBuilder.getName());
		assertEquals(30, personBuilder.getAge());
		assertEquals(2, personBuilder.getChildren().size());
		assertEquals("Joe Deere", personBuilder.getChildren().get(0).getName());
		assertEquals("Hannah Deere", personBuilder.getChildren().get(1).getName());
	}
	
	@Test
	public void create_person_children() {
		PersonBuilder<?> personBuilder = person()
				.name("John Deere")
				.age(30)
				.children(
					person().name("Joe Deere").age(12),
					person().name("Hannah Deere").age(3)
				)
				;
		
		assertEquals("John Deere", personBuilder.getName());
		assertEquals(30, personBuilder.getAge());
		assertEquals(2, personBuilder.getChildren().size());
		assertEquals("Joe Deere", personBuilder.getChildren().get(0).getName());
		assertEquals("Hannah Deere", personBuilder.getChildren().get(1).getName());
	}
	
	@Test
	public void list_of_scalar() {
		SpeechBuilder<?> s1 = speech().name("I Have A Dream")
			.keywords("free", "skin", "slave")
			.keyword("color");
		
		assertEquals(4, s1.getKeywords().size());
		assertEquals(Arrays.asList("free", "skin", "slave", "color"), s1.getKeywords());
	}

	@Test
	public void reuse_objects() {
		
		BuilderRepository repo = new BuilderRepository();
		
		PersonBuilder<?> personBuilder = person()
				.storeTo(repo, 1)
				.name("John Deere")
				.child()
					.name("Joe Deere").parent$restoreFrom(repo, 1)
				.end()
				;

		assertTrue(personBuilder == personBuilder.getChildren().get(0).getParent());
		
	}
	
	@Test
	public void self_reference() {
		BuilderRepository repo = new BuilderRepository();

		PersonBuilder<?> tom = person()
				.storeTo(repo, 1)
				.name("Tom Smith")
				;
		
		PersonBuilder<?> john = person()
				.storeTo(repo, 2)
				.name("John Deere")
				.child().storeTo(repo, 3)
					.name("Joe Deere")
				.end()
				.child(
					// a different way to define child
					person().name("Hannah Deere").storeTo(repo, 4)
				)
				.friend$restoreFrom(repo, 1);
				;
		
		tom.friend$restoreFrom(repo, 2);
		
		PersonBuilder<?> sarah = person()
				.name("Sarah Lee")
				.child$restoreFrom(repo, 3)
				.child(
					// a different way to restore a person
					person$restoreFrom(repo, 4)
				)
				;
		
		assertTrue(tom == john.getFriends().get(0));
		assertTrue(john == tom.getFriends().get(0));
		assertTrue(john.getChildren().get(0) == sarah.getChildren().get(0));
		
	}

	@Test
	public void circular_reference() {
		BuilderRepository repo = new BuilderRepository(true);

		PersonBuilder<?> tom = person()
				.storeTo(repo, 1)
				.name("Tom Smith")
				.friend$restoreFrom(repo, 2)
				;
		
		PersonBuilder<?> john = person()
				.storeTo(repo, 2)
				.name("John Deere")
				.friend$restoreFrom(repo, 1);
				;
		
		assertTrue(tom == john.getFriends().get(0));
		assertTrue(john == tom.getFriends().get(0));
				
	}
	
	@Test
	public void one_to_many() {
		
		BuilderRepository repo = new BuilderRepository();
	
		PersonBuilder<?> washington = person()
			.storeTo(repo, 1)
			.name("George Washington")
			.speech().name("First Inaugural Address").owner$restoreFrom(repo, 1).end()
			.speech().name("Thanksgiving Proclamation").owner$restoreFrom(repo, 1).end()
			.speech().name("First Annual Message to Congress").owner$restoreFrom(repo, 1).end()
			.speech().name("Second Annual Message to Congress").owner$restoreFrom(repo, 1).end()
			.speech().name("Proclamation Against Crimes Against the Cherokee Nations").owner$restoreFrom(repo, 1).end()
			;
		
		assertEquals(5, washington.getSpeeches().size());
		assertTrue(washington == washington.getSpeeches().get(0).getOwner());
		
	}
	
	@Test
	public void one_to_many_circular_reference() {
		BuilderRepository repo = new BuilderRepository(true);

		SpeechBuilder<?> s1 = speech().name("First Inaugural Address").owner$restoreFrom(repo, 1);
		SpeechBuilder<?> s2 = speech().name("Thanksgiving Proclamation").owner$restoreFrom(repo, 1);
		SpeechBuilder<?> s3 = speech().name("First Annual Message to Congress").owner$restoreFrom(repo, 1);
		SpeechBuilder<?> s4 = speech().name("Second Annual Message to Congress").owner$restoreFrom(repo, 1);
		SpeechBuilder<?> s5 = speech().name("Proclamation Against Crimes Against the Cherokee Nations").owner$restoreFrom(repo, 1);
		
		PersonBuilder<?> washington = person().storeTo(repo, 1)
				.speeches(s1, s2, s3, s4, s5);
		
		assertTrue(washington == s1.getOwner());
		assertTrue(washington == s2.getOwner());
		assertTrue(washington == s3.getOwner());
		assertTrue(washington == s4.getOwner());
		assertTrue(washington == s5.getOwner());

	}
	
	@Test
	public void many_to_many() {
		
		BuilderRepository repo = new BuilderRepository();
		HobbyBuilder<?> h1 = hobby().name("fishing").storeTo(repo, 1);
		HobbyBuilder<?> h2 = hobby().name("swimming").storeTo(repo, 2);
		HobbyBuilder<?> h3 = hobby().name("dancing").storeTo(repo, 3);
		
		PersonBuilder<?> p1 = person().name("A")
			.storeTo(repo, 11)
			.hobby$restoreFrom(repo, 1)
			.hobby$restoreFrom(repo, 2);
		
		PersonBuilder<?> p2 = person().name("B")
			.storeTo(repo, 12)
			.hobby$restoreFrom(repo, 2)
			.hobby$restoreFrom(repo, 3);

		hobby$restoreFrom(repo, 1)
			.person$restoreFrom(repo, 11);
		
		hobby$restoreFrom(repo, 2)
			.person$restoreFrom(repo, 11)
			.person$restoreFrom(repo, 12);
		
		hobby$restoreFrom(repo, 3)
			.person$restoreFrom(repo, 12);
	
		assertTrue(p1.getHobbies().get(0) == h1);
		assertTrue(h1.getPeople().get(0) == p1);
		assertTrue(p2.getHobbies().get(0) == h2);
		assertTrue(h2.getPeople().get(1) == p2);
		assertTrue(p2.getHobbies().get(1) == h3);
		assertTrue(h3.getPeople().get(0) == p2);

	
	}
	
	@Test
	public void many_to_many_circular_reference() {
		
		BuilderRepository repo = new BuilderRepository(true);
		
		HobbyBuilder<?> h1 = hobby().name("fishing").storeTo(repo, 1)
				.person$restoreFrom(repo, 11);
		HobbyBuilder<?> h2 = hobby().name("swimming").storeTo(repo, 2)
				.people$restoreFrom(repo, 11, 12);
		HobbyBuilder<?> h3 = hobby().name("dancing").storeTo(repo, 3)
				.person$restoreFrom(repo, 12);

		PersonBuilder<?> p1 = person().name("A")
			.storeTo(repo, 11)
			.hobbies$restoreFrom(repo, 1, 2);
		
		PersonBuilder<?> p2 = person().name("B")
			.storeTo(repo, 12)
			.hobbies$restoreFrom(repo, 2, 3);
	
		assertTrue(p1.getHobbies().get(0) == h1);
		assertTrue(h1.getPeople().get(0) == p1);
		assertTrue(p2.getHobbies().get(0) == h2);
		assertTrue(h2.getPeople().get(1) == p2);
		assertTrue(p2.getHobbies().get(1) == h3);
		assertTrue(h3.getPeople().get(0) == p2);
	
	}
	
}

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
package org.nebulae2us.electron.test.convert.mode;

import java.util.List;

import org.nebulae2us.electron.Mirror;

/**
 * @author Trung Phan
 *
 */
public class Person1 {

	private final String name;
	
	private final int age;
	
	private final Person1 parent;
	
	private final List<Person1> children;
	
	private final List<Hobby1> hobbies;
	
	private final List<Speech1> speeches;
	
	private final List<Person1> friends;
	
	public Person1(Mirror converter) {
		converter.register(this);
		
		this.name = converter.toString("name");
		this.age = converter.toIntValue("age");
		
		this.parent = converter.to(Person1.class, "parent");
		this.children = converter.toListOf(Person1.class, "children");
		this.hobbies = converter.toListOf(Hobby1.class, "hobbies");
		this.speeches = converter.toListOf(Speech1.class, "speeches");
		this.friends = converter.toListOf(Person1.class, "friends");
	}

	/**
	 * @return the speeches
	 */
	public List<Speech1> getSpeeches() {
		return speeches;
	}

	/**
	 * @return the friends
	 */
	public List<Person1> getFriends() {
		return friends;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @return the parent
	 */
	public Person1 getParent() {
		return parent;
	}

	/**
	 * @return the children
	 */
	public List<Person1> getChildren() {
		return children;
	}

	/**
	 * @return the hobbies
	 */
	public List<Hobby1> getHobbies() {
		return hobbies;
	}
	
}

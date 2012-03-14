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

/**
 * @author Trung Phan
 *
 */
public class Person2 {

	private String name;
	
	private int age;
	
	private Person2 parent;
	
	private List<Person2> children;
	
	private List<Hobby2> hobbies;
	
	private List<Speech2> speeches;
	
	private List<Person2> friends;
	
	
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(Person2 parent) {
		this.parent = parent;
	}

	/**
	 * @param children the children to set
	 */
	public void setChildren(List<Person2> children) {
		this.children = children;
	}

	/**
	 * @param hobbies the hobbies to set
	 */
	public void setHobbies(List<Hobby2> hobbies) {
		this.hobbies = hobbies;
	}

	/**
	 * @param speeches the speeches to set
	 */
	public void setSpeeches(List<Speech2> speeches) {
		this.speeches = speeches;
	}

	/**
	 * @param friends the friends to set
	 */
	public void setFriends(List<Person2> friends) {
		this.friends = friends;
	}

	/**
	 * @return the speeches
	 */
	public List<Speech2> getSpeeches() {
		return speeches;
	}

	/**
	 * @return the friends
	 */
	public List<Person2> getFriends() {
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
	public Person2 getParent() {
		return parent;
	}

	/**
	 * @return the children
	 */
	public List<Person2> getChildren() {
		return children;
	}

	/**
	 * @return the hobbies
	 */
	public List<Hobby2> getHobbies() {
		return hobbies;
	}
	
}

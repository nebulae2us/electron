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
public class Teacher2 extends Person2 {

	private double salary;
	
	private List<Student2> students;
	
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	/**
	 * @param students the students to set
	 */
	public void setStudents(List<Student2> students) {
		this.students = students;
	}

	public double getSalary() {
		return salary;
	}

	public List<Student2> getStudents() {
		return students;
	}

	
	
}

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

import org.nebulae2us.electron.Converter;

/**
 * @author Trung Phan
 *
 */
public class Teacher1 extends Person1 {

	private final double salary;
	
	private final List<Student1> students;
	
	public Teacher1(Converter converter) {
		super(converter);
		
		this.salary = converter.toDoubleValue("salary");
		this.students = converter.toListOf(Student1.class, "students");
	}

	public double getSalary() {
		return salary;
	}

	public List<Student1> getStudents() {
		return students;
	}

	
	
}

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
package org.nebulae2us.electron.internal.util;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.nebulae2us.electron.test.builder1.model.Person;

import static org.junit.Assert.*;

/**
 * @author Trung Phan
 *
 */
public class ClassHolderTest {

	private List<List<Set<?>>> field1;
	
	@Test
	public void field1() throws SecurityException, NoSuchFieldException {
		
		Field f1 = ClassHolderTest.class.getDeclaredField("field1");
		
		ClassHolder classHolder = ClassHolder.newInstance(f1.getGenericType());
		
		assertEquals(List.class, classHolder.getRawClass());
		assertEquals(List.class, classHolder.getArgumentClasses().get(0).getRawClass());
		assertEquals(Set.class, classHolder.getArgumentClasses().get(0).getArgumentClasses().get(0).getRawClass());
		assertEquals(Object.class, classHolder.getArgumentClasses().get(0).getArgumentClasses().get(0).getArgumentClasses().get(0).getRawClass());

	}
	
	
	private List<? extends Person> field2;
	
	@Test
	public void field2() throws SecurityException, NoSuchFieldException {
		
		Field f2 = ClassHolderTest.class.getDeclaredField("field2");
		
		ClassHolder classHolder = ClassHolder.newInstance(f2.getGenericType());
		
		assertEquals(List.class, classHolder.getRawClass());
		assertEquals(Person.class, classHolder.getArgumentClasses().get(0).getRawClass());

	}
	
	
}

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
package org.nebulae2us.electron.reflect;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Trung Phan
 *
 */
public class TypeHolderTest {

	private List<? extends Set<? super Integer>> field1;
	
	private Class<?> field2;
	
	public static class Class1<T, Q extends List<Integer> & Serializable> {
		private T field3;
		private Class<? extends T> field4;
		private Class<? super T> field5;
		private Map<Class<List<? extends T>>, Map<ArrayList<? super Q>, T>> field6;
		
		private Class1 field7;
		private Class<? extends Class1<T, Q>> field8;
	}
	
	private String toString(Class<?> c, String fieldName) {
		try {
			Field field = c.getDeclaredField(fieldName);
			TypeHolder typeHolder = TypeHolder.newInstance(field.getGenericType());
			return typeHolder.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Test
	public void to_string() throws Exception {
		assertEquals("List<? extends Set<? super Integer>>", toString(TypeHolderTest.class, "field1"));
		assertEquals("Class<?>", toString(TypeHolderTest.class, "field2"));
		assertEquals("T", toString(Class1.class, "field3"));
		assertEquals("Class<? extends T>", toString(Class1.class, "field4"));
		assertEquals("Class<? super T>", toString(Class1.class, "field5"));
		assertEquals("Map<Class<List<? extends T>>, Map<ArrayList<? super Q>, T>>", toString(Class1.class, "field6"));
	}
	
	private String toBuilderString(Class<?> c, String fieldName, String suffix, String parentBuilderVariableName, List<Class<?>> classesToBuild) {
		try {
			Field field = c.getDeclaredField(fieldName);
			TypeHolder typeHolder = TypeHolder.newInstance(field.getGenericType());
			return typeHolder.toBuilderTypeHolder(suffix, parentBuilderVariableName, classesToBuild) .toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Test
	public void to_builder_type() throws Exception {
		List<Class<?>> classesToBuild = Arrays.asList(new Class<?>[] {Class1.class});
		
		assertEquals("Class1Builder<P>", toBuilderString(Class1.class, "field7", "Builder", "P", classesToBuild));
		assertEquals("Class<? extends Class1Builder>", toBuilderString(Class1.class, "field8", "Builder", "P", classesToBuild));
	}

	@Test
	public void changeWildcardBound() throws Exception {
		assertEquals("?", TypeHolder.newInstance(Object.class).changeWildcardBound(WildcardBound.UPPER).toString());
	}
	
}

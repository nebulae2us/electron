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
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Trung Phan
 *
 */
public class ClassHolderTest {

	public static class Class1<T, Q> {}
	
	public static class Class2<
		T extends Object & Serializable, 
		Q extends Map<? extends Integer, T> & Comparable<? super Long> > {}

	
	@Test
	public void to_string() {

		assertEquals("ClassHolderTest", ClassHolder.newInstance(ClassHolderTest.class).toString());
		assertEquals("Class1<T, Q>", ClassHolder.newInstance(Class1.class).toString());
		assertEquals("Class2<T extends Serializable, Q extends Map<? extends Integer, T> & Comparable<? super Long>>", ClassHolder.newInstance(Class2.class).toString());
		
		
	}
	
	
	@Test
	public void to_builder_type() throws Exception {
		List<Class<?>> classesToBuild = Arrays.asList(new Class<?>[] {Class1.class, Class2.class});
		
		assertEquals("Class1Builder<P, T, Q>", ClassHolder.newInstance(Class1.class).toBuilderClassHolder("Builder", "P", classesToBuild).toString() );
	}
	
	
}

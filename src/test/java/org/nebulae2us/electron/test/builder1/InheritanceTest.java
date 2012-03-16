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

import org.junit.Test;
import org.nebulae2us.electron.test.builder1.model.*;

import static org.junit.Assert.*;
import static org.nebulae2us.electron.test.builder1.Builders.*;

/**
 * @author Trung Phan
 *
 */
public class InheritanceTest {

	@Test
	public void object_to_immutable() {
		
		PersonBuilder<?> personBuilder = person()
			.parent(
				teacher()
			);
		
		assertTrue(personBuilder.getParent() instanceof TeacherBuilder);
		
		Person person = personBuilder.toPerson();
		
		assertTrue(person.getParent() instanceof Teacher);
	}
	
}
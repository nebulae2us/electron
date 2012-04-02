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
package org.nebulae2us.electron.test.builder2.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.nebulae2us.electron.util.MapBuilder;

import static org.junit.Assert.*;
import static org.nebulae2us.electron.test.builder2.model.BuilderSpecs.*;

/**
 * @author Trung Phan
 *
 */
public class SpecTest {


	@Test
	public void sample_name() {
		
		SampleBuilderSpec<?> builder = new SampleBuilderSpec<Object>()
			.name("Name 1");
		
		assertEquals("Name 1", builder.getName());
		
	}
	
	@Test
	public void sample_blank() {
		
//		SampleBuilderSpec<?> sampleBuilder = sample()
//				.blank$
		
	}
	
	@Test
	public void sample_blanks() {
		
		SampleBuilderSpec<?> sampleBuilder = sample()
			.blanks$list()
				.blank$begin()
					.name("Blank 1")
				.end()
				.blank$begin()
					.name("Blank 2")
				.end()
			.end();
		
		assertEquals(2, sampleBuilder.getBlanks().size());
		
	}
	
}

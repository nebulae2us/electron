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

import java.io.File;
import java.util.Arrays;

import org.nebulae2us.electron.BuilderGenerator;

/**
 * @author Trung Phan
 *
 */
public class GenerateBuilders {

	@SuppressWarnings("static-access")
	public static void main(String ... arguments) {
		
		new BuilderGenerator()
			.generateBuilders(new File("src/test/java"),
					"org.nebulae2us.electron.test.builder2.model", 
					Arrays.asList(new Class<?>[]{
						Blank.class,
						Sample.class,
						SubSample.class
					}));
		
	}
	
}

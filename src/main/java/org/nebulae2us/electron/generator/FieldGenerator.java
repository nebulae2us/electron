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
package org.nebulae2us.electron.generator;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.nebulae2us.electron.reflect.ClassHolder;
import org.nebulae2us.electron.reflect.TypeHolder;

/**
 * @author Trung Phan
 *
 */
public class FieldGenerator implements Generator {
	
	protected final Map<String, String> templates;
	
	protected final Field field;
	
	protected final Class<?> srcClass;
	
	protected final ClassHolder destClassHolder;
	
	protected final List<Class<?>> classesToBuild;
	
	protected final TypeHolder typeHolder;
	
	protected final boolean defined;
	
	public FieldGenerator(Map<String, String> templates, Field field, Class<?> srcClass, ClassHolder destClassHolder, List<Class<?>> classesToBuild, boolean defined) {
		this.field = field;
		this.srcClass = srcClass;
		this.classesToBuild = classesToBuild;
		
		this.typeHolder = TypeHolder.newInstance(field);
		this.destClassHolder = destClassHolder;

		this.defined = defined;
		this.templates = templates;
	}

	public String generate() {
		return null;
	}

	public Generator recommendBestGenerator() {
		return null;
	}

}

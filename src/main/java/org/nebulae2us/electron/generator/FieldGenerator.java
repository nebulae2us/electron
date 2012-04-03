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
import java.util.Properties;

import org.nebulae2us.electron.internal.util.StringReplacer;
import org.nebulae2us.electron.reflect.ClassHolder;
import org.nebulae2us.electron.reflect.TypeHolder;

/**
 * @author Trung Phan
 *
 */
public class FieldGenerator {
	
	protected final Properties templates;
	
	protected final Field field;
	
	protected final Class<?> srcClass;
	
	protected ClassHolder destClassHolder;
	
	protected TypeHolder destTypeHolder;
	
	protected final List<Class<?>> classesToBuild;
	
	protected final String builderSuffix;
	
	protected final TypeHolder typeHolder;
	
	protected final boolean defined;
	
	public FieldGenerator(Properties templates, Field field, Class<?> srcClass, String builderSuffix, List<Class<?>> classesToBuild, boolean defined) {
		this.field = field;
		this.srcClass = srcClass;
		this.classesToBuild = classesToBuild;
		this.builderSuffix = builderSuffix;
		
		this.typeHolder = TypeHolder.newInstance(field);
		this.destTypeHolder = typeHolder.toBuilderTypeHolder(builderSuffix, "?", classesToBuild);
		
		this.destClassHolder = ClassHolder.newInstance(srcClass).toBuilderClassHolder(builderSuffix, "P", classesToBuild);

		this.defined = defined;
		this.templates = templates;
	}
	
	public FieldGenerator(FieldGenerator fieldGenerator) {
		this.field = fieldGenerator.field;
		this.srcClass = fieldGenerator.srcClass;
		this.classesToBuild = fieldGenerator.classesToBuild;
		this.builderSuffix = fieldGenerator.builderSuffix;
		
		this.typeHolder = fieldGenerator.typeHolder;
		this.destTypeHolder = fieldGenerator.destTypeHolder;
		this.destClassHolder = fieldGenerator.destClassHolder;

		this.defined = fieldGenerator.defined;
		this.templates = fieldGenerator.templates;
	}

	protected String generateGetterSettter() {
		return
		new StringReplacer(templates.getProperty("builder_fieldname_getter_settter"))
		.replace("String", destTypeHolder.toString())
		.replace("name", field.getName())
		.replace("Name", toUpperCamelCase(field.getName()))
		.toString();
		
	}
	
	@Override
	public String toString() {
		return "";
	}

	
	public static String toCamelCase(String camelCap) {
		return Character.toLowerCase(camelCap.charAt(0))+ camelCap.substring(1);
	}	
	
	public static String toUpperCamelCase(String camelCase) {
		return Character.toUpperCase(camelCase.charAt(0))+ camelCase.substring(1);
	}	
	
}

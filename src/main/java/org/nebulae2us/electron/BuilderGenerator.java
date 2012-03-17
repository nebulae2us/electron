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
package org.nebulae2us.electron;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;

import static org.nebulae2us.electron.Constants.*;

/**
 * @author Trung Phan
 *
 */
public class BuilderGenerator {

	private static Properties templates;
	
	private static Properties getTemplates() {
		if (templates == null) {
			try {
				templates = new Properties();
				templates.loadFromXML( BuilderGenerator.class.getClassLoader().getResourceAsStream("template/builder.xml") );
			} catch (Exception e) {
				templates = null;
				throw new RuntimeException("Failed to load builder templates", e);
			}
		}
		
		return templates;
	}
	
	public static void generateBuilders(File genFolder, String packageName, List<Class<?>> _modelClasses) {

		List<Class<?>> modelClasses = new ArrayList<Class<?>>(_modelClasses);
		Collections.sort(modelClasses, new Comparator<Class<?>>() {
			public int compare(Class<?> c1, Class<?> c2) {
				if (c1.isAssignableFrom(c2)) {
					return -1;
				}
				else if (c2.isAssignableFrom(c1)) {
					return 1;
				}
				else {
					return c1.getName().compareTo(c2.getName());
				}
			}
		});
		
		File folder = new File(genFolder, packageName.replaceAll("\\.", "/"));
		if (!folder.exists()) {
			folder.mkdirs();
		}
		
		buildBuilders(genFolder, packageName, modelClasses);
		
		for (Class<?> modelClass : modelClasses) {
			buildClassBuilder(genFolder, modelClass, modelClasses);
		}
		
	}
	
	private static String genFieldNameAndGetterSetter(String fieldType, String fieldName) {
		
		String fieldNameCamelCap = Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
		
		String template = getTemplates().getProperty("fieldname_getter_setter");
		
		return template.replaceAll("Name", fieldNameCamelCap)
				.replaceAll("name", fieldName)
				.replaceAll("String", fieldType);
		
	}
	
	
	private static void buildClassBuilder(File genFolder, Class<?> modelClass, List<Class<?>> modelClasses) {
		StringBuilder builder = new StringBuilder();

		String packageName = modelClass.getPackage().getName();
		
		String className = modelClass.getSimpleName();
		String builderClassName = className + "Builder";
		
		builder.append("package ").append(packageName).append(";\n\n")
			.append("import java.util.*;\n")
			.append("import org.nebulae2us.electron.*;\n")
			.append("\n\n")
			.append("public class ").append(builderClassName).append("<B>");
		
		Class<?> c = modelClass;
		while ((c = c.getSuperclass()) != null) {
			if (modelClasses.contains(c)) {
				builder.append(" extends ").append(c.getSimpleName()).append("Builder<B>");
				break;
			}
		}
		
		builder.append(" {\n")
		;
		
		builder.append(getTemplates().getProperty("builder_constructors_methods")
				.replaceAll("PersonBuilder", builderClassName)
				.replaceAll("Person", className)
				);
		
		Field[] fields = modelClass.getDeclaredFields();
		for (Field field : fields) {
			String fieldName = field.getName();
			Class<?> fieldClass = field.getType();
			String fieldClassName = fieldClass.getSimpleName();
			String fieldBuilderClassName = fieldClassName + "Builder";
			String fieldClassCamelCase = toCamelCase(fieldClassName);
			
			if (SCALAR_TYPES.contains(fieldClass)) {

				builder.append(genFieldNameAndGetterSetter(fieldClassName, fieldName));
				
				String template = getTemplates().getProperty("scalar_field");

				builder.append(template
						.replaceAll("PersonBuilder", builderClassName)
						.replaceAll("String", fieldClassName)
						.replaceAll("name", fieldName)
						);

			}
			else if (modelClasses.contains(fieldClass)) {

				builder.append(genFieldNameAndGetterSetter(fieldClassName + "Builder<?>", fieldName));
				
				String template = getTemplates().getProperty("builder_field");
				
				builder.append(template
						.replaceAll("SpeechBuilder", "```builderClassName```")
						.replaceAll("PersonBuilder", fieldBuilderClassName)
						.replaceAll("```builderClassName```", builderClassName)
						.replaceAll("owner", fieldName)
						.replaceAll("person", fieldClassCamelCase)
						);
				
			}
			else if (fieldClassName.equals("List")) {
				
				ParameterizedType subType = (ParameterizedType)field.getGenericType();
				Class<?> fieldSubClass = (Class<?>)subType.getActualTypeArguments()[0];
				String fieldSubClassName = fieldSubClass.getSimpleName();
				String fieldSubBuilderClassName = fieldSubClassName + "Builder";
				String singularFieldName = singularize(fieldName);

				if (modelClasses.contains(fieldSubClass)) {
					builder.append(genFieldNameAndGetterSetter(fieldClassName + "<" + fieldSubClassName + "Builder<?>>", fieldName));

					String template = getTemplates().getProperty("list_field");
					
					builder.append(template
							.replaceAll("HobbyBuilder", "```builderClassName```")
							.replaceAll("PersonBuilder", fieldSubBuilderClassName)
							.replaceAll("```builderClassName```", builderClassName)
							.replaceAll("people", fieldName)
							.replaceAll("person", singularFieldName)
							);
					
				}
				else if (SCALAR_TYPES.contains(fieldSubClass)) {
					builder.append(genFieldNameAndGetterSetter(fieldClassName + "<" + fieldSubClassName + ">", fieldName));

					String template = getTemplates().getProperty("list_scalar_field");
					
					builder.append(template
							.replaceAll("SpeechBuilder", builderClassName)
							.replaceAll("keywords", fieldName)
							.replaceAll("keyword", singularFieldName)
							.replaceAll("String", fieldSubClassName)
							);
					
				}
			}
		}

		builder.append("}\n");

		File folder = new File(genFolder, packageName.replaceAll("\\.", "/"));
		if (!folder.exists()) {
			folder.mkdirs();
		}
		
		File javaFile = new File(folder, builderClassName + ".java");
		try {
			FileWriter fw = new FileWriter(javaFile);
			fw.write(builder.toString());
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	private static void buildBuilders(File genFolder, String packageName, List<Class<?>> modelClasses) {
		
		String declareTemplate = getTemplates().getProperty("builders_declare");
		
		StringBuilder importBuilder = new StringBuilder();
		StringBuilder hint = new StringBuilder();
		for (Class<?> modelClass : modelClasses) {
			importBuilder.append("import ")
				.append(modelClass.getName())
				.append(";\n")
				.append("import ")
				.append(modelClass.getName())
				.append("Builder;\n");
			
			hint.append(".associate(")
				.append(modelClass.getSimpleName())
				.append(".class, ")
				.append(modelClass.getSimpleName())
				.append("Builder.class)\n\t\t");
		}
		if (hint.length() >= 3)
			hint.delete(hint.length() - 3, hint.length());
		
		
		StringBuilder builder = new StringBuilder();

		builder.append(declareTemplate
				.replaceAll("packageName", packageName)
				.replaceAll("import Person;", importBuilder.toString())
				.replaceAll("\\.associate\\(Person\\.class, PersonBuilder\\.class\\)", hint.toString())
				);
		
		String template = getTemplates().getProperty("builders_each_model_class");
		
		for (Class<?> modelClass : modelClasses) {
			String className = modelClass.getSimpleName();
			String classCamelCase = toCamelCase(className);
			String builderClassName = className + "Builder";
			
			builder.append(
					template
					.replaceAll("PersonBuilder", builderClassName)
					.replaceAll("Person", className)
					.replaceAll("person", classCamelCase));
				
		}
		
		builder.append("}\n");
		

		File folder = new File(genFolder, packageName.replaceAll("\\.", "/"));
		if (!folder.exists()) {
			folder.mkdirs();
		}
		
		File javaFile = new File(folder, "Builders.java");
		try {
			FileWriter fw = new FileWriter(javaFile);
			fw.write(builder.toString());
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static String toCamelCase(String camelCap) {
		return Character.toLowerCase(camelCap.charAt(0))+ camelCap.substring(1);
	}	
	
	
	private static String singularize(String expression) {

		if (expression.equals("people")) {
			return "person";
		}
		else if (expression.equals("children")) {
			return "child";
		}
		else if (expression.endsWith("ies")) {
			return expression.substring(0, expression.length() - 3) + "y";
		}
		else if (expression.endsWith("es")) {
			return expression.substring(0, expression.length() - 2);
		}
		else if (expression.endsWith("s")) {
			return expression.substring(0, expression.length() - 1);
		}
		
		
		return expression;
	}
	
	
	
}

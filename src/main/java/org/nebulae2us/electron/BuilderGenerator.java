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
import java.util.*;

import org.nebulae2us.electron.internal.util.*;

import org.nebulae2us.electron.reflect.ClassHolder;
import org.nebulae2us.electron.reflect.TypeHolder;

/**
 * @author Trung Phan
 *
 */
public class BuilderGenerator {

	private static Properties templates;
	
	static {
		try {
			templates = new Properties();
			templates.loadFromXML( BuilderGenerator.class.getClassLoader().getResourceAsStream("template/builder.xml") );
		} catch (Exception e) {
			templates = null;
			throw new RuntimeException("Failed to load builder templates", e);
		}
	}
	
	private static Properties getTemplates() {
		return templates;
	}
	
	private File baseFolder;
	
	private String buildersPackageName;
	
	private String buildersClassName = "Builders";
	
	private String builderSuffix = "Builder";
	
	public BuilderGenerator baseFolder(File baseFolder) {
		this.baseFolder = baseFolder;
		return this;
	}

	public BuilderGenerator buildersClassName(String buildersFullClassName) {
		int idx = buildersFullClassName.lastIndexOf('.');
		this.buildersClassName = idx > -1 ? buildersFullClassName.substring(idx + 1): buildersFullClassName;
		this.buildersPackageName = idx > -1 ? buildersFullClassName.substring(0, idx) : "";
		return this;
	}
	
	public BuilderGenerator builderSuffix(String builderSuffix) {
		this.builderSuffix = builderSuffix;
		return this;
	}
	
	private List<Class<?>> classesToBuild;
	
	public void generate(Class<?> ... classesToBuild) {
		
		this.classesToBuild = ClassUtils.sortClassesByLevelOfInheritance(Arrays.asList(classesToBuild));
		
		buildBuilders();
		
		for (Class<?> srcClass : classesToBuild) {
			buildClassBuilder(srcClass);
		}
		
	}

	
	private void buildClassBuilder(Class<?> srcClass) {

		String packageName = srcClass.getPackage().getName();

		String srcClassName = srcClass.getSimpleName();
		
		ClassHolder destClassHolder = ClassHolder.newInstance(srcClass).toBuilderClassHolder(this.builderSuffix, "P", classesToBuild);
		String destClassDeclaration = destClassHolder.toString();
		String destClassName = destClassHolder.getName();
		
		Class<?> destSuperClass = getDestSuperClass(srcClass, classesToBuild);
		ClassHolder destSuperClassHolder = ClassHolder.newInstance(destSuperClass).toBuilderClassHolder(this.builderSuffix, "P", classesToBuild);
		String destSuperClassDeclaration = destSuperClassHolder.toString();
		
		StringBuilder result = new StringBuilder();
		
		String packageDeclare = "package " + packageName + ";\n";
		
		ImportStatementGenerator importGenerator = new ImportStatementGenerator(packageName);
		importGenerator.importPackage("org.nebulae2us.electron");
		importGenerator.importPackage("org.nebulae2us.electron.util");
		importGenerator.importPackage("java.util");
		importGenerator.importClass(destSuperClass);
		importGenerator.importPackage(buildersPackageName);
		
		StringBuilder annotationDeclare = new StringBuilder("@Builder(destination=").append(srcClassName).append(".class)");
		
		StringBuilder classDeclare = new StringBuilder().append("public class ").append(destClassDeclaration);
		if (destSuperClass != Object.class) {
			classDeclare.append(" extends ").append(destSuperClassDeclaration);
		}
		else {
			classDeclare.append(" implements Wrappable<").append(srcClassName).append(">");
		}
		
		StringBuilder classContent = new StringBuilder();
		
		if (destSuperClass == Object.class) {
			classContent.append(new StringReplacer(getTemplates().getProperty("builder_constructors"))
					.replace("SampleBuilderSpec", destClassName)
					.replace("Sample", srcClassName)
					);
		}
		else {
			classContent.append(new StringReplacer(getTemplates().getProperty("subclass_constructors"))
					.replace("SubSampleBuilderSpec", destClassName)
					.replace("SubSample", srcClassName)
					);

			Class<?> c = srcClass;
			while ((c = c.getSuperclass()) != null) {
				if (classesToBuild.contains(c)) {
					String superClassName = c.getSimpleName();
					classContent.append(new StringReplacer(getTemplates().getProperty("subclass_build_methods"))
							.replace("SubSample", srcClassName)
							.replace("Sample", superClassName)
							);
				}
			}
			
		}

		for (Field field : ClassUtils.getFields(srcClass)) {
			TypeHolder typeHolder = TypeHolder.newInstance(field.getGenericType());
			importGenerator.importClasses(typeHolder);
			
			boolean notDefined = field.getDeclaringClass() == srcClass || destSuperClass == Object.class || !classesToBuild.contains(field.getDeclaringClass());
			
			if (notDefined) {
				classContent.append(new StringReplacer(getTemplates().getProperty("builder_fieldname_getter_settter"))
						.replace("String", typeHolder.toBuilderTypeHolder(this.builderSuffix, "?", classesToBuild).toString())
						.replace("name", field.getName())
						.replace("Name", toUpperCamelCase(field.getName()))
						);
			}
			
			switch (typeHolder.getClassHolderType()) {
			case SINGLE:
				if (notDefined) {
					classContent.append(new StringReplacer(getTemplates().getProperty("builder_single_type_field"))
							.replace("String", typeHolder.toBuilderTypeHolder(this.builderSuffix, "?", classesToBuild).toString())
							.replace("name", field.getName())
							.replace("Name", toUpperCamelCase(field.getName()))
							.replace("SampleBuilderSpec<P>", destClassDeclaration)
							.replace("SampleBuilderSpec", destClassName)
							.replace("Builders", this.buildersClassName)
							);

					if (classesToBuild.contains(typeHolder.getRawClass())) {
						classContent.append(new StringReplacer(getTemplates().getProperty("builder_single_type_builder_field"))
								.replace("SampleBuilderSpec<P>", destClassDeclaration)
								.replace("SampleBuilderSpec", destClassName)
								.replace("blank", field.getName())
								.replace("BlankBuilderSpec", typeHolder.getRawClass().getSimpleName() + this.builderSuffix)
								.replace("Blank", typeHolder.getRawClass().getSimpleName())
								.replace("Builders", this.buildersClassName)
								);
					}
				}
				else {
					classContent.append(new StringReplacer(getTemplates().getProperty("subclass_single_type_field"))
							.replace("String", typeHolder.toBuilderTypeHolder(this.builderSuffix, "?", classesToBuild).toString())
							.replace("name", field.getName())
							.replace("Name", toUpperCamelCase(field.getName()))
							.replace("SubSampleBuilderSpec<P>", destClassDeclaration)
							.replace("SubSampleBuilderSpec", destClassName)
							.replace("Builders", this.buildersClassName)
							);

					if (classesToBuild.contains(typeHolder.getRawClass())) {
						classContent.append(new StringReplacer(getTemplates().getProperty("subclass_single_type_builder_field"))
								.replace("SubSampleBuilderSpec<P>", destClassDeclaration)
								.replace("SubSampleBuilderSpec", destClassName)
								.replace("blank", field.getName())
								.replace("BlankBuilderSpec", typeHolder.getRawClass().getSimpleName() + this.builderSuffix)
								.replace("Blank", typeHolder.getRawClass().getSimpleName())
								.replace("Builders", this.buildersClassName)
								);
					}
				}
				
				
				break;
			case COLLECTION:
				if (notDefined) {
					classContent.append(new StringReplacer(getTemplates().getProperty("builder_collection_type_field"))
							.replace("String", typeHolder.getTypeParams().get(0).toBuilderTypeHolder(this.builderSuffix, "?", classesToBuild).toString())
							.replace("names", field.getName())
							.replace("SampleBuilderSpec<P>", destClassDeclaration)
							.replace("SampleBuilderSpec", destClassName)
							.replace("ArrayList", getMutableCollectionType(typeHolder.getRawClass()).getSimpleName())
							.replace("Builders", this.buildersClassName)
							);
					
					
					Class<?> elementClass = typeHolder.getTypeParams().get(0).getRawClass();
					if (classesToBuild.contains(elementClass)) {
						classContent.append(new StringReplacer(getTemplates().getProperty("builder_collection_type_builder_field"))
								.replace("SampleBuilderSpec<P>", destClassDeclaration)
								.replace("SampleBuilderSpec", destClassName)
								.replace("blanks", field.getName())
								.replace("BlankBuilderSpec", elementClass.getSimpleName() + this.builderSuffix)
								.replace("Blanks", toUpperCamelCase(field.getName()))
								.replace("Blank", elementClass.getSimpleName())
								.replace("ArrayList", getMutableCollectionType(typeHolder.getRawClass()).getSimpleName())
								.replace("Builders", this.buildersClassName)
								);
					}
				}
				else {
					classContent.append(new StringReplacer(getTemplates().getProperty("subclass_collection_type_field"))
							.replace("String", typeHolder.getTypeParams().get(0).toBuilderTypeHolder(this.builderSuffix, "?", classesToBuild).toString())
							.replace("names", field.getName())
							.replace("SubSampleBuilderSpec<P>", destClassDeclaration)
							.replace("SubSampleBuilderSpec", destClassName)
							.replace("Builders", this.buildersClassName)
							);
					
					
					Class<?> elementClass = typeHolder.getTypeParams().get(0).getRawClass();
					if (classesToBuild.contains(elementClass)) {
						classContent.append(new StringReplacer(getTemplates().getProperty("subclass_collection_type_builder_field"))
								.replace("SubSampleBuilderSpec<P>", destClassDeclaration)
								.replace("SubSampleBuilderSpec", destClassName)
								.replace("blanks", field.getName())
								.replace("BlankBuilderSpec", elementClass.getSimpleName() + this.builderSuffix)
								.replace("Blank", elementClass.getSimpleName())
								.replace("Builders", this.buildersClassName)
								);
					}
				}
				
				break;
			case MAP:
				if (notDefined) {
					classContent.append(new StringReplacer(getTemplates().getProperty("builder_map_type_field"))
							.replace("String.class", typeHolder.getTypeParams().get(0).getBuilderRawClassName(this.builderSuffix, classesToBuild) + ".class")
							.replace("Integer.class", typeHolder.getTypeParams().get(1).getBuilderRawClassName(this.builderSuffix, classesToBuild) + ".class")
							.replace("String", typeHolder.getTypeParams().get(0).toBuilderTypeHolder(this.builderSuffix, "?", classesToBuild).toString())
							.replace("Integer", typeHolder.getTypeParams().get(1).toBuilderTypeHolder(this.builderSuffix, "?", classesToBuild).toString())
							.replace("keywordCounts", field.getName())
							.replace("SampleBuilderSpec<P>", destClassDeclaration)
							.replace("SampleBuilderSpec", destClassName)
							.replace("HashMap", getMutableCollectionType(typeHolder.getRawClass()).getSimpleName())
							.replace("Builders", this.buildersClassName)
							);
				}
				else {
					classContent.append(new StringReplacer(getTemplates().getProperty("subclass_map_type_field"))
							.replace("String", typeHolder.getTypeParams().get(0).toBuilderTypeHolder(this.builderSuffix, "?", classesToBuild).toString())
							.replace("Integer", typeHolder.getTypeParams().get(1).toBuilderTypeHolder(this.builderSuffix, "?", classesToBuild).toString())
							.replace("keywordCounts", field.getName())
							.replace("SubSampleBuilderSpec<P>", destClassDeclaration)
							.replace("SubSampleBuilderSpec", destClassName)
							.replace("Builders", this.buildersClassName)
							);
				}
				
				break;
				
			}
			
		}
		
		
		result.append(packageDeclare).append("\n")
			.append(importGenerator.generate()).append("\n")
			.append(annotationDeclare).append("\n")
			.append(classDeclare).append(" {\n")
			.append(classContent.toString())
			.append("}\n");
		
		generateJavaFile(baseFolder, packageName, destClassName, result.toString());
		
	}

	private static Class<?> getMutableCollectionType(Class<?> rawClass) {
		if (NavigableSet.class.isAssignableFrom(rawClass)) {
			return TreeSet.class;
		}
		else if (Set.class.isAssignableFrom(rawClass)) {
			return HashSet.class;
		}
		else if (Collection.class.isAssignableFrom(rawClass)) {
			return ArrayList.class;
		}
		else if (NavigableMap.class.isAssignableFrom(rawClass)) {
			return TreeMap.class;
		}
		else if (Map.class.isAssignableFrom(rawClass)) {
			return HashMap.class;
		}
		else {
			throw new IllegalStateException("Unknown collection type " + rawClass.getName());
		}
	}

	private static Class<?> getDestSuperClass(Class<?> modelClass, List<Class<?>> modelClasses) {
		Class<?> c = modelClass;
		while ((c = c.getSuperclass()) != null) {
			if (modelClasses.contains(c)) {
				return c;
			}
		}
		return Object.class;
	}

	private static void generateJavaFile(File genFolder, String packageName, String destClassName, String content) {
		File folder = new File(genFolder, packageName.replaceAll("\\.", "/"));
		if (!folder.exists()) {
			folder.mkdirs();
		}
		
		File javaFile = new File(folder, destClassName + ".java");
		try {
			FileWriter fw = new FileWriter(javaFile);
			fw.write(content);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void buildBuilders() {
		
		StringBuilder importBuilder = new StringBuilder();
		StringBuilder hint = new StringBuilder();
		for (Class<?> modelClass : this.classesToBuild) {
			importBuilder.append("import ")
				.append(modelClass.getName())
				.append(";\n")
				.append("import ")
				.append(modelClass.getName())
				.append(builderSuffix)
				.append(";\n");
			
			hint.append(".put(")
				.append(modelClass.getSimpleName())
				.append(".class, ")
				.append(modelClass.getSimpleName())
				.append(builderSuffix)
				.append(".class)\n\t\t\t\t");
		}
		if (hint.length() >= 5)
			hint.delete(hint.length() - 5, hint.length());
		
		
		StringBuilder builder = new StringBuilder();

		builder.append(new StringReplacer(getTemplates().getProperty("builders_declare"))
				.replace("packageName", this.buildersPackageName)
				.replace("Builders", buildersClassName)
				.replace("import Person;", importBuilder.toString())
				.replace(".put(Person.class, PersonBuilder.class)", hint.toString())
				);
		
		for (Class<?> modelClass : this.classesToBuild) {
			String className = modelClass.getSimpleName();
			String classCamelCase = toCamelCase(className);
			String builderClassName = className + builderSuffix;
			
			builder.append(new StringReplacer(getTemplates().getProperty("builders_each_model_class"))
					.replace("PersonBuilder", builderClassName)
					.replace("Person", className)
					.replace("person", classCamelCase));
				
		}
		
		builder.append("}\n");
		

		File folder = new File(baseFolder, buildersPackageName.replaceAll("\\.", "/"));
		if (!folder.exists()) {
			folder.mkdirs();
		}
		
		File javaFile = new File(folder, buildersClassName + ".java");
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
	
	private static String toUpperCamelCase(String camelCase) {
		return Character.toUpperCase(camelCase.charAt(0))+ camelCase.substring(1);
	}	
	
	
}

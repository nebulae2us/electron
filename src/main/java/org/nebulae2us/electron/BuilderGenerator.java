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

import static org.nebulae2us.electron.util.Immutables.$;

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
			if (srcClass.isInterface()) {
				buildInterfaceBuilder(srcClass);
			}
			else {
				buildClassBuilder(srcClass);
			}
		}
		
	}

	private void buildInterfaceBuilder(Class<?> srcClass) {
		String packageName = srcClass.getPackage().getName();

		String srcClassName = srcClass.getSimpleName();

		String packageDeclare = "package " + packageName + ";\n";
		
		ImportStatementGenerator importGenerator = new ImportStatementGenerator(packageName);
		importGenerator.importPackage("org.nebulae2us.electron");
		importGenerator.importClass(srcClass);
		
		StringBuilder annotationDeclare = new StringBuilder("@Builder(destination=").append(srcClassName).append(".class)");
		String destClassName = srcClassName + this.builderSuffix;
		StringBuilder interfaceDeclare = new StringBuilder().append("public interface ").append(destClassName).append(" {}\n");
		
		StringBuilder result = new StringBuilder();
		result.append(packageDeclare).append("\n")
			.append(importGenerator.toString()).append("\n")
			.append(annotationDeclare).append("\n")
			.append(interfaceDeclare);
		
		generateJavaFile(baseFolder, packageName, destClassName, result.toString());
	}
	
	private void buildClassBuilder(Class<?> srcClass) {

		String packageName = srcClass.getPackage().getName();

		String srcClassName = srcClass.getSimpleName();
		
		ClassHolder srcClassHolder = ClassHolder.newInstance(srcClass);
		TypeHolder srcTypeNoVariable = srcClassHolder.eraseTypeVariables();
		ClassHolder destClassHolder = srcClassHolder.toBuilderClassHolder(this.builderSuffix, "P", classesToBuild);
		String destClassDeclaration = destClassHolder.toString();
		String destClassReturnName = destClassDeclaration;
		String destClassName = destClassHolder.getName();
		
		Class<?> srcSuperClass = getSourceSuperClass(srcClass, classesToBuild);
		ClassHolder destSuperClassHolder = ClassHolder.newInstance(srcSuperClass).toBuilderClassHolder(this.builderSuffix, "P", classesToBuild);
		String destSuperClassDeclaration = destSuperClassHolder.toString();
		
		StringBuilder result = new StringBuilder();
		
		String packageDeclare = "package " + packageName + ";\n";
		
		ImportStatementGenerator importGenerator = new ImportStatementGenerator(packageName);
		importGenerator.importPackage("org.nebulae2us.electron");
		importGenerator.importPackage("org.nebulae2us.electron.util");
		importGenerator.importPackage("java.util");
		importGenerator.importClass(srcSuperClass);
		importGenerator.importPackage(buildersPackageName);
		importGenerator.importClasses(srcClassHolder);
		
		StringBuilder annotationDeclare = new StringBuilder("@Builder(destination=").append(srcClassName).append(".class)");
		
		
		StringBuilder classDeclare = new StringBuilder().append("public class ").append(destClassDeclaration);
		if (srcSuperClass != Object.class) {
			classDeclare.append(" extends ").append(destSuperClassDeclaration);
		}
		else {
			classDeclare.append(" implements Wrappable<").append(srcTypeNoVariable.toString()).append(">");
			for (Class<?> classToBuild : classesToBuild) {
				if (classToBuild.isInterface() && classToBuild.isAssignableFrom(srcClass)) {
					classDeclare.append(", ")
						.append(ClassHolder.newInstance(classToBuild).toBuilderClassHolder(this.builderSuffix, "P", classesToBuild));
				}
			}
			
		}
		
		StringBuilder classContent = new StringBuilder();
		
		if (srcSuperClass == Object.class) {
			TreeMap<Integer, StringBuilder> textBlocks = prepareTextBlocks("builder_constructors");
			
			textBlocks.put(0, new StringBuilder(
					new StringReplacer(textBlocks.get(0).toString())
					.replace("Book<? extends Color, ? extends Paper<? extends Color>, ? extends Recordable<? extends Color>, ? extends List<? extends Paper<? extends Color>>>", srcTypeNoVariable.toString())
					.replace("BookBuilderSpec<P>", destClassReturnName)
					.replace("BookBuilderSpec", destClassName)
					.replace("Book", srcClassName)
					.toString()
					));
			
			
			if (srcClassHolder.getTypeVariables().size() > 0) {
				textBlocks.put(1, new StringBuilder(
						new StringReplacer(textBlocks.get(1).toString())
						.replace("Book", srcClassName)
						.replace("<C extends Color & Serializable, T extends Paper<C>, R extends Recordable<C>, L extends List<? extends T>>", srcClassHolder.toVariableDeclaration())
						.replace("<C, T, R, L>", $(srcClassHolder.toVariableList()).join(", ", "<", ">"))
						.replace("Class<C> C, Class<T> T, Class<R> R, Class<L> L", $(srcClassHolder.toVariableList()).formatElement("Class<%1$s> %1$s").join(", "))
						.toString()
						));
			}
			else {
				textBlocks.put(1, new StringBuilder());
			}
			
			classContent.append(mergeBlocks(textBlocks));
		}
		else {
			
			TreeMap<Integer, StringBuilder> textBlocks = prepareTextBlocks("subclass_constructors");
			
			textBlocks.put(0, new StringBuilder(
					new StringReplacer(textBlocks.get(0).toString())
					.replace("Fiction<? extends Color, ? extends Recordable<? extends Color>, ? extends Set<? super Recordable<? extends Color>>>", srcTypeNoVariable.toString())
					.replace("FictionBuilderSpec<P>", destClassReturnName)
					.replace("FictionBuilderSpec", destClassName)
					.replace("Fiction", srcClassName)
					.toString()
					));
			
			if (srcClassHolder.getTypeVariables().size() > 0) {
				textBlocks.put(1, new StringBuilder(
						new StringReplacer(textBlocks.get(1).toString())
						.replace("Fiction", srcClassName)
						.replace("<C extends Color & Serializable, R extends Recordable<C>, S extends Set<? super R>>", srcClassHolder.toVariableDeclaration())
						.replace("<C, R, S>", $(srcClassHolder.toVariableList()).join(", ", "<", ">"))
						.replace("Class<C> C, Class<R> R, Class<S> S", $(srcClassHolder.toVariableList()).formatElement("Class<%1$s> %1$s").join(", "))
						.toString()
						));
			}
			else {
				textBlocks.put(1, new StringBuilder());
			}
			
			StringBuilder block2 = new StringBuilder();
			String block2template = textBlocks.get(2).toString();
			textBlocks.put(2, block2);
			
			Class<?> c = srcClass;
			while ((c = c.getSuperclass()) != null) {
				if (classesToBuild.contains(c)) {
					String superClassName = c.getSimpleName();
					
					block2.append(new StringReplacer(block2template)
							.replace("Fiction<? extends Color, ? extends Recordable<? extends Color>, ? extends Set<? super Recordable<? extends Color>>>", srcTypeNoVariable.toString())
							.replace("Fiction", srcClassName)
							.replace("Book", superClassName)
							.toString());
					
				}
			}
			
			
			classContent.append(mergeBlocks(textBlocks));
			
			
		}

		for (Field field : ClassUtils.getFields(srcClass)) {
			TypeHolder typeHolder = ClassHolder.newInstance(field.getDeclaringClass()).eraseTypeVariables(field);
			importGenerator.importClasses(typeHolder);
			
			boolean notDefined = field.getDeclaringClass() == srcClass || srcSuperClass == Object.class || !classesToBuild.contains(field.getDeclaringClass());
			
			if (notDefined) {
				classContent.append(generateGetterSetter(field, typeHolder));
			}
			
			String fieldName = field.getName();
			String fieldNameTitleCase = StringUtils.toUpperCamelCase(fieldName);
			
			switch (typeHolder.getClassHolderType()) {
			case SINGLE:
				if (notDefined) {
					classContent.append(new StringReplacer(getTemplates().getProperty("builder_single_type_field"))
							.replace("PaperBuilderSpec<?>", typeHolder.toBuilderTypeHolder(this.builderSuffix, "?", classesToBuild).toString())
							.replace("myPaper", fieldName)
							.replace("MyPaper", fieldNameTitleCase)
							.replace("BookBuilderSpec<P>", destClassReturnName)
							);

					if (classesToBuild.contains(typeHolder.getRawClass())) {
						classContent.append(new StringReplacer(getTemplates().getProperty("builder_single_type_builder_field"))
								.replace("BookBuilderSpec<P>", destClassReturnName)
								.replace("PaperBuilderSpec<?>", typeHolder.toBuilderTypeHolder(this.builderSuffix, "?", classesToBuild).toString())
								.replace("BookBuilderSpec", destClassName)
								.replace("myPaper", fieldName)
								.replace("Paper", typeHolder.getRawClass().getSimpleName())
								.replace("PaperBuilderSpec", typeHolder.getRawClass().getSimpleName() + this.builderSuffix)
								.replace("BuilderSpecs", this.buildersClassName)
								);
					
						if (typeHolder.getRawClass().isInterface()) {
							
						}
						else {
							classContent.append(new StringReplacer(getTemplates().getProperty("builder_single_type_builder_field_subedit"))
									.replace("BookBuilderSpec<P>", destClassReturnName)
									.replace("BookBuilderSpec", destClassName)
									.replace("myPaper", fieldName)
									.replace("Paper", typeHolder.getRawClass().getSimpleName())
									.replace("PaperBuilderSpec", typeHolder.getRawClass().getSimpleName() + this.builderSuffix)
									);
						}
						
						for (Class<?> classToBuild : classesToBuild) {
							if (typeHolder.getRawClass().isAssignableFrom(classToBuild) && typeHolder.getRawClass() != classToBuild) {
								ClassHolder subSrcClassHolder = ClassHolder.newInstance(classToBuild);
								ClassHolder subDestClassHolder = subSrcClassHolder.toBuilderClassHolder(this.builderSuffix, "P", classesToBuild);
								
								importGenerator.importClasses(subSrcClassHolder);
								importGenerator.importClasses(subDestClassHolder);
								
								classContent.append(new StringReplacer(getTemplates().getProperty("builder_single_type_builder_field_subedit_each_subclass"))
										.replace("BookBuilderSpec<P>", destClassReturnName)
										.replace("CopyPaperBuilderSpec", subDestClassHolder.getName())
										.replace("CopyPaper", subSrcClassHolder.getName())
										.replace("myPaper", fieldName)
										);
								
							}
						}
					
					}
					
					
					
				}
				else {
					classContent.append(new StringReplacer(getTemplates().getProperty("subclass_single_type_field"))
							.replace("PaperBuilderSpec<?>", typeHolder.toBuilderTypeHolder(this.builderSuffix, "?", classesToBuild).toString())
							.replace("myPaper", fieldName)
							.replace("MyPaper", fieldNameTitleCase)
							.replace("FictionBuilderSpec<P>", destClassReturnName)
							);

					if (classesToBuild.contains(typeHolder.getRawClass())) {
						classContent.append(new StringReplacer(getTemplates().getProperty("subclass_single_type_builder_field"))
								.replace("SubSampleBuilderSpec<P>", destClassReturnName)
								.replace("SubSampleBuilderSpec", destClassName)
								.replace("blank", fieldName)
								.replace("BlankBuilderSpec", typeHolder.getRawClass().getSimpleName() + this.builderSuffix)
								.replace("Blank", typeHolder.getRawClass().getSimpleName())
								.replace("BuilderSpecs", this.buildersClassName)
								);
						
						if (typeHolder.getRawClass().isInterface()) {
							
						}
						else {
							classContent.append(new StringReplacer(getTemplates().getProperty("subclass_single_type_builder_field_subedit"))
							.replace("FictionBuilder<P>", destClassReturnName)
									.replace("FictionBuilder", destClassName)
									.replace("myPaper", fieldName)
									.replace("PaperBuilder", typeHolder.getRawClass().getSimpleName() + this.builderSuffix)
									);
						}
						
						for (Class<?> classToBuild : classesToBuild) {
							if (typeHolder.getRawClass().isAssignableFrom(classToBuild) && typeHolder.getRawClass() != classToBuild) {
								ClassHolder subSrcClassHolder = ClassHolder.newInstance(classToBuild);
								ClassHolder subDestClassHolder = subSrcClassHolder.toBuilderClassHolder(this.builderSuffix, "P", classesToBuild);
								
								importGenerator.importClasses(subSrcClassHolder);
								importGenerator.importClasses(subDestClassHolder);
								
								classContent.append(new StringReplacer(getTemplates().getProperty("subclass_single_type_builder_field_subedit_each_subclass"))
										.replace("FictionBuilderSpec<P>", destClassReturnName)
										.replace("CopyPaperBuilderSpec", subDestClassHolder.getName())
										.replace("CopyPaper", subSrcClassHolder.getName())
										.replace("myPaper", fieldName)
										);
								
							}
						}
						
					}
				}
				
				
				break;
			case COLLECTION:
				
				if (notDefined) {
					TreeMap<Integer, StringBuilder> textBlocks = prepareTextBlocks("builder_collection");

					TypeHolder collectionElementTypeHolder = typeHolder.getTypeParams().get(0);
					String mutableCollectionName = getMutableCollectionType(typeHolder.getRawClass()).getSimpleName();
					TypeHolder collectionElementBuilderTypeHolder = collectionElementTypeHolder.toBuilderTypeHolder(this.builderSuffix, "?", classesToBuild);
					
					textBlocks.put(0, new StringBuilder(
							new StringReplacer(textBlocks.get(0).toString())
							.replace("PaperBuilderSpec<?>", collectionElementBuilderTypeHolder.toString())
							.replace("PaperBuilderSpec", collectionElementBuilderTypeHolder.getName())
							.replace("myPapers", fieldName)
							.replace("BookBuilderSpec<P>", destClassReturnName)
							.replace("BookBuilderSpec", destClassName)
							.replace("ArrayList", mutableCollectionName)
							.replace("BuilderSpecs", this.buildersClassName)
							.toString()
					));
					
					if (classesToBuild.contains(collectionElementTypeHolder.getRawClass())) {
						textBlocks.put(1, new StringBuilder(
								new StringReplacer(textBlocks.get(1).toString())
								.replace("PaperBuilderSpec<?>", collectionElementBuilderTypeHolder.toString())
								.replace("PaperBuilderSpec", collectionElementBuilderTypeHolder.getName())
								.replace("Paper", collectionElementTypeHolder.getName())
								.replace("myPapers", fieldName)
								.replace("MyPapers", fieldNameTitleCase)
								.replace("BookBuilderSpec<P>", destClassReturnName)
								.replace("BookBuilderSpec", destClassName)
								.replace("ArrayList", mutableCollectionName)
								.replace("BuilderSpecs", this.buildersClassName)
								.toString()
						));
						
						StringBuilder block2 = new StringBuilder();
						String block2template = textBlocks.get(2).toString();
						textBlocks.put(2, block2);
						String block3template = textBlocks.get(3).toString();
						StringBuilder block3 = new StringBuilder();
						textBlocks.put(3, block3);
						
						for (Class<?> classToBuild : classesToBuild) {
							if (!classToBuild.isInterface() && collectionElementTypeHolder.getRawClass().isAssignableFrom(classToBuild)) {
								ClassHolder subSrcClassHolder = ClassHolder.newInstance(classToBuild);
								
								block2.append(
										new StringReplacer(block2template)
										.replace("PaperBuilderSpec<?>", collectionElementBuilderTypeHolder.toString())
										.replace("PaperBuilderSpec", collectionElementBuilderTypeHolder.getName())
										.replace("CopyPaperBuilderSpec", subSrcClassHolder.toBuilderClassHolder(this.builderSuffix, "?", classesToBuild).getName())
										.replace("myPapers", fieldName)
										.replace("MyPapers", fieldNameTitleCase)
										.replace("CopyPaper", subSrcClassHolder.getName())
										.replace("copyPaper", StringUtils.toCamelCase(subSrcClassHolder.getName()))
										.replace("BookBuilderSpec<P>", destClassReturnName)
										.replace("BookBuilderSpec", destClassName)
										.replace("ArrayList", mutableCollectionName)
										.replace("BuilderSpecs", this.buildersClassName)
										.toString()
										);

								block3.append(
										new StringReplacer(block3template)
										.replace("PaperBuilderSpec<?>", collectionElementBuilderTypeHolder.toString())
										.replace("PaperBuilderSpec", collectionElementBuilderTypeHolder.getName())
										.replace("CopyPaperBuilderSpec", subSrcClassHolder.toBuilderClassHolder(this.builderSuffix, "?", classesToBuild).getName())
										.replace("myPapers", fieldName)
										.replace("MyPapers", fieldNameTitleCase)
										.replace("CopyPaper", subSrcClassHolder.getName())
										.replace("copyPaper", StringUtils.toCamelCase(subSrcClassHolder.getName()))
										.replace("BookBuilderSpec<P>", destClassReturnName)
										.replace("BookBuilderSpec", destClassName)
										.replace("ArrayList", mutableCollectionName)
										.replace("BuilderSpecs", this.buildersClassName)
										.toString()
										);
								
							}
						}
					}
					else {
						textBlocks.put(1, new StringBuilder());
						textBlocks.put(2, new StringBuilder());
						textBlocks.put(3, new StringBuilder());
					}
					
					mergeBlocks(textBlocks);
					classContent.append(textBlocks.get(0));
					
				}
				else {
					TreeMap<Integer, StringBuilder> textBlocks = prepareTextBlocks("subclass_collection");

					TypeHolder collectionElementTypeHolder = typeHolder.getTypeParams().get(0);
					TypeHolder collectionElementBuilderTypeHolder = collectionElementTypeHolder.toBuilderTypeHolder(this.builderSuffix, "?", classesToBuild);

					textBlocks.put(0, new StringBuilder(
							new StringReplacer(textBlocks.get(0).toString())
							.replace("PaperBuilderSpec<?>", collectionElementBuilderTypeHolder.toString())
							.replace("PaperBuilderSpec", collectionElementBuilderTypeHolder.getName())
							.replace("Paper", collectionElementTypeHolder.getName())
							.replace("myPapers", fieldName)
							.replace("MyPapers", fieldNameTitleCase)
							.replace("FictionBuilderSpec<P>", destClassReturnName)
							.replace("FictionBuilderSpec", destClassName)
							.replace("BuilderSpecs", this.buildersClassName)
							.toString()
					));

					if (classesToBuild.contains(collectionElementTypeHolder.getRawClass())) {
						textBlocks.put(1, new StringBuilder(
								new StringReplacer(textBlocks.get(1).toString())
								.replace("PaperBuilderSpec<?>", collectionElementBuilderTypeHolder.toString())
								.replace("PaperBuilderSpec", collectionElementBuilderTypeHolder.getName())
								.replace("Paper", collectionElementTypeHolder.getName())
								.replace("myPapers", fieldName)
								.replace("MyPapers", fieldNameTitleCase)
								.replace("FictionBuilderSpec<P>", destClassReturnName)
								.replace("FictionBuilderSpec", destClassName)
								.replace("BuilderSpecs", this.buildersClassName)
								.toString()
						));
						
						StringBuilder block2 = new StringBuilder();
						String block2template = textBlocks.get(2).toString();
						textBlocks.put(2, block2);
						
						for (Class<?> classToBuild : classesToBuild) {
							if (!classToBuild.isInterface() && collectionElementTypeHolder.getRawClass().isAssignableFrom(classToBuild)) {
								ClassHolder subSrcClassHolder = ClassHolder.newInstance(classToBuild);
								block2.append(
										new StringReplacer(block2template)
										.replace("PaperBuilderSpec<?>", collectionElementBuilderTypeHolder.toString())
										.replace("PaperBuilderSpec", collectionElementBuilderTypeHolder.getName())
										.replace("CopyPaperBuilderSpec", subSrcClassHolder.toBuilderClassHolder(this.builderSuffix, "?", classesToBuild).getName())
										.replace("myPapers", fieldName)
										.replace("MyPapers", fieldNameTitleCase)
										.replace("CopyPaper", subSrcClassHolder.getName())
										.replace("copyPaper", StringUtils.toCamelCase(subSrcClassHolder.getName()))
										.replace("FictionBuilderSpec<P>", destClassReturnName)
										.replace("FictionBuilderSpec", destClassName)
										.replace("BuilderSpecs", this.buildersClassName)
										.toString()
										);
								
								
							}
						}

					}
					else {
						textBlocks.put(1, new StringBuilder());
						textBlocks.put(2, new StringBuilder());
					}
					
					mergeBlocks(textBlocks);
					classContent.append(textBlocks.get(0));
				}
				
				break;
			case MAP:
				if (notDefined) {
					
					TreeMap<Integer, StringBuilder> textBlocks = prepareTextBlocks("builder_map");
					
					TypeHolder mapKeyTypeHolder = typeHolder.getTypeParams().get(0);
					TypeHolder mapKeyBuilderTypeHolder = mapKeyTypeHolder.toBuilderTypeHolder(this.builderSuffix, "?", classesToBuild);
					TypeHolder mapValueTypeHolder = typeHolder.getTypeParams().get(1);
					TypeHolder mapValueBuilderTypeHolder = mapValueTypeHolder.toBuilderTypeHolder(this.builderSuffix, "?", classesToBuild);
					String mutableCollectionName = getMutableCollectionType(typeHolder.getRawClass()).getSimpleName();

					
					textBlocks.put(0, new StringBuilder(
							new StringReplacer(textBlocks.get(0).toString())
							.replace("PaperBuilderSpec<?>", mapKeyBuilderTypeHolder.toString())
							.replace("ColorBuilderSpec<?>", mapValueBuilderTypeHolder.toString())
							.replace("HashMap", mutableCollectionName)
							.replace("BuilderSpecs", this.buildersClassName)
							.replace("paperColors", fieldName)
							.replace("PaperColors", fieldNameTitleCase)
							.replace("BookBuilderSpec<P>", destClassReturnName)
							.replace("BookBuilderSpec", destClassName)
							.toString()
							));
					
					if (this.classesToBuild.contains(mapValueTypeHolder.getRawClass())) {
						
						StringBuilder block1 = new StringBuilder();
						String block1template = textBlocks.get(1).toString();
						textBlocks.put(1, block1);
						
						for (Class<?> classToBuild : classesToBuild) {
							if (!classToBuild.isInterface() && mapValueTypeHolder.getRawClass().isAssignableFrom(classToBuild)) {
								ClassHolder valueSrcClassHolder = ClassHolder.newInstance(classToBuild);
								ClassHolder valueSrcBuilderClassHolder = valueSrcClassHolder.toBuilderClassHolder(this.builderSuffix, "?", classesToBuild);
								
								block1.append(new StringReplacer(block1template)
										.replace("RGBColor", valueSrcClassHolder.getName())
										.replace("RGBColorBuilderSpec", valueSrcBuilderClassHolder.getName())
										.replace("paperColors", fieldName)
										.replace("PaperColors", fieldNameTitleCase)
										.replace("BookBuilderSpec", destClassName)
										.toString());

							}
						}
					}
					else {
						textBlocks.put(1, new StringBuilder());
					}
					
					if (this.classesToBuild.contains(mapKeyTypeHolder.getRawClass())) {
						StringBuilder block2 = new StringBuilder();
						String block2template = textBlocks.get(2).toString();
						textBlocks.put(2, block2);
						
						for (Class<?> classToBuild : classesToBuild) {
							if (!classToBuild.isInterface() && mapKeyTypeHolder.getRawClass().isAssignableFrom(classToBuild)) {
								ClassHolder keySrcClassHolder = ClassHolder.newInstance(classToBuild);
								ClassHolder keySrcBuilderClassHolder = keySrcClassHolder.toBuilderClassHolder(this.builderSuffix, "?", classesToBuild);
								
								block2.append(new StringReplacer(block2template)
										.replace("CopyPaper", keySrcClassHolder.getName())
										.replace("CopyPaperBuilderSpec", keySrcBuilderClassHolder.getName())
										.replace("paperColors", fieldName)
										.replace("PaperColors", fieldNameTitleCase)
										.replace("BookBuilderSpec", destClassName)
										.toString());

							}
						}
						
					}
					else {
						textBlocks.put(2, new StringBuilder());
					}
					
					classContent.append(mergeBlocks(textBlocks));
					
				}
				else {
					classContent.append(new StringReplacer(getTemplates().getProperty("subclass_map_type_field"))
							.replace("String", typeHolder.getTypeParams().get(0).toBuilderTypeHolder(this.builderSuffix, "?", classesToBuild).toString())
							.replace("Integer", typeHolder.getTypeParams().get(1).toBuilderTypeHolder(this.builderSuffix, "?", classesToBuild).toString())
							.replace("keywordCounts", fieldName)
							.replace("KeywordCounts", fieldNameTitleCase)
							.replace("SubSampleBuilderSpec<P>", destClassReturnName)
							.replace("SubSampleBuilderSpec", destClassName)
							.replace("BuilderSpecs", this.buildersClassName)
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

	private TreeMap<Integer, StringBuilder> prepareTextBlocks(String templateName) {
		TreeMap<Integer, StringBuilder> textBlocks = new TreeMap<Integer, StringBuilder>();
		String collectionTemplate = getTemplates().getProperty(templateName);
		List<String> lines = Arrays.asList(collectionTemplate.split("\\r?\\n"));
		Stack<Integer> blocks = new Stack<Integer>();
		blocks.push(0);
		for (String line : lines) {
			int block = blocks.peek();
			StringBuilder textBlock = textBlocks.get(block);
			if (textBlock == null) {
				textBlock = new StringBuilder();
				textBlocks.put(block, textBlock);
			}
			
			if (line.trim().startsWith("//{")) {
				block = Integer.parseInt(line.trim().substring(3, 5).trim());
				textBlock.append("// Block ").append(block).append("\n");
				blocks.push(block);
				continue;
			}
			else if (line.trim().startsWith("//}")) {
				blocks.pop();
				continue;
			}

			textBlock.append(line).append("\n");
		}
		return textBlocks;
	}

	private String mergeBlocks(TreeMap<Integer, StringBuilder> textBlocks) {

		int maxBlock = textBlocks.lastEntry().getKey();
		
		for (Integer key : textBlocks.descendingKeySet()) {
			StringBuilder textblock = textBlocks.get(key);
			for (int j = key+1; j <= maxBlock; j++) {
				int idx = 0;
				String blockMarker = "// Block " + j;
				while ((idx = textblock.indexOf(blockMarker)) > -1) {
					textblock.replace(idx, idx + blockMarker.length(), textBlocks.get(j).toString());
				}
			}
		}
		return textBlocks.get(0).toString();
	}

	private StringReplacer generateGetterSetter(Field field,
			TypeHolder typeHolder) {
		return new StringReplacer(getTemplates().getProperty("builder_fieldname_getter_settter"))
				.replace("PaperBuilderSpec<?>", typeHolder.toBuilderTypeHolder(this.builderSuffix, "?", classesToBuild).toString())
				.replace("myPaper", field.getName())
				.replace("MyPaper", StringUtils.toUpperCamelCase(field.getName()));
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

	private static Class<?> getSourceSuperClass(Class<?> modelClass, List<Class<?>> modelClasses) {
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
				.replace("BuilderSpecs", buildersClassName)
				.replace("import Person;", importBuilder.toString())
				.replace(".put(Person.class, PersonBuilder.class)", hint.toString())
				);
		
		for (Class<?> modelClass : this.classesToBuild) {
			
			if (modelClass.isInterface()) {
				continue;
			}
			
			ClassHolder srcClassHolder = ClassHolder.newInstance(modelClass);
			ClassHolder destClassHolder = srcClassHolder.toBuilderClassHolder(builderSuffix, "?", classesToBuild);
			
			String className = modelClass.getSimpleName();
			String classCamelCase = StringUtils.toCamelCase(className);
			
			builder.append(new StringReplacer(getTemplates().getProperty("builders_each_model_class"))
					.replace("BookBuilderSpec<?>", destClassHolder.toString())
					.replace("BookBuilderSpec", destClassHolder.getName())
					.replace("Book", srcClassHolder.getName())
					.replace("book", classCamelCase));
				
		}
		
		builder.append("}\n");

		generateJavaFile(baseFolder, buildersPackageName, buildersClassName, builder.toString());

		
	}
}

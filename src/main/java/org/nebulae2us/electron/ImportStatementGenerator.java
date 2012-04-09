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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.nebulae2us.electron.reflect.ClassHolder;
import org.nebulae2us.electron.reflect.TypeHolder;
import org.nebulae2us.electron.reflect.TypeVariableHolder;

/**
 * @author Trung Phan
 *
 */
public class ImportStatementGenerator {

	private final List<String> packageNames = new ArrayList<String>();
	private final String thisPackageName;

	public ImportStatementGenerator(String thisPackageName) {
		this.thisPackageName = thisPackageName;
	}
	
	public void importPackage(String packageName) {
		if (packageName.length() == 0 || packageName.equals("java.lang") || thisPackageName.equals(packageName)) {
			return;
		}

		if (!packageNames.contains(packageName)) {
			packageNames.add(packageName);
		}
	}
	
	public void importClass(Class<?> c) {
		if (c.getPackage() != null) {
			importPackage(c.getPackage().getName());
		}
	}

	public void importClasses(ClassHolder classHolder) {
		if (classHolder != null) {
			if (classHolder.getRawClass() != null) {
				importClass(classHolder.getRawClass());
			}
			else {
				importPackage(classHolder.getPackageName());
			}
			
			for (TypeVariableHolder typeVariable : classHolder.getTypeVariables()) {
				for (TypeHolder typeHolder : typeVariable.getTypeParams()) {
					importClasses(typeHolder);
				}
			}
		}
	}
	
	public void importClasses(TypeHolder typeHolder) {
		if (typeHolder != null) {
			if (typeHolder.getRawClass() != null) {
				importClass(typeHolder.getRawClass());
			}
			else {
				importPackage(typeHolder.getPackageName());
			}
			if (typeHolder.getTypeParams() != null) {
				for (TypeHolder ch : typeHolder.getTypeParams()) {
					importPackage(ch.getPackageName());
				}
			}
		}
	}
	
	public String generate() {
		StringBuilder result = new StringBuilder();
		Collections.sort(packageNames);
		
		for (String packageName : packageNames) {
			result.append("import ").append(packageName).append(".*;\n");
		}
		
		return result.toString();
	}
	
	@Override
	public String toString() {
		return generate();
	}
	
	
}

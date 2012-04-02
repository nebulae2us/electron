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

import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

import org.nebulae2us.electron.util.ImmutableList;

/**
 * @author Trung Phan
 *
 */
public class ClassHolder {

	private final String name;
	
	private final String packageName;
	
	private final Class<?> rawClass;
	
	private final List<TypeVariableHolder> typeVariables;
	
	private ClassHolder(
			String name,
			String packageName,
			Class<?> rawClass,
			List<TypeVariableHolder> typeVariables) {

		this.name = name;
		this.packageName = packageName;
		this.rawClass = rawClass;
		this.typeVariables = typeVariables == null ? new ImmutableList<TypeVariableHolder>() : new ImmutableList<TypeVariableHolder>(typeVariables);
	}

	public String getName() {
		return name;
	}

	public String getPackageName() {
		return packageName;
	}

	public Class<?> getRawClass() {
		return rawClass;
	}

	public List<TypeVariableHolder> getTypeVariables() {
		return typeVariables;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(name);
		
		if (typeVariables.size() > 0) {
			result.append('<');
			for (TypeVariableHolder typeVariable : typeVariables) {
				result.append(typeVariable.toString()).append(", ");
			}
			result.replace(result.length() - 2, result.length(), ">");
		}
		
		return result.toString();
	}
	
	public static ClassHolder newInstance(Class<?> srcClass) {
		
		List<TypeVariableHolder> typeVariableHolders = new ArrayList<TypeVariableHolder>();
		
		TypeVariable<?>[] typeVariables = srcClass.getTypeParameters();
		
		for (TypeVariable<?> typeVariable : typeVariables) {
			TypeVariableHolder typeVariableHolder = TypeVariableHolder.newInstance(typeVariable);
			typeVariableHolders.add(typeVariableHolder);
		}
		
		return new ClassHolder(srcClass.getSimpleName(), srcClass.getPackage().getName(), srcClass, typeVariableHolders);
		
	}
	
	public ClassHolder toBuilderClassHolder(String builderSuffix, String parentBuilderVariableName, List<Class<?>> classesToBuild) {
		
		List<TypeVariableHolder> newBuilderTypeVariables = new ArrayList<TypeVariableHolder>();
		
		for (TypeVariableHolder typeVariable : typeVariables) {
			newBuilderTypeVariables.add(typeVariable.toBuilderTypeVariableHolder(builderSuffix, parentBuilderVariableName, classesToBuild));
		}
		
		if (classesToBuild.contains(rawClass)) {
			newBuilderTypeVariables.add(0, new TypeVariableHolder(parentBuilderVariableName, null));
			return new ClassHolder(name + builderSuffix, packageName, rawClass, newBuilderTypeVariables);
		}
		
		return new ClassHolder(name, packageName, rawClass, newBuilderTypeVariables);
	}	
	
}

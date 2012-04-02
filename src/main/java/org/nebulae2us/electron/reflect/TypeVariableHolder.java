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

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

import org.nebulae2us.electron.util.ImmutableList;

/**
 * @author Trung Phan
 *
 */
public class TypeVariableHolder {

	private final String name;
	
	private final List<TypeHolder> typeParams;
	
	public TypeVariableHolder(String name, List<TypeHolder> typeParams) {
		this.name = name;
		this.typeParams = typeParams == null ? new ImmutableList<TypeHolder>() : new ImmutableList<TypeHolder>(typeParams);
	}

	public String getName() {
		return name;
	}

	public List<TypeHolder> getTypeParams() {
		return typeParams;
	}

	public static TypeVariableHolder newInstance(TypeVariable<?> typeVariable) {
		
		List<TypeHolder> typeHolders = new ArrayList<TypeHolder>();
		
		for (Type type : typeVariable.getBounds()) {
			if (type != Object.class) {
				TypeHolder typeHolder = TypeHolder.newInstance(type);
				typeHolders.add(typeHolder);
			}
		}

		return new TypeVariableHolder(typeVariable.getName(), typeHolders);
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(name);
		if (typeParams.size() > 0) {
			result.append(" extends ");
			for (TypeHolder typeParam : typeParams) {
				result.append(typeParam.toString()).append(" & ");
			}
			result.delete(result.length() - 3, result.length());
		}
		
		return result.toString();
	}
	
	public TypeVariableHolder toBuilderTypeVariableHolder(String builderSuffix, String parentBuilderVariableName, List<Class<?>> classesToBuild) {
		List<TypeHolder> newBuilderTypeParams = new ArrayList<TypeHolder>();
		
		for (TypeHolder typeParam : typeParams) {
			newBuilderTypeParams.add(typeParam.toBuilderTypeHolder(builderSuffix, parentBuilderVariableName, classesToBuild));
		}
		
		return new TypeVariableHolder(name, newBuilderTypeParams);
	}
	
	
}

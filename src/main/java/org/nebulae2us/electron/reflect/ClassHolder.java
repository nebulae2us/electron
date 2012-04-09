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

import java.lang.reflect.Field;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
		return this.name + toVariableDeclaration();
	}
	
	public String toVariableDeclaration() {
		StringBuilder result = new StringBuilder();
		
		if (typeVariables.size() > 0) {
			result.append('<');
			for (TypeVariableHolder typeVariable : typeVariables) {
				result.append(typeVariable.toString()).append(", ");
			}
			result.replace(result.length() - 2, result.length(), ">");
		}
		
		return result.toString();
	}
	
	public List<String> toVariableList() {
		List<String> result = new ArrayList<String>();
		
		if (typeVariables.size() > 0) {
			for (TypeVariableHolder typeVariable : typeVariables) {
				result.add(typeVariable.getName());
			}
		}
		return new ImmutableList<String>(result);
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
	
	public TypeHolder eraseTypeVariables() {
		
		List<TypeHolder> newTypeParams = new ArrayList<TypeHolder>();
		
		for (TypeVariableHolder typeVariable : this.typeVariables) {
			Map<String, TypeHolder> variable2Holder = new HashMap<String, TypeHolder>();
			Set<String> visitedVariables = new HashSet<String>();
			visitedVariables.add(typeVariable.getName());
			TypeHolder newTypeParam = null;
			if (typeVariable.getTypeParams().size() == 0) {
				newTypeParam = TypeHolder.newInstance(Object.class).changeWildcardBound(WildcardBound.UPPER);
			}
			else {
				newTypeParam = _eraseTypeVariables(variable2Holder, visitedVariables, typeVariable.getTypeParams().get(0)).changeWildcardBound(WildcardBound.UPPER);
			}
			newTypeParams.add(newTypeParam);
		}
		
		return TypeHolder.newInstance(this.rawClass, newTypeParams);
	}

	public TypeHolder eraseTypeVariables(Field field) {
		
		TypeHolder fieldTypeHolder = TypeHolder.newInstance(field);
		Map<String, TypeHolder> variable2Holder = new HashMap<String, TypeHolder>();
		Set<String> visitedVariables = new HashSet<String>();
		
		TypeHolder result = _eraseTypeVariables(variable2Holder, visitedVariables, fieldTypeHolder);
		
		return result.changeWildcardBound(WildcardBound.NO_WILDCARD);
	}
	
	private TypeHolder _eraseTypeVariables(Map<String, TypeHolder> variable2Holder, Set<String> visitedVariables, TypeHolder typeHolder) {
		
		if (typeHolder.getRawClass() == null) {
			if (variable2Holder.containsKey(typeHolder.getName())) {
				TypeHolder th = variable2Holder.get(typeHolder.getName());
				WildcardBound newWildcardBound = typeHolder.getWildcardBound() == WildcardBound.NO_WILDCARD ? th.getWildcardBound() : typeHolder.getWildcardBound();
				visitedVariables.add(typeHolder.getName());
				return th.changeWildcardBound(newWildcardBound);
			}
			else {
				if (visitedVariables.contains(typeHolder.getName())) {
					return TypeHolder.newInstance(Object.class).changeWildcardBound(WildcardBound.UPPER);
				}
				else {
					visitedVariables.add(typeHolder.getName());
					for (TypeVariableHolder typeVariable : this.typeVariables) {
						if (typeVariable.getName().equals(typeHolder.getName())) {
							if (typeVariable.getTypeParams().size() > 0) {
								TypeHolder th = _eraseTypeVariables(variable2Holder, visitedVariables, typeVariable.getTypeParams().get(0)).changeWildcardBound(WildcardBound.UPPER);
								variable2Holder.put(typeHolder.getName(), th);
								return th;
							}
							else {
								TypeHolder th = TypeHolder.newInstance(Object.class).changeWildcardBound(WildcardBound.UPPER);
								variable2Holder.put(typeHolder.getName(), th);
								return th;
							}
						}
					}
					
					throw new IllegalStateException();
				}
			}
		}
		else {
			
			List<TypeHolder> newTypeParams = new ArrayList<TypeHolder>();
			for (TypeHolder typeParam : typeHolder.getTypeParams()) {
				TypeHolder newTypeParam = _eraseTypeVariables(variable2Holder, visitedVariables, typeParam);
				if (typeParam.getWildcardBound() != WildcardBound.NO_WILDCARD) {
					newTypeParam = newTypeParam.changeWildcardBound(typeParam.getWildcardBound());
				}
				newTypeParams.add(newTypeParam);
			}
			
			return TypeHolder.newInstance(typeHolder.getRawClass(), newTypeParams );
		}
	}
	
	public ClassHolder toBuilderClassHolder(String builderSuffix, String parentBuilderVariableName, List<Class<?>> classesToBuild) {
		
		if (classesToBuild.contains(rawClass)) {
			if (rawClass.isInterface() ) {
				return new ClassHolder(name + builderSuffix, packageName, rawClass, Collections.EMPTY_LIST);
			}
			else {
				return new ClassHolder(name + builderSuffix, packageName, rawClass, Collections.singletonList(new TypeVariableHolder(parentBuilderVariableName, null)));
			}
		}

		List<TypeVariableHolder> newBuilderTypeVariables = new ArrayList<TypeVariableHolder>();
		
		for (TypeVariableHolder typeVariable : typeVariables) {
			newBuilderTypeVariables.add(typeVariable.toBuilderTypeVariableHolder(builderSuffix, parentBuilderVariableName, classesToBuild));
		}
		
		
		return new ClassHolder(name, packageName, rawClass, newBuilderTypeVariables);
	}	
	
}

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
package org.nebulae2us.electron.internal.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.*;

import org.nebulae2us.electron.util.ImmutableList;

import static org.nebulae2us.electron.internal.util.ClassHolderType.*;

/**
 * @author Trung Phan
 *
 */
public class ClassHolder {

	private final Class<?> rawClass;
	
	private final List<ClassHolder> argumentClasses;
	
	private final boolean upper;
	private final boolean lower;
	
	public boolean isUpper() {
		return upper;
	}

	public boolean isLower() {
		return lower;
	}

	public ClassHolderType getClassHolderType() {
		if (Collection.class.isAssignableFrom(rawClass)) {
			if (argumentClasses.size() > 0) {
				ClassHolderType innerType = argumentClasses.get(0).getClassHolderType();
				return innerType == COLLECTION ? MULTI_COLLECTION :
					   innerType == MULTI_COLLECTION ? MULTI_COLLECTION : COLLECTION;
			}
			return COLLECTION;
		}
		else if (Map.class.isAssignableFrom(rawClass)) {
			if (argumentClasses.size() > 1) {
				ClassHolderType innerType = argumentClasses.get(1).getClassHolderType();
				return innerType == COLLECTION ? MULTI_MAP :
					   innerType == MULTI_COLLECTION ? MULTI_MAP: MAP;
			}
			return MAP;
		}
		else{
			return SINGLE;
		}
	}
	
	private ClassHolder(Class<?> rawClass, boolean upper, boolean lower, List<ClassHolder> argumentClasses) {
		if (argumentClasses == null) {
			argumentClasses = new ArrayList<ClassHolder>();
		}
		this.rawClass = rawClass;
		this.argumentClasses = new ImmutableList<ClassHolder>(argumentClasses);
		this.upper = upper;
		this.lower = lower;
	}

	@SuppressWarnings("unchecked")
	public static ClassHolder newInstance(Class<?> rawClass, Class<?> ... argumentClasses) {
		List<ClassHolder> classHolders = new ArrayList<ClassHolder>();
		
		for (Class<?> argumentClass : argumentClasses) {
			ClassHolder classHolder = new ClassHolder(argumentClass, false, false, Collections.EMPTY_LIST);
			classHolders.add(classHolder);
		}
		
		return new ClassHolder(rawClass, false, false, classHolders);
	}

	public static ClassHolder newInstance(Class<?> rawClass, ClassHolder ... argumentClasses) {
		return new ClassHolder(rawClass, false, false, Arrays.asList(argumentClasses));
	}
	
	public static ClassHolder newInstance(Type type) {
		Class<?> rawClass = ClassUtils.getClass(type);
		
		boolean upper = false;
		boolean lower = false;
		
		if (type instanceof WildcardType) {
			WildcardType wildcardType = (WildcardType)type;
			upper = wildcardType.getUpperBounds() != null && wildcardType.getUpperBounds().length > 0;
			lower = wildcardType.getLowerBounds() != null && wildcardType.getLowerBounds().length > 0;
		}
		
		List<ClassHolder> argumentClasses = new ArrayList<ClassHolder>();
		
		if (type instanceof ParameterizedType) {
			ParameterizedType paramType = (ParameterizedType)type;
			Type[] subTypes = paramType.getActualTypeArguments();
			if (subTypes != null) {
				for (Type subType : subTypes) {
					argumentClasses.add(ClassHolder.newInstance(subType));
				}
			}
		}

		return new ClassHolder(rawClass, upper, lower, argumentClasses);
	}
	
	
	public List<ClassHolder> getArgumentClasses() {
		return argumentClasses;
	}

	public Class<?> getRawClass() {
		return rawClass;
	}
	
	public String getBuilderRawClassName(String builderSuffix, List<Class<?>> builderClasses) {
		return builderClasses.contains(rawClass) ? rawClass.getSimpleName() + builderSuffix : rawClass.getSimpleName();
	}
	
	@Override
	public String toString() {
		String className = rawClass.getSimpleName();
		
		StringBuilder result = new StringBuilder();
		if (upper) {
			if (rawClass == Object.class) {
				result.append("?");
			}
			else {
				result.append("? extends ").append(className);
			}
		}
		else if (lower) {
			result.append("? super ").append(className);
		}
		else {
			result.append(className);
		}
		
		if (argumentClasses != null && argumentClasses.size() > 0) {
			result.append("<");
			for (ClassHolder argumentClass : argumentClasses) {
				result.append(argumentClass).append(", ");
			}
			result.replace(result.length() - 2, result.length(), ">");
		}
		return result.toString();
	}
	
	public String toBuilderString(String builderSuffix, List<Class<?>> builderClasses) {
		String className = rawClass.getSimpleName();
		if (builderClasses.contains(rawClass)) {
			className = className + builderSuffix;
		}
		
		StringBuilder result = new StringBuilder();
		if (upper) {
			if (rawClass == Object.class) {
				result.append("?");
			}
			else {
				result.append("? extends ").append(className);
			}
		}
		else if (lower) {
			result.append("? super ").append(className);
		}
		else {
			result.append(className);
		}
		
		if (argumentClasses != null && argumentClasses.size() > 0) {
			result.append("<");
			for (ClassHolder argumentClass : argumentClasses) {
				result.append(argumentClass.toBuilderString(builderSuffix, builderClasses)).append(", ");
			}
			result.replace(result.length() - 2, result.length(), ">");
		}
		return result.toString();
		
	}
}

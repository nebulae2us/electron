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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.nebulae2us.electron.util.ImmutableList;

/**
 * @author Trung Phan
 *
 */
public class ClassHolder {

	private final Class<?> rawClass;
	
	private final List<ClassHolder> argumentClasses;
	
	private ClassHolder(Class<?> rawClass, List<ClassHolder> argumentClasses) {
		this.rawClass = rawClass;
		this.argumentClasses = new ImmutableList<ClassHolder>(argumentClasses);
	}

	@SuppressWarnings("unchecked")
	public static ClassHolder newInstance(Class<?> rawClass, Class<?> ... argumentClasses) {
		List<ClassHolder> classHolders = new ArrayList<ClassHolder>();
		
		for (Class<?> argumentClass : argumentClasses) {
			ClassHolder classHolder = new ClassHolder(argumentClass, Collections.EMPTY_LIST);
			classHolders.add(classHolder);
		}
		
		return new ClassHolder(rawClass, classHolders);
	}

	public static ClassHolder newInstance(Class<?> rawClass, ClassHolder ... argumentClasses) {
		List<ClassHolder> classHolders = new ArrayList<ClassHolder>();
		
		return new ClassHolder(rawClass, classHolders);
	}
	
	public static ClassHolder newInstance(Type type) {
		Class<?> rawClass = ClassUtils.getClass(type);
		
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

		return new ClassHolder(rawClass, argumentClasses);
	}
	
	
	public List<ClassHolder> getArgumentClasses() {
		return argumentClasses;
	}

	public Class<?> getRawClass() {
		return rawClass;
	}
	
	@Override
	public String toString() {
		return rawClass.getSimpleName();
	}
	
}

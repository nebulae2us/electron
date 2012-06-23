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

import java.lang.reflect.Constructor;
import java.util.List;

/**
 * @author Trung Phan
 *
 */
public class WrapConverter extends Converter {

	public WrapConverter(DestinationClassResolver destinationClassResolver, List<Class<?>> ignoredTypes) {
		super(destinationClassResolver, false, ignoredTypes);
	}

	@Override
	protected <T> Pair<T, Boolean> instantiateDestObject(Class<T> destClass,
			Class<?> srcClass, Object srcObject, Mirror mirror) {

		Constructor<?> constructor;
		try {
			constructor = destClass.getDeclaredConstructor(new Class<?>[]{srcClass});
			constructor.setAccessible(true);
		} catch (Exception e1) {
			throw new RuntimeException("Failed to find constructor ", e1);
		}

		T result;
		try {
			result = (T)constructor.newInstance(srcObject);
			return new Pair<T, Boolean>(result, Boolean.TRUE);
		} catch (Exception e) {
			throw new RuntimeException("Failed to create object", e);
		}

	}
}

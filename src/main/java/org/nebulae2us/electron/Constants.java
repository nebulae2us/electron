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

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author Trung Phan
 *
 */
public interface Constants {
	public static final List<Class<?>> SCALAR_TYPES = 
			Arrays.asList(new Class<?>[]{int.class, short.class, byte.class, long.class, double.class, float.class, char.class, boolean.class,
					Integer.class, Short.class, Byte.class, Long.class, 
					Double.class, Float.class, Character.class, Boolean.class,
					BigDecimal.class, BigInteger.class,
					String.class, Date.class});

	public static final List<Class<?>> IMMUTABLE_TYPES =
			Arrays.asList(new Class<?>[] {
					Class.class,
					Field.class
			});
	
}

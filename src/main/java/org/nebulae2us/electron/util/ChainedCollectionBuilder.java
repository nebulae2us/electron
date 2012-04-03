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
package org.nebulae2us.electron.util;

import org.nebulae2us.electron.ConverterOption;
import org.nebulae2us.electron.Procedure;

/**
 * @author Trung Phan
 *
 */
public class ChainedCollectionBuilder<P, E> {
	
	private final Class<?> elementClass;
	
	private final P parentBuilder;
	
	private final Procedure listener;
	
	private final ConverterOption option;
	
	public ChainedCollectionBuilder(Class<?> elementClass, ConverterOption option, P parentBuilder, Procedure listener) {
		this.elementClass = elementClass;
		this.parentBuilder = parentBuilder;
		this.listener = listener;
		this.option = option;
	}

	public ChainedCollectionBuilder<P, E> collection(E ... elements) {
		if (this.listener != null) {
			this.listener.execute(elements);
		}
		return this;
	}
	
	public E item$begin() {
		return null;
	}
	
	public P end () {
		return parentBuilder;
	}

}
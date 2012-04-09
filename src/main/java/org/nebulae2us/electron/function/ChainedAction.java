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
package org.nebulae2us.electron.function;

import java.util.Collection;
import java.util.List;

import org.nebulae2us.electron.ElementContext;
import org.nebulae2us.electron.Function1;
import org.nebulae2us.electron.util.ImmutableList;

/**
 * @author Trung Phan
 *
 */
public class ChainedAction<E> implements Function1<E, ElementContext<E>> {

	private final List<Function1<E, ElementContext<E>>> actions;
	
	public ChainedAction(Function1<E, ElementContext<E>> ... actions) {
		this.actions = new ImmutableList<Function1<E,ElementContext<E>>>(actions);
	}
	
	public ChainedAction(Collection<Function1<E, ElementContext<E>>> actions) {
		this.actions = new ImmutableList<Function1<E,ElementContext<E>>>(actions);
	}

	public E execute(ElementContext<E> context) {
		
		E result = null;
		
		for (Function1<E, ElementContext<E>> action : actions) {
			result = action.execute(context);
			if (context.getAction() == ElementContext.ACTION_SKIP_ELEMENT) {
				return result;
			}
			context = new ElementContext<E>(context.getIndex(), context.getElement());
		}
		return result;
	}

	
	
}

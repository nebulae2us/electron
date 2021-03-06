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

/**
 * @author Trung Phan
 *
 */
public class ElementContext<E> {

	public final static int ACTION_KEEP_ELEMENT = 0;
	public final static int ACTION_SKIP_ELEMENT = 1;
	
	private int index;
	
	private E element;
	
	private int action = ACTION_KEEP_ELEMENT;
	
	public ElementContext() {
		
	}
	
	public ElementContext(int index, E element) {
		this.index = index;
		this.element = element;
	}

	public int getIndex() {
		return index;
	}

	public E getElement() {
		return element;
	}

	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void setElement(E element) {
		this.element = element;
	}

}

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

import java.math.BigDecimal;
import java.math.BigInteger;

import org.nebulae2us.electron.Converter;
import org.nebulae2us.electron.ElementContext;
import org.nebulae2us.electron.Function1;

/**
 * @author Trung Phan
 *
 */
public class AddElement<E extends Number> implements Function1<E, ElementContext<E>> {

	private final Number number;
	
	public AddElement(Number number) {
		this.number = number;
	}
	
	public E execute(ElementContext<E> context) {

		Number element = context.getElement();
		if (element == null) {
			return null;
		}
		
		if (element instanceof Long) {
			return (E)Long.valueOf(element.longValue() + number.longValue());
		}
		
		if (element instanceof Integer) {
			return (E)Integer.valueOf(element.intValue() + number.intValue());
		}

		if (element instanceof Short) {
			return (E)Short.valueOf((short)(element.intValue() + number.intValue()));
		}

		if (element instanceof Byte) {
			return (E)Byte.valueOf((byte)(element.intValue() + number.intValue()));
		}

		if (element instanceof Double) {
			return (E)Double.valueOf(element.doubleValue() + number.doubleValue());
		}

		if (element instanceof Float) {
			return (E)Float.valueOf(element.floatValue() + number.floatValue());
		}
		
		if (element instanceof BigDecimal) {
			return (E)((BigDecimal)element).add(new Converter().convert(number).to(BigDecimal.class));
		}
		
		if (element instanceof BigInteger) {
			return (E)((BigInteger)element).add(new Converter().convert(number).to(BigInteger.class));
		}

		return null;
	}

}

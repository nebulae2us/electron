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

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.nebulae2us.electron.util.NaturalComparator;

/**
 * @author Trung Phan
 *
 */
public class StringReplacer {

	private final Map<String, String> substitutes = new TreeMap<String, String>( Collections.reverseOrder(new NaturalComparator<String>()) );
	private final String text;
	
	public StringReplacer(String text) {
		if (text == null) {
			throw new NullPointerException();
		}
		this.text = text;
	}
	
	public StringReplacer replace(String srcText, String destText) {
		substitutes.put(srcText, destText);
		return this;
	}
	
	@Override
	public String toString() {
		
		String result = text;
		for (Entry<String, String> entry : substitutes.entrySet()) {
			result = result.replaceAll(entry.getKey(), encode(entry.getKey()));
		}
		for (Entry<String, String> entry : substitutes.entrySet()) {
			result = result.replaceAll(encode(entry.getKey()), entry.getValue());
		}
		return result;
	}
	
	private String encode(String text) {
		StringBuilder result = new StringBuilder();
		result.append("```");
		for (int i = 0; i < text.length(); i++) {
			result.append('`').append(text.charAt(i));
		}
		result.append("````");
		return result.toString();
	}
	
}

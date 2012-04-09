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
import java.util.Comparator;
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

	private final Map<String, String> substitutes = new TreeMap<String, String>( new Comparator<String>() {
		public int compare(String s1, String s2) {
			if (s1.length() < s2.length()) {
				return 1;
			}
			else if (s1.length() > s2.length()) {
				return -1;
			}
			else {
				return s2.compareTo(s1);
			}
		}
	});
	
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
			String oldText = entry.getKey();
			String newText = encode(oldText);
			int idx = -1;
			while ((idx = result.indexOf(oldText)) > -1) {
				result = result.substring(0, idx) + newText + result.substring(idx + oldText.length(), result.length());
			}
		}
		for (Entry<String, String> entry : substitutes.entrySet()) {
			String oldText = encode(entry.getKey());
			String newText = entry.getValue();
			int idx = -1;
			while ((idx = result.indexOf(oldText)) > -1) {
				result = result.substring(0, idx) + newText + result.substring(idx + oldText.length(), result.length());
			}
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

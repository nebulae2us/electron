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

/**
 * @author Trung Phan
 *
 */
public class StringUtils {

	public static String concat(String delim, String prevFix, String suffix, String ... elements) {
		
		return "";
	}
	
	public static String toCamelCase(String text) {
		String upperCase = toUpperCamelCase(text);
		return upperCase.length() == 0 ? "" : Character.toLowerCase(upperCase.charAt(0)) + upperCase.substring(1);
	}	
	
	public static String toUpperCamelCase(String text) {
		text = text.trim();
		
		StringBuilder result = new StringBuilder();
		
		boolean nextIsNewWord = true;
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			if (c == '_') {
				nextIsNewWord = true;
			}
			else if (nextIsNewWord) {
				result.append(Character.toUpperCase(c));
				nextIsNewWord = false;
			}
			else {
				result.append(c);
			}
		}
		
		return result.toString();
	}	
	
	
}

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
package org.nebulae2us.electron.test.builder1.model;

import java.util.List;
import java.util.Map;

import org.nebulae2us.electron.Mirror;

/**
 * @author Trung Phan
 *
 */
public class Speech {
	
	private final String name;

	private final Person owner;
	
	private final List<String> keywords;
	
	private final Map<Hobby, List<String>> hobbyKeywords;
	
	public Speech(Mirror converter) {
		converter.bind(this);
		
		this.name = converter.toString("name");
		this.owner = converter.to(Person.class, "owner");
		this.keywords = converter.toListOf(String.class, "keywords");
		this.hobbyKeywords = converter.toMultiValueMapOf(Hobby.class, String.class, "hobbyKeywords");
	}

	public List<String> getKeywords() {
		return keywords;
	}

	public String getName() {
		return name;
	}

	public Person getOwner() {
		return owner;
	}

	public Map<Hobby, List<String>> getHobbyKeywords() {
		return hobbyKeywords;
	}

	
}

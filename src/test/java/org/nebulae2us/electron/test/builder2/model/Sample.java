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
package org.nebulae2us.electron.test.builder2.model;

import java.util.*;

import org.nebulae2us.electron.*;
import org.nebulae2us.electron.util.*;

/**
 * @author Trung Phan
 *
 */
public class Sample {

	private final String name;
	
	private final List<String> names;
	
	private final Set<String> keywords;
	
	private final List<Collection<String>> keywordsList;
	
	private final Map<String, Integer> keywordCounts;
	
	private final Map<String, Set<String>> keywordSynonyms;
	
	private final Class<?> myClass;
	
	private final NavigableSet<Class<?>> otherClasses;
	
	private final Map<Class<?>, List<Class<?>>> friendClasses;
	
	private final Blank blank;

	private final Collection<Blank> blanks;
	
	private final NavigableMap<Integer, Blank> blanksMap;
	
	private final Map<Blank, Blank> blanks2blanks;
	
	public Sample(Mirror mirror) {
		mirror.bind(this);
		
		this.name = mirror.toString("name");
		this.names = mirror.toListOf(String.class, "names");
		this.keywords = mirror.toSetOf(String.class, "keywords");
		this.keywordsList = (List<Collection<String>>)mirror.toObject("keywordsList");
		this.keywordCounts = mirror.toMapOf(String.class, Integer.class, "keywordCounts");
		this.keywordSynonyms = (Map<String, Set<String>>)(Object)mirror.toMapOf(String.class, Set.class, "keywordSynonyms");
		this.myClass = mirror.to(Class.class, "myClass");
		this.otherClasses = new ImmutableSortedSet<Class<?>>(
				(Set<Class<?>>)(Object)mirror.toSetOf(Class.class, "otherClasses"));
		
		this.friendClasses = (Map<Class<?>, List<Class<?>>>)mirror.toObject("friendClasses");
		this.blank = mirror.to(Blank.class, "blank");
		this.blanks = mirror.toListOf(Blank.class, "blanks");
		this.blanksMap = new ImmutableSortedMap<Integer, Blank>(
				mirror.toMapOf(Integer.class, Blank.class, "blanksMap"),
				NaturalComparator.getInstance()
				);
		
		this.blanks2blanks = (Map<Blank, Blank>)mirror.toObject("blanks2blanks");
	}
	

	public String getName() {
		return name;
	}

	public List<String> getNames() {
		return names;
	}

	public Set<String> getKeywords() {
		return keywords;
	}

	public List<Collection<String>> getKeywordsList() {
		return keywordsList;
	}

	public Map<String, Integer> getKeywordCounts() {
		return keywordCounts;
	}

	public Map<String, Set<String>> getKeywordSynonyms() {
		return keywordSynonyms;
	}

	public Class<?> getMyClass() {
		return myClass;
	}

	public Set<Class<?>> getOtherClasses() {
		return otherClasses;
	}

	public Map<Class<?>, List<Class<?>>> getFriendClasses() {
		return friendClasses;
	}

	public Blank getBlank() {
		return blank;
	}

	public Collection<? extends Blank> getBlanks() {
		return blanks;
	}

	public NavigableMap<Integer, Blank> getBlanksMap() {
		return blanksMap;
	}

	public Map<Blank, Blank> getBlanks2blanks() {
		return blanks2blanks;
	}

	
}

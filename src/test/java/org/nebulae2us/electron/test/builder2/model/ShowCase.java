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

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.nebulae2us.electron.util.MapBuilder;

import static org.junit.Assert.*;

/**
 * @author Trung Phan
 *
 */
public class ShowCase {


	@Test
	public void sample_name() {
		
		SampleBuilderSpec builder = new SampleBuilderSpec()
			.name("Name 1");
		
		assertEquals("Name 1", builder.getName());
		
	}
	
	@Test
	public void sample_keywordCounts() {
		SampleBuilderSpec builder = new SampleBuilderSpec()
			.keywordCounts$begin()
				.key("a").value(1)
				.key("b").value(2)
				.key("c").value(3)
			.end();
		
		Map<String, Integer> keywordCounts = builder.getKeywordCounts();
		
		assertEquals(3, keywordCounts.size());
		assertEquals(new MapBuilder<String, Integer>()
				.put("a", 1)
				.put("b", 2)
				.put("c", 3).toMap(),
				keywordCounts);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void sample_keywordsList() {
		SampleBuilderSpec builder = new SampleBuilderSpec()
			.keywordsList(
				Arrays.asList("1", "2"),
				Arrays.asList("10", "11")
			)
			.keywordsList$begin()
				.collection("a", "b", "c")
				.collection("d", "e")
				.collection$begin()
					.items("x", "y")
					.items("z")
				.end()
			.end();
		
		List<Collection<String>> keywordsList = builder.getKeywordsList();
		
		assertEquals(5, keywordsList.size());
		assertEquals(Arrays.asList("1", "2"), keywordsList.get(0));
		assertEquals(Arrays.asList("10", "11"), keywordsList.get(1));
		assertEquals(Arrays.asList("a", "b", "c"), keywordsList.get(2));
		assertEquals(Arrays.asList("d", "e"), keywordsList.get(3));
		assertEquals(Arrays.asList("x", "y", "z"), keywordsList.get(4));
	}
	
	@Test
	public void test_keywordSynonyms() {
		SampleBuilderSpec builder = new SampleBuilderSpec()
			.keywordSynonyms$begin()
				.key("fun").values("cheer", "enjoyment")
				.key("book").values$begin()
					.items("atlas", "album")
					.items("textbook", "handbook")
				.end()
			.end();
		
		
		Map<String, Set<String>> keywordSynonyms = builder.getKeywordSynonyms();
		
		assertEquals(2, keywordSynonyms.size());
		assertEquals(new HashSet<String>(Arrays.asList("cheer", "enjoyment")), keywordSynonyms.get("fun"));
		assertEquals(new HashSet<String>(Arrays.asList("atlas", "album", "textbook", "handbook")), keywordSynonyms.get("book"));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void test_friendClasses() {
		SampleBuilderSpec builder = new SampleBuilderSpec()
			.friendClasses$begin()
				.key(Sample.class).values(Blank.class, BlankBuilderSpec.class)
				.key(SampleBuilderSpec.class).values$begin()
					.items(Sample.class)
					.items(BlankBuilderSpec.class, Blank.class)
				.end()
			.end()
			;
		
		Map<Class<?>, List<Class<?>>> friendClasses = builder.getFriendClasses();
		
		assertEquals(2, friendClasses.size());
		assertEquals(Arrays.asList(Blank.class, BlankBuilderSpec.class), friendClasses.get(Sample.class));
		assertEquals(Arrays.asList(Sample.class, BlankBuilderSpec.class, Blank.class), friendClasses.get(SampleBuilderSpec.class));
	}
	
}

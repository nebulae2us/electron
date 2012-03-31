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
public class SubSampleBuilderSpec extends SampleBuilderSpec {

	public SubSampleBuilderSpec() {
		super();
	}
	
	public SubSampleBuilderSpec(SubSample wrapped, ConverterOption option) {
		super(wrapped, option);
	}

	@Override
	public SubSample getWrappedObject() {
		return (SubSample)this.$$$wrapped;
	}

	@Override
    public SubSampleBuilderSpec storeTo(BuilderRepository repo, Object builderId) {
    	repo.put(builderId, this);
    	return this;
    }
	
    public SubSample toSubSample() {
    	return new Converter(this.$$$option, true).convert(this).to(SubSample.class);
    }
	
	@Override
    public SubSample toSample() {
    	return new Converter(this.$$$option, true).convert(this).to(SubSample.class);
    }

	@Override
	public SubSampleBuilderSpec name(String name) {
		return (SubSampleBuilderSpec)super.name(name);
	}
	
	@Override
	public SubSampleBuilderSpec names(String ... names) {
		return (SubSampleBuilderSpec)names(names);
	}

	@Override
	public SubSampleBuilderSpec names(Collection<String> names) {
		return (SubSampleBuilderSpec)names(names);
	}
	
	@Override
	public SubSampleBuilderSpec keywords(String ... keywords) {
		return (SubSampleBuilderSpec)super.keywords(keywords);
	}

	@Override
	public SubSampleBuilderSpec keywords(Collection<String> keywords) {
		return (SubSampleBuilderSpec)super.keywords(keywords);
	}
	
	@Override
	public SubSampleBuilderSpec keywordsList(Collection<String> ... keywordsList) {
		return (SubSampleBuilderSpec)super.keywordsList(keywordsList);
	}

	@Override
	public SubSampleBuilderSpec keywordsList(Collection<Collection<String>> keywordsList) {
		return (SubSampleBuilderSpec)super.keywordsList(keywordsList);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ChainedMultiCollectionBuilder<? extends SubSampleBuilderSpec, String> keywordsList$begin() {
		return (ChainedMultiCollectionBuilder<? extends SubSampleBuilderSpec, String>)super.keywordsList$begin();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ChainedMapBuilder<? extends SubSampleBuilderSpec, String, Integer> keywordCounts$begin() {
		return (ChainedMapBuilder<? extends SubSampleBuilderSpec, String, Integer>)super.keywordCounts$begin();
	}

	@Override
	public SubSampleBuilderSpec keywordCounts(Map<String, Integer> keywordCounts) {
		return (SubSampleBuilderSpec)super.keywordCounts(keywordCounts);
	}
	
	@Override
	public SubSampleBuilderSpec keywordSynonyms(Map<String, Set<String>> keywordSynonyms) {
		return (SubSampleBuilderSpec)super.keywordSynonyms(keywordSynonyms);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ChainedMultiMapBuilder<? extends SubSampleBuilderSpec, String, String> keywordSynonyms$begin() {
		return (ChainedMultiMapBuilder<? extends SubSampleBuilderSpec, String, String>)super.keywordSynonyms$begin();
	}

	@Override
	public SubSampleBuilderSpec myClass(Class<?> myClass) {
		return (SubSampleBuilderSpec)super.myClass(myClass);
	}

	@Override
	public SubSampleBuilderSpec otherClasses(Class<?> ... otherClasses) {
		return (SubSampleBuilderSpec)super.otherClasses(otherClasses);
	}

	@Override
	public SubSampleBuilderSpec otherClasses(Collection<Class<?>> otherClasses) {
		return (SubSampleBuilderSpec)super.otherClasses(otherClasses);
	}

	@Override
	public SubSampleBuilderSpec friendClasses(Map<Class<?>, List<Class<?>>> friendClasses) {
		return (SubSampleBuilderSpec)super.friendClasses(friendClasses);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ChainedMultiMapBuilder<? extends SubSampleBuilderSpec, Class<?>, Class<?>> friendClasses$begin() {
		return (ChainedMultiMapBuilder<? extends SubSampleBuilderSpec, Class<?>, Class<?>>)super.friendClasses$begin();
	}
	
	@Override
	public SubSampleBuilderSpec blank(BlankBuilderSpec blank) {
		return (SubSampleBuilderSpec)super.blank(blank);
	}
	
	@Override
    public SubSampleBuilderSpec blank$wrap(Blank blank) {
		return (SubSampleBuilderSpec)super.blank$wrap(blank);
    }

	@Override
    public SubSampleBuilderSpec blank$restoreFrom(BuilderRepository repo, Object builderId) {
		return (SubSampleBuilderSpec)super.blank$restoreFrom(repo, builderId);
    }

	@Override
	public SubSampleBuilderSpec blanks(Collection<BlankBuilderSpec> blanks) {
		return (SubSampleBuilderSpec)super.blanks(blanks);
	}
	
	@Override
	public SubSampleBuilderSpec blanks(BlankBuilderSpec ... blanks) {
		return (SubSampleBuilderSpec)super.blanks(blanks);
	}

	@Override
    public SubSampleBuilderSpec blanks$wrap(Blank ... blanks) {
		return (SubSampleBuilderSpec)super.blanks$wrap(blanks);
    }

	@Override
    public SubSampleBuilderSpec blanks$wrap(Collection<Blank> blanks) {
		return (SubSampleBuilderSpec)super.blanks$wrap(blanks);
    }

	@Override
    public SubSampleBuilderSpec blanks$restoreFrom(BuilderRepository repo, Object ... builderIds) {
		return (SubSampleBuilderSpec)super.blanks$restoreFrom(repo, builderIds);
    }

	@Override
    public SubSampleBuilderSpec blanks$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		return (SubSampleBuilderSpec)super.blanks$restoreFrom(repo, builderIds);
    }

	@SuppressWarnings("unchecked")
	@Override
	public ChainedMapBuilder<? extends SubSampleBuilderSpec, Class<BlankBuilderSpec>, BlankBuilderSpec> blanksMap$begin() {
		return (ChainedMapBuilder<? extends SubSampleBuilderSpec, Class<BlankBuilderSpec>, BlankBuilderSpec>)super.blanksMap$begin();
	}
	
	@Override
	public SubSampleBuilderSpec blanksMap(Map<Class<BlankBuilderSpec>, BlankBuilderSpec> blanksMap) {
		return (SubSampleBuilderSpec)super.blanksMap(blanksMap);
	}	
	
	
}

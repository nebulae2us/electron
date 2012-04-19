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

import java.io.Serializable;
import java.util.List;

import org.nebulae2us.electron.Builder;
import org.nebulae2us.electron.DestinationClassResolverByAnnotation;
import org.nebulae2us.electron.BuilderRepository;
import org.nebulae2us.electron.Converter;
import org.nebulae2us.electron.Wrappable;

/**
 * @author Trung Phan
 *
 */
@Builder(destination=Orange.class)
public class OrangeBuilderSpec<P> implements Wrappable<Orange<? extends Sample, ? extends List<? extends Blank>, ? extends Serializable>> {
	
	protected final Orange<? extends Sample, ? extends List<? extends Blank>, ? extends Serializable> $$$wrapped;

	protected final P $$$parentBuilder;
	
	public OrangeBuilderSpec() {
		this.$$$wrapped = null;
		this.$$$parentBuilder = null;
	}
	
	public OrangeBuilderSpec(P parentBuilder) {
		this.$$$wrapped = null;
		this.$$$parentBuilder = parentBuilder;
	}

	protected OrangeBuilderSpec(Orange<? extends Sample, ? extends List<? extends Blank>, ? extends Serializable> wrapped) {
		this.$$$wrapped = wrapped;
		this.$$$parentBuilder = null;
	}
	
    public OrangeBuilderSpec<P> storeTo(BuilderRepository repo, Object builderId) {
    	repo.put(builderId, this);
    	return this;
    }

	public Orange<? extends Sample, ? extends List<? extends Blank>, ? extends Serializable> getWrappedObject() {
		return this.$$$wrapped;
	}

	protected void verifyMutable() {
		if (this.$$$wrapped != null) {
    		throw new IllegalStateException("Cannot mutate fields of immutable objects");
		}
	}

	public P end() {
		return this.$$$parentBuilder;
	}

    public Orange<? extends Sample, ? extends List<? extends Blank>, ? extends Serializable> toOrange() {
    	return new Converter(new DestinationClassResolverByAnnotation(), true).convert(this).to(Orange.class);
    }
    
    private SampleBuilderSpec<?> sample;
    
    public OrangeBuilderSpec<P> sample(SampleBuilderSpec<?> sample) {
    	this.sample = sample;
    	return this;
    }

}

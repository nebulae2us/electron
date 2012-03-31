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

import org.nebulae2us.electron.*;

/**
 * @author Trung Phan
 *
 */
public class BlankBuilderSpec {
	
	protected final Blank $$$wrapped;

	private final ConverterOption $$$option;
	
	public BlankBuilderSpec() {
		this(null, null);
	}
	
	protected BlankBuilderSpec(Blank wrapped, ConverterOption option) {
		this.$$$wrapped = wrapped;
		this.$$$option = option;
	}
	
    public BlankBuilderSpec storeTo(BuilderRepository repo, Object builderId) {
    	repo.put(builderId, this);
    	return this;
    }

	private void verifyMutable() {
		if (this.$$$wrapped != null) {
    		throw new IllegalStateException("Cannot mutate fields of immutable objects");
		}
	}

	public Blank toBlank() {
    	return new Converter(this.$$$option, true).convert(this).to(Blank.class);
    }
    
	private String name;
	
	public void setName(String name) {
		verifyMutable();
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public BlankBuilderSpec name(String name) {
		verifyMutable();
		this.name = name;
		return this;
	}

}

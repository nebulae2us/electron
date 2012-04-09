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
package org.nebulae2us.electron.test.builder3.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.nebulae2us.electron.Mirror;
import org.nebulae2us.electron.NullMirror;

/**
 * @author Trung Phan
 *
 */
public class Book<C extends Color & Serializable, T extends Paper<C>, R extends Recordable<C>, L extends List<? extends T>> {
	
	private final int sequence;
	
	private final T myPaper;

	private final R myRecordable;
	
	private final List<String> keywords;
	
	private final List<? extends T> myPapers;
	
	private final Set<? extends R> myRecordables;
	
	private final Map<? extends Paper, ? extends C> paperColors;
	
	public Book() {
		this(new NullMirror());
	}
	
	public Book(Mirror mirror) {
		mirror.bind(this);
		
		this.myPaper = (T)mirror.to(Paper.class, "myPaper");
		this.myRecordable = (R)mirror.to(Recordable.class, "myRecordable");
		this.myPapers = (List<? extends T>)mirror.to(List.class, "myPapers");
		this.myRecordables = (Set<? extends R>)mirror.to(Set.class, "myRecordables"); 
		this.keywords = mirror.toListOf(String.class, "keywords");
		this.sequence = mirror.toIntValue("sequence");
		this.paperColors = (Map<? extends Paper, ? extends C>)mirror.toObject("paperColors");
	}

	public T getMyPaper() {
		return myPaper;
	}

	public R getMyRecordable() {
		return myRecordable;
	}

	public List<? extends T> getMyPapers() {
		return myPapers;
	}

	
	
}

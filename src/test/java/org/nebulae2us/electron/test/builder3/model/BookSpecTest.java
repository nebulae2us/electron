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

import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;

import static org.nebulae2us.electron.test.builder3.model.BuilderSpecs.*;

/**
 * @author Trung Phan
 *
 */
public class BookSpecTest {

	@Test
	public void wrap_book() {
		
		
		
		Book<Color, CopyPaper<Color>, Paper<Color>, List<CopyPaper<Color>>> book1 = new Book<Color, CopyPaper<Color>, Paper<Color>, List<CopyPaper<Color>>>();
		
		BookBuilderSpec<?> bookBuilder = wrap(book1);
		
		assertTrue(book1 == bookBuilder.getWrappedObject());
		
		Book<? extends Color, ? extends Paper<? extends Color>, ? extends Recordable<? extends Color>, ? extends List<? extends Paper<? extends Color>>> book = bookBuilder.toBook();
		
		assertTrue(book1 == book);
		
	}
	
	@Test
	public void assign_paper() {

		PaperBuilderSpec<?> paperBuilder = new PaperBuilderSpec<Object>();
		
		BookBuilderSpec<?> bookBuilder = new BookBuilderSpec<Object>()
				.myPaper(paperBuilder);
		
		assertTrue(paperBuilder == bookBuilder.getMyPaper());
		
		Book<? extends Color, ? extends Paper<? extends Color>, ? extends Recordable<? extends Color>, ? extends List<? extends Paper<? extends Color>>> book = bookBuilder.toBook();
		
		assertTrue(book.getMyPaper() instanceof Paper);
		
	}

	@Test
	public void assign_paperColors() {
		
		BookBuilderSpec<?> bookBuilder = book()
				.paperColors$map()
					.key$asPaper()
					.end()
					.value$asColor()
					.end()
					.key$asPaper()
					.end()
					.value$asColor()
					.end()
					.key(null).value$asRGBColor().end()
				.end()
				;
		
		
		
		
	}
	
}

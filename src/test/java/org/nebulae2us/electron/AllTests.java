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
package org.nebulae2us.electron;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.nebulae2us.electron.reflect.*;
import org.nebulae2us.electron.test.builder1.*;
import org.nebulae2us.electron.test.builder2.model.SpecTest;
import org.nebulae2us.electron.test.builder3.model.FictionSpecTest;
import org.nebulae2us.electron.test.convert.*;
import org.nebulae2us.electron.util.*;

/**
 * @author Trung Phan
 *
 */
@RunWith(Suite.class)
@SuiteClasses({
	ClassHolderTest.class,
	TypeHolderTest.class,
	InheritanceTest.class,
	ModifyImmutableTest.class,
	TestCreatedBuilders.class,
	SpecTest.class,
	FictionSpecTest.class,
	ConvertMutableTest.class,
	ConvertTest.class,
	ConvertToObjectTest.class,
	WrapConverterTest.class,
	ImmutableListTest.class,
	ImmutableMapTest.class,
	ImmutableSortedListTest.class,
	ImmutableSortedMapTest.class,
	ImmutableSortedSetTest.class,
	ImmutablesTest.class,
	ImmutableWrapperTest.class,
	SetFunctionalityTest.class,
	SortedSetFunctionalityTest.class
})
public class AllTests {
}

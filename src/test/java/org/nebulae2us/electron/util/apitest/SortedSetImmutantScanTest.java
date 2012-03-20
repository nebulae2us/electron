package org.nebulae2us.electron.util.apitest;

import java.util.NavigableSet;

public class SortedSetImmutantScanTest<E> extends SetImmutantScanTest<E> {

	private final NavigableSet<E> control;
	private final NavigableSet<E> test;
	
	public SortedSetImmutantScanTest(Class<E> elementClass,
			NavigableSet<E> control, NavigableSet<E> test) {

		super(elementClass, control, test);

		this.control = control;
		this.test = test;
	}
	
	@Override
	public void runTests() {
		super.runTests();
	}
	
	

}

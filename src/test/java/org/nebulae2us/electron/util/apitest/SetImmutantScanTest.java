package org.nebulae2us.electron.util.apitest;

import java.util.Collection;

public class SetImmutantScanTest<E> extends CollectionImmutantScanTest<E> {

	public SetImmutantScanTest(Class<E> elementClass, Collection<E> control,
			Collection<E> test) {
		super(elementClass, control, test);
	}
	
}

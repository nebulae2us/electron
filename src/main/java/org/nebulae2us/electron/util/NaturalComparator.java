package org.nebulae2us.electron.util;

import java.util.Comparator;

public class NaturalComparator<E> implements Comparator<E> {

	public int compare(E e1, E e2) {
		if (!(e1 instanceof Comparable)) {
			throw new IllegalArgumentException("Elements are not comparable.");
		}
		if (!(e2 instanceof Comparable)) {
			throw new IllegalArgumentException("Elements are not comparable.");
		}
		Comparable<E> c1 = (Comparable) e1;
		return c1.compareTo(e2);
	}

}

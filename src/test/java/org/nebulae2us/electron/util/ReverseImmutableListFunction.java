package org.nebulae2us.electron.util;

import java.util.List;

import org.nebulae2us.electron.Function;

public class ReverseImmutableListFunction<E> implements Function<List<E>> {

	@SuppressWarnings("unchecked")
	public List<E> execute(Object... arguments) {
		ImmutableList<E> originalList = (ImmutableList<E>)arguments[0];
		return originalList.descendingList();
	}

}

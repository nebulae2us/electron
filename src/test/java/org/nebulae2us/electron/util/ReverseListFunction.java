package org.nebulae2us.electron.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.nebulae2us.electron.Function;

public class ReverseListFunction<E> implements Function<List<E>> {

	@SuppressWarnings("unchecked")
	public List<E> execute(Object... arguments) {
		List<E> originalList = (List<E>)arguments[0];
		List<E> newList = new ArrayList<E>(originalList);
		Collections.reverse(newList);
		return newList;
	}
	
}

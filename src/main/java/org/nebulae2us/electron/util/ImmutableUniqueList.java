package org.nebulae2us.electron.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class ImmutableUniqueList<E> extends ImmutableList<E> {

	private static final long serialVersionUID = -5866251847193233328L;

	public ImmutableUniqueList() {
		super();
    }

	public ImmutableUniqueList(EqualityComparator<E> equalityComparator, E ... elements) {
        super(Arrays.asList(elements), equalityComparator, true);
    }
	
	public ImmutableUniqueList(Comparator<? super E> comparator, E ... elements) {
        super(Arrays.asList(elements), comparator, true);
    }
	
	public ImmutableUniqueList(E ... elements) {
		super(Arrays.asList(elements), new ObjectEqualityComparator<E>(), true);
	}

    public ImmutableUniqueList(Collection<? extends E> c, EqualityComparator<E> equalityComparator) {
        super(c, equalityComparator, true);
    }
	
    public ImmutableUniqueList(Collection<? extends E> c, Comparator<? super E> comparator) {
        super(c, comparator, true);
    }

    public ImmutableUniqueList(Collection<? extends E> c) {
        super(c, new ObjectEqualityComparator<E>(), true);
    }
    
    protected ImmutableUniqueList(ImmutableUniqueList<E> cloned, int fromIndex, int toIndex) {
    	super(cloned, fromIndex, toIndex);
    }
    
    protected ImmutableUniqueList(ImmutableUniqueList<E> cloned, boolean descending) {
    	super(cloned, descending);
    }

    
    @Override
    public ImmutableUniqueList<E> descendingList() {
        return new ImmutableUniqueList<E>(this, true);
    }
    
    @Override
    public ImmutableUniqueList<E> subList(int fromIndex, int toIndex) {
    	return new ImmutableUniqueList<E>(this, fromIndex, toIndex);
    }
}

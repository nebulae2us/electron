package org.nebulae2us.electron.util;

import java.util.Iterator;
import java.util.Set;


public abstract class AbstractImmutableSet<E> extends AbstractImmutableCollection<E> implements Set<E> {
	
	
	@Override
	public boolean equals(Object o) {
		if (o == this)
		    return true;

		if (!(o instanceof Set))
		    return false;
		
		Set<?> set = (Set<?>) o;

		if (set.size() != size())
		    return false;

		try {
            return containsAll(set);
        } catch (ClassCastException unused)   {
            return false;
        } catch (NullPointerException unused) {
            return false;
        }
		
	}
	
	@Override
	public int hashCode() {
		int h = 0;
		Iterator<E> i = iterator();
		while (i.hasNext()) {
		    E obj = i.next();
	            if (obj != null)
	                h += obj.hashCode();
	        }
		return h;
	}
	

}

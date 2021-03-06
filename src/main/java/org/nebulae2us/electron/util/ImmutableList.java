/*
 * Copyright 2011 the original author or authors.
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
package org.nebulae2us.electron.util;

import java.io.Serializable;
import java.util.*;
import java.util.regex.Pattern;

import org.nebulae2us.electron.ElementContext;
import org.nebulae2us.electron.Function1;
import org.nebulae2us.electron.function.ChainedAction;
import org.nebulae2us.electron.function.DenullifyElement;
import org.nebulae2us.electron.function.ElementToLowerCase;
import org.nebulae2us.electron.function.ElementToUpperCase;
import org.nebulae2us.electron.function.ExtractMatchFromElement;
import org.nebulae2us.electron.function.RemoveEmptyElement;
import org.nebulae2us.electron.function.RemoveNullElement;
import org.nebulae2us.electron.function.FormatElement;
import org.nebulae2us.electron.function.ReplaceElement;
import org.nebulae2us.electron.function.SubstringElement;
import org.nebulae2us.electron.function.TrimElement;

/**
 * @author Trung Phan
 */
public final class ImmutableList<E> extends AbstractImmutableList<E> implements List<E>, RandomAccess, Cloneable, Serializable {

	private static final long serialVersionUID = -2955135267976316366L;

	private final Object[] data;

	/**
	 * fromIndex corresponding to the index of data;
	 */
    private final int fromIndex;

    private final int size;

    private final boolean descending;

    private final Comparator<Object> comparator;

    private final EqualityComparator<Object> equalityComparator;


    public ImmutableList(ImmutableList<E> c) {
        this.fromIndex = c.fromIndex;
        this.data = c.data;
        this.size = c.size;
        this.descending = c.descending;
        this.comparator = c.comparator;
        this.equalityComparator = c.equalityComparator;
    }

    @SuppressWarnings("unchecked")
	public ImmutableList() {
        this(Collections.EMPTY_LIST);
    }

    public ImmutableList(E ... elements) {
        this(Arrays.asList(elements));
    }

    public ImmutableList(Comparator<? super E> comparator, E ... elements) {
        this(Arrays.asList(elements), comparator, false);
    }

    public ImmutableList(EqualityComparator<E> equalityComparator, E ... elements) {
        this(Arrays.asList(elements), equalityComparator, false);
    }

	@SuppressWarnings("unchecked")
	public ImmutableList(Collection<? extends E> c, EqualityComparator<? super E> equalityComparator, boolean unique) {
		if (equalityComparator == null) {
			throw new NullPointerException();
		}
		
        this.fromIndex = 0;
        this.descending = false;
        this.comparator = null;
        this.equalityComparator = (EqualityComparator<Object>)equalityComparator;

    	if (unique) {
    		List<E> newList = new ArrayList<E>();
    		for (E e : c) {
    			
    			boolean contains = false;
    			for (E ie : newList) {
    				if (equalityComparator.compare(ie, e)) {
    					contains = true;
    					break;
    				}
    			}
    			
    			if (!contains) {
    				newList.add(e);
    			}
    			
    		}
    		
    		c = newList;
    	}
    	
        data = new Object[c.size()];
        c.toArray(data);
        this.size = c.size();
    }
    
    public ImmutableList(Collection<? extends E> c) {
        this(c, ObjectEqualityComparator.getInstance(), false);
    }

    @SuppressWarnings("unchecked")
	public ImmutableList(Collection<? extends E> c, Comparator<? super E> comparator, boolean unique) {
    	if (comparator == null) {
    		throw new NullPointerException();
    	}
    	
        this.fromIndex = 0;
        this.descending = false;
        this.comparator = (Comparator<Object>)comparator;
        this.equalityComparator = null;

        Object[] newData = c.toArray();
        Arrays.sort(newData, this.comparator);
        
        if (!unique) {
        	this.data = newData;
        	this.size = newData.length;
        }
        else if (c.size() == 0) {
        	this.data = newData;
        	this.size = 0;
        }
        else {
            this.data = newData;
            int newSize = 1;
            for (int i = 1; i < c.size(); i++) {
            	if (this.comparator.compare(data[i-1], data[i]) != 0) {
            		if (newSize < i) {
            			this.data[newSize] = this.data[i];
            		}
            		newSize++;
            	}
            }
            this.size = newSize;
        }
        
    }

    private ImmutableList(ImmutableList<E> cloned, int fromIndex, int toIndex) {
        if (fromIndex < 0 || fromIndex > cloned.size ||
            toIndex < 0 || toIndex > cloned.size || toIndex < fromIndex  ) {
            throw new IndexOutOfBoundsException("fromIndex or toIndex is not valid. FromIndex: " + fromIndex + ", toIndex" + toIndex);
        }

        this.size = toIndex - fromIndex;
        this.fromIndex = cloned.descending ? cloned.fromIndex + cloned.size - toIndex : cloned.fromIndex + fromIndex;
        this.data = cloned.data;
        this.descending = cloned.descending;
        this.comparator = cloned.comparator;
        this.equalityComparator = cloned.equalityComparator;
    }

    private ImmutableList(ImmutableList<E> cloned, boolean descending) {
        this.fromIndex = cloned.fromIndex;
        this.data = cloned.data;
        this.size = cloned.size;
        this.descending = descending ? !cloned.descending : cloned.descending;
        this.comparator = cloned.comparator;
        this.equalityComparator = cloned.equalityComparator;
    }
    
    private ImmutableList(Object[] data, int fromIndex, int size, boolean descending, Comparator<Object> comparator, EqualityComparator<Object> equalityComparator) {
    	if (comparator == null && equalityComparator == null) {
    		throw new NullPointerException();
    	}
    	if (comparator != null && equalityComparator != null) {
    		throw new IllegalArgumentException();
    	}
    	
    	this.data = data;
    	this.fromIndex = fromIndex;
    	this.size = size;
    	this.descending = descending;
    	this.comparator = comparator;
    	this.equalityComparator = equalityComparator;
    }

    public int size() {
        return size;
    }

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @SuppressWarnings("unchecked")
	public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        return (E)data[descending ? fromIndex + size - index - 1 : fromIndex + index];
    }

    private int indexOf(Object o, boolean descending) {
    	
    	if (this.size == 0) {
    		return -1;
    	}
    	
        boolean realDesc = this.descending ? !descending : descending;

        if (comparator != null) {
        	int idx;
        	if (comparator == NaturalComparator.getInstance()) {
                idx = Arrays.binarySearch(this.data, this.fromIndex, this.fromIndex + this.size, o);
        	}
        	else {
                idx = Arrays.binarySearch(this.data, this.fromIndex, this.fromIndex + this.size, o, this.comparator);
        	}
        	
            if (idx >= 0) {
            	if (!realDesc) {
                	while (idx > this.fromIndex && this.comparator.compare(data[idx], data[idx-1]) == 0) {
                		idx--;
                	}
            	}
            	else {
                	while (idx < this.fromIndex + size - 1 && this.comparator.compare(this.data[idx], this.data[idx+1]) == 0) {
                		idx++;
                	}
            	}
                return this.descending ? this.fromIndex + this.size - idx - 1 : idx - this.fromIndex;
            }
        }
        else if (this.equalityComparator != null) {
            for (int i = 0; i < this.size; i++) {
                if (this.equalityComparator.compare(o, this.data[realDesc ? fromIndex + size - i - 1 : fromIndex + i]))
                    return descending ? this.size - i - 1 : i;
            }
        }
        return -1;
    }

    public int indexOf(Object o) {
        return indexOf(o, false);
    }

    public int lastIndexOf(Object o) {
        return indexOf(o, true);
    }
    
    public int indexOf(Object o, int index) {
    	if (this.equalityComparator != null) {
    	    for (int i = index ; i < size ; i++) {
    	    	if (this.equalityComparator.compare(get(i), o)) {
    	    		return i;
    	    	}
    	    }
    	}
    	else if (this.comparator != null) {
    		for (int i = index; i < size; i++) {
    			if (this.comparator.compare(get(i), o) == 0) {
    				return i;
    			}
    		}
    	}
    	return -1;
    }

    public int lastIndexOf(Object o, int index) {
    	if (this.equalityComparator != null) {
    	    for (int i = index ; i >= 0; i--) {
    	    	if (this.equalityComparator.compare(get(i), o)) {
    	    		return i;
    	    	}
    	    }
    	}
    	else if (this.comparator != null) {
    		for (int i = index; i >= 0; i--) {
    			if (this.comparator.compare(get(i), o) == 0) {
    				return i;
    			}
    		}
    	}
    	return -1;
    }
    
    public ImmutableList<E> subList(int fromIndex) {
    	return subList(fromIndex, size);
    }
    
    public ImmutableList<E> subList(int fromIndex, int toIndex) {
    	
    	if (fromIndex == 0 && toIndex == size) {
    		return this;
    	}
    	
        return new ImmutableList<E>(this, fromIndex, toIndex);
    }

    public Enumeration<E> elements() {
    	return new InternalListIterator(0, false);
    }
    
    public Iterator<E> iterator() {
        return new InternalListIterator(0, false);
    }
    
	public Iterator<E> descendingIterator() {
		return new InternalListIterator(0, true);
	}
    

    public Comparator<? super E> comparator() {
        return comparator != null && descending ? Collections.reverseOrder(comparator) : comparator;
    }

    private final class InternalListIterator extends AbstractImmutableListIterator<E> implements ListIterator<E>, Enumeration<E> {

        private int index;
        
        private final boolean descending;
        
        private InternalListIterator(int index, boolean descending) {
            this.descending = descending;
            this.index = this.descending ? ImmutableList.this.size - 1 - index : index;
        }

        public boolean hasNext() {
            return this.descending ? index >= 0 : index < ImmutableList.this.size;
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return ImmutableList.this.get(this.descending ? index-- : index ++);
        }

        public boolean hasPrevious() {
            return this.descending ? index < ImmutableList.this.size - 1 : index > 0;
        }

        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            return ImmutableList.this.get(this.descending ? ++index : --index);
        }

        public int nextIndex() {
            return index;
        }

        public int previousIndex() {
            return this.descending ? index + 1 : index - 1;
        }

		public boolean hasMoreElements() {
			return hasNext();
		}

		public E nextElement() {
			return next();
		}
    }

    public ListIterator<E> listIterator() {
        return new InternalListIterator(0, false);
    }

    public ListIterator<E> descendingListIterator() {
        return new InternalListIterator(0, true);
    }
    
    public ListIterator<E> listIterator(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return new InternalListIterator(index, false);
    }

    public ListIterator<E> descendingListIterator(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return new InternalListIterator(index, true);
    }
    
    public ImmutableList<E> descendingList() {
        return new ImmutableList<E>(this, true);
    }

    public int binarySearch(Object o) {
        if (comparator == null) {
            throw new IllegalStateException("Cannot do binary search on an un-sorted list.");
        }
        
        int idx;
        if (comparator.getClass() == NaturalComparator.class) {
            idx = Arrays.binarySearch(this.data, this.fromIndex, this.fromIndex + this.size, o);
        }
        else {
            idx = Arrays.binarySearch(this.data, this.fromIndex, this.fromIndex + this.size, o, comparator);
        }

        if (!this.descending) {
        	return idx >= 0 ? idx - this.fromIndex : idx + this.fromIndex;
        }
        else {
        	return idx >= 0 ? this.fromIndex + this.size - idx - 1 : -idx - this.size - this.fromIndex - 2;
        }
   }

    public ImmutableList<E> changeComparator(Comparator<? super E> comparator) {
    	return toSortedList(comparator);
    }

    public ImmutableList<E> changeComparator(EqualityComparator<? super E> equalityComparator) {
    	if (equalityComparator == null) {
    		throw new NullPointerException();
    	}
    	
    	if (this.equalityComparator == equalityComparator) {
    		return this;
    	}
    	return new ImmutableList<E>(this.data, this.fromIndex, this.size, this.descending, null, (EqualityComparator<Object>)equalityComparator);
    }
    
    public boolean isSorted() {
    	return isSorted(null);
    }
    
    public boolean isSorted(Comparator<? super E> comparator) {
		Comparator<Object> _comparator = comparator == null ? NaturalComparator.getInstance() : (Comparator<Object>)comparator;
		
		if (this.comparator == _comparator && !this.descending) {
			return true;
		}
		
		boolean isSorted = true;
		if (!this.descending) {
			for (int i = 1; i < this.size; i++) {
				if (_comparator.compare(get(i-1), get(i)) > 0) {
					isSorted = false;
					break;
				}
			}
		}
		else {
			for (int i = 1; i < this.size; i++) {
				if (_comparator.compare(get(i-1), get(i)) < 0) {
					isSorted = false;
					break;
				}
			}
		}
    	
		return isSorted;
    }
    
    public ImmutableList<E> toSortedList() {
    	return toSortedList(null);
    }
    
	public ImmutableList<E> toSortedList(Comparator<? super E> comparator) {
		
		Comparator<Object> _comparator = comparator == null ? NaturalComparator.getInstance() : (Comparator<Object>)comparator;

		if (this.comparator != null && this.comparator == _comparator && !this.descending) {
			return this;
		}
		
		if (isSorted(comparator)) {
			return new ImmutableList<E>(this.data, this.fromIndex, this.size, false, _comparator, null);
		}
		
    	Object[] newData = new Object[this.size];
    	int i = 0;
    	for (E e : this) {
    		newData[i++] = e;
    	}
    	if (comparator == null) {
    		Arrays.sort(newData);
    	}
    	else {
        	Arrays.sort(newData, _comparator);
    	}
    	
    	return new ImmutableList<E>(newData, 0, this.size, false, _comparator, null);
    }
    
	public boolean isUnique(EqualityComparator<? super E> comparator) {
		
		for (int i = 0; i < this.size; i++) {
			for (int j = i + 1; j < this.size; j++) {
				if (comparator.compare(get(i), get(j))) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public boolean isUnique() {
		if (this.equalityComparator != null) {
			return isUnique(this.equalityComparator);
		}
		else {
			for (int i = 1; i < this.size; i++) {
				if (this.comparator.compare(get(i-1), get(i)) == 0) {
					return false;
				}
			}
			return true;
		}
	}

	public ImmutableList<E> toUniqueList(EqualityComparator<? super E> comparator) {
		if (isUnique(comparator)) {
			return this;
		}
		
		return new ImmutableList<E>(this, comparator, true);
	}
	
	public ImmutableList<E> toUniqueList() {
		if (this.size == 0) {
			return this;
		}
		else if (this.equalityComparator != null) {
			return toUniqueList(this.equalityComparator);
		}
		else if (this.comparator != null) {
			int countDuplicates = 0;
			for (int i = 1; i < this.size; i++) {
				if (this.comparator.compare(get(i-1), get(i)) == 0) {
					countDuplicates++;
				}
			}
			if (countDuplicates == 0) {
				return this;
			}
			else {
				Object[] newData = new Object[size - countDuplicates];
				newData[0] = this.get(0);
				int newSize = 1;
				for (int i = 1; i < this.size; i++) {
					Object element = this.get(i);
					if (comparator.compare(element, newData[newSize - 1]) != 0) {
						newData[newSize++] = element;
					}
				}
				return new ImmutableList<E>(newData, 0, newSize, this.descending, this.comparator, null);
			}
		}
		return toUniqueList(ObjectEqualityComparator.getInstance());
	}
	
	public ImmutableList<E> toSortedUniqueList() {
		return toSortedUniqueList(null);
	}
	
	public ImmutableList<E> toSortedUniqueList(Comparator<? super E> comparator) {
		if (this.size == 0) {
			return this;
		}
		
		Comparator<Object> _comparator = comparator == null ? NaturalComparator.getInstance() : (Comparator<Object>)comparator;

		if (isSorted(comparator)) {
			boolean unique = true;
			if (this.comparator != null) {
				unique = isUnique();
			}
			else {
				for (int i = 1; i < this.size; i++) {
					if (_comparator.compare(get(i-1), get(i)) == 0) {
						unique = false;
						break;
					}
				}
			}
			if (unique) {
				return new ImmutableList<E>(this.data, this.fromIndex, this.size, false, _comparator, null);
			}
			else {
				Object[] newData = new Object[this.size];
				int newSize = 1;
				newData[0] = get(0);
				for (int i  = 1; i < this.size; i++) {
					if (_comparator.compare(get(i-1), get(i)) != 0) {
						newData[newSize++] = get(i);
					}
				}
				return new ImmutableList<E>(newData, 0, newSize, false, _comparator, null);
			}
		}
		
    	return new ImmutableList<E>(this, _comparator, true);
		
	}
	
	public ImmutableSortedSet<E> toSortedSet() {
		return new ImmutableSortedSet<E>(toSortedUniqueList());
	}
	
	public ImmutableSortedSet<E> toSortedSet(Comparator<? super E> comparator) {
		return new ImmutableSortedSet<E>(toSortedUniqueList(comparator));
	}
	
    public <T> ImmutableList<T> toList(Function1<T, ElementContext<E>> function) {
    	if (function == null) {
    		throw new NullPointerException();
    	}
    	
    	Object[] newData = new Object[this.data.length];
    	int size = 0;
    	for (E element : this) {
    		ElementContext<E> elementContext = new ElementContext<E>(size, element);
			T newElement = function.execute(elementContext);
			switch (elementContext.getAction()) {
			case ElementContext.ACTION_SKIP_ELEMENT:
				break;
			default:
	    		newData[size++] = newElement;
			}
    	}
    	    	
    	return new ImmutableList<T>(newData, 0, size, false, null, this.equalityComparator instanceof IdentityEqualityComparator ? this.equalityComparator : ObjectEqualityComparator.getInstance());
    }
    
    public ImmutableList<E> toList(Function1<E, ElementContext<E>> ... actions) {
    	return toList(new ChainedAction<E>(actions));
    }
    
    public ImmutableList<E> toList(Collection<Function1<E, ElementContext<E>>> actions) {
    	return toList(new ChainedAction<E>(actions));
    }

    public ImmutableList<String> formatElement(String format) {
    	return toList(new FormatElement<E>(format));
    }
    
    public ImmutableList<String> substringElement(int fromIndex, int toIndex) {
    	return toList(new SubstringElement<E>(fromIndex, toIndex));
    }
    
    public ImmutableList<String> substringElement(int fromIndex) {
    	return substringElement(fromIndex, -1);
    }
    
    public ImmutableList<String> replace(String substring, String newString) {
    	return toList(new ReplaceElement<E>(substring, newString, -1, false));
    }

    public ImmutableList<String> replaceForward(String substring, String newString, int replacementCount) {
    	return toList(new ReplaceElement<E>(substring, newString, replacementCount, false));
    }
    
    public ImmutableList<String> replaceBackward(String substring, String newString, int replacementCount) {
    	return toList(new ReplaceElement<E>(substring, newString, replacementCount, true));
    }
    
    public ImmutableList<String> replaceFirst(String substring, String newString) {
    	return toList(new ReplaceElement<E>(substring, newString, 1, false));
    }
    
    public ImmutableList<String> replaceLast(String substring, String newString) {
    	return toList(new ReplaceElement<E>(substring, newString, 1, true));
    }
    
    public ImmutableList<String> elementToLowerCase() {
    	return toList(new ElementToLowerCase<E>(Locale.getDefault()));
    }
    
    public ImmutableList<String> elementToLowerCase(Locale locale) {
    	return toList(new ElementToLowerCase<E>(locale));
    }

    public ImmutableList<String> elementToUpperCase() {
    	return toList(new ElementToUpperCase<E>(Locale.getDefault()));
    }

    public ImmutableList<String> elementToUpperCase(Locale locale) {
    	return toList(new ElementToUpperCase<E>(locale));
    }
    
    public ImmutableList<String> trimElement() {
    	return toList(new TrimElement<E>());
    }
    
    public ImmutableList<String> extractMatchFromElement(Pattern pattern, int group) {
    	return toList(new ExtractMatchFromElement<E>(pattern, group));
    } 
    
    public ImmutableList<E> denullify(E nullValue) {
    	return toList(new DenullifyElement<E>(nullValue));
    }
    
    public ImmutableList<E> removeNull() {
    	return toList(new RemoveNullElement<E>());
    }
    
    public ImmutableList<E> removeEmpty() {
    	return toList(new RemoveEmptyElement<E>());
    }

    public String join(String delimiter) {
    	return join(delimiter, "", "");
    }
    
    public String join(String delimiter, String prefix, String suffix) {
    	StringBuilder result = new StringBuilder();
    	result.append(prefix);
    	
    	int i = 0;
    	for (E e : this) {
    		if (i > 0) {
    			result.append(delimiter);
    		}
    		result.append(e == null ? "" : e.toString());
    		i++;
    	}
    	
    	result.append(suffix);
    	
    	return result.toString();
    }
    
    public ImmutableList<E> unionAll(Collection<? extends E> collection) {
    	List<E> result = new ArrayList<E>(this);
    	result.addAll(collection);
    	return this.comparator != null ? new ImmutableList<E>(result, this.comparator, false) : new ImmutableList<E>(result, this.equalityComparator, false);
    }
    
    public ImmutableList<E> union(Collection<? extends E> collection) {
    	List<E> result = new ArrayList<E>(this);
    	for (E element : collection) {
    		if (!this.contains(element)) {
    			result.add(element);
    		}
    	}
    	return this.comparator != null ? new ImmutableList<E>(result, this.comparator, false) : new ImmutableList<E>(result, this.equalityComparator, false);
    }
    
    public ImmutableList<E> minus(Collection<? extends E> collection) {
    	ImmutableList<E> temp = this.comparator != null ? new ImmutableList<E>(collection, this.comparator, false) : new ImmutableList<E>(collection, this.equalityComparator, false);
    	
    	List<E> result = new ArrayList<E>();
    	for (E element : this) {
    		if (!temp.contains(element)) {
    			result.add(element);
    		}
    	}
    	return this.comparator != null ? new ImmutableList<E>(result, this.comparator, false) : new ImmutableList<E>(result, this.equalityComparator, false);
    }
    
}

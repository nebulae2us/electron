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
package org.nebulae2us.electron.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

/**
 * @author Trung Phan
 *
 */
public class Immutables {

	public static final <E> ImmutableList<E> $(Collection<E> list) {
		return list instanceof ImmutableList ? (ImmutableList<E>)list : new ImmutableList<E>(list);
	}
	
	public static final <E> ImmutableList<E> $(E ... elements) {
		return new ImmutableList<E>(elements);
	}
	
	private static final ImmutableList<?> _emptyList = new ImmutableList<Object>();
	
	@SuppressWarnings("unchecked")
	public static final <E> ImmutableList<E> emptyList(Class<E> elementClass) {
		return (ImmutableList<E>)_emptyList;
	}

	public static final <E> ImmutableList<?> emptyList() {
		return _emptyList;
	}

	private static final ImmutableMap<?, ?> _emptyMap = new ImmutableMap<Object, Object>();
	
	@SuppressWarnings("unchecked")
	public static final <E> ImmutableMap<String, E> emptyStringMap(Class<E> elementClass) {
		return (ImmutableMap<String, E>)_emptyMap;
	}

	public static final ImmutableMap<String, ?> emptyStringMap() {
		return (ImmutableMap<String, ?>)_emptyMap;
	}

	/**
	 * Convert a collection to an immutable collection based on the expected collection type.
	 * Supported collection types include {@code Collection, List, Set, SortedSet, NavigableSet, ArrayList, LinkedList, Vector, HashSet, LinkedHashSet, TreeSet}.
	 * Throw {@code UnsupportedOperationException} if expected collection type is not supported.
	 * 
	 * If the expected collection is sorted set and the input collection is also a sorted set, the new immutable collection will use the comparator from the input collection.
	 * 
	 * The returned immutable collection is only truly immutable if all the elements are immutable and the comparator is immutable.
	 * 
	 * @param expectedCollectionType
	 * @param collection
	 * @return
	 * @throws UnsupportedOperationException if expected collection type is not supported.
	 */
	public static final <E, T extends Collection<E>> T toImmutableCollection(Class<T> expectedCollectionType, Collection<E> collection) {
		if (expectedCollectionType == Collection.class || expectedCollectionType == List.class) {
			return collection instanceof ImmutableList ? (T)collection : (T)new ImmutableList<E>(collection);
		}
		else if (expectedCollectionType == Set.class) {
			return collection instanceof ImmutableSet ? (T)collection : (T)new ImmutableSet<E>(collection);
		}
		else if (expectedCollectionType == SortedSet.class || expectedCollectionType == NavigableSet.class) {
			Comparator<Object> comparator = collection instanceof SortedSet ? ((SortedSet)collection).comparator() : null;
			return collection instanceof ImmutableSortedSet ? (T)collection : comparator == null ? (T)new ImmutableSortedSet<E>(collection) : (T)new ImmutableSortedSet<E>(collection, comparator);
		}
		else if (expectedCollectionType == ArrayList.class) {
			return collection instanceof ImmutableArrayList ? (T)collection : (T)new ImmutableArrayList<E>(collection);
		}
		else if (expectedCollectionType == LinkedList.class) {
			return collection instanceof ImmutableLinkedList ? (T)collection : (T)new ImmutableLinkedList<E>(collection);
		}
		else if (expectedCollectionType == Vector.class) {
			return collection instanceof ImmutableVector ? (T)collection : (T)new ImmutableVector<E>(collection);
		}
		else if (expectedCollectionType == HashSet.class) {
			return collection instanceof ImmutableHashSet ? (T)collection : (T)new ImmutableHashSet<E>(collection);
		}
		else if (expectedCollectionType == LinkedHashSet.class) {
			return collection instanceof ImmutableLinkedHashSet ? (T)collection : (T)new ImmutableLinkedHashSet<E>(collection);
		}
		else if (expectedCollectionType == TreeSet.class) {
			Comparator<Object> comparator = collection instanceof SortedSet ? ((SortedSet)collection).comparator() : null;
			return collection instanceof ImmutableTreeSet ? (T)collection : comparator == null ? (T)new ImmutableTreeSet<E>(collection) : (T)new ImmutableTreeSet<E>(collection, comparator);
		}
		throw new UnsupportedOperationException("Unsupported collection type " + expectedCollectionType);
	}
	
	/**
	 * Convert a map to an immutable map based on the expected map type.
	 * Supported map types include {@code Map, SortedMap, NavigableMap, HashMap, Hashtable, LinkedHashMap, IdentityHashMap, TreeMap}.
	 * Throw {@code UnsupportedOperationException} if expected map type is not supported.
	 * 
	 * If expected map type is sorted map and the input map is also sorted map, the new immutable map will use the comparator from the input map.
	 * 
	 * The returned immutable map is only truly immutable if all the elements are immutable and the comparator is immutable.
	 * 
	 * @param expectedMapType
	 * @param map
	 * @return
	 */
	public static final <K, V, T extends Map<K, V>> T toImmutableMap(Class<T> expectedMapType, Map<K, V> map) {
		if (expectedMapType == Map.class) {
			if (map instanceof ImmutableMapAware) {
				return (T)((ImmutableMapAware<K, V>)map).getImmutableMap();
			}
			
			return (T)new ImmutableMap<K, V>(map);
		}
		else if (expectedMapType == HashMap.class) {
			return map instanceof ImmutableHashMap ? (T)map : (T)new ImmutableHashMap<K, V>(map);
		}
		else if (expectedMapType == Hashtable.class) {
			return map instanceof ImmutableHashtable ? (T)map : (T)new ImmutableHashtable<K, V>(map);
		}
		else if (expectedMapType == LinkedHashMap.class) {
			return map instanceof ImmutableLinkedHashMap ? (T)map : (T)new ImmutableLinkedHashMap<K, V>(map);
		}
		else if (expectedMapType == IdentityHashMap.class) {
			return map instanceof ImmutableIdentityHashMap ? (T)map : (T)new ImmutableIdentityHashMap<K, V>(map);
		}
		else if (expectedMapType == SortedMap.class || expectedMapType == NavigableMap.class) {
			if (map instanceof ImmutableSortedMapAware) {
				return (T)((ImmutableSortedMapAware<K, V>)map).getImmutableSortedMap();
			}
			
			Comparator<Object> comparator = map instanceof SortedMap ? ((SortedMap)map).comparator() : null;
			return comparator == null ? (T)new ImmutableSortedMap<K, V>(map) : (T)new ImmutableSortedMap<K, V>(map, comparator);
		}
		else if (expectedMapType == TreeMap.class) {
			Comparator<Object> comparator = map instanceof SortedMap ? ((SortedMap)map).comparator() : null;
			return map instanceof ImmutableTreeMap ? (T)map : comparator == null ? (T)new ImmutableTreeMap<K, V>(map) : (T)new ImmutableTreeMap<K, V>(map, comparator);
		}
		
		throw new UnsupportedOperationException("Unsupported map type " + expectedMapType);		
	}
	
	
}

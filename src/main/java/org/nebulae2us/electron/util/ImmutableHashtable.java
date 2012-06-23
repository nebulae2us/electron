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

import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author Trung Phan
 *
 */
public final class ImmutableHashtable<K, V> extends Hashtable<K, V> implements ImmutableMapAware<K, V> {

	private static final long serialVersionUID = -8679494817604969315L;
	
	private final ImmutableMap<K, V> data;
	
	public ImmutableHashtable(Map<? extends K, ? extends V> m) {
		this.data = new ImmutableMap<K, V>(m, IdentityEqualityComparator.getInstance());
	}

	@Override
	public synchronized int size() {
		return data.size();
	}

	@Override
	public synchronized boolean isEmpty() {
		return data.isEmpty();
	}

	@Override
	public synchronized Enumeration<K> keys() {
		return new EnumerationAdapter<K>(data.keyIterator());
	}

	@Override
	public synchronized Enumeration<V> elements() {
		return new EnumerationAdapter<V>(data.valueIterator());
	}

	@Override
	public synchronized boolean contains(Object value) {
		return data.containsKey(value);
	}

	@Override
	public boolean containsValue(Object value) {
		return data.containsValue(value);
	}

	@Override
	public synchronized boolean containsKey(Object key) {
		return data.containsKey(key);
	}

	@Override
	public synchronized V get(Object key) {
		return data.get(key);
	}

	@Override
	protected void rehash() {
		throw new UnsupportedOperationException("rehash");
	}

	@Override
	public synchronized V put(K key, V value) {
		throw new UnsupportedOperationException("put");
	}

	@Override
	public synchronized V remove(Object key) {
		throw new UnsupportedOperationException("remove");
	}

	@Override
	public synchronized void putAll(Map<? extends K, ? extends V> t) {
		throw new UnsupportedOperationException("putAll");
	}

	@Override
	public synchronized void clear() {
		throw new UnsupportedOperationException("clear");
	}

	@Override
	public synchronized Object clone() {
		return this;
	}

	@Override
	public synchronized String toString() {
		return data.toString();
	}

	@Override
	public Set<K> keySet() {
		return data.keySet();
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		return data.entrySet();
	}

	@Override
	public Collection<V> values() {
		return data.values();
	}

	@Override
	public synchronized boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (o instanceof ImmutableHashtable) {
			return this.data.equals(((ImmutableHashtable<?, ?>)o).data);
		}
		return this.data.equals(o);
	}

	@Override
	public synchronized int hashCode() {
		return this.data.hashCode();
	}
	
	
	public class EnumerationAdapter<E> implements Enumeration<E> {

		private final Iterator<E> iterator;

		public EnumerationAdapter(Iterator<E> iterator) {
			this.iterator = iterator;
		}
		
		public boolean hasMoreElements() {
			return iterator.hasNext();
		}

		public E nextElement() {
			return iterator.next();
		}
		
	}

	public ImmutableMap<K, V> getImmutableMap() {
		return data;
	}

}

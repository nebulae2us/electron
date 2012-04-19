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

import java.util.Map.Entry;

/**
 * @author Trung Phan
 *
 */
public final class ImmutableEntry<K, V> implements Entry<K, V> {

	private final K key;
	private final V value;
	
	public ImmutableEntry(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public ImmutableEntry(Entry<K, V> entry) {
		if (entry == null) {
			throw new NullPointerException();
		}
		this.key = entry.getKey();
		this.value = entry.getValue();
	}
	
	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	public V setValue(V arg0) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || o.getClass() != this.getClass()) {
			return false;
		}
		ImmutableEntry<?,?> e = (ImmutableEntry<?,?>)o;
		
		if (this.key == null) {
			if (e.key != null) {
				return false;
			}
		}
		else if (!this.key.equals(e.key)) {
			return false;
		}
		
		if (this.value == null) {
			if (e.value != null) {
				return false;
			}
		}
		else if (!this.value.equals(e.value)) {
			return false;
		}
		
		return true;
	}

	@Override
	public int hashCode() {
		return (this.key == null ? 0 : this.key.hashCode()) ^ (this.value == null ? 0 : this.value.hashCode());
	}
}

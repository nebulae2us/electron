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
package org.nebulae2us.electron;

import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;

/**
 * @author Trung Phan
 *
 */
public class NullMirror implements Mirror {

	public boolean exists(String fieldName) {
		return true;
	}

	public <T> T to(Class<T> objectClass, String fieldName) {
		return null;
	}
	public <T> List<T> toListOf(Class<T> objectClass, String fieldName) {
		return null;
	}

	public <T> NavigableSet<T> toSortedSetOf(Class<T> objectClass,
			String fieldName) {
		return null;
	}

	public <T> Set<T> toSetOf(Class<T> objectClass, String fieldName) {
		return null;
	}

	public <K, V> Map<K, V> toMapOf(Class<K> keyClass, Class<V> valueClass,
			String fieldName) {
		return null;
	}

	public <K, V> Map<K, V> toIdentityMapOf(Class<K> keyClass,
			Class<V> valueClass, String fieldName) {
		return null;
	}

	public <K, V> Map<K, List<V>> toMultiValueMapOf(Class<K> keyClass,
			Class<V> valueClass, String fieldName) {
		return null;
	}

	public <K, V> Map<K, List<V>> toMultiValueIdentityMapOf(Class<K> keyClass,
			Class<V> valueClass, String fieldName) {
		return null;
	}

	public Object toObject(String fieldName) {
		return null;
	}

	public String toString(String fieldName) {
		return null;
	}

	public Integer toInteger(String fieldName) {
		return null;
	}

	public int toIntValue(String fieldName) {
		return 0;
	}

	public Long toLong(String fieldName) {
		return null;
	}

	public long toLongValue(String fieldName) {
		return 0;
	}

	public Short toShort(String fieldName) {
		return null;
	}

	public short toShortValue(String fieldName) {
		return 0;
	}

	public Byte toByte(String fieldName) {
		return null;
	}

	public byte toByteValue(String fieldName) {
		return 0;
	}

	public Double toDouble(String fieldName) {
		return null;
	}

	public double toDoubleValue(String fieldName) {
		return 0;
	}

	public Float toFloat(String fieldName) {
		return null;
	}

	public float toFloatValue(String fieldName) {
		return 0;
	}

	public Boolean toBoolean(String fieldName) {
		return null;
	}

	public boolean toBooleanValue(String fieldName) {
		return false;
	}

	public Character toCharacter(String fieldName) {
		return null;
	}

	public char toCharValue(String fieldName) {
		return 0;
	}

	public void bind(Object object) {
	}

}

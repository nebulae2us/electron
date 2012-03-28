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

/**
 * @author Trung Phan
 *
 */
public class Pair<P, Q> {

	private final P item1;
	
	private final Q item2;
	
	public Pair(P item1, Q item2) {
		this.item1 = item1;
		this.item2 = item2;
	}

	public P getItem1() {
		return item1;
	}

	public Q getItem2() {
		return item2;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		Pair<?, ?> p = (Pair<?, ?>)o;

		return ((item1 == null && p.item1 == null) || (item1 != null && item1.equals(p.item1))) &&
				((item2 == null && p.item2 == null) || (item2 != null && item2.equals(p.item2)));
	}
	
	@Override
	public int hashCode() {
		return (item1 == null ? 0 : item1.hashCode()) ^ (item2 == null ? 0 : item2.hashCode());
	}
	
}

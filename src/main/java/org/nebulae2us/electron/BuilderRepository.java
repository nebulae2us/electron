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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Trung Phan
 *
 */
public class BuilderRepository {
	
	private Map<Object, Object> map = new HashMap<Object, Object>();

	private final boolean supportLazy;

	private final Map<Object, List<Procedure>> listenersMap = new HashMap<Object, List<Procedure>>();
	
	public BuilderRepository() {
		this(false);
	}
	
	public BuilderRepository(boolean supportLazy) {
		this.supportLazy = supportLazy;
	}
	
	public void put(Object id, Object object) {
		if (map.containsKey(id)) {
			throw new IllegalStateException("Object with id " + id + " already exists in the repository.");
		}
		map.put(id, object);
		List<Procedure> listeners = listenersMap.get(id);
		if (listeners != null) {
			for (Procedure listener : listeners) {
				listener.execute(object);
			}
		}
	}

	public Object get(Object id) {
		return map.get(id);
	}

	public boolean isSupportLazy() {
		return supportLazy;
	}

	
	public void addObjectStoredListener(Object id, Procedure procedure) {
		List<Procedure> listeners = listenersMap.get(id);
		if (listeners == null) {
			listeners = new ArrayList<Procedure>();
			listenersMap.put(id, listeners);
		}
		listeners.add(procedure);
	}
	
}

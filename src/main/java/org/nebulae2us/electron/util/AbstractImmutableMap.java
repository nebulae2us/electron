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

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author Trung Phan
 */
public abstract class AbstractImmutableMap<K, V> implements Map<K, V> {

    public final V put(K key, V value) {
        throw new UnsupportedOperationException();
    }

    public final V remove(Object key) {
        throw new UnsupportedOperationException();
    }

    public final void putAll(Map<? extends K, ? extends V> m) {
        throw new UnsupportedOperationException();
    }

    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object o) {
    	if (o == this) {
    	    return true;
    	}

    	if (!(o instanceof Map)) {
    	    return false;
    	}
    	
    	Map<K,V> t = (Map<K,V>) o;
    	if (t.size() != size()) {
    	    return false;
    	}

        try {
            Iterator<Entry<K,V>> i = entrySet().iterator();
            while (i.hasNext()) {
                Entry<K,V> e = i.next();
                K key = e.getKey();
                V value = e.getValue();
                if (value == null) {
                    if (!(t.get(key)==null && t.containsKey(key)))
                        return false;
                } else {
                    if (!value.equals(t.get(key)))
                        return false;
                }
            }
        } catch(ClassCastException unused) {
            return false;
        } catch(NullPointerException unused) {
            return false;
        }

    	return true;
    }
    
    @Override
    public int hashCode() {
    	int h = 0;
    	Iterator<Entry<K,V>> i = entrySet().iterator();
    	while (i.hasNext()) {
    	    h += i.next().hashCode();
    	}
    	return h;
    }
    
    @Override
    public String toString() {
    	if (this.size() == 0) {
    		return "{}";
    	}

    	StringBuilder sb = new StringBuilder();
    	sb.append('{');
    	for (Entry<K, V> entry : this.entrySet()) {
    		if (sb.length() != 1) {
    			sb.append(", ");
    		}
    		K key = entry.getKey();
    		V value = entry.getValue();
    		sb.append(key == this ? "(this Map)" : key)
    		.append('=')
    		.append(value == this ? "(this Map)" : value);
    	}
    	sb.append('}');
    	return sb.toString();
    }
}

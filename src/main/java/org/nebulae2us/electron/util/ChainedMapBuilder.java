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

import org.nebulae2us.electron.BuilderRepository;
import org.nebulae2us.electron.ConverterOption;
import org.nebulae2us.electron.DestinationClassResolver;
import org.nebulae2us.electron.Procedure;
import org.nebulae2us.electron.WrapConverter;

/**
 * @author Trung Phan
 *
 */
public class ChainedMapBuilder<P, K, V> {

	private final Class<?> keyClass;
	
	private final Class<?> valueClass;
	
	private final P parentBuilder;
	
	private final Procedure listener;
	
	private DestinationClassResolver destinationClassResolver;
	
	public ChainedMapBuilder(Class<?> keyClass, Class<?> valueClass, DestinationClassResolver destinationClassResolver, P parentBuilder, Procedure listener) {
		this.keyClass = keyClass;
		this.valueClass = valueClass;
		this.parentBuilder = parentBuilder;
		this.listener = listener;
		this.destinationClassResolver = destinationClassResolver;
	}
	
	public ValueBuilder key(K key) {
		return new ValueBuilder(key);
	}
	
    public ValueBuilder key$wrap(Object wrapped) {
    	K key = (K)new WrapConverter(destinationClassResolver).convert(wrapped).to(keyClass);
    	return key(key);
    }	
	
	public ValueBuilder key$restoreFrom(BuilderRepository repo, Object builderId) {
        Object restoredObject = repo.get(builderId);
        if (restoredObject == null) {
            throw new IllegalStateException("Object does not exist with id " + builderId);
        }
        else if (!(keyClass.isInstance(restoredObject))) {
        	throw new IllegalStateException("Type mismatch for id: " + builderId + ". " + keyClass.getSimpleName() + " vs " + restoredObject.getClass().getSimpleName());
        }
        else {
        	return new ValueBuilder((K)restoredObject);
        }
	}
	
	public P end() {
		return parentBuilder;
	}

	public class ValueBuilder {
		
		private final K key;

		public ValueBuilder(K key) {
			this.key = key;
		}
		
		public ChainedMapBuilder<P, K, V> value(V value) {
			if (ChainedMapBuilder.this.listener != null) {
				ChainedMapBuilder.this.listener.execute(key, value);
			}
			return ChainedMapBuilder.this;
		}

		public ChainedMapBuilder<P, K, V> value$wrap(Object wrapped) {
			V value = (V)new WrapConverter(destinationClassResolver).convert(wrapped).to(valueClass);
			if (ChainedMapBuilder.this.listener != null) {
				ChainedMapBuilder.this.listener.execute(key, value);
			}
			return ChainedMapBuilder.this;
		}
		
		public ChainedMapBuilder<P, K, V> value$restoreFrom(BuilderRepository repo, Object builderId) {
	        Object restoredObject = repo.get(builderId);
	        if (restoredObject == null) {
	            throw new IllegalStateException("Object does not exist with id " + builderId);
	        }
	        else if (!(valueClass.isInstance(restoredObject))) {
	        	throw new IllegalStateException("Type mismatch for id: " + builderId + ". " + valueClass.getSimpleName() + " vs " + restoredObject.getClass().getSimpleName());
	        }
	        else {
				if (ChainedMapBuilder.this.listener != null) {
					ChainedMapBuilder.this.listener.execute(key, (V)restoredObject);
				}
				return ChainedMapBuilder.this;
	        }
		}

		
	}	
}

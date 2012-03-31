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
import java.util.List;

import org.nebulae2us.electron.BuilderRepository;
import org.nebulae2us.electron.ConverterOption;
import org.nebulae2us.electron.Procedure;
import org.nebulae2us.electron.WrapConverter;

/**
 * @author Trung Phan
 *
 */
public class ChainedMultiMapBuilder<P, K, V> {
	
	private final Class<?> keyClass;
	
	private final Class<?> valueClass;
	
	private final P parentBuilder;
	
	private final Procedure listener;
	
	private final ConverterOption option;
	
	public ChainedMultiMapBuilder(Class<?> keyClass, Class<?> valueClass, ConverterOption option, P parentBuilder, Procedure listener) {
		this.keyClass = keyClass;
		this.valueClass = valueClass;
		this.parentBuilder = parentBuilder;
		this.listener = listener;
		this.option = option;
	}
	
	public ValueBuilder key(K key) {
		return new ValueBuilder(key);
	}
	
    public ValueBuilder key$wrap(Object wrapped) {
    	K key = (K)new WrapConverter(option).convert(wrapped).to(keyClass);
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
		
		public ChainedMultiMapBuilder<P, K, V> values(V ... values) {
			if (values != null) {
				if (ChainedMultiMapBuilder.this.listener != null) {
					Object[] arguments = new Object[values.length + 1];
					arguments[0] = key;
					System.arraycopy(values, 0, arguments, 1, values.length);
					ChainedMultiMapBuilder.this.listener.execute(arguments);
				}
			}
			return ChainedMultiMapBuilder.this;
		}

		public ChainedMultiMapBuilder<P, K, V> values(Collection<V> values) {
			if (values != null) {
				if (ChainedMultiMapBuilder.this.listener != null) {
					Object[] arguments = new Object[values.size() + 1];
					arguments[0] = key;
					System.arraycopy(values.toArray(), 0, arguments, 1, values.size());
					ChainedMultiMapBuilder.this.listener.execute(arguments);
				}
			}
			return ChainedMultiMapBuilder.this;
		}
		
		public ValuesBuilder values$begin() {
			return new ValuesBuilder();
		}
		
		public class ValuesBuilder {
			
			private final List<V> values = new ArrayList<V>();
			
			public ValuesBuilder items(V ... values) {
				if (values != null) {
					for (V value : values) {
						this.values.add(value);
					}
				}
				return this;
			}

			public ValuesBuilder items(Collection<V> values) {
				if (values != null) {
					for (V value : values) {
						this.values.add(value);
					}
				}
				return this;
			}
			
			public ChainedMultiMapBuilder<P, K, V> end() {
				if (ChainedMultiMapBuilder.this.listener != null) {
					Object[] arguments = new Object[this.values.size() + 1];
					arguments[0] = key;
					System.arraycopy(values.toArray(), 0, arguments, 1, values.size());
					ChainedMultiMapBuilder.this.listener.execute(arguments);
				}
				return ChainedMultiMapBuilder.this;
			}
		}
		
	}	
	
	
}

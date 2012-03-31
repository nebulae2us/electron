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
package org.nebulae2us.electron.test.builder2.model;

import org.nebulae2us.electron.*;
import org.nebulae2us.electron.util.*;
import java.util.*;


/**
 * @author Trung Phan
 *
 */
public class SampleBuilderSpec implements Wrappable {

	protected final Sample $$$wrapped;

	/**
	 * Option defined at beginning to be used in method toSample() and wrap()
	 */
	protected final ConverterOption $$$option;
	
	public SampleBuilderSpec() {
		this(null, null);
	}
	
	protected SampleBuilderSpec(Sample wrapped, ConverterOption option) {
		this.$$$wrapped = wrapped;
		this.$$$option = option;
	}
	
    public SampleBuilderSpec storeTo(BuilderRepository repo, Object builderId) {
    	repo.put(builderId, this);
    	return this;
    }

	public Sample getWrappedObject() {
		return this.$$$wrapped;
	}
	
	protected void verifyMutable() {
		if (this.$$$wrapped != null) {
    		throw new IllegalStateException("Cannot mutate fields of immutable objects");
		}
	}

    public Sample toSample() {
    	return new Converter(this.$$$option, true).convert(this).to(Sample.class);
    }
    
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public SampleBuilderSpec name(String name) {
		this.name = name;
		return this;
	}
	
	private List<String> names;
	
	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

	public SampleBuilderSpec names(String ... names) {
		return names(new ListBuilder<String>().add(names).toList());
	}
	
	public SampleBuilderSpec names(Collection<String> names) {
		if (this.names == null) {
			this.names = new ArrayList<String>();
		}
		if (names != null) {
			for (String e : names) {
				this.names.add(e);
			}
		}
		return this;
	}
	
	
	private Set<String> keywords;
	
	public Set<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(Set<String> keywords) {
		this.keywords = keywords;
	}

	public SampleBuilderSpec keywords(String ... keywords) {
		return keywords(new ListBuilder<String>().add(keywords).toList());
	}

	public SampleBuilderSpec keywords(Collection<String> keywords) {
		if (this.keywords == null) {
			this.keywords = new HashSet<String>();
		}
		if (keywords != null) {
			for (String e : names) {
				this.keywords.add(e);
			}
		}
		return this;
	}
	
	private List<Collection<String>> keywordsList;
	
	public List<Collection<String>> getKeywordsList() {
		return keywordsList;
	}

	public void setKeywordsList(List<Collection<String>> keywordsList) {
		this.keywordsList = keywordsList;
	}

	public SampleBuilderSpec keywordsList(Collection<String> ... keywordsList) {
		return keywordsList(new ListBuilder<Collection<String>>().add(keywordsList).toList());
	}

	public SampleBuilderSpec keywordsList(Collection<Collection<String>> keywordsList) {
		if (this.keywordsList == null) {
			this.keywordsList = new ArrayList<Collection<String>>();
		}
		if (keywordsList != null) {
			for (Collection<String> e : keywordsList) {
				this.keywordsList.add(e);
			}
		}
		return this;
	}
	
	public ChainedMultiCollectionBuilder<? extends SampleBuilderSpec, String> keywordsList$begin() {
		if (this.keywordsList == null) {
			this.keywordsList = new ArrayList<Collection<String>>();
		}
		return new ChainedMultiCollectionBuilder<SampleBuilderSpec, String>(
				String.class, this.$$$option, this,
				new Procedure() {
					public void execute(Object... arguments) {
						Collection<String> newCollection = new ArrayList<String>();
						if (arguments != null) {
							for (Object argument : arguments) {
								newCollection.add((String)argument);
							}
						}
						SampleBuilderSpec.this.keywordsList.add(newCollection);
					}
				});
	}
	
	private Map<String, Integer> keywordCounts;

	public Map<String, Integer> getKeywordCounts() {
		return keywordCounts;
	}

	public void setKeywordCounts(Map<String, Integer> keywordCounts) {
		this.keywordCounts = keywordCounts;
	}
	
	public ChainedMapBuilder<? extends SampleBuilderSpec, String, Integer> keywordCounts$begin() {
		if (this.keywordCounts == null) {
			this.keywordCounts = new HashMap<String, Integer>();
		}
		return new ChainedMapBuilder<SampleBuilderSpec, String, Integer>(
				String.class,
				Integer.class,
				SampleBuilderSpec.this.$$$option,
				this,
				new Procedure() {
					public void execute(Object... arguments) {
						String key = (String)arguments[0];
						Integer value = (Integer)arguments[1];
						SampleBuilderSpec.this.keywordCounts.put(key, value);
					}
				}
				);
	}

	public SampleBuilderSpec keywordCounts(Map<String, Integer> keywordCounts) {
		if (this.keywordCounts == null) {
			this.keywordCounts = new HashMap<String, Integer>();
		}
		if (keywordCounts != null) {
			for (Map.Entry<String, Integer> e : keywordCounts.entrySet()) {
				this.keywordCounts.put(e.getKey(), e.getValue());
			}
		}
		return this;
	}
	
	private Map<String, Set<String>> keywordSynonyms;
	

	public Map<String, Set<String>> getKeywordSynonyms() {
		return keywordSynonyms;
	}

	public void setKeywordSynonyms(Map<String, Set<String>> keywordSynonyms) {
		this.keywordSynonyms = keywordSynonyms;
	}
	
	public SampleBuilderSpec keywordSynonyms(Map<String, Set<String>> keywordSynonyms) {
		if (this.keywordSynonyms == null) {
			this.keywordSynonyms = new HashMap<String, Set<String>>();
		}
		if (keywordSynonyms != null) {
			for (Map.Entry<String, Set<String>> e : keywordSynonyms.entrySet()) {
				this.keywordSynonyms.put(e.getKey(), e.getValue());
			}
		}
		return this;
	}
	
	public ChainedMultiMapBuilder<? extends SampleBuilderSpec, String, String> keywordSynonyms$begin() {
		if (this.keywordSynonyms == null) {
			this.keywordSynonyms = new HashMap<String, Set<String>>();
		}
		return new ChainedMultiMapBuilder<SampleBuilderSpec, String, String>(
				String.class, String.class, this.$$$option, this,
				new Procedure() {
					public void execute(Object... arguments) {
						String key = (String)arguments[0];
						Set<String> newCollection = new HashSet<String>();
						for (int i = 1; i < arguments.length; i++) {
							newCollection.add((String)arguments[i]);
						}
						SampleBuilderSpec.this.keywordSynonyms.put(key, newCollection);
					}
				}
				);
	}
	
	private Class<?> myClass;

	public Class<?> getMyClass() {
		return myClass;
	}

	public void setMyClass(Class<?> myClass) {
		this.myClass = myClass;
	}

	public SampleBuilderSpec myClass(Class<?> myClass) {
		this.myClass = myClass;
		return this;
	}
	
	private Set<Class<?>> otherClasses;

	/**
	 * NavigableSet is downgrade to Set interface
	 * @return
	 */
	public Set<Class<?>> getOtherClasses() {
		return otherClasses;
	}

	public void setOtherClasses(Set<Class<?>> otherClasses) {
		this.otherClasses = otherClasses;
	}
	
	public SampleBuilderSpec otherClasses(Class<?> ... otherClasses) {
		return otherClasses(new ListBuilder<Class<?>>().add(otherClasses).toList());
	}
	
	public SampleBuilderSpec otherClasses(Collection<Class<?>> otherClasses) {
		if (this.otherClasses == null) {
			this.otherClasses = new HashSet<Class<?>>();
		}
		if (otherClasses != null) {
			for (Class<?> e : otherClasses) {
				this.otherClasses.add(e);
			}
		}
		return this;
	}

	private Map<Class<?>, List<Class<?>>> friendClasses;
	
	public Map<Class<?>, List<Class<?>>> getFriendClasses() {
		return friendClasses;
	}

	public void setFriendClasses(Map<Class<?>, List<Class<?>>> friendClasses) {
		this.friendClasses = friendClasses;
	}

	public SampleBuilderSpec friendClasses(Map<Class<?>, List<Class<?>>> friendClasses) {
		if (this.friendClasses == null) {
			this.friendClasses = new HashMap<Class<?>, List<Class<?>>>();
		}
		if (friendClasses != null) {
			for (Map.Entry<Class<?>, List<Class<?>>> e : friendClasses.entrySet()) {
				this.friendClasses.put(e.getKey(), e.getValue());
			}
		}
		return this;
	}

	public ChainedMultiMapBuilder<? extends SampleBuilderSpec, Class<?>, Class<?>> friendClasses$begin() {
		if (this.friendClasses == null) {
			this.friendClasses = new HashMap<Class<?>, List<Class<?>>>();
		}
		return new ChainedMultiMapBuilder<SampleBuilderSpec, Class<?>, Class<?>>(
				Class.class,
				Class.class,
				SampleBuilderSpec.this.$$$option,
				this,
				new Procedure() {
					public void execute(Object... arguments) {
						Class<?> key = (Class<?>)arguments[0];
						List<Class<?>> newCollection = new ArrayList<Class<?>>();
						for (int i = 1; i < arguments.length; i++) {
							newCollection.add((Class<?>)arguments[i]);
						}
						SampleBuilderSpec.this.friendClasses.put(key, newCollection);
					}
				}
				);
	}
	
	private BlankBuilderSpec blank;

	public BlankBuilderSpec getBlank() {
		return blank;
	}

	public void setBlank(BlankBuilderSpec blank) {
		this.blank = blank;
	}
	
	public SampleBuilderSpec blank(BlankBuilderSpec blank) {
    	verifyMutable();
		this.blank = blank;
		return this;
	}
	
    public SampleBuilderSpec blank$wrap(Blank blank) {
    	verifyMutable();
    	this.blank = new WrapConverter(this.$$$option).convert(blank).to(BlankBuilderSpec.class);
        return this;
    }
    
    public SampleBuilderSpec blank$restoreFrom(BuilderRepository repo, Object builderId) {
    	verifyMutable();
    	
        Object restoredObject = repo.get(builderId);
        if (restoredObject == null) {
        	if (repo.isSupportLazy()) {
        		repo.addObjectStoredListener(builderId, new Procedure() {
					public void execute(Object... arguments) {
						SampleBuilderSpec.this.blank = (BlankBuilderSpec)arguments[0];
					}
				});
        	}
        	else {
                throw new IllegalStateException("Object does not exist with id " + builderId);
        	}
        }
        else if (!(restoredObject instanceof BlankBuilderSpec)) {
        	throw new IllegalStateException("Type mismatch for id: " + builderId + ". " + BlankBuilderSpec.class.getSimpleName() + " vs " + restoredObject.getClass().getSimpleName());
        }
        else {
            this.blank = (BlankBuilderSpec)restoredObject;
        }
        return this;
    }
    
	private Collection<BlankBuilderSpec> blanks;

	public Collection<BlankBuilderSpec> getBlanks() {
		return blanks;
	}

	public void setBlanks(Collection<BlankBuilderSpec> blanks) {
		this.blanks = blanks;
	}

	/**
	 * ArrayList is the default for Collection interface
	 * @param blanks
	 * @return
	 */
	public SampleBuilderSpec blanks(Collection<BlankBuilderSpec> blanks) {
		if (this.blanks == null) {
			this.blanks = new ArrayList<BlankBuilderSpec>();
		}
		if (blanks != null) {
			for (BlankBuilderSpec e : blanks) {
				this.blanks.add(e);
			}
		}
		return this;
	}
	
	public SampleBuilderSpec blanks(BlankBuilderSpec ... blanks) {
		return blanks(new ListBuilder<BlankBuilderSpec>().add(blanks).toList());
	}
	
    public SampleBuilderSpec blanks$wrap(Blank ... blanks) {
    	return blanks$wrap(new ListBuilder<Blank>().add(blanks).toList());
    }

    public SampleBuilderSpec blanks$wrap(Collection<Blank> blanks) {
		if (this.blanks == null) {
			this.blanks = new ArrayList<BlankBuilderSpec>();
		}
		if (blanks != null) {
			for (Blank e : blanks) {
				BlankBuilderSpec wrapped = new WrapConverter(this.$$$option).convert(e).to(BlankBuilderSpec.class);
				this.blanks.add(wrapped);
			}
		}
		return this;
    }
    
    public SampleBuilderSpec blanks$restoreFrom(BuilderRepository repo, Object ... builderIds) {
    	return blanks$restoreFrom(repo, new ListBuilder<Object>().add(builderIds).toList());
    }

    public SampleBuilderSpec blanks$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		if (this.blanks == null) {
			this.blanks = new ArrayList<BlankBuilderSpec>();
		}
		if (builderIds != null) {
	    	for (Object builderId : builderIds) {
	            Object restoredObject = repo.get(builderId);
	            if (restoredObject == null) {
	            	if (repo.isSupportLazy()) {
	            		repo.addObjectStoredListener(builderId, new Procedure() {
	    					public void execute(Object... arguments) {
	    						SampleBuilderSpec.this.blanks.add((BlankBuilderSpec)arguments[0]);
	    					}
	    				});
	            	}
	            	else {
	                    throw new IllegalStateException("Object does not exist with id " + builderId);
	            	}
	            }
	            else if (!(restoredObject instanceof BlankBuilderSpec)) {
	            	throw new IllegalStateException("Type mismatch for id: " + builderId + ". " + BlankBuilderSpec.class.getSimpleName() + " vs " + restoredObject.getClass().getSimpleName());
	            }
	            else {
	                this.blanks.add((BlankBuilderSpec)restoredObject);
	            }
	    	}
		}
        return this;
    }
    
    /**
     * Downgrade NavigableMap to Map
     */
	private Map<Class<BlankBuilderSpec>, BlankBuilderSpec> blanksMap;
	
	public Map<Class<BlankBuilderSpec>, BlankBuilderSpec> getBlanksMap() {
		return blanksMap;
	}

	public void setBlanksMap(
			Map<Class<BlankBuilderSpec>, BlankBuilderSpec> blanksMap) {
		this.blanksMap = blanksMap;
	}

	public ChainedMapBuilder<? extends SampleBuilderSpec, Class<BlankBuilderSpec>, BlankBuilderSpec> blanksMap$begin() {
		if (this.blanksMap == null) {
			this.blanksMap = new HashMap<Class<BlankBuilderSpec>, BlankBuilderSpec>();
		}
		return new ChainedMapBuilder<SampleBuilderSpec, Class<BlankBuilderSpec>, BlankBuilderSpec>(
				SampleBuilderSpec.class,
				Class.class,
				SampleBuilderSpec.this.$$$option,
				this,
				new Procedure() {
					public void execute(Object... arguments) {
						Class<BlankBuilderSpec> key = (Class<BlankBuilderSpec>)arguments[0];
						BlankBuilderSpec value = (BlankBuilderSpec)arguments[1];
						SampleBuilderSpec.this.blanksMap.put(key, value);
					}
				}
				);
	}
	
	public SampleBuilderSpec blanksMap(Map<Class<BlankBuilderSpec>, BlankBuilderSpec> blanksMap) {
		if (this.blanksMap == null) {
			this.blanksMap = new HashMap<Class<BlankBuilderSpec>, BlankBuilderSpec>();
		}
		if (blanksMap != null) {
			for (Map.Entry<Class<BlankBuilderSpec>, BlankBuilderSpec> e : blanksMap.entrySet()) {
				this.blanksMap.put(e.getKey(), e.getValue());
			}
		}
		return this;
	}

    
}

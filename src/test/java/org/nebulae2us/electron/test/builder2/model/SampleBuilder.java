package org.nebulae2us.electron.test.builder2.model;

import java.util.*;
import org.nebulae2us.electron.*;
import org.nebulae2us.electron.util.*;

public class SampleBuilder implements Wrappable<Sample> {

	protected final Sample $$$wrapped;

	protected final ConverterOption $$$option;
	
	public SampleBuilder() {
		this(null, null);
	}
	
	public SampleBuilder(ConverterOption option) {
		this(null, option);
	}

	protected SampleBuilder(Sample wrapped, ConverterOption option) {
		this.$$$wrapped = wrapped;
		this.$$$option = option;
	}
	
    public SampleBuilder storeTo(BuilderRepository repo, Object builderId) {
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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		verifyMutable();
		this.name = name;
	}

	public SampleBuilder name(String name) {
		verifyMutable();
		this.name = name;
		return this;
	}

	private List<String> names;
	
	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		verifyMutable();
		this.names = names;
	}

	public SampleBuilder names(String ... names) {
		verifyMutable();
		return names(new ListBuilder<String>().add(names).toList());
	}
	
	public SampleBuilder names(Collection<String> names) {
		verifyMutable();
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
		verifyMutable();
		this.keywords = keywords;
	}

	public SampleBuilder keywords(String ... keywords) {
		verifyMutable();
		return keywords(new ListBuilder<String>().add(keywords).toList());
	}
	
	public SampleBuilder keywords(Collection<String> keywords) {
		verifyMutable();
		if (this.keywords == null) {
			this.keywords = new HashSet<String>();
		}
		if (keywords != null) {
			for (String e : keywords) {
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
		verifyMutable();
		this.keywordsList = keywordsList;
	}

	private Map<String, Integer> keywordCounts;
	
	public Map<String, Integer> getKeywordCounts() {
		return keywordCounts;
	}

	public void setKeywordCounts(Map<String, Integer> keywordCounts) {
		verifyMutable();
		this.keywordCounts = keywordCounts;
	}

	public ChainedMapBuilder<? extends SampleBuilder, String, Integer> keywordCounts$begin() {
		verifyMutable();

		if (this.keywordCounts == null) {
			this.keywordCounts = new HashMap<String, Integer>();
		}
		return new ChainedMapBuilder<SampleBuilder, String, Integer>(
				String.class,
				Integer.class,
				SampleBuilder.this.$$$option,
				this,
				new Procedure() {
					public void execute(Object... arguments) {
						String key = (String)arguments[0];
						Integer value = (Integer)arguments[1];
						SampleBuilder.this.keywordCounts.put(key, value);
					}
				}
				);
	}

	public SampleBuilder keywordCounts(Map<String, Integer> keywordCounts) {
		verifyMutable();

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
		verifyMutable();
		this.keywordSynonyms = keywordSynonyms;
	}

	private Class<?> myClass;
	
	public Class<?> getMyClass() {
		return myClass;
	}

	public void setMyClass(Class<?> myClass) {
		verifyMutable();
		this.myClass = myClass;
	}

	public SampleBuilder myClass(Class<?> myClass) {
		verifyMutable();
		this.myClass = myClass;
		return this;
	}

	private NavigableSet<Class<?>> otherClasses;
	
	public NavigableSet<Class<?>> getOtherClasses() {
		return otherClasses;
	}

	public void setOtherClasses(NavigableSet<Class<?>> otherClasses) {
		verifyMutable();
		this.otherClasses = otherClasses;
	}

	public SampleBuilder otherClasses(Class<?> ... otherClasses) {
		verifyMutable();
		return otherClasses(new ListBuilder<Class<?>>().add(otherClasses).toList());
	}
	
	public SampleBuilder otherClasses(Collection<Class<?>> otherClasses) {
		verifyMutable();
		if (this.otherClasses == null) {
			this.otherClasses = new TreeSet<Class<?>>();
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
		verifyMutable();
		this.friendClasses = friendClasses;
	}

	private BlankBuilder blank;
	
	public BlankBuilder getBlank() {
		return blank;
	}

	public void setBlank(BlankBuilder blank) {
		verifyMutable();
		this.blank = blank;
	}

	public SampleBuilder blank(BlankBuilder blank) {
		verifyMutable();
		this.blank = blank;
		return this;
	}

    public SampleBuilder blank$wrap(Blank blank) {
    	verifyMutable();
    	this.blank = new WrapConverter(this.$$$option).convert(blank).to(BlankBuilder.class);
        return this;
    }
    
    public SampleBuilder blank$restoreFrom(BuilderRepository repo, Object builderId) {
    	verifyMutable();
    	
        Object restoredObject = repo.get(builderId);
        if (restoredObject == null) {
        	if (repo.isSupportLazy()) {
        		repo.addObjectStoredListener(builderId, new Procedure() {
					public void execute(Object... arguments) {
						SampleBuilder.this.blank = (BlankBuilder)arguments[0];
					}
				});
        	}
        	else {
                throw new IllegalStateException("Object does not exist with id " + builderId);
        	}
        }
        else if (!(restoredObject instanceof BlankBuilder)) {
        	throw new IllegalStateException("Type mismatch for id: " + builderId + ". " + BlankBuilder.class.getSimpleName() + " vs " + restoredObject.getClass().getSimpleName());
        }
        else {
            this.blank = (BlankBuilder)restoredObject;
        }
        return this;
    }

	private Collection<BlankBuilder> blanks;
	
	public Collection<BlankBuilder> getBlanks() {
		return blanks;
	}

	public void setBlanks(Collection<BlankBuilder> blanks) {
		verifyMutable();
		this.blanks = blanks;
	}

	public SampleBuilder blanks(BlankBuilder ... blanks) {
		verifyMutable();
		return blanks(new ListBuilder<BlankBuilder>().add(blanks).toList());
	}
	
	public SampleBuilder blanks(Collection<BlankBuilder> blanks) {
		verifyMutable();
		if (this.blanks == null) {
			this.blanks = new ArrayList<BlankBuilder>();
		}
		if (blanks != null) {
			for (BlankBuilder e : blanks) {
				this.blanks.add(e);
			}
		}
		return this;
	}

    public SampleBuilder blanks$wrap(Blank ... blanks) {
    	return blanks$wrap(new ListBuilder<Blank>().add(blanks).toList());
    }

    public SampleBuilder blanks$wrap(Collection<Blank> blanks) {
		verifyMutable();

		if (this.blanks == null) {
			this.blanks = new ArrayList<BlankBuilder>();
		}
		if (blanks != null) {
			for (Blank e : blanks) {
				BlankBuilder wrapped = new WrapConverter(this.$$$option).convert(e).to(BlankBuilder.class);
				this.blanks.add(wrapped);
			}
		}
		return this;
    }
    
    public SampleBuilder blanks$restoreFrom(BuilderRepository repo, Object ... builderIds) {
    	return blanks$restoreFrom(repo, new ListBuilder<Object>().add(builderIds).toList());
    }

    public SampleBuilder blanks$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		verifyMutable();

		if (this.blanks == null) {
			this.blanks = new ArrayList<BlankBuilder>();
		}
		if (builderIds != null) {
	    	for (Object builderId : builderIds) {
	            Object restoredObject = repo.get(builderId);
	            if (restoredObject == null) {
	            	if (repo.isSupportLazy()) {
	            		repo.addObjectStoredListener(builderId, new Procedure() {
	    					public void execute(Object... arguments) {
	    						SampleBuilder.this.blanks.add((BlankBuilder)arguments[0]);
	    					}
	    				});
	            	}
	            	else {
	                    throw new IllegalStateException("Object does not exist with id " + builderId);
	            	}
	            }
	            else if (!(restoredObject instanceof BlankBuilder)) {
	            	throw new IllegalStateException("Type mismatch for id: " + builderId + ". " + BlankBuilder.class.getSimpleName() + " vs " + restoredObject.getClass().getSimpleName());
	            }
	            else {
	                this.blanks.add((BlankBuilder)restoredObject);
	            }
	    	}
		}
        return this;
    }

	private NavigableMap<Class<BlankBuilder>, BlankBuilder> blanksMap;
	
	public NavigableMap<Class<BlankBuilder>, BlankBuilder> getBlanksMap() {
		return blanksMap;
	}

	public void setBlanksMap(NavigableMap<Class<BlankBuilder>, BlankBuilder> blanksMap) {
		verifyMutable();
		this.blanksMap = blanksMap;
	}

	public ChainedMapBuilder<? extends SampleBuilder, Class<BlankBuilder>, BlankBuilder> blanksMap$begin() {
		verifyMutable();

		if (this.blanksMap == null) {
			this.blanksMap = new TreeMap<Class<BlankBuilder>, BlankBuilder>();
		}
		return new ChainedMapBuilder<SampleBuilder, Class<BlankBuilder>, BlankBuilder>(
				Class.class,
				BlankBuilder.class,
				SampleBuilder.this.$$$option,
				this,
				new Procedure() {
					public void execute(Object... arguments) {
						Class<BlankBuilder> key = (Class<BlankBuilder>)arguments[0];
						BlankBuilder value = (BlankBuilder)arguments[1];
						SampleBuilder.this.blanksMap.put(key, value);
					}
				}
				);
	}

	public SampleBuilder blanksMap(Map<Class<BlankBuilder>, BlankBuilder> blanksMap) {
		verifyMutable();

		if (this.blanksMap == null) {
			this.blanksMap = new TreeMap<Class<BlankBuilder>, BlankBuilder>();
		}
		if (blanksMap != null) {
			for (Map.Entry<Class<BlankBuilder>, BlankBuilder> e : blanksMap.entrySet()) {
				this.blanksMap.put(e.getKey(), e.getValue());
			}
		}
		return this;
	}
}

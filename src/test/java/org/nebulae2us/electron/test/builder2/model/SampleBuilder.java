package org.nebulae2us.electron.test.builder2.model;

import java.util.*;
import org.nebulae2us.electron.*;
import org.nebulae2us.electron.util.*;

@Builder(destination=Sample.class)
public class SampleBuilder<P> implements Wrappable<Sample> {

	protected final Sample $$$wrapped;

	protected final P $$$parentBuilder;
	
	public SampleBuilder() {
		this.$$$wrapped = null;
		this.$$$parentBuilder = null;
	}
	
	public SampleBuilder(P parentBuilder) {
		this.$$$wrapped = null;
		this.$$$parentBuilder = parentBuilder;
	}

	protected SampleBuilder(Sample wrapped) {
		this.$$$wrapped = wrapped;
		this.$$$parentBuilder = null;
	}
	
    public SampleBuilder<P> storeTo(BuilderRepository repo, Object builderId) {
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

	public P end() {
		return this.$$$parentBuilder;
	}

    public Sample toSample() {
    	return new Converter(new BuilderAnnotationDestinationClassResolver(), true).convert(this).to(Sample.class);
    }

	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		verifyMutable();
		this.name = name;
	}

	public SampleBuilder<P> name(String name) {
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

	public SampleBuilder<P> names(String ... names) {
		verifyMutable();
		return names(new ListBuilder<String>().add(names).toList());
	}
	
	public SampleBuilder<P> names(Collection<String> names) {
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

	public SampleBuilder<P> keywords(String ... keywords) {
		verifyMutable();
		return keywords(new ListBuilder<String>().add(keywords).toList());
	}
	
	public SampleBuilder<P> keywords(Collection<String> keywords) {
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

	public SampleBuilder<P> keywordCounts(Map<String, Integer> keywordCounts) {
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

	public class KeywordCounts$builder<P1 extends SampleBuilder<P>> {
		
		private final P1 $$$parentBuilder;
		
		public class Value$builder {
			private String key;
			private Value$builder(String key) {
				this.key = key;
			}
			public KeywordCounts$builder<P1> value(Integer value) {
				SampleBuilder.this.keywordCounts.put(key, value);
				return KeywordCounts$builder.this;
			}
		}
		
		private KeywordCounts$builder(P1 parentBuilder) {
			this.$$$parentBuilder = parentBuilder;
		}
		
		public Value$builder key(String key) {
			return new Value$builder(key);
		}
		
		public P1 end() {
			return this.$$$parentBuilder;
		}
	}
	
	public KeywordCounts$builder<? extends SampleBuilder<P>> keywordCounts$map() {
		verifyMutable();

		if (this.keywordCounts == null) {
			this.keywordCounts = new HashMap<String, Integer>();
		}
		return new KeywordCounts$builder<SampleBuilder<P>>(this);
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

	public SampleBuilder<P> myClass(Class<?> myClass) {
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

	public SampleBuilder<P> otherClasses(Class<?> ... otherClasses) {
		verifyMutable();
		return otherClasses(new ListBuilder<Class<?>>().add(otherClasses).toList());
	}
	
	public SampleBuilder<P> otherClasses(Collection<Class<?>> otherClasses) {
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

	private BlankBuilder<?> blank;
	
	public BlankBuilder<?> getBlank() {
		return blank;
	}

	public void setBlank(BlankBuilder<?> blank) {
		verifyMutable();
		this.blank = blank;
	}

	public SampleBuilder<P> blank(BlankBuilder<?> blank) {
		verifyMutable();
		this.blank = blank;
		return this;
	}

	public BlankBuilder<? extends SampleBuilder<P>> blank$begin() {
		BlankBuilder<SampleBuilder<P>> result = new BlankBuilder<SampleBuilder<P>>(this);
		this.blank = result;
		return result;
	}

    public SampleBuilder<P> blank$wrap(Blank blank) {
    	verifyMutable();
    	this.blank = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER).convert(blank).to(BlankBuilder.class);
        return this;
    }
    
    public SampleBuilder<P> blank$restoreFrom(BuilderRepository repo, Object builderId) {
    	verifyMutable();
    	
        Object restoredObject = repo.get(builderId);
        if (restoredObject == null) {
        	if (repo.isSupportLazy()) {
        		repo.addObjectStoredListener(builderId, new Procedure() {
					public void execute(Object... arguments) {
						SampleBuilder.this.blank = (BlankBuilder<?>)arguments[0];
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
            this.blank = (BlankBuilder<?>)restoredObject;
        }
        return this;
    }

	private Collection<BlankBuilder<?>> blanks;
	
	public Collection<BlankBuilder<?>> getBlanks() {
		return blanks;
	}

	public void setBlanks(Collection<BlankBuilder<?>> blanks) {
		verifyMutable();
		this.blanks = blanks;
	}

	public SampleBuilder<P> blanks(BlankBuilder<?> ... blanks) {
		verifyMutable();
		return blanks(new ListBuilder<BlankBuilder<?>>().add(blanks).toList());
	}
	
	public SampleBuilder<P> blanks(Collection<BlankBuilder<?>> blanks) {
		verifyMutable();
		if (this.blanks == null) {
			this.blanks = new ArrayList<BlankBuilder<?>>();
		}
		if (blanks != null) {
			for (BlankBuilder<?> e : blanks) {
				this.blanks.add(e);
			}
		}
		return this;
	}

	public BlankBuilder<SampleBuilder<P>> blanks$one() {
		verifyMutable();
		if (this.blanks == null) {
			this.blanks = new ArrayList<BlankBuilder<?>>();
		}
		
		BlankBuilder<SampleBuilder<P>> result =
				new BlankBuilder<SampleBuilder<P>>(this);
		
		this.blanks.add(result);
		
		return result;
	}

	public class Blanks$$$builder {
		
		public BlankBuilder<Blanks$$$builder> blank$begin() {
			BlankBuilder<Blanks$$$builder> result = new BlankBuilder<Blanks$$$builder>(this);
			SampleBuilder.this.blanks.add(result);
			return result;
		}
		
		public SampleBuilder<P> end() {
			return SampleBuilder.this;
		}
	}
	
	public Blanks$$$builder blanks$list() {
		verifyMutable();
		if (this.blanks == null) {
			this.blanks = new ArrayList<BlankBuilder<?>>();
		}
		return new Blanks$$$builder();
	}

    public SampleBuilder<P> blanks$wrap(Blank ... blanks) {
    	return blanks$wrap(new ListBuilder<Blank>().add(blanks).toList());
    }

    public SampleBuilder<P> blanks$wrap(Collection<Blank> blanks) {
		verifyMutable();

		if (this.blanks == null) {
			this.blanks = new ArrayList<BlankBuilder<?>>();
		}
		if (blanks != null) {
			for (Blank e : blanks) {
				BlankBuilder<?> wrapped = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER).convert(e).to(BlankBuilder.class);
				this.blanks.add(wrapped);
			}
		}
		return this;
    }
    
    public SampleBuilder<P> blanks$restoreFrom(BuilderRepository repo, Object ... builderIds) {
    	return blanks$restoreFrom(repo, new ListBuilder<Object>().add(builderIds).toList());
    }

    public SampleBuilder<P> blanks$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		verifyMutable();

		if (this.blanks == null) {
			this.blanks = new ArrayList<BlankBuilder<?>>();
		}
		if (builderIds != null) {
	    	for (Object builderId : builderIds) {
	            Object restoredObject = repo.get(builderId);
	            if (restoredObject == null) {
	            	if (repo.isSupportLazy()) {
	            		repo.addObjectStoredListener(builderId, new Procedure() {
	    					public void execute(Object... arguments) {
	    						SampleBuilder.this.blanks.add((BlankBuilder<?>)arguments[0]);
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
	                this.blanks.add((BlankBuilder<?>)restoredObject);
	            }
	    	}
		}
        return this;
    }

	private NavigableMap<Class<BlankBuilder<?>>, BlankBuilder<?>> blanksMap;
	
	public NavigableMap<Class<BlankBuilder<?>>, BlankBuilder<?>> getBlanksMap() {
		return blanksMap;
	}

	public void setBlanksMap(NavigableMap<Class<BlankBuilder<?>>, BlankBuilder<?>> blanksMap) {
		verifyMutable();
		this.blanksMap = blanksMap;
	}

	public SampleBuilder<P> blanksMap(Map<Class<BlankBuilder<?>>, BlankBuilder<?>> blanksMap) {
		verifyMutable();

		if (this.blanksMap == null) {
			this.blanksMap = new TreeMap<Class<BlankBuilder<?>>, BlankBuilder<?>>();
		}
		if (blanksMap != null) {
			for (Map.Entry<Class<BlankBuilder<?>>, BlankBuilder<?>> e : blanksMap.entrySet()) {
				this.blanksMap.put(e.getKey(), e.getValue());
			}
		}
		return this;
	}

	public class BlanksMap$builder<P1 extends SampleBuilder<P>> {
		
		private final P1 $$$parentBuilder;
		
		public class Value$builder {
			private Class<BlankBuilder<?>> key;
			private Value$builder(Class<BlankBuilder<?>> key) {
				this.key = key;
			}
			public BlanksMap$builder<P1> value(BlankBuilder<?> value) {
				SampleBuilder.this.blanksMap.put(key, value);
				return BlanksMap$builder.this;
			}
		}
		
		private BlanksMap$builder(P1 parentBuilder) {
			this.$$$parentBuilder = parentBuilder;
		}
		
		public Value$builder key(Class<BlankBuilder<?>> key) {
			return new Value$builder(key);
		}
		
		public P1 end() {
			return this.$$$parentBuilder;
		}
	}
	
	public BlanksMap$builder<? extends SampleBuilder<P>> blanksMap$map() {
		verifyMutable();

		if (this.blanksMap == null) {
			this.blanksMap = new TreeMap<Class<BlankBuilder<?>>, BlankBuilder<?>>();
		}
		return new BlanksMap$builder<SampleBuilder<P>>(this);
	}	
}

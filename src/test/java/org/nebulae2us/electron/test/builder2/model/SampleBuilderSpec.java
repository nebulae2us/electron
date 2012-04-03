package org.nebulae2us.electron.test.builder2.model;

import java.util.*;
import org.nebulae2us.electron.*;
import org.nebulae2us.electron.test.builder2.model.SampleBuilderSpec.Blanks2blanks$builder;
import org.nebulae2us.electron.test.builder2.model.SampleBuilderSpec.Blanks2blanks$builder.Value$builder;
import org.nebulae2us.electron.util.*;

@Builder(destination=Sample.class)
public class SampleBuilderSpec<P> implements Wrappable<Sample> {

	protected final Sample $$$wrapped;

	protected final P $$$parentBuilder;
	
	public SampleBuilderSpec() {
		this.$$$wrapped = null;
		this.$$$parentBuilder = null;
	}
	
	public SampleBuilderSpec(P parentBuilder) {
		this.$$$wrapped = null;
		this.$$$parentBuilder = parentBuilder;
	}

	protected SampleBuilderSpec(Sample wrapped) {
		this.$$$wrapped = wrapped;
		this.$$$parentBuilder = null;
	}
	
    public SampleBuilderSpec<P> storeTo(BuilderRepository repo, Object builderId) {
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

	public SampleBuilderSpec<P> name(String name) {
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

	public SampleBuilderSpec<P> names(String ... names) {
		verifyMutable();
		return names(new ListBuilder<String>().add(names).toList());
	}
	
	public SampleBuilderSpec<P> names(Collection<String> names) {
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

	public SampleBuilderSpec<P> keywords(String ... keywords) {
		verifyMutable();
		return keywords(new ListBuilder<String>().add(keywords).toList());
	}
	
	public SampleBuilderSpec<P> keywords(Collection<String> keywords) {
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

	public SampleBuilderSpec<P> keywordCounts(Map<String, Integer> keywordCounts) {
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

	public class KeywordCounts$builder<P1 extends SampleBuilderSpec<P>> {
		
		private final P1 $$$parentBuilder;
		
		public class Value$builder {
			private String key;
			private Value$builder(String key) {
				this.key = key;
			}
			public KeywordCounts$builder<P1> value(Integer value) {
				SampleBuilderSpec.this.keywordCounts.put(key, value);
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
	
	public KeywordCounts$builder<? extends SampleBuilderSpec<P>> keywordCounts$map() {
		verifyMutable();

		if (this.keywordCounts == null) {
			this.keywordCounts = new HashMap<String, Integer>();
		}
		return new KeywordCounts$builder<SampleBuilderSpec<P>>(this);
	}	

	private Map<String, Set<String>> keywordSynonyms;
	
	public Map<String, Set<String>> getKeywordSynonyms() {
		return keywordSynonyms;
	}

	public void setKeywordSynonyms(Map<String, Set<String>> keywordSynonyms) {
		verifyMutable();
		this.keywordSynonyms = keywordSynonyms;
	}

	private Class<Object> myClass;
	
	public Class<Object> getMyClass() {
		return myClass;
	}

	public void setMyClass(Class<Object> myClass) {
		verifyMutable();
		this.myClass = myClass;
	}

	public SampleBuilderSpec<P> myClass(Class<Object> myClass) {
		verifyMutable();
		this.myClass = myClass;
		return this;
	}

	private NavigableSet<Class<Object>> otherClasses;
	
	public NavigableSet<Class<Object>> getOtherClasses() {
		return otherClasses;
	}

	public void setOtherClasses(NavigableSet<Class<Object>> otherClasses) {
		verifyMutable();
		this.otherClasses = otherClasses;
	}

	public SampleBuilderSpec<P> otherClasses(Class<Object> ... otherClasses) {
		verifyMutable();
		return otherClasses(new ListBuilder<Class<Object>>().add(otherClasses).toList());
	}
	
	public SampleBuilderSpec<P> otherClasses(Collection<Class<Object>> otherClasses) {
		verifyMutable();
		if (this.otherClasses == null) {
			this.otherClasses = new TreeSet<Class<Object>>();
		}
		if (otherClasses != null) {
			for (Class<Object> e : otherClasses) {
				this.otherClasses.add(e);
			}
		}
		return this;
	}

	private Map<Class<Object>, List<Class<Object>>> friendClasses;
	
	public Map<Class<Object>, List<Class<Object>>> getFriendClasses() {
		return friendClasses;
	}

	public void setFriendClasses(Map<Class<Object>, List<Class<Object>>> friendClasses) {
		verifyMutable();
		this.friendClasses = friendClasses;
	}

	private BlankBuilderSpec<?> blank;
	
	public BlankBuilderSpec<?> getBlank() {
		return blank;
	}

	public void setBlank(BlankBuilderSpec<?> blank) {
		verifyMutable();
		this.blank = blank;
	}

	public SampleBuilderSpec<P> blank(BlankBuilderSpec<?> blank) {
		verifyMutable();
		this.blank = blank;
		return this;
	}

	public BlankBuilderSpec<? extends SampleBuilderSpec<P>> blank$begin() {
		BlankBuilderSpec<SampleBuilderSpec<P>> result = new BlankBuilderSpec<SampleBuilderSpec<P>>(this);
		this.blank = result;
		return result;
	}

    public SampleBuilderSpec<P> blank$wrap(Blank blank) {
    	verifyMutable();
    	this.blank = new WrapConverter(BuilderSpecs.DESTINATION_CLASS_RESOLVER).convert(blank).to(BlankBuilderSpec.class);
        return this;
    }
    
    public SampleBuilderSpec<P> blank$restoreFrom(BuilderRepository repo, Object builderId) {
    	verifyMutable();
    	
        Object restoredObject = repo.get(builderId);
        if (restoredObject == null) {
        	if (repo.isSupportLazy()) {
        		repo.addObjectStoredListener(builderId, new Procedure() {
					public void execute(Object... arguments) {
						SampleBuilderSpec.this.blank = (BlankBuilderSpec<?>)arguments[0];
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
            this.blank = (BlankBuilderSpec<?>)restoredObject;
        }
        return this;
    }

	private Collection<BlankBuilderSpec<?>> blanks;
	
	public Collection<BlankBuilderSpec<?>> getBlanks() {
		return blanks;
	}

	public void setBlanks(Collection<BlankBuilderSpec<?>> blanks) {
		verifyMutable();
		this.blanks = blanks;
	}

	public SampleBuilderSpec<P> blanks(BlankBuilderSpec<?> ... blanks) {
		verifyMutable();
		return blanks(new ListBuilder<BlankBuilderSpec<?>>().add(blanks).toList());
	}
	
	public SampleBuilderSpec<P> blanks(Collection<BlankBuilderSpec<?>> blanks) {
		verifyMutable();
		if (this.blanks == null) {
			this.blanks = new ArrayList<BlankBuilderSpec<?>>();
		}
		if (blanks != null) {
			for (BlankBuilderSpec<?> e : blanks) {
				this.blanks.add(e);
			}
		}
		return this;
	}

	public BlankBuilderSpec<SampleBuilderSpec<P>> blanks$one() {
		verifyMutable();
		if (this.blanks == null) {
			this.blanks = new ArrayList<BlankBuilderSpec<?>>();
		}
		
		BlankBuilderSpec<SampleBuilderSpec<P>> result =
				new BlankBuilderSpec<SampleBuilderSpec<P>>(this);
		
		this.blanks.add(result);
		
		return result;
	}

	public class Blanks$$$builder {
		
		public BlankBuilderSpec<Blanks$$$builder> blank$begin() {
			BlankBuilderSpec<Blanks$$$builder> result = new BlankBuilderSpec<Blanks$$$builder>(this);
			SampleBuilderSpec.this.blanks.add(result);
			return result;
		}
		
		public SampleBuilderSpec<P> end() {
			return SampleBuilderSpec.this;
		}
	}
	
	public Blanks$$$builder blanks$list() {
		verifyMutable();
		if (this.blanks == null) {
			this.blanks = new ArrayList<BlankBuilderSpec<?>>();
		}
		return new Blanks$$$builder();
	}

    public SampleBuilderSpec<P> blanks$wrap(Blank ... blanks) {
    	return blanks$wrap(new ListBuilder<Blank>().add(blanks).toList());
    }

    public SampleBuilderSpec<P> blanks$wrap(Collection<Blank> blanks) {
		verifyMutable();

		if (this.blanks == null) {
			this.blanks = new ArrayList<BlankBuilderSpec<?>>();
		}
		if (blanks != null) {
			for (Blank e : blanks) {
				BlankBuilderSpec<?> wrapped = new WrapConverter(BuilderSpecs.DESTINATION_CLASS_RESOLVER).convert(e).to(BlankBuilderSpec.class);
				this.blanks.add(wrapped);
			}
		}
		return this;
    }
    
    public SampleBuilderSpec<P> blanks$restoreFrom(BuilderRepository repo, Object ... builderIds) {
    	return blanks$restoreFrom(repo, new ListBuilder<Object>().add(builderIds).toList());
    }

    public SampleBuilderSpec<P> blanks$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		verifyMutable();

		if (this.blanks == null) {
			this.blanks = new ArrayList<BlankBuilderSpec<?>>();
		}
		if (builderIds != null) {
	    	for (Object builderId : builderIds) {
	            Object restoredObject = repo.get(builderId);
	            if (restoredObject == null) {
	            	if (repo.isSupportLazy()) {
	            		repo.addObjectStoredListener(builderId, new Procedure() {
	    					public void execute(Object... arguments) {
	    						SampleBuilderSpec.this.blanks.add((BlankBuilderSpec<?>)arguments[0]);
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
	                this.blanks.add((BlankBuilderSpec<?>)restoredObject);
	            }
	    	}
		}
        return this;
    }

	private NavigableMap<Class<BlankBuilderSpec>, BlankBuilderSpec<?>> blanksMap;
	
	public NavigableMap<Class<BlankBuilderSpec>, BlankBuilderSpec<?>> getBlanksMap() {
		return blanksMap;
	}

	public void setBlanksMap(NavigableMap<Class<BlankBuilderSpec>, BlankBuilderSpec<?>> blanksMap) {
		verifyMutable();
		this.blanksMap = blanksMap;
	}

	public SampleBuilderSpec<P> blanksMap(Map<Class<BlankBuilderSpec>, BlankBuilderSpec<?>> blanksMap) {
		verifyMutable();

		if (this.blanksMap == null) {
			this.blanksMap = new TreeMap<Class<BlankBuilderSpec>, BlankBuilderSpec<?>>();
		}
		if (blanksMap != null) {
			for (Map.Entry<Class<BlankBuilderSpec>, BlankBuilderSpec<?>> e : blanksMap.entrySet()) {
				this.blanksMap.put(e.getKey(), e.getValue());
			}
		}
		return this;
	}

	public class BlanksMap$builder<P1 extends SampleBuilderSpec<P>> {
		
		private final P1 $$$parentBuilder;
		
		public class Value$builder {
			private Class<BlankBuilderSpec> key;
			private Value$builder(Class<BlankBuilderSpec> key) {
				this.key = key;
			}
			public BlanksMap$builder<P1> value(BlankBuilderSpec<?> value) {
				SampleBuilderSpec.this.blanksMap.put(key, value);
				return BlanksMap$builder.this;
			}
		}
		
		private BlanksMap$builder(P1 parentBuilder) {
			this.$$$parentBuilder = parentBuilder;
		}
		
		public Value$builder key(Class<BlankBuilderSpec> key) {
			return new Value$builder(key);
		}
		
		public P1 end() {
			return this.$$$parentBuilder;
		}
	}
	
	public BlanksMap$builder<? extends SampleBuilderSpec<P>> blanksMap$map() {
		verifyMutable();

		if (this.blanksMap == null) {
			this.blanksMap = new TreeMap<Class<BlankBuilderSpec>, BlankBuilderSpec<?>>();
		}
		return new BlanksMap$builder<SampleBuilderSpec<P>>(this);
	}	

	private Map<BlankBuilderSpec<?>, BlankBuilderSpec<?>> blanks2blanks;
	
	public Map<BlankBuilderSpec<?>, BlankBuilderSpec<?>> getBlanks2blanks() {
		return blanks2blanks;
	}

	public void setBlanks2blanks(Map<BlankBuilderSpec<?>, BlankBuilderSpec<?>> blanks2blanks) {
		verifyMutable();
		this.blanks2blanks = blanks2blanks;
	}

	public SampleBuilderSpec<P> blanks2blanks(Map<BlankBuilderSpec<?>, BlankBuilderSpec<?>> blanks2blanks) {
		verifyMutable();

		if (this.blanks2blanks == null) {
			this.blanks2blanks = new HashMap<BlankBuilderSpec<?>, BlankBuilderSpec<?>>();
		}
		if (blanks2blanks != null) {
			for (Map.Entry<BlankBuilderSpec<?>, BlankBuilderSpec<?>> e : blanks2blanks.entrySet()) {
				this.blanks2blanks.put(e.getKey(), e.getValue());
			}
		}
		return this;
	}

	public class Blanks2blanks$builder<P1 extends SampleBuilderSpec<P>> {
		
		private final P1 $$$parentBuilder;
		
		public class Value$builder {
			private BlankBuilderSpec<?> key;
			private Value$builder(BlankBuilderSpec<?> key) {
				this.key = key;
			}
			public Blanks2blanks$builder<P1> value(BlankBuilderSpec<?> value) {
				SampleBuilderSpec.this.blanks2blanks.put(key, value);
				return Blanks2blanks$builder.this;
			}
// if value is builder
//			public BlankBuilderSpec<Blanks2blanks$builder<P1>> value$begin() {
//				BlankBuilderSpec<Blanks2blanks$builder<P1>> result = new BlankBuilderSpec<Blanks2blanks$builder<P1>>(Blanks2blanks$builder.this);
//				SampleBuilderSpec.this.blanks2blanks.put(key, result);
//				return result;
//			}
		}
		
		private Blanks2blanks$builder(P1 parentBuilder) {
			this.$$$parentBuilder = parentBuilder;
		}
		
		public Value$builder key(BlankBuilderSpec<?> key) {
			return new Value$builder(key);
		}
// if key is builder
//		public BlankBuilderSpec<Value$builder> key$begin() {
//			Value$builder b = new Value$builder(null);
//			BlankBuilderSpec<Value$builder> result = new BlankBuilderSpec<Value$builder>(b);
//			b.key = result;
//			return result;
//		}

		public P1 end() {
			return this.$$$parentBuilder;
		}
	}
	
	public Blanks2blanks$builder<? extends SampleBuilderSpec<P>> blanks2blanks$map() {
		verifyMutable();

		if (this.blanks2blanks == null) {
			this.blanks2blanks = new HashMap<BlankBuilderSpec<?>, BlankBuilderSpec<?>>();
		}
		return new Blanks2blanks$builder<SampleBuilderSpec<P>>(this);
	}	
}
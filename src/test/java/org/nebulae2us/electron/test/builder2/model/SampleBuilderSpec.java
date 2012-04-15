package org.nebulae2us.electron.test.builder2.model;

import java.util.*;
import org.nebulae2us.electron.*;
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
		if (wrapped == null) {
			throw new NullPointerException();
		}
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
		if (this.$$$wrapped != null && WrapHelper.valueNotSet(this.name, String.class)) {
			Object o = WrapHelper.getValue(this.$$$wrapped, Sample.class, "name");
			this.name = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER).convert(o).to(String.class);
		}

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
		if (this.$$$wrapped != null && WrapHelper.valueNotSet(this.names, List.class)) {
			Object o = WrapHelper.getValue(this.$$$wrapped, Sample.class, "names");
			this.names = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER).convert(o).to(List.class);
		}

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
				CollectionUtils.addItem(this.names, e);
			}
		}
		return this;
	}



	private Set<String> keywords;
	
	public Set<String> getKeywords() {
		if (this.$$$wrapped != null && WrapHelper.valueNotSet(this.keywords, Set.class)) {
			Object o = WrapHelper.getValue(this.$$$wrapped, Sample.class, "keywords");
			this.keywords = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER).convert(o).to(Set.class);
		}

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
				CollectionUtils.addItem(this.keywords, e);
			}
		}
		return this;
	}



	private List<Collection<String>> keywordsList;
	
	public List<Collection<String>> getKeywordsList() {
		if (this.$$$wrapped != null && WrapHelper.valueNotSet(this.keywordsList, List.class)) {
			Object o = WrapHelper.getValue(this.$$$wrapped, Sample.class, "keywordsList");
			this.keywordsList = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER).convert(o).to(List.class);
		}

		return keywordsList;
	}

	public void setKeywordsList(List<Collection<String>> keywordsList) {
		verifyMutable();
		this.keywordsList = keywordsList;
	}

	private Map<String, Integer> keywordCounts;
	
	public Map<String, Integer> getKeywordCounts() {
		if (this.$$$wrapped != null && WrapHelper.valueNotSet(this.keywordCounts, Map.class)) {
			Object o = WrapHelper.getValue(this.$$$wrapped, Sample.class, "keywordCounts");
			this.keywordCounts = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER).convert(o).to(Map.class);
		}

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
				CollectionUtils.putItem(this.keywordCounts, e.getKey(), e.getValue());
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
				CollectionUtils.putItem(SampleBuilderSpec.this.keywordCounts, key, value);
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
		if (this.$$$wrapped != null && WrapHelper.valueNotSet(this.keywordSynonyms, Map.class)) {
			Object o = WrapHelper.getValue(this.$$$wrapped, Sample.class, "keywordSynonyms");
			this.keywordSynonyms = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER).convert(o).to(Map.class);
		}

		return keywordSynonyms;
	}

	public void setKeywordSynonyms(Map<String, Set<String>> keywordSynonyms) {
		verifyMutable();
		this.keywordSynonyms = keywordSynonyms;
	}

	private Class<?> myClass;
	
	public Class<?> getMyClass() {
		if (this.$$$wrapped != null && WrapHelper.valueNotSet(this.myClass, Class.class)) {
			Object o = WrapHelper.getValue(this.$$$wrapped, Sample.class, "myClass");
			this.myClass = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER).convert(o).to(Class.class);
		}

		return myClass;
	}

	public void setMyClass(Class<?> myClass) {
		verifyMutable();
		this.myClass = myClass;
	}

	public SampleBuilderSpec<P> myClass(Class<?> myClass) {
		verifyMutable();
		this.myClass = myClass;
		return this;
	}

	private NavigableSet<Class<?>> otherClasses;
	
	public NavigableSet<Class<?>> getOtherClasses() {
		if (this.$$$wrapped != null && WrapHelper.valueNotSet(this.otherClasses, NavigableSet.class)) {
			Object o = WrapHelper.getValue(this.$$$wrapped, Sample.class, "otherClasses");
			this.otherClasses = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER).convert(o).to(NavigableSet.class);
		}

		return otherClasses;
	}

	public void setOtherClasses(NavigableSet<Class<?>> otherClasses) {
		verifyMutable();
		this.otherClasses = otherClasses;
	}

	public SampleBuilderSpec<P> otherClasses(Class<?> ... otherClasses) {
		verifyMutable();
		return otherClasses(new ListBuilder<Class<?>>().add(otherClasses).toList());
	}
	
	public SampleBuilderSpec<P> otherClasses(Collection<Class<?>> otherClasses) {
		verifyMutable();
		if (this.otherClasses == null) {
			this.otherClasses = new TreeSet<Class<?>>();
		}
		if (otherClasses != null) {
			for (Class<?> e : otherClasses) {
				CollectionUtils.addItem(this.otherClasses, e);
			}
		}
		return this;
	}



	private Map<Class<?>, List<Class<?>>> friendClasses;
	
	public Map<Class<?>, List<Class<?>>> getFriendClasses() {
		if (this.$$$wrapped != null && WrapHelper.valueNotSet(this.friendClasses, Map.class)) {
			Object o = WrapHelper.getValue(this.$$$wrapped, Sample.class, "friendClasses");
			this.friendClasses = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER).convert(o).to(Map.class);
		}

		return friendClasses;
	}

	public void setFriendClasses(Map<Class<?>, List<Class<?>>> friendClasses) {
		verifyMutable();
		this.friendClasses = friendClasses;
	}

	private BlankBuilderSpec<?> blank;
	
	public BlankBuilderSpec<?> getBlank() {
		if (this.$$$wrapped != null && WrapHelper.valueNotSet(this.blank, BlankBuilderSpec.class)) {
			Object o = WrapHelper.getValue(this.$$$wrapped, Sample.class, "blank");
			this.blank = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER).convert(o).to(BlankBuilderSpec.class);
		}

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

	public BlankBuilderSpec<? extends SampleBuilderSpec<P>> blank$begin() {
		verifyMutable();
		BlankBuilderSpec<SampleBuilderSpec<P>> result = new BlankBuilderSpec<SampleBuilderSpec<P>>(this);
		this.blank = result;
		return result;
	}

	private Collection<BlankBuilderSpec<?>> blanks;
	
	public Collection<BlankBuilderSpec<?>> getBlanks() {
		if (this.$$$wrapped != null && WrapHelper.valueNotSet(this.blanks, Collection.class)) {
			Object o = WrapHelper.getValue(this.$$$wrapped, Sample.class, "blanks");
			this.blanks = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER).convert(o).to(Collection.class);
		}

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
				CollectionUtils.addItem(this.blanks, e);
			}
		}
		return this;
	}

	public BlankBuilderSpec<? extends SampleBuilderSpec<P>> blanks$addBlank() {
		verifyMutable();
		if (this.blanks == null) {
			this.blanks = new ArrayList<BlankBuilderSpec<?>>();
		}
		
		BlankBuilderSpec<SampleBuilderSpec<P>> result =
				new BlankBuilderSpec<SampleBuilderSpec<P>>(this);
		
		CollectionUtils.addItem(this.blanks, result);
		
		return result;
	}
	

	public class Blanks$$$builder<P1 extends SampleBuilderSpec<P>> {
	
		private final P1 $$$parentBuilder1;
	
		protected Blanks$$$builder(P1 parentBuilder) {
			this.$$$parentBuilder1 = parentBuilder;
		}

		public BlankBuilderSpec<Blanks$$$builder<P1>> blank$begin() {
			BlankBuilderSpec<Blanks$$$builder<P1>> result = new BlankBuilderSpec<Blanks$$$builder<P1>>(this);
			CollectionUtils.addItem(SampleBuilderSpec.this.blanks, result);
			return result;
		}
		

		public P1 end() {
			return this.$$$parentBuilder1;
		}
	}
	
	public Blanks$$$builder<? extends SampleBuilderSpec<P>> blanks$list() {
		verifyMutable();
		if (this.blanks == null) {
			this.blanks = new ArrayList<BlankBuilderSpec<?>>();
		}
		return new Blanks$$$builder<SampleBuilderSpec<P>>(this);
	}

    public SampleBuilderSpec<P> blanks$wrap(Blank ... blanks) {
    	return blanks$wrap(new ListBuilder<Blank>().add(blanks).toList());
    }

    public SampleBuilderSpec<P> blanks$wrap(Collection<? extends Blank> blanks) {
		verifyMutable();

		if (this.blanks == null) {
			this.blanks = new ArrayList<BlankBuilderSpec<?>>();
		}
		if (blanks != null) {
			for (Blank e : blanks) {
				BlankBuilderSpec<?> wrapped = new WrapConverter(BuilderSpecs.DESTINATION_CLASS_RESOLVER).convert(e).to(BlankBuilderSpec.class);
				CollectionUtils.addItem(this.blanks, wrapped);
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
	    						CollectionUtils.addItem(SampleBuilderSpec.this.blanks, arguments[0]);
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
	                CollectionUtils.addItem(this.blanks, restoredObject);
	            }
	    	}
		}
        return this;
    }


	private NavigableMap<Class<BlankBuilderSpec>, BlankBuilderSpec<?>> blanksMap;
	
	public NavigableMap<Class<BlankBuilderSpec>, BlankBuilderSpec<?>> getBlanksMap() {
		if (this.$$$wrapped != null && WrapHelper.valueNotSet(this.blanksMap, NavigableMap.class)) {
			Object o = WrapHelper.getValue(this.$$$wrapped, Sample.class, "blanksMap");
			this.blanksMap = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER).convert(o).to(NavigableMap.class);
		}

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
				CollectionUtils.putItem(this.blanksMap, e.getKey(), e.getValue());
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
				CollectionUtils.putItem(SampleBuilderSpec.this.blanksMap, key, value);
				return BlanksMap$builder.this;
			}

			public BlankBuilderSpec<BlanksMap$builder<P1>> value$asBlank() {
				BlankBuilderSpec<BlanksMap$builder<P1>> result = new BlankBuilderSpec<BlanksMap$builder<P1>>(BlanksMap$builder.this);
				CollectionUtils.putItem(SampleBuilderSpec.this.blanksMap, key, result);
				return result;
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
		if (this.$$$wrapped != null && WrapHelper.valueNotSet(this.blanks2blanks, Map.class)) {
			Object o = WrapHelper.getValue(this.$$$wrapped, Sample.class, "blanks2blanks");
			this.blanks2blanks = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER).convert(o).to(Map.class);
		}

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
				CollectionUtils.putItem(this.blanks2blanks, e.getKey(), e.getValue());
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
				CollectionUtils.putItem(SampleBuilderSpec.this.blanks2blanks, key, value);
				return Blanks2blanks$builder.this;
			}

			public BlankBuilderSpec<Blanks2blanks$builder<P1>> value$asBlank() {
				BlankBuilderSpec<Blanks2blanks$builder<P1>> result = new BlankBuilderSpec<Blanks2blanks$builder<P1>>(Blanks2blanks$builder.this);
				CollectionUtils.putItem(SampleBuilderSpec.this.blanks2blanks, key, result);
				return result;
			}
			

		}
		
		private Blanks2blanks$builder(P1 parentBuilder) {
			this.$$$parentBuilder = parentBuilder;
		}
		
		public Value$builder key(BlankBuilderSpec<?> key) {
			return new Value$builder(key);
		}
		
		public BlankBuilderSpec<Value$builder> key$asBlank() {
			BlankBuilderSpec<Value$builder> result = new BlankBuilderSpec<Value$builder>(new Value$builder(null));
			result.$$$parentBuilder.key = result;
			return result;
		}
		

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

    /* CUSTOM CODE *********************************
     * 
     * Put your own custom code below. These codes won't be discarded during generation.
     * 
     */
     
     
     
}

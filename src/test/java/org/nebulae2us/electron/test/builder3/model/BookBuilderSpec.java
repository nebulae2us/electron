package org.nebulae2us.electron.test.builder3.model;

import java.io.*;
import java.util.*;
import org.nebulae2us.electron.*;
import org.nebulae2us.electron.util.*;

@Builder(destination=Book.class)
public class BookBuilderSpec<P> implements Wrappable<Book<? extends Color, ? extends Paper<? extends Color>, ? extends Recordable<? extends Color>, ? extends List<? extends Paper<? extends Color>>>> {

	protected final Book<? extends Color, ? extends Paper<? extends Color>, ? extends Recordable<? extends Color>, ? extends List<? extends Paper<? extends Color>>> $$$wrapped;

	protected final P $$$parentBuilder;
	
	public BookBuilderSpec() {
		this.$$$wrapped = null;
		this.$$$parentBuilder = null;
	}
	
	public BookBuilderSpec(P parentBuilder) {
		this.$$$wrapped = null;
		this.$$$parentBuilder = parentBuilder;
	}

	protected BookBuilderSpec(Book<? extends Color, ? extends Paper<? extends Color>, ? extends Recordable<? extends Color>, ? extends List<? extends Paper<? extends Color>>> wrapped) {
		this.$$$wrapped = wrapped;
		this.$$$parentBuilder = null;
	}
	
    public BookBuilderSpec<P> storeTo(BuilderRepository repo, Object builderId) {
    	repo.put(builderId, this);
    	return this;
    }

	public Book<? extends Color, ? extends Paper<? extends Color>, ? extends Recordable<? extends Color>, ? extends List<? extends Paper<? extends Color>>> getWrappedObject() {
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

    public Book<? extends Color, ? extends Paper<? extends Color>, ? extends Recordable<? extends Color>, ? extends List<? extends Paper<? extends Color>>> toBook() {
    	return new Converter(new BuilderAnnotationDestinationClassResolver(), true).convert(this).to(Book.class);
    }

    public <C extends Color & Serializable, T extends Paper<C>, R extends Recordable<C>, L extends List<? extends T>> Book<C, T, R, L> toBook(Class<C> C, Class<T> T, Class<R> R, Class<L> L) {
    	return new Converter(new BuilderAnnotationDestinationClassResolver(), true).convert(this).to(Book.class);
    }


	private int sequence;
	
	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		verifyMutable();
		this.sequence = sequence;
	}

	public BookBuilderSpec<P> sequence(int sequence) {
		verifyMutable();
		this.sequence = sequence;
		return this;
	}

	private PaperBuilderSpec<?> myPaper;
	
	public PaperBuilderSpec<?> getMyPaper() {
		return myPaper;
	}

	public void setMyPaper(PaperBuilderSpec<?> myPaper) {
		verifyMutable();
		this.myPaper = myPaper;
	}

	public BookBuilderSpec<P> myPaper(PaperBuilderSpec<?> myPaper) {
		verifyMutable();
		this.myPaper = myPaper;
		return this;
	}

    public BookBuilderSpec<P> myPaper$wrap(Paper myPaper) {
    	verifyMutable();
    	this.myPaper = new WrapConverter(BuilderSpecs.DESTINATION_CLASS_RESOLVER).convert(myPaper).to(PaperBuilderSpec.class);
        return this;
    }
    
    public BookBuilderSpec<P> myPaper$restoreFrom(BuilderRepository repo, Object builderId) {
    	verifyMutable();
    	
        Object restoredObject = repo.get(builderId);
        if (restoredObject == null) {
        	if (repo.isSupportLazy()) {
        		repo.addObjectStoredListener(builderId, new Procedure() {
					public void execute(Object... arguments) {
						BookBuilderSpec.this.myPaper = (PaperBuilderSpec<?>)arguments[0];
					}
				});
        	}
        	else {
                throw new IllegalStateException("Object does not exist with id " + builderId);
        	}
        }
        else if (!(restoredObject instanceof PaperBuilderSpec)) {
        	throw new IllegalStateException("Type mismatch for id: " + builderId + ". " + PaperBuilderSpec.class.getSimpleName() + " vs " + restoredObject.getClass().getSimpleName());
        }
        else {
            this.myPaper = (PaperBuilderSpec<?>)restoredObject;
        }
        return this;
    }

	public PaperBuilderSpec<? extends BookBuilderSpec<P>> myPaper$begin() {
		verifyMutable();
		PaperBuilderSpec<BookBuilderSpec<P>> result = new PaperBuilderSpec<BookBuilderSpec<P>>(this);
		this.myPaper = result;
		return result;
	}

	public CopyPaperBuilderSpec<? extends BookBuilderSpec<P>> myPaper$asCopyPaper$begin() {
		verifyMutable();
		CopyPaperBuilderSpec<BookBuilderSpec<P>> result = new CopyPaperBuilderSpec<BookBuilderSpec<P>>(this);
		this.myPaper = result;
		return result;
	}

	private RecordableBuilderSpec myRecordable;
	
	public RecordableBuilderSpec getMyRecordable() {
		return myRecordable;
	}

	public void setMyRecordable(RecordableBuilderSpec myRecordable) {
		verifyMutable();
		this.myRecordable = myRecordable;
	}

	public BookBuilderSpec<P> myRecordable(RecordableBuilderSpec myRecordable) {
		verifyMutable();
		this.myRecordable = myRecordable;
		return this;
	}

    public BookBuilderSpec<P> myRecordable$wrap(Recordable myRecordable) {
    	verifyMutable();
    	this.myRecordable = new WrapConverter(BuilderSpecs.DESTINATION_CLASS_RESOLVER).convert(myRecordable).to(RecordableBuilderSpec.class);
        return this;
    }
    
    public BookBuilderSpec<P> myRecordable$restoreFrom(BuilderRepository repo, Object builderId) {
    	verifyMutable();
    	
        Object restoredObject = repo.get(builderId);
        if (restoredObject == null) {
        	if (repo.isSupportLazy()) {
        		repo.addObjectStoredListener(builderId, new Procedure() {
					public void execute(Object... arguments) {
						BookBuilderSpec.this.myRecordable = (RecordableBuilderSpec)arguments[0];
					}
				});
        	}
        	else {
                throw new IllegalStateException("Object does not exist with id " + builderId);
        	}
        }
        else if (!(restoredObject instanceof RecordableBuilderSpec)) {
        	throw new IllegalStateException("Type mismatch for id: " + builderId + ". " + RecordableBuilderSpec.class.getSimpleName() + " vs " + restoredObject.getClass().getSimpleName());
        }
        else {
            this.myRecordable = (RecordableBuilderSpec)restoredObject;
        }
        return this;
    }

	public PaperBuilderSpec<? extends BookBuilderSpec<P>> myRecordable$asPaper$begin() {
		verifyMutable();
		PaperBuilderSpec<BookBuilderSpec<P>> result = new PaperBuilderSpec<BookBuilderSpec<P>>(this);
		this.myRecordable = result;
		return result;
	}

	public CopyPaperBuilderSpec<? extends BookBuilderSpec<P>> myRecordable$asCopyPaper$begin() {
		verifyMutable();
		CopyPaperBuilderSpec<BookBuilderSpec<P>> result = new CopyPaperBuilderSpec<BookBuilderSpec<P>>(this);
		this.myRecordable = result;
		return result;
	}

	private List<String> keywords;
	
	public List<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<String> keywords) {
		verifyMutable();
		this.keywords = keywords;
	}

	public BookBuilderSpec<P> keywords(String ... keywords) {
		verifyMutable();
		return keywords(new ListBuilder<String>().add(keywords).toList());
	}
	
	public BookBuilderSpec<P> keywords(Collection<String> keywords) {
		verifyMutable();
		if (this.keywords == null) {
			this.keywords = new ArrayList<String>();
		}
		if (keywords != null) {
			for (String e : keywords) {
				CollectionUtils.addItem(this.keywords, e);
			}
		}
		return this;
	}



	private List<? extends PaperBuilderSpec<?>> myPapers;
	
	public List<? extends PaperBuilderSpec<?>> getMyPapers() {
		return myPapers;
	}

	public void setMyPapers(List<? extends PaperBuilderSpec<?>> myPapers) {
		verifyMutable();
		this.myPapers = myPapers;
	}

	public BookBuilderSpec<P> myPapers(PaperBuilderSpec<?> ... myPapers) {
		verifyMutable();
		return myPapers(new ListBuilder<PaperBuilderSpec<?>>().add(myPapers).toList());
	}
	
	public BookBuilderSpec<P> myPapers(Collection<PaperBuilderSpec<?>> myPapers) {
		verifyMutable();
		if (this.myPapers == null) {
			this.myPapers = new ArrayList<PaperBuilderSpec<?>>();
		}
		if (myPapers != null) {
			for (PaperBuilderSpec<?> e : myPapers) {
				CollectionUtils.addItem(this.myPapers, e);
			}
		}
		return this;
	}

	public PaperBuilderSpec<? extends BookBuilderSpec<P>> myPapers$addPaper() {
		verifyMutable();
		if (this.myPapers == null) {
			this.myPapers = new ArrayList<PaperBuilderSpec<?>>();
		}
		
		PaperBuilderSpec<BookBuilderSpec<P>> result =
				new PaperBuilderSpec<BookBuilderSpec<P>>(this);
		
		CollectionUtils.addItem(this.myPapers, result);
		
		return result;
	}
	
	public CopyPaperBuilderSpec<? extends BookBuilderSpec<P>> myPapers$addCopyPaper() {
		verifyMutable();
		if (this.myPapers == null) {
			this.myPapers = new ArrayList<PaperBuilderSpec<?>>();
		}
		
		CopyPaperBuilderSpec<BookBuilderSpec<P>> result =
				new CopyPaperBuilderSpec<BookBuilderSpec<P>>(this);
		
		CollectionUtils.addItem(this.myPapers, result);
		
		return result;
	}
	

	public class MyPapers$$$builder<P1 extends BookBuilderSpec<P>> {
	
		private final P1 $$$parentBuilder1;
	
		protected MyPapers$$$builder(P1 parentBuilder) {
			this.$$$parentBuilder1 = parentBuilder;
		}

		public PaperBuilderSpec<MyPapers$$$builder<P1>> paper$begin() {
			PaperBuilderSpec<MyPapers$$$builder<P1>> result = new PaperBuilderSpec<MyPapers$$$builder<P1>>(this);
			CollectionUtils.addItem(BookBuilderSpec.this.myPapers, result);
			return result;
		}
		
		public CopyPaperBuilderSpec<MyPapers$$$builder<P1>> copyPaper$begin() {
			CopyPaperBuilderSpec<MyPapers$$$builder<P1>> result = new CopyPaperBuilderSpec<MyPapers$$$builder<P1>>(this);
			CollectionUtils.addItem(BookBuilderSpec.this.myPapers, result);
			return result;
		}
		

		public P1 end() {
			return this.$$$parentBuilder1;
		}
	}
	
	public MyPapers$$$builder<? extends BookBuilderSpec<P>> myPapers$list() {
		verifyMutable();
		if (this.myPapers == null) {
			this.myPapers = new ArrayList<PaperBuilderSpec<?>>();
		}
		return new MyPapers$$$builder<BookBuilderSpec<P>>(this);
	}

    public BookBuilderSpec<P> myPapers$wrap(Paper ... myPapers) {
    	return myPapers$wrap(new ListBuilder<Paper>().add(myPapers).toList());
    }

    public BookBuilderSpec<P> myPapers$wrap(Collection<? extends Paper> myPapers) {
		verifyMutable();

		if (this.myPapers == null) {
			this.myPapers = new ArrayList<PaperBuilderSpec<?>>();
		}
		if (myPapers != null) {
			for (Paper e : myPapers) {
				PaperBuilderSpec<?> wrapped = new WrapConverter(BuilderSpecs.DESTINATION_CLASS_RESOLVER).convert(e).to(PaperBuilderSpec.class);
				CollectionUtils.addItem(this.myPapers, wrapped);
			}
		}
		return this;
    }
    
    public BookBuilderSpec<P> myPapers$restoreFrom(BuilderRepository repo, Object ... builderIds) {
    	return myPapers$restoreFrom(repo, new ListBuilder<Object>().add(builderIds).toList());
    }

    public BookBuilderSpec<P> myPapers$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		verifyMutable();

		if (this.myPapers == null) {
			this.myPapers = new ArrayList<PaperBuilderSpec<?>>();
		}
		if (builderIds != null) {
	    	for (Object builderId : builderIds) {
	            Object restoredObject = repo.get(builderId);
	            if (restoredObject == null) {
	            	if (repo.isSupportLazy()) {
	            		repo.addObjectStoredListener(builderId, new Procedure() {
	    					public void execute(Object... arguments) {
	    						CollectionUtils.addItem(BookBuilderSpec.this.myPapers, arguments[0]);
	    					}
	    				});
	            	}
	            	else {
	                    throw new IllegalStateException("Object does not exist with id " + builderId);
	            	}
	            }
	            else if (!(restoredObject instanceof PaperBuilderSpec)) {
	            	throw new IllegalStateException("Type mismatch for id: " + builderId + ". " + PaperBuilderSpec.class.getSimpleName() + " vs " + restoredObject.getClass().getSimpleName());
	            }
	            else {
	                CollectionUtils.addItem(this.myPapers, restoredObject);
	            }
	    	}
		}
        return this;
    }


	private Set<? extends RecordableBuilderSpec> myRecordables;
	
	public Set<? extends RecordableBuilderSpec> getMyRecordables() {
		return myRecordables;
	}

	public void setMyRecordables(Set<? extends RecordableBuilderSpec> myRecordables) {
		verifyMutable();
		this.myRecordables = myRecordables;
	}

	public BookBuilderSpec<P> myRecordables(RecordableBuilderSpec ... myRecordables) {
		verifyMutable();
		return myRecordables(new ListBuilder<RecordableBuilderSpec>().add(myRecordables).toList());
	}
	
	public BookBuilderSpec<P> myRecordables(Collection<RecordableBuilderSpec> myRecordables) {
		verifyMutable();
		if (this.myRecordables == null) {
			this.myRecordables = new HashSet<RecordableBuilderSpec>();
		}
		if (myRecordables != null) {
			for (RecordableBuilderSpec e : myRecordables) {
				CollectionUtils.addItem(this.myRecordables, e);
			}
		}
		return this;
	}

	public PaperBuilderSpec<? extends BookBuilderSpec<P>> myRecordables$addPaper() {
		verifyMutable();
		if (this.myRecordables == null) {
			this.myRecordables = new HashSet<RecordableBuilderSpec>();
		}
		
		PaperBuilderSpec<BookBuilderSpec<P>> result =
				new PaperBuilderSpec<BookBuilderSpec<P>>(this);
		
		CollectionUtils.addItem(this.myRecordables, result);
		
		return result;
	}
	
	public CopyPaperBuilderSpec<? extends BookBuilderSpec<P>> myRecordables$addCopyPaper() {
		verifyMutable();
		if (this.myRecordables == null) {
			this.myRecordables = new HashSet<RecordableBuilderSpec>();
		}
		
		CopyPaperBuilderSpec<BookBuilderSpec<P>> result =
				new CopyPaperBuilderSpec<BookBuilderSpec<P>>(this);
		
		CollectionUtils.addItem(this.myRecordables, result);
		
		return result;
	}
	

	public class MyRecordables$$$builder<P1 extends BookBuilderSpec<P>> {
	
		private final P1 $$$parentBuilder1;
	
		protected MyRecordables$$$builder(P1 parentBuilder) {
			this.$$$parentBuilder1 = parentBuilder;
		}

		public PaperBuilderSpec<MyRecordables$$$builder<P1>> paper$begin() {
			PaperBuilderSpec<MyRecordables$$$builder<P1>> result = new PaperBuilderSpec<MyRecordables$$$builder<P1>>(this);
			CollectionUtils.addItem(BookBuilderSpec.this.myRecordables, result);
			return result;
		}
		
		public CopyPaperBuilderSpec<MyRecordables$$$builder<P1>> copyPaper$begin() {
			CopyPaperBuilderSpec<MyRecordables$$$builder<P1>> result = new CopyPaperBuilderSpec<MyRecordables$$$builder<P1>>(this);
			CollectionUtils.addItem(BookBuilderSpec.this.myRecordables, result);
			return result;
		}
		

		public P1 end() {
			return this.$$$parentBuilder1;
		}
	}
	
	public MyRecordables$$$builder<? extends BookBuilderSpec<P>> myRecordables$list() {
		verifyMutable();
		if (this.myRecordables == null) {
			this.myRecordables = new HashSet<RecordableBuilderSpec>();
		}
		return new MyRecordables$$$builder<BookBuilderSpec<P>>(this);
	}

    public BookBuilderSpec<P> myRecordables$wrap(Recordable ... myRecordables) {
    	return myRecordables$wrap(new ListBuilder<Recordable>().add(myRecordables).toList());
    }

    public BookBuilderSpec<P> myRecordables$wrap(Collection<? extends Recordable> myRecordables) {
		verifyMutable();

		if (this.myRecordables == null) {
			this.myRecordables = new HashSet<RecordableBuilderSpec>();
		}
		if (myRecordables != null) {
			for (Recordable e : myRecordables) {
				RecordableBuilderSpec wrapped = new WrapConverter(BuilderSpecs.DESTINATION_CLASS_RESOLVER).convert(e).to(RecordableBuilderSpec.class);
				CollectionUtils.addItem(this.myRecordables, wrapped);
			}
		}
		return this;
    }
    
    public BookBuilderSpec<P> myRecordables$restoreFrom(BuilderRepository repo, Object ... builderIds) {
    	return myRecordables$restoreFrom(repo, new ListBuilder<Object>().add(builderIds).toList());
    }

    public BookBuilderSpec<P> myRecordables$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		verifyMutable();

		if (this.myRecordables == null) {
			this.myRecordables = new HashSet<RecordableBuilderSpec>();
		}
		if (builderIds != null) {
	    	for (Object builderId : builderIds) {
	            Object restoredObject = repo.get(builderId);
	            if (restoredObject == null) {
	            	if (repo.isSupportLazy()) {
	            		repo.addObjectStoredListener(builderId, new Procedure() {
	    					public void execute(Object... arguments) {
	    						CollectionUtils.addItem(BookBuilderSpec.this.myRecordables, arguments[0]);
	    					}
	    				});
	            	}
	            	else {
	                    throw new IllegalStateException("Object does not exist with id " + builderId);
	            	}
	            }
	            else if (!(restoredObject instanceof RecordableBuilderSpec)) {
	            	throw new IllegalStateException("Type mismatch for id: " + builderId + ". " + RecordableBuilderSpec.class.getSimpleName() + " vs " + restoredObject.getClass().getSimpleName());
	            }
	            else {
	                CollectionUtils.addItem(this.myRecordables, restoredObject);
	            }
	    	}
		}
        return this;
    }


	private Map<? extends PaperBuilderSpec<?>, ? extends ColorBuilderSpec<?>> paperColors;
	
	public Map<? extends PaperBuilderSpec<?>, ? extends ColorBuilderSpec<?>> getPaperColors() {
		return paperColors;
	}

	public void setPaperColors(Map<? extends PaperBuilderSpec<?>, ? extends ColorBuilderSpec<?>> paperColors) {
		verifyMutable();
		this.paperColors = paperColors;
	}

	public BookBuilderSpec<P> paperColors(Map<PaperBuilderSpec<?>, ColorBuilderSpec<?>> paperColors) {
		verifyMutable();

		if (this.paperColors == null) {
			this.paperColors = new HashMap<PaperBuilderSpec<?>, ColorBuilderSpec<?>>();
		}
		if (paperColors != null) {
			for (Map.Entry<PaperBuilderSpec<?>, ColorBuilderSpec<?>> e : paperColors.entrySet()) {
				CollectionUtils.putItem(this.paperColors, e.getKey(), e.getValue());
			}
		}
		return this;
	}

	public class PaperColors$builder<P1 extends BookBuilderSpec<P>> {
		
		private final P1 $$$parentBuilder;
		
		public class Value$builder {

			private PaperBuilderSpec<?> key;

			private Value$builder(PaperBuilderSpec<?> key) {
				this.key = key;
			}

			public PaperColors$builder<P1> value(ColorBuilderSpec<?> value) {
				CollectionUtils.putItem(BookBuilderSpec.this.paperColors, key, value);
				return PaperColors$builder.this;
			}

			public ColorBuilderSpec<PaperColors$builder<P1>> value$asColor() {
				ColorBuilderSpec<PaperColors$builder<P1>> result = new ColorBuilderSpec<PaperColors$builder<P1>>(PaperColors$builder.this);
				CollectionUtils.putItem(BookBuilderSpec.this.paperColors, key, result);
				return result;
			}
			
			public RGBColorBuilderSpec<PaperColors$builder<P1>> value$asRGBColor() {
				RGBColorBuilderSpec<PaperColors$builder<P1>> result = new RGBColorBuilderSpec<PaperColors$builder<P1>>(PaperColors$builder.this);
				CollectionUtils.putItem(BookBuilderSpec.this.paperColors, key, result);
				return result;
			}
			

		}
		
		private PaperColors$builder(P1 parentBuilder) {
			this.$$$parentBuilder = parentBuilder;
		}
		
		public Value$builder key(PaperBuilderSpec<?> key) {
			return new Value$builder(key);
		}
		
		public PaperBuilderSpec<Value$builder> key$asPaper() {
			PaperBuilderSpec<Value$builder> result = new PaperBuilderSpec<Value$builder>(new Value$builder(null));
			result.$$$parentBuilder.key = result;
			return result;
		}
		
		public CopyPaperBuilderSpec<Value$builder> key$asCopyPaper() {
			CopyPaperBuilderSpec<Value$builder> result = new CopyPaperBuilderSpec<Value$builder>(new Value$builder(null));
			result.$$$parentBuilder.key = result;
			return result;
		}
		

		public P1 end() {
			return this.$$$parentBuilder;
		}
	}
	
	public PaperColors$builder<? extends BookBuilderSpec<P>> paperColors$map() {
		verifyMutable();

		if (this.paperColors == null) {
			this.paperColors = new HashMap<PaperBuilderSpec<?>, ColorBuilderSpec<?>>();
		}
		return new PaperColors$builder<BookBuilderSpec<P>>(this);
	}	
}

package org.nebulae2us.electron.test.builder3.model;

import java.io.*;
import java.util.*;
import org.nebulae2us.electron.*;
import org.nebulae2us.electron.util.*;

@Builder(destination=Book.class)
public class BookBuilder<P> implements Wrappable<Book<? extends Color, ? extends Paper<? extends Color>, ? extends Recordable<? extends Color>, ? extends List<? extends Paper<? extends Color>>>> {

	protected final Book<? extends Color, ? extends Paper<? extends Color>, ? extends Recordable<? extends Color>, ? extends List<? extends Paper<? extends Color>>> $$$wrapped;

	protected final P $$$parentBuilder;
	
	public BookBuilder() {
		this.$$$wrapped = null;
		this.$$$parentBuilder = null;
	}
	
	public BookBuilder(P parentBuilder) {
		this.$$$wrapped = null;
		this.$$$parentBuilder = parentBuilder;
	}

	protected BookBuilder(Book<? extends Color, ? extends Paper<? extends Color>, ? extends Recordable<? extends Color>, ? extends List<? extends Paper<? extends Color>>> wrapped) {
		this.$$$wrapped = wrapped;
		this.$$$parentBuilder = null;
	}
	
    public BookBuilder<P> storeTo(BuilderRepository repo, Object builderId) {
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

	public BookBuilder<P> sequence(int sequence) {
		verifyMutable();
		this.sequence = sequence;
		return this;
	}

	private PaperBuilder<?> myPaper;
	
	public PaperBuilder<?> getMyPaper() {
		return myPaper;
	}

	public void setMyPaper(PaperBuilder<?> myPaper) {
		verifyMutable();
		this.myPaper = myPaper;
	}

	public BookBuilder<P> myPaper(PaperBuilder<?> myPaper) {
		verifyMutable();
		this.myPaper = myPaper;
		return this;
	}

    public BookBuilder<P> myPaper$wrap(Paper myPaper) {
    	verifyMutable();
    	this.myPaper = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER).convert(myPaper).to(PaperBuilder.class);
        return this;
    }
    
    public BookBuilder<P> myPaper$restoreFrom(BuilderRepository repo, Object builderId) {
    	verifyMutable();
    	
        Object restoredObject = repo.get(builderId);
        if (restoredObject == null) {
        	if (repo.isSupportLazy()) {
        		repo.addObjectStoredListener(builderId, new Procedure() {
					public void execute(Object... arguments) {
						BookBuilder.this.myPaper = (PaperBuilder<?>)arguments[0];
					}
				});
        	}
        	else {
                throw new IllegalStateException("Object does not exist with id " + builderId);
        	}
        }
        else if (!(restoredObject instanceof PaperBuilder)) {
        	throw new IllegalStateException("Type mismatch for id: " + builderId + ". " + PaperBuilder.class.getSimpleName() + " vs " + restoredObject.getClass().getSimpleName());
        }
        else {
            this.myPaper = (PaperBuilder<?>)restoredObject;
        }
        return this;
    }

	public PaperBuilder<? extends BookBuilder<P>> myPaper$begin() {
		verifyMutable();
		PaperBuilder<BookBuilder<P>> result = new PaperBuilder<BookBuilder<P>>(this);
		this.myPaper = result;
		return result;
	}

	public CopyPaperBuilder<? extends BookBuilder<P>> myPaper$asCopyPaper$begin() {
		verifyMutable();
		CopyPaperBuilder<BookBuilder<P>> result = new CopyPaperBuilder<BookBuilder<P>>(this);
		this.myPaper = result;
		return result;
	}

	private RecordableBuilder myRecordable;
	
	public RecordableBuilder getMyRecordable() {
		return myRecordable;
	}

	public void setMyRecordable(RecordableBuilder myRecordable) {
		verifyMutable();
		this.myRecordable = myRecordable;
	}

	public BookBuilder<P> myRecordable(RecordableBuilder myRecordable) {
		verifyMutable();
		this.myRecordable = myRecordable;
		return this;
	}

    public BookBuilder<P> myRecordable$wrap(Recordable myRecordable) {
    	verifyMutable();
    	this.myRecordable = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER).convert(myRecordable).to(RecordableBuilder.class);
        return this;
    }
    
    public BookBuilder<P> myRecordable$restoreFrom(BuilderRepository repo, Object builderId) {
    	verifyMutable();
    	
        Object restoredObject = repo.get(builderId);
        if (restoredObject == null) {
        	if (repo.isSupportLazy()) {
        		repo.addObjectStoredListener(builderId, new Procedure() {
					public void execute(Object... arguments) {
						BookBuilder.this.myRecordable = (RecordableBuilder)arguments[0];
					}
				});
        	}
        	else {
                throw new IllegalStateException("Object does not exist with id " + builderId);
        	}
        }
        else if (!(restoredObject instanceof RecordableBuilder)) {
        	throw new IllegalStateException("Type mismatch for id: " + builderId + ". " + RecordableBuilder.class.getSimpleName() + " vs " + restoredObject.getClass().getSimpleName());
        }
        else {
            this.myRecordable = (RecordableBuilder)restoredObject;
        }
        return this;
    }

	public PaperBuilder<? extends BookBuilder<P>> myRecordable$asPaper$begin() {
		verifyMutable();
		PaperBuilder<BookBuilder<P>> result = new PaperBuilder<BookBuilder<P>>(this);
		this.myRecordable = result;
		return result;
	}

	public CopyPaperBuilder<? extends BookBuilder<P>> myRecordable$asCopyPaper$begin() {
		verifyMutable();
		CopyPaperBuilder<BookBuilder<P>> result = new CopyPaperBuilder<BookBuilder<P>>(this);
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

	public BookBuilder<P> keywords(String ... keywords) {
		verifyMutable();
		return keywords(new ListBuilder<String>().add(keywords).toList());
	}
	
	public BookBuilder<P> keywords(Collection<String> keywords) {
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



	private List<? extends PaperBuilder<?>> myPapers;
	
	public List<? extends PaperBuilder<?>> getMyPapers() {
		return myPapers;
	}

	public void setMyPapers(List<? extends PaperBuilder<?>> myPapers) {
		verifyMutable();
		this.myPapers = myPapers;
	}

	public BookBuilder<P> myPapers(PaperBuilder<?> ... myPapers) {
		verifyMutable();
		return myPapers(new ListBuilder<PaperBuilder<?>>().add(myPapers).toList());
	}
	
	public BookBuilder<P> myPapers(Collection<PaperBuilder<?>> myPapers) {
		verifyMutable();
		if (this.myPapers == null) {
			this.myPapers = new ArrayList<PaperBuilder<?>>();
		}
		if (myPapers != null) {
			for (PaperBuilder<?> e : myPapers) {
				CollectionUtils.addItem(this.myPapers, e);
			}
		}
		return this;
	}

	public PaperBuilder<? extends BookBuilder<P>> myPapers$addPaper() {
		verifyMutable();
		if (this.myPapers == null) {
			this.myPapers = new ArrayList<PaperBuilder<?>>();
		}
		
		PaperBuilder<BookBuilder<P>> result =
				new PaperBuilder<BookBuilder<P>>(this);
		
		CollectionUtils.addItem(this.myPapers, result);
		
		return result;
	}
	
	public CopyPaperBuilder<? extends BookBuilder<P>> myPapers$addCopyPaper() {
		verifyMutable();
		if (this.myPapers == null) {
			this.myPapers = new ArrayList<PaperBuilder<?>>();
		}
		
		CopyPaperBuilder<BookBuilder<P>> result =
				new CopyPaperBuilder<BookBuilder<P>>(this);
		
		CollectionUtils.addItem(this.myPapers, result);
		
		return result;
	}
	

	public class MyPapers$$$builder<P1 extends BookBuilder<P>> {
	
		private final P1 $$$parentBuilder1;
	
		protected MyPapers$$$builder(P1 parentBuilder) {
			this.$$$parentBuilder1 = parentBuilder;
		}

		public PaperBuilder<MyPapers$$$builder<P1>> paper$begin() {
			PaperBuilder<MyPapers$$$builder<P1>> result = new PaperBuilder<MyPapers$$$builder<P1>>(this);
			CollectionUtils.addItem(BookBuilder.this.myPapers, result);
			return result;
		}
		
		public CopyPaperBuilder<MyPapers$$$builder<P1>> copyPaper$begin() {
			CopyPaperBuilder<MyPapers$$$builder<P1>> result = new CopyPaperBuilder<MyPapers$$$builder<P1>>(this);
			CollectionUtils.addItem(BookBuilder.this.myPapers, result);
			return result;
		}
		

		public P1 end() {
			return this.$$$parentBuilder1;
		}
	}
	
	public MyPapers$$$builder<? extends BookBuilder<P>> myPapers$list() {
		verifyMutable();
		if (this.myPapers == null) {
			this.myPapers = new ArrayList<PaperBuilder<?>>();
		}
		return new MyPapers$$$builder<BookBuilder<P>>(this);
	}

    public BookBuilder<P> myPapers$wrap(Paper ... myPapers) {
    	return myPapers$wrap(new ListBuilder<Paper>().add(myPapers).toList());
    }

    public BookBuilder<P> myPapers$wrap(Collection<? extends Paper> myPapers) {
		verifyMutable();

		if (this.myPapers == null) {
			this.myPapers = new ArrayList<PaperBuilder<?>>();
		}
		if (myPapers != null) {
			for (Paper e : myPapers) {
				PaperBuilder<?> wrapped = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER).convert(e).to(PaperBuilder.class);
				CollectionUtils.addItem(this.myPapers, wrapped);
			}
		}
		return this;
    }
    
    public BookBuilder<P> myPapers$restoreFrom(BuilderRepository repo, Object ... builderIds) {
    	return myPapers$restoreFrom(repo, new ListBuilder<Object>().add(builderIds).toList());
    }

    public BookBuilder<P> myPapers$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		verifyMutable();

		if (this.myPapers == null) {
			this.myPapers = new ArrayList<PaperBuilder<?>>();
		}
		if (builderIds != null) {
	    	for (Object builderId : builderIds) {
	            Object restoredObject = repo.get(builderId);
	            if (restoredObject == null) {
	            	if (repo.isSupportLazy()) {
	            		repo.addObjectStoredListener(builderId, new Procedure() {
	    					public void execute(Object... arguments) {
	    						CollectionUtils.addItem(BookBuilder.this.myPapers, arguments[0]);
	    					}
	    				});
	            	}
	            	else {
	                    throw new IllegalStateException("Object does not exist with id " + builderId);
	            	}
	            }
	            else if (!(restoredObject instanceof PaperBuilder)) {
	            	throw new IllegalStateException("Type mismatch for id: " + builderId + ". " + PaperBuilder.class.getSimpleName() + " vs " + restoredObject.getClass().getSimpleName());
	            }
	            else {
	                CollectionUtils.addItem(this.myPapers, restoredObject);
	            }
	    	}
		}
        return this;
    }


	private Set<? extends RecordableBuilder> myRecordables;
	
	public Set<? extends RecordableBuilder> getMyRecordables() {
		return myRecordables;
	}

	public void setMyRecordables(Set<? extends RecordableBuilder> myRecordables) {
		verifyMutable();
		this.myRecordables = myRecordables;
	}

	public BookBuilder<P> myRecordables(RecordableBuilder ... myRecordables) {
		verifyMutable();
		return myRecordables(new ListBuilder<RecordableBuilder>().add(myRecordables).toList());
	}
	
	public BookBuilder<P> myRecordables(Collection<RecordableBuilder> myRecordables) {
		verifyMutable();
		if (this.myRecordables == null) {
			this.myRecordables = new HashSet<RecordableBuilder>();
		}
		if (myRecordables != null) {
			for (RecordableBuilder e : myRecordables) {
				CollectionUtils.addItem(this.myRecordables, e);
			}
		}
		return this;
	}

	public PaperBuilder<? extends BookBuilder<P>> myRecordables$addPaper() {
		verifyMutable();
		if (this.myRecordables == null) {
			this.myRecordables = new HashSet<RecordableBuilder>();
		}
		
		PaperBuilder<BookBuilder<P>> result =
				new PaperBuilder<BookBuilder<P>>(this);
		
		CollectionUtils.addItem(this.myRecordables, result);
		
		return result;
	}
	
	public CopyPaperBuilder<? extends BookBuilder<P>> myRecordables$addCopyPaper() {
		verifyMutable();
		if (this.myRecordables == null) {
			this.myRecordables = new HashSet<RecordableBuilder>();
		}
		
		CopyPaperBuilder<BookBuilder<P>> result =
				new CopyPaperBuilder<BookBuilder<P>>(this);
		
		CollectionUtils.addItem(this.myRecordables, result);
		
		return result;
	}
	

	public class MyRecordables$$$builder<P1 extends BookBuilder<P>> {
	
		private final P1 $$$parentBuilder1;
	
		protected MyRecordables$$$builder(P1 parentBuilder) {
			this.$$$parentBuilder1 = parentBuilder;
		}

		public PaperBuilder<MyRecordables$$$builder<P1>> paper$begin() {
			PaperBuilder<MyRecordables$$$builder<P1>> result = new PaperBuilder<MyRecordables$$$builder<P1>>(this);
			CollectionUtils.addItem(BookBuilder.this.myRecordables, result);
			return result;
		}
		
		public CopyPaperBuilder<MyRecordables$$$builder<P1>> copyPaper$begin() {
			CopyPaperBuilder<MyRecordables$$$builder<P1>> result = new CopyPaperBuilder<MyRecordables$$$builder<P1>>(this);
			CollectionUtils.addItem(BookBuilder.this.myRecordables, result);
			return result;
		}
		

		public P1 end() {
			return this.$$$parentBuilder1;
		}
	}
	
	public MyRecordables$$$builder<? extends BookBuilder<P>> myRecordables$list() {
		verifyMutable();
		if (this.myRecordables == null) {
			this.myRecordables = new HashSet<RecordableBuilder>();
		}
		return new MyRecordables$$$builder<BookBuilder<P>>(this);
	}

    public BookBuilder<P> myRecordables$wrap(Recordable ... myRecordables) {
    	return myRecordables$wrap(new ListBuilder<Recordable>().add(myRecordables).toList());
    }

    public BookBuilder<P> myRecordables$wrap(Collection<? extends Recordable> myRecordables) {
		verifyMutable();

		if (this.myRecordables == null) {
			this.myRecordables = new HashSet<RecordableBuilder>();
		}
		if (myRecordables != null) {
			for (Recordable e : myRecordables) {
				RecordableBuilder wrapped = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER).convert(e).to(RecordableBuilder.class);
				CollectionUtils.addItem(this.myRecordables, wrapped);
			}
		}
		return this;
    }
    
    public BookBuilder<P> myRecordables$restoreFrom(BuilderRepository repo, Object ... builderIds) {
    	return myRecordables$restoreFrom(repo, new ListBuilder<Object>().add(builderIds).toList());
    }

    public BookBuilder<P> myRecordables$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		verifyMutable();

		if (this.myRecordables == null) {
			this.myRecordables = new HashSet<RecordableBuilder>();
		}
		if (builderIds != null) {
	    	for (Object builderId : builderIds) {
	            Object restoredObject = repo.get(builderId);
	            if (restoredObject == null) {
	            	if (repo.isSupportLazy()) {
	            		repo.addObjectStoredListener(builderId, new Procedure() {
	    					public void execute(Object... arguments) {
	    						CollectionUtils.addItem(BookBuilder.this.myRecordables, arguments[0]);
	    					}
	    				});
	            	}
	            	else {
	                    throw new IllegalStateException("Object does not exist with id " + builderId);
	            	}
	            }
	            else if (!(restoredObject instanceof RecordableBuilder)) {
	            	throw new IllegalStateException("Type mismatch for id: " + builderId + ". " + RecordableBuilder.class.getSimpleName() + " vs " + restoredObject.getClass().getSimpleName());
	            }
	            else {
	                CollectionUtils.addItem(this.myRecordables, restoredObject);
	            }
	    	}
		}
        return this;
    }


	private Map<? extends PaperBuilder<?>, ? extends ColorBuilder<?>> paperColors;
	
	public Map<? extends PaperBuilder<?>, ? extends ColorBuilder<?>> getPaperColors() {
		return paperColors;
	}

	public void setPaperColors(Map<? extends PaperBuilder<?>, ? extends ColorBuilder<?>> paperColors) {
		verifyMutable();
		this.paperColors = paperColors;
	}

	public BookBuilder<P> paperColors(Map<PaperBuilder<?>, ColorBuilder<?>> paperColors) {
		verifyMutable();

		if (this.paperColors == null) {
			this.paperColors = new HashMap<PaperBuilder<?>, ColorBuilder<?>>();
		}
		if (paperColors != null) {
			for (Map.Entry<PaperBuilder<?>, ColorBuilder<?>> e : paperColors.entrySet()) {
				CollectionUtils.putItem(this.paperColors, e.getKey(), e.getValue());
			}
		}
		return this;
	}

	public class PaperColors$builder<P1 extends BookBuilder<P>> {
		
		private final P1 $$$parentBuilder;
		
		public class Value$builder {

			private PaperBuilder<?> key;

			private Value$builder(PaperBuilder<?> key) {
				this.key = key;
			}

			public PaperColors$builder<P1> value(ColorBuilder<?> value) {
				CollectionUtils.putItem(BookBuilder.this.paperColors, key, value);
				return PaperColors$builder.this;
			}

			public ColorBuilder<PaperColors$builder<P1>> value$asColor() {
				ColorBuilder<PaperColors$builder<P1>> result = new ColorBuilder<PaperColors$builder<P1>>(PaperColors$builder.this);
				CollectionUtils.putItem(BookBuilder.this.paperColors, key, result);
				return result;
			}
			
			public RGBColorBuilder<PaperColors$builder<P1>> value$asRGBColor() {
				RGBColorBuilder<PaperColors$builder<P1>> result = new RGBColorBuilder<PaperColors$builder<P1>>(PaperColors$builder.this);
				CollectionUtils.putItem(BookBuilder.this.paperColors, key, result);
				return result;
			}
			

		}
		
		private PaperColors$builder(P1 parentBuilder) {
			this.$$$parentBuilder = parentBuilder;
		}
		
		public Value$builder key(PaperBuilder<?> key) {
			return new Value$builder(key);
		}
		
		public PaperBuilder<Value$builder> key$asPaper() {
			PaperBuilder<Value$builder> result = new PaperBuilder<Value$builder>(new Value$builder(null));
			result.$$$parentBuilder.key = result;
			return result;
		}
		
		public CopyPaperBuilder<Value$builder> key$asCopyPaper() {
			CopyPaperBuilder<Value$builder> result = new CopyPaperBuilder<Value$builder>(new Value$builder(null));
			result.$$$parentBuilder.key = result;
			return result;
		}
		

		public P1 end() {
			return this.$$$parentBuilder;
		}
	}
	
	public PaperColors$builder<? extends BookBuilder<P>> paperColors$map() {
		verifyMutable();

		if (this.paperColors == null) {
			this.paperColors = new HashMap<PaperBuilder<?>, ColorBuilder<?>>();
		}
		return new PaperColors$builder<BookBuilder<P>>(this);
	}	
}

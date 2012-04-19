package org.nebulae2us.electron.test.builder3.model;

import java.io.*;
import java.util.*;
import org.nebulae2us.electron.*;
import org.nebulae2us.electron.util.*;

@Builder(destination=Fiction.class)
public class FictionBuilder<P> extends BookBuilder<P> {

	public FictionBuilder() {
		super();
	}
	
	public FictionBuilder(P parentBuilder) {
		super(parentBuilder);
	}

	protected FictionBuilder(Fiction<? extends Color, ? extends Recordable<? extends Color>, ? extends Set<? super Recordable<? extends Color>>> wrapped) {
		super(wrapped);
	}

	@Override
    public FictionBuilder<P> storeTo(BuilderRepository repo, Object builderId) {
    	repo.put(builderId, this);
    	return this;
    }

	@Override
	public Fiction<? extends Color, ? extends Recordable<? extends Color>, ? extends Set<? super Recordable<? extends Color>>> getWrappedObject() {
		return (Fiction<? extends Color, ? extends Recordable<? extends Color>, ? extends Set<? super Recordable<? extends Color>>>)this.$$$wrapped;
	}

    public Fiction<? extends Color, ? extends Recordable<? extends Color>, ? extends Set<? super Recordable<? extends Color>>> toFiction() {
    	return new Converter(new DestinationClassResolverByAnnotation(), true).convert(this).to(Fiction.class);
    }
    
    public <C extends Color & Serializable, R extends Recordable<C>, S extends Set<? super R>> Fiction<C, R, S> toFiction(Class<C> C, Class<R> R, Class<S> S) {
    	return new Converter(new DestinationClassResolverByAnnotation(), true).convert(this).to(Fiction.class);
    }
	

	@Override
    public Fiction<? extends Color, ? extends Recordable<? extends Color>, ? extends Set<? super Recordable<? extends Color>>> toBook() {
    	return new Converter(new DestinationClassResolverByAnnotation(), true).convert(this).to(Fiction.class);
    }
    


	@Override
	public FictionBuilder<P> sequence(int sequence) {
		return (FictionBuilder<P>)super.sequence(sequence);
	}

	@Override
	public FictionBuilder<P> myPaper(PaperBuilder<?> myPaper) {
		return (FictionBuilder<P>)super.myPaper(myPaper);
	}

	@Override
    public FictionBuilder<P> myPaper$wrap(Paper myPaper) {
		return (FictionBuilder<P>)super.myPaper$wrap(myPaper);
    }

	@Override
    public FictionBuilder<P> myPaper$restoreFrom(BuilderRepository repo, Object builderId) {
		return (FictionBuilder<P>)super.myPaper$restoreFrom(repo, builderId);
    }

	@SuppressWarnings("unchecked")
	@Override
	public PaperBuilder<? extends FictionBuilder<P>> myPaper$begin() {
		return (PaperBuilder<? extends FictionBuilder<P>>)super.myPaper$begin();
	}

	@Override
	public CopyPaperBuilder<? extends FictionBuilder<P>> myPaper$asCopyPaper$begin() {
		return (CopyPaperBuilder<? extends FictionBuilder<P>>)super.myPaper$asCopyPaper$begin();
	}

	@Override
	public FictionBuilder<P> myRecordable(RecordableBuilder myRecordable) {
		return (FictionBuilder<P>)super.myRecordable(myRecordable);
	}

	@Override
    public FictionBuilder<P> myRecordable$wrap(Recordable myRecordable) {
		return (FictionBuilder<P>)super.myRecordable$wrap(myRecordable);
    }

	@Override
    public FictionBuilder<P> myRecordable$restoreFrom(BuilderRepository repo, Object builderId) {
		return (FictionBuilder<P>)super.myRecordable$restoreFrom(repo, builderId);
    }

	@Override
	public PaperBuilder<? extends FictionBuilder<P>> myRecordable$asPaper$begin() {
		return (PaperBuilder<? extends FictionBuilder<P>>)super.myRecordable$asPaper$begin();
	}

	@Override
	public CopyPaperBuilder<? extends FictionBuilder<P>> myRecordable$asCopyPaper$begin() {
		return (CopyPaperBuilder<? extends FictionBuilder<P>>)super.myRecordable$asCopyPaper$begin();
	}

	@Override
	public FictionBuilder<P> keywords(String ... keywords) {
		return (FictionBuilder<P>)super.keywords(keywords);
	}

	@Override
	public FictionBuilder<P> keywords(Collection<String> keywords) {
		return (FictionBuilder<P>)super.keywords(keywords);
	}



	@Override
	public FictionBuilder<P> myPapers(PaperBuilder<?> ... myPapers) {
		return (FictionBuilder<P>)super.myPapers(myPapers);
	}

	@Override
	public FictionBuilder<P> myPapers(Collection<PaperBuilder<?>> myPapers) {
		return (FictionBuilder<P>)super.myPapers(myPapers);
	}

	@Override
	public PaperBuilder<? extends FictionBuilder<P>> myPapers$addPaper() {
		return (PaperBuilder<? extends FictionBuilder<P>>)super.myPapers$addPaper();
	}
	
	@Override
	public CopyPaperBuilder<? extends FictionBuilder<P>> myPapers$addCopyPaper() {
		return (CopyPaperBuilder<? extends FictionBuilder<P>>)super.myPapers$addCopyPaper();
	}
	

	public MyPapers$$$builder<? extends FictionBuilder<P>> myPapers$list() {
		return (MyPapers$$$builder<? extends FictionBuilder<P>>)super.myPapers$list();
	}
	
	@Override
    public FictionBuilder<P> myPapers$wrap(Paper ... myPapers) {
		return (FictionBuilder<P>)super.myPapers$wrap(myPapers);
    }

	@Override
    public FictionBuilder<P> myPapers$wrap(Collection<? extends Paper> myPapers) {
		return (FictionBuilder<P>)super.myPapers$wrap(myPapers);
    }

	@Override
    public FictionBuilder<P> myPapers$restoreFrom(BuilderRepository repo, Object ... builderIds) {
		return (FictionBuilder<P>)super.myPapers$restoreFrom(repo, builderIds);
    }

	@Override
    public FictionBuilder<P> myPapers$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		return (FictionBuilder<P>)super.myPapers$restoreFrom(repo, builderIds);
    }


	@Override
	public FictionBuilder<P> myRecordables(RecordableBuilder ... myRecordables) {
		return (FictionBuilder<P>)super.myRecordables(myRecordables);
	}

	@Override
	public FictionBuilder<P> myRecordables(Collection<RecordableBuilder> myRecordables) {
		return (FictionBuilder<P>)super.myRecordables(myRecordables);
	}

	@Override
	public PaperBuilder<? extends FictionBuilder<P>> myRecordables$addPaper() {
		return (PaperBuilder<? extends FictionBuilder<P>>)super.myRecordables$addPaper();
	}
	
	@Override
	public CopyPaperBuilder<? extends FictionBuilder<P>> myRecordables$addCopyPaper() {
		return (CopyPaperBuilder<? extends FictionBuilder<P>>)super.myRecordables$addCopyPaper();
	}
	

	public MyRecordables$$$builder<? extends FictionBuilder<P>> myRecordables$list() {
		return (MyRecordables$$$builder<? extends FictionBuilder<P>>)super.myRecordables$list();
	}
	
	@Override
    public FictionBuilder<P> myRecordables$wrap(Recordable ... myRecordables) {
		return (FictionBuilder<P>)super.myRecordables$wrap(myRecordables);
    }

	@Override
    public FictionBuilder<P> myRecordables$wrap(Collection<? extends Recordable> myRecordables) {
		return (FictionBuilder<P>)super.myRecordables$wrap(myRecordables);
    }

	@Override
    public FictionBuilder<P> myRecordables$restoreFrom(BuilderRepository repo, Object ... builderIds) {
		return (FictionBuilder<P>)super.myRecordables$restoreFrom(repo, builderIds);
    }

	@Override
    public FictionBuilder<P> myRecordables$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		return (FictionBuilder<P>)super.myRecordables$restoreFrom(repo, builderIds);
    }


	@Override
	public FictionBuilder<P> paperColors(Map<PaperBuilder<?>, ColorBuilder<?>> paperColors) {
		return (FictionBuilder<P>)super.paperColors(paperColors);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public PaperColors$builder<? extends FictionBuilder<P>> paperColors$map() {
		return (PaperColors$builder<? extends FictionBuilder<P>>)super.paperColors$map();
	}

    /* CUSTOM CODE *********************************
     * 
     * Put your own custom code below. These codes won't be discarded during generation.
     * 
     */
     
     
     
}

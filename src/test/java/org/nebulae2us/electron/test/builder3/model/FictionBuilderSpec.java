package org.nebulae2us.electron.test.builder3.model;

import java.io.*;
import java.util.*;
import org.nebulae2us.electron.*;
import org.nebulae2us.electron.util.*;

@Builder(destination=Fiction.class)
public class FictionBuilderSpec<P> extends BookBuilderSpec<P> {

	public FictionBuilderSpec() {
		super();
	}
	
	public FictionBuilderSpec(P parentBuilder) {
		super(parentBuilder);
	}

	protected FictionBuilderSpec(Fiction<? extends Color, ? extends Recordable<? extends Color>, ? extends Set<? super Recordable<? extends Color>>> wrapped) {
		super(wrapped);
	}

	@Override
    public FictionBuilderSpec<P> storeTo(BuilderRepository repo, Object builderId) {
    	repo.put(builderId, this);
    	return this;
    }

	@Override
	public Fiction<? extends Color, ? extends Recordable<? extends Color>, ? extends Set<? super Recordable<? extends Color>>> getWrappedObject() {
		return (Fiction<? extends Color, ? extends Recordable<? extends Color>, ? extends Set<? super Recordable<? extends Color>>>)this.$$$wrapped;
	}

    public Fiction<? extends Color, ? extends Recordable<? extends Color>, ? extends Set<? super Recordable<? extends Color>>> toFiction() {
    	return new Converter(new DestinationClassResolverByAnnotation(), true, BuilderSpecs.IGNORED_TYPES).convert(this).to(Fiction.class);
    }
    
    public <C extends Color & Serializable, R extends Recordable<C>, S extends Set<? super R>> Fiction<C, R, S> toFiction(Class<C> C, Class<R> R, Class<S> S) {
    	return new Converter(new DestinationClassResolverByAnnotation(), true, BuilderSpecs.IGNORED_TYPES).convert(this).to(Fiction.class);
    }
	

	@Override
    public Fiction<? extends Color, ? extends Recordable<? extends Color>, ? extends Set<? super Recordable<? extends Color>>> toBook() {
    	return new Converter(new DestinationClassResolverByAnnotation(), true, BuilderSpecs.IGNORED_TYPES).convert(this).to(Fiction.class);
    }
    


	@Override
	public FictionBuilderSpec<P> sequence(int sequence) {
		return (FictionBuilderSpec<P>)super.sequence(sequence);
	}

	@Override
	public FictionBuilderSpec<P> myPaper(PaperBuilderSpec<?> myPaper) {
		return (FictionBuilderSpec<P>)super.myPaper(myPaper);
	}

	@Override
    public FictionBuilderSpec<P> myPaper$wrap(Paper myPaper) {
		return (FictionBuilderSpec<P>)super.myPaper$wrap(myPaper);
    }

	@Override
    public FictionBuilderSpec<P> myPaper$restoreFrom(BuilderRepository repo, Object builderId) {
		return (FictionBuilderSpec<P>)super.myPaper$restoreFrom(repo, builderId);
    }

	@SuppressWarnings("unchecked")
	@Override
	public PaperBuilderSpec<? extends FictionBuilderSpec<P>> myPaper$begin() {
		return (PaperBuilderSpec<? extends FictionBuilderSpec<P>>)super.myPaper$begin();
	}

	@Override
	public CopyPaperBuilderSpec<? extends FictionBuilderSpec<P>> myPaper$asCopyPaper$begin() {
		return (CopyPaperBuilderSpec<? extends FictionBuilderSpec<P>>)super.myPaper$asCopyPaper$begin();
	}

	@Override
	public FictionBuilderSpec<P> myRecordable(RecordableBuilderSpec myRecordable) {
		return (FictionBuilderSpec<P>)super.myRecordable(myRecordable);
	}

	@Override
    public FictionBuilderSpec<P> myRecordable$wrap(Recordable myRecordable) {
		return (FictionBuilderSpec<P>)super.myRecordable$wrap(myRecordable);
    }

	@Override
    public FictionBuilderSpec<P> myRecordable$restoreFrom(BuilderRepository repo, Object builderId) {
		return (FictionBuilderSpec<P>)super.myRecordable$restoreFrom(repo, builderId);
    }

	@Override
	public PaperBuilderSpec<? extends FictionBuilderSpec<P>> myRecordable$asPaper$begin() {
		return (PaperBuilderSpec<? extends FictionBuilderSpec<P>>)super.myRecordable$asPaper$begin();
	}

	@Override
	public CopyPaperBuilderSpec<? extends FictionBuilderSpec<P>> myRecordable$asCopyPaper$begin() {
		return (CopyPaperBuilderSpec<? extends FictionBuilderSpec<P>>)super.myRecordable$asCopyPaper$begin();
	}

	@Override
	public FictionBuilderSpec<P> keywords(String ... keywords) {
		return (FictionBuilderSpec<P>)super.keywords(keywords);
	}

	@Override
	public FictionBuilderSpec<P> keywords(Collection<String> keywords) {
		return (FictionBuilderSpec<P>)super.keywords(keywords);
	}



	@Override
	public FictionBuilderSpec<P> myPapers(PaperBuilderSpec<?> ... myPapers) {
		return (FictionBuilderSpec<P>)super.myPapers(myPapers);
	}

	@Override
	public FictionBuilderSpec<P> myPapers(Collection<PaperBuilderSpec<?>> myPapers) {
		return (FictionBuilderSpec<P>)super.myPapers(myPapers);
	}

	@Override
	public PaperBuilderSpec<? extends FictionBuilderSpec<P>> myPapers$addPaper() {
		return (PaperBuilderSpec<? extends FictionBuilderSpec<P>>)super.myPapers$addPaper();
	}
	
	@Override
	public CopyPaperBuilderSpec<? extends FictionBuilderSpec<P>> myPapers$addCopyPaper() {
		return (CopyPaperBuilderSpec<? extends FictionBuilderSpec<P>>)super.myPapers$addCopyPaper();
	}
	

	public MyPapers$$$builder<? extends FictionBuilderSpec<P>> myPapers$list() {
		return (MyPapers$$$builder<? extends FictionBuilderSpec<P>>)super.myPapers$list();
	}
	
	@Override
    public FictionBuilderSpec<P> myPapers$wrap(Paper ... myPapers) {
		return (FictionBuilderSpec<P>)super.myPapers$wrap(myPapers);
    }

	@Override
    public FictionBuilderSpec<P> myPapers$wrap(Collection<? extends Paper> myPapers) {
		return (FictionBuilderSpec<P>)super.myPapers$wrap(myPapers);
    }

	@Override
    public FictionBuilderSpec<P> myPapers$restoreFrom(BuilderRepository repo, Object ... builderIds) {
		return (FictionBuilderSpec<P>)super.myPapers$restoreFrom(repo, builderIds);
    }

	@Override
    public FictionBuilderSpec<P> myPapers$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		return (FictionBuilderSpec<P>)super.myPapers$restoreFrom(repo, builderIds);
    }


	@Override
	public FictionBuilderSpec<P> myRecordables(RecordableBuilderSpec ... myRecordables) {
		return (FictionBuilderSpec<P>)super.myRecordables(myRecordables);
	}

	@Override
	public FictionBuilderSpec<P> myRecordables(Collection<RecordableBuilderSpec> myRecordables) {
		return (FictionBuilderSpec<P>)super.myRecordables(myRecordables);
	}

	@Override
	public PaperBuilderSpec<? extends FictionBuilderSpec<P>> myRecordables$addPaper() {
		return (PaperBuilderSpec<? extends FictionBuilderSpec<P>>)super.myRecordables$addPaper();
	}
	
	@Override
	public CopyPaperBuilderSpec<? extends FictionBuilderSpec<P>> myRecordables$addCopyPaper() {
		return (CopyPaperBuilderSpec<? extends FictionBuilderSpec<P>>)super.myRecordables$addCopyPaper();
	}
	

	public MyRecordables$$$builder<? extends FictionBuilderSpec<P>> myRecordables$list() {
		return (MyRecordables$$$builder<? extends FictionBuilderSpec<P>>)super.myRecordables$list();
	}
	
	@Override
    public FictionBuilderSpec<P> myRecordables$wrap(Recordable ... myRecordables) {
		return (FictionBuilderSpec<P>)super.myRecordables$wrap(myRecordables);
    }

	@Override
    public FictionBuilderSpec<P> myRecordables$wrap(Collection<? extends Recordable> myRecordables) {
		return (FictionBuilderSpec<P>)super.myRecordables$wrap(myRecordables);
    }

	@Override
    public FictionBuilderSpec<P> myRecordables$restoreFrom(BuilderRepository repo, Object ... builderIds) {
		return (FictionBuilderSpec<P>)super.myRecordables$restoreFrom(repo, builderIds);
    }

	@Override
    public FictionBuilderSpec<P> myRecordables$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		return (FictionBuilderSpec<P>)super.myRecordables$restoreFrom(repo, builderIds);
    }


	@Override
	public FictionBuilderSpec<P> paperColors(Map<PaperBuilderSpec<?>, ColorBuilderSpec<?>> paperColors) {
		return (FictionBuilderSpec<P>)super.paperColors(paperColors);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public PaperColors$builder<? extends FictionBuilderSpec<P>> paperColors$map() {
		return (PaperColors$builder<? extends FictionBuilderSpec<P>>)super.paperColors$map();
	}

    /* CUSTOM CODE *********************************
     * 
     * Put your own custom code below. These codes won't be discarded during generation.
     * 
     */
     
     
     
}

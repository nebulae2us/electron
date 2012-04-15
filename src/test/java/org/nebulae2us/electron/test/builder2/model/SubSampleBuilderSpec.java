package org.nebulae2us.electron.test.builder2.model;

import java.util.*;
import org.nebulae2us.electron.*;
import org.nebulae2us.electron.util.*;

@Builder(destination=SubSample.class)
public class SubSampleBuilderSpec<P> extends SampleBuilderSpec<P> {

	public SubSampleBuilderSpec() {
		super();
	}
	
	public SubSampleBuilderSpec(P parentBuilder) {
		super(parentBuilder);
	}

	protected SubSampleBuilderSpec(SubSample wrapped) {
		super(wrapped);
	}

	@Override
    public SubSampleBuilderSpec<P> storeTo(BuilderRepository repo, Object builderId) {
    	repo.put(builderId, this);
    	return this;
    }

	@Override
	public SubSample getWrappedObject() {
		return (SubSample)this.$$$wrapped;
	}

    public SubSample toSubSample() {
    	return new Converter(new BuilderAnnotationDestinationClassResolver(), true).convert(this).to(SubSample.class);
    }
    

	@Override
    public SubSample toSample() {
    	return new Converter(new BuilderAnnotationDestinationClassResolver(), true).convert(this).to(SubSample.class);
    }
    


	@Override
	public SubSampleBuilderSpec<P> name(String name) {
		return (SubSampleBuilderSpec<P>)super.name(name);
	}

	@Override
	public SubSampleBuilderSpec<P> names(String ... names) {
		return (SubSampleBuilderSpec<P>)super.names(names);
	}

	@Override
	public SubSampleBuilderSpec<P> names(Collection<String> names) {
		return (SubSampleBuilderSpec<P>)super.names(names);
	}



	@Override
	public SubSampleBuilderSpec<P> keywords(String ... keywords) {
		return (SubSampleBuilderSpec<P>)super.keywords(keywords);
	}

	@Override
	public SubSampleBuilderSpec<P> keywords(Collection<String> keywords) {
		return (SubSampleBuilderSpec<P>)super.keywords(keywords);
	}



	@Override
	public SubSampleBuilderSpec<P> keywordCounts(Map<String, Integer> keywordCounts) {
		return (SubSampleBuilderSpec<P>)super.keywordCounts(keywordCounts);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public KeywordCounts$builder<? extends SubSampleBuilderSpec<P>> keywordCounts$map() {
		return (KeywordCounts$builder<? extends SubSampleBuilderSpec<P>>)super.keywordCounts$map();
	}

	@Override
	public SubSampleBuilderSpec<P> myClass(Class<?> myClass) {
		return (SubSampleBuilderSpec<P>)super.myClass(myClass);
	}

	@Override
	public SubSampleBuilderSpec<P> otherClasses(Class<?> ... otherClasses) {
		return (SubSampleBuilderSpec<P>)super.otherClasses(otherClasses);
	}

	@Override
	public SubSampleBuilderSpec<P> otherClasses(Collection<Class<?>> otherClasses) {
		return (SubSampleBuilderSpec<P>)super.otherClasses(otherClasses);
	}



	@Override
	public SubSampleBuilderSpec<P> blank(BlankBuilderSpec<?> blank) {
		return (SubSampleBuilderSpec<P>)super.blank(blank);
	}

	@Override
    public SubSampleBuilderSpec<P> blank$wrap(Blank blank) {
		return (SubSampleBuilderSpec<P>)super.blank$wrap(blank);
    }

	@Override
    public SubSampleBuilderSpec<P> blank$restoreFrom(BuilderRepository repo, Object builderId) {
		return (SubSampleBuilderSpec<P>)super.blank$restoreFrom(repo, builderId);
    }

	@SuppressWarnings("unchecked")
	@Override
	public BlankBuilderSpec<? extends SubSampleBuilderSpec<P>> blank$begin() {
		return (BlankBuilderSpec<? extends SubSampleBuilderSpec<P>>)super.blank$begin();
	}

	@Override
	public SubSampleBuilderSpec<P> blanks(BlankBuilderSpec<?> ... blanks) {
		return (SubSampleBuilderSpec<P>)super.blanks(blanks);
	}

	@Override
	public SubSampleBuilderSpec<P> blanks(Collection<BlankBuilderSpec<?>> blanks) {
		return (SubSampleBuilderSpec<P>)super.blanks(blanks);
	}

	@Override
	public BlankBuilderSpec<? extends SubSampleBuilderSpec<P>> blanks$addBlank() {
		return (BlankBuilderSpec<? extends SubSampleBuilderSpec<P>>)super.blanks$addBlank();
	}
	

	public Blanks$$$builder<? extends SubSampleBuilderSpec<P>> blanks$list() {
		return (Blanks$$$builder<? extends SubSampleBuilderSpec<P>>)super.blanks$list();
	}
	
	@Override
    public SubSampleBuilderSpec<P> blanks$wrap(Blank ... blanks) {
		return (SubSampleBuilderSpec<P>)super.blanks$wrap(blanks);
    }

	@Override
    public SubSampleBuilderSpec<P> blanks$wrap(Collection<? extends Blank> blanks) {
		return (SubSampleBuilderSpec<P>)super.blanks$wrap(blanks);
    }

	@Override
    public SubSampleBuilderSpec<P> blanks$restoreFrom(BuilderRepository repo, Object ... builderIds) {
		return (SubSampleBuilderSpec<P>)super.blanks$restoreFrom(repo, builderIds);
    }

	@Override
    public SubSampleBuilderSpec<P> blanks$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		return (SubSampleBuilderSpec<P>)super.blanks$restoreFrom(repo, builderIds);
    }


	@Override
	public SubSampleBuilderSpec<P> blanksMap(Map<Class<BlankBuilderSpec>, BlankBuilderSpec<?>> blanksMap) {
		return (SubSampleBuilderSpec<P>)super.blanksMap(blanksMap);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public BlanksMap$builder<? extends SubSampleBuilderSpec<P>> blanksMap$map() {
		return (BlanksMap$builder<? extends SubSampleBuilderSpec<P>>)super.blanksMap$map();
	}

	@Override
	public SubSampleBuilderSpec<P> blanks2blanks(Map<BlankBuilderSpec<?>, BlankBuilderSpec<?>> blanks2blanks) {
		return (SubSampleBuilderSpec<P>)super.blanks2blanks(blanks2blanks);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Blanks2blanks$builder<? extends SubSampleBuilderSpec<P>> blanks2blanks$map() {
		return (Blanks2blanks$builder<? extends SubSampleBuilderSpec<P>>)super.blanks2blanks$map();
	}

    /* CUSTOM CODE *********************************
     * 
     * Put your own custom code below. These codes won't be discarded during generation.
     * 
     */
     
     
     
}

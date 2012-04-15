package org.nebulae2us.electron.test.builder2.model;

import java.util.*;
import org.nebulae2us.electron.*;
import org.nebulae2us.electron.util.*;

@Builder(destination=SubSample.class)
public class SubSampleBuilder<P> extends SampleBuilder<P> {

	public SubSampleBuilder() {
		super();
	}
	
	public SubSampleBuilder(P parentBuilder) {
		super(parentBuilder);
	}

	protected SubSampleBuilder(SubSample wrapped) {
		super(wrapped);
	}

	@Override
    public SubSampleBuilder<P> storeTo(BuilderRepository repo, Object builderId) {
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
	public SubSampleBuilder<P> name(String name) {
		return (SubSampleBuilder<P>)super.name(name);
	}

	@Override
	public SubSampleBuilder<P> names(String ... names) {
		return (SubSampleBuilder<P>)super.names(names);
	}

	@Override
	public SubSampleBuilder<P> names(Collection<String> names) {
		return (SubSampleBuilder<P>)super.names(names);
	}



	@Override
	public SubSampleBuilder<P> keywords(String ... keywords) {
		return (SubSampleBuilder<P>)super.keywords(keywords);
	}

	@Override
	public SubSampleBuilder<P> keywords(Collection<String> keywords) {
		return (SubSampleBuilder<P>)super.keywords(keywords);
	}



	@Override
	public SubSampleBuilder<P> keywordCounts(Map<String, Integer> keywordCounts) {
		return (SubSampleBuilder<P>)super.keywordCounts(keywordCounts);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public KeywordCounts$builder<? extends SubSampleBuilder<P>> keywordCounts$map() {
		return (KeywordCounts$builder<? extends SubSampleBuilder<P>>)super.keywordCounts$map();
	}

	@Override
	public SubSampleBuilder<P> myClass(Class<?> myClass) {
		return (SubSampleBuilder<P>)super.myClass(myClass);
	}

	@Override
	public SubSampleBuilder<P> otherClasses(Class<?> ... otherClasses) {
		return (SubSampleBuilder<P>)super.otherClasses(otherClasses);
	}

	@Override
	public SubSampleBuilder<P> otherClasses(Collection<Class<?>> otherClasses) {
		return (SubSampleBuilder<P>)super.otherClasses(otherClasses);
	}



	@Override
	public SubSampleBuilder<P> blank(BlankBuilder<?> blank) {
		return (SubSampleBuilder<P>)super.blank(blank);
	}

	@Override
    public SubSampleBuilder<P> blank$wrap(Blank blank) {
		return (SubSampleBuilder<P>)super.blank$wrap(blank);
    }

	@Override
    public SubSampleBuilder<P> blank$restoreFrom(BuilderRepository repo, Object builderId) {
		return (SubSampleBuilder<P>)super.blank$restoreFrom(repo, builderId);
    }

	@SuppressWarnings("unchecked")
	@Override
	public BlankBuilder<? extends SubSampleBuilder<P>> blank$begin() {
		return (BlankBuilder<? extends SubSampleBuilder<P>>)super.blank$begin();
	}

	@Override
	public SubSampleBuilder<P> blanks(BlankBuilder<?> ... blanks) {
		return (SubSampleBuilder<P>)super.blanks(blanks);
	}

	@Override
	public SubSampleBuilder<P> blanks(Collection<BlankBuilder<?>> blanks) {
		return (SubSampleBuilder<P>)super.blanks(blanks);
	}

	@Override
	public BlankBuilder<? extends SubSampleBuilder<P>> blanks$addBlank() {
		return (BlankBuilder<? extends SubSampleBuilder<P>>)super.blanks$addBlank();
	}
	

	public Blanks$$$builder<? extends SubSampleBuilder<P>> blanks$list() {
		return (Blanks$$$builder<? extends SubSampleBuilder<P>>)super.blanks$list();
	}
	
	@Override
    public SubSampleBuilder<P> blanks$wrap(Blank ... blanks) {
		return (SubSampleBuilder<P>)super.blanks$wrap(blanks);
    }

	@Override
    public SubSampleBuilder<P> blanks$wrap(Collection<? extends Blank> blanks) {
		return (SubSampleBuilder<P>)super.blanks$wrap(blanks);
    }

	@Override
    public SubSampleBuilder<P> blanks$restoreFrom(BuilderRepository repo, Object ... builderIds) {
		return (SubSampleBuilder<P>)super.blanks$restoreFrom(repo, builderIds);
    }

	@Override
    public SubSampleBuilder<P> blanks$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		return (SubSampleBuilder<P>)super.blanks$restoreFrom(repo, builderIds);
    }


	@Override
	public SubSampleBuilder<P> blanksMap(Map<Class<BlankBuilder>, BlankBuilder<?>> blanksMap) {
		return (SubSampleBuilder<P>)super.blanksMap(blanksMap);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public BlanksMap$builder<? extends SubSampleBuilder<P>> blanksMap$map() {
		return (BlanksMap$builder<? extends SubSampleBuilder<P>>)super.blanksMap$map();
	}

	@Override
	public SubSampleBuilder<P> blanks2blanks(Map<BlankBuilder<?>, BlankBuilder<?>> blanks2blanks) {
		return (SubSampleBuilder<P>)super.blanks2blanks(blanks2blanks);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Blanks2blanks$builder<? extends SubSampleBuilder<P>> blanks2blanks$map() {
		return (Blanks2blanks$builder<? extends SubSampleBuilder<P>>)super.blanks2blanks$map();
	}

    /* CUSTOM CODE *********************************
     * 
     * Put your own custom code below. These codes won't be discarded during generation.
     * 
     */
     
     
     
}

package org.nebulae2us.electron.test.builder2.model;

import java.util.*;
import org.nebulae2us.electron.*;
import org.nebulae2us.electron.util.*;

public class SubSampleBuilder extends SampleBuilder {

	public SubSampleBuilder() {
		super();
	}
	
	public SubSampleBuilder(ConverterOption option) {
		super(option);
	}

	public SubSampleBuilder(SubSample wrapped, ConverterOption option) {
		super(wrapped, option);
	}

	@Override
	public SubSample getWrappedObject() {
		return (SubSample)this.$$$wrapped;
	}

	@Override
    public SubSampleBuilder storeTo(BuilderRepository repo, Object builderId) {
    	repo.put(builderId, this);
    	return this;
    }
	
    public SubSample toSubSample() {
    	return new Converter(this.$$$option, true).convert(this).to(SubSample.class);
    }

    @Override
    public SubSample toSample() {
    	return new Converter(this.$$$option, true).convert(this).to(SubSample.class);
    }

	@Override
	public SubSampleBuilder name(String name) {
		return (SubSampleBuilder)super.name(name);
	}

	@Override
	public SubSampleBuilder names(String ... names) {
		return (SubSampleBuilder)super.names(names);
	}

	@Override
	public SubSampleBuilder names(Collection<String> names) {
		return (SubSampleBuilder)super.names(names);
	}

	@Override
	public SubSampleBuilder keywords(String ... keywords) {
		return (SubSampleBuilder)super.keywords(keywords);
	}

	@Override
	public SubSampleBuilder keywords(Collection<String> keywords) {
		return (SubSampleBuilder)super.keywords(keywords);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ChainedMapBuilder<? extends SubSampleBuilder, String, Integer> keywordCounts$begin() {
		return (ChainedMapBuilder<? extends SubSampleBuilder, String, Integer>)super.keywordCounts$begin();
	}

	@Override
	public SubSampleBuilder keywordCounts(Map<String, Integer> keywordCounts) {
		return (SubSampleBuilder)super.keywordCounts(keywordCounts);
	}

	@Override
	public SubSampleBuilder myClass(Class<?> myClass) {
		return (SubSampleBuilder)super.myClass(myClass);
	}

	@Override
	public SubSampleBuilder otherClasses(Class<?> ... otherClasses) {
		return (SubSampleBuilder)super.otherClasses(otherClasses);
	}

	@Override
	public SubSampleBuilder otherClasses(Collection<Class<?>> otherClasses) {
		return (SubSampleBuilder)super.otherClasses(otherClasses);
	}

	@Override
	public SubSampleBuilder blank(BlankBuilder blank) {
		return (SubSampleBuilder)super.blank(blank);
	}

	@Override
    public SubSampleBuilder blank$wrap(Blank blank) {
		return (SubSampleBuilder)super.blank$wrap(blank);
    }

	@Override
    public SubSampleBuilder blank$restoreFrom(BuilderRepository repo, Object builderId) {
		return (SubSampleBuilder)super.blank$restoreFrom(repo, builderId);
    }

	@Override
	public SubSampleBuilder blanks(BlankBuilder ... blanks) {
		return (SubSampleBuilder)super.blanks(blanks);
	}

	@Override
	public SubSampleBuilder blanks(Collection<BlankBuilder> blanks) {
		return (SubSampleBuilder)super.blanks(blanks);
	}

	@Override
    public SubSampleBuilder blanks$wrap(Blank ... blanks) {
		return (SubSampleBuilder)super.blanks$wrap(blanks);
    }

	@Override
    public SubSampleBuilder blanks$wrap(Collection<Blank> blanks) {
		return (SubSampleBuilder)super.blanks$wrap(blanks);
    }

	@Override
    public SubSampleBuilder blanks$restoreFrom(BuilderRepository repo, Object ... builderIds) {
		return (SubSampleBuilder)super.blanks$restoreFrom(repo, builderIds);
    }

	@Override
    public SubSampleBuilder blanks$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		return (SubSampleBuilder)super.blanks$restoreFrom(repo, builderIds);
    }

	@SuppressWarnings("unchecked")
	@Override
	public ChainedMapBuilder<? extends SubSampleBuilder, Class<BlankBuilder>, BlankBuilder> blanksMap$begin() {
		return (ChainedMapBuilder<? extends SubSampleBuilder, Class<BlankBuilder>, BlankBuilder>)super.blanksMap$begin();
	}

	@Override
	public SubSampleBuilder blanksMap(Map<Class<BlankBuilder>, BlankBuilder> blanksMap) {
		return (SubSampleBuilder)super.blanksMap(blanksMap);
	}
}

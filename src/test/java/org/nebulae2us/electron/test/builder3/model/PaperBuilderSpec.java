package org.nebulae2us.electron.test.builder3.model;

import java.util.*;
import org.nebulae2us.electron.*;
import org.nebulae2us.electron.util.*;

@Builder(destination=Paper.class)
public class PaperBuilderSpec<P> implements Wrappable<Paper<? extends Color>>, RecordableBuilderSpec {

	protected final Paper<? extends Color> $$$wrapped;

	protected final P $$$parentBuilder;
	
	public PaperBuilderSpec() {
		this.$$$wrapped = null;
		this.$$$parentBuilder = null;
	}
	
	public PaperBuilderSpec(P parentBuilder) {
		this.$$$wrapped = null;
		this.$$$parentBuilder = parentBuilder;
	}

	protected PaperBuilderSpec(Paper<? extends Color> wrapped) {
		this.$$$wrapped = wrapped;
		this.$$$parentBuilder = null;
	}
	
    public PaperBuilderSpec<P> storeTo(BuilderRepository repo, Object builderId) {
    	repo.put(builderId, this);
    	return this;
    }

	public Paper<? extends Color> getWrappedObject() {
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

    public Paper<? extends Color> toPaper() {
    	return new Converter(new BuilderAnnotationDestinationClassResolver(), true).convert(this).to(Paper.class);
    }

    public <C extends Color> Paper<C> toPaper(Class<C> C) {
    	return new Converter(new BuilderAnnotationDestinationClassResolver(), true).convert(this).to(Paper.class);
    }

}

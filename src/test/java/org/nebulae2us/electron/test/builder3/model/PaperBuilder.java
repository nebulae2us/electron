package org.nebulae2us.electron.test.builder3.model;

import java.util.*;
import org.nebulae2us.electron.*;
import org.nebulae2us.electron.util.*;

@Builder(destination=Paper.class)
public class PaperBuilder<P> implements Wrappable<Paper<? extends Color>>, RecordableBuilder {

	protected final Paper<? extends Color> $$$wrapped;

	protected final P $$$parentBuilder;
	
	public PaperBuilder() {
		this.$$$wrapped = null;
		this.$$$parentBuilder = null;
	}
	
	public PaperBuilder(P parentBuilder) {
		this.$$$wrapped = null;
		this.$$$parentBuilder = parentBuilder;
	}

	protected PaperBuilder(Paper<? extends Color> wrapped) {
		if (wrapped == null) {
			throw new NullPointerException();
		}
		this.$$$wrapped = wrapped;
		this.$$$parentBuilder = null;
	}
	
    public PaperBuilder<P> storeTo(BuilderRepository repo, Object builderId) {
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
    	return new Converter(new DestinationClassResolverByAnnotation(), true).convert(this).to(Paper.class);
    }

    public <C extends Color> Paper<C> toPaper(Class<C> C) {
    	return new Converter(new DestinationClassResolverByAnnotation(), true).convert(this).to(Paper.class);
    }


    /* CUSTOM CODE *********************************
     * 
     * Put your own custom code below. These codes won't be discarded during generation.
     * 
     */
     
     
     
}

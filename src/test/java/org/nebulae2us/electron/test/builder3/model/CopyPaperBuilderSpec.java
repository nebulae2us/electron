package org.nebulae2us.electron.test.builder3.model;

import java.util.*;
import org.nebulae2us.electron.*;
import org.nebulae2us.electron.util.*;

@Builder(destination=CopyPaper.class)
public class CopyPaperBuilderSpec<P> extends PaperBuilderSpec<P> {

	public CopyPaperBuilderSpec() {
		super();
	}
	
	public CopyPaperBuilderSpec(P parentBuilder) {
		super(parentBuilder);
	}

	protected CopyPaperBuilderSpec(CopyPaper<? extends Color> wrapped) {
		super(wrapped);
	}

	@Override
    public CopyPaperBuilderSpec<P> storeTo(BuilderRepository repo, Object builderId) {
    	repo.put(builderId, this);
    	return this;
    }

	@Override
	public CopyPaper<? extends Color> getWrappedObject() {
		return (CopyPaper<? extends Color>)this.$$$wrapped;
	}

    public CopyPaper<? extends Color> toCopyPaper() {
    	return new Converter(new BuilderAnnotationDestinationClassResolver(), true).convert(this).to(CopyPaper.class);
    }
    
    public <C extends Color> CopyPaper<C> toCopyPaper(Class<C> C) {
    	return new Converter(new BuilderAnnotationDestinationClassResolver(), true).convert(this).to(CopyPaper.class);
    }
	

	@Override
    public CopyPaper<? extends Color> toPaper() {
    	return new Converter(new BuilderAnnotationDestinationClassResolver(), true).convert(this).to(CopyPaper.class);
    }
    

}

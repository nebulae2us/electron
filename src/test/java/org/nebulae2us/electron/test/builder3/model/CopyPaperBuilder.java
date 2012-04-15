package org.nebulae2us.electron.test.builder3.model;

import java.util.*;
import org.nebulae2us.electron.*;
import org.nebulae2us.electron.util.*;

@Builder(destination=CopyPaper.class)
public class CopyPaperBuilder<P> extends PaperBuilder<P> {

	public CopyPaperBuilder() {
		super();
	}
	
	public CopyPaperBuilder(P parentBuilder) {
		super(parentBuilder);
	}

	protected CopyPaperBuilder(CopyPaper<? extends Color> wrapped) {
		super(wrapped);
	}

	@Override
    public CopyPaperBuilder<P> storeTo(BuilderRepository repo, Object builderId) {
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
    


    /* CUSTOM CODE *********************************
     * 
     * Put your own custom code below. These codes won't be discarded during generation.
     * 
     */
     
     
     
}

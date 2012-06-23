package org.nebulae2us.electron.test.builder3.model;

import java.util.*;
import org.nebulae2us.electron.*;
import org.nebulae2us.electron.util.*;

@Builder(destination=RGBColor.class)
public class RGBColorBuilder<P> extends ColorBuilder<P> {

	public RGBColorBuilder() {
		super();
	}
	
	public RGBColorBuilder(P parentBuilder) {
		super(parentBuilder);
	}

	protected RGBColorBuilder(RGBColor wrapped) {
		super(wrapped);
	}

	@Override
    public RGBColorBuilder<P> storeTo(BuilderRepository repo, Object builderId) {
    	repo.put(builderId, this);
    	return this;
    }

	@Override
	public RGBColor getWrappedObject() {
		return (RGBColor)this.$$$wrapped;
	}

    public RGBColor toRGBColor() {
    	return new Converter(new DestinationClassResolverByAnnotation(), true, BuilderSpecs.IGNORED_TYPES).convert(this).to(RGBColor.class);
    }
    

	@Override
    public RGBColor toColor() {
    	return new Converter(new DestinationClassResolverByAnnotation(), true, BuilderSpecs.IGNORED_TYPES).convert(this).to(RGBColor.class);
    }
    


    /* CUSTOM CODE *********************************
     * 
     * Put your own custom code below. These codes won't be discarded during generation.
     * 
     */
     
     
     
}

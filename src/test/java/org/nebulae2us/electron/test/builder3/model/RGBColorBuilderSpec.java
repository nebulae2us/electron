package org.nebulae2us.electron.test.builder3.model;

import java.util.*;
import org.nebulae2us.electron.*;
import org.nebulae2us.electron.util.*;

@Builder(destination=RGBColor.class)
public class RGBColorBuilderSpec<P> extends ColorBuilderSpec<P> {

	public RGBColorBuilderSpec() {
		super();
	}
	
	public RGBColorBuilderSpec(P parentBuilder) {
		super(parentBuilder);
	}

	protected RGBColorBuilderSpec(RGBColor wrapped) {
		super(wrapped);
	}

	@Override
    public RGBColorBuilderSpec<P> storeTo(BuilderRepository repo, Object builderId) {
    	repo.put(builderId, this);
    	return this;
    }

	@Override
	public RGBColor getWrappedObject() {
		return (RGBColor)this.$$$wrapped;
	}

    public RGBColor toRGBColor() {
    	return new Converter(new BuilderAnnotationDestinationClassResolver(), true).convert(this).to(RGBColor.class);
    }
    

	@Override
    public RGBColor toColor() {
    	return new Converter(new BuilderAnnotationDestinationClassResolver(), true).convert(this).to(RGBColor.class);
    }
    

}

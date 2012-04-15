package org.nebulae2us.electron.test.builder3.model;

import java.util.*;
import org.nebulae2us.electron.*;
import org.nebulae2us.electron.util.*;

@Builder(destination=Color.class)
public class ColorBuilder<P> implements Wrappable<Color> {

	protected final Color $$$wrapped;

	protected final P $$$parentBuilder;
	
	public ColorBuilder() {
		this.$$$wrapped = null;
		this.$$$parentBuilder = null;
	}
	
	public ColorBuilder(P parentBuilder) {
		this.$$$wrapped = null;
		this.$$$parentBuilder = parentBuilder;
	}

	protected ColorBuilder(Color wrapped) {
		if (wrapped == null) {
			throw new NullPointerException();
		}
		this.$$$wrapped = wrapped;
		this.$$$parentBuilder = null;
	}
	
    public ColorBuilder<P> storeTo(BuilderRepository repo, Object builderId) {
    	repo.put(builderId, this);
    	return this;
    }

	public Color getWrappedObject() {
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

    public Color toColor() {
    	return new Converter(new BuilderAnnotationDestinationClassResolver(), true).convert(this).to(Color.class);
    }



    /* CUSTOM CODE *********************************
     * 
     * Put your own custom code below. These codes won't be discarded during generation.
     * 
     */
     
     
     
}

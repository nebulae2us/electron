package org.nebulae2us.electron.test.builder2.model;

import java.util.*;
import org.nebulae2us.electron.*;
import org.nebulae2us.electron.util.*;

@Builder(destination=Blank.class)
public class BlankBuilder<P> implements Wrappable<Blank> {

	protected final Blank $$$wrapped;

	protected final P $$$parentBuilder;
	
	public BlankBuilder() {
		this.$$$wrapped = null;
		this.$$$parentBuilder = null;
	}
	
	public BlankBuilder(P parentBuilder) {
		this.$$$wrapped = null;
		this.$$$parentBuilder = parentBuilder;
	}

	protected BlankBuilder(Blank wrapped) {
		if (wrapped == null) {
			throw new NullPointerException();
		}
		this.$$$wrapped = wrapped;
		this.$$$parentBuilder = null;
	}
	
    public BlankBuilder<P> storeTo(BuilderRepository repo, Object builderId) {
    	repo.put(builderId, this);
    	return this;
    }

	public Blank getWrappedObject() {
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

    public Blank toBlank() {
    	return new Converter(new DestinationClassResolverByAnnotation(), true, BuilderSpecs.IGNORED_TYPES).convert(this).to(Blank.class);
    }



	private String name;
	
	public String getName() {
		if (this.$$$wrapped != null && WrapHelper.valueNotSet(this.name, String.class)) {
			Object o = WrapHelper.getValue(this.$$$wrapped, Blank.class, "name");
			this.name = new WrapConverter(BuilderSpecs.DESTINATION_CLASS_RESOLVER, BuilderSpecs.IGNORED_TYPES).convert(o).to(String.class);
		}

		return name;
	}

	public void setName(String name) {
		verifyMutable();
		this.name = name;
	}

	public BlankBuilder<P> name(String name) {
		verifyMutable();
		this.name = name;
		return this;
	}

    /* CUSTOM CODE *********************************
     * 
     * Put your own custom code below. These codes won't be discarded during generation.
     * 
     */
     
     
     
}

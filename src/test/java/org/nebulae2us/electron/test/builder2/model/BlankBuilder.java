package org.nebulae2us.electron.test.builder2.model;

import java.util.*;
import org.nebulae2us.electron.*;
import org.nebulae2us.electron.util.*;

public class BlankBuilder implements Wrappable<Blank> {

	protected final Blank $$$wrapped;

	protected final ConverterOption $$$option;
	
	public BlankBuilder() {
		this(null, null);
	}
	
	public BlankBuilder(ConverterOption option) {
		this(null, option);
	}

	protected BlankBuilder(Blank wrapped, ConverterOption option) {
		this.$$$wrapped = wrapped;
		this.$$$option = option;
	}
	
    public BlankBuilder storeTo(BuilderRepository repo, Object builderId) {
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

    public Blank toBlank() {
    	return new Converter(this.$$$option, true).convert(this).to(Blank.class);
    }

	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		verifyMutable();
		this.name = name;
	}

	public BlankBuilder name(String name) {
		verifyMutable();
		this.name = name;
		return this;
	}
}

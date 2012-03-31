package org.nebulae2us.electron.test.builder1.model;

import java.util.*;
import org.nebulae2us.electron.*;
import org.nebulae2us.electron.util.*;

public class SpeechBuilder implements Wrappable<Speech> {

	protected final Speech $$$wrapped;

	protected final ConverterOption $$$option;
	
	public SpeechBuilder() {
		this(null, null);
	}
	
	public SpeechBuilder(ConverterOption option) {
		this(null, option);
	}

	protected SpeechBuilder(Speech wrapped, ConverterOption option) {
		this.$$$wrapped = wrapped;
		this.$$$option = option;
	}
	
    public SpeechBuilder storeTo(BuilderRepository repo, Object builderId) {
    	repo.put(builderId, this);
    	return this;
    }

	public Speech getWrappedObject() {
		return this.$$$wrapped;
	}

	protected void verifyMutable() {
		if (this.$$$wrapped != null) {
    		throw new IllegalStateException("Cannot mutate fields of immutable objects");
		}
	}

    public Speech toSpeech() {
    	return new Converter(this.$$$option, true).convert(this).to(Speech.class);
    }

	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		verifyMutable();
		this.name = name;
	}

	public SpeechBuilder name(String name) {
		verifyMutable();
		this.name = name;
		return this;
	}

	private PersonBuilder owner;
	
	public PersonBuilder getOwner() {
		return owner;
	}

	public void setOwner(PersonBuilder owner) {
		verifyMutable();
		this.owner = owner;
	}

	public SpeechBuilder owner(PersonBuilder owner) {
		verifyMutable();
		this.owner = owner;
		return this;
	}

    public SpeechBuilder owner$wrap(Person owner) {
    	verifyMutable();
    	this.owner = new WrapConverter(this.$$$option).convert(owner).to(PersonBuilder.class);
        return this;
    }
    
    public SpeechBuilder owner$restoreFrom(BuilderRepository repo, Object builderId) {
    	verifyMutable();
    	
        Object restoredObject = repo.get(builderId);
        if (restoredObject == null) {
        	if (repo.isSupportLazy()) {
        		repo.addObjectStoredListener(builderId, new Procedure() {
					public void execute(Object... arguments) {
						SpeechBuilder.this.owner = (PersonBuilder)arguments[0];
					}
				});
        	}
        	else {
                throw new IllegalStateException("Object does not exist with id " + builderId);
        	}
        }
        else if (!(restoredObject instanceof PersonBuilder)) {
        	throw new IllegalStateException("Type mismatch for id: " + builderId + ". " + PersonBuilder.class.getSimpleName() + " vs " + restoredObject.getClass().getSimpleName());
        }
        else {
            this.owner = (PersonBuilder)restoredObject;
        }
        return this;
    }

	private List<String> keywords;
	
	public List<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<String> keywords) {
		verifyMutable();
		this.keywords = keywords;
	}

	public SpeechBuilder keywords(String ... keywords) {
		verifyMutable();
		return keywords(new ListBuilder<String>().add(keywords).toList());
	}
	
	public SpeechBuilder keywords(Collection<String> keywords) {
		verifyMutable();
		if (this.keywords == null) {
			this.keywords = new ArrayList<String>();
		}
		if (keywords != null) {
			for (String e : keywords) {
				this.keywords.add(e);
			}
		}
		return this;
	}

	private Map<HobbyBuilder, List<String>> hobbyKeywords;
	
	public Map<HobbyBuilder, List<String>> getHobbyKeywords() {
		return hobbyKeywords;
	}

	public void setHobbyKeywords(Map<HobbyBuilder, List<String>> hobbyKeywords) {
		verifyMutable();
		this.hobbyKeywords = hobbyKeywords;
	}
}

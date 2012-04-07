package org.nebulae2us.electron.test.builder1.model;

import java.util.*;
import org.nebulae2us.electron.*;
import org.nebulae2us.electron.util.*;

@Builder(destination=Speech.class)
public class SpeechBuilder<P> implements Wrappable<Speech> {

	protected final Speech $$$wrapped;

	protected final P $$$parentBuilder;
	
	public SpeechBuilder() {
		this.$$$wrapped = null;
		this.$$$parentBuilder = null;
	}
	
	public SpeechBuilder(P parentBuilder) {
		this.$$$wrapped = null;
		this.$$$parentBuilder = parentBuilder;
	}

	protected SpeechBuilder(Speech wrapped) {
		this.$$$wrapped = wrapped;
		this.$$$parentBuilder = null;
	}
	
    public SpeechBuilder<P> storeTo(BuilderRepository repo, Object builderId) {
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

	public P end() {
		return this.$$$parentBuilder;
	}

    public Speech toSpeech() {
    	return new Converter(new BuilderAnnotationDestinationClassResolver(), true).convert(this).to(Speech.class);
    }

	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		verifyMutable();
		this.name = name;
	}

	public SpeechBuilder<P> name(String name) {
		verifyMutable();
		this.name = name;
		return this;
	}

	private PersonBuilder<?> owner;
	
	public PersonBuilder<?> getOwner() {
		return owner;
	}

	public void setOwner(PersonBuilder<?> owner) {
		verifyMutable();
		this.owner = owner;
	}

	public SpeechBuilder<P> owner(PersonBuilder<?> owner) {
		verifyMutable();
		this.owner = owner;
		return this;
	}

	public PersonBuilder<? extends SpeechBuilder<P>> owner$begin() {
		PersonBuilder<SpeechBuilder<P>> result = new PersonBuilder<SpeechBuilder<P>>(this);
		this.owner = result;
		return result;
	}

    public SpeechBuilder<P> owner$wrap(Person owner) {
    	verifyMutable();
    	this.owner = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER).convert(owner).to(PersonBuilder.class);
        return this;
    }
    
    public SpeechBuilder<P> owner$restoreFrom(BuilderRepository repo, Object builderId) {
    	verifyMutable();
    	
        Object restoredObject = repo.get(builderId);
        if (restoredObject == null) {
        	if (repo.isSupportLazy()) {
        		repo.addObjectStoredListener(builderId, new Procedure() {
					public void execute(Object... arguments) {
						SpeechBuilder.this.owner = (PersonBuilder<?>)arguments[0];
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
            this.owner = (PersonBuilder<?>)restoredObject;
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

	public SpeechBuilder<P> keywords(String ... keywords) {
		verifyMutable();
		return keywords(new ListBuilder<String>().add(keywords).toList());
	}
	
	public SpeechBuilder<P> keywords(Collection<String> keywords) {
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

	private Map<HobbyBuilder<?>, List<String>> hobbyKeywords;
	
	public Map<HobbyBuilder<?>, List<String>> getHobbyKeywords() {
		return hobbyKeywords;
	}

	public void setHobbyKeywords(Map<HobbyBuilder<?>, List<String>> hobbyKeywords) {
		verifyMutable();
		this.hobbyKeywords = hobbyKeywords;
	}
}

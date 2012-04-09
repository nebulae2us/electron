package org.nebulae2us.electron.test.builder1.model;

import java.util.*;
import org.nebulae2us.electron.*;
import org.nebulae2us.electron.util.*;

@Builder(destination=Speech.class)
public class SpeechBuilderSpec<P> implements Wrappable<Speech> {

	protected final Speech $$$wrapped;

	protected final P $$$parentBuilder;
	
	public SpeechBuilderSpec() {
		this.$$$wrapped = null;
		this.$$$parentBuilder = null;
	}
	
	public SpeechBuilderSpec(P parentBuilder) {
		this.$$$wrapped = null;
		this.$$$parentBuilder = parentBuilder;
	}

	protected SpeechBuilderSpec(Speech wrapped) {
		this.$$$wrapped = wrapped;
		this.$$$parentBuilder = null;
	}
	
    public SpeechBuilderSpec<P> storeTo(BuilderRepository repo, Object builderId) {
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

	public SpeechBuilderSpec<P> name(String name) {
		verifyMutable();
		this.name = name;
		return this;
	}

	private PersonBuilderSpec<?> owner;
	
	public PersonBuilderSpec<?> getOwner() {
		return owner;
	}

	public void setOwner(PersonBuilderSpec<?> owner) {
		verifyMutable();
		this.owner = owner;
	}

	public SpeechBuilderSpec<P> owner(PersonBuilderSpec<?> owner) {
		verifyMutable();
		this.owner = owner;
		return this;
	}

    public SpeechBuilderSpec<P> owner$wrap(Person owner) {
    	verifyMutable();
    	this.owner = new WrapConverter(BuilderSpecs.DESTINATION_CLASS_RESOLVER).convert(owner).to(PersonBuilderSpec.class);
        return this;
    }
    
    public SpeechBuilderSpec<P> owner$restoreFrom(BuilderRepository repo, Object builderId) {
    	verifyMutable();
    	
        Object restoredObject = repo.get(builderId);
        if (restoredObject == null) {
        	if (repo.isSupportLazy()) {
        		repo.addObjectStoredListener(builderId, new Procedure() {
					public void execute(Object... arguments) {
						SpeechBuilderSpec.this.owner = (PersonBuilderSpec<?>)arguments[0];
					}
				});
        	}
        	else {
                throw new IllegalStateException("Object does not exist with id " + builderId);
        	}
        }
        else if (!(restoredObject instanceof PersonBuilderSpec)) {
        	throw new IllegalStateException("Type mismatch for id: " + builderId + ". " + PersonBuilderSpec.class.getSimpleName() + " vs " + restoredObject.getClass().getSimpleName());
        }
        else {
            this.owner = (PersonBuilderSpec<?>)restoredObject;
        }
        return this;
    }

	public PersonBuilderSpec<? extends SpeechBuilderSpec<P>> owner$begin() {
		verifyMutable();
		PersonBuilderSpec<SpeechBuilderSpec<P>> result = new PersonBuilderSpec<SpeechBuilderSpec<P>>(this);
		this.owner = result;
		return result;
	}

	public StudentBuilderSpec<? extends SpeechBuilderSpec<P>> owner$asStudent$begin() {
		verifyMutable();
		StudentBuilderSpec<SpeechBuilderSpec<P>> result = new StudentBuilderSpec<SpeechBuilderSpec<P>>(this);
		this.owner = result;
		return result;
	}

	public TeacherBuilderSpec<? extends SpeechBuilderSpec<P>> owner$asTeacher$begin() {
		verifyMutable();
		TeacherBuilderSpec<SpeechBuilderSpec<P>> result = new TeacherBuilderSpec<SpeechBuilderSpec<P>>(this);
		this.owner = result;
		return result;
	}

	private List<String> keywords;
	
	public List<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<String> keywords) {
		verifyMutable();
		this.keywords = keywords;
	}

	public SpeechBuilderSpec<P> keywords(String ... keywords) {
		verifyMutable();
		return keywords(new ListBuilder<String>().add(keywords).toList());
	}
	
	public SpeechBuilderSpec<P> keywords(Collection<String> keywords) {
		verifyMutable();
		if (this.keywords == null) {
			this.keywords = new ArrayList<String>();
		}
		if (keywords != null) {
			for (String e : keywords) {
				CollectionUtils.addItem(this.keywords, e);
			}
		}
		return this;
	}



	private Map<HobbyBuilderSpec<?>, List<String>> hobbyKeywords;
	
	public Map<HobbyBuilderSpec<?>, List<String>> getHobbyKeywords() {
		return hobbyKeywords;
	}

	public void setHobbyKeywords(Map<HobbyBuilderSpec<?>, List<String>> hobbyKeywords) {
		verifyMutable();
		this.hobbyKeywords = hobbyKeywords;
	}
}

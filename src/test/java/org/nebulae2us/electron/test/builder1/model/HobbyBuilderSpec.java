package org.nebulae2us.electron.test.builder1.model;

import java.util.*;
import org.nebulae2us.electron.*;
import org.nebulae2us.electron.util.*;

@Builder(destination=Hobby.class)
public class HobbyBuilderSpec<P> implements Wrappable<Hobby> {

	protected final Hobby $$$wrapped;

	protected final P $$$parentBuilder;
	
	public HobbyBuilderSpec() {
		this.$$$wrapped = null;
		this.$$$parentBuilder = null;
	}
	
	public HobbyBuilderSpec(P parentBuilder) {
		this.$$$wrapped = null;
		this.$$$parentBuilder = parentBuilder;
	}

	protected HobbyBuilderSpec(Hobby wrapped) {
		this.$$$wrapped = wrapped;
		this.$$$parentBuilder = null;
	}
	
    public HobbyBuilderSpec<P> storeTo(BuilderRepository repo, Object builderId) {
    	repo.put(builderId, this);
    	return this;
    }

	public Hobby getWrappedObject() {
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

    public Hobby toHobby() {
    	return new Converter(new BuilderAnnotationDestinationClassResolver(), true).convert(this).to(Hobby.class);
    }

	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		verifyMutable();
		this.name = name;
	}

	public HobbyBuilderSpec<P> name(String name) {
		verifyMutable();
		this.name = name;
		return this;
	}

	private List<PersonBuilderSpec<?>> people;
	
	public List<PersonBuilderSpec<?>> getPeople() {
		return people;
	}

	public void setPeople(List<PersonBuilderSpec<?>> people) {
		verifyMutable();
		this.people = people;
	}

	public HobbyBuilderSpec<P> people(PersonBuilderSpec<?> ... people) {
		verifyMutable();
		return people(new ListBuilder<PersonBuilderSpec<?>>().add(people).toList());
	}
	
	public HobbyBuilderSpec<P> people(Collection<PersonBuilderSpec<?>> people) {
		verifyMutable();
		if (this.people == null) {
			this.people = new ArrayList<PersonBuilderSpec<?>>();
		}
		if (people != null) {
			for (PersonBuilderSpec<?> e : people) {
				this.people.add(e);
			}
		}
		return this;
	}

	public PersonBuilderSpec<HobbyBuilderSpec<P>> people$one() {
		verifyMutable();
		if (this.people == null) {
			this.people = new ArrayList<PersonBuilderSpec<?>>();
		}
		
		PersonBuilderSpec<HobbyBuilderSpec<P>> result =
				new PersonBuilderSpec<HobbyBuilderSpec<P>>(this);
		
		this.people.add(result);
		
		return result;
	}

	public class People$$$builder {
		
		public PersonBuilderSpec<People$$$builder> blank$begin() {
			PersonBuilderSpec<People$$$builder> result = new PersonBuilderSpec<People$$$builder>(this);
			HobbyBuilderSpec.this.people.add(result);
			return result;
		}
		
		public HobbyBuilderSpec<P> end() {
			return HobbyBuilderSpec.this;
		}
	}
	
	public People$$$builder people$list() {
		verifyMutable();
		if (this.people == null) {
			this.people = new ArrayList<PersonBuilderSpec<?>>();
		}
		return new People$$$builder();
	}

    public HobbyBuilderSpec<P> people$wrap(Person ... people) {
    	return people$wrap(new ListBuilder<Person>().add(people).toList());
    }

    public HobbyBuilderSpec<P> people$wrap(Collection<Person> people) {
		verifyMutable();

		if (this.people == null) {
			this.people = new ArrayList<PersonBuilderSpec<?>>();
		}
		if (people != null) {
			for (Person e : people) {
				PersonBuilderSpec<?> wrapped = new WrapConverter(BuilderSpecs.DESTINATION_CLASS_RESOLVER).convert(e).to(PersonBuilderSpec.class);
				this.people.add(wrapped);
			}
		}
		return this;
    }
    
    public HobbyBuilderSpec<P> people$restoreFrom(BuilderRepository repo, Object ... builderIds) {
    	return people$restoreFrom(repo, new ListBuilder<Object>().add(builderIds).toList());
    }

    public HobbyBuilderSpec<P> people$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		verifyMutable();

		if (this.people == null) {
			this.people = new ArrayList<PersonBuilderSpec<?>>();
		}
		if (builderIds != null) {
	    	for (Object builderId : builderIds) {
	            Object restoredObject = repo.get(builderId);
	            if (restoredObject == null) {
	            	if (repo.isSupportLazy()) {
	            		repo.addObjectStoredListener(builderId, new Procedure() {
	    					public void execute(Object... arguments) {
	    						HobbyBuilderSpec.this.people.add((PersonBuilderSpec<?>)arguments[0]);
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
	                this.people.add((PersonBuilderSpec<?>)restoredObject);
	            }
	    	}
		}
        return this;
    }
}

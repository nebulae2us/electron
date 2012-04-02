package org.nebulae2us.electron.test.builder1.model;

import java.util.*;
import org.nebulae2us.electron.*;
import org.nebulae2us.electron.util.*;

@Builder(destination=Hobby.class)
public class HobbyBuilder<P> implements Wrappable<Hobby> {

	protected final Hobby $$$wrapped;

	protected final P $$$parentBuilder;
	
	public HobbyBuilder() {
		this.$$$wrapped = null;
		this.$$$parentBuilder = null;
	}
	
	public HobbyBuilder(P parentBuilder) {
		this.$$$wrapped = null;
		this.$$$parentBuilder = parentBuilder;
	}

	protected HobbyBuilder(Hobby wrapped) {
		this.$$$wrapped = wrapped;
		this.$$$parentBuilder = null;
	}
	
    public HobbyBuilder<P> storeTo(BuilderRepository repo, Object builderId) {
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

	public HobbyBuilder<P> name(String name) {
		verifyMutable();
		this.name = name;
		return this;
	}

	private List<PersonBuilder<?>> people;
	
	public List<PersonBuilder<?>> getPeople() {
		return people;
	}

	public void setPeople(List<PersonBuilder<?>> people) {
		verifyMutable();
		this.people = people;
	}

	public HobbyBuilder<P> people(PersonBuilder<?> ... people) {
		verifyMutable();
		return people(new ListBuilder<PersonBuilder<?>>().add(people).toList());
	}
	
	public HobbyBuilder<P> people(Collection<PersonBuilder<?>> people) {
		verifyMutable();
		if (this.people == null) {
			this.people = new ArrayList<PersonBuilder<?>>();
		}
		if (people != null) {
			for (PersonBuilder<?> e : people) {
				this.people.add(e);
			}
		}
		return this;
	}

	public PersonBuilder<HobbyBuilder<P>> people$one() {
		verifyMutable();
		if (this.people == null) {
			this.people = new ArrayList<PersonBuilder<?>>();
		}
		
		PersonBuilder<HobbyBuilder<P>> result =
				new PersonBuilder<HobbyBuilder<P>>(this);
		
		this.people.add(result);
		
		return result;
	}

	public class People$$$builder {
		
		public PersonBuilder<People$$$builder> blank$begin() {
			PersonBuilder<People$$$builder> result = new PersonBuilder<People$$$builder>(this);
			HobbyBuilder.this.people.add(result);
			return result;
		}
		
		public HobbyBuilder<P> end() {
			return HobbyBuilder.this;
		}
	}
	
	public People$$$builder people$list() {
		verifyMutable();
		if (this.people == null) {
			this.people = new ArrayList<PersonBuilder<?>>();
		}
		return new People$$$builder();
	}

    public HobbyBuilder<P> people$wrap(Person ... people) {
    	return people$wrap(new ListBuilder<Person>().add(people).toList());
    }

    public HobbyBuilder<P> people$wrap(Collection<Person> people) {
		verifyMutable();

		if (this.people == null) {
			this.people = new ArrayList<PersonBuilder<?>>();
		}
		if (people != null) {
			for (Person e : people) {
				PersonBuilder<?> wrapped = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER).convert(e).to(PersonBuilder.class);
				this.people.add(wrapped);
			}
		}
		return this;
    }
    
    public HobbyBuilder<P> people$restoreFrom(BuilderRepository repo, Object ... builderIds) {
    	return people$restoreFrom(repo, new ListBuilder<Object>().add(builderIds).toList());
    }

    public HobbyBuilder<P> people$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		verifyMutable();

		if (this.people == null) {
			this.people = new ArrayList<PersonBuilder<?>>();
		}
		if (builderIds != null) {
	    	for (Object builderId : builderIds) {
	            Object restoredObject = repo.get(builderId);
	            if (restoredObject == null) {
	            	if (repo.isSupportLazy()) {
	            		repo.addObjectStoredListener(builderId, new Procedure() {
	    					public void execute(Object... arguments) {
	    						HobbyBuilder.this.people.add((PersonBuilder<?>)arguments[0]);
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
	                this.people.add((PersonBuilder<?>)restoredObject);
	            }
	    	}
		}
        return this;
    }
}

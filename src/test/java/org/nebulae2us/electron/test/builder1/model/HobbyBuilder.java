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
		if (wrapped == null) {
			throw new NullPointerException();
		}
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
    	return new Converter(new DestinationClassResolverByAnnotation(), true, Builders.IGNORED_TYPES).convert(this).to(Hobby.class);
    }



	private String name;
	
	public String getName() {
		if (this.$$$wrapped != null && WrapHelper.valueNotSet(this.name, String.class)) {
			Object o = WrapHelper.getValue(this.$$$wrapped, Hobby.class, "name");
			this.name = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER, Builders.IGNORED_TYPES).convert(o).to(String.class);
		}

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
		if (this.$$$wrapped != null && WrapHelper.valueNotSet(this.people, List.class)) {
			Object o = WrapHelper.getValue(this.$$$wrapped, Hobby.class, "people");
			this.people = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER, Builders.IGNORED_TYPES).convert(o).to(List.class);
		}

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
				CollectionUtils.addItem(this.people, e);
			}
		}
		return this;
	}

	public PersonBuilder<? extends HobbyBuilder<P>> people$addPerson() {
		verifyMutable();
		if (this.people == null) {
			this.people = new ArrayList<PersonBuilder<?>>();
		}
		
		PersonBuilder<HobbyBuilder<P>> result =
				new PersonBuilder<HobbyBuilder<P>>(this);
		
		CollectionUtils.addItem(this.people, result);
		
		return result;
	}
	
	public StudentBuilder<? extends HobbyBuilder<P>> people$addStudent() {
		verifyMutable();
		if (this.people == null) {
			this.people = new ArrayList<PersonBuilder<?>>();
		}
		
		StudentBuilder<HobbyBuilder<P>> result =
				new StudentBuilder<HobbyBuilder<P>>(this);
		
		CollectionUtils.addItem(this.people, result);
		
		return result;
	}
	
	public TeacherBuilder<? extends HobbyBuilder<P>> people$addTeacher() {
		verifyMutable();
		if (this.people == null) {
			this.people = new ArrayList<PersonBuilder<?>>();
		}
		
		TeacherBuilder<HobbyBuilder<P>> result =
				new TeacherBuilder<HobbyBuilder<P>>(this);
		
		CollectionUtils.addItem(this.people, result);
		
		return result;
	}
	

	public class People$$$builder<P1 extends HobbyBuilder<P>> {
	
		private final P1 $$$parentBuilder1;
	
		protected People$$$builder(P1 parentBuilder) {
			this.$$$parentBuilder1 = parentBuilder;
		}

		public PersonBuilder<People$$$builder<P1>> person$begin() {
			PersonBuilder<People$$$builder<P1>> result = new PersonBuilder<People$$$builder<P1>>(this);
			CollectionUtils.addItem(HobbyBuilder.this.people, result);
			return result;
		}
		
		public StudentBuilder<People$$$builder<P1>> student$begin() {
			StudentBuilder<People$$$builder<P1>> result = new StudentBuilder<People$$$builder<P1>>(this);
			CollectionUtils.addItem(HobbyBuilder.this.people, result);
			return result;
		}
		
		public TeacherBuilder<People$$$builder<P1>> teacher$begin() {
			TeacherBuilder<People$$$builder<P1>> result = new TeacherBuilder<People$$$builder<P1>>(this);
			CollectionUtils.addItem(HobbyBuilder.this.people, result);
			return result;
		}
		

		public P1 end() {
			return this.$$$parentBuilder1;
		}
	}
	
	public People$$$builder<? extends HobbyBuilder<P>> people$list() {
		verifyMutable();
		if (this.people == null) {
			this.people = new ArrayList<PersonBuilder<?>>();
		}
		return new People$$$builder<HobbyBuilder<P>>(this);
	}

    public HobbyBuilder<P> people$wrap(Person ... people) {
    	return people$wrap(new ListBuilder<Person>().add(people).toList());
    }

    public HobbyBuilder<P> people$wrap(Collection<? extends Person> people) {
		verifyMutable();

		if (this.people == null) {
			this.people = new ArrayList<PersonBuilder<?>>();
		}
		if (people != null) {
			for (Person e : people) {
				PersonBuilder<?> wrapped = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER, Builders.IGNORED_TYPES).convert(e).to(PersonBuilder.class);
				CollectionUtils.addItem(this.people, wrapped);
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
	    						CollectionUtils.addItem(HobbyBuilder.this.people, arguments[0]);
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
	                CollectionUtils.addItem(this.people, restoredObject);
	            }
	    	}
		}
        return this;
    }


    /* CUSTOM CODE *********************************
     * 
     * Put your own custom code below. These codes won't be discarded during generation.
     * 
     */
     
     
     
}

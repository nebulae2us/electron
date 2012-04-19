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
		if (wrapped == null) {
			throw new NullPointerException();
		}
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
    	return new Converter(new DestinationClassResolverByAnnotation(), true).convert(this).to(Hobby.class);
    }



	private String name;
	
	public String getName() {
		if (this.$$$wrapped != null && WrapHelper.valueNotSet(this.name, String.class)) {
			Object o = WrapHelper.getValue(this.$$$wrapped, Hobby.class, "name");
			this.name = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER).convert(o).to(String.class);
		}

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
		if (this.$$$wrapped != null && WrapHelper.valueNotSet(this.people, List.class)) {
			Object o = WrapHelper.getValue(this.$$$wrapped, Hobby.class, "people");
			this.people = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER).convert(o).to(List.class);
		}

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
				CollectionUtils.addItem(this.people, e);
			}
		}
		return this;
	}

	public PersonBuilderSpec<? extends HobbyBuilderSpec<P>> people$addPerson() {
		verifyMutable();
		if (this.people == null) {
			this.people = new ArrayList<PersonBuilderSpec<?>>();
		}
		
		PersonBuilderSpec<HobbyBuilderSpec<P>> result =
				new PersonBuilderSpec<HobbyBuilderSpec<P>>(this);
		
		CollectionUtils.addItem(this.people, result);
		
		return result;
	}
	
	public StudentBuilderSpec<? extends HobbyBuilderSpec<P>> people$addStudent() {
		verifyMutable();
		if (this.people == null) {
			this.people = new ArrayList<PersonBuilderSpec<?>>();
		}
		
		StudentBuilderSpec<HobbyBuilderSpec<P>> result =
				new StudentBuilderSpec<HobbyBuilderSpec<P>>(this);
		
		CollectionUtils.addItem(this.people, result);
		
		return result;
	}
	
	public TeacherBuilderSpec<? extends HobbyBuilderSpec<P>> people$addTeacher() {
		verifyMutable();
		if (this.people == null) {
			this.people = new ArrayList<PersonBuilderSpec<?>>();
		}
		
		TeacherBuilderSpec<HobbyBuilderSpec<P>> result =
				new TeacherBuilderSpec<HobbyBuilderSpec<P>>(this);
		
		CollectionUtils.addItem(this.people, result);
		
		return result;
	}
	

	public class People$$$builder<P1 extends HobbyBuilderSpec<P>> {
	
		private final P1 $$$parentBuilder1;
	
		protected People$$$builder(P1 parentBuilder) {
			this.$$$parentBuilder1 = parentBuilder;
		}

		public PersonBuilderSpec<People$$$builder<P1>> person$begin() {
			PersonBuilderSpec<People$$$builder<P1>> result = new PersonBuilderSpec<People$$$builder<P1>>(this);
			CollectionUtils.addItem(HobbyBuilderSpec.this.people, result);
			return result;
		}
		
		public StudentBuilderSpec<People$$$builder<P1>> student$begin() {
			StudentBuilderSpec<People$$$builder<P1>> result = new StudentBuilderSpec<People$$$builder<P1>>(this);
			CollectionUtils.addItem(HobbyBuilderSpec.this.people, result);
			return result;
		}
		
		public TeacherBuilderSpec<People$$$builder<P1>> teacher$begin() {
			TeacherBuilderSpec<People$$$builder<P1>> result = new TeacherBuilderSpec<People$$$builder<P1>>(this);
			CollectionUtils.addItem(HobbyBuilderSpec.this.people, result);
			return result;
		}
		

		public P1 end() {
			return this.$$$parentBuilder1;
		}
	}
	
	public People$$$builder<? extends HobbyBuilderSpec<P>> people$list() {
		verifyMutable();
		if (this.people == null) {
			this.people = new ArrayList<PersonBuilderSpec<?>>();
		}
		return new People$$$builder<HobbyBuilderSpec<P>>(this);
	}

    public HobbyBuilderSpec<P> people$wrap(Person ... people) {
    	return people$wrap(new ListBuilder<Person>().add(people).toList());
    }

    public HobbyBuilderSpec<P> people$wrap(Collection<? extends Person> people) {
		verifyMutable();

		if (this.people == null) {
			this.people = new ArrayList<PersonBuilderSpec<?>>();
		}
		if (people != null) {
			for (Person e : people) {
				PersonBuilderSpec<?> wrapped = new WrapConverter(BuilderSpecs.DESTINATION_CLASS_RESOLVER).convert(e).to(PersonBuilderSpec.class);
				CollectionUtils.addItem(this.people, wrapped);
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
	    						CollectionUtils.addItem(HobbyBuilderSpec.this.people, arguments[0]);
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

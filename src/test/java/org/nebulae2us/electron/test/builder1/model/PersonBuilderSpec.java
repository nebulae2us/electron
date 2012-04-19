package org.nebulae2us.electron.test.builder1.model;

import java.util.*;
import org.nebulae2us.electron.*;
import org.nebulae2us.electron.util.*;

@Builder(destination=Person.class)
public class PersonBuilderSpec<P> implements Wrappable<Person> {

	protected final Person $$$wrapped;

	protected final P $$$parentBuilder;
	
	public PersonBuilderSpec() {
		this.$$$wrapped = null;
		this.$$$parentBuilder = null;
	}
	
	public PersonBuilderSpec(P parentBuilder) {
		this.$$$wrapped = null;
		this.$$$parentBuilder = parentBuilder;
	}

	protected PersonBuilderSpec(Person wrapped) {
		if (wrapped == null) {
			throw new NullPointerException();
		}
		this.$$$wrapped = wrapped;
		this.$$$parentBuilder = null;
	}
	
    public PersonBuilderSpec<P> storeTo(BuilderRepository repo, Object builderId) {
    	repo.put(builderId, this);
    	return this;
    }

	public Person getWrappedObject() {
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

    public Person toPerson() {
    	return new Converter(new DestinationClassResolverByAnnotation(), true).convert(this).to(Person.class);
    }



	private String name;
	
	public String getName() {
		if (this.$$$wrapped != null && WrapHelper.valueNotSet(this.name, String.class)) {
			Object o = WrapHelper.getValue(this.$$$wrapped, Person.class, "name");
			this.name = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER).convert(o).to(String.class);
		}

		return name;
	}

	public void setName(String name) {
		verifyMutable();
		this.name = name;
	}

	public PersonBuilderSpec<P> name(String name) {
		verifyMutable();
		this.name = name;
		return this;
	}

	private int age;
	
	public int getAge() {
		if (this.$$$wrapped != null && WrapHelper.valueNotSet(this.age, int.class)) {
			Object o = WrapHelper.getValue(this.$$$wrapped, Person.class, "age");
			this.age = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER).convert(o).to(int.class);
		}

		return age;
	}

	public void setAge(int age) {
		verifyMutable();
		this.age = age;
	}

	public PersonBuilderSpec<P> age(int age) {
		verifyMutable();
		this.age = age;
		return this;
	}

	private Gender gender;
	
	public Gender getGender() {
		if (this.$$$wrapped != null && WrapHelper.valueNotSet(this.gender, Gender.class)) {
			Object o = WrapHelper.getValue(this.$$$wrapped, Person.class, "gender");
			this.gender = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER).convert(o).to(Gender.class);
		}

		return gender;
	}

	public void setGender(Gender gender) {
		verifyMutable();
		this.gender = gender;
	}

	public PersonBuilderSpec<P> gender(Gender gender) {
		verifyMutable();
		this.gender = gender;
		return this;
	}

	private PersonBuilderSpec<?> parent;
	
	public PersonBuilderSpec<?> getParent() {
		if (this.$$$wrapped != null && WrapHelper.valueNotSet(this.parent, PersonBuilderSpec.class)) {
			Object o = WrapHelper.getValue(this.$$$wrapped, Person.class, "parent");
			this.parent = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER).convert(o).to(PersonBuilderSpec.class);
		}

		return parent;
	}

	public void setParent(PersonBuilderSpec<?> parent) {
		verifyMutable();
		this.parent = parent;
	}

	public PersonBuilderSpec<P> parent(PersonBuilderSpec<?> parent) {
		verifyMutable();
		this.parent = parent;
		return this;
	}

    public PersonBuilderSpec<P> parent$wrap(Person parent) {
    	verifyMutable();
    	this.parent = new WrapConverter(BuilderSpecs.DESTINATION_CLASS_RESOLVER).convert(parent).to(PersonBuilderSpec.class);
        return this;
    }
    
    public PersonBuilderSpec<P> parent$restoreFrom(BuilderRepository repo, Object builderId) {
    	verifyMutable();
    	
        Object restoredObject = repo.get(builderId);
        if (restoredObject == null) {
        	if (repo.isSupportLazy()) {
        		repo.addObjectStoredListener(builderId, new Procedure() {
					public void execute(Object... arguments) {
						PersonBuilderSpec.this.parent = (PersonBuilderSpec<?>)arguments[0];
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
            this.parent = (PersonBuilderSpec<?>)restoredObject;
        }
        return this;
    }

	public PersonBuilderSpec<? extends PersonBuilderSpec<P>> parent$begin() {
		verifyMutable();
		PersonBuilderSpec<PersonBuilderSpec<P>> result = new PersonBuilderSpec<PersonBuilderSpec<P>>(this);
		this.parent = result;
		return result;
	}

	public StudentBuilderSpec<? extends PersonBuilderSpec<P>> parent$asStudent$begin() {
		verifyMutable();
		StudentBuilderSpec<PersonBuilderSpec<P>> result = new StudentBuilderSpec<PersonBuilderSpec<P>>(this);
		this.parent = result;
		return result;
	}

	public TeacherBuilderSpec<? extends PersonBuilderSpec<P>> parent$asTeacher$begin() {
		verifyMutable();
		TeacherBuilderSpec<PersonBuilderSpec<P>> result = new TeacherBuilderSpec<PersonBuilderSpec<P>>(this);
		this.parent = result;
		return result;
	}

	private List<PersonBuilderSpec<?>> children;
	
	public List<PersonBuilderSpec<?>> getChildren() {
		if (this.$$$wrapped != null && WrapHelper.valueNotSet(this.children, List.class)) {
			Object o = WrapHelper.getValue(this.$$$wrapped, Person.class, "children");
			this.children = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER).convert(o).to(List.class);
		}

		return children;
	}

	public void setChildren(List<PersonBuilderSpec<?>> children) {
		verifyMutable();
		this.children = children;
	}

	public PersonBuilderSpec<P> children(PersonBuilderSpec<?> ... children) {
		verifyMutable();
		return children(new ListBuilder<PersonBuilderSpec<?>>().add(children).toList());
	}
	
	public PersonBuilderSpec<P> children(Collection<PersonBuilderSpec<?>> children) {
		verifyMutable();
		if (this.children == null) {
			this.children = new ArrayList<PersonBuilderSpec<?>>();
		}
		if (children != null) {
			for (PersonBuilderSpec<?> e : children) {
				CollectionUtils.addItem(this.children, e);
			}
		}
		return this;
	}

	public PersonBuilderSpec<? extends PersonBuilderSpec<P>> children$addPerson() {
		verifyMutable();
		if (this.children == null) {
			this.children = new ArrayList<PersonBuilderSpec<?>>();
		}
		
		PersonBuilderSpec<PersonBuilderSpec<P>> result =
				new PersonBuilderSpec<PersonBuilderSpec<P>>(this);
		
		CollectionUtils.addItem(this.children, result);
		
		return result;
	}
	
	public StudentBuilderSpec<? extends PersonBuilderSpec<P>> children$addStudent() {
		verifyMutable();
		if (this.children == null) {
			this.children = new ArrayList<PersonBuilderSpec<?>>();
		}
		
		StudentBuilderSpec<PersonBuilderSpec<P>> result =
				new StudentBuilderSpec<PersonBuilderSpec<P>>(this);
		
		CollectionUtils.addItem(this.children, result);
		
		return result;
	}
	
	public TeacherBuilderSpec<? extends PersonBuilderSpec<P>> children$addTeacher() {
		verifyMutable();
		if (this.children == null) {
			this.children = new ArrayList<PersonBuilderSpec<?>>();
		}
		
		TeacherBuilderSpec<PersonBuilderSpec<P>> result =
				new TeacherBuilderSpec<PersonBuilderSpec<P>>(this);
		
		CollectionUtils.addItem(this.children, result);
		
		return result;
	}
	

	public class Children$$$builder<P1 extends PersonBuilderSpec<P>> {
	
		private final P1 $$$parentBuilder1;
	
		protected Children$$$builder(P1 parentBuilder) {
			this.$$$parentBuilder1 = parentBuilder;
		}

		public PersonBuilderSpec<Children$$$builder<P1>> person$begin() {
			PersonBuilderSpec<Children$$$builder<P1>> result = new PersonBuilderSpec<Children$$$builder<P1>>(this);
			CollectionUtils.addItem(PersonBuilderSpec.this.children, result);
			return result;
		}
		
		public StudentBuilderSpec<Children$$$builder<P1>> student$begin() {
			StudentBuilderSpec<Children$$$builder<P1>> result = new StudentBuilderSpec<Children$$$builder<P1>>(this);
			CollectionUtils.addItem(PersonBuilderSpec.this.children, result);
			return result;
		}
		
		public TeacherBuilderSpec<Children$$$builder<P1>> teacher$begin() {
			TeacherBuilderSpec<Children$$$builder<P1>> result = new TeacherBuilderSpec<Children$$$builder<P1>>(this);
			CollectionUtils.addItem(PersonBuilderSpec.this.children, result);
			return result;
		}
		

		public P1 end() {
			return this.$$$parentBuilder1;
		}
	}
	
	public Children$$$builder<? extends PersonBuilderSpec<P>> children$list() {
		verifyMutable();
		if (this.children == null) {
			this.children = new ArrayList<PersonBuilderSpec<?>>();
		}
		return new Children$$$builder<PersonBuilderSpec<P>>(this);
	}

    public PersonBuilderSpec<P> children$wrap(Person ... children) {
    	return children$wrap(new ListBuilder<Person>().add(children).toList());
    }

    public PersonBuilderSpec<P> children$wrap(Collection<? extends Person> children) {
		verifyMutable();

		if (this.children == null) {
			this.children = new ArrayList<PersonBuilderSpec<?>>();
		}
		if (children != null) {
			for (Person e : children) {
				PersonBuilderSpec<?> wrapped = new WrapConverter(BuilderSpecs.DESTINATION_CLASS_RESOLVER).convert(e).to(PersonBuilderSpec.class);
				CollectionUtils.addItem(this.children, wrapped);
			}
		}
		return this;
    }
    
    public PersonBuilderSpec<P> children$restoreFrom(BuilderRepository repo, Object ... builderIds) {
    	return children$restoreFrom(repo, new ListBuilder<Object>().add(builderIds).toList());
    }

    public PersonBuilderSpec<P> children$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		verifyMutable();

		if (this.children == null) {
			this.children = new ArrayList<PersonBuilderSpec<?>>();
		}
		if (builderIds != null) {
	    	for (Object builderId : builderIds) {
	            Object restoredObject = repo.get(builderId);
	            if (restoredObject == null) {
	            	if (repo.isSupportLazy()) {
	            		repo.addObjectStoredListener(builderId, new Procedure() {
	    					public void execute(Object... arguments) {
	    						CollectionUtils.addItem(PersonBuilderSpec.this.children, arguments[0]);
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
	                CollectionUtils.addItem(this.children, restoredObject);
	            }
	    	}
		}
        return this;
    }


	private List<HobbyBuilderSpec<?>> hobbies;
	
	public List<HobbyBuilderSpec<?>> getHobbies() {
		if (this.$$$wrapped != null && WrapHelper.valueNotSet(this.hobbies, List.class)) {
			Object o = WrapHelper.getValue(this.$$$wrapped, Person.class, "hobbies");
			this.hobbies = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER).convert(o).to(List.class);
		}

		return hobbies;
	}

	public void setHobbies(List<HobbyBuilderSpec<?>> hobbies) {
		verifyMutable();
		this.hobbies = hobbies;
	}

	public PersonBuilderSpec<P> hobbies(HobbyBuilderSpec<?> ... hobbies) {
		verifyMutable();
		return hobbies(new ListBuilder<HobbyBuilderSpec<?>>().add(hobbies).toList());
	}
	
	public PersonBuilderSpec<P> hobbies(Collection<HobbyBuilderSpec<?>> hobbies) {
		verifyMutable();
		if (this.hobbies == null) {
			this.hobbies = new ArrayList<HobbyBuilderSpec<?>>();
		}
		if (hobbies != null) {
			for (HobbyBuilderSpec<?> e : hobbies) {
				CollectionUtils.addItem(this.hobbies, e);
			}
		}
		return this;
	}

	public HobbyBuilderSpec<? extends PersonBuilderSpec<P>> hobbies$addHobby() {
		verifyMutable();
		if (this.hobbies == null) {
			this.hobbies = new ArrayList<HobbyBuilderSpec<?>>();
		}
		
		HobbyBuilderSpec<PersonBuilderSpec<P>> result =
				new HobbyBuilderSpec<PersonBuilderSpec<P>>(this);
		
		CollectionUtils.addItem(this.hobbies, result);
		
		return result;
	}
	

	public class Hobbies$$$builder<P1 extends PersonBuilderSpec<P>> {
	
		private final P1 $$$parentBuilder1;
	
		protected Hobbies$$$builder(P1 parentBuilder) {
			this.$$$parentBuilder1 = parentBuilder;
		}

		public HobbyBuilderSpec<Hobbies$$$builder<P1>> hobby$begin() {
			HobbyBuilderSpec<Hobbies$$$builder<P1>> result = new HobbyBuilderSpec<Hobbies$$$builder<P1>>(this);
			CollectionUtils.addItem(PersonBuilderSpec.this.hobbies, result);
			return result;
		}
		

		public P1 end() {
			return this.$$$parentBuilder1;
		}
	}
	
	public Hobbies$$$builder<? extends PersonBuilderSpec<P>> hobbies$list() {
		verifyMutable();
		if (this.hobbies == null) {
			this.hobbies = new ArrayList<HobbyBuilderSpec<?>>();
		}
		return new Hobbies$$$builder<PersonBuilderSpec<P>>(this);
	}

    public PersonBuilderSpec<P> hobbies$wrap(Hobby ... hobbies) {
    	return hobbies$wrap(new ListBuilder<Hobby>().add(hobbies).toList());
    }

    public PersonBuilderSpec<P> hobbies$wrap(Collection<? extends Hobby> hobbies) {
		verifyMutable();

		if (this.hobbies == null) {
			this.hobbies = new ArrayList<HobbyBuilderSpec<?>>();
		}
		if (hobbies != null) {
			for (Hobby e : hobbies) {
				HobbyBuilderSpec<?> wrapped = new WrapConverter(BuilderSpecs.DESTINATION_CLASS_RESOLVER).convert(e).to(HobbyBuilderSpec.class);
				CollectionUtils.addItem(this.hobbies, wrapped);
			}
		}
		return this;
    }
    
    public PersonBuilderSpec<P> hobbies$restoreFrom(BuilderRepository repo, Object ... builderIds) {
    	return hobbies$restoreFrom(repo, new ListBuilder<Object>().add(builderIds).toList());
    }

    public PersonBuilderSpec<P> hobbies$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		verifyMutable();

		if (this.hobbies == null) {
			this.hobbies = new ArrayList<HobbyBuilderSpec<?>>();
		}
		if (builderIds != null) {
	    	for (Object builderId : builderIds) {
	            Object restoredObject = repo.get(builderId);
	            if (restoredObject == null) {
	            	if (repo.isSupportLazy()) {
	            		repo.addObjectStoredListener(builderId, new Procedure() {
	    					public void execute(Object... arguments) {
	    						CollectionUtils.addItem(PersonBuilderSpec.this.hobbies, arguments[0]);
	    					}
	    				});
	            	}
	            	else {
	                    throw new IllegalStateException("Object does not exist with id " + builderId);
	            	}
	            }
	            else if (!(restoredObject instanceof HobbyBuilderSpec)) {
	            	throw new IllegalStateException("Type mismatch for id: " + builderId + ". " + HobbyBuilderSpec.class.getSimpleName() + " vs " + restoredObject.getClass().getSimpleName());
	            }
	            else {
	                CollectionUtils.addItem(this.hobbies, restoredObject);
	            }
	    	}
		}
        return this;
    }


	private List<SpeechBuilderSpec<?>> speeches;
	
	public List<SpeechBuilderSpec<?>> getSpeeches() {
		if (this.$$$wrapped != null && WrapHelper.valueNotSet(this.speeches, List.class)) {
			Object o = WrapHelper.getValue(this.$$$wrapped, Person.class, "speeches");
			this.speeches = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER).convert(o).to(List.class);
		}

		return speeches;
	}

	public void setSpeeches(List<SpeechBuilderSpec<?>> speeches) {
		verifyMutable();
		this.speeches = speeches;
	}

	public PersonBuilderSpec<P> speeches(SpeechBuilderSpec<?> ... speeches) {
		verifyMutable();
		return speeches(new ListBuilder<SpeechBuilderSpec<?>>().add(speeches).toList());
	}
	
	public PersonBuilderSpec<P> speeches(Collection<SpeechBuilderSpec<?>> speeches) {
		verifyMutable();
		if (this.speeches == null) {
			this.speeches = new ArrayList<SpeechBuilderSpec<?>>();
		}
		if (speeches != null) {
			for (SpeechBuilderSpec<?> e : speeches) {
				CollectionUtils.addItem(this.speeches, e);
			}
		}
		return this;
	}

	public SpeechBuilderSpec<? extends PersonBuilderSpec<P>> speeches$addSpeech() {
		verifyMutable();
		if (this.speeches == null) {
			this.speeches = new ArrayList<SpeechBuilderSpec<?>>();
		}
		
		SpeechBuilderSpec<PersonBuilderSpec<P>> result =
				new SpeechBuilderSpec<PersonBuilderSpec<P>>(this);
		
		CollectionUtils.addItem(this.speeches, result);
		
		return result;
	}
	

	public class Speeches$$$builder<P1 extends PersonBuilderSpec<P>> {
	
		private final P1 $$$parentBuilder1;
	
		protected Speeches$$$builder(P1 parentBuilder) {
			this.$$$parentBuilder1 = parentBuilder;
		}

		public SpeechBuilderSpec<Speeches$$$builder<P1>> speech$begin() {
			SpeechBuilderSpec<Speeches$$$builder<P1>> result = new SpeechBuilderSpec<Speeches$$$builder<P1>>(this);
			CollectionUtils.addItem(PersonBuilderSpec.this.speeches, result);
			return result;
		}
		

		public P1 end() {
			return this.$$$parentBuilder1;
		}
	}
	
	public Speeches$$$builder<? extends PersonBuilderSpec<P>> speeches$list() {
		verifyMutable();
		if (this.speeches == null) {
			this.speeches = new ArrayList<SpeechBuilderSpec<?>>();
		}
		return new Speeches$$$builder<PersonBuilderSpec<P>>(this);
	}

    public PersonBuilderSpec<P> speeches$wrap(Speech ... speeches) {
    	return speeches$wrap(new ListBuilder<Speech>().add(speeches).toList());
    }

    public PersonBuilderSpec<P> speeches$wrap(Collection<? extends Speech> speeches) {
		verifyMutable();

		if (this.speeches == null) {
			this.speeches = new ArrayList<SpeechBuilderSpec<?>>();
		}
		if (speeches != null) {
			for (Speech e : speeches) {
				SpeechBuilderSpec<?> wrapped = new WrapConverter(BuilderSpecs.DESTINATION_CLASS_RESOLVER).convert(e).to(SpeechBuilderSpec.class);
				CollectionUtils.addItem(this.speeches, wrapped);
			}
		}
		return this;
    }
    
    public PersonBuilderSpec<P> speeches$restoreFrom(BuilderRepository repo, Object ... builderIds) {
    	return speeches$restoreFrom(repo, new ListBuilder<Object>().add(builderIds).toList());
    }

    public PersonBuilderSpec<P> speeches$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		verifyMutable();

		if (this.speeches == null) {
			this.speeches = new ArrayList<SpeechBuilderSpec<?>>();
		}
		if (builderIds != null) {
	    	for (Object builderId : builderIds) {
	            Object restoredObject = repo.get(builderId);
	            if (restoredObject == null) {
	            	if (repo.isSupportLazy()) {
	            		repo.addObjectStoredListener(builderId, new Procedure() {
	    					public void execute(Object... arguments) {
	    						CollectionUtils.addItem(PersonBuilderSpec.this.speeches, arguments[0]);
	    					}
	    				});
	            	}
	            	else {
	                    throw new IllegalStateException("Object does not exist with id " + builderId);
	            	}
	            }
	            else if (!(restoredObject instanceof SpeechBuilderSpec)) {
	            	throw new IllegalStateException("Type mismatch for id: " + builderId + ". " + SpeechBuilderSpec.class.getSimpleName() + " vs " + restoredObject.getClass().getSimpleName());
	            }
	            else {
	                CollectionUtils.addItem(this.speeches, restoredObject);
	            }
	    	}
		}
        return this;
    }


	private List<PersonBuilderSpec<?>> friends;
	
	public List<PersonBuilderSpec<?>> getFriends() {
		if (this.$$$wrapped != null && WrapHelper.valueNotSet(this.friends, List.class)) {
			Object o = WrapHelper.getValue(this.$$$wrapped, Person.class, "friends");
			this.friends = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER).convert(o).to(List.class);
		}

		return friends;
	}

	public void setFriends(List<PersonBuilderSpec<?>> friends) {
		verifyMutable();
		this.friends = friends;
	}

	public PersonBuilderSpec<P> friends(PersonBuilderSpec<?> ... friends) {
		verifyMutable();
		return friends(new ListBuilder<PersonBuilderSpec<?>>().add(friends).toList());
	}
	
	public PersonBuilderSpec<P> friends(Collection<PersonBuilderSpec<?>> friends) {
		verifyMutable();
		if (this.friends == null) {
			this.friends = new ArrayList<PersonBuilderSpec<?>>();
		}
		if (friends != null) {
			for (PersonBuilderSpec<?> e : friends) {
				CollectionUtils.addItem(this.friends, e);
			}
		}
		return this;
	}

	public PersonBuilderSpec<? extends PersonBuilderSpec<P>> friends$addPerson() {
		verifyMutable();
		if (this.friends == null) {
			this.friends = new ArrayList<PersonBuilderSpec<?>>();
		}
		
		PersonBuilderSpec<PersonBuilderSpec<P>> result =
				new PersonBuilderSpec<PersonBuilderSpec<P>>(this);
		
		CollectionUtils.addItem(this.friends, result);
		
		return result;
	}
	
	public StudentBuilderSpec<? extends PersonBuilderSpec<P>> friends$addStudent() {
		verifyMutable();
		if (this.friends == null) {
			this.friends = new ArrayList<PersonBuilderSpec<?>>();
		}
		
		StudentBuilderSpec<PersonBuilderSpec<P>> result =
				new StudentBuilderSpec<PersonBuilderSpec<P>>(this);
		
		CollectionUtils.addItem(this.friends, result);
		
		return result;
	}
	
	public TeacherBuilderSpec<? extends PersonBuilderSpec<P>> friends$addTeacher() {
		verifyMutable();
		if (this.friends == null) {
			this.friends = new ArrayList<PersonBuilderSpec<?>>();
		}
		
		TeacherBuilderSpec<PersonBuilderSpec<P>> result =
				new TeacherBuilderSpec<PersonBuilderSpec<P>>(this);
		
		CollectionUtils.addItem(this.friends, result);
		
		return result;
	}
	

	public class Friends$$$builder<P1 extends PersonBuilderSpec<P>> {
	
		private final P1 $$$parentBuilder1;
	
		protected Friends$$$builder(P1 parentBuilder) {
			this.$$$parentBuilder1 = parentBuilder;
		}

		public PersonBuilderSpec<Friends$$$builder<P1>> person$begin() {
			PersonBuilderSpec<Friends$$$builder<P1>> result = new PersonBuilderSpec<Friends$$$builder<P1>>(this);
			CollectionUtils.addItem(PersonBuilderSpec.this.friends, result);
			return result;
		}
		
		public StudentBuilderSpec<Friends$$$builder<P1>> student$begin() {
			StudentBuilderSpec<Friends$$$builder<P1>> result = new StudentBuilderSpec<Friends$$$builder<P1>>(this);
			CollectionUtils.addItem(PersonBuilderSpec.this.friends, result);
			return result;
		}
		
		public TeacherBuilderSpec<Friends$$$builder<P1>> teacher$begin() {
			TeacherBuilderSpec<Friends$$$builder<P1>> result = new TeacherBuilderSpec<Friends$$$builder<P1>>(this);
			CollectionUtils.addItem(PersonBuilderSpec.this.friends, result);
			return result;
		}
		

		public P1 end() {
			return this.$$$parentBuilder1;
		}
	}
	
	public Friends$$$builder<? extends PersonBuilderSpec<P>> friends$list() {
		verifyMutable();
		if (this.friends == null) {
			this.friends = new ArrayList<PersonBuilderSpec<?>>();
		}
		return new Friends$$$builder<PersonBuilderSpec<P>>(this);
	}

    public PersonBuilderSpec<P> friends$wrap(Person ... friends) {
    	return friends$wrap(new ListBuilder<Person>().add(friends).toList());
    }

    public PersonBuilderSpec<P> friends$wrap(Collection<? extends Person> friends) {
		verifyMutable();

		if (this.friends == null) {
			this.friends = new ArrayList<PersonBuilderSpec<?>>();
		}
		if (friends != null) {
			for (Person e : friends) {
				PersonBuilderSpec<?> wrapped = new WrapConverter(BuilderSpecs.DESTINATION_CLASS_RESOLVER).convert(e).to(PersonBuilderSpec.class);
				CollectionUtils.addItem(this.friends, wrapped);
			}
		}
		return this;
    }
    
    public PersonBuilderSpec<P> friends$restoreFrom(BuilderRepository repo, Object ... builderIds) {
    	return friends$restoreFrom(repo, new ListBuilder<Object>().add(builderIds).toList());
    }

    public PersonBuilderSpec<P> friends$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		verifyMutable();

		if (this.friends == null) {
			this.friends = new ArrayList<PersonBuilderSpec<?>>();
		}
		if (builderIds != null) {
	    	for (Object builderId : builderIds) {
	            Object restoredObject = repo.get(builderId);
	            if (restoredObject == null) {
	            	if (repo.isSupportLazy()) {
	            		repo.addObjectStoredListener(builderId, new Procedure() {
	    					public void execute(Object... arguments) {
	    						CollectionUtils.addItem(PersonBuilderSpec.this.friends, arguments[0]);
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
	                CollectionUtils.addItem(this.friends, restoredObject);
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

package org.nebulae2us.electron.test.builder1.model;

import java.util.*;
import org.nebulae2us.electron.*;
import org.nebulae2us.electron.util.*;

@Builder(destination=Person.class)
public class PersonBuilder<P> implements Wrappable<Person> {

	protected final Person $$$wrapped;

	protected final P $$$parentBuilder;
	
	public PersonBuilder() {
		this.$$$wrapped = null;
		this.$$$parentBuilder = null;
	}
	
	public PersonBuilder(P parentBuilder) {
		this.$$$wrapped = null;
		this.$$$parentBuilder = parentBuilder;
	}

	protected PersonBuilder(Person wrapped) {
		this.$$$wrapped = wrapped;
		this.$$$parentBuilder = null;
	}
	
    public PersonBuilder<P> storeTo(BuilderRepository repo, Object builderId) {
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
    	return new Converter(new BuilderAnnotationDestinationClassResolver(), true).convert(this).to(Person.class);
    }



	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		verifyMutable();
		this.name = name;
	}

	public PersonBuilder<P> name(String name) {
		verifyMutable();
		this.name = name;
		return this;
	}

	private int age;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		verifyMutable();
		this.age = age;
	}

	public PersonBuilder<P> age(int age) {
		verifyMutable();
		this.age = age;
		return this;
	}

	private Gender gender;
	
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		verifyMutable();
		this.gender = gender;
	}

	public PersonBuilder<P> gender(Gender gender) {
		verifyMutable();
		this.gender = gender;
		return this;
	}

	private PersonBuilder<?> parent;
	
	public PersonBuilder<?> getParent() {
		return parent;
	}

	public void setParent(PersonBuilder<?> parent) {
		verifyMutable();
		this.parent = parent;
	}

	public PersonBuilder<P> parent(PersonBuilder<?> parent) {
		verifyMutable();
		this.parent = parent;
		return this;
	}

    public PersonBuilder<P> parent$wrap(Person parent) {
    	verifyMutable();
    	this.parent = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER).convert(parent).to(PersonBuilder.class);
        return this;
    }
    
    public PersonBuilder<P> parent$restoreFrom(BuilderRepository repo, Object builderId) {
    	verifyMutable();
    	
        Object restoredObject = repo.get(builderId);
        if (restoredObject == null) {
        	if (repo.isSupportLazy()) {
        		repo.addObjectStoredListener(builderId, new Procedure() {
					public void execute(Object... arguments) {
						PersonBuilder.this.parent = (PersonBuilder<?>)arguments[0];
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
            this.parent = (PersonBuilder<?>)restoredObject;
        }
        return this;
    }

	public PersonBuilder<? extends PersonBuilder<P>> parent$begin() {
		verifyMutable();
		PersonBuilder<PersonBuilder<P>> result = new PersonBuilder<PersonBuilder<P>>(this);
		this.parent = result;
		return result;
	}

	public StudentBuilder<? extends PersonBuilder<P>> parent$asStudent$begin() {
		verifyMutable();
		StudentBuilder<PersonBuilder<P>> result = new StudentBuilder<PersonBuilder<P>>(this);
		this.parent = result;
		return result;
	}

	public TeacherBuilder<? extends PersonBuilder<P>> parent$asTeacher$begin() {
		verifyMutable();
		TeacherBuilder<PersonBuilder<P>> result = new TeacherBuilder<PersonBuilder<P>>(this);
		this.parent = result;
		return result;
	}

	private List<PersonBuilder<?>> children;
	
	public List<PersonBuilder<?>> getChildren() {
		return children;
	}

	public void setChildren(List<PersonBuilder<?>> children) {
		verifyMutable();
		this.children = children;
	}

	public PersonBuilder<P> children(PersonBuilder<?> ... children) {
		verifyMutable();
		return children(new ListBuilder<PersonBuilder<?>>().add(children).toList());
	}
	
	public PersonBuilder<P> children(Collection<PersonBuilder<?>> children) {
		verifyMutable();
		if (this.children == null) {
			this.children = new ArrayList<PersonBuilder<?>>();
		}
		if (children != null) {
			for (PersonBuilder<?> e : children) {
				CollectionUtils.addItem(this.children, e);
			}
		}
		return this;
	}

	public PersonBuilder<? extends PersonBuilder<P>> children$addPerson() {
		verifyMutable();
		if (this.children == null) {
			this.children = new ArrayList<PersonBuilder<?>>();
		}
		
		PersonBuilder<PersonBuilder<P>> result =
				new PersonBuilder<PersonBuilder<P>>(this);
		
		CollectionUtils.addItem(this.children, result);
		
		return result;
	}
	
	public StudentBuilder<? extends PersonBuilder<P>> children$addStudent() {
		verifyMutable();
		if (this.children == null) {
			this.children = new ArrayList<PersonBuilder<?>>();
		}
		
		StudentBuilder<PersonBuilder<P>> result =
				new StudentBuilder<PersonBuilder<P>>(this);
		
		CollectionUtils.addItem(this.children, result);
		
		return result;
	}
	
	public TeacherBuilder<? extends PersonBuilder<P>> children$addTeacher() {
		verifyMutable();
		if (this.children == null) {
			this.children = new ArrayList<PersonBuilder<?>>();
		}
		
		TeacherBuilder<PersonBuilder<P>> result =
				new TeacherBuilder<PersonBuilder<P>>(this);
		
		CollectionUtils.addItem(this.children, result);
		
		return result;
	}
	

	public class Children$$$builder<P1 extends PersonBuilder<P>> {
	
		private final P1 $$$parentBuilder1;
	
		protected Children$$$builder(P1 parentBuilder) {
			this.$$$parentBuilder1 = parentBuilder;
		}

		public PersonBuilder<Children$$$builder<P1>> person$begin() {
			PersonBuilder<Children$$$builder<P1>> result = new PersonBuilder<Children$$$builder<P1>>(this);
			CollectionUtils.addItem(PersonBuilder.this.children, result);
			return result;
		}
		
		public StudentBuilder<Children$$$builder<P1>> student$begin() {
			StudentBuilder<Children$$$builder<P1>> result = new StudentBuilder<Children$$$builder<P1>>(this);
			CollectionUtils.addItem(PersonBuilder.this.children, result);
			return result;
		}
		
		public TeacherBuilder<Children$$$builder<P1>> teacher$begin() {
			TeacherBuilder<Children$$$builder<P1>> result = new TeacherBuilder<Children$$$builder<P1>>(this);
			CollectionUtils.addItem(PersonBuilder.this.children, result);
			return result;
		}
		

		public P1 end() {
			return this.$$$parentBuilder1;
		}
	}
	
	public Children$$$builder<? extends PersonBuilder<P>> children$list() {
		verifyMutable();
		if (this.children == null) {
			this.children = new ArrayList<PersonBuilder<?>>();
		}
		return new Children$$$builder<PersonBuilder<P>>(this);
	}

    public PersonBuilder<P> children$wrap(Person ... children) {
    	return children$wrap(new ListBuilder<Person>().add(children).toList());
    }

    public PersonBuilder<P> children$wrap(Collection<? extends Person> children) {
		verifyMutable();

		if (this.children == null) {
			this.children = new ArrayList<PersonBuilder<?>>();
		}
		if (children != null) {
			for (Person e : children) {
				PersonBuilder<?> wrapped = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER).convert(e).to(PersonBuilder.class);
				CollectionUtils.addItem(this.children, wrapped);
			}
		}
		return this;
    }
    
    public PersonBuilder<P> children$restoreFrom(BuilderRepository repo, Object ... builderIds) {
    	return children$restoreFrom(repo, new ListBuilder<Object>().add(builderIds).toList());
    }

    public PersonBuilder<P> children$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		verifyMutable();

		if (this.children == null) {
			this.children = new ArrayList<PersonBuilder<?>>();
		}
		if (builderIds != null) {
	    	for (Object builderId : builderIds) {
	            Object restoredObject = repo.get(builderId);
	            if (restoredObject == null) {
	            	if (repo.isSupportLazy()) {
	            		repo.addObjectStoredListener(builderId, new Procedure() {
	    					public void execute(Object... arguments) {
	    						CollectionUtils.addItem(PersonBuilder.this.children, arguments[0]);
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
	                CollectionUtils.addItem(this.children, restoredObject);
	            }
	    	}
		}
        return this;
    }


	private List<HobbyBuilder<?>> hobbies;
	
	public List<HobbyBuilder<?>> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<HobbyBuilder<?>> hobbies) {
		verifyMutable();
		this.hobbies = hobbies;
	}

	public PersonBuilder<P> hobbies(HobbyBuilder<?> ... hobbies) {
		verifyMutable();
		return hobbies(new ListBuilder<HobbyBuilder<?>>().add(hobbies).toList());
	}
	
	public PersonBuilder<P> hobbies(Collection<HobbyBuilder<?>> hobbies) {
		verifyMutable();
		if (this.hobbies == null) {
			this.hobbies = new ArrayList<HobbyBuilder<?>>();
		}
		if (hobbies != null) {
			for (HobbyBuilder<?> e : hobbies) {
				CollectionUtils.addItem(this.hobbies, e);
			}
		}
		return this;
	}

	public HobbyBuilder<? extends PersonBuilder<P>> hobbies$addHobby() {
		verifyMutable();
		if (this.hobbies == null) {
			this.hobbies = new ArrayList<HobbyBuilder<?>>();
		}
		
		HobbyBuilder<PersonBuilder<P>> result =
				new HobbyBuilder<PersonBuilder<P>>(this);
		
		CollectionUtils.addItem(this.hobbies, result);
		
		return result;
	}
	

	public class Hobbies$$$builder<P1 extends PersonBuilder<P>> {
	
		private final P1 $$$parentBuilder1;
	
		protected Hobbies$$$builder(P1 parentBuilder) {
			this.$$$parentBuilder1 = parentBuilder;
		}

		public HobbyBuilder<Hobbies$$$builder<P1>> hobby$begin() {
			HobbyBuilder<Hobbies$$$builder<P1>> result = new HobbyBuilder<Hobbies$$$builder<P1>>(this);
			CollectionUtils.addItem(PersonBuilder.this.hobbies, result);
			return result;
		}
		

		public P1 end() {
			return this.$$$parentBuilder1;
		}
	}
	
	public Hobbies$$$builder<? extends PersonBuilder<P>> hobbies$list() {
		verifyMutable();
		if (this.hobbies == null) {
			this.hobbies = new ArrayList<HobbyBuilder<?>>();
		}
		return new Hobbies$$$builder<PersonBuilder<P>>(this);
	}

    public PersonBuilder<P> hobbies$wrap(Hobby ... hobbies) {
    	return hobbies$wrap(new ListBuilder<Hobby>().add(hobbies).toList());
    }

    public PersonBuilder<P> hobbies$wrap(Collection<? extends Hobby> hobbies) {
		verifyMutable();

		if (this.hobbies == null) {
			this.hobbies = new ArrayList<HobbyBuilder<?>>();
		}
		if (hobbies != null) {
			for (Hobby e : hobbies) {
				HobbyBuilder<?> wrapped = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER).convert(e).to(HobbyBuilder.class);
				CollectionUtils.addItem(this.hobbies, wrapped);
			}
		}
		return this;
    }
    
    public PersonBuilder<P> hobbies$restoreFrom(BuilderRepository repo, Object ... builderIds) {
    	return hobbies$restoreFrom(repo, new ListBuilder<Object>().add(builderIds).toList());
    }

    public PersonBuilder<P> hobbies$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		verifyMutable();

		if (this.hobbies == null) {
			this.hobbies = new ArrayList<HobbyBuilder<?>>();
		}
		if (builderIds != null) {
	    	for (Object builderId : builderIds) {
	            Object restoredObject = repo.get(builderId);
	            if (restoredObject == null) {
	            	if (repo.isSupportLazy()) {
	            		repo.addObjectStoredListener(builderId, new Procedure() {
	    					public void execute(Object... arguments) {
	    						CollectionUtils.addItem(PersonBuilder.this.hobbies, arguments[0]);
	    					}
	    				});
	            	}
	            	else {
	                    throw new IllegalStateException("Object does not exist with id " + builderId);
	            	}
	            }
	            else if (!(restoredObject instanceof HobbyBuilder)) {
	            	throw new IllegalStateException("Type mismatch for id: " + builderId + ". " + HobbyBuilder.class.getSimpleName() + " vs " + restoredObject.getClass().getSimpleName());
	            }
	            else {
	                CollectionUtils.addItem(this.hobbies, restoredObject);
	            }
	    	}
		}
        return this;
    }


	private List<SpeechBuilder<?>> speeches;
	
	public List<SpeechBuilder<?>> getSpeeches() {
		return speeches;
	}

	public void setSpeeches(List<SpeechBuilder<?>> speeches) {
		verifyMutable();
		this.speeches = speeches;
	}

	public PersonBuilder<P> speeches(SpeechBuilder<?> ... speeches) {
		verifyMutable();
		return speeches(new ListBuilder<SpeechBuilder<?>>().add(speeches).toList());
	}
	
	public PersonBuilder<P> speeches(Collection<SpeechBuilder<?>> speeches) {
		verifyMutable();
		if (this.speeches == null) {
			this.speeches = new ArrayList<SpeechBuilder<?>>();
		}
		if (speeches != null) {
			for (SpeechBuilder<?> e : speeches) {
				CollectionUtils.addItem(this.speeches, e);
			}
		}
		return this;
	}

	public SpeechBuilder<? extends PersonBuilder<P>> speeches$addSpeech() {
		verifyMutable();
		if (this.speeches == null) {
			this.speeches = new ArrayList<SpeechBuilder<?>>();
		}
		
		SpeechBuilder<PersonBuilder<P>> result =
				new SpeechBuilder<PersonBuilder<P>>(this);
		
		CollectionUtils.addItem(this.speeches, result);
		
		return result;
	}
	

	public class Speeches$$$builder<P1 extends PersonBuilder<P>> {
	
		private final P1 $$$parentBuilder1;
	
		protected Speeches$$$builder(P1 parentBuilder) {
			this.$$$parentBuilder1 = parentBuilder;
		}

		public SpeechBuilder<Speeches$$$builder<P1>> speech$begin() {
			SpeechBuilder<Speeches$$$builder<P1>> result = new SpeechBuilder<Speeches$$$builder<P1>>(this);
			CollectionUtils.addItem(PersonBuilder.this.speeches, result);
			return result;
		}
		

		public P1 end() {
			return this.$$$parentBuilder1;
		}
	}
	
	public Speeches$$$builder<? extends PersonBuilder<P>> speeches$list() {
		verifyMutable();
		if (this.speeches == null) {
			this.speeches = new ArrayList<SpeechBuilder<?>>();
		}
		return new Speeches$$$builder<PersonBuilder<P>>(this);
	}

    public PersonBuilder<P> speeches$wrap(Speech ... speeches) {
    	return speeches$wrap(new ListBuilder<Speech>().add(speeches).toList());
    }

    public PersonBuilder<P> speeches$wrap(Collection<? extends Speech> speeches) {
		verifyMutable();

		if (this.speeches == null) {
			this.speeches = new ArrayList<SpeechBuilder<?>>();
		}
		if (speeches != null) {
			for (Speech e : speeches) {
				SpeechBuilder<?> wrapped = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER).convert(e).to(SpeechBuilder.class);
				CollectionUtils.addItem(this.speeches, wrapped);
			}
		}
		return this;
    }
    
    public PersonBuilder<P> speeches$restoreFrom(BuilderRepository repo, Object ... builderIds) {
    	return speeches$restoreFrom(repo, new ListBuilder<Object>().add(builderIds).toList());
    }

    public PersonBuilder<P> speeches$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		verifyMutable();

		if (this.speeches == null) {
			this.speeches = new ArrayList<SpeechBuilder<?>>();
		}
		if (builderIds != null) {
	    	for (Object builderId : builderIds) {
	            Object restoredObject = repo.get(builderId);
	            if (restoredObject == null) {
	            	if (repo.isSupportLazy()) {
	            		repo.addObjectStoredListener(builderId, new Procedure() {
	    					public void execute(Object... arguments) {
	    						CollectionUtils.addItem(PersonBuilder.this.speeches, arguments[0]);
	    					}
	    				});
	            	}
	            	else {
	                    throw new IllegalStateException("Object does not exist with id " + builderId);
	            	}
	            }
	            else if (!(restoredObject instanceof SpeechBuilder)) {
	            	throw new IllegalStateException("Type mismatch for id: " + builderId + ". " + SpeechBuilder.class.getSimpleName() + " vs " + restoredObject.getClass().getSimpleName());
	            }
	            else {
	                CollectionUtils.addItem(this.speeches, restoredObject);
	            }
	    	}
		}
        return this;
    }


	private List<PersonBuilder<?>> friends;
	
	public List<PersonBuilder<?>> getFriends() {
		return friends;
	}

	public void setFriends(List<PersonBuilder<?>> friends) {
		verifyMutable();
		this.friends = friends;
	}

	public PersonBuilder<P> friends(PersonBuilder<?> ... friends) {
		verifyMutable();
		return friends(new ListBuilder<PersonBuilder<?>>().add(friends).toList());
	}
	
	public PersonBuilder<P> friends(Collection<PersonBuilder<?>> friends) {
		verifyMutable();
		if (this.friends == null) {
			this.friends = new ArrayList<PersonBuilder<?>>();
		}
		if (friends != null) {
			for (PersonBuilder<?> e : friends) {
				CollectionUtils.addItem(this.friends, e);
			}
		}
		return this;
	}

	public PersonBuilder<? extends PersonBuilder<P>> friends$addPerson() {
		verifyMutable();
		if (this.friends == null) {
			this.friends = new ArrayList<PersonBuilder<?>>();
		}
		
		PersonBuilder<PersonBuilder<P>> result =
				new PersonBuilder<PersonBuilder<P>>(this);
		
		CollectionUtils.addItem(this.friends, result);
		
		return result;
	}
	
	public StudentBuilder<? extends PersonBuilder<P>> friends$addStudent() {
		verifyMutable();
		if (this.friends == null) {
			this.friends = new ArrayList<PersonBuilder<?>>();
		}
		
		StudentBuilder<PersonBuilder<P>> result =
				new StudentBuilder<PersonBuilder<P>>(this);
		
		CollectionUtils.addItem(this.friends, result);
		
		return result;
	}
	
	public TeacherBuilder<? extends PersonBuilder<P>> friends$addTeacher() {
		verifyMutable();
		if (this.friends == null) {
			this.friends = new ArrayList<PersonBuilder<?>>();
		}
		
		TeacherBuilder<PersonBuilder<P>> result =
				new TeacherBuilder<PersonBuilder<P>>(this);
		
		CollectionUtils.addItem(this.friends, result);
		
		return result;
	}
	

	public class Friends$$$builder<P1 extends PersonBuilder<P>> {
	
		private final P1 $$$parentBuilder1;
	
		protected Friends$$$builder(P1 parentBuilder) {
			this.$$$parentBuilder1 = parentBuilder;
		}

		public PersonBuilder<Friends$$$builder<P1>> person$begin() {
			PersonBuilder<Friends$$$builder<P1>> result = new PersonBuilder<Friends$$$builder<P1>>(this);
			CollectionUtils.addItem(PersonBuilder.this.friends, result);
			return result;
		}
		
		public StudentBuilder<Friends$$$builder<P1>> student$begin() {
			StudentBuilder<Friends$$$builder<P1>> result = new StudentBuilder<Friends$$$builder<P1>>(this);
			CollectionUtils.addItem(PersonBuilder.this.friends, result);
			return result;
		}
		
		public TeacherBuilder<Friends$$$builder<P1>> teacher$begin() {
			TeacherBuilder<Friends$$$builder<P1>> result = new TeacherBuilder<Friends$$$builder<P1>>(this);
			CollectionUtils.addItem(PersonBuilder.this.friends, result);
			return result;
		}
		

		public P1 end() {
			return this.$$$parentBuilder1;
		}
	}
	
	public Friends$$$builder<? extends PersonBuilder<P>> friends$list() {
		verifyMutable();
		if (this.friends == null) {
			this.friends = new ArrayList<PersonBuilder<?>>();
		}
		return new Friends$$$builder<PersonBuilder<P>>(this);
	}

    public PersonBuilder<P> friends$wrap(Person ... friends) {
    	return friends$wrap(new ListBuilder<Person>().add(friends).toList());
    }

    public PersonBuilder<P> friends$wrap(Collection<? extends Person> friends) {
		verifyMutable();

		if (this.friends == null) {
			this.friends = new ArrayList<PersonBuilder<?>>();
		}
		if (friends != null) {
			for (Person e : friends) {
				PersonBuilder<?> wrapped = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER).convert(e).to(PersonBuilder.class);
				CollectionUtils.addItem(this.friends, wrapped);
			}
		}
		return this;
    }
    
    public PersonBuilder<P> friends$restoreFrom(BuilderRepository repo, Object ... builderIds) {
    	return friends$restoreFrom(repo, new ListBuilder<Object>().add(builderIds).toList());
    }

    public PersonBuilder<P> friends$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		verifyMutable();

		if (this.friends == null) {
			this.friends = new ArrayList<PersonBuilder<?>>();
		}
		if (builderIds != null) {
	    	for (Object builderId : builderIds) {
	            Object restoredObject = repo.get(builderId);
	            if (restoredObject == null) {
	            	if (repo.isSupportLazy()) {
	            		repo.addObjectStoredListener(builderId, new Procedure() {
	    					public void execute(Object... arguments) {
	    						CollectionUtils.addItem(PersonBuilder.this.friends, arguments[0]);
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
	                CollectionUtils.addItem(this.friends, restoredObject);
	            }
	    	}
		}
        return this;
    }

}

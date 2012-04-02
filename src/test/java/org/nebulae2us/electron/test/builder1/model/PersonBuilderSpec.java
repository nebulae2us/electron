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

	public PersonBuilderSpec<P> name(String name) {
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

	public PersonBuilderSpec<P> age(int age) {
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

	public PersonBuilderSpec<P> gender(Gender gender) {
		verifyMutable();
		this.gender = gender;
		return this;
	}

	private PersonBuilderSpec<?> parent;
	
	public PersonBuilderSpec<?> getParent() {
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

	private List<PersonBuilderSpec<?>> children;
	
	public List<PersonBuilderSpec<?>> getChildren() {
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
				this.children.add(e);
			}
		}
		return this;
	}

	public PersonBuilderSpec<PersonBuilderSpec<P>> children$one() {
		verifyMutable();
		if (this.children == null) {
			this.children = new ArrayList<PersonBuilderSpec<?>>();
		}
		
		PersonBuilderSpec<PersonBuilderSpec<P>> result =
				new PersonBuilderSpec<PersonBuilderSpec<P>>(this);
		
		this.children.add(result);
		
		return result;
	}

	public class Children$$$builder {
		
		public PersonBuilderSpec<Children$$$builder> blank$begin() {
			PersonBuilderSpec<Children$$$builder> result = new PersonBuilderSpec<Children$$$builder>(this);
			PersonBuilderSpec.this.children.add(result);
			return result;
		}
		
		public PersonBuilderSpec<P> end() {
			return PersonBuilderSpec.this;
		}
	}
	
	public Children$$$builder children$list() {
		verifyMutable();
		if (this.children == null) {
			this.children = new ArrayList<PersonBuilderSpec<?>>();
		}
		return new Children$$$builder();
	}

    public PersonBuilderSpec<P> children$wrap(Person ... children) {
    	return children$wrap(new ListBuilder<Person>().add(children).toList());
    }

    public PersonBuilderSpec<P> children$wrap(Collection<Person> children) {
		verifyMutable();

		if (this.children == null) {
			this.children = new ArrayList<PersonBuilderSpec<?>>();
		}
		if (children != null) {
			for (Person e : children) {
				PersonBuilderSpec<?> wrapped = new WrapConverter(BuilderSpecs.DESTINATION_CLASS_RESOLVER).convert(e).to(PersonBuilderSpec.class);
				this.children.add(wrapped);
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
	    						PersonBuilderSpec.this.children.add((PersonBuilderSpec<?>)arguments[0]);
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
	                this.children.add((PersonBuilderSpec<?>)restoredObject);
	            }
	    	}
		}
        return this;
    }

	private List<HobbyBuilderSpec<?>> hobbies;
	
	public List<HobbyBuilderSpec<?>> getHobbies() {
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
				this.hobbies.add(e);
			}
		}
		return this;
	}

	public HobbyBuilderSpec<PersonBuilderSpec<P>> hobbies$one() {
		verifyMutable();
		if (this.hobbies == null) {
			this.hobbies = new ArrayList<HobbyBuilderSpec<?>>();
		}
		
		HobbyBuilderSpec<PersonBuilderSpec<P>> result =
				new HobbyBuilderSpec<PersonBuilderSpec<P>>(this);
		
		this.hobbies.add(result);
		
		return result;
	}

	public class Hobbies$$$builder {
		
		public HobbyBuilderSpec<Hobbies$$$builder> blank$begin() {
			HobbyBuilderSpec<Hobbies$$$builder> result = new HobbyBuilderSpec<Hobbies$$$builder>(this);
			PersonBuilderSpec.this.hobbies.add(result);
			return result;
		}
		
		public PersonBuilderSpec<P> end() {
			return PersonBuilderSpec.this;
		}
	}
	
	public Hobbies$$$builder hobbies$list() {
		verifyMutable();
		if (this.hobbies == null) {
			this.hobbies = new ArrayList<HobbyBuilderSpec<?>>();
		}
		return new Hobbies$$$builder();
	}

    public PersonBuilderSpec<P> hobbies$wrap(Hobby ... hobbies) {
    	return hobbies$wrap(new ListBuilder<Hobby>().add(hobbies).toList());
    }

    public PersonBuilderSpec<P> hobbies$wrap(Collection<Hobby> hobbies) {
		verifyMutable();

		if (this.hobbies == null) {
			this.hobbies = new ArrayList<HobbyBuilderSpec<?>>();
		}
		if (hobbies != null) {
			for (Hobby e : hobbies) {
				HobbyBuilderSpec<?> wrapped = new WrapConverter(BuilderSpecs.DESTINATION_CLASS_RESOLVER).convert(e).to(HobbyBuilderSpec.class);
				this.hobbies.add(wrapped);
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
	    						PersonBuilderSpec.this.hobbies.add((HobbyBuilderSpec<?>)arguments[0]);
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
	                this.hobbies.add((HobbyBuilderSpec<?>)restoredObject);
	            }
	    	}
		}
        return this;
    }

	private List<SpeechBuilderSpec<?>> speeches;
	
	public List<SpeechBuilderSpec<?>> getSpeeches() {
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
				this.speeches.add(e);
			}
		}
		return this;
	}

	public SpeechBuilderSpec<PersonBuilderSpec<P>> speeches$one() {
		verifyMutable();
		if (this.speeches == null) {
			this.speeches = new ArrayList<SpeechBuilderSpec<?>>();
		}
		
		SpeechBuilderSpec<PersonBuilderSpec<P>> result =
				new SpeechBuilderSpec<PersonBuilderSpec<P>>(this);
		
		this.speeches.add(result);
		
		return result;
	}

	public class Speeches$$$builder {
		
		public SpeechBuilderSpec<Speeches$$$builder> blank$begin() {
			SpeechBuilderSpec<Speeches$$$builder> result = new SpeechBuilderSpec<Speeches$$$builder>(this);
			PersonBuilderSpec.this.speeches.add(result);
			return result;
		}
		
		public PersonBuilderSpec<P> end() {
			return PersonBuilderSpec.this;
		}
	}
	
	public Speeches$$$builder speeches$list() {
		verifyMutable();
		if (this.speeches == null) {
			this.speeches = new ArrayList<SpeechBuilderSpec<?>>();
		}
		return new Speeches$$$builder();
	}

    public PersonBuilderSpec<P> speeches$wrap(Speech ... speeches) {
    	return speeches$wrap(new ListBuilder<Speech>().add(speeches).toList());
    }

    public PersonBuilderSpec<P> speeches$wrap(Collection<Speech> speeches) {
		verifyMutable();

		if (this.speeches == null) {
			this.speeches = new ArrayList<SpeechBuilderSpec<?>>();
		}
		if (speeches != null) {
			for (Speech e : speeches) {
				SpeechBuilderSpec<?> wrapped = new WrapConverter(BuilderSpecs.DESTINATION_CLASS_RESOLVER).convert(e).to(SpeechBuilderSpec.class);
				this.speeches.add(wrapped);
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
	    						PersonBuilderSpec.this.speeches.add((SpeechBuilderSpec<?>)arguments[0]);
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
	                this.speeches.add((SpeechBuilderSpec<?>)restoredObject);
	            }
	    	}
		}
        return this;
    }

	private List<PersonBuilderSpec<?>> friends;
	
	public List<PersonBuilderSpec<?>> getFriends() {
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
				this.friends.add(e);
			}
		}
		return this;
	}

	public PersonBuilderSpec<PersonBuilderSpec<P>> friends$one() {
		verifyMutable();
		if (this.friends == null) {
			this.friends = new ArrayList<PersonBuilderSpec<?>>();
		}
		
		PersonBuilderSpec<PersonBuilderSpec<P>> result =
				new PersonBuilderSpec<PersonBuilderSpec<P>>(this);
		
		this.friends.add(result);
		
		return result;
	}

	public class Friends$$$builder {
		
		public PersonBuilderSpec<Friends$$$builder> blank$begin() {
			PersonBuilderSpec<Friends$$$builder> result = new PersonBuilderSpec<Friends$$$builder>(this);
			PersonBuilderSpec.this.friends.add(result);
			return result;
		}
		
		public PersonBuilderSpec<P> end() {
			return PersonBuilderSpec.this;
		}
	}
	
	public Friends$$$builder friends$list() {
		verifyMutable();
		if (this.friends == null) {
			this.friends = new ArrayList<PersonBuilderSpec<?>>();
		}
		return new Friends$$$builder();
	}

    public PersonBuilderSpec<P> friends$wrap(Person ... friends) {
    	return friends$wrap(new ListBuilder<Person>().add(friends).toList());
    }

    public PersonBuilderSpec<P> friends$wrap(Collection<Person> friends) {
		verifyMutable();

		if (this.friends == null) {
			this.friends = new ArrayList<PersonBuilderSpec<?>>();
		}
		if (friends != null) {
			for (Person e : friends) {
				PersonBuilderSpec<?> wrapped = new WrapConverter(BuilderSpecs.DESTINATION_CLASS_RESOLVER).convert(e).to(PersonBuilderSpec.class);
				this.friends.add(wrapped);
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
	    						PersonBuilderSpec.this.friends.add((PersonBuilderSpec<?>)arguments[0]);
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
	                this.friends.add((PersonBuilderSpec<?>)restoredObject);
	            }
	    	}
		}
        return this;
    }
}

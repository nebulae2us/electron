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

	public PersonBuilder<? extends PersonBuilder<P>> parent$begin() {
		PersonBuilder<PersonBuilder<P>> result = new PersonBuilder<PersonBuilder<P>>(this);
		this.parent = result;
		return result;
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
				this.children.add(e);
			}
		}
		return this;
	}

	public PersonBuilder<PersonBuilder<P>> children$one() {
		verifyMutable();
		if (this.children == null) {
			this.children = new ArrayList<PersonBuilder<?>>();
		}
		
		PersonBuilder<PersonBuilder<P>> result =
				new PersonBuilder<PersonBuilder<P>>(this);
		
		this.children.add(result);
		
		return result;
	}

	public class Children$$$builder {
		
		public PersonBuilder<Children$$$builder> blank$begin() {
			PersonBuilder<Children$$$builder> result = new PersonBuilder<Children$$$builder>(this);
			PersonBuilder.this.children.add(result);
			return result;
		}
		
		public PersonBuilder<P> end() {
			return PersonBuilder.this;
		}
	}
	
	public Children$$$builder children$list() {
		verifyMutable();
		if (this.children == null) {
			this.children = new ArrayList<PersonBuilder<?>>();
		}
		return new Children$$$builder();
	}

    public PersonBuilder<P> children$wrap(Person ... children) {
    	return children$wrap(new ListBuilder<Person>().add(children).toList());
    }

    public PersonBuilder<P> children$wrap(Collection<Person> children) {
		verifyMutable();

		if (this.children == null) {
			this.children = new ArrayList<PersonBuilder<?>>();
		}
		if (children != null) {
			for (Person e : children) {
				PersonBuilder<?> wrapped = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER).convert(e).to(PersonBuilder.class);
				this.children.add(wrapped);
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
	    						PersonBuilder.this.children.add((PersonBuilder<?>)arguments[0]);
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
	                this.children.add((PersonBuilder<?>)restoredObject);
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
				this.hobbies.add(e);
			}
		}
		return this;
	}

	public HobbyBuilder<PersonBuilder<P>> hobbies$one() {
		verifyMutable();
		if (this.hobbies == null) {
			this.hobbies = new ArrayList<HobbyBuilder<?>>();
		}
		
		HobbyBuilder<PersonBuilder<P>> result =
				new HobbyBuilder<PersonBuilder<P>>(this);
		
		this.hobbies.add(result);
		
		return result;
	}

	public class Hobbies$$$builder {
		
		public HobbyBuilder<Hobbies$$$builder> blank$begin() {
			HobbyBuilder<Hobbies$$$builder> result = new HobbyBuilder<Hobbies$$$builder>(this);
			PersonBuilder.this.hobbies.add(result);
			return result;
		}
		
		public PersonBuilder<P> end() {
			return PersonBuilder.this;
		}
	}
	
	public Hobbies$$$builder hobbies$list() {
		verifyMutable();
		if (this.hobbies == null) {
			this.hobbies = new ArrayList<HobbyBuilder<?>>();
		}
		return new Hobbies$$$builder();
	}

    public PersonBuilder<P> hobbies$wrap(Hobby ... hobbies) {
    	return hobbies$wrap(new ListBuilder<Hobby>().add(hobbies).toList());
    }

    public PersonBuilder<P> hobbies$wrap(Collection<Hobby> hobbies) {
		verifyMutable();

		if (this.hobbies == null) {
			this.hobbies = new ArrayList<HobbyBuilder<?>>();
		}
		if (hobbies != null) {
			for (Hobby e : hobbies) {
				HobbyBuilder<?> wrapped = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER).convert(e).to(HobbyBuilder.class);
				this.hobbies.add(wrapped);
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
	    						PersonBuilder.this.hobbies.add((HobbyBuilder<?>)arguments[0]);
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
	                this.hobbies.add((HobbyBuilder<?>)restoredObject);
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
				this.speeches.add(e);
			}
		}
		return this;
	}

	public SpeechBuilder<PersonBuilder<P>> speeches$one() {
		verifyMutable();
		if (this.speeches == null) {
			this.speeches = new ArrayList<SpeechBuilder<?>>();
		}
		
		SpeechBuilder<PersonBuilder<P>> result =
				new SpeechBuilder<PersonBuilder<P>>(this);
		
		this.speeches.add(result);
		
		return result;
	}

	public class Speeches$$$builder {
		
		public SpeechBuilder<Speeches$$$builder> blank$begin() {
			SpeechBuilder<Speeches$$$builder> result = new SpeechBuilder<Speeches$$$builder>(this);
			PersonBuilder.this.speeches.add(result);
			return result;
		}
		
		public PersonBuilder<P> end() {
			return PersonBuilder.this;
		}
	}
	
	public Speeches$$$builder speeches$list() {
		verifyMutable();
		if (this.speeches == null) {
			this.speeches = new ArrayList<SpeechBuilder<?>>();
		}
		return new Speeches$$$builder();
	}

    public PersonBuilder<P> speeches$wrap(Speech ... speeches) {
    	return speeches$wrap(new ListBuilder<Speech>().add(speeches).toList());
    }

    public PersonBuilder<P> speeches$wrap(Collection<Speech> speeches) {
		verifyMutable();

		if (this.speeches == null) {
			this.speeches = new ArrayList<SpeechBuilder<?>>();
		}
		if (speeches != null) {
			for (Speech e : speeches) {
				SpeechBuilder<?> wrapped = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER).convert(e).to(SpeechBuilder.class);
				this.speeches.add(wrapped);
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
	    						PersonBuilder.this.speeches.add((SpeechBuilder<?>)arguments[0]);
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
	                this.speeches.add((SpeechBuilder<?>)restoredObject);
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
				this.friends.add(e);
			}
		}
		return this;
	}

	public PersonBuilder<PersonBuilder<P>> friends$one() {
		verifyMutable();
		if (this.friends == null) {
			this.friends = new ArrayList<PersonBuilder<?>>();
		}
		
		PersonBuilder<PersonBuilder<P>> result =
				new PersonBuilder<PersonBuilder<P>>(this);
		
		this.friends.add(result);
		
		return result;
	}

	public class Friends$$$builder {
		
		public PersonBuilder<Friends$$$builder> blank$begin() {
			PersonBuilder<Friends$$$builder> result = new PersonBuilder<Friends$$$builder>(this);
			PersonBuilder.this.friends.add(result);
			return result;
		}
		
		public PersonBuilder<P> end() {
			return PersonBuilder.this;
		}
	}
	
	public Friends$$$builder friends$list() {
		verifyMutable();
		if (this.friends == null) {
			this.friends = new ArrayList<PersonBuilder<?>>();
		}
		return new Friends$$$builder();
	}

    public PersonBuilder<P> friends$wrap(Person ... friends) {
    	return friends$wrap(new ListBuilder<Person>().add(friends).toList());
    }

    public PersonBuilder<P> friends$wrap(Collection<Person> friends) {
		verifyMutable();

		if (this.friends == null) {
			this.friends = new ArrayList<PersonBuilder<?>>();
		}
		if (friends != null) {
			for (Person e : friends) {
				PersonBuilder<?> wrapped = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER).convert(e).to(PersonBuilder.class);
				this.friends.add(wrapped);
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
	    						PersonBuilder.this.friends.add((PersonBuilder<?>)arguments[0]);
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
	                this.friends.add((PersonBuilder<?>)restoredObject);
	            }
	    	}
		}
        return this;
    }
}

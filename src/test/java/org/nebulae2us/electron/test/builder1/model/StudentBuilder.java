package org.nebulae2us.electron.test.builder1.model;

import java.util.*;
import org.nebulae2us.electron.*;
import org.nebulae2us.electron.util.*;

@Builder(destination=Student.class)
public class StudentBuilder<P> extends PersonBuilder<P> {

	public StudentBuilder() {
		super();
	}
	
	public StudentBuilder(P parentBuilder) {
		super(parentBuilder);
	}

	protected StudentBuilder(Student wrapped) {
		super(wrapped);
	}

	@Override
	public Student getWrappedObject() {
		return (Student)this.$$$wrapped;
	}

	@Override
    public StudentBuilder<P> storeTo(BuilderRepository repo, Object builderId) {
    	repo.put(builderId, this);
    	return this;
    }

    public Student toStudent() {
    	return new Converter(new BuilderAnnotationDestinationClassResolver(), true).convert(this).to(Student.class);
    }

    @Override
    public Student toPerson() {
    	return new Converter(new BuilderAnnotationDestinationClassResolver(), true).convert(this).to(Student.class);
    }

	private boolean partTime;
	
	public boolean getPartTime() {
		return partTime;
	}

	public void setPartTime(boolean partTime) {
		verifyMutable();
		this.partTime = partTime;
	}

	public StudentBuilder<P> partTime(boolean partTime) {
		verifyMutable();
		this.partTime = partTime;
		return this;
	}

	private List<TeacherBuilder<?>> teachers;
	
	public List<TeacherBuilder<?>> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<TeacherBuilder<?>> teachers) {
		verifyMutable();
		this.teachers = teachers;
	}

	public StudentBuilder<P> teachers(TeacherBuilder<?> ... teachers) {
		verifyMutable();
		return teachers(new ListBuilder<TeacherBuilder<?>>().add(teachers).toList());
	}
	
	public StudentBuilder<P> teachers(Collection<TeacherBuilder<?>> teachers) {
		verifyMutable();
		if (this.teachers == null) {
			this.teachers = new ArrayList<TeacherBuilder<?>>();
		}
		if (teachers != null) {
			for (TeacherBuilder<?> e : teachers) {
				this.teachers.add(e);
			}
		}
		return this;
	}

	public TeacherBuilder<StudentBuilder<P>> teachers$one() {
		verifyMutable();
		if (this.teachers == null) {
			this.teachers = new ArrayList<TeacherBuilder<?>>();
		}
		
		TeacherBuilder<StudentBuilder<P>> result =
				new TeacherBuilder<StudentBuilder<P>>(this);
		
		this.teachers.add(result);
		
		return result;
	}

	public class Teachers$$$builder {
		
		public TeacherBuilder<Teachers$$$builder> blank$begin() {
			TeacherBuilder<Teachers$$$builder> result = new TeacherBuilder<Teachers$$$builder>(this);
			StudentBuilder.this.teachers.add(result);
			return result;
		}
		
		public StudentBuilder<P> end() {
			return StudentBuilder.this;
		}
	}
	
	public Teachers$$$builder teachers$list() {
		verifyMutable();
		if (this.teachers == null) {
			this.teachers = new ArrayList<TeacherBuilder<?>>();
		}
		return new Teachers$$$builder();
	}

    public StudentBuilder<P> teachers$wrap(Teacher ... teachers) {
    	return teachers$wrap(new ListBuilder<Teacher>().add(teachers).toList());
    }

    public StudentBuilder<P> teachers$wrap(Collection<Teacher> teachers) {
		verifyMutable();

		if (this.teachers == null) {
			this.teachers = new ArrayList<TeacherBuilder<?>>();
		}
		if (teachers != null) {
			for (Teacher e : teachers) {
				TeacherBuilder<?> wrapped = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER).convert(e).to(TeacherBuilder.class);
				this.teachers.add(wrapped);
			}
		}
		return this;
    }
    
    public StudentBuilder<P> teachers$restoreFrom(BuilderRepository repo, Object ... builderIds) {
    	return teachers$restoreFrom(repo, new ListBuilder<Object>().add(builderIds).toList());
    }

    public StudentBuilder<P> teachers$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		verifyMutable();

		if (this.teachers == null) {
			this.teachers = new ArrayList<TeacherBuilder<?>>();
		}
		if (builderIds != null) {
	    	for (Object builderId : builderIds) {
	            Object restoredObject = repo.get(builderId);
	            if (restoredObject == null) {
	            	if (repo.isSupportLazy()) {
	            		repo.addObjectStoredListener(builderId, new Procedure() {
	    					public void execute(Object... arguments) {
	    						StudentBuilder.this.teachers.add((TeacherBuilder<?>)arguments[0]);
	    					}
	    				});
	            	}
	            	else {
	                    throw new IllegalStateException("Object does not exist with id " + builderId);
	            	}
	            }
	            else if (!(restoredObject instanceof TeacherBuilder)) {
	            	throw new IllegalStateException("Type mismatch for id: " + builderId + ". " + TeacherBuilder.class.getSimpleName() + " vs " + restoredObject.getClass().getSimpleName());
	            }
	            else {
	                this.teachers.add((TeacherBuilder<?>)restoredObject);
	            }
	    	}
		}
        return this;
    }

	@Override
	public StudentBuilder<P> name(String name) {
		return (StudentBuilder<P>)super.name(name);
	}

	@Override
	public StudentBuilder<P> age(int age) {
		return (StudentBuilder<P>)super.age(age);
	}

	@Override
	public StudentBuilder<P> gender(Gender gender) {
		return (StudentBuilder<P>)super.gender(gender);
	}

	@Override
	public StudentBuilder<P> parent(PersonBuilder<?> parent) {
		return (StudentBuilder<P>)super.parent(parent);
	}

	@SuppressWarnings("unchecked")
	@Override
	public PersonBuilder<? extends StudentBuilder<P>> parent$begin() {
		return (PersonBuilder<? extends StudentBuilder<P>>)super.parent$begin();
	}

	@Override
    public StudentBuilder<P> parent$wrap(Person parent) {
		return (StudentBuilder<P>)super.parent$wrap(parent);
    }

	@Override
    public StudentBuilder<P> parent$restoreFrom(BuilderRepository repo, Object builderId) {
		return (StudentBuilder<P>)super.parent$restoreFrom(repo, builderId);
    }

	@Override
	public StudentBuilder<P> children(PersonBuilder<?> ... children) {
		return (StudentBuilder<P>)super.children(children);
	}

	@Override
	public StudentBuilder<P> children(Collection<PersonBuilder<?>> children) {
		return (StudentBuilder<P>)super.children(children);
	}

	@Override
    public StudentBuilder<P> children$wrap(Person ... children) {
		return (StudentBuilder<P>)super.children$wrap(children);
    }

	@Override
    public StudentBuilder<P> children$wrap(Collection<Person> children) {
		return (StudentBuilder<P>)super.children$wrap(children);
    }

	@Override
    public StudentBuilder<P> children$restoreFrom(BuilderRepository repo, Object ... builderIds) {
		return (StudentBuilder<P>)super.children$restoreFrom(repo, builderIds);
    }

	@Override
    public StudentBuilder<P> children$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		return (StudentBuilder<P>)super.children$restoreFrom(repo, builderIds);
    }

	@Override
	public StudentBuilder<P> hobbies(HobbyBuilder<?> ... hobbies) {
		return (StudentBuilder<P>)super.hobbies(hobbies);
	}

	@Override
	public StudentBuilder<P> hobbies(Collection<HobbyBuilder<?>> hobbies) {
		return (StudentBuilder<P>)super.hobbies(hobbies);
	}

	@Override
    public StudentBuilder<P> hobbies$wrap(Hobby ... hobbies) {
		return (StudentBuilder<P>)super.hobbies$wrap(hobbies);
    }

	@Override
    public StudentBuilder<P> hobbies$wrap(Collection<Hobby> hobbies) {
		return (StudentBuilder<P>)super.hobbies$wrap(hobbies);
    }

	@Override
    public StudentBuilder<P> hobbies$restoreFrom(BuilderRepository repo, Object ... builderIds) {
		return (StudentBuilder<P>)super.hobbies$restoreFrom(repo, builderIds);
    }

	@Override
    public StudentBuilder<P> hobbies$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		return (StudentBuilder<P>)super.hobbies$restoreFrom(repo, builderIds);
    }

	@Override
	public StudentBuilder<P> speeches(SpeechBuilder<?> ... speeches) {
		return (StudentBuilder<P>)super.speeches(speeches);
	}

	@Override
	public StudentBuilder<P> speeches(Collection<SpeechBuilder<?>> speeches) {
		return (StudentBuilder<P>)super.speeches(speeches);
	}

	@Override
    public StudentBuilder<P> speeches$wrap(Speech ... speeches) {
		return (StudentBuilder<P>)super.speeches$wrap(speeches);
    }

	@Override
    public StudentBuilder<P> speeches$wrap(Collection<Speech> speeches) {
		return (StudentBuilder<P>)super.speeches$wrap(speeches);
    }

	@Override
    public StudentBuilder<P> speeches$restoreFrom(BuilderRepository repo, Object ... builderIds) {
		return (StudentBuilder<P>)super.speeches$restoreFrom(repo, builderIds);
    }

	@Override
    public StudentBuilder<P> speeches$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		return (StudentBuilder<P>)super.speeches$restoreFrom(repo, builderIds);
    }

	@Override
	public StudentBuilder<P> friends(PersonBuilder<?> ... friends) {
		return (StudentBuilder<P>)super.friends(friends);
	}

	@Override
	public StudentBuilder<P> friends(Collection<PersonBuilder<?>> friends) {
		return (StudentBuilder<P>)super.friends(friends);
	}

	@Override
    public StudentBuilder<P> friends$wrap(Person ... friends) {
		return (StudentBuilder<P>)super.friends$wrap(friends);
    }

	@Override
    public StudentBuilder<P> friends$wrap(Collection<Person> friends) {
		return (StudentBuilder<P>)super.friends$wrap(friends);
    }

	@Override
    public StudentBuilder<P> friends$restoreFrom(BuilderRepository repo, Object ... builderIds) {
		return (StudentBuilder<P>)super.friends$restoreFrom(repo, builderIds);
    }

	@Override
    public StudentBuilder<P> friends$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		return (StudentBuilder<P>)super.friends$restoreFrom(repo, builderIds);
    }
}

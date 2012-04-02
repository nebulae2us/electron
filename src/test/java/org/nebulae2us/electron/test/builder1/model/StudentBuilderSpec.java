package org.nebulae2us.electron.test.builder1.model;

import java.util.*;
import org.nebulae2us.electron.*;
import org.nebulae2us.electron.util.*;

@Builder(destination=Student.class)
public class StudentBuilderSpec<P> extends PersonBuilderSpec<P> {

	public StudentBuilderSpec() {
		super();
	}
	
	public StudentBuilderSpec(P parentBuilder) {
		super(parentBuilder);
	}

	protected StudentBuilderSpec(Student wrapped) {
		super(wrapped);
	}

	@Override
	public Student getWrappedObject() {
		return (Student)this.$$$wrapped;
	}

	@Override
    public StudentBuilderSpec<P> storeTo(BuilderRepository repo, Object builderId) {
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

	public StudentBuilderSpec<P> partTime(boolean partTime) {
		verifyMutable();
		this.partTime = partTime;
		return this;
	}

	private List<TeacherBuilderSpec<?>> teachers;
	
	public List<TeacherBuilderSpec<?>> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<TeacherBuilderSpec<?>> teachers) {
		verifyMutable();
		this.teachers = teachers;
	}

	public StudentBuilderSpec<P> teachers(TeacherBuilderSpec<?> ... teachers) {
		verifyMutable();
		return teachers(new ListBuilder<TeacherBuilderSpec<?>>().add(teachers).toList());
	}
	
	public StudentBuilderSpec<P> teachers(Collection<TeacherBuilderSpec<?>> teachers) {
		verifyMutable();
		if (this.teachers == null) {
			this.teachers = new ArrayList<TeacherBuilderSpec<?>>();
		}
		if (teachers != null) {
			for (TeacherBuilderSpec<?> e : teachers) {
				this.teachers.add(e);
			}
		}
		return this;
	}

	public TeacherBuilderSpec<StudentBuilderSpec<P>> teachers$one() {
		verifyMutable();
		if (this.teachers == null) {
			this.teachers = new ArrayList<TeacherBuilderSpec<?>>();
		}
		
		TeacherBuilderSpec<StudentBuilderSpec<P>> result =
				new TeacherBuilderSpec<StudentBuilderSpec<P>>(this);
		
		this.teachers.add(result);
		
		return result;
	}

	public class Teachers$$$builder {
		
		public TeacherBuilderSpec<Teachers$$$builder> blank$begin() {
			TeacherBuilderSpec<Teachers$$$builder> result = new TeacherBuilderSpec<Teachers$$$builder>(this);
			StudentBuilderSpec.this.teachers.add(result);
			return result;
		}
		
		public StudentBuilderSpec<P> end() {
			return StudentBuilderSpec.this;
		}
	}
	
	public Teachers$$$builder teachers$list() {
		verifyMutable();
		if (this.teachers == null) {
			this.teachers = new ArrayList<TeacherBuilderSpec<?>>();
		}
		return new Teachers$$$builder();
	}

    public StudentBuilderSpec<P> teachers$wrap(Teacher ... teachers) {
    	return teachers$wrap(new ListBuilder<Teacher>().add(teachers).toList());
    }

    public StudentBuilderSpec<P> teachers$wrap(Collection<Teacher> teachers) {
		verifyMutable();

		if (this.teachers == null) {
			this.teachers = new ArrayList<TeacherBuilderSpec<?>>();
		}
		if (teachers != null) {
			for (Teacher e : teachers) {
				TeacherBuilderSpec<?> wrapped = new WrapConverter(BuilderSpecs.DESTINATION_CLASS_RESOLVER).convert(e).to(TeacherBuilderSpec.class);
				this.teachers.add(wrapped);
			}
		}
		return this;
    }
    
    public StudentBuilderSpec<P> teachers$restoreFrom(BuilderRepository repo, Object ... builderIds) {
    	return teachers$restoreFrom(repo, new ListBuilder<Object>().add(builderIds).toList());
    }

    public StudentBuilderSpec<P> teachers$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		verifyMutable();

		if (this.teachers == null) {
			this.teachers = new ArrayList<TeacherBuilderSpec<?>>();
		}
		if (builderIds != null) {
	    	for (Object builderId : builderIds) {
	            Object restoredObject = repo.get(builderId);
	            if (restoredObject == null) {
	            	if (repo.isSupportLazy()) {
	            		repo.addObjectStoredListener(builderId, new Procedure() {
	    					public void execute(Object... arguments) {
	    						StudentBuilderSpec.this.teachers.add((TeacherBuilderSpec<?>)arguments[0]);
	    					}
	    				});
	            	}
	            	else {
	                    throw new IllegalStateException("Object does not exist with id " + builderId);
	            	}
	            }
	            else if (!(restoredObject instanceof TeacherBuilderSpec)) {
	            	throw new IllegalStateException("Type mismatch for id: " + builderId + ". " + TeacherBuilderSpec.class.getSimpleName() + " vs " + restoredObject.getClass().getSimpleName());
	            }
	            else {
	                this.teachers.add((TeacherBuilderSpec<?>)restoredObject);
	            }
	    	}
		}
        return this;
    }

	@Override
	public StudentBuilderSpec<P> name(String name) {
		return (StudentBuilderSpec<P>)super.name(name);
	}

	@Override
	public StudentBuilderSpec<P> age(int age) {
		return (StudentBuilderSpec<P>)super.age(age);
	}

	@Override
	public StudentBuilderSpec<P> gender(Gender gender) {
		return (StudentBuilderSpec<P>)super.gender(gender);
	}

	@Override
	public StudentBuilderSpec<P> parent(PersonBuilderSpec<?> parent) {
		return (StudentBuilderSpec<P>)super.parent(parent);
	}

	@Override
    public StudentBuilderSpec<P> parent$wrap(Person parent) {
		return (StudentBuilderSpec<P>)super.parent$wrap(parent);
    }

	@Override
    public StudentBuilderSpec<P> parent$restoreFrom(BuilderRepository repo, Object builderId) {
		return (StudentBuilderSpec<P>)super.parent$restoreFrom(repo, builderId);
    }

	@Override
	public StudentBuilderSpec<P> children(PersonBuilderSpec<?> ... children) {
		return (StudentBuilderSpec<P>)super.children(children);
	}

	@Override
	public StudentBuilderSpec<P> children(Collection<PersonBuilderSpec<?>> children) {
		return (StudentBuilderSpec<P>)super.children(children);
	}

	@Override
    public StudentBuilderSpec<P> children$wrap(Person ... children) {
		return (StudentBuilderSpec<P>)super.children$wrap(children);
    }

	@Override
    public StudentBuilderSpec<P> children$wrap(Collection<Person> children) {
		return (StudentBuilderSpec<P>)super.children$wrap(children);
    }

	@Override
    public StudentBuilderSpec<P> children$restoreFrom(BuilderRepository repo, Object ... builderIds) {
		return (StudentBuilderSpec<P>)super.children$restoreFrom(repo, builderIds);
    }

	@Override
    public StudentBuilderSpec<P> children$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		return (StudentBuilderSpec<P>)super.children$restoreFrom(repo, builderIds);
    }

	@Override
	public StudentBuilderSpec<P> hobbies(HobbyBuilderSpec<?> ... hobbies) {
		return (StudentBuilderSpec<P>)super.hobbies(hobbies);
	}

	@Override
	public StudentBuilderSpec<P> hobbies(Collection<HobbyBuilderSpec<?>> hobbies) {
		return (StudentBuilderSpec<P>)super.hobbies(hobbies);
	}

	@Override
    public StudentBuilderSpec<P> hobbies$wrap(Hobby ... hobbies) {
		return (StudentBuilderSpec<P>)super.hobbies$wrap(hobbies);
    }

	@Override
    public StudentBuilderSpec<P> hobbies$wrap(Collection<Hobby> hobbies) {
		return (StudentBuilderSpec<P>)super.hobbies$wrap(hobbies);
    }

	@Override
    public StudentBuilderSpec<P> hobbies$restoreFrom(BuilderRepository repo, Object ... builderIds) {
		return (StudentBuilderSpec<P>)super.hobbies$restoreFrom(repo, builderIds);
    }

	@Override
    public StudentBuilderSpec<P> hobbies$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		return (StudentBuilderSpec<P>)super.hobbies$restoreFrom(repo, builderIds);
    }

	@Override
	public StudentBuilderSpec<P> speeches(SpeechBuilderSpec<?> ... speeches) {
		return (StudentBuilderSpec<P>)super.speeches(speeches);
	}

	@Override
	public StudentBuilderSpec<P> speeches(Collection<SpeechBuilderSpec<?>> speeches) {
		return (StudentBuilderSpec<P>)super.speeches(speeches);
	}

	@Override
    public StudentBuilderSpec<P> speeches$wrap(Speech ... speeches) {
		return (StudentBuilderSpec<P>)super.speeches$wrap(speeches);
    }

	@Override
    public StudentBuilderSpec<P> speeches$wrap(Collection<Speech> speeches) {
		return (StudentBuilderSpec<P>)super.speeches$wrap(speeches);
    }

	@Override
    public StudentBuilderSpec<P> speeches$restoreFrom(BuilderRepository repo, Object ... builderIds) {
		return (StudentBuilderSpec<P>)super.speeches$restoreFrom(repo, builderIds);
    }

	@Override
    public StudentBuilderSpec<P> speeches$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		return (StudentBuilderSpec<P>)super.speeches$restoreFrom(repo, builderIds);
    }

	@Override
	public StudentBuilderSpec<P> friends(PersonBuilderSpec<?> ... friends) {
		return (StudentBuilderSpec<P>)super.friends(friends);
	}

	@Override
	public StudentBuilderSpec<P> friends(Collection<PersonBuilderSpec<?>> friends) {
		return (StudentBuilderSpec<P>)super.friends(friends);
	}

	@Override
    public StudentBuilderSpec<P> friends$wrap(Person ... friends) {
		return (StudentBuilderSpec<P>)super.friends$wrap(friends);
    }

	@Override
    public StudentBuilderSpec<P> friends$wrap(Collection<Person> friends) {
		return (StudentBuilderSpec<P>)super.friends$wrap(friends);
    }

	@Override
    public StudentBuilderSpec<P> friends$restoreFrom(BuilderRepository repo, Object ... builderIds) {
		return (StudentBuilderSpec<P>)super.friends$restoreFrom(repo, builderIds);
    }

	@Override
    public StudentBuilderSpec<P> friends$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		return (StudentBuilderSpec<P>)super.friends$restoreFrom(repo, builderIds);
    }
}

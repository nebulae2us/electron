package org.nebulae2us.electron.test.builder1.model;

import java.util.*;
import org.nebulae2us.electron.*;
import org.nebulae2us.electron.util.*;

public class StudentBuilder extends PersonBuilder {

	public StudentBuilder() {
		super();
	}
	
	public StudentBuilder(ConverterOption option) {
		super(option);
	}

	protected StudentBuilder(Student wrapped, ConverterOption option) {
		super(wrapped, option);
	}

	@Override
	public Student getWrappedObject() {
		return (Student)this.$$$wrapped;
	}

	@Override
    public StudentBuilder storeTo(BuilderRepository repo, Object builderId) {
    	repo.put(builderId, this);
    	return this;
    }
	
    public Student toStudent() {
    	return new Converter(this.$$$option, true).convert(this).to(Student.class);
    }

    @Override
    public Student toPerson() {
    	return new Converter(this.$$$option, true).convert(this).to(Student.class);
    }

	private boolean partTime;
	
	public boolean getPartTime() {
		return partTime;
	}

	public void setPartTime(boolean partTime) {
		verifyMutable();
		this.partTime = partTime;
	}

	public StudentBuilder partTime(boolean partTime) {
		verifyMutable();
		this.partTime = partTime;
		return this;
	}

	private List<TeacherBuilder> teachers;
	
	public List<TeacherBuilder> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<TeacherBuilder> teachers) {
		verifyMutable();
		this.teachers = teachers;
	}

	public StudentBuilder teachers(TeacherBuilder ... teachers) {
		verifyMutable();
		return teachers(new ListBuilder<TeacherBuilder>().add(teachers).toList());
	}
	
	public StudentBuilder teachers(Collection<TeacherBuilder> teachers) {
		verifyMutable();
		if (this.teachers == null) {
			this.teachers = new ArrayList<TeacherBuilder>();
		}
		if (teachers != null) {
			for (TeacherBuilder e : teachers) {
				this.teachers.add(e);
			}
		}
		return this;
	}

    public StudentBuilder teachers$wrap(Teacher ... teachers) {
    	return teachers$wrap(new ListBuilder<Teacher>().add(teachers).toList());
    }

    public StudentBuilder teachers$wrap(Collection<Teacher> teachers) {
		verifyMutable();

		if (this.teachers == null) {
			this.teachers = new ArrayList<TeacherBuilder>();
		}
		if (teachers != null) {
			for (Teacher e : teachers) {
				TeacherBuilder wrapped = new WrapConverter(this.$$$option).convert(e).to(TeacherBuilder.class);
				this.teachers.add(wrapped);
			}
		}
		return this;
    }
    
    public StudentBuilder teachers$restoreFrom(BuilderRepository repo, Object ... builderIds) {
    	return teachers$restoreFrom(repo, new ListBuilder<Object>().add(builderIds).toList());
    }

    public StudentBuilder teachers$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		verifyMutable();

		if (this.teachers == null) {
			this.teachers = new ArrayList<TeacherBuilder>();
		}
		if (builderIds != null) {
	    	for (Object builderId : builderIds) {
	            Object restoredObject = repo.get(builderId);
	            if (restoredObject == null) {
	            	if (repo.isSupportLazy()) {
	            		repo.addObjectStoredListener(builderId, new Procedure() {
	    					public void execute(Object... arguments) {
	    						StudentBuilder.this.teachers.add((TeacherBuilder)arguments[0]);
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
	                this.teachers.add((TeacherBuilder)restoredObject);
	            }
	    	}
		}
        return this;
    }

	@Override
	public StudentBuilder name(String name) {
		return (StudentBuilder)super.name(name);
	}

	@Override
	public StudentBuilder age(int age) {
		return (StudentBuilder)super.age(age);
	}

	@Override
	public StudentBuilder gender(Gender gender) {
		return (StudentBuilder)super.gender(gender);
	}

	@Override
	public StudentBuilder parent(PersonBuilder parent) {
		return (StudentBuilder)super.parent(parent);
	}

	@Override
    public StudentBuilder parent$wrap(Person parent) {
		return (StudentBuilder)super.parent$wrap(parent);
    }

	@Override
    public StudentBuilder parent$restoreFrom(BuilderRepository repo, Object builderId) {
		return (StudentBuilder)super.parent$restoreFrom(repo, builderId);
    }

	@Override
	public StudentBuilder children(PersonBuilder ... children) {
		return (StudentBuilder)super.children(children);
	}

	@Override
	public StudentBuilder children(Collection<PersonBuilder> children) {
		return (StudentBuilder)super.children(children);
	}

	@Override
    public StudentBuilder children$wrap(Person ... children) {
		return (StudentBuilder)super.children$wrap(children);
    }

	@Override
    public StudentBuilder children$wrap(Collection<Person> children) {
		return (StudentBuilder)super.children$wrap(children);
    }

	@Override
    public StudentBuilder children$restoreFrom(BuilderRepository repo, Object ... builderIds) {
		return (StudentBuilder)super.children$restoreFrom(repo, builderIds);
    }

	@Override
    public StudentBuilder children$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		return (StudentBuilder)super.children$restoreFrom(repo, builderIds);
    }

	@Override
	public StudentBuilder hobbies(HobbyBuilder ... hobbies) {
		return (StudentBuilder)super.hobbies(hobbies);
	}

	@Override
	public StudentBuilder hobbies(Collection<HobbyBuilder> hobbies) {
		return (StudentBuilder)super.hobbies(hobbies);
	}

	@Override
    public StudentBuilder hobbies$wrap(Hobby ... hobbies) {
		return (StudentBuilder)super.hobbies$wrap(hobbies);
    }

	@Override
    public StudentBuilder hobbies$wrap(Collection<Hobby> hobbies) {
		return (StudentBuilder)super.hobbies$wrap(hobbies);
    }

	@Override
    public StudentBuilder hobbies$restoreFrom(BuilderRepository repo, Object ... builderIds) {
		return (StudentBuilder)super.hobbies$restoreFrom(repo, builderIds);
    }

	@Override
    public StudentBuilder hobbies$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		return (StudentBuilder)super.hobbies$restoreFrom(repo, builderIds);
    }

	@Override
	public StudentBuilder speeches(SpeechBuilder ... speeches) {
		return (StudentBuilder)super.speeches(speeches);
	}

	@Override
	public StudentBuilder speeches(Collection<SpeechBuilder> speeches) {
		return (StudentBuilder)super.speeches(speeches);
	}

	@Override
    public StudentBuilder speeches$wrap(Speech ... speeches) {
		return (StudentBuilder)super.speeches$wrap(speeches);
    }

	@Override
    public StudentBuilder speeches$wrap(Collection<Speech> speeches) {
		return (StudentBuilder)super.speeches$wrap(speeches);
    }

	@Override
    public StudentBuilder speeches$restoreFrom(BuilderRepository repo, Object ... builderIds) {
		return (StudentBuilder)super.speeches$restoreFrom(repo, builderIds);
    }

	@Override
    public StudentBuilder speeches$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		return (StudentBuilder)super.speeches$restoreFrom(repo, builderIds);
    }

	@Override
	public StudentBuilder friends(PersonBuilder ... friends) {
		return (StudentBuilder)super.friends(friends);
	}

	@Override
	public StudentBuilder friends(Collection<PersonBuilder> friends) {
		return (StudentBuilder)super.friends(friends);
	}

	@Override
    public StudentBuilder friends$wrap(Person ... friends) {
		return (StudentBuilder)super.friends$wrap(friends);
    }

	@Override
    public StudentBuilder friends$wrap(Collection<Person> friends) {
		return (StudentBuilder)super.friends$wrap(friends);
    }

	@Override
    public StudentBuilder friends$restoreFrom(BuilderRepository repo, Object ... builderIds) {
		return (StudentBuilder)super.friends$restoreFrom(repo, builderIds);
    }

	@Override
    public StudentBuilder friends$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		return (StudentBuilder)super.friends$restoreFrom(repo, builderIds);
    }
}

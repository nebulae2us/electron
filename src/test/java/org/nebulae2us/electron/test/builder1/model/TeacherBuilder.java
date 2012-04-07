package org.nebulae2us.electron.test.builder1.model;

import java.util.*;
import org.nebulae2us.electron.*;
import org.nebulae2us.electron.util.*;

@Builder(destination=Teacher.class)
public class TeacherBuilder<P> extends PersonBuilder<P> {

	public TeacherBuilder() {
		super();
	}
	
	public TeacherBuilder(P parentBuilder) {
		super(parentBuilder);
	}

	protected TeacherBuilder(Teacher wrapped) {
		super(wrapped);
	}

	@Override
	public Teacher getWrappedObject() {
		return (Teacher)this.$$$wrapped;
	}

	@Override
    public TeacherBuilder<P> storeTo(BuilderRepository repo, Object builderId) {
    	repo.put(builderId, this);
    	return this;
    }

    public Teacher toTeacher() {
    	return new Converter(new BuilderAnnotationDestinationClassResolver(), true).convert(this).to(Teacher.class);
    }

    @Override
    public Teacher toPerson() {
    	return new Converter(new BuilderAnnotationDestinationClassResolver(), true).convert(this).to(Teacher.class);
    }

	private double salary;
	
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		verifyMutable();
		this.salary = salary;
	}

	public TeacherBuilder<P> salary(double salary) {
		verifyMutable();
		this.salary = salary;
		return this;
	}

	private List<StudentBuilder<?>> students;
	
	public List<StudentBuilder<?>> getStudents() {
		return students;
	}

	public void setStudents(List<StudentBuilder<?>> students) {
		verifyMutable();
		this.students = students;
	}

	public TeacherBuilder<P> students(StudentBuilder<?> ... students) {
		verifyMutable();
		return students(new ListBuilder<StudentBuilder<?>>().add(students).toList());
	}
	
	public TeacherBuilder<P> students(Collection<StudentBuilder<?>> students) {
		verifyMutable();
		if (this.students == null) {
			this.students = new ArrayList<StudentBuilder<?>>();
		}
		if (students != null) {
			for (StudentBuilder<?> e : students) {
				this.students.add(e);
			}
		}
		return this;
	}

	public StudentBuilder<TeacherBuilder<P>> students$one() {
		verifyMutable();
		if (this.students == null) {
			this.students = new ArrayList<StudentBuilder<?>>();
		}
		
		StudentBuilder<TeacherBuilder<P>> result =
				new StudentBuilder<TeacherBuilder<P>>(this);
		
		this.students.add(result);
		
		return result;
	}

	public class Students$$$builder {
		
		public StudentBuilder<Students$$$builder> blank$begin() {
			StudentBuilder<Students$$$builder> result = new StudentBuilder<Students$$$builder>(this);
			TeacherBuilder.this.students.add(result);
			return result;
		}
		
		public TeacherBuilder<P> end() {
			return TeacherBuilder.this;
		}
	}
	
	public Students$$$builder students$list() {
		verifyMutable();
		if (this.students == null) {
			this.students = new ArrayList<StudentBuilder<?>>();
		}
		return new Students$$$builder();
	}

    public TeacherBuilder<P> students$wrap(Student ... students) {
    	return students$wrap(new ListBuilder<Student>().add(students).toList());
    }

    public TeacherBuilder<P> students$wrap(Collection<Student> students) {
		verifyMutable();

		if (this.students == null) {
			this.students = new ArrayList<StudentBuilder<?>>();
		}
		if (students != null) {
			for (Student e : students) {
				StudentBuilder<?> wrapped = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER).convert(e).to(StudentBuilder.class);
				this.students.add(wrapped);
			}
		}
		return this;
    }
    
    public TeacherBuilder<P> students$restoreFrom(BuilderRepository repo, Object ... builderIds) {
    	return students$restoreFrom(repo, new ListBuilder<Object>().add(builderIds).toList());
    }

    public TeacherBuilder<P> students$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		verifyMutable();

		if (this.students == null) {
			this.students = new ArrayList<StudentBuilder<?>>();
		}
		if (builderIds != null) {
	    	for (Object builderId : builderIds) {
	            Object restoredObject = repo.get(builderId);
	            if (restoredObject == null) {
	            	if (repo.isSupportLazy()) {
	            		repo.addObjectStoredListener(builderId, new Procedure() {
	    					public void execute(Object... arguments) {
	    						TeacherBuilder.this.students.add((StudentBuilder<?>)arguments[0]);
	    					}
	    				});
	            	}
	            	else {
	                    throw new IllegalStateException("Object does not exist with id " + builderId);
	            	}
	            }
	            else if (!(restoredObject instanceof StudentBuilder)) {
	            	throw new IllegalStateException("Type mismatch for id: " + builderId + ". " + StudentBuilder.class.getSimpleName() + " vs " + restoredObject.getClass().getSimpleName());
	            }
	            else {
	                this.students.add((StudentBuilder<?>)restoredObject);
	            }
	    	}
		}
        return this;
    }

	@Override
	public TeacherBuilder<P> name(String name) {
		return (TeacherBuilder<P>)super.name(name);
	}

	@Override
	public TeacherBuilder<P> age(int age) {
		return (TeacherBuilder<P>)super.age(age);
	}

	@Override
	public TeacherBuilder<P> gender(Gender gender) {
		return (TeacherBuilder<P>)super.gender(gender);
	}

	@Override
	public TeacherBuilder<P> parent(PersonBuilder<?> parent) {
		return (TeacherBuilder<P>)super.parent(parent);
	}

	@SuppressWarnings("unchecked")
	@Override
	public PersonBuilder<? extends TeacherBuilder<P>> parent$begin() {
		return (PersonBuilder<? extends TeacherBuilder<P>>)super.parent$begin();
	}

	@Override
    public TeacherBuilder<P> parent$wrap(Person parent) {
		return (TeacherBuilder<P>)super.parent$wrap(parent);
    }

	@Override
    public TeacherBuilder<P> parent$restoreFrom(BuilderRepository repo, Object builderId) {
		return (TeacherBuilder<P>)super.parent$restoreFrom(repo, builderId);
    }

	@Override
	public TeacherBuilder<P> children(PersonBuilder<?> ... children) {
		return (TeacherBuilder<P>)super.children(children);
	}

	@Override
	public TeacherBuilder<P> children(Collection<PersonBuilder<?>> children) {
		return (TeacherBuilder<P>)super.children(children);
	}

	@Override
    public TeacherBuilder<P> children$wrap(Person ... children) {
		return (TeacherBuilder<P>)super.children$wrap(children);
    }

	@Override
    public TeacherBuilder<P> children$wrap(Collection<Person> children) {
		return (TeacherBuilder<P>)super.children$wrap(children);
    }

	@Override
    public TeacherBuilder<P> children$restoreFrom(BuilderRepository repo, Object ... builderIds) {
		return (TeacherBuilder<P>)super.children$restoreFrom(repo, builderIds);
    }

	@Override
    public TeacherBuilder<P> children$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		return (TeacherBuilder<P>)super.children$restoreFrom(repo, builderIds);
    }

	@Override
	public TeacherBuilder<P> hobbies(HobbyBuilder<?> ... hobbies) {
		return (TeacherBuilder<P>)super.hobbies(hobbies);
	}

	@Override
	public TeacherBuilder<P> hobbies(Collection<HobbyBuilder<?>> hobbies) {
		return (TeacherBuilder<P>)super.hobbies(hobbies);
	}

	@Override
    public TeacherBuilder<P> hobbies$wrap(Hobby ... hobbies) {
		return (TeacherBuilder<P>)super.hobbies$wrap(hobbies);
    }

	@Override
    public TeacherBuilder<P> hobbies$wrap(Collection<Hobby> hobbies) {
		return (TeacherBuilder<P>)super.hobbies$wrap(hobbies);
    }

	@Override
    public TeacherBuilder<P> hobbies$restoreFrom(BuilderRepository repo, Object ... builderIds) {
		return (TeacherBuilder<P>)super.hobbies$restoreFrom(repo, builderIds);
    }

	@Override
    public TeacherBuilder<P> hobbies$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		return (TeacherBuilder<P>)super.hobbies$restoreFrom(repo, builderIds);
    }

	@Override
	public TeacherBuilder<P> speeches(SpeechBuilder<?> ... speeches) {
		return (TeacherBuilder<P>)super.speeches(speeches);
	}

	@Override
	public TeacherBuilder<P> speeches(Collection<SpeechBuilder<?>> speeches) {
		return (TeacherBuilder<P>)super.speeches(speeches);
	}

	@Override
    public TeacherBuilder<P> speeches$wrap(Speech ... speeches) {
		return (TeacherBuilder<P>)super.speeches$wrap(speeches);
    }

	@Override
    public TeacherBuilder<P> speeches$wrap(Collection<Speech> speeches) {
		return (TeacherBuilder<P>)super.speeches$wrap(speeches);
    }

	@Override
    public TeacherBuilder<P> speeches$restoreFrom(BuilderRepository repo, Object ... builderIds) {
		return (TeacherBuilder<P>)super.speeches$restoreFrom(repo, builderIds);
    }

	@Override
    public TeacherBuilder<P> speeches$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		return (TeacherBuilder<P>)super.speeches$restoreFrom(repo, builderIds);
    }

	@Override
	public TeacherBuilder<P> friends(PersonBuilder<?> ... friends) {
		return (TeacherBuilder<P>)super.friends(friends);
	}

	@Override
	public TeacherBuilder<P> friends(Collection<PersonBuilder<?>> friends) {
		return (TeacherBuilder<P>)super.friends(friends);
	}

	@Override
    public TeacherBuilder<P> friends$wrap(Person ... friends) {
		return (TeacherBuilder<P>)super.friends$wrap(friends);
    }

	@Override
    public TeacherBuilder<P> friends$wrap(Collection<Person> friends) {
		return (TeacherBuilder<P>)super.friends$wrap(friends);
    }

	@Override
    public TeacherBuilder<P> friends$restoreFrom(BuilderRepository repo, Object ... builderIds) {
		return (TeacherBuilder<P>)super.friends$restoreFrom(repo, builderIds);
    }

	@Override
    public TeacherBuilder<P> friends$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		return (TeacherBuilder<P>)super.friends$restoreFrom(repo, builderIds);
    }
}

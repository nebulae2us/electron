package org.nebulae2us.electron.test.builder1.model;

import java.util.*;
import org.nebulae2us.electron.*;
import org.nebulae2us.electron.util.*;

@Builder(destination=Teacher.class)
public class TeacherBuilderSpec<P> extends PersonBuilderSpec<P> {

	public TeacherBuilderSpec() {
		super();
	}
	
	public TeacherBuilderSpec(P parentBuilder) {
		super(parentBuilder);
	}

	protected TeacherBuilderSpec(Teacher wrapped) {
		super(wrapped);
	}

	@Override
	public Teacher getWrappedObject() {
		return (Teacher)this.$$$wrapped;
	}

	@Override
    public TeacherBuilderSpec<P> storeTo(BuilderRepository repo, Object builderId) {
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

	public TeacherBuilderSpec<P> salary(double salary) {
		verifyMutable();
		this.salary = salary;
		return this;
	}

	private List<StudentBuilderSpec<?>> students;
	
	public List<StudentBuilderSpec<?>> getStudents() {
		return students;
	}

	public void setStudents(List<StudentBuilderSpec<?>> students) {
		verifyMutable();
		this.students = students;
	}

	public TeacherBuilderSpec<P> students(StudentBuilderSpec<?> ... students) {
		verifyMutable();
		return students(new ListBuilder<StudentBuilderSpec<?>>().add(students).toList());
	}
	
	public TeacherBuilderSpec<P> students(Collection<StudentBuilderSpec<?>> students) {
		verifyMutable();
		if (this.students == null) {
			this.students = new ArrayList<StudentBuilderSpec<?>>();
		}
		if (students != null) {
			for (StudentBuilderSpec<?> e : students) {
				this.students.add(e);
			}
		}
		return this;
	}

	public StudentBuilderSpec<TeacherBuilderSpec<P>> students$one() {
		verifyMutable();
		if (this.students == null) {
			this.students = new ArrayList<StudentBuilderSpec<?>>();
		}
		
		StudentBuilderSpec<TeacherBuilderSpec<P>> result =
				new StudentBuilderSpec<TeacherBuilderSpec<P>>(this);
		
		this.students.add(result);
		
		return result;
	}

	public class Students$$$builder {
		
		public StudentBuilderSpec<Students$$$builder> blank$begin() {
			StudentBuilderSpec<Students$$$builder> result = new StudentBuilderSpec<Students$$$builder>(this);
			TeacherBuilderSpec.this.students.add(result);
			return result;
		}
		
		public TeacherBuilderSpec<P> end() {
			return TeacherBuilderSpec.this;
		}
	}
	
	public Students$$$builder students$list() {
		verifyMutable();
		if (this.students == null) {
			this.students = new ArrayList<StudentBuilderSpec<?>>();
		}
		return new Students$$$builder();
	}

    public TeacherBuilderSpec<P> students$wrap(Student ... students) {
    	return students$wrap(new ListBuilder<Student>().add(students).toList());
    }

    public TeacherBuilderSpec<P> students$wrap(Collection<Student> students) {
		verifyMutable();

		if (this.students == null) {
			this.students = new ArrayList<StudentBuilderSpec<?>>();
		}
		if (students != null) {
			for (Student e : students) {
				StudentBuilderSpec<?> wrapped = new WrapConverter(BuilderSpecs.DESTINATION_CLASS_RESOLVER).convert(e).to(StudentBuilderSpec.class);
				this.students.add(wrapped);
			}
		}
		return this;
    }
    
    public TeacherBuilderSpec<P> students$restoreFrom(BuilderRepository repo, Object ... builderIds) {
    	return students$restoreFrom(repo, new ListBuilder<Object>().add(builderIds).toList());
    }

    public TeacherBuilderSpec<P> students$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		verifyMutable();

		if (this.students == null) {
			this.students = new ArrayList<StudentBuilderSpec<?>>();
		}
		if (builderIds != null) {
	    	for (Object builderId : builderIds) {
	            Object restoredObject = repo.get(builderId);
	            if (restoredObject == null) {
	            	if (repo.isSupportLazy()) {
	            		repo.addObjectStoredListener(builderId, new Procedure() {
	    					public void execute(Object... arguments) {
	    						TeacherBuilderSpec.this.students.add((StudentBuilderSpec<?>)arguments[0]);
	    					}
	    				});
	            	}
	            	else {
	                    throw new IllegalStateException("Object does not exist with id " + builderId);
	            	}
	            }
	            else if (!(restoredObject instanceof StudentBuilderSpec)) {
	            	throw new IllegalStateException("Type mismatch for id: " + builderId + ". " + StudentBuilderSpec.class.getSimpleName() + " vs " + restoredObject.getClass().getSimpleName());
	            }
	            else {
	                this.students.add((StudentBuilderSpec<?>)restoredObject);
	            }
	    	}
		}
        return this;
    }

	@Override
	public TeacherBuilderSpec<P> name(String name) {
		return (TeacherBuilderSpec<P>)super.name(name);
	}

	@Override
	public TeacherBuilderSpec<P> age(int age) {
		return (TeacherBuilderSpec<P>)super.age(age);
	}

	@Override
	public TeacherBuilderSpec<P> gender(Gender gender) {
		return (TeacherBuilderSpec<P>)super.gender(gender);
	}

	@Override
	public TeacherBuilderSpec<P> parent(PersonBuilderSpec<?> parent) {
		return (TeacherBuilderSpec<P>)super.parent(parent);
	}

	@Override
    public TeacherBuilderSpec<P> parent$wrap(Person parent) {
		return (TeacherBuilderSpec<P>)super.parent$wrap(parent);
    }

	@Override
    public TeacherBuilderSpec<P> parent$restoreFrom(BuilderRepository repo, Object builderId) {
		return (TeacherBuilderSpec<P>)super.parent$restoreFrom(repo, builderId);
    }

	@Override
	public TeacherBuilderSpec<P> children(PersonBuilderSpec<?> ... children) {
		return (TeacherBuilderSpec<P>)super.children(children);
	}

	@Override
	public TeacherBuilderSpec<P> children(Collection<PersonBuilderSpec<?>> children) {
		return (TeacherBuilderSpec<P>)super.children(children);
	}

	@Override
    public TeacherBuilderSpec<P> children$wrap(Person ... children) {
		return (TeacherBuilderSpec<P>)super.children$wrap(children);
    }

	@Override
    public TeacherBuilderSpec<P> children$wrap(Collection<Person> children) {
		return (TeacherBuilderSpec<P>)super.children$wrap(children);
    }

	@Override
    public TeacherBuilderSpec<P> children$restoreFrom(BuilderRepository repo, Object ... builderIds) {
		return (TeacherBuilderSpec<P>)super.children$restoreFrom(repo, builderIds);
    }

	@Override
    public TeacherBuilderSpec<P> children$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		return (TeacherBuilderSpec<P>)super.children$restoreFrom(repo, builderIds);
    }

	@Override
	public TeacherBuilderSpec<P> hobbies(HobbyBuilderSpec<?> ... hobbies) {
		return (TeacherBuilderSpec<P>)super.hobbies(hobbies);
	}

	@Override
	public TeacherBuilderSpec<P> hobbies(Collection<HobbyBuilderSpec<?>> hobbies) {
		return (TeacherBuilderSpec<P>)super.hobbies(hobbies);
	}

	@Override
    public TeacherBuilderSpec<P> hobbies$wrap(Hobby ... hobbies) {
		return (TeacherBuilderSpec<P>)super.hobbies$wrap(hobbies);
    }

	@Override
    public TeacherBuilderSpec<P> hobbies$wrap(Collection<Hobby> hobbies) {
		return (TeacherBuilderSpec<P>)super.hobbies$wrap(hobbies);
    }

	@Override
    public TeacherBuilderSpec<P> hobbies$restoreFrom(BuilderRepository repo, Object ... builderIds) {
		return (TeacherBuilderSpec<P>)super.hobbies$restoreFrom(repo, builderIds);
    }

	@Override
    public TeacherBuilderSpec<P> hobbies$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		return (TeacherBuilderSpec<P>)super.hobbies$restoreFrom(repo, builderIds);
    }

	@Override
	public TeacherBuilderSpec<P> speeches(SpeechBuilderSpec<?> ... speeches) {
		return (TeacherBuilderSpec<P>)super.speeches(speeches);
	}

	@Override
	public TeacherBuilderSpec<P> speeches(Collection<SpeechBuilderSpec<?>> speeches) {
		return (TeacherBuilderSpec<P>)super.speeches(speeches);
	}

	@Override
    public TeacherBuilderSpec<P> speeches$wrap(Speech ... speeches) {
		return (TeacherBuilderSpec<P>)super.speeches$wrap(speeches);
    }

	@Override
    public TeacherBuilderSpec<P> speeches$wrap(Collection<Speech> speeches) {
		return (TeacherBuilderSpec<P>)super.speeches$wrap(speeches);
    }

	@Override
    public TeacherBuilderSpec<P> speeches$restoreFrom(BuilderRepository repo, Object ... builderIds) {
		return (TeacherBuilderSpec<P>)super.speeches$restoreFrom(repo, builderIds);
    }

	@Override
    public TeacherBuilderSpec<P> speeches$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		return (TeacherBuilderSpec<P>)super.speeches$restoreFrom(repo, builderIds);
    }

	@Override
	public TeacherBuilderSpec<P> friends(PersonBuilderSpec<?> ... friends) {
		return (TeacherBuilderSpec<P>)super.friends(friends);
	}

	@Override
	public TeacherBuilderSpec<P> friends(Collection<PersonBuilderSpec<?>> friends) {
		return (TeacherBuilderSpec<P>)super.friends(friends);
	}

	@Override
    public TeacherBuilderSpec<P> friends$wrap(Person ... friends) {
		return (TeacherBuilderSpec<P>)super.friends$wrap(friends);
    }

	@Override
    public TeacherBuilderSpec<P> friends$wrap(Collection<Person> friends) {
		return (TeacherBuilderSpec<P>)super.friends$wrap(friends);
    }

	@Override
    public TeacherBuilderSpec<P> friends$restoreFrom(BuilderRepository repo, Object ... builderIds) {
		return (TeacherBuilderSpec<P>)super.friends$restoreFrom(repo, builderIds);
    }

	@Override
    public TeacherBuilderSpec<P> friends$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		return (TeacherBuilderSpec<P>)super.friends$restoreFrom(repo, builderIds);
    }
}

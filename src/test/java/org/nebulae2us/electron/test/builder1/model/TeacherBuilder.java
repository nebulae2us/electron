package org.nebulae2us.electron.test.builder1.model;

import java.util.*;
import org.nebulae2us.electron.*;
import org.nebulae2us.electron.util.*;

public class TeacherBuilder extends PersonBuilder {

	public TeacherBuilder() {
		super();
	}
	
	public TeacherBuilder(ConverterOption option) {
		super(option);
	}

	protected TeacherBuilder(Teacher wrapped, ConverterOption option) {
		super(wrapped, option);
	}

	@Override
	public Teacher getWrappedObject() {
		return (Teacher)this.$$$wrapped;
	}

	@Override
    public TeacherBuilder storeTo(BuilderRepository repo, Object builderId) {
    	repo.put(builderId, this);
    	return this;
    }
	
    public Teacher toTeacher() {
    	return new Converter(this.$$$option, true).convert(this).to(Teacher.class);
    }

    @Override
    public Teacher toPerson() {
    	return new Converter(this.$$$option, true).convert(this).to(Teacher.class);
    }

	private double salary;
	
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		verifyMutable();
		this.salary = salary;
	}

	public TeacherBuilder salary(double salary) {
		verifyMutable();
		this.salary = salary;
		return this;
	}

	private List<StudentBuilder> students;
	
	public List<StudentBuilder> getStudents() {
		return students;
	}

	public void setStudents(List<StudentBuilder> students) {
		verifyMutable();
		this.students = students;
	}

	public TeacherBuilder students(StudentBuilder ... students) {
		verifyMutable();
		return students(new ListBuilder<StudentBuilder>().add(students).toList());
	}
	
	public TeacherBuilder students(Collection<StudentBuilder> students) {
		verifyMutable();
		if (this.students == null) {
			this.students = new ArrayList<StudentBuilder>();
		}
		if (students != null) {
			for (StudentBuilder e : students) {
				this.students.add(e);
			}
		}
		return this;
	}

    public TeacherBuilder students$wrap(Student ... students) {
    	return students$wrap(new ListBuilder<Student>().add(students).toList());
    }

    public TeacherBuilder students$wrap(Collection<Student> students) {
		verifyMutable();

		if (this.students == null) {
			this.students = new ArrayList<StudentBuilder>();
		}
		if (students != null) {
			for (Student e : students) {
				StudentBuilder wrapped = new WrapConverter(this.$$$option).convert(e).to(StudentBuilder.class);
				this.students.add(wrapped);
			}
		}
		return this;
    }
    
    public TeacherBuilder students$restoreFrom(BuilderRepository repo, Object ... builderIds) {
    	return students$restoreFrom(repo, new ListBuilder<Object>().add(builderIds).toList());
    }

    public TeacherBuilder students$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		verifyMutable();

		if (this.students == null) {
			this.students = new ArrayList<StudentBuilder>();
		}
		if (builderIds != null) {
	    	for (Object builderId : builderIds) {
	            Object restoredObject = repo.get(builderId);
	            if (restoredObject == null) {
	            	if (repo.isSupportLazy()) {
	            		repo.addObjectStoredListener(builderId, new Procedure() {
	    					public void execute(Object... arguments) {
	    						TeacherBuilder.this.students.add((StudentBuilder)arguments[0]);
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
	                this.students.add((StudentBuilder)restoredObject);
	            }
	    	}
		}
        return this;
    }

	@Override
	public TeacherBuilder name(String name) {
		return (TeacherBuilder)super.name(name);
	}

	@Override
	public TeacherBuilder age(int age) {
		return (TeacherBuilder)super.age(age);
	}

	@Override
	public TeacherBuilder gender(Gender gender) {
		return (TeacherBuilder)super.gender(gender);
	}

	@Override
	public TeacherBuilder parent(PersonBuilder parent) {
		return (TeacherBuilder)super.parent(parent);
	}

	@Override
    public TeacherBuilder parent$wrap(Person parent) {
		return (TeacherBuilder)super.parent$wrap(parent);
    }

	@Override
    public TeacherBuilder parent$restoreFrom(BuilderRepository repo, Object builderId) {
		return (TeacherBuilder)super.parent$restoreFrom(repo, builderId);
    }

	@Override
	public TeacherBuilder children(PersonBuilder ... children) {
		return (TeacherBuilder)super.children(children);
	}

	@Override
	public TeacherBuilder children(Collection<PersonBuilder> children) {
		return (TeacherBuilder)super.children(children);
	}

	@Override
    public TeacherBuilder children$wrap(Person ... children) {
		return (TeacherBuilder)super.children$wrap(children);
    }

	@Override
    public TeacherBuilder children$wrap(Collection<Person> children) {
		return (TeacherBuilder)super.children$wrap(children);
    }

	@Override
    public TeacherBuilder children$restoreFrom(BuilderRepository repo, Object ... builderIds) {
		return (TeacherBuilder)super.children$restoreFrom(repo, builderIds);
    }

	@Override
    public TeacherBuilder children$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		return (TeacherBuilder)super.children$restoreFrom(repo, builderIds);
    }

	@Override
	public TeacherBuilder hobbies(HobbyBuilder ... hobbies) {
		return (TeacherBuilder)super.hobbies(hobbies);
	}

	@Override
	public TeacherBuilder hobbies(Collection<HobbyBuilder> hobbies) {
		return (TeacherBuilder)super.hobbies(hobbies);
	}

	@Override
    public TeacherBuilder hobbies$wrap(Hobby ... hobbies) {
		return (TeacherBuilder)super.hobbies$wrap(hobbies);
    }

	@Override
    public TeacherBuilder hobbies$wrap(Collection<Hobby> hobbies) {
		return (TeacherBuilder)super.hobbies$wrap(hobbies);
    }

	@Override
    public TeacherBuilder hobbies$restoreFrom(BuilderRepository repo, Object ... builderIds) {
		return (TeacherBuilder)super.hobbies$restoreFrom(repo, builderIds);
    }

	@Override
    public TeacherBuilder hobbies$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		return (TeacherBuilder)super.hobbies$restoreFrom(repo, builderIds);
    }

	@Override
	public TeacherBuilder speeches(SpeechBuilder ... speeches) {
		return (TeacherBuilder)super.speeches(speeches);
	}

	@Override
	public TeacherBuilder speeches(Collection<SpeechBuilder> speeches) {
		return (TeacherBuilder)super.speeches(speeches);
	}

	@Override
    public TeacherBuilder speeches$wrap(Speech ... speeches) {
		return (TeacherBuilder)super.speeches$wrap(speeches);
    }

	@Override
    public TeacherBuilder speeches$wrap(Collection<Speech> speeches) {
		return (TeacherBuilder)super.speeches$wrap(speeches);
    }

	@Override
    public TeacherBuilder speeches$restoreFrom(BuilderRepository repo, Object ... builderIds) {
		return (TeacherBuilder)super.speeches$restoreFrom(repo, builderIds);
    }

	@Override
    public TeacherBuilder speeches$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		return (TeacherBuilder)super.speeches$restoreFrom(repo, builderIds);
    }

	@Override
	public TeacherBuilder friends(PersonBuilder ... friends) {
		return (TeacherBuilder)super.friends(friends);
	}

	@Override
	public TeacherBuilder friends(Collection<PersonBuilder> friends) {
		return (TeacherBuilder)super.friends(friends);
	}

	@Override
    public TeacherBuilder friends$wrap(Person ... friends) {
		return (TeacherBuilder)super.friends$wrap(friends);
    }

	@Override
    public TeacherBuilder friends$wrap(Collection<Person> friends) {
		return (TeacherBuilder)super.friends$wrap(friends);
    }

	@Override
    public TeacherBuilder friends$restoreFrom(BuilderRepository repo, Object ... builderIds) {
		return (TeacherBuilder)super.friends$restoreFrom(repo, builderIds);
    }

	@Override
    public TeacherBuilder friends$restoreFrom(BuilderRepository repo, Collection<Object> builderIds) {
		return (TeacherBuilder)super.friends$restoreFrom(repo, builderIds);
    }
}

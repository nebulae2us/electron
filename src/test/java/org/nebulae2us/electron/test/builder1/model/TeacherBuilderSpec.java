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
    public TeacherBuilderSpec<P> storeTo(BuilderRepository repo, Object builderId) {
    	repo.put(builderId, this);
    	return this;
    }

	@Override
	public Teacher getWrappedObject() {
		return (Teacher)this.$$$wrapped;
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
				CollectionUtils.addItem(this.students, e);
			}
		}
		return this;
	}

	public StudentBuilderSpec<? extends TeacherBuilderSpec<P>> students$addStudent() {
		verifyMutable();
		if (this.students == null) {
			this.students = new ArrayList<StudentBuilderSpec<?>>();
		}
		
		StudentBuilderSpec<TeacherBuilderSpec<P>> result =
				new StudentBuilderSpec<TeacherBuilderSpec<P>>(this);
		
		CollectionUtils.addItem(this.students, result);
		
		return result;
	}
	

	public class Students$$$builder<P1 extends TeacherBuilderSpec<P>> {
	
		private final P1 $$$parentBuilder1;
	
		protected Students$$$builder(P1 parentBuilder) {
			this.$$$parentBuilder1 = parentBuilder;
		}

		public StudentBuilderSpec<Students$$$builder<P1>> student$begin() {
			StudentBuilderSpec<Students$$$builder<P1>> result = new StudentBuilderSpec<Students$$$builder<P1>>(this);
			CollectionUtils.addItem(TeacherBuilderSpec.this.students, result);
			return result;
		}
		

		public P1 end() {
			return this.$$$parentBuilder1;
		}
	}
	
	public Students$$$builder<? extends TeacherBuilderSpec<P>> students$list() {
		verifyMutable();
		if (this.students == null) {
			this.students = new ArrayList<StudentBuilderSpec<?>>();
		}
		return new Students$$$builder<TeacherBuilderSpec<P>>(this);
	}

    public TeacherBuilderSpec<P> students$wrap(Student ... students) {
    	return students$wrap(new ListBuilder<Student>().add(students).toList());
    }

    public TeacherBuilderSpec<P> students$wrap(Collection<? extends Student> students) {
		verifyMutable();

		if (this.students == null) {
			this.students = new ArrayList<StudentBuilderSpec<?>>();
		}
		if (students != null) {
			for (Student e : students) {
				StudentBuilderSpec<?> wrapped = new WrapConverter(BuilderSpecs.DESTINATION_CLASS_RESOLVER).convert(e).to(StudentBuilderSpec.class);
				CollectionUtils.addItem(this.students, wrapped);
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
	    						CollectionUtils.addItem(TeacherBuilderSpec.this.students, arguments[0]);
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
	                CollectionUtils.addItem(this.students, restoredObject);
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

	@SuppressWarnings("unchecked")
	@Override
	public PersonBuilderSpec<? extends TeacherBuilderSpec<P>> parent$begin() {
		return (PersonBuilderSpec<? extends TeacherBuilderSpec<P>>)super.parent$begin();
	}

	@Override
	public StudentBuilderSpec<? extends TeacherBuilderSpec<P>> parent$asStudent$begin() {
		return (StudentBuilderSpec<? extends TeacherBuilderSpec<P>>)super.parent$asStudent$begin();
	}

	@Override
	public TeacherBuilderSpec<? extends TeacherBuilderSpec<P>> parent$asTeacher$begin() {
		return (TeacherBuilderSpec<? extends TeacherBuilderSpec<P>>)super.parent$asTeacher$begin();
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
	public PersonBuilderSpec<? extends TeacherBuilderSpec<P>> children$addPerson() {
		return (PersonBuilderSpec<? extends TeacherBuilderSpec<P>>)super.children$addPerson();
	}
	
	@Override
	public StudentBuilderSpec<? extends TeacherBuilderSpec<P>> children$addStudent() {
		return (StudentBuilderSpec<? extends TeacherBuilderSpec<P>>)super.children$addStudent();
	}
	
	@Override
	public TeacherBuilderSpec<? extends TeacherBuilderSpec<P>> children$addTeacher() {
		return (TeacherBuilderSpec<? extends TeacherBuilderSpec<P>>)super.children$addTeacher();
	}
	

	public Children$$$builder<? extends TeacherBuilderSpec<P>> children$list() {
		return (Children$$$builder<? extends TeacherBuilderSpec<P>>)super.children$list();
	}
	
	@Override
    public TeacherBuilderSpec<P> children$wrap(Person ... children) {
		return (TeacherBuilderSpec<P>)super.children$wrap(children);
    }

	@Override
    public TeacherBuilderSpec<P> children$wrap(Collection<? extends Person> children) {
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
	public HobbyBuilderSpec<? extends TeacherBuilderSpec<P>> hobbies$addHobby() {
		return (HobbyBuilderSpec<? extends TeacherBuilderSpec<P>>)super.hobbies$addHobby();
	}
	

	public Hobbies$$$builder<? extends TeacherBuilderSpec<P>> hobbies$list() {
		return (Hobbies$$$builder<? extends TeacherBuilderSpec<P>>)super.hobbies$list();
	}
	
	@Override
    public TeacherBuilderSpec<P> hobbies$wrap(Hobby ... hobbies) {
		return (TeacherBuilderSpec<P>)super.hobbies$wrap(hobbies);
    }

	@Override
    public TeacherBuilderSpec<P> hobbies$wrap(Collection<? extends Hobby> hobbies) {
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
	public SpeechBuilderSpec<? extends TeacherBuilderSpec<P>> speeches$addSpeech() {
		return (SpeechBuilderSpec<? extends TeacherBuilderSpec<P>>)super.speeches$addSpeech();
	}
	

	public Speeches$$$builder<? extends TeacherBuilderSpec<P>> speeches$list() {
		return (Speeches$$$builder<? extends TeacherBuilderSpec<P>>)super.speeches$list();
	}
	
	@Override
    public TeacherBuilderSpec<P> speeches$wrap(Speech ... speeches) {
		return (TeacherBuilderSpec<P>)super.speeches$wrap(speeches);
    }

	@Override
    public TeacherBuilderSpec<P> speeches$wrap(Collection<? extends Speech> speeches) {
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
	public PersonBuilderSpec<? extends TeacherBuilderSpec<P>> friends$addPerson() {
		return (PersonBuilderSpec<? extends TeacherBuilderSpec<P>>)super.friends$addPerson();
	}
	
	@Override
	public StudentBuilderSpec<? extends TeacherBuilderSpec<P>> friends$addStudent() {
		return (StudentBuilderSpec<? extends TeacherBuilderSpec<P>>)super.friends$addStudent();
	}
	
	@Override
	public TeacherBuilderSpec<? extends TeacherBuilderSpec<P>> friends$addTeacher() {
		return (TeacherBuilderSpec<? extends TeacherBuilderSpec<P>>)super.friends$addTeacher();
	}
	

	public Friends$$$builder<? extends TeacherBuilderSpec<P>> friends$list() {
		return (Friends$$$builder<? extends TeacherBuilderSpec<P>>)super.friends$list();
	}
	
	@Override
    public TeacherBuilderSpec<P> friends$wrap(Person ... friends) {
		return (TeacherBuilderSpec<P>)super.friends$wrap(friends);
    }

	@Override
    public TeacherBuilderSpec<P> friends$wrap(Collection<? extends Person> friends) {
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

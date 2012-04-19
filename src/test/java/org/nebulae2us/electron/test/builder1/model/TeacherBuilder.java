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
    public TeacherBuilder<P> storeTo(BuilderRepository repo, Object builderId) {
    	repo.put(builderId, this);
    	return this;
    }

	@Override
	public Teacher getWrappedObject() {
		return (Teacher)this.$$$wrapped;
	}

    public Teacher toTeacher() {
    	return new Converter(new DestinationClassResolverByAnnotation(), true).convert(this).to(Teacher.class);
    }
    

	@Override
    public Teacher toPerson() {
    	return new Converter(new DestinationClassResolverByAnnotation(), true).convert(this).to(Teacher.class);
    }
    


	private double salary;
	
	public double getSalary() {
		if (this.$$$wrapped != null && WrapHelper.valueNotSet(this.salary, double.class)) {
			Object o = WrapHelper.getValue(this.$$$wrapped, Teacher.class, "salary");
			this.salary = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER).convert(o).to(double.class);
		}

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
		if (this.$$$wrapped != null && WrapHelper.valueNotSet(this.students, List.class)) {
			Object o = WrapHelper.getValue(this.$$$wrapped, Teacher.class, "students");
			this.students = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER).convert(o).to(List.class);
		}

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
				CollectionUtils.addItem(this.students, e);
			}
		}
		return this;
	}

	public StudentBuilder<? extends TeacherBuilder<P>> students$addStudent() {
		verifyMutable();
		if (this.students == null) {
			this.students = new ArrayList<StudentBuilder<?>>();
		}
		
		StudentBuilder<TeacherBuilder<P>> result =
				new StudentBuilder<TeacherBuilder<P>>(this);
		
		CollectionUtils.addItem(this.students, result);
		
		return result;
	}
	

	public class Students$$$builder<P1 extends TeacherBuilder<P>> {
	
		private final P1 $$$parentBuilder1;
	
		protected Students$$$builder(P1 parentBuilder) {
			this.$$$parentBuilder1 = parentBuilder;
		}

		public StudentBuilder<Students$$$builder<P1>> student$begin() {
			StudentBuilder<Students$$$builder<P1>> result = new StudentBuilder<Students$$$builder<P1>>(this);
			CollectionUtils.addItem(TeacherBuilder.this.students, result);
			return result;
		}
		

		public P1 end() {
			return this.$$$parentBuilder1;
		}
	}
	
	public Students$$$builder<? extends TeacherBuilder<P>> students$list() {
		verifyMutable();
		if (this.students == null) {
			this.students = new ArrayList<StudentBuilder<?>>();
		}
		return new Students$$$builder<TeacherBuilder<P>>(this);
	}

    public TeacherBuilder<P> students$wrap(Student ... students) {
    	return students$wrap(new ListBuilder<Student>().add(students).toList());
    }

    public TeacherBuilder<P> students$wrap(Collection<? extends Student> students) {
		verifyMutable();

		if (this.students == null) {
			this.students = new ArrayList<StudentBuilder<?>>();
		}
		if (students != null) {
			for (Student e : students) {
				StudentBuilder<?> wrapped = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER).convert(e).to(StudentBuilder.class);
				CollectionUtils.addItem(this.students, wrapped);
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
	    						CollectionUtils.addItem(TeacherBuilder.this.students, arguments[0]);
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
	                CollectionUtils.addItem(this.students, restoredObject);
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

	@Override
    public TeacherBuilder<P> parent$wrap(Person parent) {
		return (TeacherBuilder<P>)super.parent$wrap(parent);
    }

	@Override
    public TeacherBuilder<P> parent$restoreFrom(BuilderRepository repo, Object builderId) {
		return (TeacherBuilder<P>)super.parent$restoreFrom(repo, builderId);
    }

	@SuppressWarnings("unchecked")
	@Override
	public PersonBuilder<? extends TeacherBuilder<P>> parent$begin() {
		return (PersonBuilder<? extends TeacherBuilder<P>>)super.parent$begin();
	}

	@Override
	public StudentBuilder<? extends TeacherBuilder<P>> parent$asStudent$begin() {
		return (StudentBuilder<? extends TeacherBuilder<P>>)super.parent$asStudent$begin();
	}

	@Override
	public TeacherBuilder<? extends TeacherBuilder<P>> parent$asTeacher$begin() {
		return (TeacherBuilder<? extends TeacherBuilder<P>>)super.parent$asTeacher$begin();
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
	public PersonBuilder<? extends TeacherBuilder<P>> children$addPerson() {
		return (PersonBuilder<? extends TeacherBuilder<P>>)super.children$addPerson();
	}
	
	@Override
	public StudentBuilder<? extends TeacherBuilder<P>> children$addStudent() {
		return (StudentBuilder<? extends TeacherBuilder<P>>)super.children$addStudent();
	}
	
	@Override
	public TeacherBuilder<? extends TeacherBuilder<P>> children$addTeacher() {
		return (TeacherBuilder<? extends TeacherBuilder<P>>)super.children$addTeacher();
	}
	

	public Children$$$builder<? extends TeacherBuilder<P>> children$list() {
		return (Children$$$builder<? extends TeacherBuilder<P>>)super.children$list();
	}
	
	@Override
    public TeacherBuilder<P> children$wrap(Person ... children) {
		return (TeacherBuilder<P>)super.children$wrap(children);
    }

	@Override
    public TeacherBuilder<P> children$wrap(Collection<? extends Person> children) {
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
	public HobbyBuilder<? extends TeacherBuilder<P>> hobbies$addHobby() {
		return (HobbyBuilder<? extends TeacherBuilder<P>>)super.hobbies$addHobby();
	}
	

	public Hobbies$$$builder<? extends TeacherBuilder<P>> hobbies$list() {
		return (Hobbies$$$builder<? extends TeacherBuilder<P>>)super.hobbies$list();
	}
	
	@Override
    public TeacherBuilder<P> hobbies$wrap(Hobby ... hobbies) {
		return (TeacherBuilder<P>)super.hobbies$wrap(hobbies);
    }

	@Override
    public TeacherBuilder<P> hobbies$wrap(Collection<? extends Hobby> hobbies) {
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
	public SpeechBuilder<? extends TeacherBuilder<P>> speeches$addSpeech() {
		return (SpeechBuilder<? extends TeacherBuilder<P>>)super.speeches$addSpeech();
	}
	

	public Speeches$$$builder<? extends TeacherBuilder<P>> speeches$list() {
		return (Speeches$$$builder<? extends TeacherBuilder<P>>)super.speeches$list();
	}
	
	@Override
    public TeacherBuilder<P> speeches$wrap(Speech ... speeches) {
		return (TeacherBuilder<P>)super.speeches$wrap(speeches);
    }

	@Override
    public TeacherBuilder<P> speeches$wrap(Collection<? extends Speech> speeches) {
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
	public PersonBuilder<? extends TeacherBuilder<P>> friends$addPerson() {
		return (PersonBuilder<? extends TeacherBuilder<P>>)super.friends$addPerson();
	}
	
	@Override
	public StudentBuilder<? extends TeacherBuilder<P>> friends$addStudent() {
		return (StudentBuilder<? extends TeacherBuilder<P>>)super.friends$addStudent();
	}
	
	@Override
	public TeacherBuilder<? extends TeacherBuilder<P>> friends$addTeacher() {
		return (TeacherBuilder<? extends TeacherBuilder<P>>)super.friends$addTeacher();
	}
	

	public Friends$$$builder<? extends TeacherBuilder<P>> friends$list() {
		return (Friends$$$builder<? extends TeacherBuilder<P>>)super.friends$list();
	}
	
	@Override
    public TeacherBuilder<P> friends$wrap(Person ... friends) {
		return (TeacherBuilder<P>)super.friends$wrap(friends);
    }

	@Override
    public TeacherBuilder<P> friends$wrap(Collection<? extends Person> friends) {
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


    /* CUSTOM CODE *********************************
     * 
     * Put your own custom code below. These codes won't be discarded during generation.
     * 
     */
     
     
     
}

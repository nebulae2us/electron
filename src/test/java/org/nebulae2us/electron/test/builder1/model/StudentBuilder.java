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
    public StudentBuilder<P> storeTo(BuilderRepository repo, Object builderId) {
    	repo.put(builderId, this);
    	return this;
    }

	@Override
	public Student getWrappedObject() {
		return (Student)this.$$$wrapped;
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
		if (this.$$$wrapped != null && WrapHelper.valueNotSet(this.partTime, boolean.class)) {
			Object o = WrapHelper.getValue(this.$$$wrapped, Student.class, "partTime");
			this.partTime = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER).convert(o).to(boolean.class);
		}

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
		if (this.$$$wrapped != null && WrapHelper.valueNotSet(this.teachers, List.class)) {
			Object o = WrapHelper.getValue(this.$$$wrapped, Student.class, "teachers");
			this.teachers = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER).convert(o).to(List.class);
		}

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
				CollectionUtils.addItem(this.teachers, e);
			}
		}
		return this;
	}

	public TeacherBuilder<? extends StudentBuilder<P>> teachers$addTeacher() {
		verifyMutable();
		if (this.teachers == null) {
			this.teachers = new ArrayList<TeacherBuilder<?>>();
		}
		
		TeacherBuilder<StudentBuilder<P>> result =
				new TeacherBuilder<StudentBuilder<P>>(this);
		
		CollectionUtils.addItem(this.teachers, result);
		
		return result;
	}
	

	public class Teachers$$$builder<P1 extends StudentBuilder<P>> {
	
		private final P1 $$$parentBuilder1;
	
		protected Teachers$$$builder(P1 parentBuilder) {
			this.$$$parentBuilder1 = parentBuilder;
		}

		public TeacherBuilder<Teachers$$$builder<P1>> teacher$begin() {
			TeacherBuilder<Teachers$$$builder<P1>> result = new TeacherBuilder<Teachers$$$builder<P1>>(this);
			CollectionUtils.addItem(StudentBuilder.this.teachers, result);
			return result;
		}
		

		public P1 end() {
			return this.$$$parentBuilder1;
		}
	}
	
	public Teachers$$$builder<? extends StudentBuilder<P>> teachers$list() {
		verifyMutable();
		if (this.teachers == null) {
			this.teachers = new ArrayList<TeacherBuilder<?>>();
		}
		return new Teachers$$$builder<StudentBuilder<P>>(this);
	}

    public StudentBuilder<P> teachers$wrap(Teacher ... teachers) {
    	return teachers$wrap(new ListBuilder<Teacher>().add(teachers).toList());
    }

    public StudentBuilder<P> teachers$wrap(Collection<? extends Teacher> teachers) {
		verifyMutable();

		if (this.teachers == null) {
			this.teachers = new ArrayList<TeacherBuilder<?>>();
		}
		if (teachers != null) {
			for (Teacher e : teachers) {
				TeacherBuilder<?> wrapped = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER).convert(e).to(TeacherBuilder.class);
				CollectionUtils.addItem(this.teachers, wrapped);
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
	    						CollectionUtils.addItem(StudentBuilder.this.teachers, arguments[0]);
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
	                CollectionUtils.addItem(this.teachers, restoredObject);
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

	@Override
    public StudentBuilder<P> parent$wrap(Person parent) {
		return (StudentBuilder<P>)super.parent$wrap(parent);
    }

	@Override
    public StudentBuilder<P> parent$restoreFrom(BuilderRepository repo, Object builderId) {
		return (StudentBuilder<P>)super.parent$restoreFrom(repo, builderId);
    }

	@SuppressWarnings("unchecked")
	@Override
	public PersonBuilder<? extends StudentBuilder<P>> parent$begin() {
		return (PersonBuilder<? extends StudentBuilder<P>>)super.parent$begin();
	}

	@Override
	public StudentBuilder<? extends StudentBuilder<P>> parent$asStudent$begin() {
		return (StudentBuilder<? extends StudentBuilder<P>>)super.parent$asStudent$begin();
	}

	@Override
	public TeacherBuilder<? extends StudentBuilder<P>> parent$asTeacher$begin() {
		return (TeacherBuilder<? extends StudentBuilder<P>>)super.parent$asTeacher$begin();
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
	public PersonBuilder<? extends StudentBuilder<P>> children$addPerson() {
		return (PersonBuilder<? extends StudentBuilder<P>>)super.children$addPerson();
	}
	
	@Override
	public StudentBuilder<? extends StudentBuilder<P>> children$addStudent() {
		return (StudentBuilder<? extends StudentBuilder<P>>)super.children$addStudent();
	}
	
	@Override
	public TeacherBuilder<? extends StudentBuilder<P>> children$addTeacher() {
		return (TeacherBuilder<? extends StudentBuilder<P>>)super.children$addTeacher();
	}
	

	public Children$$$builder<? extends StudentBuilder<P>> children$list() {
		return (Children$$$builder<? extends StudentBuilder<P>>)super.children$list();
	}
	
	@Override
    public StudentBuilder<P> children$wrap(Person ... children) {
		return (StudentBuilder<P>)super.children$wrap(children);
    }

	@Override
    public StudentBuilder<P> children$wrap(Collection<? extends Person> children) {
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
	public HobbyBuilder<? extends StudentBuilder<P>> hobbies$addHobby() {
		return (HobbyBuilder<? extends StudentBuilder<P>>)super.hobbies$addHobby();
	}
	

	public Hobbies$$$builder<? extends StudentBuilder<P>> hobbies$list() {
		return (Hobbies$$$builder<? extends StudentBuilder<P>>)super.hobbies$list();
	}
	
	@Override
    public StudentBuilder<P> hobbies$wrap(Hobby ... hobbies) {
		return (StudentBuilder<P>)super.hobbies$wrap(hobbies);
    }

	@Override
    public StudentBuilder<P> hobbies$wrap(Collection<? extends Hobby> hobbies) {
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
	public SpeechBuilder<? extends StudentBuilder<P>> speeches$addSpeech() {
		return (SpeechBuilder<? extends StudentBuilder<P>>)super.speeches$addSpeech();
	}
	

	public Speeches$$$builder<? extends StudentBuilder<P>> speeches$list() {
		return (Speeches$$$builder<? extends StudentBuilder<P>>)super.speeches$list();
	}
	
	@Override
    public StudentBuilder<P> speeches$wrap(Speech ... speeches) {
		return (StudentBuilder<P>)super.speeches$wrap(speeches);
    }

	@Override
    public StudentBuilder<P> speeches$wrap(Collection<? extends Speech> speeches) {
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
	public PersonBuilder<? extends StudentBuilder<P>> friends$addPerson() {
		return (PersonBuilder<? extends StudentBuilder<P>>)super.friends$addPerson();
	}
	
	@Override
	public StudentBuilder<? extends StudentBuilder<P>> friends$addStudent() {
		return (StudentBuilder<? extends StudentBuilder<P>>)super.friends$addStudent();
	}
	
	@Override
	public TeacherBuilder<? extends StudentBuilder<P>> friends$addTeacher() {
		return (TeacherBuilder<? extends StudentBuilder<P>>)super.friends$addTeacher();
	}
	

	public Friends$$$builder<? extends StudentBuilder<P>> friends$list() {
		return (Friends$$$builder<? extends StudentBuilder<P>>)super.friends$list();
	}
	
	@Override
    public StudentBuilder<P> friends$wrap(Person ... friends) {
		return (StudentBuilder<P>)super.friends$wrap(friends);
    }

	@Override
    public StudentBuilder<P> friends$wrap(Collection<? extends Person> friends) {
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


    /* CUSTOM CODE *********************************
     * 
     * Put your own custom code below. These codes won't be discarded during generation.
     * 
     */
     
     
     
}

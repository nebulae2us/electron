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
    public StudentBuilderSpec<P> storeTo(BuilderRepository repo, Object builderId) {
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

	public StudentBuilderSpec<P> partTime(boolean partTime) {
		verifyMutable();
		this.partTime = partTime;
		return this;
	}

	private List<TeacherBuilderSpec<?>> teachers;
	
	public List<TeacherBuilderSpec<?>> getTeachers() {
		if (this.$$$wrapped != null && WrapHelper.valueNotSet(this.teachers, List.class)) {
			Object o = WrapHelper.getValue(this.$$$wrapped, Student.class, "teachers");
			this.teachers = new WrapConverter(Builders.DESTINATION_CLASS_RESOLVER).convert(o).to(List.class);
		}

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
				CollectionUtils.addItem(this.teachers, e);
			}
		}
		return this;
	}

	public TeacherBuilderSpec<? extends StudentBuilderSpec<P>> teachers$addTeacher() {
		verifyMutable();
		if (this.teachers == null) {
			this.teachers = new ArrayList<TeacherBuilderSpec<?>>();
		}
		
		TeacherBuilderSpec<StudentBuilderSpec<P>> result =
				new TeacherBuilderSpec<StudentBuilderSpec<P>>(this);
		
		CollectionUtils.addItem(this.teachers, result);
		
		return result;
	}
	

	public class Teachers$$$builder<P1 extends StudentBuilderSpec<P>> {
	
		private final P1 $$$parentBuilder1;
	
		protected Teachers$$$builder(P1 parentBuilder) {
			this.$$$parentBuilder1 = parentBuilder;
		}

		public TeacherBuilderSpec<Teachers$$$builder<P1>> teacher$begin() {
			TeacherBuilderSpec<Teachers$$$builder<P1>> result = new TeacherBuilderSpec<Teachers$$$builder<P1>>(this);
			CollectionUtils.addItem(StudentBuilderSpec.this.teachers, result);
			return result;
		}
		

		public P1 end() {
			return this.$$$parentBuilder1;
		}
	}
	
	public Teachers$$$builder<? extends StudentBuilderSpec<P>> teachers$list() {
		verifyMutable();
		if (this.teachers == null) {
			this.teachers = new ArrayList<TeacherBuilderSpec<?>>();
		}
		return new Teachers$$$builder<StudentBuilderSpec<P>>(this);
	}

    public StudentBuilderSpec<P> teachers$wrap(Teacher ... teachers) {
    	return teachers$wrap(new ListBuilder<Teacher>().add(teachers).toList());
    }

    public StudentBuilderSpec<P> teachers$wrap(Collection<? extends Teacher> teachers) {
		verifyMutable();

		if (this.teachers == null) {
			this.teachers = new ArrayList<TeacherBuilderSpec<?>>();
		}
		if (teachers != null) {
			for (Teacher e : teachers) {
				TeacherBuilderSpec<?> wrapped = new WrapConverter(BuilderSpecs.DESTINATION_CLASS_RESOLVER).convert(e).to(TeacherBuilderSpec.class);
				CollectionUtils.addItem(this.teachers, wrapped);
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
	    						CollectionUtils.addItem(StudentBuilderSpec.this.teachers, arguments[0]);
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
	                CollectionUtils.addItem(this.teachers, restoredObject);
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

	@SuppressWarnings("unchecked")
	@Override
	public PersonBuilderSpec<? extends StudentBuilderSpec<P>> parent$begin() {
		return (PersonBuilderSpec<? extends StudentBuilderSpec<P>>)super.parent$begin();
	}

	@Override
	public StudentBuilderSpec<? extends StudentBuilderSpec<P>> parent$asStudent$begin() {
		return (StudentBuilderSpec<? extends StudentBuilderSpec<P>>)super.parent$asStudent$begin();
	}

	@Override
	public TeacherBuilderSpec<? extends StudentBuilderSpec<P>> parent$asTeacher$begin() {
		return (TeacherBuilderSpec<? extends StudentBuilderSpec<P>>)super.parent$asTeacher$begin();
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
	public PersonBuilderSpec<? extends StudentBuilderSpec<P>> children$addPerson() {
		return (PersonBuilderSpec<? extends StudentBuilderSpec<P>>)super.children$addPerson();
	}
	
	@Override
	public StudentBuilderSpec<? extends StudentBuilderSpec<P>> children$addStudent() {
		return (StudentBuilderSpec<? extends StudentBuilderSpec<P>>)super.children$addStudent();
	}
	
	@Override
	public TeacherBuilderSpec<? extends StudentBuilderSpec<P>> children$addTeacher() {
		return (TeacherBuilderSpec<? extends StudentBuilderSpec<P>>)super.children$addTeacher();
	}
	

	public Children$$$builder<? extends StudentBuilderSpec<P>> children$list() {
		return (Children$$$builder<? extends StudentBuilderSpec<P>>)super.children$list();
	}
	
	@Override
    public StudentBuilderSpec<P> children$wrap(Person ... children) {
		return (StudentBuilderSpec<P>)super.children$wrap(children);
    }

	@Override
    public StudentBuilderSpec<P> children$wrap(Collection<? extends Person> children) {
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
	public HobbyBuilderSpec<? extends StudentBuilderSpec<P>> hobbies$addHobby() {
		return (HobbyBuilderSpec<? extends StudentBuilderSpec<P>>)super.hobbies$addHobby();
	}
	

	public Hobbies$$$builder<? extends StudentBuilderSpec<P>> hobbies$list() {
		return (Hobbies$$$builder<? extends StudentBuilderSpec<P>>)super.hobbies$list();
	}
	
	@Override
    public StudentBuilderSpec<P> hobbies$wrap(Hobby ... hobbies) {
		return (StudentBuilderSpec<P>)super.hobbies$wrap(hobbies);
    }

	@Override
    public StudentBuilderSpec<P> hobbies$wrap(Collection<? extends Hobby> hobbies) {
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
	public SpeechBuilderSpec<? extends StudentBuilderSpec<P>> speeches$addSpeech() {
		return (SpeechBuilderSpec<? extends StudentBuilderSpec<P>>)super.speeches$addSpeech();
	}
	

	public Speeches$$$builder<? extends StudentBuilderSpec<P>> speeches$list() {
		return (Speeches$$$builder<? extends StudentBuilderSpec<P>>)super.speeches$list();
	}
	
	@Override
    public StudentBuilderSpec<P> speeches$wrap(Speech ... speeches) {
		return (StudentBuilderSpec<P>)super.speeches$wrap(speeches);
    }

	@Override
    public StudentBuilderSpec<P> speeches$wrap(Collection<? extends Speech> speeches) {
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
	public PersonBuilderSpec<? extends StudentBuilderSpec<P>> friends$addPerson() {
		return (PersonBuilderSpec<? extends StudentBuilderSpec<P>>)super.friends$addPerson();
	}
	
	@Override
	public StudentBuilderSpec<? extends StudentBuilderSpec<P>> friends$addStudent() {
		return (StudentBuilderSpec<? extends StudentBuilderSpec<P>>)super.friends$addStudent();
	}
	
	@Override
	public TeacherBuilderSpec<? extends StudentBuilderSpec<P>> friends$addTeacher() {
		return (TeacherBuilderSpec<? extends StudentBuilderSpec<P>>)super.friends$addTeacher();
	}
	

	public Friends$$$builder<? extends StudentBuilderSpec<P>> friends$list() {
		return (Friends$$$builder<? extends StudentBuilderSpec<P>>)super.friends$list();
	}
	
	@Override
    public StudentBuilderSpec<P> friends$wrap(Person ... friends) {
		return (StudentBuilderSpec<P>)super.friends$wrap(friends);
    }

	@Override
    public StudentBuilderSpec<P> friends$wrap(Collection<? extends Person> friends) {
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


    /* CUSTOM CODE *********************************
     * 
     * Put your own custom code below. These codes won't be discarded during generation.
     * 
     */
     
     
     
}

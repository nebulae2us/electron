
package org.nebulae2us.electron.test.builder1.model;

import org.nebulae2us.electron.*;
import org.nebulae2us.electron.util.*;
import org.nebulae2us.electron.test.builder1.model.Hobby;
import org.nebulae2us.electron.test.builder1.model.HobbyBuilderSpec;
import org.nebulae2us.electron.test.builder1.model.Person;
import org.nebulae2us.electron.test.builder1.model.PersonBuilderSpec;
import org.nebulae2us.electron.test.builder1.model.Speech;
import org.nebulae2us.electron.test.builder1.model.SpeechBuilderSpec;
import org.nebulae2us.electron.test.builder1.model.Student;
import org.nebulae2us.electron.test.builder1.model.StudentBuilderSpec;
import org.nebulae2us.electron.test.builder1.model.Teacher;
import org.nebulae2us.electron.test.builder1.model.TeacherBuilderSpec;

public class BuilderSpecs {

	public static final DestinationClassResolver DESTINATION_CLASS_RESOLVER = new DestinationClassResolverByMap(
			new MapBuilder<Class<?>, Class<?>> ()
				.put(Hobby.class, HobbyBuilderSpec.class)
				.put(Person.class, PersonBuilderSpec.class)
				.put(Speech.class, SpeechBuilderSpec.class)
				.put(Student.class, StudentBuilderSpec.class)
				.put(Teacher.class, TeacherBuilderSpec.class)
			.toMap()
			);

	public static Converter converter() {
		return new Converter(DESTINATION_CLASS_RESOLVER, true);
	}

    public static HobbyBuilderSpec<?> hobby() {
        return new HobbyBuilderSpec<Object>();
    }

    public static HobbyBuilderSpec<?> hobby$restoreFrom(BuilderRepository repo, int builderId) {
        return (HobbyBuilderSpec<?>)repo.get(builderId);
    }

    public static HobbyBuilderSpec<?> hobby$copyFrom(Hobby hobby) {
    	HobbyBuilderSpec<?> result = new Converter(DESTINATION_CLASS_RESOLVER, false).convert(hobby).to(HobbyBuilderSpec.class);
    	return result;
    }
    
    public static HobbyBuilderSpec<?> wrap(Hobby hobby) {
    	return new WrapConverter(DESTINATION_CLASS_RESOLVER).convert(hobby).to(HobbyBuilderSpec.class);
    }

    public static PersonBuilderSpec<?> person() {
        return new PersonBuilderSpec<Object>();
    }

    public static PersonBuilderSpec<?> person$restoreFrom(BuilderRepository repo, int builderId) {
        return (PersonBuilderSpec<?>)repo.get(builderId);
    }

    public static PersonBuilderSpec<?> person$copyFrom(Person person) {
    	PersonBuilderSpec<?> result = new Converter(DESTINATION_CLASS_RESOLVER, false).convert(person).to(PersonBuilderSpec.class);
    	return result;
    }
    
    public static PersonBuilderSpec<?> wrap(Person person) {
    	return new WrapConverter(DESTINATION_CLASS_RESOLVER).convert(person).to(PersonBuilderSpec.class);
    }

    public static SpeechBuilderSpec<?> speech() {
        return new SpeechBuilderSpec<Object>();
    }

    public static SpeechBuilderSpec<?> speech$restoreFrom(BuilderRepository repo, int builderId) {
        return (SpeechBuilderSpec<?>)repo.get(builderId);
    }

    public static SpeechBuilderSpec<?> speech$copyFrom(Speech speech) {
    	SpeechBuilderSpec<?> result = new Converter(DESTINATION_CLASS_RESOLVER, false).convert(speech).to(SpeechBuilderSpec.class);
    	return result;
    }
    
    public static SpeechBuilderSpec<?> wrap(Speech speech) {
    	return new WrapConverter(DESTINATION_CLASS_RESOLVER).convert(speech).to(SpeechBuilderSpec.class);
    }

    public static StudentBuilderSpec<?> student() {
        return new StudentBuilderSpec<Object>();
    }

    public static StudentBuilderSpec<?> student$restoreFrom(BuilderRepository repo, int builderId) {
        return (StudentBuilderSpec<?>)repo.get(builderId);
    }

    public static StudentBuilderSpec<?> student$copyFrom(Student student) {
    	StudentBuilderSpec<?> result = new Converter(DESTINATION_CLASS_RESOLVER, false).convert(student).to(StudentBuilderSpec.class);
    	return result;
    }
    
    public static StudentBuilderSpec<?> wrap(Student student) {
    	return new WrapConverter(DESTINATION_CLASS_RESOLVER).convert(student).to(StudentBuilderSpec.class);
    }

    public static TeacherBuilderSpec<?> teacher() {
        return new TeacherBuilderSpec<Object>();
    }

    public static TeacherBuilderSpec<?> teacher$restoreFrom(BuilderRepository repo, int builderId) {
        return (TeacherBuilderSpec<?>)repo.get(builderId);
    }

    public static TeacherBuilderSpec<?> teacher$copyFrom(Teacher teacher) {
    	TeacherBuilderSpec<?> result = new Converter(DESTINATION_CLASS_RESOLVER, false).convert(teacher).to(TeacherBuilderSpec.class);
    	return result;
    }
    
    public static TeacherBuilderSpec<?> wrap(Teacher teacher) {
    	return new WrapConverter(DESTINATION_CLASS_RESOLVER).convert(teacher).to(TeacherBuilderSpec.class);
    }

    /* CUSTOM CODE *********************************
     * 
     * Put your own custom code below. These codes won't be discarded during generation.
     * 
     */
     
     
     
}

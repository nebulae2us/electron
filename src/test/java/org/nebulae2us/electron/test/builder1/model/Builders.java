
package org.nebulae2us.electron.test.builder1.model;

import org.nebulae2us.electron.*;
import org.nebulae2us.electron.util.*;
import org.nebulae2us.electron.test.builder1.model.Hobby;
import org.nebulae2us.electron.test.builder1.model.HobbyBuilder;
import org.nebulae2us.electron.test.builder1.model.Person;
import org.nebulae2us.electron.test.builder1.model.PersonBuilder;
import org.nebulae2us.electron.test.builder1.model.Speech;
import org.nebulae2us.electron.test.builder1.model.SpeechBuilder;
import org.nebulae2us.electron.test.builder1.model.Student;
import org.nebulae2us.electron.test.builder1.model.StudentBuilder;
import org.nebulae2us.electron.test.builder1.model.Teacher;
import org.nebulae2us.electron.test.builder1.model.TeacherBuilder;

public class Builders {

	public static final DestinationClassResolver DESTINATION_CLASS_RESOLVER = new DestinationClassResolverByMap(
			new MapBuilder<Class<?>, Class<?>> ()
				.put(Hobby.class, HobbyBuilder.class)
				.put(Person.class, PersonBuilder.class)
				.put(Speech.class, SpeechBuilder.class)
				.put(Student.class, StudentBuilder.class)
				.put(Teacher.class, TeacherBuilder.class)
			.toMap()
			);


    public static HobbyBuilder<?> hobby() {
        return new HobbyBuilder<Object>();
    }

    public static HobbyBuilder<?> hobby$restoreFrom(BuilderRepository repo, int builderId) {
        return (HobbyBuilder<?>)repo.get(builderId);
    }

    public static HobbyBuilder<?> hobby$copyFrom(Hobby hobby) {
    	HobbyBuilder<?> result = new Converter(DESTINATION_CLASS_RESOLVER, false).convert(hobby).to(HobbyBuilder.class);
    	return result;
    }
    
    public static HobbyBuilder<?> wrap(Hobby hobby) {
    	return new WrapConverter(DESTINATION_CLASS_RESOLVER).convert(hobby).to(HobbyBuilder.class);
    }

    public static PersonBuilder<?> person() {
        return new PersonBuilder<Object>();
    }

    public static PersonBuilder<?> person$restoreFrom(BuilderRepository repo, int builderId) {
        return (PersonBuilder<?>)repo.get(builderId);
    }

    public static PersonBuilder<?> person$copyFrom(Person person) {
    	PersonBuilder<?> result = new Converter(DESTINATION_CLASS_RESOLVER, false).convert(person).to(PersonBuilder.class);
    	return result;
    }
    
    public static PersonBuilder<?> wrap(Person person) {
    	return new WrapConverter(DESTINATION_CLASS_RESOLVER).convert(person).to(PersonBuilder.class);
    }

    public static SpeechBuilder<?> speech() {
        return new SpeechBuilder<Object>();
    }

    public static SpeechBuilder<?> speech$restoreFrom(BuilderRepository repo, int builderId) {
        return (SpeechBuilder<?>)repo.get(builderId);
    }

    public static SpeechBuilder<?> speech$copyFrom(Speech speech) {
    	SpeechBuilder<?> result = new Converter(DESTINATION_CLASS_RESOLVER, false).convert(speech).to(SpeechBuilder.class);
    	return result;
    }
    
    public static SpeechBuilder<?> wrap(Speech speech) {
    	return new WrapConverter(DESTINATION_CLASS_RESOLVER).convert(speech).to(SpeechBuilder.class);
    }

    public static StudentBuilder<?> student() {
        return new StudentBuilder<Object>();
    }

    public static StudentBuilder<?> student$restoreFrom(BuilderRepository repo, int builderId) {
        return (StudentBuilder<?>)repo.get(builderId);
    }

    public static StudentBuilder<?> student$copyFrom(Student student) {
    	StudentBuilder<?> result = new Converter(DESTINATION_CLASS_RESOLVER, false).convert(student).to(StudentBuilder.class);
    	return result;
    }
    
    public static StudentBuilder<?> wrap(Student student) {
    	return new WrapConverter(DESTINATION_CLASS_RESOLVER).convert(student).to(StudentBuilder.class);
    }

    public static TeacherBuilder<?> teacher() {
        return new TeacherBuilder<Object>();
    }

    public static TeacherBuilder<?> teacher$restoreFrom(BuilderRepository repo, int builderId) {
        return (TeacherBuilder<?>)repo.get(builderId);
    }

    public static TeacherBuilder<?> teacher$copyFrom(Teacher teacher) {
    	TeacherBuilder<?> result = new Converter(DESTINATION_CLASS_RESOLVER, false).convert(teacher).to(TeacherBuilder.class);
    	return result;
    }
    
    public static TeacherBuilder<?> wrap(Teacher teacher) {
    	return new WrapConverter(DESTINATION_CLASS_RESOLVER).convert(teacher).to(TeacherBuilder.class);
    }
}

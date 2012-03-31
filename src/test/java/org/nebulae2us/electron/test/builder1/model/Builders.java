
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

	public static final ConverterOption CONVERTER_OPTIONS = new ConverterOption(
			new MapBuilder<Class<?>, Class<?>> ()
				.put(Hobby.class, HobbyBuilder.class)
				.put(Person.class, PersonBuilder.class)
				.put(Speech.class, SpeechBuilder.class)
				.put(Student.class, StudentBuilder.class)
				.put(Teacher.class, TeacherBuilder.class)
			.toMap()
			);


    public static HobbyBuilder hobby() {
        return new HobbyBuilder(CONVERTER_OPTIONS);
    }

    public static HobbyBuilder hobby$restoreFrom(BuilderRepository repo, int builderId) {
        return (HobbyBuilder)repo.get(builderId);
    }

    public static HobbyBuilder hobby$copyFrom(Hobby hobby) {
    	HobbyBuilder result = new Converter(CONVERTER_OPTIONS, false).convert(hobby).to(HobbyBuilder.class);
    	return result;
    }

    public static PersonBuilder person() {
        return new PersonBuilder(CONVERTER_OPTIONS);
    }

    public static PersonBuilder person$restoreFrom(BuilderRepository repo, int builderId) {
        return (PersonBuilder)repo.get(builderId);
    }

    public static PersonBuilder person$copyFrom(Person person) {
    	PersonBuilder result = new Converter(CONVERTER_OPTIONS, false).convert(person).to(PersonBuilder.class);
    	return result;
    }

    public static SpeechBuilder speech() {
        return new SpeechBuilder(CONVERTER_OPTIONS);
    }

    public static SpeechBuilder speech$restoreFrom(BuilderRepository repo, int builderId) {
        return (SpeechBuilder)repo.get(builderId);
    }

    public static SpeechBuilder speech$copyFrom(Speech speech) {
    	SpeechBuilder result = new Converter(CONVERTER_OPTIONS, false).convert(speech).to(SpeechBuilder.class);
    	return result;
    }

    public static StudentBuilder student() {
        return new StudentBuilder(CONVERTER_OPTIONS);
    }

    public static StudentBuilder student$restoreFrom(BuilderRepository repo, int builderId) {
        return (StudentBuilder)repo.get(builderId);
    }

    public static StudentBuilder student$copyFrom(Student student) {
    	StudentBuilder result = new Converter(CONVERTER_OPTIONS, false).convert(student).to(StudentBuilder.class);
    	return result;
    }

    public static TeacherBuilder teacher() {
        return new TeacherBuilder(CONVERTER_OPTIONS);
    }

    public static TeacherBuilder teacher$restoreFrom(BuilderRepository repo, int builderId) {
        return (TeacherBuilder)repo.get(builderId);
    }

    public static TeacherBuilder teacher$copyFrom(Teacher teacher) {
    	TeacherBuilder result = new Converter(CONVERTER_OPTIONS, false).convert(teacher).to(TeacherBuilder.class);
    	return result;
    }
}

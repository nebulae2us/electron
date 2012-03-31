
package org.nebulae2us.electron.test.builder2.model;

import org.nebulae2us.electron.*;
import org.nebulae2us.electron.util.*;
import org.nebulae2us.electron.test.builder2.model.Blank;
import org.nebulae2us.electron.test.builder2.model.BlankBuilder;
import org.nebulae2us.electron.test.builder2.model.Sample;
import org.nebulae2us.electron.test.builder2.model.SampleBuilder;
import org.nebulae2us.electron.test.builder2.model.SubSample;
import org.nebulae2us.electron.test.builder2.model.SubSampleBuilder;

public class Builders {

	public static final ConverterOption CONVERTER_OPTIONS = new ConverterOption(
			new MapBuilder<Class<?>, Class<?>> ()
				.put(Blank.class, BlankBuilder.class)
				.put(Sample.class, SampleBuilder.class)
				.put(SubSample.class, SubSampleBuilder.class)
			.toMap()
			);


    public static BlankBuilder blank() {
        return new BlankBuilder(CONVERTER_OPTIONS);
    }

    public static BlankBuilder blank$restoreFrom(BuilderRepository repo, int builderId) {
        return (BlankBuilder)repo.get(builderId);
    }

    public static BlankBuilder blank$copyFrom(Blank blank) {
    	BlankBuilder result = new Converter(CONVERTER_OPTIONS, false).convert(blank).to(BlankBuilder.class);
    	return result;
    }

    public static SampleBuilder sample() {
        return new SampleBuilder(CONVERTER_OPTIONS);
    }

    public static SampleBuilder sample$restoreFrom(BuilderRepository repo, int builderId) {
        return (SampleBuilder)repo.get(builderId);
    }

    public static SampleBuilder sample$copyFrom(Sample sample) {
    	SampleBuilder result = new Converter(CONVERTER_OPTIONS, false).convert(sample).to(SampleBuilder.class);
    	return result;
    }

    public static SubSampleBuilder subSample() {
        return new SubSampleBuilder(CONVERTER_OPTIONS);
    }

    public static SubSampleBuilder subSample$restoreFrom(BuilderRepository repo, int builderId) {
        return (SubSampleBuilder)repo.get(builderId);
    }

    public static SubSampleBuilder subSample$copyFrom(SubSample subSample) {
    	SubSampleBuilder result = new Converter(CONVERTER_OPTIONS, false).convert(subSample).to(SubSampleBuilder.class);
    	return result;
    }
}

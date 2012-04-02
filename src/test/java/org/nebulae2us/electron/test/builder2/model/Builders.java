
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

	public static final DestinationClassResolver DESTINATION_CLASS_RESOLVER = new DestinationClassResolverByMap(
			new MapBuilder<Class<?>, Class<?>> ()
				.put(Blank.class, BlankBuilder.class)
				.put(Sample.class, SampleBuilder.class)
				.put(SubSample.class, SubSampleBuilder.class)
			.toMap()
			);


    public static BlankBuilder<?> blank() {
        return new BlankBuilder<Object>();
    }

    public static BlankBuilder<?> blank$restoreFrom(BuilderRepository repo, int builderId) {
        return (BlankBuilder<?>)repo.get(builderId);
    }

    public static BlankBuilder<?> blank$copyFrom(Blank blank) {
    	BlankBuilder<?> result = new Converter(DESTINATION_CLASS_RESOLVER, false).convert(blank).to(BlankBuilder.class);
    	return result;
    }

    public static SampleBuilder<?> sample() {
        return new SampleBuilder<Object>();
    }

    public static SampleBuilder<?> sample$restoreFrom(BuilderRepository repo, int builderId) {
        return (SampleBuilder<?>)repo.get(builderId);
    }

    public static SampleBuilder<?> sample$copyFrom(Sample sample) {
    	SampleBuilder<?> result = new Converter(DESTINATION_CLASS_RESOLVER, false).convert(sample).to(SampleBuilder.class);
    	return result;
    }

    public static SubSampleBuilder<?> subSample() {
        return new SubSampleBuilder<Object>();
    }

    public static SubSampleBuilder<?> subSample$restoreFrom(BuilderRepository repo, int builderId) {
        return (SubSampleBuilder<?>)repo.get(builderId);
    }

    public static SubSampleBuilder<?> subSample$copyFrom(SubSample subSample) {
    	SubSampleBuilder<?> result = new Converter(DESTINATION_CLASS_RESOLVER, false).convert(subSample).to(SubSampleBuilder.class);
    	return result;
    }
}

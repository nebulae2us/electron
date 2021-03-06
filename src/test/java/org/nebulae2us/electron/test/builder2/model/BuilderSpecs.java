
package org.nebulae2us.electron.test.builder2.model;

import java.util.*;
import org.nebulae2us.electron.*;
import org.nebulae2us.electron.util.*;
import org.nebulae2us.electron.test.builder2.model.Blank;
import org.nebulae2us.electron.test.builder2.model.BlankBuilderSpec;
import org.nebulae2us.electron.test.builder2.model.Sample;
import org.nebulae2us.electron.test.builder2.model.SampleBuilderSpec;
import org.nebulae2us.electron.test.builder2.model.SubSample;
import org.nebulae2us.electron.test.builder2.model.SubSampleBuilderSpec;

public class BuilderSpecs {

	public static final List<Class<?>> IGNORED_TYPES = new ListBuilder<Class<?>>()
			.toList();

	public static final DestinationClassResolver DESTINATION_CLASS_RESOLVER = new DestinationClassResolverByMap(
			new MapBuilder<Class<?>, Class<?>> ()
				.put(Blank.class, BlankBuilderSpec.class)
				.put(Sample.class, SampleBuilderSpec.class)
				.put(SubSample.class, SubSampleBuilderSpec.class)
			.toMap()
			);

	public static Converter converter() {
		return new Converter(DESTINATION_CLASS_RESOLVER, true, IGNORED_TYPES);
	}

    public static BlankBuilderSpec<?> blank() {
        return new BlankBuilderSpec<Object>();
    }

    public static BlankBuilderSpec<?> blank$restoreFrom(BuilderRepository repo, int builderId) {
        return (BlankBuilderSpec<?>)repo.get(builderId);
    }

    public static BlankBuilderSpec<?> blank$copyFrom(Blank blank) {
    	BlankBuilderSpec<?> result = new Converter(DESTINATION_CLASS_RESOLVER, false, IGNORED_TYPES).convert(blank).to(BlankBuilderSpec.class);
    	return result;
    }
    
    public static BlankBuilderSpec<?> wrap(Blank blank) {
    	return new WrapConverter(DESTINATION_CLASS_RESOLVER, IGNORED_TYPES).convert(blank).to(BlankBuilderSpec.class);
    }

    public static SampleBuilderSpec<?> sample() {
        return new SampleBuilderSpec<Object>();
    }

    public static SampleBuilderSpec<?> sample$restoreFrom(BuilderRepository repo, int builderId) {
        return (SampleBuilderSpec<?>)repo.get(builderId);
    }

    public static SampleBuilderSpec<?> sample$copyFrom(Sample sample) {
    	SampleBuilderSpec<?> result = new Converter(DESTINATION_CLASS_RESOLVER, false, IGNORED_TYPES).convert(sample).to(SampleBuilderSpec.class);
    	return result;
    }
    
    public static SampleBuilderSpec<?> wrap(Sample sample) {
    	return new WrapConverter(DESTINATION_CLASS_RESOLVER, IGNORED_TYPES).convert(sample).to(SampleBuilderSpec.class);
    }

    public static SubSampleBuilderSpec<?> subSample() {
        return new SubSampleBuilderSpec<Object>();
    }

    public static SubSampleBuilderSpec<?> subSample$restoreFrom(BuilderRepository repo, int builderId) {
        return (SubSampleBuilderSpec<?>)repo.get(builderId);
    }

    public static SubSampleBuilderSpec<?> subSample$copyFrom(SubSample subSample) {
    	SubSampleBuilderSpec<?> result = new Converter(DESTINATION_CLASS_RESOLVER, false, IGNORED_TYPES).convert(subSample).to(SubSampleBuilderSpec.class);
    	return result;
    }
    
    public static SubSampleBuilderSpec<?> wrap(SubSample subSample) {
    	return new WrapConverter(DESTINATION_CLASS_RESOLVER, IGNORED_TYPES).convert(subSample).to(SubSampleBuilderSpec.class);
    }

    /* CUSTOM CODE *********************************
     * 
     * Put your own custom code below. These codes won't be discarded during generation.
     * 
     */
     
     
     
}

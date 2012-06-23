
package org.nebulae2us.electron.test.builder3.model;

import java.util.*;
import org.nebulae2us.electron.*;
import org.nebulae2us.electron.util.*;
import org.nebulae2us.electron.test.builder3.model.Recordable;
import org.nebulae2us.electron.test.builder3.model.RecordableBuilderSpec;
import org.nebulae2us.electron.test.builder3.model.Book;
import org.nebulae2us.electron.test.builder3.model.BookBuilderSpec;
import org.nebulae2us.electron.test.builder3.model.Color;
import org.nebulae2us.electron.test.builder3.model.ColorBuilderSpec;
import org.nebulae2us.electron.test.builder3.model.Paper;
import org.nebulae2us.electron.test.builder3.model.PaperBuilderSpec;
import org.nebulae2us.electron.test.builder3.model.CopyPaper;
import org.nebulae2us.electron.test.builder3.model.CopyPaperBuilderSpec;
import org.nebulae2us.electron.test.builder3.model.Fiction;
import org.nebulae2us.electron.test.builder3.model.FictionBuilderSpec;
import org.nebulae2us.electron.test.builder3.model.RGBColor;
import org.nebulae2us.electron.test.builder3.model.RGBColorBuilderSpec;

public class BuilderSpecs {

	public static final List<Class<?>> IGNORED_TYPES = new ListBuilder<Class<?>>()
			.toList();

	public static final DestinationClassResolver DESTINATION_CLASS_RESOLVER = new DestinationClassResolverByMap(
			new MapBuilder<Class<?>, Class<?>> ()
				.put(Recordable.class, RecordableBuilderSpec.class)
				.put(Book.class, BookBuilderSpec.class)
				.put(Color.class, ColorBuilderSpec.class)
				.put(Paper.class, PaperBuilderSpec.class)
				.put(CopyPaper.class, CopyPaperBuilderSpec.class)
				.put(Fiction.class, FictionBuilderSpec.class)
				.put(RGBColor.class, RGBColorBuilderSpec.class)
			.toMap()
			);

	public static Converter converter() {
		return new Converter(DESTINATION_CLASS_RESOLVER, true, IGNORED_TYPES);
	}

    public static BookBuilderSpec<?> book() {
        return new BookBuilderSpec<Object>();
    }

    public static BookBuilderSpec<?> book$restoreFrom(BuilderRepository repo, int builderId) {
        return (BookBuilderSpec<?>)repo.get(builderId);
    }

    public static BookBuilderSpec<?> book$copyFrom(Book book) {
    	BookBuilderSpec<?> result = new Converter(DESTINATION_CLASS_RESOLVER, false, IGNORED_TYPES).convert(book).to(BookBuilderSpec.class);
    	return result;
    }
    
    public static BookBuilderSpec<?> wrap(Book book) {
    	return new WrapConverter(DESTINATION_CLASS_RESOLVER, IGNORED_TYPES).convert(book).to(BookBuilderSpec.class);
    }

    public static ColorBuilderSpec<?> color() {
        return new ColorBuilderSpec<Object>();
    }

    public static ColorBuilderSpec<?> color$restoreFrom(BuilderRepository repo, int builderId) {
        return (ColorBuilderSpec<?>)repo.get(builderId);
    }

    public static ColorBuilderSpec<?> color$copyFrom(Color color) {
    	ColorBuilderSpec<?> result = new Converter(DESTINATION_CLASS_RESOLVER, false, IGNORED_TYPES).convert(color).to(ColorBuilderSpec.class);
    	return result;
    }
    
    public static ColorBuilderSpec<?> wrap(Color color) {
    	return new WrapConverter(DESTINATION_CLASS_RESOLVER, IGNORED_TYPES).convert(color).to(ColorBuilderSpec.class);
    }

    public static PaperBuilderSpec<?> paper() {
        return new PaperBuilderSpec<Object>();
    }

    public static PaperBuilderSpec<?> paper$restoreFrom(BuilderRepository repo, int builderId) {
        return (PaperBuilderSpec<?>)repo.get(builderId);
    }

    public static PaperBuilderSpec<?> paper$copyFrom(Paper paper) {
    	PaperBuilderSpec<?> result = new Converter(DESTINATION_CLASS_RESOLVER, false, IGNORED_TYPES).convert(paper).to(PaperBuilderSpec.class);
    	return result;
    }
    
    public static PaperBuilderSpec<?> wrap(Paper paper) {
    	return new WrapConverter(DESTINATION_CLASS_RESOLVER, IGNORED_TYPES).convert(paper).to(PaperBuilderSpec.class);
    }

    public static CopyPaperBuilderSpec<?> copyPaper() {
        return new CopyPaperBuilderSpec<Object>();
    }

    public static CopyPaperBuilderSpec<?> copyPaper$restoreFrom(BuilderRepository repo, int builderId) {
        return (CopyPaperBuilderSpec<?>)repo.get(builderId);
    }

    public static CopyPaperBuilderSpec<?> copyPaper$copyFrom(CopyPaper copyPaper) {
    	CopyPaperBuilderSpec<?> result = new Converter(DESTINATION_CLASS_RESOLVER, false, IGNORED_TYPES).convert(copyPaper).to(CopyPaperBuilderSpec.class);
    	return result;
    }
    
    public static CopyPaperBuilderSpec<?> wrap(CopyPaper copyPaper) {
    	return new WrapConverter(DESTINATION_CLASS_RESOLVER, IGNORED_TYPES).convert(copyPaper).to(CopyPaperBuilderSpec.class);
    }

    public static FictionBuilderSpec<?> fiction() {
        return new FictionBuilderSpec<Object>();
    }

    public static FictionBuilderSpec<?> fiction$restoreFrom(BuilderRepository repo, int builderId) {
        return (FictionBuilderSpec<?>)repo.get(builderId);
    }

    public static FictionBuilderSpec<?> fiction$copyFrom(Fiction fiction) {
    	FictionBuilderSpec<?> result = new Converter(DESTINATION_CLASS_RESOLVER, false, IGNORED_TYPES).convert(fiction).to(FictionBuilderSpec.class);
    	return result;
    }
    
    public static FictionBuilderSpec<?> wrap(Fiction fiction) {
    	return new WrapConverter(DESTINATION_CLASS_RESOLVER, IGNORED_TYPES).convert(fiction).to(FictionBuilderSpec.class);
    }

    public static RGBColorBuilderSpec<?> rGBColor() {
        return new RGBColorBuilderSpec<Object>();
    }

    public static RGBColorBuilderSpec<?> rGBColor$restoreFrom(BuilderRepository repo, int builderId) {
        return (RGBColorBuilderSpec<?>)repo.get(builderId);
    }

    public static RGBColorBuilderSpec<?> rGBColor$copyFrom(RGBColor rGBColor) {
    	RGBColorBuilderSpec<?> result = new Converter(DESTINATION_CLASS_RESOLVER, false, IGNORED_TYPES).convert(rGBColor).to(RGBColorBuilderSpec.class);
    	return result;
    }
    
    public static RGBColorBuilderSpec<?> wrap(RGBColor rGBColor) {
    	return new WrapConverter(DESTINATION_CLASS_RESOLVER, IGNORED_TYPES).convert(rGBColor).to(RGBColorBuilderSpec.class);
    }

    /* CUSTOM CODE *********************************
     * 
     * Put your own custom code below. These codes won't be discarded during generation.
     * 
     */
     
     
     
}


package org.nebulae2us.electron.test.builder3.model;

import java.util.*;
import org.nebulae2us.electron.*;
import org.nebulae2us.electron.util.*;
import org.nebulae2us.electron.test.builder3.model.Recordable;
import org.nebulae2us.electron.test.builder3.model.RecordableBuilder;
import org.nebulae2us.electron.test.builder3.model.Book;
import org.nebulae2us.electron.test.builder3.model.BookBuilder;
import org.nebulae2us.electron.test.builder3.model.Color;
import org.nebulae2us.electron.test.builder3.model.ColorBuilder;
import org.nebulae2us.electron.test.builder3.model.Paper;
import org.nebulae2us.electron.test.builder3.model.PaperBuilder;
import org.nebulae2us.electron.test.builder3.model.CopyPaper;
import org.nebulae2us.electron.test.builder3.model.CopyPaperBuilder;
import org.nebulae2us.electron.test.builder3.model.Fiction;
import org.nebulae2us.electron.test.builder3.model.FictionBuilder;
import org.nebulae2us.electron.test.builder3.model.RGBColor;
import org.nebulae2us.electron.test.builder3.model.RGBColorBuilder;

public class Builders {

	public static final List<Class<?>> IGNORED_TYPES = new ListBuilder<Class<?>>()
			.toList();

	public static final DestinationClassResolver DESTINATION_CLASS_RESOLVER = new DestinationClassResolverByMap(
			new MapBuilder<Class<?>, Class<?>> ()
				.put(Recordable.class, RecordableBuilder.class)
				.put(Book.class, BookBuilder.class)
				.put(Color.class, ColorBuilder.class)
				.put(Paper.class, PaperBuilder.class)
				.put(CopyPaper.class, CopyPaperBuilder.class)
				.put(Fiction.class, FictionBuilder.class)
				.put(RGBColor.class, RGBColorBuilder.class)
			.toMap()
			);

	public static Converter converter() {
		return new Converter(DESTINATION_CLASS_RESOLVER, true, IGNORED_TYPES);
	}

    public static BookBuilder<?> book() {
        return new BookBuilder<Object>();
    }

    public static BookBuilder<?> book$restoreFrom(BuilderRepository repo, int builderId) {
        return (BookBuilder<?>)repo.get(builderId);
    }

    public static BookBuilder<?> book$copyFrom(Book book) {
    	BookBuilder<?> result = new Converter(DESTINATION_CLASS_RESOLVER, false, IGNORED_TYPES).convert(book).to(BookBuilder.class);
    	return result;
    }
    
    public static BookBuilder<?> wrap(Book book) {
    	return new WrapConverter(DESTINATION_CLASS_RESOLVER, IGNORED_TYPES).convert(book).to(BookBuilder.class);
    }

    public static ColorBuilder<?> color() {
        return new ColorBuilder<Object>();
    }

    public static ColorBuilder<?> color$restoreFrom(BuilderRepository repo, int builderId) {
        return (ColorBuilder<?>)repo.get(builderId);
    }

    public static ColorBuilder<?> color$copyFrom(Color color) {
    	ColorBuilder<?> result = new Converter(DESTINATION_CLASS_RESOLVER, false, IGNORED_TYPES).convert(color).to(ColorBuilder.class);
    	return result;
    }
    
    public static ColorBuilder<?> wrap(Color color) {
    	return new WrapConverter(DESTINATION_CLASS_RESOLVER, IGNORED_TYPES).convert(color).to(ColorBuilder.class);
    }

    public static PaperBuilder<?> paper() {
        return new PaperBuilder<Object>();
    }

    public static PaperBuilder<?> paper$restoreFrom(BuilderRepository repo, int builderId) {
        return (PaperBuilder<?>)repo.get(builderId);
    }

    public static PaperBuilder<?> paper$copyFrom(Paper paper) {
    	PaperBuilder<?> result = new Converter(DESTINATION_CLASS_RESOLVER, false, IGNORED_TYPES).convert(paper).to(PaperBuilder.class);
    	return result;
    }
    
    public static PaperBuilder<?> wrap(Paper paper) {
    	return new WrapConverter(DESTINATION_CLASS_RESOLVER, IGNORED_TYPES).convert(paper).to(PaperBuilder.class);
    }

    public static CopyPaperBuilder<?> copyPaper() {
        return new CopyPaperBuilder<Object>();
    }

    public static CopyPaperBuilder<?> copyPaper$restoreFrom(BuilderRepository repo, int builderId) {
        return (CopyPaperBuilder<?>)repo.get(builderId);
    }

    public static CopyPaperBuilder<?> copyPaper$copyFrom(CopyPaper copyPaper) {
    	CopyPaperBuilder<?> result = new Converter(DESTINATION_CLASS_RESOLVER, false, IGNORED_TYPES).convert(copyPaper).to(CopyPaperBuilder.class);
    	return result;
    }
    
    public static CopyPaperBuilder<?> wrap(CopyPaper copyPaper) {
    	return new WrapConverter(DESTINATION_CLASS_RESOLVER, IGNORED_TYPES).convert(copyPaper).to(CopyPaperBuilder.class);
    }

    public static FictionBuilder<?> fiction() {
        return new FictionBuilder<Object>();
    }

    public static FictionBuilder<?> fiction$restoreFrom(BuilderRepository repo, int builderId) {
        return (FictionBuilder<?>)repo.get(builderId);
    }

    public static FictionBuilder<?> fiction$copyFrom(Fiction fiction) {
    	FictionBuilder<?> result = new Converter(DESTINATION_CLASS_RESOLVER, false, IGNORED_TYPES).convert(fiction).to(FictionBuilder.class);
    	return result;
    }
    
    public static FictionBuilder<?> wrap(Fiction fiction) {
    	return new WrapConverter(DESTINATION_CLASS_RESOLVER, IGNORED_TYPES).convert(fiction).to(FictionBuilder.class);
    }

    public static RGBColorBuilder<?> rGBColor() {
        return new RGBColorBuilder<Object>();
    }

    public static RGBColorBuilder<?> rGBColor$restoreFrom(BuilderRepository repo, int builderId) {
        return (RGBColorBuilder<?>)repo.get(builderId);
    }

    public static RGBColorBuilder<?> rGBColor$copyFrom(RGBColor rGBColor) {
    	RGBColorBuilder<?> result = new Converter(DESTINATION_CLASS_RESOLVER, false, IGNORED_TYPES).convert(rGBColor).to(RGBColorBuilder.class);
    	return result;
    }
    
    public static RGBColorBuilder<?> wrap(RGBColor rGBColor) {
    	return new WrapConverter(DESTINATION_CLASS_RESOLVER, IGNORED_TYPES).convert(rGBColor).to(RGBColorBuilder.class);
    }

    /* CUSTOM CODE *********************************
     * 
     * Put your own custom code below. These codes won't be discarded during generation.
     * 
     */
     
     
     
}

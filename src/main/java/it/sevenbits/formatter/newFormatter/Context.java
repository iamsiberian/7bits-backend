package it.sevenbits.formatter.newFormatter;

import it.sevenbits.formatter.io.exceptions.WriterException;
import it.sevenbits.formatter.io.interfaces.IWriter;

/**
 * A class that defines the necessary actions with a token
 *
 * @author Minyukhin Ilya
 */
public class Context implements IContext {

    private final IWriter writer;

    /**
     * The basic constructor that initializes the instance of a class
     *
     * @param writer an instance of a class that implements an IWriter interface
     */
    Context(final IWriter writer) {
        this.writer = writer;
    }

    @Override
    public void writeLexeme(final String lexeme) throws ContextException {
        try {
            writer.write(lexeme);
        } catch (WriterException e) {
            throw new ContextException("error in Context.writeLexeme(final String lexeme)", e);
        }
    }

}

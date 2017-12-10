package it.sevenbits.formatter.newFormatter;

import it.sevenbits.formatter.io.exceptions.WriterException;
import it.sevenbits.formatter.io.interfaces.IWriter;

/**
 * A class that defines the necessary actions with a token
 *
 * @author Minyukhin Ilya
 */
public class Context implements IContext {

    private static final int indent = 4;
    private int countLevel = 0;

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

    @Override
    public void writeIndent() throws ContextException {
        try {
            for (int i = 0; i < countLevel * indent; i++) {
                writer.write(' ');
            }
        } catch (WriterException e) {
            throw new ContextException("error in Context.writeIndent()", e);
        }
    }

    @Override
    public void increaseCountLevel() {
        countLevel++;
    }

    @Override
    public void decreaseCountLevel() {
        countLevel--;
    }

    @Override
    public void writeNewLine() throws ContextException {
        try {
            writer.write('\n');
        } catch (WriterException e) {
            throw new ContextException("error in Context.writeNewLine()", e);
        }
    }

}

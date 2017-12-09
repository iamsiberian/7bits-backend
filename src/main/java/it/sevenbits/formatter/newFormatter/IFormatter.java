package it.sevenbits.formatter.newFormatter;

import it.sevenbits.formatter.io.exceptions.ReaderException;
import it.sevenbits.formatter.io.interfaces.IWriter;
import it.sevenbits.formatter.newLexer.ILexer;

/**
 * Interface for formatting tokens
 *
 * @author Minyukhin Ilya
 */
public interface IFormatter {

    /**
     * The method reads the token with the help of the lexer, and, if necessary, writes it with a writer
     *
     * @param lexer an instance of the lexer class
     * @param writer an instance of a class that implements an IWriter interface
     * @throws ReaderException if an error occurred
     */
    void format(ILexer lexer, IWriter writer) throws ReaderException, ContextException;
}

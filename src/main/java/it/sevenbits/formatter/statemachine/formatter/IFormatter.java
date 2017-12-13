package it.sevenbits.formatter.statemachine.formatter;

import it.sevenbits.formatter.io.ReaderException;
import it.sevenbits.formatter.io.IWriter;
import it.sevenbits.formatter.statemachine.lexer.ILexer;

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
     * @throws ContextException if an error occurred
     */
    void format(ILexer lexer, IWriter writer) throws ReaderException, ContextException;
}

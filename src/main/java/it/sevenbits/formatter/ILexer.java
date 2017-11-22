package it.sevenbits.formatter;

import it.sevenbits.formatter.io.exceptions.ReaderException;

/**
 * Interface for reading tokens
 *
 * @author Minyukhin Ilya
 */
public interface ILexer {

    /**
     * Returns the name of the token
     *
     * @return String name of the token
     * @throws ReaderException if an error occurred
     */
    IToken readToken() throws ReaderException;

    /**
     * Check if the next token can be read
     *
     * @return boolean yes/no
     * @throws ReaderException if an error occurred
     */
    boolean hasMoreTokens() throws ReaderException;
}

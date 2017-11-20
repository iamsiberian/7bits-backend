package it.sevenbits.formatter.io.interfaces;

import it.sevenbits.formatter.io.exceptions.ReaderException;

/**
 * Interface for reading by character
 *
 * @author Minyukhin Ilya
 */
public interface IReader {
    /**
     * reads the next character
     *
     * @return char next character
     * @throws ReaderException if an error occurred
     */
    char readNext() throws ReaderException;

    /**
     * check if the next character can be read
     *
     * @return boolean yes/no
     * @throws ReaderException if an error occurred
     */
    boolean hasNext() throws ReaderException;
}

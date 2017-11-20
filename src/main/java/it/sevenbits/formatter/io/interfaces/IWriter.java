package it.sevenbits.formatter.io.interfaces;

import it.sevenbits.formatter.io.exceptions.WriterException;

/**
 * Interface for writing by character
 *
 * @author Minyukhin Ilya
 */
public interface IWriter {
    /**
     * writes a character
     *
     * @param c character
     * @throws WriterException if an error occurred
     */
    void write(char c) throws WriterException;
}

package it.sevenbits.Interfaces;

import it.sevenbits.Exceptions.WriterException;

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

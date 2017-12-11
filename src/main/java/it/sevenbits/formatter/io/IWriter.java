package it.sevenbits.formatter.io;

/**
 * Interface for writing
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

    /**
     * writes a stroke
     *
     * @param s stroke
     * @throws WriterException if an error occurred
     */
    void write(String s) throws WriterException;
}

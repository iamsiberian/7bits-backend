package it.sevenbits.formatter.io.string;

import it.sevenbits.formatter.io.ReaderException;
import it.sevenbits.formatter.io.IReader;

/**
 * Class for reading char from string
 *
 * @author Minyukhin Ilya
 */
public class StringReader implements IReader {

    private String stroke;
    private int count = 0;

    /**
     * the constructor initializes the variable stroke with the specified string
     * @param stroke specified string
     */
    public StringReader(final String stroke) {
        this.stroke = stroke;
    }

    @Override
    public char readNext() throws ReaderException {
        try {
            return stroke.charAt(count++);
        } catch (Exception e) {
            throw new ReaderException("Char at " + count + " can't read", e);
        }
    }

    @Override
    public boolean hasNext() {
        return (count < stroke.length());
    }
}

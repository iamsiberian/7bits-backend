package it.sevenbits.formatter.io.string;

import it.sevenbits.formatter.io.exceptions.WriterException;
import it.sevenbits.formatter.io.interfaces.IWriter;

/**
 * Class for writing char to string
 *
 * @author Minyukhin Ilya
 */

public class StringWriter implements IWriter {

    private StringBuilder content;

    /**
     * the constructor initializes the stringBuffer
     */
    public StringWriter() {
        content = new StringBuilder("");
    }

    @Override
    public void write(final char c) throws WriterException {
        content.append(c);
    }

    @Override
    public void write(final String s) throws WriterException {
        content.append(s);
    }

    /**
     * converts a stringBuffer to a String
     * @return the value of a stringBuffer converted to a string
     */
    public String toString() {
        return content.toString();
    }

}

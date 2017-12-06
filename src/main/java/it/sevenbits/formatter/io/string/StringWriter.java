package it.sevenbits.formatter.io.string;

import it.sevenbits.formatter.io.exceptions.WriterException;
import it.sevenbits.formatter.io.interfaces.IStringWriter;
import it.sevenbits.formatter.io.interfaces.IWriter;
import it.sevenbits.formatter.token.IToken;

import java.util.ArrayList;

/**
 * Class for writing char to string
 *
 * @author Minyukhin Ilya
 */

public class StringWriter implements IWriter {

    private StringBuilder stringBuilder;

    /**
     * the constructor initializes the stringBuffer
     */
    public StringWriter() {
        stringBuilder = new StringBuilder("");
    }

    @Override
    public void write(final char c) throws WriterException {
        stringBuilder.append(c);
    }

    /**
     * converts a stringBuffer to a String
     * @return the value of a stringBuffer converted to a string
     */
    public String toString() {
        return stringBuilder.toString();
    }

}

package it.sevenbits.IO.String;

import it.sevenbits.Exceptions.WriterException;
import it.sevenbits.Interfaces.IWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Class for writing char to string
 *
 * @author Minyukhin Ilya
 */

public class StringWriter implements IWriter {

    private StringBuffer stringBuffer;

    /**
     * the constructor initializes the stringBuffer
     */
    public StringWriter() {
        stringBuffer = new StringBuffer("");
    }

    @Override
    public void write(final char c) throws WriterException {
        stringBuffer.append(c);
    }

    /**
     * converts a stringBuffer to a String
     * @return the value of a stringBuffer converted to a string
     */
    public String toString() {
        return stringBuffer.toString();
    }
}

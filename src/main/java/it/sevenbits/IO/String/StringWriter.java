package it.sevenbits.IO.String;

import it.sevenbits.Exceptions.WriterException;
import it.sevenbits.Interfaces.IWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class StringWriter implements IWriter {

    private String filepath;
    private StringBuffer stringBuffer;

    public StringWriter(final String filepath) {
        this.filepath = filepath;
        stringBuffer = new StringBuffer("");
    }

    @Override
    public void write(final char c) throws WriterException {
        stringBuffer.append(c);
    }

    public String toString() {
        return stringBuffer.toString();
    }
}

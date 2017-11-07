package it.sevenbits.IO.String;

import it.sevenbits.Exceptions.WriterException;
import it.sevenbits.IWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class StringWriter implements IWriter {

    private String filepath;
    private StringBuffer stringBuffer;
    private BufferedWriter bufferedWriter;

    public StringWriter(final String filepath) {
        this.filepath = filepath;
        stringBuffer = new StringBuffer("");
    }

    @Override
    public void write(final char c) throws WriterException {
        stringBuffer.append(c);
    }



    public void close() throws IOException, WriterException {
        try {
        bufferedWriter = new BufferedWriter(new FileWriter(filepath));
        bufferedWriter.write(stringBuffer.toString());
        } catch (Exception e) {
            throw new WriterException("StringWriter.close() error", e);
        } finally {
            bufferedWriter.close();
        }
    }

    public String toString() {
        return stringBuffer.toString();
    }
}

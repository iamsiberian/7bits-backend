package it.sevenbits.IO.File;

import it.sevenbits.Exceptions.WriterException;
import it.sevenbits.IClosable;
import it.sevenbits.IWriter;

import java.io.IOException;
import java.io.Writer;

public class FileWriter implements IWriter, IClosable {

    private Writer writer;

    public FileWriter(final String pathname) throws WriterException, IOException {
        try {
            writer = new java.io.FileWriter(pathname);
        } catch (IOException e) {
            throw new WriterException("error FileWriter initialization" , e);
        }
    }

    @Override
    public void write(final char c) throws WriterException, IOException {
        try {
            writer.write(c);
        } catch (IOException e) {
            throw new WriterException("(char) writer.write() error" , e);
        }
    }

    @Override
    public void close() throws Exception {
        try {
            writer.close();
        } catch (IOException e) {
            throw new IOException("writer.close() error", e);
        }
    }
}

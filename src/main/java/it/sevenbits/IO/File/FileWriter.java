package it.sevenbits.IO.File;

import it.sevenbits.Exceptions.CloseableException;
import it.sevenbits.Exceptions.WriterException;
import it.sevenbits.Interfaces.IClosable;
import it.sevenbits.Interfaces.IWriter;

import java.io.Writer;

public class FileWriter implements IWriter, IClosable {

    private Writer writer;

    public FileWriter(final String pathname) throws WriterException {
        try {
            writer = new java.io.FileWriter(pathname);
        } catch (Exception e) {
            throw new WriterException("error FileWriter initialization" , e);
        }
    }

    @Override
    public void write(final char c) throws WriterException {
        try {
            writer.write(c);
        } catch (Exception e) {
            throw new WriterException("(char) writer.write() error" , e);
        }
    }

    @Override
    public void close() throws CloseableException {
        try {
            writer.close();
        } catch (Exception e) {
            throw new CloseableException("writer.close() error", e);
        }
    }
}

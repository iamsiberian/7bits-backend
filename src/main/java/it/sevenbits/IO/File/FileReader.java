package it.sevenbits.IO.File;

import it.sevenbits.Exceptions.CloseableException;
import it.sevenbits.Exceptions.ReaderException;
import it.sevenbits.Interfaces.IClosable;
import it.sevenbits.Interfaces.IReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;

public class FileReader implements IClosable, IReader {

    private Reader reader;
    private int byteSymbol;

    public FileReader(final String pathname) throws ReaderException {
        try {
            reader = new java.io.FileReader(pathname);
        } catch (FileNotFoundException e) {
            throw new ReaderException("file not found", e);
        }
    }

    @Override
    public char readNext() throws ReaderException {
        if (byteSymbol > -1) {
            return (char) byteSymbol;
        } else {
            throw new ReaderException("file is ended");
        }
    }

    @Override
    public boolean hasNext() throws ReaderException {
        try {
            byteSymbol = reader.read();
            return byteSymbol != -1;
        } catch (Exception e) {
            throw new ReaderException("reader.hasNext() error", e);
        }
    }

    @Override
    public void close() throws CloseableException {
        try {
            reader.close();
        } catch (Exception e) {
            throw new CloseableException("reader.close() error", e);
        }
    }


}

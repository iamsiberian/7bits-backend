package it.sevenbits.formatter.io.file;

import it.sevenbits.formatter.io.CloseableException;
import it.sevenbits.formatter.io.ReaderException;
import it.sevenbits.formatter.io.IClosable;
import it.sevenbits.formatter.io.IReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;

/**
 * Class for reading char from file
 *
 * @author Minyukhin Ilya
 */
public class FileReader implements IClosable, IReader {

    private Reader reader;
    private int byteSymbol;

    /**
     * the constructor initializes instance of a class java.io.FileReader
     *
     * @param pathname path to file
     * @throws ReaderException if an error occurred in FileReader
     */
    public FileReader(final String pathname) throws ReaderException {
        try {
            reader = new java.io.FileReader(pathname);
            byteSymbol = reader.read();
        } catch (FileNotFoundException e) {
            throw new ReaderException("file not found", e);
        } catch (IOException e) {
            throw new ReaderException("file can not read", e);
        }
    }

    @Override
    public char readNext() throws ReaderException {
        try {
            int prevByteSymbol = byteSymbol;
            byteSymbol = reader.read();
            return (char) prevByteSymbol;
        } catch (IOException e) {
            throw new ReaderException("file is ended", e);
        }
    }

    @Override
    public boolean hasNext() throws ReaderException {
        try {
            return byteSymbol >= 0;
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

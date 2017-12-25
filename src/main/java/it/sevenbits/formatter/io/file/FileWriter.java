package it.sevenbits.formatter.io.file;

import it.sevenbits.formatter.io.CloseableException;
import it.sevenbits.formatter.io.WriterException;
import it.sevenbits.formatter.io.IClosable;
import it.sevenbits.formatter.io.IWriter;

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;

/**
 * Class for writing char to file
 *
 * @author Minyukhin Ilya
 */
public class FileWriter implements IWriter, IClosable {

    private Writer writer;

    /**
     * the constructor initializes instance of a class java.io.FileWriter
     * @param pathname path to file
     * @throws WriterException if an error occurred in FileWriter
     */
    public FileWriter(final String pathname) throws WriterException {
        try {
            writer = new OutputStreamWriter(Files.newOutputStream(FileSystems.getDefault().getPath(pathname)), StandardCharsets.UTF_8);
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

    @Override
    public void write(final String s) throws WriterException {
        try {
            writer.write(s);
        } catch (Exception e) {
            throw new  WriterException("error in write(String s);", e);
        }
    }
}

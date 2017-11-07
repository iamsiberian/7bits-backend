package it.sevenbits;

import it.sevenbits.Exceptions.WriterException;

import java.io.IOException;

public interface IWriter {
    void write(char c) throws WriterException, IOException;
}

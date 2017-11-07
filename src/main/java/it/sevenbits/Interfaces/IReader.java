package it.sevenbits;

import it.sevenbits.Exceptions.ReaderException;

import java.io.IOException;

public interface IReader {
    char readNext() throws ReaderException;
    boolean hasNext() throws ReaderException, IOException;
}

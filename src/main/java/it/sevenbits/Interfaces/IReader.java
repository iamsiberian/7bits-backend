package it.sevenbits.Interfaces;

import it.sevenbits.Exceptions.ReaderException;

public interface IReader {
    char readNext() throws ReaderException;
    boolean hasNext() throws ReaderException;
}

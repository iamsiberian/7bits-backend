package it.sevenbits.Interfaces;

import it.sevenbits.Exceptions.WriterException;

public interface IWriter {
    void write(char c) throws WriterException;
}

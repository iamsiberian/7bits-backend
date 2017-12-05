package it.sevenbits.formatter.io.interfaces;

import it.sevenbits.formatter.io.exceptions.WriterException;

public interface IStringWriter {
    void write(String s) throws WriterException;
}

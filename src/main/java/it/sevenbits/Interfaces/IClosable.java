package it.sevenbits.Interfaces;

import it.sevenbits.Exceptions.CloseableException;

public interface IClosable extends AutoCloseable {
    void close() throws CloseableException;
}

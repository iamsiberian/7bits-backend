package it.sevenbits.formatter.io;

/**
 * Interface wrapper for AutoClosable
 *
 * @author Minyukhin Ilya
 */
public interface IClosable extends AutoCloseable {

    /**
     * the method throws an exception in case of an error
     *
     * @throws CloseableException if an error occurred
     */
    void close() throws CloseableException;
}

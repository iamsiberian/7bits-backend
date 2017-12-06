package it.sevenbits.formatter.lexer.stateMachineComponents;

import it.sevenbits.formatter.io.exceptions.ReaderException;

/**
 * Created by user on 06.12.2017.
 */
public interface IStringBuilderReader {
    public char readNext() throws ReaderException;
    public boolean hasNext();
}

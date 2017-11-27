package it.sevenbits.formatter.lexer;

import it.sevenbits.formatter.io.exceptions.ReaderException;
import it.sevenbits.formatter.io.interfaces.IReader;

public interface ILexerFactory {
    public ILexer createLexer(IReader iReader) throws ReaderException;
}

package it.sevenbits.formatter.lexer;

import it.sevenbits.formatter.io.exceptions.ReaderException;
import it.sevenbits.formatter.io.interfaces.IReader;

public class LexerFactory implements ILexerFactory {

    @Override
    public ILexer createLexer(final IReader iReader) throws ReaderException {
        return new Lexer(iReader);
    }
}

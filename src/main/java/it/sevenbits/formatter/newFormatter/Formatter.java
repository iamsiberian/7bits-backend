package it.sevenbits.formatter.newFormatter;

import it.sevenbits.formatter.io.exceptions.ReaderException;
import it.sevenbits.formatter.io.interfaces.IStringWriter;
import it.sevenbits.formatter.lexer.Lexer;

public class Formatter implements IFormatter {
    @Override
    public void format(Lexer lexer, IStringWriter iStringWriter) throws ReaderException {
        try {
            iStringWriter.write(lexer.readToken().getLexeme());
        } catch (Exception e) {
            throw new ReaderException("", e);
        }

    }
}

package it.sevenbits.formatter.newFormatter;

import it.sevenbits.formatter.io.exceptions.ReaderException;
import it.sevenbits.formatter.io.interfaces.IStringWriter;
import it.sevenbits.formatter.lexer.Lexer;
import it.sevenbits.formatter.token.IToken;


public class Formatter implements IFormatter {
    @Override
    public void format(Lexer lexer, IStringWriter iStringWriter) throws ReaderException {
        try {
            while (lexer.hasMoreTokens()) {
                IToken iToken = lexer.readToken();
                //System.out.println(iToken.toString());
                iStringWriter.write(iToken.getLexeme());
            }
        } catch (Exception e) {
            throw new ReaderException("", e);
        }

    }
}

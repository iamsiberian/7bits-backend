package it.sevenbits.formatter;

import it.sevenbits.formatter.io.exceptions.ReaderException;
import it.sevenbits.formatter.io.interfaces.IReader;

/**
 * Class Lexer is intended for reading lexemes
 *
 * @author Minyukhin Ilya
 */
public class Lexer implements ILexer {

    private IReader iReader;
    private Token token;

    /**
     * The constructor initializes instance of a class
     * @param iReader class that implements iReader interface
     * @throws ReaderException if an error occurred
     */
    public Lexer(final IReader iReader) throws ReaderException {
        this.iReader = iReader;
        token = (Token) readToken();
    }

    @Override
    public IToken readToken() throws ReaderException {
        Token prevToken = token;
        StringBuilder lexeme =  new StringBuilder();

        while (hasMoreTokens()) {
            char c = iReader.readNext();
            //////////
            if (c == '{') {
                iWriter.write(c);
                countLevel++;
                isMiddleOfTheLine = false;
                isSpacesBeforeCode = true;
                newLine = true;
            } else if (c == '}') {
                countLevel--;
                if (newLine) {
                    iWriter.write('\n');
                    for (int i = 0; i < countLevel * tab; i++) {
                        iWriter.write(' ');
                    }
                    iWriter.write(c);
                    isMiddleOfTheLine = false;
                    isSpacesBeforeCode = true;
                    newLine = true;
                } else {
                    iWriter.write(c);
                    isMiddleOfTheLine = false;
                    isSpacesBeforeCode = true;
                    newLine = true;
                }
            } else if (c == ';') {
                iWriter.write(c);
                isMiddleOfTheLine = false;
                isSpacesBeforeCode = true;
                newLine = true;
            } else if (c == '\n') {
                if (!isMiddleOfTheLine && newLine) {
                    iWriter.write(c);
                    for (int i = 0; i < countLevel * tab; i++) {
                        iWriter.write(' ');
                    }
                    isMiddleOfTheLine = true;
                    isSpacesBeforeCode = true;
                    newLine = false;
                } //else newLine = true;
            } else if (c == ' ') {
                if (!isSpacesBeforeCode) {
                    iWriter.write(c);
                }
            } else {
                if (newLine) {
                    iWriter.write('\n');
                    for (int i = 0; i < countLevel * tab; i++) {
                        iWriter.write(' ');
                    }
                    iWriter.write(c);
                    newLine = false;
                } else {
                    iWriter.write(c);
                    //isMiddleOfTheLine = true;
                    isSpacesBeforeCode = false;
                }
            }
            //////////
        }

        token = new Token("name", lexeme.toString());
        return prevToken;
    }

    /**
     * The method checks if there are more tokens, when an empty token is received at the input, it returns NO
     * @return boleean yes/no
     */
    @Override
    public boolean hasMoreTokens() {
        return (!token.getName().equals("") && token.getLexeme().equals(""));
    }
}

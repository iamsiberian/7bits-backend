package it.sevenbits;

import it.sevenbits.formatter.io.exceptions.ReaderException;
import it.sevenbits.formatter.io.string.StringReader;
import it.sevenbits.formatter.lexer.Lexer;
import it.sevenbits.formatter.token.IToken;
import it.sevenbits.formatter.token.Token;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 06.12.2017.
 */
public class TestLexer {
    @Test
    public void testTextToTokens() throws ReaderException {
        ArrayList<IToken> resultTokens = new ArrayList<>();
        String testStroke =
                "   aaa { //\n" +
                        "bbbb\n" +
                        "ccc;\n" +
                        "} /*\n" +
                        " aaa {\n" +
                        "} */";
        ArrayList<IToken> tokens = new ArrayList<>();
        tokens.add(new Token("Char", " "));
        tokens.add(new Token("Char", " "));
        tokens.add(new Token("Char", " "));
        tokens.add(new Token("Char", "a"));
        tokens.add(new Token("Char", "a"));
        tokens.add(new Token("Char", "a"));
        tokens.add(new Token("Char", " "));
        tokens.add(new Token("Char", "{"));
        tokens.add(new Token("Char", " "));
        tokens.add(new Token("Comment", "//"));
        tokens.add(new Token("Char", "\n"));
        tokens.add(new Token("Char", "b"));
        tokens.add(new Token("Char", "b"));
        tokens.add(new Token("Char", "b"));
        tokens.add(new Token("Char", "b"));
        tokens.add(new Token("Char", "\n"));
        tokens.add(new Token("Char", "c"));
        tokens.add(new Token("Char", "c"));
        tokens.add(new Token("Char", "c"));
        tokens.add(new Token("Char", ";"));
        tokens.add(new Token("Char", "\n"));
        tokens.add(new Token("Char", "}"));
        tokens.add(new Token("Char", " "));
        tokens.add(new Token("Comment", "/*"));
        tokens.add(new Token("Char", "\n"));
        tokens.add(new Token("Char", " "));
        tokens.add(new Token("Char", "a"));
        tokens.add(new Token("Char", "a"));
        tokens.add(new Token("Char", "a"));
        tokens.add(new Token("Char", " "));
        tokens.add(new Token("Char", "{"));
        tokens.add(new Token("Char", "\n"));
        tokens.add(new Token("Char", "}"));
        tokens.add(new Token("Char", " "));
        tokens.add(new Token("Comment", "*/"));

        StringReader stringReader = new StringReader(testStroke);
        //StringWriter stringWriter = new StringWriter();
        try {
            Lexer lexer = new Lexer(stringReader);
            while (lexer.hasMoreTokens()) {
                resultTokens.add(lexer.readToken());
            }
        } catch (ReaderException e) {
            throw new ReaderException(" ", e);
        }

        assertEquals(tokens, resultTokens);
    }
}
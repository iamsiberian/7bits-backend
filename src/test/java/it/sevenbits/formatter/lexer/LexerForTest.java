package it.sevenbits.formatter.lexer;


import it.sevenbits.formatter.io.IReader;
import it.sevenbits.formatter.io.ReaderException;
import it.sevenbits.formatter.io.string.StringReader;
import it.sevenbits.formatter.statemachine.lexer.ConfigExecLexer;
import it.sevenbits.formatter.statemachine.lexer.ILexer;
import it.sevenbits.formatter.statemachine.lexer.Lexer;
import it.sevenbits.formatter.statemachine.token.IToken;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LexerForTest {
    @Test
    public void testFor() throws ReaderException {
        ConfigExecLexer configExecLexer = new ConfigExecLexer();
        IReader reader = new StringReader("for fo f ");
        ILexer lexer = new Lexer(reader, configExecLexer);

        assertTrue(lexer.hasNextToken());
        IToken token = lexer.readToken();
        assertEquals("for", token.getName());
        assertEquals("for", token.getLexeme());

        assertTrue(lexer.hasNextToken());
        token = lexer.readToken();
        assertEquals("space", token.getName());
        assertEquals(" ", token.getLexeme());

        assertTrue(lexer.hasNextToken());
        token = lexer.readToken();
        assertEquals("chars", token.getName());
        assertEquals("fo", token.getLexeme());

        assertTrue(lexer.hasNextToken());
        token = lexer.readToken();
        assertEquals("space", token.getName());
        assertEquals(" ", token.getLexeme());

        assertTrue(lexer.hasNextToken());
        token = lexer.readToken();
        assertEquals("chars", token.getName());
        assertEquals("f", token.getLexeme());

        assertTrue(lexer.hasNextToken());
        token = lexer.readToken();
        assertEquals("space", token.getName());
        assertEquals(" ", token.getLexeme());

        assertFalse(lexer.hasNextToken());
    }

    @Test
    public void testFor2() throws ReaderException {
        ConfigExecLexer configExecLexer = new ConfigExecLexer();
        IReader reader = new StringReader("for form");
        ILexer lexer = new Lexer(reader, configExecLexer);

        assertTrue(lexer.hasNextToken());
        IToken token = lexer.readToken();
        assertEquals("for", token.getName());
        assertEquals("for", token.getLexeme());

        assertTrue(lexer.hasNextToken());
        token = lexer.readToken();
        assertEquals("space", token.getName());
        assertEquals(" ", token.getLexeme());

        assertTrue(lexer.hasNextToken());
        token = lexer.readToken();
        assertEquals("chars", token.getName());
        assertEquals("for", token.getLexeme());

        assertTrue(lexer.hasNextToken());
        token = lexer.readToken();
        assertEquals("char", token.getName());
        assertEquals("m", token.getLexeme());

        assertFalse(lexer.hasNextToken());
    }
}

package it.sevenbits.formatter.lexer;

import it.sevenbits.formatter.io.ReaderException;
import it.sevenbits.formatter.io.IReader;
import it.sevenbits.formatter.io.string.StringReader;

import it.sevenbits.formatter.statemachine.lexer.*;
import it.sevenbits.formatter.statemachine.token.IToken;
import org.junit.Test;

import static org.junit.Assert.*;

public class LexerTest {
    @Test
    public void testAnotherSimpleTokenize() throws ReaderException {
        ConfigExecLexer configExecLexer = new ConfigExecLexer();
        IReader reader = new StringReader(
                "  a ");

        ILexer lexer = new Lexer(reader, configExecLexer);

        assertTrue(lexer.hasNextToken());
        IToken token = lexer.readToken();
        assertEquals("spaces", token.getName());
        assertEquals("  ", token.getLexeme());

        assertTrue(lexer.hasNextToken());
        token = lexer.readToken();
        assertEquals("char", token.getName());
        assertEquals("a", token.getLexeme());

        assertTrue(lexer.hasNextToken());
        token = lexer.readToken();
        assertEquals("space", token.getName());
        assertEquals(" ", token.getLexeme());

        assertFalse(lexer.hasNextToken());
    }

    @Test
    public void testSimpleTokenize() throws ReaderException {
        ConfigExecLexer configExecLexer = new ConfigExecLexer();
        IReader reader = new StringReader(
                "  a {\n" +
                "   b; //c\n" +
                "}");

        ILexer lexer = new Lexer(reader, configExecLexer);

        assertTrue(lexer.hasNextToken());
        IToken token = lexer.readToken();
        assertEquals("spaces", token.getName());
        assertEquals("  ", token.getLexeme());

        assertTrue(lexer.hasNextToken());
        token = lexer.readToken();
        assertEquals("char", token.getName());
        assertEquals("a", token.getLexeme());

        assertTrue(lexer.hasNextToken());
        token = lexer.readToken();
        assertEquals("space", token.getName());
        assertEquals(" ", token.getLexeme());

        assertTrue(lexer.hasNextToken());
        token = lexer.readToken();
        assertEquals("openbrace", token.getName());
        assertEquals("{", token.getLexeme());

        assertTrue(lexer.hasNextToken());
        token = lexer.readToken();
        assertEquals("newline", token.getName());
        assertEquals("\n", token.getLexeme());

        assertTrue(lexer.hasNextToken());
        token = lexer.readToken();
        assertEquals("spaces", token.getName());
        assertEquals("   ", token.getLexeme());

        assertTrue(lexer.hasNextToken());
        token = lexer.readToken();
        assertEquals("char", token.getName());
        assertEquals("b", token.getLexeme());

        assertTrue(lexer.hasNextToken());
        token = lexer.readToken();
        assertEquals("semicolon", token.getName());
        assertEquals(";", token.getLexeme());

        assertTrue(lexer.hasNextToken());
        token = lexer.readToken();
        assertEquals("space", token.getName());
        assertEquals(" ", token.getLexeme());

        assertTrue(lexer.hasNextToken());
        token = lexer.readToken();
        assertEquals("onelinecomment", token.getName());
        assertEquals("//", token.getLexeme());

        assertTrue(lexer.hasNextToken());
        token = lexer.readToken();
        assertEquals("char", token.getName());
        assertEquals("c", token.getLexeme());

        assertTrue(lexer.hasNextToken());
        token = lexer.readToken();
        assertEquals("newline", token.getName());
        assertEquals("\n", token.getLexeme());

        assertTrue(lexer.hasNextToken());
        token = lexer.readToken();
        assertEquals("closebrace", token.getName());
        assertEquals("}", token.getLexeme());

        assertFalse(lexer.hasNextToken());
    }

    @Test
    public void testSimpleTokenize2() throws ReaderException {
        ConfigExecLexer configExecLexer = new ConfigExecLexer();
        IReader reader = new StringReader(
                "//c\n" +
                        "for () {}");

        ILexer lexer = new Lexer(reader, configExecLexer);

        assertTrue(lexer.hasNextToken());
        IToken token = lexer.readToken();
        assertEquals("onelinecomment", token.getName());
        assertEquals("//", token.getLexeme());

        assertTrue(lexer.hasNextToken());
        token = lexer.readToken();
        assertEquals("char", token.getName());
        assertEquals("c", token.getLexeme());

        assertTrue(lexer.hasNextToken());
        token = lexer.readToken();
        assertEquals("newline", token.getName());
        assertEquals("\n", token.getLexeme());

        assertTrue(lexer.hasNextToken());
        token = lexer.readToken();
        assertEquals("for", token.getName());
        assertEquals("for", token.getLexeme());

        assertTrue(lexer.hasNextToken());
        token = lexer.readToken();
        assertEquals("space", token.getName());
        assertEquals(" ", token.getLexeme());

        assertTrue(lexer.hasNextToken());
        token = lexer.readToken();
        assertEquals("openbracket", token.getName());
        assertEquals("(", token.getLexeme());

        assertTrue(lexer.hasNextToken());
        token = lexer.readToken();
        assertEquals("closebracket", token.getName());
        assertEquals(")", token.getLexeme());

        assertTrue(lexer.hasNextToken());
        token = lexer.readToken();
        assertEquals("space", token.getName());
        assertEquals(" ", token.getLexeme());

        assertTrue(lexer.hasNextToken());
        token = lexer.readToken();
        assertEquals("openbrace", token.getName());
        assertEquals("{", token.getLexeme());

        assertTrue(lexer.hasNextToken());
        token = lexer.readToken();
        assertEquals("closebrace", token.getName());
        assertEquals("}", token.getLexeme());

        assertFalse(lexer.hasNextToken());
    }
}

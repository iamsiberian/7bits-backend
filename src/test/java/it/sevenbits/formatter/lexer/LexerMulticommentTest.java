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

public class LexerMulticommentTest {
    @Test
    public void testMultiComment() throws ReaderException {
        ConfigExecLexer configExecLexer = new ConfigExecLexer();
        IReader reader = new StringReader("/*asd; asd\n {}*/");
        ILexer lexer = new Lexer(reader, configExecLexer);

        assertTrue(lexer.hasNextToken());
        IToken token = lexer.readToken();
        assertEquals("openmultilinecomment", token.getName());
        assertEquals("/*", token.getLexeme());

        assertTrue(lexer.hasNextToken());
        token = lexer.readToken();
        assertEquals("char", token.getName());
        assertEquals("a", token.getLexeme());

        assertTrue(lexer.hasNextToken());
        token = lexer.readToken();
        assertEquals("char", token.getName());
        assertEquals("s", token.getLexeme());

        assertTrue(lexer.hasNextToken());
        token = lexer.readToken();
        assertEquals("char", token.getName());
        assertEquals("d", token.getLexeme());

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
        assertEquals("char", token.getName());
        assertEquals("a", token.getLexeme());

        assertTrue(lexer.hasNextToken());
        token = lexer.readToken();
        assertEquals("char", token.getName());
        assertEquals("s", token.getLexeme());

        assertTrue(lexer.hasNextToken());
        token = lexer.readToken();
        assertEquals("char", token.getName());
        assertEquals("d", token.getLexeme());

        assertTrue(lexer.hasNextToken());
        token = lexer.readToken();
        assertEquals("newline", token.getName());
        assertEquals("\n", token.getLexeme());

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

        assertTrue(lexer.hasNextToken());
        token = lexer.readToken();
        assertEquals("closemultilinecomment", token.getName());
        assertEquals("*/", token.getLexeme());

        assertFalse(lexer.hasNextToken());
    }

}

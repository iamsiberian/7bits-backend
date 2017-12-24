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

public class LexerQuoteMark {
    @Test
    public void testQuoteMark() throws ReaderException {
        ConfigExecLexer configExecLexer = new ConfigExecLexer();
        IReader reader = new StringReader("\" ");
        ILexer lexer = new Lexer(reader, configExecLexer);

        assertTrue(lexer.hasNextToken());
        IToken token = lexer.readToken();
        assertEquals("quotemark", token.getName());
        assertEquals("\"", token.getLexeme());

        assertTrue(lexer.hasNextToken());
        token = lexer.readToken();
        assertEquals("space", token.getName());
        assertEquals(" ", token.getLexeme());

        assertFalse(lexer.hasNextToken());
    }
}

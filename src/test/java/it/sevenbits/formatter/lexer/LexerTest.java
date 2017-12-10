package it.sevenbits.formatter.lexer;

import it.sevenbits.formatter.State;
import it.sevenbits.formatter.io.exceptions.ReaderException;
import it.sevenbits.formatter.io.interfaces.IReader;
import it.sevenbits.formatter.io.string.StringReader;
import it.sevenbits.formatter.newLexer.*;

import it.sevenbits.formatter.token.IToken;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyChar;
import static org.mockito.Mockito.*;

public class LexerTest {
    @Test
    public void testSimpleTokenize() throws ReaderException {
        IReader reader = new StringReader(
                "  a {\n" +
                "   b; //c\n" +
                "}");

        ILexer lexer = new Lexer(reader);

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
        assertEquals("openbracket", token.getName());
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
        assertEquals("closebracket", token.getName());
        assertEquals("}", token.getLexeme());

        assertFalse(lexer.hasNextToken());
    }

    @Test
    public void testStateMachineLoop() throws ReaderException {
        IReader reader = mock(IReader.class);
        when(reader.hasNext()).thenReturn(true, false);
        when(reader.readNext()).thenReturn('a');

        ICommand command = mock(ICommand.class);
        ICommandRepository commands = mock(ICommandRepository.class);
        when(commands.getCommand(any(State.class), anyChar())).thenReturn(command);

        IStateTransitions transitions = mock(IStateTransitions.class);

        ILexer lexer = new Lexer(reader, commands, transitions);
        lexer.readToken();

        verify(reader, times(2)).hasNext();
        verify(reader).readNext();
        verify(commands).getCommand(new State("default"), 'a');
        verify(command).execute(eq('a'), any(IContext.class));
        verify(transitions).nextState(new State("default"), 'a');
    }

    @Test
    public void testMultiComment() throws ReaderException{
        IReader reader = new StringReader("/*asd; asd\n {}*/");
        ILexer lexer = new Lexer(reader);

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
        assertEquals("openbracket", token.getName());
        assertEquals("{", token.getLexeme());

        assertTrue(lexer.hasNextToken());
        token = lexer.readToken();
        assertEquals("closebracket", token.getName());
        assertEquals("}", token.getLexeme());

        assertTrue(lexer.hasNextToken());
        token = lexer.readToken();
        assertEquals("closemultilinecomment", token.getName());
        assertEquals("*/", token.getLexeme());

        assertFalse(lexer.hasNextToken());
    }
}
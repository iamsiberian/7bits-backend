package it.sevenbits.formatter.formatter;

import it.sevenbits.formatter.io.ReaderException;
import it.sevenbits.formatter.io.IReader;
import it.sevenbits.formatter.io.IWriter;
import it.sevenbits.formatter.io.string.StringReader;
import it.sevenbits.formatter.io.string.StringWriter;
import it.sevenbits.formatter.statemachine.formatter.ContextException;
import it.sevenbits.formatter.statemachine.formatter.Formatter;
import it.sevenbits.formatter.statemachine.lexer.Lexer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FormatterTest {
    @Test
    public void testMultiComment() throws ReaderException, ContextException {
        String testStroke = "/*asd; asd\n {}*/";
        String trueStroke = "/*asd; asd\n {}*/\n";

        IReader stringReader = new StringReader(testStroke);
        IWriter stringWriter = new StringWriter();

        Lexer lexer = new Lexer(stringReader);
        Formatter formatter = new Formatter();
        formatter.format(lexer, stringWriter);

        String resultStroke = stringWriter.toString();

        assertEquals(trueStroke, resultStroke);
    }

    @Test
    public void testMultiCommentWithWhiteSpaces() throws ReaderException, ContextException {
        String testStroke = "  /*asd; asd\n {}*/";
        String trueStroke = "/*asd; asd\n {}*/\n";

        IReader stringReader = new StringReader(testStroke);
        IWriter stringWriter = new StringWriter();

        Lexer lexer = new Lexer(stringReader);
        Formatter formatter = new Formatter();
        formatter.format(lexer, stringWriter);

        String resultStroke = stringWriter.toString();

        assertEquals(trueStroke, resultStroke);
    }

    @Test
    public void testLineComment() throws ReaderException, ContextException{
        String testStroke = "//asd  {}\n";
        String trueStroke = "//asd  {}\n";

        IReader stringReader = new StringReader(testStroke);
        IWriter stringWriter = new StringWriter();

        Lexer lexer = new Lexer(stringReader);
        Formatter formatter = new Formatter();
        formatter.format(lexer, stringWriter);

        String resultStroke = stringWriter.toString();

        assertEquals(trueStroke, resultStroke);
    }

    @Test
    public void testFormatter() throws ReaderException, ContextException {
        String testStroke = "   aaa {\nbbbb\nccc;\n}\n aaa {\n}";
        String trueStroke = "aaa {\n    bbbbccc;\n    }\naaa {\n    }\n";

        IReader stringReader = new StringReader(testStroke);
        IWriter stringWriter = new StringWriter();

        Lexer lexer = new Lexer(stringReader);
        Formatter formatter = new Formatter();
        formatter.format(lexer, stringWriter);

        String resultStroke = stringWriter.toString();

        assertEquals(trueStroke, resultStroke);
    }

    @Test
    public void testFormatter2() throws ReaderException, ContextException {
        String testStroke = "   a";
        String trueStroke = "a";

        IReader stringReader = new StringReader(testStroke);
        IWriter stringWriter = new StringWriter();

        Lexer lexer = new Lexer(stringReader);
        Formatter formatter = new Formatter();
        formatter.format(lexer, stringWriter);

        String resultStroke = stringWriter.toString();

        assertEquals(trueStroke, resultStroke);
    }

}

package it.sevenbits.formatter.formatter;

import it.sevenbits.formatter.io.exceptions.ReaderException;
import it.sevenbits.formatter.io.interfaces.IReader;
import it.sevenbits.formatter.io.interfaces.IWriter;
import it.sevenbits.formatter.io.string.StringReader;
import it.sevenbits.formatter.io.string.StringWriter;
import it.sevenbits.formatter.newFormatter.ContextException;
import it.sevenbits.formatter.newFormatter.Formatter;
import it.sevenbits.formatter.newLexer.Lexer;
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

}

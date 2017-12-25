package it.sevenbits.formatter.formatter;

import it.sevenbits.formatter.io.IReader;
import it.sevenbits.formatter.io.IWriter;
import it.sevenbits.formatter.io.ReaderException;
import it.sevenbits.formatter.io.string.StringReader;
import it.sevenbits.formatter.io.string.StringWriter;
import it.sevenbits.formatter.statemachine.formatter.ConfigExecFormatter;
import it.sevenbits.formatter.statemachine.formatter.ContextException;
import it.sevenbits.formatter.statemachine.formatter.Formatter;
import it.sevenbits.formatter.statemachine.formatter.LineSeparator;
import it.sevenbits.formatter.statemachine.lexer.ConfigExecLexer;
import it.sevenbits.formatter.statemachine.lexer.Lexer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FormatterBraceTest {
    private static final String lineSeparator = LineSeparator.get();

    @Test
    public void testBrace1() throws ContextException, ReaderException {
        String testStroke = "{a;}";
        String trueStroke = "{" + lineSeparator + "    a;" + lineSeparator + "}" + lineSeparator;

        IReader stringReader = new StringReader(testStroke);
        IWriter stringWriter = new StringWriter();

        ConfigExecLexer configExecLexer = new ConfigExecLexer();
        Lexer lexer = new Lexer(stringReader, configExecLexer);

        ConfigExecFormatter configExecFormatter = new ConfigExecFormatter();
        Formatter formatter = new Formatter(configExecFormatter);

        formatter.format(lexer, stringWriter);

        String resultStroke = stringWriter.toString();

        assertEquals(trueStroke, resultStroke);
    }

    @Test
    public void testFormatterBrace() throws ContextException, ReaderException {
        String testStroke = "a {\nb;a;\n}";
        String trueStroke = "a {" + lineSeparator +
                "    b;" + lineSeparator +
                "    a;" + lineSeparator +
                "}" + lineSeparator;

        IReader stringReader = new StringReader(testStroke);
        IWriter stringWriter = new StringWriter();

        ConfigExecLexer configExecLexer = new ConfigExecLexer();
        Lexer lexer = new Lexer(stringReader, configExecLexer);

        ConfigExecFormatter configExecFormatter = new ConfigExecFormatter();
        Formatter formatter = new Formatter(configExecFormatter);

        formatter.format(lexer, stringWriter);

        String resultStroke = stringWriter.toString();

        assertEquals(trueStroke, resultStroke);
    }

    @Test
    public void testTextWithBraces() throws ReaderException, ContextException {
        String testStroke = "   aaa {\nbbbb\nccc;\n}\n aaa {\n}";
        String trueStroke = "aaa {" + lineSeparator + "    bbbbccc;" + lineSeparator + "}" + lineSeparator + "aaa {" + lineSeparator + "}" + lineSeparator;

        IReader stringReader = new StringReader(testStroke);
        IWriter stringWriter = new StringWriter();

        ConfigExecLexer configExecLexer = new ConfigExecLexer();
        Lexer lexer = new Lexer(stringReader, configExecLexer);

        ConfigExecFormatter configExecFormatter = new ConfigExecFormatter();
        Formatter formatter = new Formatter(configExecFormatter);

        formatter.format(lexer, stringWriter);

        String resultStroke = stringWriter.toString();

        assertEquals(trueStroke, resultStroke);
    }

    @Test
    public void testFormatterFirstLineWithOpenBrace() throws ReaderException, ContextException {
        String testStroke = "a {a";
        String trueStroke = "a {" + lineSeparator + "    a";

        IReader stringReader = new StringReader(testStroke);
        IWriter stringWriter = new StringWriter();

        ConfigExecLexer configExecLexer = new ConfigExecLexer();
        Lexer lexer = new Lexer(stringReader, configExecLexer);

        ConfigExecFormatter configExecFormatter = new ConfigExecFormatter();
        Formatter formatter = new Formatter(configExecFormatter);

        formatter.format(lexer, stringWriter);

        String resultStroke = stringWriter.toString();

        assertEquals(trueStroke, resultStroke);
    }

    @Test
    public void testFormatterFirstLineWithCloseBrace() throws ReaderException, ContextException {
        String testStroke = "a}a";
        String trueStroke = "a" + lineSeparator + "}" + lineSeparator + "a";

        IReader stringReader = new StringReader(testStroke);
        IWriter stringWriter = new StringWriter();

        ConfigExecLexer configExecLexer = new ConfigExecLexer();
        Lexer lexer = new Lexer(stringReader, configExecLexer);

        ConfigExecFormatter configExecFormatter = new ConfigExecFormatter();
        Formatter formatter = new Formatter(configExecFormatter);

        formatter.format(lexer, stringWriter);

        String resultStroke = stringWriter.toString();

        assertEquals(trueStroke, resultStroke);
    }
}

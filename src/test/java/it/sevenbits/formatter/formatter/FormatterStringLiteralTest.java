package it.sevenbits.formatter.formatter;

import it.sevenbits.formatter.io.IReader;
import it.sevenbits.formatter.io.IWriter;
import it.sevenbits.formatter.io.ReaderException;
import it.sevenbits.formatter.io.string.StringReader;
import it.sevenbits.formatter.io.string.StringWriter;
import it.sevenbits.formatter.statemachine.formatter.ConfigExecFormatter;
import it.sevenbits.formatter.statemachine.formatter.ContextException;
import it.sevenbits.formatter.statemachine.formatter.Formatter;
import it.sevenbits.formatter.statemachine.lexer.ConfigExecLexer;
import it.sevenbits.formatter.statemachine.lexer.Lexer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FormatterStringLiteralTest {
    @Test
    public void testStringLiteral() throws ReaderException, ContextException {
        String testStroke = "\"{}\n \"";
        String trueStroke = "\"{}\n \"";

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
    public void testStringLiteralInMultiComment() throws ReaderException, ContextException {
        String testStroke = "/*\"{}\n \"\n*/";
        String trueStroke = "/*\"{}\n \"\n*/\n";

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

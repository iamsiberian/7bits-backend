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

public class FormatterForTest {
    private static final String lineSeparator = LineSeparator.get();

    @Test
    public void testFor() throws ReaderException, ContextException {
        String testStroke = "  for (int i = 1;i < 10;i++) {";
        String trueStroke = "for (int i = 1;i < 10;i++) {" + lineSeparator;

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
    public void testNewLineAndCarriageReturnInFor() throws ReaderException, ContextException {
        String testStroke = "  for (int i = 1;i\r\n < 10;i++) {";
        String trueStroke = "for (int i = 1;i < 10;i++) {" + lineSeparator;

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

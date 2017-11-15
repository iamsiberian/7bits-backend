package it.sevenbits;

import it.sevenbits.Exceptions.ReaderException;
import it.sevenbits.Exceptions.WriterException;
import it.sevenbits.IO.String.StringReader;
import it.sevenbits.IO.String.StringWriter;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class TestApp {
    @Test
    public void test1() throws IOException, ReaderException, WriterException{
        String testStroke = "   aaa {\nbbbb\nccc;\n}\n aaa {\n}";
        String trueStroke = "aaa {\n    bbbbccc;\n    }\naaa {\n    }";

        StringReader stringReader = new StringReader(testStroke);
        StringWriter stringWriter = new StringWriter();
        Formatter formatter = new Formatter();
        formatter.format(stringReader, stringWriter);
        String resultStroke = stringWriter.toString();

        assertEquals(trueStroke, resultStroke);
    }

    @Test
    public void test2() throws IOException, ReaderException, WriterException{
        String testStroke = "bbb;ccc;";
        String trueStroke = "bbb;\nccc;";

        StringReader stringReader = new StringReader(testStroke);
        StringWriter stringWriter = new StringWriter();
        Formatter formatter = new Formatter();
        formatter.format(stringReader, stringWriter);
        String resultStroke = stringWriter.toString();

        assertEquals(trueStroke, resultStroke);
    }

    @Test
    public void test3() throws IOException, ReaderException, WriterException{
        String testStroke = "{qwe;}";
        String trueStroke = "{\n    qwe;\n}";

        StringReader stringReader = new StringReader(testStroke);
        StringWriter stringWriter = new StringWriter();
        Formatter formatter = new Formatter();
        formatter.format(stringReader, stringWriter);
        String resultStroke = stringWriter.toString();

        assertEquals(trueStroke, resultStroke);
    }

    @Test
    public void test4() throws IOException, ReaderException, WriterException{
        String testStroke = "abcdef {abcdef;}";
        String trueStroke = "abcdef {\n    abcdef;\n}";

        StringReader stringReader = new StringReader(testStroke);
        StringWriter stringWriter = new StringWriter();
        Formatter formatter = new Formatter();
        formatter.format(stringReader, stringWriter);
        String resultStroke = stringWriter.toString();

        assertEquals(trueStroke, resultStroke);
    }
}

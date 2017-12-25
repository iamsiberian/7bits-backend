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

public class FormatterTest {
    @Test
    public void testCode() throws ReaderException, ContextException {
        String testStroke =
                "public static void main(final String[] args) throws AppException {\n" +
                "final int argsLenghtForFile = 2;\n" +
                "if (args.length == argsLenghtForFile) {\n" +
                "try (\n" +
                "FileReader fileReader = new FileReader(args[0]);\n" +
                "FileWriter fileWriter = new FileWriter(args[1])\n" +
                ") {\n" +
                "ConfigExecLexer configExecLexer = new ConfigExecLexer();\n" +
                "Lexer lexer = new Lexer(fileReader, configExecLexer);\n" +
                "Formatter formatter = new Formatter();\n" +
                "formatter.format(lexer, fileWriter);\n" +
                "} catch (Exception e) {\n" +
                "throw new AppException(\"error in main()\", e);\n" +
                "}\n" +
                "} else {\n" +
                "System.err.println(\"Usage: java -jar *.jar input.file output.file\");\n" +
                "System.exit(1);\n" +
                "}\n" +
                "}\n";
        String trueStroke =
                "public static void main(final String[] args) throws AppException {\n" +
                "    final int argsLenghtForFile = 2;\n" +
                "    if (args.length == argsLenghtForFile) {\n" +
                "        try (FileReader fileReader = new FileReader(args[0]);\n" +
                "        FileWriter fileWriter = new FileWriter(args[1])) {\n" +
                "            ConfigExecLexer configExecLexer = new ConfigExecLexer();\n" +
                "            Lexer lexer = new Lexer(fileReader, configExecLexer);\n" +
                "            Formatter formatter = new Formatter();\n" +
                "            formatter.format(lexer, fileWriter);\n" +
                "        }\n" +
                "        catch (Exception e) {\n" +
                "            throw new AppException(\"error in main()\", e);\n" +
                "        }\n" +
                "    }\n" +
                "    else {\n" +
                "        System.err.println(\"Usage: java -jar *.jar input.file output.file\");\n" +
                "        System.exit(1);\n" +
                "    }\n" +
                "}\n";

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
    public void testCode2() throws ReaderException, ContextException {
        String testStroke =
                "   aaa {\n" +
                "bbbb\n" +
                "ccc;\n" +
                "}\n" +
                " aaa {\n" +
                "}";
        String trueStroke = "aaa {\n" +
                "    bbbbccc;\n" +
                "}\n" +
                "aaa {\n" +
                "}\n";

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

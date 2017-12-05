package it.sevenbits.formatter;


import it.sevenbits.formatter.formatter.FormatterException;
import it.sevenbits.formatter.io.exceptions.CloseableException;
import it.sevenbits.formatter.io.exceptions.ReaderException;
import it.sevenbits.formatter.io.exceptions.WriterException;
import it.sevenbits.formatter.io.file.FileReader;
import it.sevenbits.formatter.io.file.FileWriter;
import it.sevenbits.formatter.lexer.Lexer;
import it.sevenbits.formatter.newFormatter.Formatter;

public class AppNew {
    public static void main(final String[] args) throws ReaderException, WriterException, CloseableException, FormatterException {
        final int argsLenghtForFile = 3;
        if (args.length == argsLenghtForFile && args[0].equals("-f")) {
            try (
                    FileReader fileReader = new FileReader(args[1]);
                    FileWriter fileWriter = new FileWriter(args[2])
            ) {
                Lexer lexer = new Lexer(fileReader);
                Formatter formatter = new Formatter();
                formatter.format(lexer, fileWriter);
            } catch (Exception e) {
                throw new FormatterException("error in main()", e);
            }
        }
    }
}

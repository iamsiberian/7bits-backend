package it.sevenbits;

import it.sevenbits.Exceptions.CloseableException;
import it.sevenbits.Exceptions.FormatterException;
import it.sevenbits.Exceptions.ReaderException;
import it.sevenbits.Exceptions.WriterException;
import it.sevenbits.IO.File.FileReader;
import it.sevenbits.IO.File.FileWriter;

public class App {
    private static int ARGSLENGTHFORFILE = 3;
    private static int ARGSLENGTHFORSTRING = 2;
    public static void main(final String[] args) throws ReaderException, WriterException, CloseableException, FormatterException {
        if (args.length == ARGSLENGTHFORFILE && args[0].equals("-f")) {
            try (
                    FileReader fileReader = new FileReader(args[1]);
                    FileWriter fileWriter = new FileWriter(args[2])
            ) {
                Formatter formatter = new Formatter();
                formatter.format(fileReader, fileWriter);
            } catch (Exception e) {
                throw new FormatterException("", e);
            }
        }
    }
}


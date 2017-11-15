package it.sevenbits;

import it.sevenbits.Exceptions.CloseableException;
import it.sevenbits.Exceptions.FormatterException;
import it.sevenbits.Exceptions.ReaderException;
import it.sevenbits.Exceptions.WriterException;
import it.sevenbits.IO.File.FileReader;
import it.sevenbits.IO.File.FileWriter;

/**
 * Main class
 *
 * @author Minyukhin Ilya
 */
public class App {
    /**
     * The method creates input-output streams and an instance of the Formatter class to call the method format()
     *
     * @param args -f for file
     * path to the file being scanned
     * path to the file with the result
     * @throws ReaderException if an error occurred in Reader
     * @throws WriterException if an error occurred in Writer
     * @throws CloseableException if an error occurred in Reader, Writer
     * @throws FormatterException if an error occurred in main()
     */
    public static void main(final String[] args) throws ReaderException, WriterException, CloseableException, FormatterException {
        final int argsLenghtForFile = 3;
        if (args.length == argsLenghtForFile && args[0].equals("-f")) {
            try (
                    FileReader fileReader = new FileReader(args[1]);
                    FileWriter fileWriter = new FileWriter(args[2])
            ) {
                Formatter formatter = new Formatter();
                formatter.format(fileReader, fileWriter);
            } catch (Exception e) {
                throw new FormatterException("error in main()", e);
            }
        }
    }
}


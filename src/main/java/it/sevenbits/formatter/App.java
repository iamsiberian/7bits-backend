package it.sevenbits.formatter;

import it.sevenbits.formatter.io.file.FileReader;
import it.sevenbits.formatter.io.file.FileWriter;
import it.sevenbits.formatter.newFormatter.Formatter;
import it.sevenbits.formatter.newLexer.Lexer;

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
     * @throws AppException if an error occurred
     */
    public static void main(final String[] args) throws AppException {
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
                throw new AppException("error in main()", e);
            }
        }
    }
}

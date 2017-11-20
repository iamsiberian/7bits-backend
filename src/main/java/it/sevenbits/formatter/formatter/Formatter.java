package it.sevenbits.formatter.formatter;

import it.sevenbits.formatter.io.exceptions.ReaderException;
import it.sevenbits.formatter.io.exceptions.WriterException;
import it.sevenbits.formatter.io.interfaces.IReader;
import it.sevenbits.formatter.io.interfaces.IWriter;

/**
 * class Formatter with a single method for formatting text
 *
 * @author Minyukhin Ilya
 */
public class Formatter {

    /**
     * The method formats indents in the source text, line translations
     *
     * @param iReader common type for instances of a classes: FileReader or StringReader
     * @param iWriter common type for instances of a classes: FileWriter or StringWriter
     * @throws ReaderException if an error occurred in Reader
     * @throws WriterException if an error occurred in Writer
     */
    public void format(final IReader iReader, final IWriter iWriter) throws ReaderException, WriterException {

        final int tab = 4; //Number of spaces in the one tab
        int countLevel = 0;
        boolean isMiddleOfTheLine = false;
        boolean isSpacesBeforeCode = true;
        boolean newLine = false;

        char c;

        try {
            while (iReader.hasNext()) {
                c = iReader.readNext();

                if (c == '{') {
                    iWriter.write(c);
                    countLevel++;
                    isMiddleOfTheLine = false;
                    isSpacesBeforeCode = true;
                    newLine = true;
                } else if (c == '}') {
                    countLevel--;
                    if (newLine) {
                        iWriter.write('\n');
                        for (int i = 0; i < countLevel * tab; i++) {
                            iWriter.write(' ');
                        }
                        iWriter.write(c);
                        isMiddleOfTheLine = false;
                        isSpacesBeforeCode = true;
                        newLine = true;
                    } else {
                        iWriter.write(c);
                        isMiddleOfTheLine = false;
                        isSpacesBeforeCode = true;
                        newLine = true;
                    }
                } else if (c == ';') {
                    iWriter.write(c);
                    isMiddleOfTheLine = false;
                    isSpacesBeforeCode = true;
                    newLine = true;
                } else if (c == '\n') {
                    if (!isMiddleOfTheLine && newLine) {
                        iWriter.write(c);
                        for (int i = 0; i < countLevel * tab; i++) {
                            iWriter.write(' ');
                        }
                        isMiddleOfTheLine = true;
                        isSpacesBeforeCode = true;
                        newLine = false;
                    } //else newLine = true;
                } else if (c == ' ') {
                    if (!isSpacesBeforeCode) {
                        iWriter.write(c);
                    }
                } else {
                    if (newLine) {
                        iWriter.write('\n');
                        for (int i = 0; i < countLevel * tab; i++) {
                            iWriter.write(' ');
                        }
                        iWriter.write(c);
                        newLine = false;
                    } else {
                        iWriter.write(c);
                        //isMiddleOfTheLine = true;
                        isSpacesBeforeCode = false;
                    }
                }
            }
        } catch (ReaderException e) {
            throw new ReaderException("ReaderException in Formatter.format", e);
        } catch (WriterException e) {
            throw new WriterException("WriterException in Formatter.format", e);
        }

    }
}
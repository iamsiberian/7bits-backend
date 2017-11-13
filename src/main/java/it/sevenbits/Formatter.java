package it.sevenbits;

import it.sevenbits.Exceptions.ReaderException;
import it.sevenbits.Exceptions.WriterException;
import it.sevenbits.Interfaces.IReader;
import it.sevenbits.Interfaces.IWriter;

public class Formatter {

    private static int SPACESINTAB = 4;
    private static int countLevel = 0;
    private static boolean isSpacesBeforeCode = true;
    //private static boolean isMiddleOfTheLine = false;
    //private static char c;

    public void format(final IReader iReader, final IWriter iWriter) throws ReaderException, WriterException {
        char c;
        try {
            while (iReader.hasNext()) {
                c = iReader.readNext();

                System.out.print(c);

                iWriter.write(c);
            }
        } catch (ReaderException e) {
            throw new ReaderException("ReaderException in Formatter.format", e);
        } catch (WriterException e) {
            throw new WriterException("WriterException in Formatter.format", e);
        }
    }

    public void tabRecorder(final IWriter iWriter) throws WriterException {
        for (int i = 0; i < countLevel * 4; i++) {
            iWriter.write(' ');
        }
    }
}

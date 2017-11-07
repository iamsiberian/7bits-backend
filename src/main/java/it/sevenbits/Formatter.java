package it.sevenbits;

import it.sevenbits.Exceptions.ReaderException;
import it.sevenbits.Exceptions.WriterException;
import it.sevenbits.IO.File.FileReader;
import it.sevenbits.IO.File.FileWriter;
import it.sevenbits.IO.String.StringReader;
import it.sevenbits.IO.String.StringWriter;

import java.io.IOException;

public class Formatter {
    private static int countLevel = 0;
    private static boolean isSpacesBeforeCode = true;
    public static void main(final String[] args) throws ReaderException, WriterException, IOException {
        if (args.length == 3 && args[0].equals("-f")) {
            try (
                    FileReader fileReader = new FileReader(args[1]);
                    FileWriter fileWriter = new FileWriter(args[2])) {
                CharacterArrayList characterArrayList = new CharacterArrayList(fileReader);
                char c;
                char n;
                for (int i = 0; i < characterArrayList.size(); i++) {
                    c = characterArrayList.get(i);
                    n = characterArrayList.get(i + 1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (args.length == 3 && args[0].equals("-s")) {
            char c;
            StringReader stringReader = new StringReader(args[1]);
            StringWriter stringWriter = new StringWriter(args[2]);
            while (stringReader.hasNext()) {
                c = stringReader.readNext();
                //charRecord(c, stringWriter);
            }
            stringWriter.close();
        }
    }

    public static void charRecord(final char c, final char n, final IWriter writer) throws IOException, WriterException {
        switch (c) {
            case '{' : {
                countLevel++;
                writer.write('{');
                return;
            }
            case '}' : {
                countLevel--;
                writer.write('}');
                return;
            }
            case ' ' : if (!isSpacesBeforeCode) {
                writer.write(' ');
                return;
            }
            case '\n' : {
                writer.write('\n');
                tabRecorder(writer, countLevel);
                isSpacesBeforeCode = false;
                return;
            }
            case ';' : {
                writer.write(';');
                tabRecorder(writer, countLevel);
                return;
            }
            default: {
                isSpacesBeforeCode = false;
                writer.write(c);
            }
        }
    }

    public static void tabRecorder(final IWriter iWriter , final int countLevel) throws IOException, WriterException {
        for (int i = 0; i < countLevel * 4; i++) {
            iWriter.write(' ');
        }
    }
}

package it.sevenbits;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 *
 */
public class App {
    public static void main(final String[] args) throws IOException {
        if (args.length == 2 && args[0].equals("-f")) {
            File fileInput = new File(args[1]);
            FileInputStream inputStream = new FileInputStream(fileInput);
            File fileOutput = new File(fileInput.getParent() + "\\checked" + fileInput.getName());
            FileOutputStream outputStream = new FileOutputStream(fileOutput);
            int whiteSpaceCount = 0;
            int countLevel = 0;
            int countLines = 1;
            while (inputStream.available() > 0) {
                int tempValue = inputStream.read();
                char symbol = (char) tempValue;

                if (symbol == ' ') {
                    whiteSpaceCount++;
                }
                if (symbol == '{') {
                    countLevel++;
                }
                if (symbol == '}') {
                    countLevel--;
                }
                if (symbol == '\n') {
                    countLines++;
                    
                }

            }




            inputStream.close();
            outputStream.close();
        }
    }
}

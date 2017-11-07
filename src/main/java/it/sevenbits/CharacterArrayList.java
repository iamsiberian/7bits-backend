package it.sevenbits;

import it.sevenbits.Exceptions.ReaderException;
import it.sevenbits.IO.File.FileReader;

import java.io.IOException;
import java.util.*;


public class CharacterArrayList extends ArrayList<java.lang.Character> {
    private ArrayList<Character> characterArrayList;

    public CharacterArrayList(final FileReader fileReader) throws ReaderException, IOException {
        characterArrayList = new ArrayList<>();
        char c;
        while (fileReader.hasNext()) {
            c = fileReader.readNext();
            characterArrayList.add(c);
        }
    }
}

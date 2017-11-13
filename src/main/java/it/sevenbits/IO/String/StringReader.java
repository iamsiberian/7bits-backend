package it.sevenbits.IO.String;

import it.sevenbits.Exceptions.ReaderException;
import it.sevenbits.Interfaces.IReader;

public class StringReader implements IReader {

    private String stroke;
    private int count = 0;

    public StringReader(final String stroke) {
        this.stroke = stroke;
    }

    @Override
    public char readNext() throws ReaderException {
        try {
            return stroke.charAt(count);
        } catch (Exception e) {
            throw  new ReaderException("Char at " + count + " can't read", e);
        } finally {
            count++;
        }
    }

    @Override
    public boolean hasNext() {
        return (count < stroke.length());
    }
}

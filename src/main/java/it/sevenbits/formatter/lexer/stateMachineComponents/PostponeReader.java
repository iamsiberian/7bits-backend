package it.sevenbits.formatter.lexer.stateMachineComponents;

import it.sevenbits.formatter.io.exceptions.ReaderException;

/**
 * Created by user on 06.12.2017.
 */
public class PostponeReader implements IStringBuilderReader {

    private StringBuilder stringBuilder;
    private int count = 0;

    public PostponeReader(final StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    @Override
    public char readNext() throws ReaderException {
        try {
            return stringBuilder.charAt(count);
        } catch (Exception e) {
            throw  new ReaderException("Char at " + count + " can't read in PostponeReader.readNext()", e);
        } finally {
            count++;
        }
    }

    @Override
    public boolean hasNext() {
        return (count < stringBuilder.length());
    }
}

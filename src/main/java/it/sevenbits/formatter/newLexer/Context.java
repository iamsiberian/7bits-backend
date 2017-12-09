package it.sevenbits.formatter.newLexer;

/**
 * A class that defines the necessary actions with a char
 *
 * @author Minyukhin Ilya
 */
public class Context implements IContext {

    private String tokenName;
    private StringBuilder tokenLexeme;
    private StringBuilder postponeBuffer;

    /**
     * The basic constructor that initializes the instance of a class
     *
     *
     */
    public Context() {

    }

    @Override
    public void appendLexeme(final char c) {
        tokenLexeme.append(c);
    }

    @Override
    public void setTokenName(final String name) {
        tokenName = name;
    }

    @Override
    public void appendPostpone(final char c) {
        postponeBuffer.append(c);
    }
}

package it.sevenbits.formatter.statemachine.lexer;

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
    Context() {
        tokenName = "";
        tokenLexeme = new StringBuilder();
        postponeBuffer = new StringBuilder();
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

    @Override
    public void newLexeme() {
        tokenLexeme = new StringBuilder();
    }

    @Override
    public StringBuilder getPostponeBuffer() {
        return postponeBuffer;
    }

    @Override
    public void setPostponeBufferZeroLength() {
        postponeBuffer.setLength(0);
    }

    @Override
    public StringBuilder getTokenLexeme() {
        return tokenLexeme;
    }

    @Override
    public String getTokenName() {
        return tokenName;
    }

}

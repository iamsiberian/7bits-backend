package it.sevenbits.formatter.statemachine.lexer;

/**
 * The interface that determines what to do with the symbol read,
 * if necessary, you can assign the name of the token
 *
 * @author Minyukhin Ilya
 */
public interface IContext {
    /**
     * Method adds a character to the lexeme
     *
     * @param c the character that was read
     */
    void appendLexeme(char c);

    /**
     * The method assigns the name of the token
     *
     * @param name the name of the token
     */
    void setTokenName(String name);

    /**
     * Method adds a character to the buffer
     *
     * @param c the character that was read
     */
    void appendPostpone(char c);

    void newLexeme();

    StringBuilder getPostponeBuffer();

    void setPostponeBufferZeroLength();

    StringBuilder getTokenLexeme();

    String getTokenName();
}

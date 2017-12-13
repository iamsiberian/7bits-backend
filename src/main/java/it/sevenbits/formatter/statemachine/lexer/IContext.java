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

    /**
     * The method creates a new lexeme
     */
    void newLexeme();

    /**
     * The method returns the value of the postponeBuffer
     *
     * @return StringBuilder postponeBuffer
     */
    StringBuilder getPostponeBuffer();

    /**
     * The method clears the postponeBuffer
     */
    void setPostponeBufferZeroLength();

    /**
     * The method returns the value of the tokenLexeme
     *
     * @return StringBuilder lexeme of the token
     */
    StringBuilder getTokenLexeme();

    /**
     * The method returns the value of the tokenName
     *
     * @return String name of the token
     */
    String getTokenName();
}

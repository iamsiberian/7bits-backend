package it.sevenbits.formatter.statemachine.formatter;

/**
 * The interface that determines what to do with the lexeme read
 *
 * @author Minyukhin Ilya
 */
public interface IContext {

    /**
     * Method write the lexeme
     *
     * @param lexeme the lexeme that was read
     * @throws ContextException if an error occurred
     */
    void writeLexeme(String lexeme) throws ContextException;

    /**
     * Method write indent
     *
     * @throws ContextException if an error occurred
     */
    void writeIndent() throws ContextException;

    /**
     * Method increases the level
     */
    void increaseCountLevel();

    /**
     * Method decreases the level
     */
    void decreaseCountLevel();

    /**
     * Method write new line
     *
     * @throws ContextException if an error occurred
     */
    void writeNewLine() throws ContextException;
}

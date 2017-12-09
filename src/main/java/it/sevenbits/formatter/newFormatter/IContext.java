package it.sevenbits.formatter.newFormatter;

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
}

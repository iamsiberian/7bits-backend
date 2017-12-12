package it.sevenbits.formatter.statemachine.token;

/**
 * Interface to get the name of the token and lexeme
 *
 * @author Minyukhin Ilya
 */
public interface IToken {

    /**
     * Returns the name of the token
     *
     * @return String name of the token
     */
    String getName();

    /**
     * Returns a lexeme
     *
     * @return String lexeme
     */
    String getLexeme();
}

package it.sevenbits.formatter.token;

/**
 * Interface for receiving information about the token
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
     * Returns the lexeme
     *
     * @return String lexeme
     */
    String getLexeme();
}

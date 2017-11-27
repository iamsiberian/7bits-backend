package it.sevenbits.formatter.lexer;

/**
 * Class wrapper for Exception
 *
 * @author Minyukhin Ilya
 */

public class LexerException extends Exception {
    /**
     * basic constructor
     *
     * @param message exception text
     */
    public LexerException(final String message) {
        super(message);
    }

    /**
     * basic constructor
     *
     * @param cause exception object
     */
    public LexerException(final Throwable cause) {
        super(cause);
    }

    /**
     * basic constructor
     *
     * @param message exception text
     * @param cause exception object
     */
    public LexerException(final String message, final Throwable cause) {
        super(message, cause);
    }
}


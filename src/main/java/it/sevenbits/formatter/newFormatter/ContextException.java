package it.sevenbits.formatter.newFormatter;

/**
 * Class wrapper for Exception
 *
 * @author Minyukhin Ilya
 */
public class ContextException extends Exception {

    /**
     * basic constructor
     *
     * @param message exception text
     */
    public ContextException(final String message) {
        super(message);
    }

    /**
     * basic constructor
     *
     * @param cause exception object
     */
    public ContextException(final Throwable cause) {
        super(cause);
    }

    /**
     * basic constructor
     *
     * @param message exception text
     * @param cause exception object
     */
    public ContextException(final String message, final Throwable cause) {
        super(message, cause);
    }
}

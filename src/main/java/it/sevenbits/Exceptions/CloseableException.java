package it.sevenbits.Exceptions;

/**
 * Class wrapper for Exception
 *
 * @author Minyukhin Ilya
 */
public class CloseableException extends Exception {
    /**
     * basic constructor
     *
     * @param message exception text
     */
    public CloseableException(final String message) {
        super(message);
    }

    /**
     * basic constructor
     *
     * @param cause exception object
     */
    public CloseableException(final Throwable cause) {
        super(cause);
    }

    /**
     * basic constructor
     *
     * @param message exception text
     * @param cause exception object
     */
    public CloseableException(final String message, final Throwable cause) {
        super(message, cause);
    }
}

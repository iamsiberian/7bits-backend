package it.sevenbits.formatter;

/**
 * Class wrapper for Exception
 *
 * @author Minyukhin Ilya
 */
public class AppException extends Exception {

    /**
     * basic constructor
     *
     * @param message exception text
     */
    public AppException(final String message) {
        super(message);
    }

    /**
     * basic constructor
     *
     * @param cause exception object
     */
    public AppException(final Throwable cause) {
        super(cause);
    }

    /**
     * basic constructor
     *
     * @param message exception text
     * @param cause exception object
     */
    public AppException(final String message, final Throwable cause) {
        super(message, cause);
    }
}

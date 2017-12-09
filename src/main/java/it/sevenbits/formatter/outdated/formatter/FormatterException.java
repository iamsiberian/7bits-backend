package it.sevenbits.formatter.outdated.formatter;

/**
 * Class wrapper for Exception
 *
 * @author Minyukhin Ilya
 */
public class FormatterException extends Exception {
    /**
     * basic constructor
     *
     * @param message exception text
     */
    public FormatterException(final String message) {
        super(message);
    }

    /**
     * basic constructor
     *
     * @param cause exception object
     */
    public FormatterException(final Throwable cause) {
        super(cause);
    }

    /**
     * basic constructor
     *
     * @param message exception text
     * @param cause exception object
     */
    public FormatterException(final String message, final Throwable cause) {
        super(message, cause);
    }
}

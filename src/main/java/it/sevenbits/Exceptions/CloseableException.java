package it.sevenbits.Exceptions;

public class CloseableException extends Exception {
    public CloseableException(final String message) {
        super(message);
    }

    public CloseableException(final Throwable cause) {
        super(cause);
    }

    public CloseableException(final String message, final Throwable cause) {
        super(message, cause);
    }
}

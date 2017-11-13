package it.sevenbits.Exceptions;

public class WriterException extends Exception {

    public WriterException(final String message) {
        super(message);
    }

    public WriterException(final Throwable cause) {
        super(cause);
    }

    public WriterException(final String message, final Throwable cause) {
        super(message, cause);
    }
}

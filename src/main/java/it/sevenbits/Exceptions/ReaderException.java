package it.sevenbits.Exceptions;

import java.io.IOException;

public class ReaderException extends Throwable {

    public ReaderException(final String message) {
        super(message);
    }

    public ReaderException(final Throwable cause) {
        super(cause);
    }

    public ReaderException(final String message, final Throwable cause) {
        super(message, cause);
    }
}

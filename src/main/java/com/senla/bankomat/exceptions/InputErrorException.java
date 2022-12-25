package com.senla.bankomat.exceptions;

public class InputErrorException extends Exception {
    public InputErrorException() {
        super();
    }

    public InputErrorException(String message) {
        super(message);
    }

    public InputErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public InputErrorException(Throwable cause) {
        super(cause);
    }

    protected InputErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

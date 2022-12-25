package com.senla.bankomat.exceptions;

public class NoSuchClientException extends Exception{
    public NoSuchClientException() {
        super();
    }

    public NoSuchClientException(String message) {
        super(message);
    }

    public NoSuchClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchClientException(Throwable cause) {
        super(cause);
    }

    protected NoSuchClientException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

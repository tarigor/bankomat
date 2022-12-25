package com.senla.bankomat.exceptions;

public class MenuItemException extends Exception {
    public MenuItemException() {
        super();
    }

    public MenuItemException(String message) {
        super(message);
    }

    public MenuItemException(String message, Throwable cause) {
        super(message, cause);
    }

    public MenuItemException(Throwable cause) {
        super(cause);
    }

    protected MenuItemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

package com.ecommerce.data.exceptions;

public class AddressException extends Exception {

    public AddressException(String message) {
        super(message);
    }

    public AddressException() {
    }

    public AddressException(Throwable cause) {
        super(cause);
    }

    public AddressException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddressException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

package com.leo.market.items.activeitemserver.exception;

/**
 * Custom exception class for the Read/Update/Delete method
 */
public class IdNotFoundException extends RuntimeException {
    public IdNotFoundException(String message) {
        super(message);
    }

    public IdNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

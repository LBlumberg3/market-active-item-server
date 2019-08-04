package com.leo.market.items.activeitemserver.exception;

/**
 * Checked exception for when a client attempts to create a new item without allowing for overwrites of the old item
 * (assuming an item with the provided ID already exists)
 */
public class NonUniqueIdException extends Exception {
    public NonUniqueIdException(String message) {
        super(message);
    }

    public NonUniqueIdException(String message, Throwable cause) {
        super(message, cause);
    }
}

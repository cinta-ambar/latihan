package com.codeanapp.project.exception;

public class NonExistentResourceException extends RuntimeException {
    public NonExistentResourceException(String message) {
        super(message);
    }
}

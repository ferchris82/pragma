package com.chrisferdev.pragma.infrastructure.exception;

public class CategoryAlreadyExistsException extends RuntimeException{
    public CategoryAlreadyExistsException(String message) {
        super(message);
    }
    public CategoryAlreadyExistsException() {
        super();
    }
}

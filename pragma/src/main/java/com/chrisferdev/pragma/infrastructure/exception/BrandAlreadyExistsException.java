package com.chrisferdev.pragma.infrastructure.exception;

public class BrandAlreadyExistsException extends RuntimeException{
    public BrandAlreadyExistsException(String message){
        super(message);
    }
}

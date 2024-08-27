package com.chrisferdev.pragma.infrastructure.exceptionhandler;

public enum ExceptionResponse {
    CATEGORY_NOT_FOUND("No se encontro la categoría"),
    CATEGORY_ALREADY_EXISTS("Ya hay una categoría con ese nombre");

    private String message;

    ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }


}

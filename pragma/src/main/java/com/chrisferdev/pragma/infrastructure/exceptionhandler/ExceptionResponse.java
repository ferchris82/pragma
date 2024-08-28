package com.chrisferdev.pragma.infrastructure.exceptionhandler;

import lombok.Getter;

@Getter
public enum ExceptionResponse {
    CATEGORY_ALREADY_EXISTS("Ya hay una categoría con ese nombre"),
    INVALID_CATEGORY("El nombre o la descripción de la categoría no puede esta vacía");

    private String message;

    ExceptionResponse(String message) {
        this.message = message;
    }


}

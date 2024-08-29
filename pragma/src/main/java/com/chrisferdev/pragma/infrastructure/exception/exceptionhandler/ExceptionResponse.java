package com.chrisferdev.pragma.infrastructure.exception.exceptionhandler;

import lombok.Getter;

@Getter
public enum ExceptionResponse {
    CATEGORY_ALREADY_EXISTS("Ya hay una categoría con ese nombre"),
    INVALID_CATEGORY("El nombre o la descripción de la categoría no puede estar vacía"),
    BRAND_ALREADY_EXISTS("Ya hay una marca con ese nombre"),
    INVALID_BRAND("El nombre o la descripción de la marca no puede estar vacía");

    private String message;

    ExceptionResponse(String message) {
        this.message = message;
    }


}

package com.neoris.account.common.web;

import lombok.Builder;
import lombok.Getter;

/**
 * Vo for response api
 *
 * @author bcueva
 * @version 1.0
 * @param <T> Type data response
 */
@Builder
@Getter
public class Response<T> {
    private T data;
    private String message;

    // Constructor por defecto para permitir la deserialización
    public Response() {}

    public Response(T data, String message) {
        this.data = data;
        this.message = message;
    }

    // Getters y setters
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
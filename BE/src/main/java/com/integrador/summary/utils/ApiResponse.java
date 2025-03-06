package com.integrador.summary.utils;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ApiResponse {

    private String message;
    private Object data;
    private String error;

    public ApiResponse() {
    }

    public ApiResponse(String message, Object data, String error) {
        this.message = message;
        this.data = data;
        this.error = error;
    }

}

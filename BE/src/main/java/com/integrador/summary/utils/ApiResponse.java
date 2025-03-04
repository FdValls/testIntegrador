package com.integrador.summary.utils;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ApiResponse {

    private String message;
    private Object data;

    public ApiResponse() {
    }

    public ApiResponse(String message, Object data) {
        this.message = message;
        this.data = data;
    }

}

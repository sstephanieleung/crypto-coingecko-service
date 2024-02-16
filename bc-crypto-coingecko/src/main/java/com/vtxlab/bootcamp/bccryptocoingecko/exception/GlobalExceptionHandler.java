package com.vtxlab.bootcamp.bccryptocoingecko.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vtxlab.bootcamp.bccryptocoingecko.infra.ApiResponse;
import com.vtxlab.bootcamp.bccryptocoingecko.infra.Syscode;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidInputException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<Void> handleInvalidInputException(InvalidInputException e) {
        return ApiResponse.<Void>builder()
                .code(e.getCode())
                .message(e.getMessage())
                .data(null)
                .build();
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.REQUEST_TIMEOUT)
    public ApiResponse<Void> handleInvalidInputException(RuntimeException e) {
        return ApiResponse.<Void>builder()
                .code(Syscode.RUNTIME_EXCEPTION.getCode())
                .message(Syscode.RUNTIME_EXCEPTION.getMessage())
                .data(null)
                .build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.REQUEST_TIMEOUT)
    public ApiResponse<Void> handleInvalidInputException(Exception e) {
        return ApiResponse.<Void>builder()
                .code(Syscode.GENERAL_EXCEPTION.getCode())
                .message(Syscode.GENERAL_EXCEPTION.getMessage())
                .data(null)
                .build();
    }
}

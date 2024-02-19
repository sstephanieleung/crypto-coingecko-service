package com.vtxlab.bootcamp.bcstockfinnhub.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vtxlab.bootcamp.bcstockfinnhub.infra.ApiResp;
import com.vtxlab.bootcamp.bcstockfinnhub.infra.Syscode;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidParamException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResp<Void> handleInvalidParamException(InvalidParamException e) {
        return ApiResp.<Void>builder()
                .code(Syscode.INVALID_SYMBOL.getCode())
                .message(Syscode.INVALID_SYMBOL.getMessage())
                .data(null)
                .build();
    }
}

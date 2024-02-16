package com.vtxlab.bootcamp.bccryptocoingecko.exception;

import com.vtxlab.bootcamp.bccryptocoingecko.infra.Syscode;

import lombok.Getter;

@Getter
public class InvalidInputException extends RuntimeException {
    
    private String code;

    public InvalidInputException(Syscode syscode){
        super(syscode.getMessage());
    }
}

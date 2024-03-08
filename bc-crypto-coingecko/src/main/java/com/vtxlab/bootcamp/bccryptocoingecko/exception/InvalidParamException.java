package com.vtxlab.bootcamp.bccryptocoingecko.exception;

import com.vtxlab.bootcamp.bccryptocoingecko.infra.Syscode;

import lombok.Getter;

@Getter
public class InvalidParamException extends RuntimeException {
    
    private String code;

    public InvalidParamException(Syscode SysCode){
        super(SysCode.getMessage());
    }
}

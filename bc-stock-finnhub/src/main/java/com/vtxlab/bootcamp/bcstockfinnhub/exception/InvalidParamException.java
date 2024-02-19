package com.vtxlab.bootcamp.bcstockfinnhub.exception;

import com.vtxlab.bootcamp.bcstockfinnhub.infra.Syscode;

import lombok.Getter;

@Getter
public class InvalidParamException extends RuntimeException{

    private String code;

    public InvalidParamException(Syscode syscode){
        super(syscode.getMessage());
        this.code = syscode.getCode();        
    }
}

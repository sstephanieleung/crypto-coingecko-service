package com.vtxlab.bootcamp.bcproductdata.exception;

import com.vtxlab.bootcamp.bcproductdata.infra.Syscode;

import lombok.Getter;

@Getter
public class InvalidParamException extends RuntimeException {
    
    private String code;

    public InvalidParamException(Syscode SysCode){
        super(SysCode.getMessage());
    }
}

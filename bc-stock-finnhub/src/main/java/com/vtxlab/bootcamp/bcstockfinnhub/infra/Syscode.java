package com.vtxlab.bootcamp.bcstockfinnhub.infra;

import lombok.Getter;

@Getter
public enum Syscode {
    
    NORMAL_RESPONSE("000000","OK"),
    INVALID_SYMBOL("910001", "Invalid Symbol Parameter."),
    REST_CLIENT_EXCEPTION("900000","RestClientExcepction - Finnhub Service is unavailable."),
    ;

    private String code;
    private String message;

    private Syscode(String code, String message){
        this.code = code;
        this.message = message;
    }
}

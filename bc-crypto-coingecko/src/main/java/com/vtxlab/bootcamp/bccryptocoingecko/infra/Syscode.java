package com.vtxlab.bootcamp.bccryptocoingecko.infra;

import lombok.Getter;

@Getter
public enum Syscode {
    
    INVALID_CURRENCY_INPUT("1001", "Invalid Currency Input. Examples of valid input: usd, cny, hkd, krw."),
    INVALID_ID_INPUT("1002", "Invalid Coin ID Input: "),
    RUNTIME_EXCEPTION("9001", "Runtime Exception"),
    GENERAL_EXCEPTION("9000", "General Exception"),
    ;

    private String code;
    private String message;

    private Syscode(String code, String message){
        this.code = code;
        this.message = message;
    }
}

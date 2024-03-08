package com.vtxlab.bootcamp.bcproductdata.infra;

import lombok.Getter;

@Getter
public enum Syscode {
    NORMAL_RESPONSE("000000","OK"),
    INVALID_CURRENCY_INPUT("100001", "Invalid Currency Input. Examples of valid input: usd, cny, hkd, krw."),
    INVALID_ID_INPUT("100002", "Invalid Coin ID Input: "),
    REST_CLIENT_EXCEPTION("900000","RestClientExcepction - Finnhub Service is unavailable."),
    RUNTIME_EXCEPTION("900001", "Runtime Exception"),
    GENERAL_EXCEPTION("900000", "General Exception"),
    ;

    private String code;
    private String message;

    private Syscode(String code, String message){
        this.code = code;
        this.message = message;
    }
}

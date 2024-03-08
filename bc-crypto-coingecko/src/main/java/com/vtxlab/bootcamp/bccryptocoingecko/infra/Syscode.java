package com.vtxlab.bootcamp.bccryptocoingecko.infra;

import lombok.Getter;

@Getter
public enum Syscode {
    NORMAL_RESPONSE("000000","OK"),
    INVALID_CURRENCY_INPUT("100001", "Invalid Currency Input. Examples of valid input: usd, cny, hkd, krw."),
    INVALID_ID_INPUT_COINID("100002", "Invalid Coin ID Input: "),
    INVALID_ID_INPUT_STOCKID("100003", "Invalid Stock ID Input: "),
    REST_CLIENT_EXCEPTION_CRYPTO("900000","RestClientExcepction - Crypto Service is unavailable."),
    REST_CLIENT_EXCEPTION_STOCK("900010","RestClientException - Stock Service is unavailable."),
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

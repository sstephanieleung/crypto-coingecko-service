package com.vtxlab.bootcamp.bccryptocoingecko.model;

import com.vtxlab.bootcamp.bccryptocoingecko.exception.InvalidParamException;
import com.vtxlab.bootcamp.bccryptocoingecko.infra.Syscode;

import lombok.Getter;

@Getter
public enum Currency {
    
    US_DOLLAR("usd"),
    INDONESIAN_RUPIAH("inr"),
    NEW_TAIWAN_DOLLAR("twd"),
    EURO("eur"),
    SOUTH_KOREAN_WON("krw"),
    JAPANESE_YEN("jpy"),
    RUSSIAN_RUBLE("rub"),
    CHINESE_YUAN("cny"),
    ;

    private String code;

    private Currency(String code){
        this.code = code;
    }

    public static Currency get(String text) throws InvalidParamException{
        if(text == null)
            return Currency.US_DOLLAR;
        for(Currency cur: Currency.values())
            if(cur.getCode().equals(text))
                return cur;
        throw new InvalidParamException(Syscode.INVALID_CURRENCY_INPUT);
    }
}

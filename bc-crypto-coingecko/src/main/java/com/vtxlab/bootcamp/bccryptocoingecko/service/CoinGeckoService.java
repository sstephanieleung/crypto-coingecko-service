package com.vtxlab.bootcamp.bccryptocoingecko.service;

import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtxlab.bootcamp.bccryptocoingecko.model.Coin;

public interface CoinGeckoService {

    /*
     * Obtain coin information from database
     * Update Database Coins information.
     * Return a list of coin data collected from Coingecko API.
     */
    List<Coin> getCoinsFromApi(String currency) throws JsonProcessingException;

    List<Coin> getCoinsFromMemory(String currency,List<String> ids) throws JsonProcessingException;

}

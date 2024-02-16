package com.vtxlab.bootcamp.bccryptocoingecko.service;

import java.util.List;

import com.vtxlab.bootcamp.bccryptocoingecko.model.Coin;

public interface CoinsGeckoOperation {

    /*
     * Obtain coin information from database
     * Update Database Coins information.
     * Return a list of coin data collected from Coingecko API.
     */
    List<Coin> getCoinsFromApi(String currency);

}

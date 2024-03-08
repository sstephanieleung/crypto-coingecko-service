package com.vtxlab.bootcamp.bccryptocoingecko.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtxlab.bootcamp.bccryptocoingecko.infra.Uri;
import com.vtxlab.bootcamp.bccryptocoingecko.infra.holder.DBHolder;
import com.vtxlab.bootcamp.bccryptocoingecko.infra.holder.RedisHolder;
import com.vtxlab.bootcamp.bccryptocoingecko.model.Coin;
import com.vtxlab.bootcamp.bccryptocoingecko.model.Currency;
import com.vtxlab.bootcamp.bccryptocoingecko.service.CoinGeckoService;

@Service
public class CoinGecko implements CoinGeckoService {

    @Value(value = "${api.coingecko.endpoints.coins-markets}")
    private String endpoint;

    @Value(value = "${memory.key.prefix}")
    private String keyPrefix;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RedisHolder redisHolder;

    @Autowired
    private DBHolder coindb;

    @Autowired
    private Uri uri;

    @Override
    public List<Coin> getCoinsFromApi(String currency) throws JsonProcessingException {
        if (currency == null)
            currency = Currency.US_DOLLAR.getCode(); // default reply data in USD if no specified.

        String url = uri.get(endpoint, currency);
        @SuppressWarnings("null")
        Coin[] coins = restTemplate.getForObject(url, Coin[].class);

        List<Coin> coinList = Arrays.stream(coins).collect(Collectors.toList());
        // Add to redis temporary
        addToMemory(coinList, currency);
        // Update DB: Delete original data an Save the Coin information to DB
        // addToDB(coinList); //private method
        return coinList;
    }

    private void addToMemory(List<Coin> coins, String currency) throws JsonProcessingException {
        String key = keyPrefix.concat(currency).concat(":");
        for (Coin coin : coins)
            redisHolder.set(key.concat(coin.getCoinId()), coin, 60L);
    }

    private void addToDB(List<Coin> coins) {
        coindb.updateCoins(coins);
    }

    @Override
    public List<Coin> getCoinsFromMemory(String currency, List<String> ids) throws JsonProcessingException {
        if (ids == null)
            return getCoinsFromMemory(currency);

        return getCoinsFromMemory(currency).stream()
                .filter(e -> ids.contains(e.getCoinId()))
                .collect(Collectors.toList());
    }

    public List<Coin> getCoinsFromMemory(String currency) throws JsonProcessingException {
        // System.out.println("GOTO getAllKeyStartWith() method");
        String key = keyPrefix.concat(currency).concat(":");
        List<Coin> coins = redisHolder.getAllKeyStartWith(key, Coin.class);
        // System.out.println("COMPLETED getAllKeyStartWith() method");
        return coins;
    }

}


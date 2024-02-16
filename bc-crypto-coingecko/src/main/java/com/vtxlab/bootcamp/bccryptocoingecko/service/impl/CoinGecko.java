package com.vtxlab.bootcamp.bccryptocoingecko.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.vtxlab.bootcamp.bccryptocoingecko.infra.Scheme;
import com.vtxlab.bootcamp.bccryptocoingecko.model.Coin;
import com.vtxlab.bootcamp.bccryptocoingecko.model.Currency;
import com.vtxlab.bootcamp.bccryptocoingecko.service.CoinsGeckoOperation;

@Service
public class CoinGecko implements CoinsGeckoOperation {

    @Value("${api.coingecko.domain}")
    private String domain;

    @Value("${api.coingecko.version}")
    private String apiVersion;

    @Value("${api.coingecko.endpoints.coins-markets}")
    private String endpoint;

    @Value("${api.coingecko.x-cg-api-key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CoinDB coindb;

    @Override
    public List<Coin> getCoinsFromApi(String currency) {
        if (currency == null)
            currency = Currency.US_DOLLAR.getCode(); // default reply data in USD if no specified.

        @SuppressWarnings("null")
        String url = UriComponentsBuilder.newInstance()
                .scheme(Scheme.HTTPS.name().toLowerCase())
                .host(domain)
                .path(apiVersion)
                .path(endpoint)
                .queryParam("vs_currency", Currency.get(currency).getCode())
                .queryParam("order", "market_cap_desc")
                .queryParam("per_page", 100)
                .queryParam("page", 1)
                .queryParam("sparkline", false)
                .queryParam("locale", "en")
                // .queryParam("x_cg_demo_api_key", apiKey)
                .toUriString();
        Coin[] coins = restTemplate.getForObject(url, Coin[].class);

        List<Coin> coinList = Arrays.stream(coins).collect(Collectors.toList());
        //Update DB: Delete original data an Save the Coin information to DB
        coindb.updateCoins(coinList);

        return coinList;
    }

}

// https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&order=market_cap_desc&per_page=100&page=1&sparkline=false&locale=en
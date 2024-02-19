package com.vtxlab.bootcamp.bcstockfinnhub.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.vtxlab.bootcamp.bcstockfinnhub.exception.InvalidParamException;
import com.vtxlab.bootcamp.bcstockfinnhub.infra.Syscode;
import com.vtxlab.bootcamp.bcstockfinnhub.model.Profile;
import com.vtxlab.bootcamp.bcstockfinnhub.model.Quote;
import com.vtxlab.bootcamp.bcstockfinnhub.service.FinnhubService;

@Service
public class Finnhub implements FinnhubService {

    @Value(value = "${api.finnhub.scheme}")
    private String scheme;

    @Value(value = "${api.finnhub.domain}")
    private String domain;

    @Value(value = "${api.finnhub.base_path}")
    private String basePath;

    @Value(value = "${api.finnhub.endpoint.quote}")
    private String endpointQuote;

    @Value(value = "${api.finnhub.endpoint.profile}")
    private String endpointProfile;

    @Value(value = "${api.finnhub.token}")
    private String token;

    @Value(value = "${api.finnhub.symbol}")
    private String symbols;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Quote getStock(String symbol) {
        if (symbol == null)
            throw new InvalidParamException(Syscode.INVALID_SYMBOL);
        if (!validSymbol(symbol))
            throw new InvalidParamException(Syscode.INVALID_SYMBOL);
        String url = UriComponentsBuilder.newInstance()
                .scheme(scheme)
                .host(domain)
                .path(basePath)
                .path(endpointQuote)
                .queryParam("symbol", symbol.toUpperCase())
                .queryParam("token", token)
                .toUriString();
        Quote quote = restTemplate.getForObject(url, Quote.class);
        return quote;
    }

    @Override
    public Profile getProfile(String symbol) {
        if (symbol == null)
            throw new InvalidParamException(Syscode.INVALID_SYMBOL);
        if (!validSymbol(symbol))
            throw new InvalidParamException(Syscode.INVALID_SYMBOL);
        String url = UriComponentsBuilder.newInstance()
                .scheme(scheme)
                .host(domain)
                .path(basePath)
                .path(endpointProfile)
                .queryParam("symbol", symbol.toUpperCase())
                .queryParam("token", token)
                .toUriString();
        Profile profile = restTemplate.getForObject(url, Profile.class);
        return profile;
    }

    private boolean validSymbol(String symbol) {
        if (Arrays.stream(symbols.toLowerCase().split(", "))
                .collect(Collectors.toList())
                .contains(symbol.toLowerCase()))
            return true;
        return false;
    }

}

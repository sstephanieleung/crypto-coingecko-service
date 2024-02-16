package com.vtxlab.bootcamp.bccryptocoingecko.controller;

import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.vtxlab.bootcamp.bccryptocoingecko.dto.CoinDTO;
import com.vtxlab.bootcamp.bccryptocoingecko.infra.ApiResponse;

public interface CoinGeckoOperation {

    /*
     * List all supported coins price, market cap, volume and market related data
     */

    @GetMapping(value = "/coins")
    ApiResponse<List<CoinDTO>> getCoinsFromApi(@RequestParam(value = "currency") String currency,
            @RequestParam(value = "ids", required = false) Set<String> ids);

   
}

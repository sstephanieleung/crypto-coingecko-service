package com.vtxlab.bootcamp.bccryptocoingecko.controller.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.bootcamp.bccryptocoingecko.controller.CoinDBOperation;
import com.vtxlab.bootcamp.bccryptocoingecko.entity.CoinEntity;
import com.vtxlab.bootcamp.bccryptocoingecko.infra.ApiResponse;
import com.vtxlab.bootcamp.bccryptocoingecko.service.impl.CoinDB;
import com.vtxlab.bootcamp.bccryptocoingecko.service.impl.CoinGecko;

@RestController
@RequestMapping(value = "/crypto/coingecko/api/v1/db")
public class CoinDBController implements CoinDBOperation {

    @Autowired
    private CoinGecko coingecko;

    @Autowired
    private CoinDB coindb;

    @Override
    public ApiResponse<List<CoinEntity>> getCoinsFromDB(Set<String> ids) {

        List<CoinEntity> coins = coindb.getCoins(ids);

        System.out.println(coins.get(0));

        if (ids != null) {
            coins = coins.stream().filter(e -> ids.contains(e.getCoinId()))
                    .collect(Collectors.toList());

            List<String> coinIds = coins.stream().map(e -> e.getCoinId()).collect(Collectors.toList());

            List<String> invalidIds = new ArrayList<>();
            for (String id : ids)
                if (!coinIds.contains(id))
                    invalidIds.add(id);

            if (invalidIds.size() == 0)
                return ApiResponse.<List<CoinEntity>>builder()
                        .code("200")
                        .message("OK")
                        .data(coins)
                        .build();

            return ApiResponse.<List<CoinEntity>>builder()
                    .code("200")
                    .message("Invalid Coin ID input: " + String.join(",", invalidIds))
                    .data(coins)
                    .build();
        }

        return ApiResponse.<List<CoinEntity>>builder()
                .code("200")
                .message("OK.")
                .data(coins)
                .build();
    }

    @Override
    public ApiResponse<List<CoinEntity>> refreshDBFromApi(String currency) {
        return ApiResponse.<List<CoinEntity>>builder()
                .code("200")
                .message("OK")
                .data(coindb.updateCoins(coingecko.getCoinsFromApi(currency)))
                .build();
    }

}

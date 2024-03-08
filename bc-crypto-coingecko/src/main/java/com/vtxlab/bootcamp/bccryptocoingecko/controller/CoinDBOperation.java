package com.vtxlab.bootcamp.bccryptocoingecko.controller;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtxlab.bootcamp.bccryptocoingecko.entity.CoinEntity;
import com.vtxlab.bootcamp.bccryptocoingecko.infra.ApiResponse;

public interface CoinDBOperation {

    //CRUD Operation

    @GetMapping(value = "/coins")
    ApiResponse<List<CoinEntity>> getCoinsFromDB(@RequestParam(value = "ids", required = false) Set<String> ids);

    @GetMapping(value = "/coins/updatedb")
    @ResponseStatus(value = HttpStatus.OK)
    ApiResponse<List<CoinEntity>> refreshDBFromApi(@RequestParam(value = "currency", required = false) String currency) throws JsonProcessingException;

    

}

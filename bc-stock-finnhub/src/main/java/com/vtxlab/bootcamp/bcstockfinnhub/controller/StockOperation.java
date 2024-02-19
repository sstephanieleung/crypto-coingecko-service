package com.vtxlab.bootcamp.bcstockfinnhub.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vtxlab.bootcamp.bcstockfinnhub.dto.ProfileDTO;
import com.vtxlab.bootcamp.bcstockfinnhub.dto.QuoteDTO;
import com.vtxlab.bootcamp.bcstockfinnhub.infra.ApiResp;

public interface StockOperation {

    @GetMapping(value = "/quote")
    ApiResp<QuoteDTO> getStock(@RequestParam(name = "symbol") String symbol);

    @GetMapping(value = "/profile2")
    ApiResp<ProfileDTO> getProfile(@RequestParam(name = "symbol") String symbol);
}
    
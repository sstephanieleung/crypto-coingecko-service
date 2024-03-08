package com.vtxlab.bootcamp.bccryptocoingecko.controller.testapi;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtxlab.bootcamp.bccryptocoingecko.dto.CoinDTO;
import com.vtxlab.bootcamp.bccryptocoingecko.infra.ApiResponse;

public interface CoinTestApiOperation {

  @GetMapping(value = "/coins/instant")
  ApiResponse<List<CoinDTO>> getCoinsFromApi(@RequestParam(value = "currency") String currency,
      @RequestParam(value = "ids", required = false) List<String> ids) throws JsonProcessingException;
}

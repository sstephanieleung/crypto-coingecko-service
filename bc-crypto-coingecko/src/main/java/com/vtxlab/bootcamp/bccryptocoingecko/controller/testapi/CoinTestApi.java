package com.vtxlab.bootcamp.bccryptocoingecko.controller.testapi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtxlab.bootcamp.bccryptocoingecko.dto.CoinDTO;
import com.vtxlab.bootcamp.bccryptocoingecko.infra.ApiResponse;
import com.vtxlab.bootcamp.bccryptocoingecko.service.CoinGeckoService;

// @RestController
// @RequestMapping(value = "/crypto/coingecko/api/v1/testapi")
// @CrossOrigin(origins = "http://localhost:8080")
public class CoinTestApi implements CoinTestApiOperation{

  @Autowired
  private CoinGeckoService coingecko;

  @Autowired
  private ModelMapper modelMapper;

  // @GetMapping(value = "/testapi")
  // public String testApi(){
  // return "test-Coingecko-controller";
  // }

  @Override
  public ApiResponse<List<CoinDTO>> getCoinsFromApi(String currency, List<String> ids)
      throws JsonProcessingException {

    List<CoinDTO> coins = coingecko.getCoinsFromApi(currency).stream()
        .map(e -> modelMapper.map(e, CoinDTO.class))
        .collect(Collectors.toList());
    if (ids != null) {
      coins = coins.stream()
          .filter(e -> ids.contains(e.getCoinId()))
          .collect(Collectors.toList());

      List<String> coinIds = coins.stream().map(e -> e.getCoinId()).collect(Collectors.toList());

      List<String> invalidIds = new ArrayList<>();
      for (String id : ids)
        if (!coinIds.contains(id))
          invalidIds.add(id);

      if (invalidIds.size() == 0)
        return ApiResponse.<List<CoinDTO>>builder()
            .code("200")
            .message("OK")
            .data(coins)
            .build();

      return ApiResponse.<List<CoinDTO>>builder()
          .code("200")
          .message("Invalid Coin ID input: " + String.join(",", invalidIds))
          .data(coins)
          .build();
    }

    return ApiResponse.<List<CoinDTO>>builder()
        .code("200")
        .message("OK.")
        .data(coins)
        .build();
  }
}
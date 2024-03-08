package com.vtxlab.bootcamp.bccryptocoingecko.controller.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtxlab.bootcamp.bccryptocoingecko.controller.CoinGeckoOperation;
import com.vtxlab.bootcamp.bccryptocoingecko.dto.CoinDTO;
import com.vtxlab.bootcamp.bccryptocoingecko.infra.ApiResponse;
import com.vtxlab.bootcamp.bccryptocoingecko.service.CoinGeckoService;

@RestController
@RequestMapping(value = "/crypto/coingecko/api/v1")
// @CrossOrigin(origins = "http://localhost:8080")
public class CoinGeckoController implements CoinGeckoOperation {

  @Autowired
  private CoinGeckoService coingecko;

  @Autowired
  private ModelMapper modelMapper;

  @Override
  public ApiResponse<List<CoinDTO>> getCoinsFromMemory(String currency, List<String> ids)
      throws JsonProcessingException {
    System.out.println("FROM CONTROLLER TO getCoinsFromMemory()");
    List<CoinDTO> coins = coingecko.getCoinsFromMemory(currency, ids).stream()
        .map(e -> {
          CoinDTO dto = modelMapper.map(e, CoinDTO.class);
          dto.setCurrency(currency);
          return dto;
        })
        .collect(Collectors.toList());

    return ApiResponse.<List<CoinDTO>>builder()
        .code("200")
        .message("OK")
        .data(coins)
        .build();
  }
}

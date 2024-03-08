package com.vtxlab.bootcamp.bcproductdata.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtxlab.bootcamp.bcproductdata.entity.redis.RCoinQuo;

public interface CryptoOperation {
  
  @GetMapping(value = "/coins")
  List<RCoinQuo> getCryptoQuote(@RequestParam (value = "ids", required = false) List<String> ids) throws JsonProcessingException;
}

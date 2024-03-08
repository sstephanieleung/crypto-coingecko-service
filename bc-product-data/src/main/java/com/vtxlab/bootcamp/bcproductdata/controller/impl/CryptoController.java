package com.vtxlab.bootcamp.bcproductdata.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtxlab.bootcamp.bcproductdata.controller.CryptoOperation;
import com.vtxlab.bootcamp.bcproductdata.dto.CryptoQuote;
import com.vtxlab.bootcamp.bcproductdata.entity.redis.RCoinQuo;
import com.vtxlab.bootcamp.bcproductdata.service.CryptoAPIService;
import com.vtxlab.bootcamp.bcproductdata.service.FinDataService;

@RestController
@RequestMapping(value = "/data/api/v1/product")
public class CryptoController implements CryptoOperation{

  @Autowired
  private CryptoAPIService cryptoAPIService;

  @Autowired
  private FinDataService finDataService;

  // @Autowired
  // private RestTemplate restTemplate;

  @Override
  public List<RCoinQuo> getCryptoQuote(List<String> ids) throws JsonProcessingException {
    System.out.println("CONTROLLER METHOD START");
    System.out.println("ids = " + ids);
    // return cryptoAPIService.getCQ(ids);
    return finDataService.getCoinQuo(ids);
  }

  @GetMapping(value = "/testapi")
  public List<CryptoQuote> testApi(@RequestParam(required = false) List<String> ids) throws JsonProcessingException{
    System.out.println("CONTROLLER METHOD START");
    System.out.println("ids = " + ids);
    return cryptoAPIService.getCQ(ids);
  }

  // @GetMapping(value = "/testapi")
  // public String testApi(){
  //   String url = UriComponentsBuilder.newInstance()
  //       .scheme("http")
  //       .host("localhost")
  //       .port("8090")
  //       .path("/crypto/coingecko/api/v1")
  //       .path("/testapi")
  //       .toUriString();
  //   System.out.println("URL String = " + url);
  //   String response = restTemplate
  //       .getForObject(url, String.class);
  //   // if (response == null)
  //   return response;
  // }
  
}

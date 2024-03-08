package com.vtxlab.bootcamp.bccryptocoingecko.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtxlab.bootcamp.bccryptocoingecko.service.CoinGeckoService;

@Component
@EnableScheduling
public class Scheduler {

  @Autowired
  private CoinGeckoService coinGeckoService;

  @Scheduled(fixedRate = 60000)
  public void getCoinsPerMinute() throws InterruptedException, JsonProcessingException {
    String currency = "usd";
    coinGeckoService.getCoinsFromApi(currency);
  }
}

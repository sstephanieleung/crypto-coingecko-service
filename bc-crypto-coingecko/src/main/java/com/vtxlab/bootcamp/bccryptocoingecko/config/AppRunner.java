package com.vtxlab.bootcamp.bccryptocoingecko.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.vtxlab.bootcamp.bccryptocoingecko.service.CoinGeckoService;

@Component
public class AppRunner implements CommandLineRunner{

  @Autowired
  private CoinGeckoService coinsGeckoOperation;

  @Override
  public void run(String... args) throws Exception {
    coinsGeckoOperation.getCoinsFromApi("usd");
  }
  
}

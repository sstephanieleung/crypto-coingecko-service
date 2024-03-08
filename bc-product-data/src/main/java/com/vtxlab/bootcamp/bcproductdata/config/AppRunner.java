package com.vtxlab.bootcamp.bcproductdata.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.vtxlab.bootcamp.bcproductdata.service.CryptoAPIService;

public class AppRunner implements CommandLineRunner{

  @Autowired
  private CryptoAPIService cryptoAPIService;

  @Override
  public void run(String... args) throws Exception {
    cryptoAPIService.getCQ(null);
  }
  
}

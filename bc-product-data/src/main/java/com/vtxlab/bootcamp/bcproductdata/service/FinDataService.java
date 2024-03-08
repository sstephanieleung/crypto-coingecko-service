package com.vtxlab.bootcamp.bcproductdata.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtxlab.bootcamp.bcproductdata.dto.CryptoQuote;
import com.vtxlab.bootcamp.bcproductdata.entity.TCoinEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.redis.RCoinQuo;

public interface FinDataService {
  
  /*
   * FinData (both Crypto and Stock) shall be kept in DB
   * in a pre-defined structure of entities.
   * This class aims to perform several tasks for the requested data from other microservice API
   * incl: 
   * 1) Conversion of data from original to Entity
   * 2) Pass the Entity data to dbholders for further operations
   */

   List<TCoinEntity> updateCoins(List<CryptoQuote> quotes) throws JsonProcessingException;

   List<RCoinQuo> getCoinQuo(List<String> codes) throws JsonProcessingException; //get RCoinQuo from Redis according to coin code input

}

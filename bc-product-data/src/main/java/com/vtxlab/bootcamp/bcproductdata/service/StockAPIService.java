package com.vtxlab.bootcamp.bcproductdata.service;

import java.util.List;

import com.vtxlab.bootcamp.bcproductdata.model.stock.StockProfile;
import com.vtxlab.bootcamp.bcproductdata.model.stock.StockQuote;

public interface StockAPIService {
  
  /*
   * Get all Stock symbols from API and 
   * Store the symbols to Postgres
   * This should be triggered at least once before project start using AppRunner
   */
  List<String> getStockSymbols();

  /*
   * For each Stock symbols available in Postgres
   * Obtain the corresponding stock profile from API and 
   * Store into Postgres
   * This should be triggered every scheduled period.
   */
  List<StockProfile> getStockProfiles();

  List<StockQuote> getStockQuotes();

  
}

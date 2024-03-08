package com.vtxlab.bootcamp.bcproductdata.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtxlab.bootcamp.bcproductdata.dto.CryptoQuote;

public interface CryptoAPIService {
  
  /*
   * Get Crypto Quotation
   */
  List<CryptoQuote> getCQ(List<String> ids) throws JsonProcessingException;

}

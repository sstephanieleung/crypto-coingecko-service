package com.vtxlab.bootcamp.bcproductdata.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtxlab.bootcamp.bcproductdata.dto.CryptoQuote;
import com.vtxlab.bootcamp.bcproductdata.infra.UrlMaker;
import com.vtxlab.bootcamp.bcproductdata.model.crypto.CryptoApiReceived;
import com.vtxlab.bootcamp.bcproductdata.service.CryptoAPIService;
import com.vtxlab.bootcamp.bcproductdata.service.FinDataService;

@Service
public class CryptoApi implements CryptoAPIService {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  private UrlMaker urlMaker;

  @Autowired
  private FinDataService finDataService;

  @Override
  public List<CryptoQuote> getCQ(List<String> ids) throws JsonProcessingException {
    String url;
    System.out.println("IDS String = " + ids);
    if (ids == null)
      url = urlMaker.getCryptoPath().toUriString();
    else
      url = urlMaker.getCryptoPath()
          .queryParam("ids", String.join(",", ids))
          .toUriString();
      
    System.out.println("URL String = " + url);

    CryptoApiReceived response = restTemplate
        .getForObject(url, CryptoApiReceived.class);

    List<CryptoQuote> cryptos = new ArrayList<>();

    if (response != null) {
      cryptos = response.getData().stream()
          .map(e -> {
            CryptoQuote quote = modelMapper.map(e, CryptoQuote.class);
            quote.setQuoteDate(LocalDate.now());
            return quote;
          })
          .collect(Collectors.toList());
    }
    finDataService.updateCoins(cryptos);
    return cryptos;
  }

}
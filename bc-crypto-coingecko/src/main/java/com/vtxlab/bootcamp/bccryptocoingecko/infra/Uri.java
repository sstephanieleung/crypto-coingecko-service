package com.vtxlab.bootcamp.bccryptocoingecko.infra;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import com.vtxlab.bootcamp.bccryptocoingecko.model.Currency;

@Component
public class Uri {

  @Value(value = "${api.coingecko.domain}")
  private String domain;

  @Value(value = "${api.coingecko.version}")
  private String basePath;

  @Value(value = "${api.coingecko.x-cg-api-key}")
  private String token;

  public String get(String endpoint, String currency) {
    return UriComponentsBuilder.newInstance()
        .scheme(Scheme.HTTPS.name().toLowerCase())
        .host(domain)
        .path(basePath)
        .path(endpoint)
        .queryParam("token", token)
        .queryParam("vs_currency", Currency.get(currency).getCode())
        .queryParam("order", "market_cap_desc")
        .queryParam("per_page", 100)
        .queryParam("page", 1)
        .queryParam("sparkline", false)
        .queryParam("locale", "en")
        .toUriString();
  }
}
// https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&order=market_cap_desc&per_page=100&page=1&sparkline=false&locale=en
package com.vtxlab.bootcamp.bcproductdata.infra;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.util.UriComponentsBuilder;

public class UrlMaker {

  @Value(value = "${api.crypto.domain}")
  private String dCrypto; // domain

  @Value(value = "${api.crypto.port}")
  private String pCrypto; // port

  @Value(value = "${api.crypto.basepath}")
  private String bpCrypto; // base-path

  @Value(value = "${api.crypto.endpath}")
  private String epCQuote; // endpoint

  @Value(value = "${api.crypto.currency}")
  private String currency;

  @Value(value = "${api.stock.domain}")
  private String dStock;

  @Value(value = "${api.stock.port}")
  private String pStock;

  @Value(value = "${api.stock.basepath}")
  private String bpStock;

  @Value(value = "${api.stock.endpath.quote}")
  private String epSQuote;

  @Value(value = "${api.stock.endpath.profile}")
  private String epSProfile;

  public UriComponentsBuilder getCryptoPath() {
    // InfoType type = InfoType.QUOTE;
    UriComponentsBuilder path = UriComponentsBuilder
        .newInstance()
        .scheme("http")
        .host(dCrypto)
        .port(pCrypto)
        .path(bpCrypto)
        .path(epCQuote)
        .queryParam("currency", currency);
    return path;
  }

  public UriComponentsBuilder getStockPath(InfoType type) {
    UriComponentsBuilder path = UriComponentsBuilder
        .newInstance()
        .scheme("http")
        .host(dStock)
        .port(dStock)
        .path(bpStock);
    if (type == InfoType.QUOTE)
      return path.path(epSQuote);
    if (type == InfoType.PROFILE)
      return path.path(epSProfile);
    return path;
  }

}

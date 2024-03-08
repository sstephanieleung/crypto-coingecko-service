package com.vtxlab.bootcamp.bcproductdata.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CryptoQuote {

  private Long id;
  @JsonProperty(value = "quote_date") //datetime
  private LocalDate quoteDate;
  @JsonProperty(value = "quote_coin_code") //varchar
  private String coinCode;
  @JsonProperty(value = "quote_currency")//varchar
  private String currency;
  @JsonProperty(value = "name") //varchar
  private String name;
  @JsonProperty(value = "image") // varchar
  private String image;
  @JsonProperty(value = "curr_price") // double
  private Double currentPrice;
  @JsonProperty(value = "market_cap") // double
  private Long marketCap;
  @JsonProperty(value = "market_cap_rank") // int
  private Integer marketCapRank;
  @JsonProperty(value = "fully_diluted_valuation") //double
  private Long fullyDilutedValuation;
  @JsonProperty(value = "total_volume") //double
  private Long totalVolume;
  @JsonProperty(value = "high_24h") // double
  private Double high24H;
  @JsonProperty(value = "low_24h") // double
  private Double low24H;
  @JsonProperty(value = "price_change_24h") // double
  private Double priceChange24H;
  @JsonProperty(value = "price_change_pct_24h") // double
  private Double priceChangePercentage24H;
  @JsonProperty(value = "circulating_supply") // double
  private Double circulatingSupply;
  @JsonProperty(value = "total_supply") // double
  private Double totalSupply;
  @JsonProperty(value = "max_supply") // double
  private Double maxSupply;
  @JsonProperty(value = "ath") // double
  private Double ath;
  @JsonProperty(value = "ath_change_percentage") // double
  private Double athChangePercentage;
  @JsonProperty(value = "ath_date") //datetime
  private String athDate;
  @JsonProperty(value = "atl") // double
  private Double atl;
  @JsonProperty(value = "atl_change_percentage") // double
  private Double atlChangePercentage;
  @JsonProperty(value = "atl_date") //datetime
  private String atlDate;
}

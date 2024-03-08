package com.vtxlab.bootcamp.bcproductdata.model.crypto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CryptoApiReceived {

  private String code;

  private String message;

  private List<CryptoQuo> data = new ArrayList<>();

  @Getter
  @Setter
  public static class CryptoQuo {
    @JsonProperty(value = "quote_date") // datetime
    private LocalDateTime quoteDate;
    @JsonProperty(value = "id") // varchar
    private String coinCode;
    @JsonProperty(value = "currency") // varchar
    private String currency;
    @JsonProperty(value = "name") // varchar
    private String name;
    @JsonProperty(value = "image") // varchar
    private String image;
    @JsonProperty(value = "curr_price") // double
    private Double currentPrice;
    @JsonProperty(value = "market_cap") // double
    private Long marketCap;
    @JsonProperty(value = "market_cap_rank") // int
    private Integer marketCapRank;
    @JsonProperty(value = "fully_diluted_valuation") // double
    private Long fullyDilutedValuation;
    @JsonProperty(value = "total_volume") // double
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
    @JsonProperty(value = "ath_date") // datetime
    private String athDate;
    @JsonProperty(value = "atl") // double
    private Double atl;
    @JsonProperty(value = "atl_change_percentage") // double
    private Double atlChangePercentage;
    @JsonProperty(value = "atl_date") // datetime
    private String atlDate;
  }
}

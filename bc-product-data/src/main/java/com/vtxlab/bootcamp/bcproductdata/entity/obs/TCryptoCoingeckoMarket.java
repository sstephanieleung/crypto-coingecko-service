package com.vtxlab.bootcamp.bcproductdata.entity.obs;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

// @Entity
// @Table(name = "texternal_crypto_market")
@Setter
@Getter
@Builder
public class TCryptoCoingeckoMarket {
  // @Id
  // @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "quote_date") //datetime
  private LocalDateTime quoteDate;
  @Column(name = "quote_coin_code") //varchar
  private String coinCode;
  @Column(name = "quote_currency")//varchar
  private String currency;
  @Column(name = "name") //varchar
  private String name;
  @Column(name = "image") // varchar
  private String image;
  @Column(name = "curr_price") // double
  private Double currentPrice;
  @Column(name = "market_cap") // double
  private Long marketCap;
  @Column(name = "market_cap_rank") // int
  private Integer marketCapRank;
  @Column(name = "fully_diluted_valuation") //double
  private Long fullyDilutedValuation;
  @Column(name = "total_volume") //double
  private Long totalVolume;
  @Column(name = "high_24h") // double
  private Double high24H;
  @Column(name = "low_24h") // double
  private Double low24H;
  @Column(name = "price_change_24h") // double
  private Double priceChange24H;
  @Column(name = "price_change_pct_24h") // double
  private Double priceChangePercentage24H;
  @Column(name = "circulating_supply") // double
  private Double circulatingSupply;
  @Column(name = "total_supply") // double
  private Double totalSupply;
  @Column(name = "max_supply") // double
  private Double maxSupply;
  @Column(name = "ath") // double
  private Double ath;
  @Column(name = "ath_change_percentage") // double
  private Double athChangePercentage;
  @Column(name = "ath_date") //datetime
  private String athDate;
  @Column(name = "atl") // double
  private Double atl;
  @Column(name = "atl_change_percentage") // double
  private Double atlChangePercentage;
  @Column(name = "atl_date") //datetime
  private String atlDate;
}

package com.vtxlab.bootcamp.bcproductdata.entity.obs;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// @Entity
// @Table(name = "texternal_stock_finnhub_quote")
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TStockFinnhubQuote {
  
  // @Id
  // @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;
  @Column(name = "quote_date")
  private LocalDateTime quoteDate;
  @Column(name = "quote_stock_code")
  private String quoteStockCode;
  @Column(name = "curr_price")
  private Double currentPrice;
  @Column(name = "price_chg")
  private Double priceChange;
  @Column(name = "price_chg_pct")
  private Double priceChangePercentage;
  @Column(name = "price_day_high")
  private Double priceDayHigh;
  @Column(name = "price_day_low")
  private Double priceDayLow;
  @Column(name = "price_prev_open")
  private Double pricePrevOpen;
  @Column(name = "price_prev_close")
  private Double pricePreClose;

}

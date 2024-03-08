package com.vtxlab.bootcamp.bcproductdata.model.stock;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StockQuote {
  
  @JsonProperty(value = "id")
  private Long id;
  @JsonProperty(value = "quote_date")
  private LocalDateTime quoteDate;
  @JsonProperty(value = "quote_stock_code")
  private String quoteStockCode;
  @JsonProperty(value = "curr_price")
  private Double currentPrice;
  @JsonProperty(value = "price_chg")
  private Double priceChange;
  @JsonProperty(value = "price_chg_pct")
  private Double priceChangePercentage;
  @JsonProperty(value = "price_day_high")
  private Double priceDayHigh;
  @JsonProperty(value = "price_day_low")
  private Double priceDayLow;
  @JsonProperty(value = "price_prev_open")
  private Double pricePrevOpen;
  @JsonProperty(value = "price_prev_close")
  private Double pricePreClose;

}

package com.vtxlab.bootcamp.bcproductdata.model.stock;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockProfile {
  
  private Long id;
  @JsonProperty(value = "quote_date")
  private LocalDateTime quoteDate;
  @JsonProperty(value = "quote_stock_code")
  private String quoteStockCode;
  @JsonProperty(value = "country")
  private String country;
  @JsonProperty(value = "currency")
  private String currency;
  @JsonProperty(value = "estimateCurrency")
  private String estimateCurrency;
  @JsonProperty(value = "exchange")
  private String exchange;
  @JsonProperty(value = "finnhubIndustry")
  private String finnhubIndustry;
  @JsonProperty(value = "ipo")
  private String ipo;
  @JsonProperty(value = "logo")
  private String logo;
  @JsonProperty(value = "marketCapitalization")
  private Double marketCapitalization;
  @JsonProperty(value = "name")
  private String name;
  @JsonProperty(value = "phone")
  private String phone;
  @JsonProperty(value = "shareOutstanding")
  private Double shareOutstanding;
  @JsonProperty(value = "ticker")
  private String ticker;
  @JsonProperty(value = "weburl")
  private String weburl;
}

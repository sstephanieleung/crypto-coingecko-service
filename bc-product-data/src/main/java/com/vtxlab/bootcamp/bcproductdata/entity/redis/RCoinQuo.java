package com.vtxlab.bootcamp.bcproductdata.entity.redis;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RCoinQuo {

  @JsonProperty(value ="product_id")
  private String coinCode;

  @JsonProperty(value ="name")
  private String name;

  @JsonProperty(value ="curr_price")
  private Double currentPrice;

  @JsonProperty(value ="price_chg_pct")
  private Double priceChangePercentage;

  @JsonProperty(value ="market_cap")
  private Long marketCap;

  @JsonProperty(value ="logo")
  private String image;
}

package com.vtxlab.bootcamp.bcproductdata.model.stock;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockApiReceived {
  
  private String code;

  private String message;

  private StockProfile data;
}


package com.vtxlab.bootcamp.bcstockfinnhub.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Quote {
    
    @JsonProperty(value = "c")
    private Double currentPrice;

    @JsonProperty(value = "d")
    private Double change;

    @JsonProperty(value = "dp")
    private Double percentageChnage;

    @JsonProperty(value = "h")
    private Double highPriceOfTheDay;

    @JsonProperty(value = "l")
    private Double lowPriceOfTheDay;

    @JsonProperty(value = "o")
    private Double openPriceOfTheDay;

    @JsonProperty(value = "pc")
    private Double previousClosePrice;

    @JsonProperty(value = "t")
    private Long timeStamp;

}

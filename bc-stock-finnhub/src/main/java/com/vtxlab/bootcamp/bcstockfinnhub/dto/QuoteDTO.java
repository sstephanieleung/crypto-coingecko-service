package com.vtxlab.bootcamp.bcstockfinnhub.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QuoteDTO {
    
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

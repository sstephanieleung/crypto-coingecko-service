package com.vtxlab.bootcamp.bccryptocoingecko.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CoinDTO {
    
    @JsonProperty(value = "id")
    private String coinId;

    private String symbol;

    private String name;

    @JsonProperty(value = "currency")
    private String currency;

    private String image;

    @JsonProperty(value = "current_price")
    private Double currentPrice;

    @JsonProperty(value = "market_cap")
    private Long marketCap;

    @JsonProperty(value = "market_cap_rank")
    private Integer marketCapRank;

    @JsonProperty(value = "fully_diluted_valuation")
    private Long fullyDilutedValuation;

    @JsonProperty(value = "total_volume")
    private Long totalVolume;

    @JsonProperty(value = "high_24h")
    private Double high24H;

    @JsonProperty(value = "low_24h")
    private Double low24H;

    @JsonProperty(value = "price_change_24h")
    private Double priceChange24H;

    @JsonProperty(value = "price_change_percentage_24h")
    private Double priceChangePercentage24H;

    @JsonProperty(value = "market_cap_change_24h")
    private Long marketCapChange24h;

    @JsonProperty(value = "market_cap_change_percentage_24h")
    private Double marketCapChangePercentage24h;

    @JsonProperty(value = "circulating_supply")
    private Double circulatingSupply;

    @JsonProperty(value = "total_supply")
    private Double totalSupply;

    @JsonProperty(value = "max_supply")
    private Double maxSupply;

    private Double ath;

    @JsonProperty(value = "ath_change_percentage")
    private Double athChangePercentage;

    @JsonProperty(value = "ath_date")
    private String athDate;

    private Double atl;

    @JsonProperty(value = "atl_change_percentage")
    private Double atlChangePercentage;

    @JsonProperty(value = "atl_date")
    private String atlDate;

    @Setter
    private Roi roi;

    @Getter
    @Builder
    public static class Roi{
        private Double times;
        private String currency;
        private Double percentage;
    }

    @JsonProperty(value = "last_updated")
        private String lastUpdated;
}

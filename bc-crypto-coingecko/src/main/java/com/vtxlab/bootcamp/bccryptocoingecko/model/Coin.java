package com.vtxlab.bootcamp.bccryptocoingecko.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Coin {

    @JsonProperty(value = "id")
    private String coinId;

    private String symbol;

    private String name;

    private String image;

    @JsonProperty(value = "current_price")
    private double currentPrice;

    @JsonProperty(value = "market_cap")
    private long marketCap;

    @JsonProperty(value = "market_cap_rank")
    private int marketCapRank;

    @JsonProperty(value = "fully_diluted_valuation")
    private long fullyDilutedValuation;

    @JsonProperty(value = "total_volume")
    private long totalVolume;

    @JsonProperty(value = "high_24h")
    private double high24H;

    @JsonProperty(value = "low_24h")
    private double low24H;

    @JsonProperty(value = "price_change_24h")
    private double priceChange24H;

    @JsonProperty(value = "price_change_percentage_24h")
    private double priceChangePercentage24H;

    @JsonProperty(value = "circulating_supply")
    private double circulatingSupply;

    @JsonProperty(value = "total_supply")
    private double totalSupply;

    @JsonProperty(value = "max_supply")
    private double maxSupply;

    private double ath;

    @JsonProperty(value = "ath_change_percentage")
    private double athChangePercentage;

    @JsonProperty(value = "ath_date")
    private String athDate;

    private double atl;

    @JsonProperty(value = "atl_change_percentage")
    private double atlChangePercentage;

    @JsonProperty(value = "atl_date")
    private String atlDate;

    private Roi roi;

    @JsonProperty(value = "last_updated")
    private String lastUpdated;

    @Getter
    @Builder
    public static class Roi{
        private double times;
        private String currency;
        private double percentage;
    }
}

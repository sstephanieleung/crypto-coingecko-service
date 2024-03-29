package com.vtxlab.bootcamp.bccryptocoingecko.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Coins")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CoinEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String coinId;

    private String symbol;

    private String name;

    private String image;

    @Column(name = "current_price")
    private Double currentPrice;

    @Column(name = "market_cap")
    private Long marketCap;

    @Column(name = "market_cap_rank")
    private Integer marketCapRank;

    @Column(name = "fully_diluted_valuation")
    private Long fullyDilutedValuation;

    @Column(name = "total_volume")
    private Long totalVolume;

    @Column(name = "high_24h")
    private Double high24H;

    @Column(name = "low_24h")
    private Double low24H;

    @Column(name = "price_change_24h")
    private Double priceChange24H;

    @Column(name = "price_change_percentage_24h")
    private Double priceChangePercentage24H;

    @Column(name = "market_cap_change_24h")
    private Long marketCapChange24h;

    @Column(name = "market_cap_change_percentage_24h")
    private Double marketCapChangePercentage24h;

    @Column(name = "circulating_supply")
    private Double circulatingSupply;

    @Column(name = "total_supply")
    private Double totalSupply;

    @Column(name = "max_supply")
    private Double maxSupply;

    private Double ath;

    @Column(name = "ath_change_percentage")
    private Double athChangePercentage;

    @Column(name = "ath_date")
    private String athDate;

    private Double atl;

    @Column(name = "atl_change_percentage")
    private Double atlChangePercentage;

    @Column(name = "atl_date")
    private String atlDate;

    @Column(name = "last_updated")
    private String lastUpdated;

    @Column(name = "roi_times")
    private Double roiTimes;

    @Column(name = "roi_currency")
    private String roiCurrency;

    @Column(name = "roi_percentage")
    private Double roiPercentage;
}

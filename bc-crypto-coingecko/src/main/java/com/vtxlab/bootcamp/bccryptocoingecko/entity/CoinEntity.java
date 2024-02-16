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
    private double currentPrice;

    @Column(name = "market_cap")
    private long marketCap;

    @Column(name = "market_cap_rank")
    private int marketCapRank;

    @Column(name = "fully_diluted_valuation")
    private long fullyDilutedValuation;

    @Column(name = "total_volume")
    private long totalVolume;

    @Column(name = "high_24h")
    private double high24H;

    @Column(name = "low_24h")
    private double low24H;

    @Column(name = "price_change_24h")
    private double priceChange24H;

    @Column(name = "price_change_percentage_24h")
    private double priceChangePercentage24H;

    @Column(name = "circulating_supply")
    private double circulatingSupply;

    @Column(name = "total_supply")
    private double totalSupply;

    @Column(name = "max_supply")
    private double maxSupply;

    private double ath;

    @Column(name = "ath_change_percentage")
    private double athChangePercentage;

    @Column(name = "ath_date")
    private String athDate;

    private double atl;

    @Column(name = "atl_change_percentage")
    private double atlChangePercentage;

    @Column(name = "atl_date")
    private String atlDate;

    @Column(name = "last_updated")
    private String lastUpdated;

    @Column(name = "roi_times")
    private double roiTimes;

    @Column(name = "roi_currency")
    private String roiCurrency;

    @Column(name = "roi_percentage")
    private double roiPercentage;
}

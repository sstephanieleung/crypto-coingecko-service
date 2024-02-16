package com.vtxlab.bootcamp.bccryptocoingecko.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.vtxlab.bootcamp.bccryptocoingecko.dto.CoinDTO;
import com.vtxlab.bootcamp.bccryptocoingecko.entity.CoinEntity;
import com.vtxlab.bootcamp.bccryptocoingecko.model.Coin;

public class CoinMapper {

    @Autowired
    private ModelMapper modelMapper;

    /*
     * Map List<Coin> to List<CoinEntity>
     */
    public List<CoinEntity> mapToEntity(List<Coin> coins) {
        return coins.stream().map(e -> {
            CoinEntity entity = CoinEntity.builder()
                    .ath(e.getAth()).athChangePercentage(e.getAthChangePercentage()).athDate(e.getAthDate())
                    .atl(e.getAtl()).atlChangePercentage(e.getAtlChangePercentage()).atlDate(e.getAtlDate())
                    .circulatingSupply(e.getCirculatingSupply())
                    .coinId(e.getCoinId()).currentPrice(e.getCurrentPrice())
                    .fullyDilutedValuation(e.getFullyDilutedValuation())
                    .high24H(e.getHigh24H())
                    .image(e.getImage())
                    .lastUpdated(e.getLastUpdated())
                    .low24H(e.getLow24H())
                    .marketCap(e.getMarketCap())
                    .marketCapRank(e.getMarketCapRank())
                    .maxSupply(e.getMaxSupply())
                    .name(e.getName())
                    .priceChange24H(e.getPriceChange24H())
                    .priceChangePercentage24H(e.getPriceChangePercentage24H())
                    .symbol(e.getSymbol())
                    .totalSupply(e.getTotalSupply())
                    .totalVolume(e.getTotalVolume())
                    .build();
            if(e.getRoi() != null){
                entity.setRoiCurrency(e.getRoi().getCurrency());
                entity.setRoiPercentage(e.getRoi().getPercentage());
                entity.setRoiTimes(e.getRoi().getTimes());
            }
            return entity;
        }).collect(Collectors.toList());
    }

    /*
     * Map List<CoinEntity> to List<DTO>
     */
    public List<CoinDTO> mapToDTO(List<CoinEntity> coins) {
        return coins.stream().map(e -> {
            CoinDTO coinDTO = modelMapper.map(e, CoinDTO.class);
            coinDTO.setRoi(CoinDTO.Roi.builder()
                    .currency(e.getRoiCurrency())
                    .percentage(e.getRoiPercentage())
                    .times(e.getRoiTimes())
                    .build());
            return coinDTO;
        }).collect(Collectors.toList());
    }
}

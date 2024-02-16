package com.vtxlab.bootcamp.bccryptocoingecko.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtxlab.bootcamp.bccryptocoingecko.entity.CoinEntity;
import com.vtxlab.bootcamp.bccryptocoingecko.mapper.CoinMapper;
import com.vtxlab.bootcamp.bccryptocoingecko.model.Coin;
import com.vtxlab.bootcamp.bccryptocoingecko.repository.CoinRepository;
import com.vtxlab.bootcamp.bccryptocoingecko.service.CoinDBService;

@Service
public class CoinDB implements CoinDBService {

    @Autowired
    private CoinRepository coinRepository;

    @Autowired
    private CoinMapper coinMapper;

    @Override
    public List<CoinEntity> getCoins(Set<String> coinIds) {
        List<CoinEntity> coins = coinRepository.findAll();
        if (coinIds == null || coinIds.size() == 0)
            return coins;

        return coins.stream()
                .filter(e -> coinIds.contains(e.getCoinId()))
                .collect(Collectors.toList());
    }

    @SuppressWarnings("null")
    @Override
    public List<CoinEntity> saveCoins(List<Coin> coins) {
        if (coins == null)
            return null;
        else
            return coinRepository.saveAll(coinMapper.mapToEntity(coins));
    }

    @Override
    public CoinEntity saveCoin(CoinEntity coin) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveCoin'");
    }

    @Override
    public void deleteCoins() {
        coinRepository.deleteAll();
    }

    @Override
    public List<CoinEntity> updateCoins(List<Coin> coins) {
        this.deleteCoins();
        return this.saveCoins(coins);
    }

}

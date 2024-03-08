package com.vtxlab.bootcamp.bccryptocoingecko.infra.holder;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.vtxlab.bootcamp.bccryptocoingecko.entity.CoinEntity;
import com.vtxlab.bootcamp.bccryptocoingecko.mapper.CoinMapper;
import com.vtxlab.bootcamp.bccryptocoingecko.model.Coin;
import com.vtxlab.bootcamp.bccryptocoingecko.repository.CoinRepository;

public class DBHolder implements DBHolderService {

    
    private CoinRepository coinRepository;

    
    private CoinMapper coinMapper;

    public DBHolder (CoinRepository coinRepository, CoinMapper coinMapper){
        this.coinMapper = coinMapper;
        this.coinRepository = coinRepository;
    }

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

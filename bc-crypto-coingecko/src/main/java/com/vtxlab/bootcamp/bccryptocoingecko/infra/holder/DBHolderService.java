package com.vtxlab.bootcamp.bccryptocoingecko.infra.holder;

import java.util.List;
import java.util.Set;

import com.vtxlab.bootcamp.bccryptocoingecko.entity.CoinEntity;
import com.vtxlab.bootcamp.bccryptocoingecko.model.Coin;

public interface DBHolderService {

    // CoinEntity getCoin(String ids);

    List<CoinEntity> getCoins(Set<String> ids);
    
    List<CoinEntity> saveCoins(List<Coin> coins);

    CoinEntity saveCoin(CoinEntity coin);

    void deleteCoins();

    List<CoinEntity> updateCoins(List<Coin> coins);
 
}

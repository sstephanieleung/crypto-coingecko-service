package com.vtxlab.bootcamp.bcproductdata.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtxlab.bootcamp.bcproductdata.dto.CryptoQuote;
import com.vtxlab.bootcamp.bcproductdata.entity.TCoinEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.redis.RCoinQuo;
import com.vtxlab.bootcamp.bcproductdata.infra.holder.DBHolder;
import com.vtxlab.bootcamp.bcproductdata.infra.holder.RedisHolder;
import com.vtxlab.bootcamp.bcproductdata.infra.mapper.FinDataMapper;
import com.vtxlab.bootcamp.bcproductdata.service.FinDataService;

@Service
public class FinDataOperation implements FinDataService {

  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  private FinDataMapper finDataMapper;

  @Autowired
  private DBHolder dbHolder;

  @Autowired
  private RedisHolder redisHolder;

  @Override
  public List<TCoinEntity> updateCoins(List<CryptoQuote> quotes) throws JsonProcessingException {

    // Update DB Coin data
    dbHolder.deleteTCoins();
    List<TCoinEntity> coinEntities = quotes.stream()
        .map(e -> finDataMapper.mapEntity(e))
        .collect(Collectors.toList());
    dbHolder.saveTCoins(coinEntities);

    // Update Redis Coin data
    String keyprefix = "coin:usd:";
    for (TCoinEntity coin : coinEntities) {
      RCoinQuo rCoinQuo = modelMapper.map(coin.getQuote(), RCoinQuo.class);
      rCoinQuo.setCoinCode(coin.getCoinCode());
      System.out.println("RCoin Get Image = "+ rCoinQuo.getImage());
      redisHolder.set(keyprefix.concat(coin.getCoinCode()), rCoinQuo, 60L);
    }
    return coinEntities;
  }

  public List<RCoinQuo> getCoinQuo(List<String> codes) throws JsonProcessingException {
    String keyprefix = "coin:usd:";
    List<RCoinQuo> coins = redisHolder.getAllKeyStartWith(keyprefix, RCoinQuo.class);
    if (codes == null)
      return coins;
    return coins.stream().filter(e -> codes.contains(e.getCoinCode())).collect(Collectors.toList());
  }

}

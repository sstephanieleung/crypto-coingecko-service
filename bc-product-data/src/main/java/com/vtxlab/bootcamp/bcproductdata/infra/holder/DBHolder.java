package com.vtxlab.bootcamp.bcproductdata.infra.holder;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import com.vtxlab.bootcamp.bcproductdata.entity.TCoinEntity;
import com.vtxlab.bootcamp.bcproductdata.repository.TCoinRepository;

public class DBHolder implements CryptoDBService {

  @Autowired
  private TCoinRepository tCoinRepository;

  @Override
  public Boolean saveTCoins(List<TCoinEntity> coins) {
    Objects.requireNonNull(coins);
    tCoinRepository.saveAll(coins);
    return true;
  }

  @Override
  public void deleteTCoins() {
    tCoinRepository.deleteAll();
  }

}

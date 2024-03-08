package com.vtxlab.bootcamp.bcproductdata.infra.holder;

import java.util.List;

import com.vtxlab.bootcamp.bcproductdata.entity.TCoinEntity;

public interface CryptoDBService {
  
  Boolean saveTCoins(List<TCoinEntity> coins);

  void deleteTCoins();
}

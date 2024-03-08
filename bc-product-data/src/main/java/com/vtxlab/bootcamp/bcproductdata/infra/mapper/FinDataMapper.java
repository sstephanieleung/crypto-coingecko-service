package com.vtxlab.bootcamp.bcproductdata.infra.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vtxlab.bootcamp.bcproductdata.dto.CryptoQuote;
import com.vtxlab.bootcamp.bcproductdata.entity.TCoinEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.TCoinQuoEntity;

@Component
public class FinDataMapper {

  @Autowired
  private ModelMapper modelMapper;

  public TCoinEntity mapEntity(CryptoQuote dto) {
    TCoinEntity coin = modelMapper.map(dto, TCoinEntity.class);
    TCoinQuoEntity quote = modelMapper.map(dto, TCoinQuoEntity.class);
    quote.setCoin(coin);
    coin.setQuote(quote);
    System.out.println("Quote Get Image = "+quote.getImage());
    return coin;
  }
}

package com.vtxlab.bootcamp.bccryptocoingecko;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.vtxlab.bootcamp.bccryptocoingecko.entity.CoinEntity;
import com.vtxlab.bootcamp.bccryptocoingecko.mapper.CoinMapper;
import com.vtxlab.bootcamp.bccryptocoingecko.model.Coin;
import com.vtxlab.bootcamp.bccryptocoingecko.repository.CoinRepository;
import com.vtxlab.bootcamp.bccryptocoingecko.service.impl.CoinDB;

@WebMvcTest(CoinDB.class)
@ExtendWith(MockitoExtension.class)
public class CoinDBTest {

    @MockBean
    private CoinRepository coinRepository;

    @MockBean
    private CoinMapper coinMapper;

    @Test
    void testGetCoin(){

        CoinEntity coin1 = CoinEntity.builder().coinId("bitcoin").build();
        CoinEntity coin2 = CoinEntity.builder().coinId("ethereum").build();
        List<CoinEntity> coins = new ArrayList<>(List.of(coin1, coin2));     
        Set<String> coinIds = new HashSet<>();
        List<CoinEntity> returnCoins = new ArrayList<>(List.of(coin1));

        // mock
        Mockito.when(coinRepository.findAll()).thenReturn(coins);
        Mockito.when(coinIds.contains("bitcoin")).thenReturn(true);
        Mockito.when(coinIds.contains("ethereum")).thenReturn(false);

        
        // assert
        assertEquals(returnCoins, coins.stream()
                .filter(e -> coinIds.contains(e.getCoinId()))
                .collect(Collectors.toList()));

    }

    @Test
    void testSaveCoins(){
        Coin coin1 = Coin.builder().coinId("bitcoin").build();
        Coin coin2 = Coin.builder().coinId("ethereum").build();
        List<Coin> coins = new ArrayList<>(List.of(coin1, coin2));
        CoinEntity coinEntity1 = CoinEntity.builder().coinId("bitcoin").build();
        CoinEntity coinEntity2 = CoinEntity.builder().coinId("ethereum").build();
        List<CoinEntity> coinsEntity = new ArrayList<>(List.of(coinEntity1, coinEntity2));     

        //mock
        Mockito.when(coinMapper.mapToEntity(coins)).thenReturn(coinsEntity);
        Mockito.when(coinRepository.saveAll(coinsEntity)).thenReturn(coinsEntity);

        assertEquals(coinsEntity, coinRepository.saveAll(coinMapper.mapToEntity(coins)));
    }
}

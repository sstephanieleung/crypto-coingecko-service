package com.vtxlab.bootcamp.bccryptocoingecko;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.vtxlab.bootcamp.bccryptocoingecko.dto.CoinDTO;
import com.vtxlab.bootcamp.bccryptocoingecko.entity.CoinEntity;
import com.vtxlab.bootcamp.bccryptocoingecko.mapper.CoinMapper;
import com.vtxlab.bootcamp.bccryptocoingecko.model.Coin;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CoinMapperTest {

    @Autowired
    private CoinMapper coinMapper;

    @MockBean
    private ModelMapper modelMapper;

    @Test
    void testMapToEntity() {
        // Create a list of Coin objects
        List<Coin> coins = new ArrayList<>();
        Coin coin1 = Coin.builder().coinId("bitcoin").build();
        Coin coin2 = Coin.builder().coinId("etheruem").build();
        coins.add(coin1);
        coins.add(coin2);

        
        // Call the mapToEntity method
        List<CoinEntity> entities = coinMapper.mapToEntity(coins);

        // Assert the size of the resulting list
        assertEquals(coins.size(), entities.size());

        // Assert the properties of each entity
        CoinEntity coinEntity1 = entities.get(0);
        assertEquals(coin1.getAth(), coinEntity1.getAth());
        assertEquals(coin1.getAthChangePercentage(), coinEntity1.getAthChangePercentage());

        if (coin1.getRoi() != null) {
            assertEquals(coin1.getRoi().getCurrency(), coinEntity1.getRoiCurrency());
            assertEquals(coin1.getRoi().getPercentage(), coinEntity1.getRoiPercentage());
            assertEquals(coin1.getRoi().getTimes(), coinEntity1.getRoiTimes());
        }
    }

    @Test
    void testMapToDTO() {
        List<CoinEntity> coins = new ArrayList<>();
        CoinEntity coinEntity1 = CoinEntity.builder().coinId("bitcoin").build();
        CoinEntity coinEntity2 = CoinEntity.builder().coinId("etheruem").build();
        coins.add(coinEntity1);
        coins.add(coinEntity2);

        CoinDTO coinDTO1 = CoinDTO.builder().coinId("bitcoin").build();
        CoinDTO coinDTO2 = CoinDTO.builder().coinId("etheruem").build();

        //mock
        Mockito.when(modelMapper.map(coinEntity1, CoinDTO.class)).thenReturn(coinDTO1);
        Mockito.when(modelMapper.map(coinEntity2, CoinDTO.class)).thenReturn(coinDTO2);

        List<CoinDTO> coinDTOs = coinMapper.mapToDTO(coins);

        assertEquals(coins.size(), coinDTOs.size());

        CoinDTO coinDTO3 = coinDTOs.get(0);

        assertEquals(coinEntity1.getAth(), coinDTO3.getAth());
        assertEquals(coinEntity1.getAthChangePercentage(), coinDTO3.getAthChangePercentage());

        if (coinDTO1.getRoi() != null) {
            assertEquals(coinEntity1.getRoiCurrency(), coinDTO3.getRoi().getCurrency());
            assertEquals(coinEntity1.getRoiPercentage(), coinDTO3.getRoi().getPercentage());
            assertEquals(coinEntity1.getRoiTimes(), coinDTO3.getRoi().getTimes());
        }

    }
}

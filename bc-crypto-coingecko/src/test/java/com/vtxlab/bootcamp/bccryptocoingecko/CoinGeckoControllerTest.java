package com.vtxlab.bootcamp.bccryptocoingecko;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import com.vtxlab.bootcamp.bccryptocoingecko.controller.impl.CoinGeckoController;
import com.vtxlab.bootcamp.bccryptocoingecko.dto.CoinDTO;
import com.vtxlab.bootcamp.bccryptocoingecko.model.Coin;
import com.vtxlab.bootcamp.bccryptocoingecko.service.impl.CoinGecko;

@WebMvcTest(CoinGeckoController.class)
public class CoinGeckoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CoinGecko coinGecko;

    @MockBean
    private ModelMapper modelMapper;

    @Test
    void testGetCoins() throws Exception {
        Coin mockReturnEthcoin = Coin.builder()
                .coinId("ethereum")
                .symbol("eth")
                .name("Ethereum")
                .image("https://assets.coingecko.com/coins/images/279/large/ethereum.png?1696501628")
                .currentPrice(2885.25d)
                .marketCap(346798540952L)
                .marketCapRank(2)
                .fullyDilutedValuation(346791568578L)
                .totalVolume(25012036073L)
                .high24H(2894.2d)
                .low24H(2767.68d)
                .priceChange24H(117.57d)
                .priceChangePercentage24H(4.24806d)
                .marketCapChange24h(14377643635L)
                .marketCapChangePercentage24h(4.32513d)
                .circulatingSupply(120165512.393742d)
                .totalSupply(120163096.469676d)
                .maxSupply(null)
                .ath(4878.26d)
                .athChangePercentage(-40.83419d)
                .athDate("2021-11-10T14:24:19.604Z")
                .atl(0.432979d)
                .atlChangePercentage(666505.83204d)
                .atlDate("2015-10-20T00:00:00.000Z")
                .roi(Coin.Roi.builder()
                        .currency("btc")
                        .percentage(7294.855900456845d)
                        .times(72.94855900456845d)
                        .build())
                .lastUpdated("2024-02-19T02:53:49.291Z")
                .build();

        List<Coin> mockReturnCoins = new ArrayList<>();
        mockReturnCoins.add(mockReturnEthcoin);

        CoinDTO mockReturnCoinDTO = CoinDTO.builder()
                .coinId("ethereum")
                .symbol("eth")
                .name("Ethereum")
                .image("https://assets.coingecko.com/coins/images/279/large/ethereum.png?1696501628")
                .currentPrice(2885.25d)
                .marketCap(346798540952L)
                .marketCapRank(2)
                .fullyDilutedValuation(346791568578L)
                .totalVolume(25012036073L)
                .high24H(2894.2d)
                .low24H(2767.68d)
                .priceChange24H(117.57d)
                .priceChangePercentage24H(4.24806d)
                .marketCapChange24h(14377643635L)
                .marketCapChangePercentage24h(4.32513d)
                .circulatingSupply(120165512.393742d)
                .totalSupply(120163096.469676d)
                .maxSupply(null)
                .ath(4878.26d)
                .athChangePercentage(-40.83419d)
                .athDate("2021-11-10T14:24:19.604Z")
                .atl(0.432979d)
                .atlChangePercentage(666505.83204d)
                .atlDate("2015-10-20T00:00:00.000Z")
                .roi(CoinDTO.Roi.builder()
                        .currency("btc")
                        .percentage(7294.855900456845d)
                        .times(72.94855900456845d)
                        .build())
                .lastUpdated("2024-02-19T02:53:49.291Z")
                .build();
        List<CoinDTO> mockReturnCoinDtos = new ArrayList<>();
        mockReturnCoinDtos.add(mockReturnCoinDTO);

        // mock
        Mockito.when(coinGecko.getCoinsFromApi("usd")).thenReturn(mockReturnCoins); // List<Coin>
        Mockito.when(modelMapper.map(mockReturnEthcoin, CoinDTO.class)).thenReturn(mockReturnCoinDTO); // List<CoinDTO>

        assertEquals(mockReturnCoinDtos, mockReturnCoins.stream()
                .map(e -> modelMapper.map(mockReturnEthcoin, CoinDTO.class))
                .collect(Collectors.toList()));

        mockMvc.perform(get("/crypto/coingecko/api/v1/coins")
                .param("currency", "usd")
                .param("ids", "ethereum"))
                .andExpect(status().isOk())
                .andExpectAll(content().contentType(MediaType.APPLICATION_JSON),
                        jsonPath("$.code").value("200"),
                        jsonPath("$.data[0].id").value("ethereum"),
                        jsonPath("$.data[0].symbol").value("eth"),
                        jsonPath("$.data[0].name").value("Ethereum"),
                        jsonPath("$.data[0].image")
                                .value("https://assets.coingecko.com/coins/images/279/large/ethereum.png?1696501628"),
                        jsonPath("$.data[0].current_price").value("2885.25"),
                        jsonPath("$.data[0].market_cap").value(346798540952L),
                        jsonPath("$.data[0].market_cap_rank").value(2),
                        jsonPath("$.data[0].fully_diluted_valuation").value(346791568578L),
                        jsonPath("$.data[0].total_volume").value(25012036073L),
                        jsonPath("$.data[0].high_24h").value(2894.2d),
                        jsonPath("$.data[0].low_24h").value(2767.68),
                        jsonPath("$.data[0].price_change_24h").value(117.57d),
                        jsonPath("$.data[0].price_change_percentage_24h").value(4.24806d),
                        jsonPath("$.data[0].market_cap_change_24h").value(14377643635L),
                        jsonPath("$.data[0].market_cap_change_percentage_24h").value(4.32513d),
                        jsonPath("$.data[0].circulating_supply").value(120165512.393742d),
                        jsonPath("$.data[0].total_supply").value(120163096.469676d),
                        jsonPath("$.data[0].max_supply").doesNotExist(),
                        jsonPath("$.data[0].ath").value(4878.26),
                        jsonPath("$.data[0].ath_change_percentage").value(-40.83419d),
                        jsonPath("$.data[0].ath_date").value("2021-11-10T14:24:19.604Z"),
                        jsonPath("$.data[0].atl").value(0.432979d),
                        jsonPath("$.data[0].atl_change_percentage").value(666505.83204d),
                        jsonPath("$.data[0].atl_date").value("2015-10-20T00:00:00.000Z"),
                        jsonPath("$.data[0].roi.times").value(72.94855900456845d),
                        jsonPath("$.data[0].roi.currency").value("btc"),
                        jsonPath("$.data[0].roi.percentage").value(7294.855900456845d),
                        jsonPath("$.data[0].last_updated").value("2024-02-19T02:53:49.291Z"));
    }
}

package com.vtxlab.bootcamp.bccryptocoingecko;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.vtxlab.bootcamp.bccryptocoingecko.infra.Scheme;
import com.vtxlab.bootcamp.bccryptocoingecko.model.Coin;
import com.vtxlab.bootcamp.bccryptocoingecko.model.Currency;
import com.vtxlab.bootcamp.bccryptocoingecko.service.impl.CoinDB;
import com.vtxlab.bootcamp.bccryptocoingecko.service.impl.CoinGecko;

@WebMvcTest(CoinGecko.class)
@ExtendWith(MockitoExtension.class)
public class CoinGeckoServiceTest {

    @MockBean
    private RestTemplate restTemplate;

    @MockBean
    private CoinDB coindb;

    @Test
    void testGetCoinsFromApi() {
        String currency = "usd";
        String urlExpected = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&order=market_cap_desc&per_page=100&page=1&sparkline=false&locale=en";
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
        Coin[] coins = new Coin[] { mockReturnEthcoin };
        List<Coin> coinsList = new ArrayList<>(List.of(mockReturnEthcoin));
        // mock
        Mockito.when(restTemplate.getForObject(urlExpected, Coin[].class)).thenReturn(coins);
        // assert
        assertEquals(urlExpected, UriComponentsBuilder.newInstance()
                .scheme(Scheme.HTTPS.name().toLowerCase())
                .host("api.coingecko.com")
                .path("/api/v3")
                .path("/coins/markets")
                .queryParam("vs_currency", Currency.get(currency).getCode())
                .queryParam("order", "market_cap_desc")
                .queryParam("per_page", 100)
                .queryParam("page", 1)
                .queryParam("sparkline", false)
                .queryParam("locale", "en")
                // .queryParam("x_cg_demo_api_key", apiKey)
                .toUriString());
        assertEquals(coinsList, Arrays.stream(coins).collect(Collectors.toList()));
        
    }
}

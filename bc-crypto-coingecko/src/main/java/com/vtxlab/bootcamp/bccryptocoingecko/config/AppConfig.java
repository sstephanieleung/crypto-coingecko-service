package com.vtxlab.bootcamp.bccryptocoingecko.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.vtxlab.bootcamp.bccryptocoingecko.mapper.CoinMapper;

@Configuration
public class AppConfig {
    
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    CoinMapper coinMapper(){
        return new CoinMapper();
    }

}

package com.vtxlab.bootcamp.bccryptocoingecko.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vtxlab.bootcamp.bccryptocoingecko.infra.holder.DBHolder;
import com.vtxlab.bootcamp.bccryptocoingecko.infra.holder.RedisHolder;
import com.vtxlab.bootcamp.bccryptocoingecko.mapper.CoinMapper;
import com.vtxlab.bootcamp.bccryptocoingecko.repository.CoinRepository;

@Configuration
public class AppConfig {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    CoinMapper coinMapper() {
        return new CoinMapper();
    }

    @Bean
    RedisHolder redisHolder(RedisConnectionFactory redisConnectionFactory, ObjectMapper objectMapper) {
        return new RedisHolder(redisConnectionFactory, objectMapper);
    }

    @Bean
    DBHolder dbHolder(CoinRepository coinRepository, CoinMapper coinMapper) {
        return new DBHolder(coinRepository, coinMapper);
    }

}

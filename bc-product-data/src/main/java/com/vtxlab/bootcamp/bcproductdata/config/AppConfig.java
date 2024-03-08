package com.vtxlab.bootcamp.bcproductdata.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vtxlab.bootcamp.bcproductdata.infra.UrlMaker;
import com.vtxlab.bootcamp.bcproductdata.infra.holder.DBHolder;
import com.vtxlab.bootcamp.bcproductdata.infra.holder.RedisHolder;
import com.vtxlab.bootcamp.bcproductdata.infra.mapper.FinDataMapper;

@Configuration
public class AppConfig {

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }

  @Bean
  public UrlMaker urlMaker() {
    return new UrlMaker();
  }

  @Bean
  public FinDataMapper finDataMapper() {
    return new FinDataMapper();
  }

  @Bean
  public DBHolder dbHolder(){
    return new DBHolder();
  }

  @Bean
  public RedisHolder redisHolder(RedisConnectionFactory redisConnectionFactory, ObjectMapper objectMapper){
    return new RedisHolder(redisConnectionFactory, objectMapper);
  }

}

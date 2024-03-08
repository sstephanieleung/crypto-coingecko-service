package com.vtxlab.bootcamp.bccryptocoingecko.infra.holder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vtxlab.bootcamp.bccryptocoingecko.exception.InvalidParamException;
import com.vtxlab.bootcamp.bccryptocoingecko.exception.RestClientException;
import com.vtxlab.bootcamp.bccryptocoingecko.infra.Syscode;

public class RedisHolder {

  private RedisTemplate<String, String> redisTemplate;

  private ObjectMapper objectMapper;

  public RedisHolder(RedisTemplate<String, String> redisTemplate, ObjectMapper objectMapper) {
    Objects.requireNonNull(objectMapper);
    this.objectMapper = objectMapper;
    Objects.requireNonNull(redisTemplate);
    this.redisTemplate = redisTemplate;
  }

  public RedisHolder(RedisConnectionFactory redisConnectionFactory, ObjectMapper objectMapper) {
    RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(redisConnectionFactory);
    redisTemplate.setKeySerializer(RedisSerializer.string());
    redisTemplate.setValueSerializer(RedisSerializer.json());
    redisTemplate.afterPropertiesSet();
    this.redisTemplate = redisTemplate;
    Objects.requireNonNull(objectMapper);
    this.objectMapper = objectMapper;
  }

  @SuppressWarnings("null")
  public void set(String key, Object value, Long expireSeconds) throws JsonProcessingException {
    if (key == null)
      throw new InvalidParamException(Syscode.INVALID_ID_INPUT_COINID);
    String serializedData = objectMapper.writeValueAsString(value);
    Objects.requireNonNull(serializedData);
    redisTemplate.opsForValue().set(key, serializedData);
    Objects.requireNonNull(expireSeconds);
    // redisTemplate.expire(key, Duration.ofSeconds(expireSeconds));
  }

  public <T> T get(String key, Class<T> responseType) throws JsonProcessingException {
    if (key == null)
      throw new InvalidParamException(Syscode.INVALID_ID_INPUT_COINID);
    String value = redisTemplate.opsForValue().get(key);
    if (value == null)
      throw new RestClientException(Syscode.REST_CLIENT_EXCEPTION_CRYPTO);
    return objectMapper.readValue(value, responseType);
  }

  public <T> List<T> getAllKeyStartWith(String prefix, Class<T> responseType) throws JsonProcessingException {
    if (prefix == null)
      throw new InvalidParamException(Syscode.INVALID_ID_INPUT_COINID);
    @SuppressWarnings("null")
    Set<String> keys = redisTemplate.keys(prefix.concat("*"));
    List<T> values = new ArrayList<>();
    if (keys != null)
      for (String key : keys) {
        String value = redisTemplate.opsForValue().get(key);
        T object = objectMapper.readValue(value, responseType);
        values.add(object);
      }
    return values;
    // if (value == null)
    // throw new RestClientException(Syscode.REST_CLIENT_EXCEPTION);
    // return objectMapper.readValue(value, responseType);
  }
}

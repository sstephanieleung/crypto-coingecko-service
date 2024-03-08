package com.vtxlab.bootcamp.bccryptocoingecko.exception;

import com.vtxlab.bootcamp.bccryptocoingecko.infra.Syscode;

import lombok.Getter;

@Getter
public class RestClientException extends RuntimeException {
  
  private String code;

  public RestClientException(Syscode SysCode){
    super(SysCode.getMessage());
    this.code = SysCode.getCode();
  }
}

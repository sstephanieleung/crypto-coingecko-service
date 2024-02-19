package com.vtxlab.bootcamp.bcstockfinnhub.controller.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.bootcamp.bcstockfinnhub.controller.StockOperation;
import com.vtxlab.bootcamp.bcstockfinnhub.dto.ProfileDTO;
import com.vtxlab.bootcamp.bcstockfinnhub.dto.QuoteDTO;
import com.vtxlab.bootcamp.bcstockfinnhub.infra.ApiResp;
import com.vtxlab.bootcamp.bcstockfinnhub.infra.Syscode;
import com.vtxlab.bootcamp.bcstockfinnhub.service.impl.Finnhub;

@RestController
@RequestMapping(value = "/stock/finnhub/api/v1")
public class StockController implements StockOperation {

    @Autowired
    private Finnhub finnhub;

    @Autowired
    private ModelMapper modelMapper;  //Setter is required for DTO class when using modelMapper

    @Override
    public ApiResp<QuoteDTO> getStock(String symbol) {
        QuoteDTO stockDTO = modelMapper.map(finnhub.getStock(symbol), QuoteDTO.class);
        // Quote stock = finnhub.getStock(symbol);
        return ApiResp.<QuoteDTO>builder()
                .code(Syscode.NORMAL_RESPONSE.getCode())
                .message(Syscode.NORMAL_RESPONSE.getMessage())
                .data(stockDTO)
                .build();
    }

    @Override
    public ApiResp<ProfileDTO> getProfile(String symbol) {
        ProfileDTO profileDTO = modelMapper.map(finnhub.getProfile(symbol), ProfileDTO.class);
        return ApiResp.<ProfileDTO>builder()
                .code(Syscode.NORMAL_RESPONSE.getCode())
                .message(Syscode.NORMAL_RESPONSE.getMessage())
                .data(profileDTO)
                .build();
    }

}

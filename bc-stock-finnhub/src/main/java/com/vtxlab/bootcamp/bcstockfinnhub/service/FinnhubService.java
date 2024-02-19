package com.vtxlab.bootcamp.bcstockfinnhub.service;

import com.vtxlab.bootcamp.bcstockfinnhub.model.Profile;
import com.vtxlab.bootcamp.bcstockfinnhub.model.Quote;

public interface FinnhubService {
    
    Quote getStock(String symbol);

    Profile getProfile(String symbol);

}

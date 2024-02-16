package com.vtxlab.bootcamp.bccryptocoingecko.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vtxlab.bootcamp.bccryptocoingecko.entity.CoinEntity;


@Repository
public interface CoinRepository extends JpaRepository<CoinEntity, Long>{
    
    //JPARepository is an interface, Hibernate will generate all required codes fulfilling the contract with interface and the custom query methods.
    //One EntityClass only for one JPA application, the Entity Class must implement Serializable
}

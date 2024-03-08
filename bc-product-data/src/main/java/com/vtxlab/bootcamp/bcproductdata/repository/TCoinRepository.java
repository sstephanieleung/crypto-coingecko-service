package com.vtxlab.bootcamp.bcproductdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vtxlab.bootcamp.bcproductdata.entity.TCoinEntity;

@Repository
public interface TCoinRepository extends JpaRepository<TCoinEntity, Long>{
  
}

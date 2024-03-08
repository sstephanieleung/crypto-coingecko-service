package com.vtxlab.bootcamp.bcproductdata.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tproduct_coins")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TCoinQuoEntity implements Serializable{
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "coin_id")
  private Long coinId;

  @Column(name = "name")
  private String name;

  @Column(name = "curr_price")
  private Double currentPrice;

  @Column(name = "price_chg_pct")
  private Double priceChangePercentage;

  @Column(name = "market_cap")
  private Long marketCap;

  @Column(name = "logo")
  private String image;

  @OneToOne
  @JoinColumn(name = "tproduct_coin_list_id")
  @JsonBackReference
  private TCoinEntity coin;
}

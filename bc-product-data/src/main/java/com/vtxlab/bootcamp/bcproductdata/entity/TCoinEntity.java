package com.vtxlab.bootcamp.bcproductdata.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tproduct_coin_list")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TCoinEntity extends TProduct implements Serializable{
  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "coin_code")
  private String coinCode;

  @OneToOne(mappedBy = "coin", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonManagedReference
  private TCoinQuoEntity quote;
}

package com.app.eece4792mealmaster.models.products;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "nutrients")
public class Nutrient {
  @Id
  private Long nutrientCode;
  private String derivationDescription;
  private double outputValue;
  private String outputUom;

  @ManyToOne
  @MapsId("ndbNo")
  @JsonIgnore
  private Product product;
}

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

  public Long getNutrientCode() {
    return nutrientCode;
  }

  public void setNutrientCode(Long nutrientCode) {
    this.nutrientCode = nutrientCode;
  }

  public String getDerivationDescription() {
    return derivationDescription;
  }

  public void setDerivationDescription(String derivationDescription) {
    this.derivationDescription = derivationDescription;
  }

  public double getOutputValue() {
    return outputValue;
  }

  public void setOutputValue(double outputValue) {
    this.outputValue = outputValue;
  }

  public String getOutputUom() {
    return outputUom;
  }

  public void setOutputUom(String outputUom) {
    this.outputUom = outputUom;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }
}

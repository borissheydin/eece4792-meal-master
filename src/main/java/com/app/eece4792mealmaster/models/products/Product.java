package com.app.eece4792mealmaster.models.products;

import com.app.eece4792mealmaster.models.GenericFood;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
  public Product() {}

  @Id
  private Long ndbNo;
  @Column(columnDefinition = "text")
  private String longName;
  private String manufacturer;
  private Double servingSize;
  private Double householdServingSize;
  private String servingSizeUom;
  private String householdServingSizeUom;
  @Column(columnDefinition = "longtext")
  private String ingredients;
  @ManyToOne
  @MapsId("genericFoodId")
  private GenericFood genericClassification;

  @OneToMany (mappedBy = "product")
  private Set<Nutrient> nutrients;

  public Long getNdbNo() {
    return ndbNo;
  }

  public void setNdbNo(Long ndbNo) {
    this.ndbNo = ndbNo;
  }

  public String getLongName() {
    return longName;
  }

  public void setLongName(String longName) {
    this.longName = longName;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public Double getServingSize() {
    return servingSize;
  }

  public void setServingSize(Double servingSize) {
    this.servingSize = servingSize;
  }

  public Double getHouseholdServingSize() {
    return householdServingSize;
  }

  public void setHouseholdServingSize(Double householdServingSize) {
    this.householdServingSize = householdServingSize;
  }

  public String getServingSizeUom() {
    return servingSizeUom;
  }

  public void setServingSizeUom(String servingSizeUom) {
    this.servingSizeUom = servingSizeUom;
  }

  public String getHouseholdServingSizeUom() {
    return householdServingSizeUom;
  }

  public void setHouseholdServingSizeUom(String householdServingSizeUom) {
    this.householdServingSizeUom = householdServingSizeUom;
  }

  public String getIngredients() {
    return ingredients;
  }

  public void setIngredients(String ingredients) {
    this.ingredients = ingredients;
  }

  public GenericFood getGenericClassification() {
    return genericClassification;
  }

  public void setGenericClassification(GenericFood genericClassification) {
    this.genericClassification = genericClassification;
  }

  public Set<Nutrient> getNutrients() {
    return nutrients;
  }

  public void setNutrients(Set<Nutrient> nutrients) {
    this.nutrients = nutrients;
  }
}

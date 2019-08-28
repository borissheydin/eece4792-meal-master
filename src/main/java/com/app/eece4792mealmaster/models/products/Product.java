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
}

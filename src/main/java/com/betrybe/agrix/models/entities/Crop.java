package com.betrybe.agrix.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * The type Crop.
 */

@Entity
@Table(name = "crops")
public class Crop {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;

  @Column(name = "planted_area")
  private Double plantedArea;

  @ManyToOne
  @JoinColumn(name = "farm_id")
  private Farm farm;

  /**
   * Empty constructor.
   */
  public Crop() {}

  /**
   * Constructor crop.
   *
   * @param id long
   * @param name string
   * @param plantedArea double
   * @param farm farm crop
   */

  public Crop(Long id, String name, Double plantedArea, Farm farm) {
    this.id = id;
    this.name = name;
    this.plantedArea = plantedArea;
    this.farm = farm;
  }

  public void setPlantedArea(Double plantedArea) {
    this.plantedArea = plantedArea;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setFarm(Farm farm) {
    this.farm = farm;
  }

  public String getName() {
    return name;
  }

  public Farm getFarm() {
    return farm;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getPlantedArea() {
    return plantedArea;
  }
}

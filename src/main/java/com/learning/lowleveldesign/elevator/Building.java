package com.learning.lowleveldesign.elevator;

import java.util.ArrayList;
import java.util.List;

public class Building {
  private String name;
  private Integer buildingId;
  private Address address;
  private List<BuildingSection> sections;

  public Building(String name, Integer buildingId, Address address) {
    this.name = name;
    this.buildingId = buildingId;
    this.address = address;
    this.sections = new ArrayList<>();
  }

  public void addSection(BuildingSection buildingSection){
    this.sections.add(buildingSection);
  }

  public List<BuildingSection> getSections() {
    return sections;
  }

  public String getName() {
    return name;
  }

  public Integer getBuildingId() {
    return buildingId;
  }

  public Address getAddress() {
    return address;
  }
}

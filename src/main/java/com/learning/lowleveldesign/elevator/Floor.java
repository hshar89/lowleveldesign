package com.learning.lowleveldesign.elevator;

import java.util.HashMap;
import java.util.Map;

public class Floor {
  private final Integer floorNumber;
  private final Map<String, Button> elevatorLobbyButtons;
  private FloorStatus floorStatus;

  public Floor(Integer floorNumber) {
    this.floorNumber = floorNumber;
    this.elevatorLobbyButtons = new HashMap<>();
  }

  public void addLobbyButton(String liftId, Button button) {
    elevatorLobbyButtons.put(liftId, button);
  }

  public void setFloorStatus(FloorStatus floorStatus) {
    this.floorStatus = floorStatus;
  }

  public void pressButton(String liftId) {
    elevatorLobbyButtons.get(liftId).performAction(floorNumber);
  }

}

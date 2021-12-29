package com.learning.lowleveldesign.elevator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Floor {
  private final Integer floorNumber;
  private final Map<String, Lift> liftMap;
  private FloorStatus floorStatus;

  public Floor(Integer floorNumber) {
    this.floorNumber = floorNumber;
    this.liftMap = new HashMap<>();
  }

  public void addLift(Lift lift) {
    liftMap.put(lift.getLiftId(), lift);
  }

  public void setFloorStatus(FloorStatus floorStatus) {
    this.floorStatus = floorStatus;
  }

  public boolean move(String liftId, Direction direction) {
    List<Lift> liftsAtCurrentFloor = getLiftsAtFloor();
    if (liftsAtCurrentFloor.isEmpty()) {
      liftsAtCurrentFloor.forEach(lift -> {
        lift.openDoor();
      });
      return false;
    }
    List<Lift> liftsGoingInGiveDirection = getLiftsGoingInDirection(direction);
    if(!liftsGoingInGiveDirection.isEmpty()){
      for (Lift lift : liftsGoingInGiveDirection) {
        lift.selectFloor(floorNumber);
      }
    }else{
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      move(liftId, direction);
    }
    return true;
  }

  private List<Lift> getLiftsGoingInDirection(Direction direction) {
    return liftMap.entrySet().stream().map(entry->entry.getValue())
        .filter(lift -> lift.getCurrentDirection().equals(direction)).collect(Collectors.toList());
  }

  private List<Lift> getLiftsAtFloor() {
    return liftMap.entrySet().stream().map(entry -> entry.getValue())
        .filter(lift -> lift.getCurrentFloorNumber() == this.floorNumber && !lift.isDoorClosed()).collect(
            Collectors.toList());
  }

}

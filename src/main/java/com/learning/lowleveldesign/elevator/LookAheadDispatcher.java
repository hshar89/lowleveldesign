package com.learning.lowleveldesign.elevator;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LookAheadDispatcher implements Dispatcher {

  private final Map<String, Lift> liftMap;
  private final Integer maxFloorsInBuilding;
  private final Integer maxFloorNumber;
  private final Integer minFloorNumber;

  public LookAheadDispatcher(Map<String, Lift> liftMap, Integer maxFloorsInBuilding, Integer maxFloorNumber,
                             Integer minFloorNumber) {
    this.liftMap = liftMap;
    this.maxFloorsInBuilding = maxFloorsInBuilding;
    this.maxFloorNumber = maxFloorNumber;
    this.minFloorNumber = minFloorNumber;
  }

  @Override
  public boolean assignFloorToLift(Integer floorId, String liftId) {
    if (floorId < minFloorNumber || floorId > maxFloorNumber) {
      return false;
    }
    Lift lift = liftMap.get(liftId);
    return lift.selectFloor(floorId);
  }

  @Override
  public boolean assignLiftToFloor(Direction direction, Integer floorNum) {
    List<Lift> liftsAtCurrentFloor = getLiftsAtCurrentFloor(floorNum, direction);
    if (!liftsAtCurrentFloor.isEmpty()) {
      for (Lift lift : liftsAtCurrentFloor) {
        lift.openDoor();
      }
      return true;
    }
    Lift lift = getNearestLift(floorNum, direction);
    if (lift != null) {
      lift.assignFloorToLift(floorNum);
    }
    return false;
  }

  private Lift getNearestLift(Integer floor, Direction direction) {
    int minDistance = maxFloorsInBuilding;
    Lift selectedLift = null;
    for (Map.Entry<String, Lift> entry : liftMap.entrySet()) {
      int distance = Math.abs(entry.getValue().getCurrentFloorNumber() - floor);
      if ((entry.getValue().getCurrentDirection().equals(direction) || entry.getValue().isLiftIdle()) &&
          distance < minDistance) {
        minDistance = distance;
        selectedLift = entry.getValue();
      }
    }
    return selectedLift;
  }

  private List<Lift> getLiftsAtCurrentFloor(Integer floorNum, Direction direction) {
    return liftMap.entrySet().stream().map(entry -> entry.getValue())
        .filter(lift -> lift.getCurrentFloorNumber() == floorNum && (!lift.isDoorClosed() &&
            lift.getCurrentDirection().equals(direction)) || (lift.isLiftIdle())).collect(
            Collectors.toList());
  }
}

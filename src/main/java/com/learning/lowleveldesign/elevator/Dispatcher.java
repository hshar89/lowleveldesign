package com.learning.lowleveldesign.elevator;

public interface Dispatcher {

  boolean assignFloorToLift(Integer floorId, String liftId);

  boolean assignLiftToFloor(Direction direction, Integer floorNum);
}

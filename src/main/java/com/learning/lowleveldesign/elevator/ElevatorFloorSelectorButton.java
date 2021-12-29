package com.learning.lowleveldesign.elevator;

public class ElevatorFloorSelectorButton implements Button<Integer>{

  private final String liftId;
  private final Dispatcher dispatcher;

  public ElevatorFloorSelectorButton(String liftId, Dispatcher dispatcher) {
    this.liftId = liftId;
    this.dispatcher = dispatcher;
  }

  @Override
  public void performAction(Integer floorId) {
    dispatcher.assignFloorToLift(floorId, liftId);
  }
}

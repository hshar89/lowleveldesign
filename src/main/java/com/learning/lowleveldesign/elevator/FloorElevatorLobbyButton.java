package com.learning.lowleveldesign.elevator;

public class FloorElevatorLobbyButton implements Button<Direction>{

  private final Integer floorNum;
  private final Dispatcher dispatcher;

  public FloorElevatorLobbyButton(Integer floorNum, Dispatcher dispatcher) {
    this.floorNum = floorNum;
    this.dispatcher = dispatcher;
  }

  @Override
  public void performAction(Direction direction) {
    dispatcher.assignLiftToFloor(direction, floorNum);
  }
}

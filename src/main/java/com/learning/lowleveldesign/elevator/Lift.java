package com.learning.lowleveldesign.elevator;

import java.util.Comparator;
import java.util.TreeSet;

public class Lift {
  private final String liftId;
  private Integer currentFloorNumber;
  private Direction currentDirection;
  private TreeSet<Command> upDirectionQueue;
  private TreeSet<Command> downDirectionQueue;
  private Command currentCommandInExecution;
  private final Integer maxFloorNumber;
  private final Integer minFloorNumber;
  private boolean isLiftIdle;
  private final Integer maxLoad;
  private final Integer maxPassengers;
  private LiftCondition liftCondition;
  private final LiftDoor liftDoor;
  private final Button fanButton;
  private final Motor motor;
  private final Button alarmButton;

  public Lift(String liftId, Integer maxFloorNumber, Integer minFloorNumber,
              Integer maxLoad, Integer maxPassengers, LiftDoor liftDoor,
              Button fanButton, Motor motor, Button alarmButton) {
    this.liftId = liftId;
    this.maxFloorNumber = maxFloorNumber;
    this.minFloorNumber = minFloorNumber;
    this.maxLoad = maxLoad;
    this.maxPassengers = maxPassengers;
    this.liftDoor = liftDoor;
    this.fanButton = fanButton;
    this.motor = motor;
    this.alarmButton = alarmButton;
    this.upDirectionQueue = new TreeSet<>(Comparator.comparingInt(Command::getFloorNum));
    this.downDirectionQueue = new TreeSet<>((o1, o2) -> o2.getFloorNum() - o1.getFloorNum());
    this.liftCondition = LiftCondition.WORKING;
    this.currentDirection = Direction.UP;
    this.isLiftIdle = true;
    this.currentFloorNumber = minFloorNumber;
  }

  public void turnOnFan(boolean turnOn) {
    this.fanButton.performAction(turnOn);
  }

  public void setEmergencyAlarm(boolean turnOn) {
    this.alarmButton.performAction(turnOn);
  }

  public void assignFloorToLift(Integer floorNum) {
    if (floorNum < currentFloorNumber) {
      downDirectionQueue.add(new Command(floorNum));
      if(isLiftIdle){
        currentDirection = Direction.DOWN;
        isLiftIdle = false;
      }
    } else {
      upDirectionQueue.add(new Command(floorNum));
      if(isLiftIdle){
        currentDirection = Direction.UP;
        isLiftIdle = false;
      }
    }
    updateCurrentCommand();
  }

  public boolean selectFloor(int floorId) {
    if (floorId == currentFloorNumber) {
      if (!liftDoor.getLiftDoorStatus().equals(LiftDoorStatus.CLOSED) || isLiftIdle) {
        liftDoor.openDoor();
        return false;
      } else {
        if (currentDirection.equals(Direction.UP)) {
          downDirectionQueue.add(new Command(floorId));
        } else {
          upDirectionQueue.add(new Command(floorId));
        }
      }
    } else {
      if (floorId < currentFloorNumber) {
        downDirectionQueue.add(new Command(floorId));
      } else {
        upDirectionQueue.add(new Command(floorId));
      }
    }
    updateCurrentCommand();
    return true;
  }

  private void updateCurrentCommand() {
    if ((currentDirection.equals(Direction.UP) &&
        !currentCommandInExecution.getFloorNum().equals(upDirectionQueue.first().getFloorNum())) ||
        (currentDirection.equals(Direction.DOWN) &&
            !currentCommandInExecution.getFloorNum().equals(downDirectionQueue.first().getFloorNum()))) {
      if (currentDirection.equals(Direction.UP)) {
        currentCommandInExecution = upDirectionQueue.first();
        motor.setMotorRateUpDirection(currentCommandInExecution.getFloorNum() - currentFloorNumber);
      } else {
        currentCommandInExecution = downDirectionQueue.first();
        motor.setMotorRateDownDirection(currentFloorNumber - currentCommandInExecution.getFloorNum());
      }
    }
  }

  public boolean openDoor() {
    if (liftDoor.getLiftDoorStatus().equals(LiftDoorStatus.CLOSED)) {
      return false;
    }
    liftDoor.openDoor();
    return true;
  }

  public boolean closeDoor() {
    liftDoor.closeDoor();
    return true;
  }

  public String getLiftId() {
    return liftId;
  }

  public Integer getCurrentFloorNumber() {
    return currentFloorNumber;
  }

  public boolean isLiftIdle() {
    return isLiftIdle;
  }

  public boolean isDoorClosed() {
    return liftDoor.getLiftDoorStatus() == LiftDoorStatus.CLOSED;
  }

  public Direction getCurrentDirection() {
    return currentDirection;
  }

  public LiftCondition getLiftStatus() {
    return liftCondition;
  }

  private void stopLift() {
    motor.haltMotor();
    isLiftIdle = true;
    currentDirection = Direction.NONE;
  }

  public void updateCurrentFloorOfLift(int floorId) {
    this.currentFloorNumber = floorId;
    if (currentDirection.equals(Direction.DOWN) && downDirectionQueue.first().getFloorNum() == floorId) {
      downDirectionQueue.pollFirst();
      if (downDirectionQueue.isEmpty() && upDirectionQueue.isEmpty()) {
        stopLift();
      } else {
        this.currentDirection = Direction.UP;
        updateCurrentCommand();
      }
    } else if (currentDirection.equals(Direction.UP) && upDirectionQueue.first().getFloorNum() == floorId) {
      upDirectionQueue.pollFirst();
      if (downDirectionQueue.isEmpty() && upDirectionQueue.isEmpty()) {
        stopLift();
      } else {
        this.currentDirection = Direction.DOWN;
        updateCurrentCommand();
      }
    }
  }

}

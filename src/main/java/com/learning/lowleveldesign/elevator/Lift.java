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
  private LiftStatus liftStatus;
  private final LiftDoor liftDoor;
  private final Fan fan;
  private final Motor motor;
  private final Alarm alarm;

  public Lift(String liftId, Integer maxFloorNumber, Integer minFloorNumber,
              LiftDoor liftDoor, Fan fan, Motor motor, Alarm alarm) {
    this.liftId = liftId;
    this.maxFloorNumber = maxFloorNumber;
    this.minFloorNumber = minFloorNumber;
    this.liftDoor = liftDoor;
    this.fan = fan;
    this.motor = motor;
    this.alarm = alarm;
    this.upDirectionQueue = new TreeSet<>(Comparator.comparingInt(Command::getFloorNum));
    this.downDirectionQueue = new TreeSet<>((o1, o2) -> o2.getFloorNum() - o1.getFloorNum());
    this.liftStatus = LiftStatus.WORKING;
    this.currentDirection = Direction.UP;
    this.currentFloorNumber = minFloorNumber;
  }

  public void changeFanState(boolean turnOn) {
    if (turnOn) {
      fan.setFanStatus(FanStatus.ON);
    } else {
      fan.setFanStatus(FanStatus.OFF);
    }
  }

  public void emergencyAlarm(boolean turnOn) {
    if (turnOn) {
      alarm.turnOnAlarm();
    } else {
      alarm.turnOffAlarm();
    }
  }

  public boolean selectFloor(int floorId) {
    if (floorId > maxFloorNumber || floorId < minFloorNumber) {
      return false;
    }
    if (floorId == currentFloorNumber) {
      if (!liftDoor.getLiftDoorStatus().equals(LiftDoorStatus.CLOSED)) {
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
    if ((currentDirection.equals(Direction.UP) &&
        !currentCommandInExecution.getFloorNum().equals(upDirectionQueue.first().getFloorNum())) ||
        (currentDirection.equals(Direction.UP) &&
            !currentCommandInExecution.getFloorNum().equals(downDirectionQueue.first().getFloorNum()))) {
      updateCurrentCommand();
    }
    return true;
  }

  private void updateCurrentCommand() {
    if (currentDirection.equals(Direction.UP)) {
      currentCommandInExecution = upDirectionQueue.first();
      motor.setMotorRateUpDirection(currentCommandInExecution.getFloorNum() - currentFloorNumber);
    } else {
      currentCommandInExecution = downDirectionQueue.first();
      motor.setMotorRateDownDirection(currentFloorNumber - currentCommandInExecution.getFloorNum());
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

  public boolean isDoorClosed() {
    return liftDoor.getLiftDoorStatus() == LiftDoorStatus.CLOSED;
  }

  public Direction getCurrentDirection() {
    return currentDirection;
  }

  public LiftStatus getLiftStatus() {
    return liftStatus;
  }

  private void stopLift() {
    this.liftDoor.openDoor();
  }

  public void updateCurrentFloorOfLift(int floorId) {
    this.currentFloorNumber = floorId;
    if (currentDirection.equals(Direction.DOWN) && downDirectionQueue.first().getFloorNum() == floorId) {
      downDirectionQueue.pollFirst();
      if (downDirectionQueue.isEmpty() && upDirectionQueue.isEmpty()) {
        motor.haltMotor();
      } else {
        this.currentDirection = Direction.UP;
        updateCurrentCommand();
      }
    } else if (currentDirection.equals(Direction.UP) && upDirectionQueue.first().getFloorNum() == floorId) {
      upDirectionQueue.pollFirst();
      if (downDirectionQueue.isEmpty() && upDirectionQueue.isEmpty()) {
        motor.haltMotor();
      } else {
        this.currentDirection = Direction.DOWN;
        updateCurrentCommand();
      }
    }
    if (floorId == minFloorNumber) {
      currentDirection = Direction.UP;
    } else if (floorId == maxFloorNumber) {
      currentDirection = Direction.DOWN;
    }
  }

}

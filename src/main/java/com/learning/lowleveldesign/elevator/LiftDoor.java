package com.learning.lowleveldesign.elevator;

public class LiftDoor {
  private LiftDoorStatus liftDoorStatus;

  public LiftDoor(LiftDoorStatus liftDoorStatus) {
    this.liftDoorStatus = liftDoorStatus;
  }

  public void openDoor(){
    if(this.liftDoorStatus == LiftDoorStatus.OPEN){
      return;
    }
    liftDoorStatus = LiftDoorStatus.OPENING;
  }

  public void closeDoor(){
    if(this.liftDoorStatus == LiftDoorStatus.CLOSED){
      return;
    }
    liftDoorStatus = LiftDoorStatus.CLOSING;
  }

  public void setDoorClosed(){
    liftDoorStatus = LiftDoorStatus.CLOSED;
  }

  public void setDoorOpen(){
    liftDoorStatus = LiftDoorStatus.OPEN;
  }

  public LiftDoorStatus getLiftDoorStatus() {
    return liftDoorStatus;
  }
}

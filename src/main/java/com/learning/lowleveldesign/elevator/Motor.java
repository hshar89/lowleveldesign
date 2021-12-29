package com.learning.lowleveldesign.elevator;

public class Motor {
  private String motorId;
  private double rateOfPullPerMin;
  private MotorDirection motorDirection;

  public void setMotorRateUpDirection(int diffToTravel) {

  }

  public void setMotorRateDownDirection(int diffToTravel) {

  }

  public void haltMotor(){

  }


  private enum MotorDirection{
    CLOCKWISE, ANTICLOCKWISE;
  }
}


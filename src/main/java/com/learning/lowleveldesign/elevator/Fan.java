package com.learning.lowleveldesign.elevator;

public class Fan {
  private Integer fanId;
  private FanStatus fanStatus;

  public void turnOnFan(){
    this.fanStatus = FanStatus.ON;
  }

  public void turnOffFan(){
    this.fanStatus = FanStatus.OFF;
  }

}

package com.learning.lowleveldesign.elevator;

public class FanButton implements Button<Boolean>{

  private final Fan fan;
  private final String liftId;

  public FanButton(Fan fan, String liftId) {
    this.fan = fan;
    this.liftId = liftId;
  }

  @Override
  public void performAction(Boolean turnOnFan) {
    if(turnOnFan){
      this.fan.turnOnFan();
    }else{
      this.fan.turnOffFan();
    }
  }
}

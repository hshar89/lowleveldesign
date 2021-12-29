package com.learning.lowleveldesign.elevator;

public class EmergencyAlarmButton implements Button<Boolean>{
  private final String liftId;
  private final Alarm alarm;

  public EmergencyAlarmButton(String liftId, Alarm alarm) {
    this.liftId = liftId;
    this.alarm = alarm;
  }

  @Override
  public void performAction(Boolean turnOn) {
    if(turnOn){
      alarm.turnOnAlarm();
    }else{
      alarm.turnOffAlarm();
    }
  }
}

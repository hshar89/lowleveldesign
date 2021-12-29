package com.learning.lowleveldesign.elevator;

public class Alarm {
  private final Integer alarmId;
  private AlarmStatus alarmStatus;

  public Alarm(Integer alarmId) {
    this.alarmId = alarmId;
  }

  public void turnOnAlarm(){
    alarmStatus = AlarmStatus.ON;
  }

  public void turnOffAlarm(){
    alarmStatus = AlarmStatus.OFF;
  }
}

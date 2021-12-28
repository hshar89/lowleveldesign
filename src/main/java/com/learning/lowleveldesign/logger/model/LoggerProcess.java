package com.learning.lowleveldesign.logger.model;

public class LoggerProcess {
  private String processId;
  private long startTime;
  private long endTime;

  public LoggerProcess(String processId, long startTime) {
    this.processId = processId;
    this.startTime = startTime;
    this.endTime = -1;
  }

  public void setEndTime(long endTime) {
    this.endTime = endTime;
  }

  public String getProcessId() {
    return processId;
  }

  public long getStartTime() {
    return startTime;
  }

  public long getEndTime() {
    return endTime;
  }
}

package com.learning.lowleveldesign.logger.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import com.learning.lowleveldesign.logger.contract.Logger;
import com.learning.lowleveldesign.logger.model.LoggerProcess;

public class LoggerImpl implements Logger {

  private final Map<String, LoggerProcess> processMap;
  private final Queue<String> processQueue;

  public LoggerImpl() {
    this.processQueue = new LinkedList<>();
    this.processMap = new HashMap<>();
  }

  @Override
  public void start(String processId) {
    LoggerProcess process = new LoggerProcess(processId, System.currentTimeMillis());
    processMap.put(processId, process);
    processQueue.add(processId);
  }

  @Override
  public void end(String processId) {
    processMap.get(processId).setEndTime(System.currentTimeMillis());
  }

  @Override
  public void poll() {
    if (processQueue.isEmpty()) {
      System.out.println("Queue is empty..");
      return;
    }
    if (processMap.get(processQueue.peek()).getEndTime() != -1) {
      LoggerProcess loggerProcess = processMap.get(processQueue.peek());
      System.out.println(
          "Process " + loggerProcess.getProcessId() + " started at " + loggerProcess.getStartTime() + " ended at " +
              loggerProcess.getEndTime());
      processQueue.poll();
      processMap.remove(loggerProcess.getProcessId());
    } else {
      System.out.println("No process has ended. "+processQueue.size());
    }
  }
}

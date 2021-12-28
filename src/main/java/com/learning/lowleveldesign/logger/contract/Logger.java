package com.learning.lowleveldesign.logger.contract;

public interface Logger {
  void start(String processId);
  void end(String processId);
  void poll();
}

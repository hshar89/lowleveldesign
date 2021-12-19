package com.learning.lowleveldesign.cricbuzz.contract;

public interface StatCalculator<R> {
  double calculateStats(R request);
}

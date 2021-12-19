package com.learning.lowleveldesign.cricbuzz.impl;

import com.learning.lowleveldesign.cricbuzz.contract.StatCalculator;
import com.learning.lowleveldesign.cricbuzz.service.RunService;

public class TotalRunCalculator implements StatCalculator<Integer> {

  private RunService runService;

  @Override
  public double calculateStats(Integer playerId) {
    return runService.getRunsScoredByPlayer(playerId).stream().map(run -> run.getRunValue()).reduce(0, Integer::sum);
  }
}

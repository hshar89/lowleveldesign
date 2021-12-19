package com.learning.lowleveldesign.cricbuzz.service;

import com.learning.lowleveldesign.cricbuzz.contract.StatService;
import com.learning.lowleveldesign.cricbuzz.factory.StatFactory;
import com.learning.lowleveldesign.cricbuzz.model.PlayerStatRequest;
import com.learning.lowleveldesign.cricbuzz.model.PlayerStatResponse;

public class PlayerStatService implements StatService<PlayerStatResponse, PlayerStatRequest> {

  @Override
  public PlayerStatResponse getStats(PlayerStatRequest playerStatRequest) {
    StatFactory.getInstance().getStatCalculator(playerStatRequest.getStatType()).calculateStats(playerStatRequest.getPlayerId());
    return null;
  }
}

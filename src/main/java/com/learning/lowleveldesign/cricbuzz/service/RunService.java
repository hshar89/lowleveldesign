package com.learning.lowleveldesign.cricbuzz.service;

import java.util.List;

import com.learning.lowleveldesign.cricbuzz.model.Run;
import com.learning.lowleveldesign.cricbuzz.repo.RunRepo;

public class RunService {
  RunRepo runRepo;

  public List<Run> getRunsByScoreAndMatchId(int score, List<String> ballIds) {
    return runRepo.getRunsByScoreAndBalls(score, ballIds);
  }
  public List<Run> getRunsScoredByPlayer(int playerId){
    return runRepo.getRunsByPlayerId(playerId);
  }
}

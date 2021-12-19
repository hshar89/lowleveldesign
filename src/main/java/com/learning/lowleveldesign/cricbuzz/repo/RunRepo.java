package com.learning.lowleveldesign.cricbuzz.repo;

import java.util.List;

import com.learning.lowleveldesign.cricbuzz.model.Run;

public interface RunRepo {
  boolean saveRun(Run run);

  Run getRunForBall(String ballId);

  List<Run> getRunsByScoreAndBalls(int score, List<String> ballIds);

  List<Run> getRunsByPlayerId(int playerId);
}

package com.learning.lowleveldesign.cricbuzz.repo;

import java.util.List;

import com.learning.lowleveldesign.cricbuzz.model.Ball;

public interface BallRepo {
  boolean saveBall(Ball ball);
  Ball getBall(int ballId);
  List<Ball> getAllBallsForAnOver(int overId, int matchId);
  List<Ball> getBallsForAMatch(int matchId);
}

package com.learning.lowleveldesign.cricbuzz.service;

import java.util.List;
import java.util.stream.Collectors;

import com.learning.lowleveldesign.cricbuzz.model.Ball;
import com.learning.lowleveldesign.cricbuzz.model.Commentary;
import com.learning.lowleveldesign.cricbuzz.repo.BallRepo;
import com.learning.lowleveldesign.cricbuzz.repo.CommentaryRepo;
import com.learning.lowleveldesign.cricbuzz.repo.OverRepo;

public class OverService {
  OverRepo overRepo;
  BallRepo ballRepo;
  CommentaryRepo commentaryRepo;

  public List<Ball> getAllBallsInAnOver(int overId, int matchId) {
    return ballRepo.getAllBallsForAnOver(overId, matchId);
  }

  public List<Commentary> getAllCommentatriesForAnOver(int overId, int matchId) {
    List<Ball> balls = ballRepo.getAllBallsForAnOver(overId, matchId);
    List<Commentary> commentaries = commentaryRepo.getCommentaryInBulk(balls.stream().map(ball->ball.getBallNumber()).collect(
        Collectors.toList()));
    return commentaries;
  }

}

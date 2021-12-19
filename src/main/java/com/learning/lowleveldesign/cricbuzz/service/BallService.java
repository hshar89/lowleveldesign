package com.learning.lowleveldesign.cricbuzz.service;

import com.learning.lowleveldesign.cricbuzz.model.Ball;
import com.learning.lowleveldesign.cricbuzz.model.Commentary;
import com.learning.lowleveldesign.cricbuzz.repo.BallRepo;
import com.learning.lowleveldesign.cricbuzz.repo.CommentaryRepo;

public class BallService {
  private BallRepo ballRepo;
  private CommentaryRepo commentaryRepo;
  public Commentary getCommentaryPerBall(String ballId){
    return commentaryRepo.getCommentaryForBall(ballId);
  }
  public Ball getLatestBallOfAMatch(int matchId){
    return ballRepo.getBallsForAMatch(matchId).get(0);
  }

}

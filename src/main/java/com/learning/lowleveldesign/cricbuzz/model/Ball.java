package com.learning.lowleveldesign.cricbuzz.model;

public class Ball {
  String ballId;
  Inning inning;
  int ballNumber;
  BallType ballType;
  int bolwerId;
  int batsmenId;
  long ballDeliveredAtTime;
  String overId;
  int overNumber;
  int matchId;

  public Ball(Inning inning, int ballNumber, int bolwerId, int batsmenId, int overNumber, int matchId, String overId) {
    this.inning = inning;
    this.ballNumber = ballNumber;
    this.bolwerId = bolwerId;
    this.batsmenId = batsmenId;
    this.ballDeliveredAtTime = System.currentTimeMillis();
    this.overNumber = overNumber;
    this.matchId = matchId;
    this.overId = overId;
    this.ballId = generateId(inning, ballNumber, overNumber, matchId);
  }

  public int getBallNumber() {
    return ballNumber;
  }

  public String getBallId() {
    return ballId;
  }

  private String generateId(Inning inning, int ballNumber, int overId, int matchId) {
    return inning.getInningValue() + "-" + ballNumber + "-" + overId + "-" + matchId;
  }

}

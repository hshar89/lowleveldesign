package com.learning.lowleveldesign.cricbuzz.model;

public class Over {
  int overNumber;
  int matchId;
  String overId;
  int bowledById;

  public Over(int overNumber, int matchId, int bowledById) {
    this.overNumber = overNumber;
    this.matchId = matchId;
    this.bowledById = bowledById;
    this.overId = generateOverId(overNumber, matchId);
  }

  private String generateOverId(int overNumber, int matchId) {
    return overNumber+"-"+matchId;
  }
}

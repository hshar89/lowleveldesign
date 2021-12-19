package com.learning.lowleveldesign.cricbuzz.model;

public class Wicket {
  String wicketId;
  Inning inning;
  int wicketNumber;
  int matchId;
  int bowlerId;
  int batsmenId;
  String ballId;
  WicketType wicketType;

  public Wicket(Inning inning, int wicketNumber, int matchId, int bowlerId, int batsmenId, String ballId,
                WicketType wicketType) {
    this.inning = inning;
    this.wicketNumber = wicketNumber;
    this.matchId = matchId;
    this.bowlerId = bowlerId;
    this.batsmenId = batsmenId;
    this.ballId = ballId;
    this.wicketType = wicketType;
    this.wicketId = generateWicketId(inning, wicketNumber, matchId);
  }

  private String generateWicketId(Inning inning, int wicketNumber, int matchId) {
    return inning.getInningValue()+"-"+wicketNumber + "-" + matchId;
  }
}

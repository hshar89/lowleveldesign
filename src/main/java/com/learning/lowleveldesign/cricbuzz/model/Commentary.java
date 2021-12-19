package com.learning.lowleveldesign.cricbuzz.model;

public class Commentary {
  String commentaryId;
  int commentatorId;
  int matchId;
  Inning inning;
  String commentary;
  String ballId;

  public Commentary(int commentatorId, Inning inning, String ballId, int matchId, String commentary) {
    this.commentatorId = commentatorId;
    this.inning = inning;
    this.ballId = ballId;
    this.matchId = matchId;
    this.commentaryId = getCommentaryId(ballId);
    this.commentary = commentary;
  }



  private String getCommentaryId(String ballId) {
    return ballId+"_C";
  }
}

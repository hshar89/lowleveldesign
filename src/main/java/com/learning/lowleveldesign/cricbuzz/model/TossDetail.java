package com.learning.lowleveldesign.cricbuzz.model;

public class TossDetail {
  int tossId;
  int matchId;
  int tossWinTeamId;
  int tossLoseTeamId;
  int battingTeamIdFirstInning;
  int battingTeamIdSecondInnning;

  public int getTossId() {
    return tossId;
  }

  public int getMatchId() {
    return matchId;
  }

  public int getTossWinTeamId() {
    return tossWinTeamId;
  }

  public int getTossLoseTeamId() {
    return tossLoseTeamId;
  }

  public int getBattingTeamIdFirstInning() {
    return battingTeamIdFirstInning;
  }

  public int getBattingTeamIdSecondInning() {
    return battingTeamIdSecondInnning;
  }
}

package com.learning.lowleveldesign.cricbuzz.model;

public class Match {
  int teamAId;
  int teamBId;
  int teamThatWonId;
  int stadiumId;
  int tournamentId;
  TournamentType tournamentType;
  MatchStatus matchStatus;

  public Match(int teamAId, int teamBId, int stadiumId, int tournamentId,
               TournamentType tournamentType, MatchStatus matchStatus) {
    this.teamAId = teamAId;
    this.teamBId = teamBId;
    this.stadiumId = stadiumId;
    this.tournamentId = tournamentId;
    this.tournamentType = tournamentType;
    this.matchStatus = matchStatus;
  }

  public void setTeamThatWonId(int teamThatWonId) {
    this.teamThatWonId = teamThatWonId;
  }

  public void setMatchStatus(MatchStatus matchStatus) {
    this.matchStatus = matchStatus;
  }

  public int getStadiumId() {
    return stadiumId;
  }

  public int getTournamentId() {
    return tournamentId;
  }

  public int getTeamAId() {
    return teamAId;
  }

  public int getTeamBId() {
    return teamBId;
  }
}

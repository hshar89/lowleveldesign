package com.learning.lowleveldesign.cricbuzz.model;

import java.util.Date;

public class Tournament {
  int tournamentId;
  String name;
  Date startDate;
  Date endDate;
  TournamentType tournamentType;

  public Tournament(String name, Date startDate, Date endDate, TournamentType tournamentType) {
    this.name = name;
    this.startDate = startDate;
    this.endDate = endDate;
    this.tournamentType = tournamentType;
  }

  public int getTournamentId() {
    return tournamentId;
  }

  public void setTournamentId(int tournamentId) {
    this.tournamentId = tournamentId;
  }

  public String getName() {
    return name;
  }
}

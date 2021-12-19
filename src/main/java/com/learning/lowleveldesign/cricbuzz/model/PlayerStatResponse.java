package com.learning.lowleveldesign.cricbuzz.model;

import java.util.List;

public class PlayerStatResponse {
  int playerId;
  List<PlayerStatDetail> playerStatDetails;

  public static class PlayerStatDetail{
    TournamentType tournamentType;
    StatType statType;
    double value;
  }
}

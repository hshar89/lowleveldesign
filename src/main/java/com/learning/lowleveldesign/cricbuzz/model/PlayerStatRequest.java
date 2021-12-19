package com.learning.lowleveldesign.cricbuzz.model;

import java.util.ArrayList;
import java.util.List;

public class PlayerStatRequest {
  private int playerId;
  private int matchId;
  private boolean perMatch;
  private List<TournamentType> tournamentTypes;
  private StatType statType;
  private SummaryCategory summaryCategory;

  public PlayerStatRequest(int playerId, int matchId, List<TournamentType> tournamentTypes,
                           StatType statType, SummaryCategory summaryCategory, boolean perMatch) {
    this.playerId = playerId;
    this.matchId = matchId;
    this.tournamentTypes = tournamentTypes;
    this.statType = statType;
    this.summaryCategory = summaryCategory;
    this.perMatch = perMatch;
  }

  public int getPlayerId() {
    return playerId;
  }

  public int getMatchId() {
    return matchId;
  }

  public boolean isPerMatch() {
    return perMatch;
  }

  public List<TournamentType> getTournamentTypes() {
    return tournamentTypes;
  }

  public StatType getStatType() {
    return statType;
  }

  public SummaryCategory getSummaryCategory() {
    return summaryCategory;
  }

  public class PlayerStatRequestBuilder{
    private int playerId;
    private int matchId;
    private List<TournamentType> tournamentTypes;
    private StatType statType;
    private SummaryCategory summaryCategory;
    private boolean perMatch;

    public PlayerStatRequestBuilder(int playerId, StatType statType, SummaryCategory summaryCategory){
      this.playerId = playerId;
      this.statType = statType;
      this.summaryCategory = summaryCategory;
      this.tournamentTypes = new ArrayList<>();
    }

    public PlayerStatRequestBuilder setMatchId(int matchId) {
      this.matchId = matchId;
      return this;
    }

    public PlayerStatRequestBuilder addTournamentType(TournamentType tournamentType) {
      this.tournamentTypes.add(tournamentType);
      return this;
    }

    public PlayerStatRequestBuilder setPerMatch(boolean perMatch) {
      this.perMatch = perMatch;
      return this;
    }

    public PlayerStatRequest build(){
      return new PlayerStatRequest(this.playerId, this.matchId, this.tournamentTypes, this.statType, this.summaryCategory, this.perMatch);
    }
  }
}

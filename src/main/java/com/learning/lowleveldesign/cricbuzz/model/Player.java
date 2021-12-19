package com.learning.lowleveldesign.cricbuzz.model;

import java.util.Date;

public class Player extends Person{
  int playerId;
  Date birthDate;
  float hieght;
  PlayerRole playerRole;
  BattingStyle battingStyle;

  public Player(Date birthDate, float hieght, PlayerRole playerRole,
                BattingStyle battingStyle) {
    this.birthDate = birthDate;
    this.hieght = hieght;
    this.playerRole = playerRole;
    this.battingStyle = battingStyle;
  }

  public int getPlayerId() {
    return playerId;
  }

  public void setPlayerId(int playerId) {
    this.playerId = playerId;
  }
}

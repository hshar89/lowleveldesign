package com.learning.lowleveldesign.chess;

import org.apache.commons.lang3.tuple.Pair;

public class StraightMove extends Move {
  private Integer amount;
  private Direction direction;

  public StraightMove(String playerId, Integer pieceId, Integer amount, Direction direction) {
    super(playerId, pieceId);
    this.amount = amount;
    this.direction = direction;
  }

  public Pair<Integer, Integer> getNextCoordinates(int row, int col) {
    return null;
  }
}

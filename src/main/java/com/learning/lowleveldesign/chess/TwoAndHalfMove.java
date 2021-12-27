package com.learning.lowleveldesign.chess;

import org.apache.commons.lang3.tuple.Pair;

public class TwoAndHalfMove extends Move{

  private Direction direction;

  public TwoAndHalfMove(String playerId, Integer pieceId, Direction direction) {
    super(playerId, pieceId);
    this.direction = direction;
  }

  public Direction getDirection() {
    return direction;
  }

  @Override
  public Pair<Integer, Integer> getNextCoordinates(int row, int col) {
    return null;
  }
}

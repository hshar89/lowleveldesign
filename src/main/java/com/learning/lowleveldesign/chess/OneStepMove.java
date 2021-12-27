package com.learning.lowleveldesign.chess;

import org.apache.commons.lang3.tuple.Pair;

public class OneStepMove extends Move{

  private Direction direction;

  public OneStepMove(String playerId, Integer pieceId, Direction direction) {
    super(playerId, pieceId);
    this.direction = direction;
  }

  @Override
  public Pair<Integer, Integer> getNextCoordinates(int row, int col) {
    return null;
  }
}

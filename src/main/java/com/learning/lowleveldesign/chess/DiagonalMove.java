package com.learning.lowleveldesign.chess;

import org.apache.commons.lang3.tuple.Pair;

public class DiagonalMove extends Move{

  private Integer amount;
  private Direction direction;

  public DiagonalMove(Integer amount, Direction direction) {
    this.amount = amount;
    this.direction = direction;
  }

  @Override
  public Pair<Integer, Integer> getNextCoordinates(int row, int col) {
    return null;
  }
}

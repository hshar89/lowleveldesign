package com.learning.lowleveldesign.chess;

import org.apache.commons.lang3.tuple.Pair;

public class StraightMove extends Move{
  private Integer amount;
  private Direction direction;

  public StraightMove(Integer amount, Direction direction){
    this.amount = amount;
    this.direction = direction;
  }

  public Pair<Integer, Integer> getNextCoordinates(int row, int col){
    return null;
  }
}

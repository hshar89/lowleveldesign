package com.learning.lowleveldesign.chess;

import org.apache.commons.lang3.tuple.Pair;

public abstract class Move {
  public abstract Pair<Integer, Integer> getNextCoordinates(int row, int col);
}

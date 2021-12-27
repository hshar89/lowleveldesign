package com.learning.lowleveldesign.chess;

import org.apache.commons.lang3.tuple.Pair;

public abstract class Move {
  protected String playerId;
  protected Integer pieceId;
  protected Integer killedPieceId;
  private Pair<Integer, Integer> fromPosition;
  private Pair<Integer, Integer> toPosition;

  public Move(String playerId, Integer pieceId) {
    this.playerId = playerId;
    this.pieceId = pieceId;
    this.killedPieceId = killedPieceId;
  }

  public void setKilledPieceId(Integer killedPieceId){
    this.killedPieceId = killedPieceId;
  }

  public void setFromPosition(Pair<Integer, Integer> fromPosition) {
    this.fromPosition = fromPosition;
  }

  public void setToPosition(Pair<Integer, Integer> toPosition) {
    this.toPosition = toPosition;
  }

  public abstract Pair<Integer, Integer> getNextCoordinates(int row, int col);
}

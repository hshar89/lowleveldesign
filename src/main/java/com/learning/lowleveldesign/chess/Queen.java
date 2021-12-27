package com.learning.lowleveldesign.chess;

import org.apache.commons.lang3.tuple.Pair;

public class Queen extends ChessPiece{

  public Queen(int pieceId, PieceColor pieceColor,
               Pair<Integer, Integer> currentPosition, boolean isCheckMatePiece) {
    super(pieceId, pieceColor, currentPosition, isCheckMatePiece);
  }

  @Override
  public boolean isValidMove(Move move) {
    return false;
  }
}

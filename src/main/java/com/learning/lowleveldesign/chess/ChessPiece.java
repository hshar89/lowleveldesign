package com.learning.lowleveldesign.chess;

import org.apache.commons.lang3.tuple.Pair;

public abstract class ChessPiece {
  private int pieceId;
  private PieceColor pieceColor;
  private Pair<Integer, Integer> currentPosition;
  private boolean isCheckMatePiece;
  private PieceStatus pieceStatus;

  public ChessPiece(int pieceId, PieceColor pieceColor, Pair<Integer, Integer> currentPosition,
                    boolean isCheckMatePiece) {
    this.pieceId = pieceId;
    this.pieceColor = pieceColor;
    this.currentPosition = currentPosition;
    this.isCheckMatePiece = isCheckMatePiece;
    this.pieceStatus = PieceStatus.ACTIVE;
  }

  public int getPieceId() {
    return pieceId;
  }

  public PieceStatus getPieceStatus() {
    return pieceStatus;
  }

  public void setPieceStatus(PieceStatus pieceStatus) {
    this.pieceStatus = pieceStatus;
  }

  public PieceColor getPieceColor() {
    return pieceColor;
  }

  public boolean isCheckMatePiece() {
    return isCheckMatePiece;
  }

  public abstract boolean isValidMove(Move move);

  public Pair<Integer, Integer> getCurrentLocation() {
    return currentPosition;
  }

  public void updateLocation(Pair<Integer, Integer> currentPosition) {
    this.currentPosition = currentPosition;
  }
}

package com.learning.lowleveldesign.chess;

import java.util.List;
import java.util.UUID;

public class Player {
  private String playerId;
  private boolean isAnonymousUser;
  private boolean isRobot;
  private PieceColor pieceColor;
  private List<ChessPiece> chessPieces;
  private long timeLeft;
  private Match match;

  public Player(boolean isAnonymousUser, boolean isRobot,
                PieceColor pieceColor, Match match) {
    this.playerId = UUID.randomUUID().toString();
    this.isAnonymousUser = isAnonymousUser;
    this.isRobot = isRobot;
    this.match = match;
    this.pieceColor = pieceColor;
  }

  public String getPlayerId() {
    return playerId;
  }

  public boolean isAnonymousUser() {
    return isAnonymousUser;
  }

  public boolean isRobot() {
    return isRobot;
  }

  public PieceColor getPieceColor() {
    return pieceColor;
  }

  public List<ChessPiece> getChessPieces() {
    return match.getChessPiecesForPlayer(pieceColor);
  }

  public boolean makeMove(ChessPiece chessPiece, Move move) {
    return match.makeMove(chessPiece, move, playerId);
  }

  public boolean cancelMatch() {
    return match.cancelMatch();
  }
}

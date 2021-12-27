package com.learning.lowleveldesign.chess;

import java.util.Date;

public class Match {
  private String matchId;
  private String playerOneId;
  private String playerTwoId;
  private Date createdDate;
  private String winnerId;
  private MatchStatus matchStatus;
  private ChessBoard chessBoard;

  public Match(String playerOneId, String playerTwoId, ChessBoard chessBoard) {
    this.playerOneId = playerOneId;
    this.playerTwoId = playerTwoId;
    this.chessBoard = chessBoard;
    this.matchStatus = MatchStatus.INPROGRESS;
  }

  public boolean isMatchComplete(){
    return chessBoard.isDeciderPieceDown();
  }

  public PieceColor getWinnerPiece(){
    return chessBoard.getMatchWinner();
  }

  public boolean cancelMatch() {
    this.matchStatus = MatchStatus.CANCELLED;
    return true;
  }

  public MatchStatus getMatchStatus() {
    return matchStatus;
  }
}

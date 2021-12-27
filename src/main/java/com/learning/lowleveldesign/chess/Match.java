package com.learning.lowleveldesign.chess;

import java.util.Date;
import java.util.List;

public class Match {
  private String matchId;
  private String playerOneId;
  private String playerTwoId;
  private Date createdDate;
  private long matchEndTime;
  private long pauseStartTime;
  private String winnerId;
  String currentPlayerId;
  private MatchStatus matchStatus;
  private ChessBoard chessBoard;

  public Match(String playerOneId, String playerTwoId, ChessBoard chessBoard) {
    this.playerOneId = playerOneId;
    this.playerTwoId = playerTwoId;
    this.chessBoard = chessBoard;
    this.matchStatus = MatchStatus.INPROGRESS;
    this.matchEndTime = System.currentTimeMillis()+2000000;
    this.currentPlayerId = playerOneId;
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

  private void setMatchStatus(MatchStatus matchStatus){
    this.matchStatus = matchStatus;
  }

  public MatchStatus getMatchStatus() {
    return matchStatus;
  }

  public void pauseGame(){
    this.matchStatus = MatchStatus.PAUSED;
    this.pauseStartTime = System.currentTimeMillis();
  }

  public void resumeGame(){
    this.matchStatus = MatchStatus.INPROGRESS;
    this.matchEndTime += (System.currentTimeMillis()-pauseStartTime);
  }

  public String getCurrentPlayerId(){
    return this.currentPlayerId;
  }

  private void changeTurn(){
    if(currentPlayerId.equals(playerOneId)){
      this.currentPlayerId = playerTwoId;
    }else{
      this.currentPlayerId = playerOneId;
    }
  }

  private boolean checkMatchEndTime(){
    return System.currentTimeMillis()<=matchEndTime;
  }

  public List<ChessPiece> getChessPiecesForPlayer(PieceColor pieceColor) {
    return chessBoard.getChessPieces(pieceColor);
  }

  public boolean makeMove(ChessPiece chessPiece, Move move, String playerId) {
    if(!checkMatchEndTime()){
      setMatchStatus(MatchStatus.OVER);
      return false;
    }
    boolean moveMade = chessBoard.makeMove(chessPiece, move);
    if(!moveMade){
      return false;
    }
    changeTurn();
    return true;
  }
}

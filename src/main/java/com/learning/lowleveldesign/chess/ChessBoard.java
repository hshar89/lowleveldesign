package com.learning.lowleveldesign.chess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.tuple.Pair;

public class ChessBoard {
  private String boardId;
  private String matchId;
  private Map<PieceColor, Boolean> deciderPieceStatus;
  private BoardSquare[][] boardSquares;
  private Map<PieceColor, List<ChessPiece>> piecesMap;
  private Integer idGenerator;

  public ChessBoard(String matchId) {
    this.matchId = matchId;
    this.boardSquares = new BoardSquare[8][8];
    this.piecesMap = new HashMap<>();
    this.idGenerator = 1;
    this.piecesMap.put(PieceColor.BLACK, generatePieces(PieceColor.BLACK));
    this.piecesMap.put(PieceColor.WHITE, generatePieces(PieceColor.WHITE));
    this.deciderPieceStatus = new HashMap<>();
    deciderPieceStatus.put(PieceColor.WHITE, true);
    deciderPieceStatus.put(PieceColor.BLACK, true);
    Horse.initialIzeInstanceWithMatch(matchId);
    King.initialIzeInstanceWithMatch(matchId);
  }

  private List<ChessPiece> generatePieces(PieceColor pieceColor) {
    ChessPiece horse1 = Horse.getInstance(idGenerator++, matchId, pieceColor);
    Pair<Integer, Integer> position = horse1.getCurrentLocation();
    BoardSquare boardSquare = new BoardSquare(position.getKey(), position.getValue(), horse1);
    boardSquares[position.getKey()][position.getValue()] = boardSquare;
    ChessPiece horse2 = Horse.getInstance(idGenerator++, matchId, pieceColor);
    position = horse2.getCurrentLocation();
    boardSquare = new BoardSquare(position.getKey(), position.getValue(), horse1);
    boardSquares[position.getKey()][position.getValue()] = boardSquare;
    List<ChessPiece> chessPieces = new ArrayList<>();
    chessPieces.add(horse1);
    chessPieces.add(horse2);
    return chessPieces;
  }

  public List<ChessPiece> getChessPieces(PieceColor pieceColor) {
    return piecesMap.get(pieceColor);
  }

  public boolean makeMove(ChessPiece chessPiece, Move move) {
    if (!chessPiece.isValidMove(move)) {
      return false;
    }
    Pair<Integer, Integer> currentCoordinates = chessPiece.getCurrentLocation();
    BoardSquare boardSquare = boardSquares[currentCoordinates.getKey()][currentCoordinates.getValue()];
    Pair<Integer, Integer> nextCoordinate =
        move.getNextCoordinates(currentCoordinates.getKey(), currentCoordinates.getValue());
    if (validatePosition(nextCoordinate, chessPiece.getPieceColor())) {
      return false;
    }
    ChessPiece otherPiece = boardSquares[nextCoordinate.getKey()][nextCoordinate.getValue()].getChessPiece();
    if (otherPiece != null) {
      otherPiece.setPieceStatus(PieceStatus.REMOVED);
      if(otherPiece.isCheckMatePiece()){
        deciderPieceStatus.put(otherPiece.getPieceColor(), false);
      }
    }
    boardSquares[nextCoordinate.getKey()][nextCoordinate.getValue()] = boardSquare;
    return true;
  }

  private boolean validatePosition(Pair<Integer, Integer> nextCoordinate, PieceColor pieceColor) {
    if (nextCoordinate.getKey() < 0 || nextCoordinate.getKey() > 7 || nextCoordinate.getValue() < 0 ||
        nextCoordinate.getValue() > 7) {
      return false;
    }
    if (boardSquares[nextCoordinate.getKey()][nextCoordinate.getValue()].getChessPiece().getPieceColor() ==
        pieceColor) {
      return false;
    }
    return true;
  }

  public boolean isDeciderPieceDown(){
    if(deciderPieceStatus.get(PieceColor.WHITE)==false || deciderPieceStatus.get(PieceColor.BLACK)==false){
      return true;
    }
    return false;
  }

  public PieceColor getMatchWinner(){
    if(deciderPieceStatus.get(PieceColor.WHITE) == true && deciderPieceStatus.get(PieceColor.BLACK)==true){
      return null;
    }
    if(deciderPieceStatus.get(PieceColor.BLACK)==false){
      return PieceColor.BLACK;
    }else{
      return PieceColor.WHITE;
    }
  }
}

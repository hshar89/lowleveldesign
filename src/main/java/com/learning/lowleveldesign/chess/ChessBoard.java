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
  private Cell[][] cells;
  private Map<PieceColor, List<ChessPiece>> piecesMap;
  private List<Move> moveHistory;
  private Integer idGenerator;

  public ChessBoard(String matchId) {
    this.matchId = matchId;
    this.moveHistory = new ArrayList<>();
    this.cells = new Cell[8][8];
    this.piecesMap = new HashMap<>();
    this.idGenerator = 1;
    this.piecesMap.put(PieceColor.BLACK, generatePieces(PieceColor.BLACK));
    this.piecesMap.put(PieceColor.WHITE, generatePieces(PieceColor.WHITE));
    this.deciderPieceStatus = new HashMap<>();
    deciderPieceStatus.put(PieceColor.WHITE, true);
    deciderPieceStatus.put(PieceColor.BLACK, true);
    Knight.initialIzeInstanceWithMatch(matchId);
    King.initialIzeInstanceWithMatch(matchId);
  }

  private List<ChessPiece> generatePieces(PieceColor pieceColor) {
    List<ChessPiece> chessPieces = new ArrayList<>();
    ChessPiece horse1 = Knight.getInstance(idGenerator++, matchId, pieceColor);
    Pair<Integer, Integer> position = horse1.getCurrentLocation();
    Cell cell1 = new Cell(position.getKey(), position.getValue(), horse1);
    cells[position.getKey()][position.getValue()] = cell1;
    ChessPiece horse2 = Knight.getInstance(idGenerator++, matchId, pieceColor);
    position = horse2.getCurrentLocation();
    Cell cell2 = new Cell(position.getKey(), position.getValue(), horse1);
    cells[position.getKey()][position.getValue()] = cell2;
    chessPieces.add(horse1);
    chessPieces.add(horse2);
    ChessPiece king1 = King.getInstance(idGenerator++, matchId, pieceColor);
    position = king1.getCurrentLocation();
    Cell cell3 = new Cell(position.getKey(), position.getValue(), king1);
    cells[position.getKey()][position.getValue()] = cell3;
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
    Cell cell = cells[currentCoordinates.getKey()][currentCoordinates.getValue()];
    Pair<Integer, Integer> nextCoordinates =
        move.getNextCoordinates(currentCoordinates.getKey(), currentCoordinates.getValue());
    if (validatePosition(nextCoordinates, chessPiece.getPieceColor())) {
      return false;
    }
    this.moveHistory.add(move);
    ChessPiece otherPiece = cells[nextCoordinates.getKey()][nextCoordinates.getValue()].getChessPiece();
    if (otherPiece != null) {
      otherPiece.setPieceStatus(PieceStatus.REMOVED);
      move.setKilledPieceId(otherPiece.getPieceId());
      if(otherPiece.isCheckMatePiece()){
        deciderPieceStatus.put(otherPiece.getPieceColor(), false);
      }
    }
    move.setFromPosition(currentCoordinates);
    move.setToPosition(nextCoordinates);
    cells[nextCoordinates.getKey()][nextCoordinates.getValue()] = cell;
    return true;
  }

  private boolean validatePosition(Pair<Integer, Integer> nextCoordinate, PieceColor pieceColor) {
    if (nextCoordinate.getKey() < 0 || nextCoordinate.getKey() > 7 || nextCoordinate.getValue() < 0 ||
        nextCoordinate.getValue() > 7) {
      return false;
    }
    if (cells[nextCoordinate.getKey()][nextCoordinate.getValue()].getChessPiece().getPieceColor() ==
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

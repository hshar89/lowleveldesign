package com.learning.lowleveldesign.chess;

public class BoardSquare {
  private int rowNum;
  private int colNum;
  private ChessPiece chessPiece;

  public BoardSquare(int rowNum, int colNum, ChessPiece chessPiece) {
    this.rowNum = rowNum;
    this.colNum = colNum;
    this.chessPiece = chessPiece;
  }

  public int getRowNum() {
    return rowNum;
  }

  public int getColNum() {
    return colNum;
  }

  public ChessPiece getChessPiece() {
    return chessPiece;
  }
}

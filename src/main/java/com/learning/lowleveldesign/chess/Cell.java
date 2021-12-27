package com.learning.lowleveldesign.chess;

public class Cell {
  private int rowNum;
  private int colNum;
  private ChessPiece chessPiece;
  private CellColor cellColor;

  public Cell(int rowNum, int colNum, ChessPiece chessPiece) {
    this.rowNum = rowNum;
    this.colNum = colNum;
    this.chessPiece = chessPiece;
    this.cellColor = calculateCellColor();
  }

  private CellColor calculateCellColor() {
    return ((rowNum + 8 * colNum) & 1) == 0 ? CellColor.BLACK : CellColor.WHITE;
  }

  public CellColor getCellColor(){
    return this.cellColor;
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

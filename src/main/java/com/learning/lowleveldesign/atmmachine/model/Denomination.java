package com.learning.lowleveldesign.atmmachine.model;

public enum Denomination {
  HUNDRED(100), FIFTY(50), TWOTHOUHSAND(2000), FIVEHUNDRED(500);
  private int value;
  private Denomination(int value){
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}

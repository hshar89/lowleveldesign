package com.learning.lowleveldesign.cricbuzz.model;

public enum Inning {
  FIRST(1), SECOND(2);
  private int val;
  Inning(int val){
    this.val = val;
  }
  public int getInningValue(){
    return this.val;
  }
}

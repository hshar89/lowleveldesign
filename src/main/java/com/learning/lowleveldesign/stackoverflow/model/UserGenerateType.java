package com.learning.lowleveldesign.stackoverflow.model;

public class UserGenerateType {
  private Character code;
  private GenerateType generateType;

  public UserGenerateType(Character code, GenerateType generateType) {
    this.code = code;
    this.generateType = generateType;
  }

  public Character getCode() {
    return code;
  }

}

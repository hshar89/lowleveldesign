package com.learning.lowleveldesign.stackoverflow.model;

public class Flag extends UserAction {
  private Integer userGenerateId;
  private String flagReason;

  public Flag(String userId,
              Integer userGenerateId, String flagReason) {
    super('f', ActionType.FLAG, userId);
    this.userGenerateId = userGenerateId;
    this.flagReason = flagReason;
  }

  public Integer getUserGenerateId() {
    return userGenerateId;
  }

}

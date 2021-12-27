package com.learning.lowleveldesign.stackoverflow.model;

public class Upvote extends UserAction{
  private Integer userGenerateId;
  private Character userGenerateCode;

  public Upvote(String userId,
                Integer userGenerateId) {
    super('u', ActionType.UPVOTE, userId);
    this.userGenerateId = userGenerateId;
  }

  public Integer getUserGenerateId() {
    return userGenerateId;
  }

  public Character getUserGenerateCode() {
    return userGenerateCode;
  }
}

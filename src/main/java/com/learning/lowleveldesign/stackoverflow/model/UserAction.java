package com.learning.lowleveldesign.stackoverflow.model;

public class UserAction extends UserActionType{
  private Integer userActionId;
  private String userId;

  public UserAction(Character code, ActionType actionType, String userId) {
    super(code, actionType);
    this.userId = userId;
  }

  public void setUserActionId(Integer userActionId) {
    this.userActionId = userActionId;
  }

  public Integer getUserActionId() {
    return userActionId;
  }

  public String getUserId() {
    return userId;
  }
}

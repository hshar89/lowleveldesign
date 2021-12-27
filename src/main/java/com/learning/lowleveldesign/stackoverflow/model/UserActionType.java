package com.learning.lowleveldesign.stackoverflow.model;

public class UserActionType {
  private Character code;
  private ActionType actionType;

  public UserActionType(Character code, ActionType actionType) {
    this.code = code;
    this.actionType = actionType;
  }

  public Character getCode() {
    return code;
  }

  public ActionType getActionTypeName() {
    return actionType;
  }
}

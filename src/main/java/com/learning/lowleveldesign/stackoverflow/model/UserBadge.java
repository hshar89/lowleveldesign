package com.learning.lowleveldesign.stackoverflow.model;

public class UserBadge {
  private String userId;
  private Integer badgeId;

  public UserBadge(String userId, Integer badgeId) {
    this.userId = userId;
    this.badgeId = badgeId;
  }

  public String getUserId() {
    return userId;
  }

  public Integer getBadgeId() {
    return badgeId;
  }
}

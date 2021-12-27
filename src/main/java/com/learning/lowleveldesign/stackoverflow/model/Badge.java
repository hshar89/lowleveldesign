package com.learning.lowleveldesign.stackoverflow.model;

public class Badge {
  private int badgeId;
  private String badgeTitle;

  public Badge(int badgeId, String badgeTitle) {
    this.badgeId = badgeId;
    this.badgeTitle = badgeTitle;
  }

  public int getBadgeId() {
    return badgeId;
  }

  public String getBadgeTitle() {
    return badgeTitle;
  }
}

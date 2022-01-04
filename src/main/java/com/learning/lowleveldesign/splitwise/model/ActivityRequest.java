package com.learning.lowleveldesign.splitwise.model;

import java.util.List;

public class ActivityRequest {
  private String createdByUserId;
  private String action;
  private ActivityType activityType;
  private String groupId;
  private List<String> involvedUsers;

  public ActivityRequest(String createdByUserId, String action,
                         ActivityType activityType, String groupId, List<String> involvedUsers) {
    this.createdByUserId = createdByUserId;
    this.action = action;
    this.activityType = activityType;
    this.groupId = groupId;
    this.involvedUsers = involvedUsers;
  }

  public String getCreatedByUserId() {
    return createdByUserId;
  }

  public String getAction() {
    return action;
  }

  public ActivityType getActivityType() {
    return activityType;
  }

  public String getGroupId() {
    return groupId;
  }

  public List<String> getInvolvedUsers() {
    return involvedUsers;
  }
}

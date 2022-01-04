package com.learning.lowleveldesign.splitwise.model;

import java.util.Date;

public class Activity {
  private String activityId;
  private String createdByUserId;
  private Date createdDate;
  private String action;
  private String generatedForUserId;
  private ActivityType activityType;

  public Activity(String createdByUserId, Date createdDate, String action, String generatedForUserId,
                  ActivityType activityType) {
    this.createdByUserId = createdByUserId;
    this.createdDate = createdDate;
    this.action = action;
    this.generatedForUserId = generatedForUserId;
    this.activityType = activityType;
  }

  public String getActivityId() {
    return activityId;
  }

  public String getCreatedByUserId() {
    return createdByUserId;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public String getAction() {
    return action;
  }

  public String getGeneratedForUserId() {
    return generatedForUserId;
  }

  public ActivityType getActivityType() {
    return activityType;
  }
}

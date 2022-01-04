package com.learning.lowleveldesign.splitwise.model;

import java.util.Date;

public class UserGroup {
  private String groupId;
  private String userId;
  private Date createdDate;

  public UserGroup(String groupId, String userId, Date createdDate) {
    this.groupId = groupId;
    this.userId = userId;
    this.createdDate = createdDate;
  }

  public String getGroupId() {
    return groupId;
  }

  public String getUserId() {
    return userId;
  }

  public Date getCreatedDate() {
    return createdDate;
  }
}

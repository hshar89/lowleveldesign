package com.learning.lowleveldesign.splitwise.model;

import java.util.Date;

public class Friend {
  private final String userOneId;
  private final String userTwoId;
  private final Date createdOn;
  private Date lastKnownTransactionDate;

  public Friend(String userOneId, String userTwoId, Date createdOn) {
    this.userOneId = userOneId;
    this.userTwoId = userTwoId;
    this.createdOn = createdOn;
  }

  public void setLastKnownTransactionDate(Date lastKnownTransactionDate) {
    this.lastKnownTransactionDate = lastKnownTransactionDate;
  }

  public String getUserOneId() {
    return userOneId;
  }

  public String getUserTwoId() {
    return userTwoId;
  }

  public Date getCreatedOn() {
    return createdOn;
  }

  public Date getLastKnownTransactionDate() {
    return lastKnownTransactionDate;
  }
}

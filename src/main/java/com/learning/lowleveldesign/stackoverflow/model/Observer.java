package com.learning.lowleveldesign.stackoverflow.model;

public class Observer {
  private Integer observerId;
  private String userId;
  private Integer entityId;

  public Observer(String userId, Integer entityId) {
    this.userId = userId;
    this.entityId = entityId;
  }

  public void setObserverId(Integer observerId) {
    this.observerId = observerId;
  }

  public Integer getObserverId() {
    return observerId;
  }

  public String getUserId() {
    return userId;
  }

  public Integer getEntityId() {
    return entityId;
  }
}

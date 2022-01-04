package com.learning.lowleveldesign.splitwise.model;

import java.util.Date;

public class Group {
  private final String groupId;
  private final String name;
  private final String desc;
  private final Date createdDate;
  private final String createdByUserId;
  private Integer memberCount;

  public Group(String groupId, String name, String desc, Date createdDate, String createdByUserId) {
    this.groupId = groupId;
    this.name = name;
    this.desc = desc;
    this.createdDate = createdDate;
    this.createdByUserId = createdByUserId;
    this.memberCount = 0;
  }

  public void increaseMemberCount(){
    this.memberCount++;
  }

  public String getGroupId() {
    return groupId;
  }

  public String getName() {
    return name;
  }

  public String getDesc() {
    return desc;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public Integer getMemberCount() {
    return memberCount;
  }

  public String getCreatedByUserId() {
    return createdByUserId;
  }
}

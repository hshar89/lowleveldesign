package com.learning.lowleveldesign.stackoverflow.model;

import java.util.Date;

public class UserGenerate extends UserGenerateType {

  private Integer id;
  private String userId;
  private Date createdDate;

  public UserGenerate(Character code, GenerateType generateType, String userId, Date createdDate) {
    super(code, generateType);
    this.userId = userId;
    this.createdDate = createdDate;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}

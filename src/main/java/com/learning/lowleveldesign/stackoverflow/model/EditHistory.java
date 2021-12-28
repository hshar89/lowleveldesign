package com.learning.lowleveldesign.stackoverflow.model;

import java.util.Date;

public class EditHistory {
  private Integer editHistoryId;
  private String userId;
  private Integer questionId;
  private Date createdDate;
  private String prevousQuestion;
  private String newQuestion;

  public EditHistory(String userId, Integer questionId, Date createdDate, String prevousQuestion,
                     String newQuestion) {
    this.userId = userId;
    this.questionId = questionId;
    this.createdDate = createdDate;
    this.prevousQuestion = prevousQuestion;
    this.newQuestion = newQuestion;
  }

  public Integer getEditHistoryId() {
    return editHistoryId;
  }

  public void setEditHistoryId(Integer editHistoryId) {
    this.editHistoryId = editHistoryId;
  }
}

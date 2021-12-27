package com.learning.lowleveldesign.stackoverflow.model;

public class Tag {
  private Integer tagId;
  private String tagName;
  private Integer questionId;

  public Tag(Integer tagId, String tagName, Integer questionId) {
    this.tagId = tagId;
    this.tagName = tagName;
    this.questionId = questionId;
  }
}

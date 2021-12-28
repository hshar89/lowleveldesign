package com.learning.lowleveldesign.stackoverflow.model;

import java.util.Date;
import java.util.List;

public class Question extends UserGenerate{
  private String questionDescription;
  private List<Integer> tagIds;
  private String title;
  private QuestionStatus questionStatus;

  public Question(String userId, Date createdDate,
                  String questionDescription, List<Integer> tagIds, String title) {
    super('q', GenerateType.QUESTION, userId, createdDate);
    this.questionDescription = questionDescription;
    this.tagIds = tagIds;
    this.title = title;
    this.questionStatus = QuestionStatus.ACTIVE;
  }

  public void setQuestionStatus(QuestionStatus questionStatus) {
    this.questionStatus = questionStatus;
  }

  public void updateQuestionStatus(QuestionStatus questionStatus) {
    this.questionStatus = questionStatus;
  }

  public String getQuestionDescription() {
    return questionDescription;
  }

  public List<Integer> getTagIds() {
    return tagIds;
  }

  public String getTitle() {
    return title;
  }
}

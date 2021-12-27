package com.learning.lowleveldesign.stackoverflow.model;

import java.util.Date;

public class Answer extends UserGenerate{
  private String answerDescription;
  private Integer questionId;
  private AnswerStatus answerStatus;
  private boolean isAccepted;

  public Answer(String userId, Date createdDate, Integer questionId,
                String answerDescription) {
    super('a', GenerateType.ANSWER, userId, createdDate);
    this.answerDescription = answerDescription;
    this.questionId = questionId;
    this.answerStatus = AnswerStatus.ACTIVE;
  }

  public void setAccepted(boolean accepted) {
    isAccepted = accepted;
  }

  public boolean isAccepted() {
    return isAccepted;
  }

  public Integer getQuestionId() {
    return questionId;
  }

  public void updateAnswerStatus(AnswerStatus answerStatus) {
    this.answerStatus = answerStatus;
  }

  public String getAnswerDescription() {
    return answerDescription;
  }
}

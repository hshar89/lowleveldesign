package com.learning.lowleveldesign.stackoverflow.model;

import java.util.Date;

public class Comment extends UserGenerate {
  private String comment;
  private Integer answerId;
  private CommentStatus commentStatus;

  public Comment(String userId, Date createdDate, String comment, Integer answerId) {
    super('c', GenerateType.COMMENT, userId, createdDate);
    this.comment = comment;
    this.answerId = answerId;
    this.commentStatus = CommentStatus.ACTIVE;
  }

  public void updateCommentStatus(CommentStatus commentStatus) {
    this.commentStatus = commentStatus;
  }

  public String getComment() {
    return comment;
  }

  public Integer getAnswerId() {
    return answerId;
  }
}

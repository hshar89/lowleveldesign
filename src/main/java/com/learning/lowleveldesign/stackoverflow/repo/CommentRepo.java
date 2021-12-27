package com.learning.lowleveldesign.stackoverflow.repo;

import java.util.List;

import com.learning.lowleveldesign.stackoverflow.model.Comment;

public interface CommentRepo {
  public List<Comment> getCommentsByUserId(String userId);
  public Comment getCommentById(Integer commentId);
  public Comment saveComment(Comment comment);
  public List<Comment> getAllCommentsOnAnAnswer(Integer answerId);
  List<Comment> getAllCommentsOnAnswerBulk(List<Integer> answerIds);
}

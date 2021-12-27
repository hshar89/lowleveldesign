package com.learning.lowleveldesign.stackoverflow.repo;

import java.util.List;

import com.learning.lowleveldesign.stackoverflow.model.Upvote;

public interface UpvoteRepo {
  public Upvote saveUpvote(Upvote upvote);
  public Upvote getUpvoteById(Integer upvoteId);
  public List<Upvote> getUpvotesOnAQuestion(Integer questionId);
  public List<Upvote> getUpvotesOnAnAnswer(Integer answerId);
  public List<Upvote> getUpvotesOnComment(Integer commentId);
  List<Upvote> getUpvotesOnAnswerBulk(List<Integer> answerIds);
}

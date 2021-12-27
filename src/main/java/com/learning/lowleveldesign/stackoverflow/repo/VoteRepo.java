package com.learning.lowleveldesign.stackoverflow.repo;

import java.util.List;

import com.learning.lowleveldesign.stackoverflow.model.Vote;

public interface VoteRepo {
  public Vote saveVote(Vote vote);
  public Vote getVote(Integer voteId);
  public List<Vote> getAllVotesByUser(String userId);
  public List<Vote> getAllVotesOnQuestion(Integer questionId);
  public List<Vote> getAllVotesOnAnAnswer(Integer answerId);
  public List<Vote> getAllVotesOnComment(Integer commentId);
}

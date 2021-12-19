package com.learning.lowleveldesign.cricbuzz.repo;

import java.util.List;

import com.learning.lowleveldesign.cricbuzz.model.Commentator;

public interface CommentatorRepo {
  boolean saveCommentator(Commentator commentator);
  Commentator getCommentatorById(int commentatorId);
  List<Commentator> getCommentatorsByMatchId(int matchId);
  List<Commentator> getAllCommentatorsInBulk(List<Integer> commentatorIds);
}

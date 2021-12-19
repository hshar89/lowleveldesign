package com.learning.lowleveldesign.cricbuzz.repo;

import java.util.List;

import com.graph.lld.cricbuzz.model.CommentatorInstance;

public interface CommentatorInstanceRepo {
  boolean addCommentorInstance(CommentatorInstance commentatorInstance);
  List<Integer> getAllMatchesForACommentator(int commentatorId);
  List<Integer> getAllCommentatorForAMatch(int matchId);
}

package com.learning.lowleveldesign.cricbuzz.repo;

import java.util.List;

import com.learning.lowleveldesign.cricbuzz.model.Commentary;

public interface CommentaryRepo {
  boolean saveCommentary(Commentary commentary);
  Commentary getCommentaryById(int commentaryId);
  List<Commentary> getCommentaryByCommentorId(int commentatorId);
  Commentary getCommentaryForBall(String ballId);
  List<Commentary> getCommentaryInBulk(List<Integer> ballId);
}

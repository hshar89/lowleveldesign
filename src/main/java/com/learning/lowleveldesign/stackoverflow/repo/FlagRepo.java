package com.learning.lowleveldesign.stackoverflow.repo;

import java.util.List;

import com.learning.lowleveldesign.stackoverflow.model.Flag;

public interface FlagRepo {
  public Flag saveFlat(Flag flag);
  public Flag getFlagById(Integer flagId);
  public List<Flag> getFlagsByUserId(String userId);
  public List<Flag> getFlagsOnQuestion(Integer questionId);
  public List<Flag> getFlagsOnAnswer(Integer answerId);
  public List<Flag> getFlagsOnComment(Integer commentId);
  public List<Flag> getAllFlags();
}

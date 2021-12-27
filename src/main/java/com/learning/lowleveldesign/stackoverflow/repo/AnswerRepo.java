package com.learning.lowleveldesign.stackoverflow.repo;

import java.util.List;

import com.learning.lowleveldesign.stackoverflow.model.Answer;

public interface AnswerRepo {
  public Answer saveAnswer(Answer answer);
  public Answer getAnswerById(Integer id);
  public List<Answer> getAllAnswersByAUser(String userId);
  public List<Answer> getAllAnswersOnAQuestion(Integer questionId);
}

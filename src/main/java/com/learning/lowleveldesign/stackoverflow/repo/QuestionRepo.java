package com.learning.lowleveldesign.stackoverflow.repo;

import java.util.List;

import com.learning.lowleveldesign.stackoverflow.model.Question;

public interface QuestionRepo {
  public Question saveQuestion(Question question);
  public Question getQuestionById(Integer id);
  public List<Question> getAllQuestionsForAUser(String userId);
  public List<Question> getQuestionByTagId(Integer tagId);
  public List<Question> getQuestionByDescription(String question);
  public Question updateQuestion(Question question);
  List<Question> getQuestionsByBulk(List<Integer> userGenerateIds);
}

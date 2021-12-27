package com.learning.lowleveldesign.stackoverflow.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.learning.lowleveldesign.stackoverflow.model.Answer;
import com.learning.lowleveldesign.stackoverflow.model.Comment;
import com.learning.lowleveldesign.stackoverflow.model.Question;
import com.learning.lowleveldesign.stackoverflow.model.Upvote;
import com.learning.lowleveldesign.stackoverflow.repo.AnswerRepo;
import com.learning.lowleveldesign.stackoverflow.repo.CommentRepo;
import com.learning.lowleveldesign.stackoverflow.repo.QuestionRepo;
import com.learning.lowleveldesign.stackoverflow.repo.UpvoteRepo;

public class SearchService {
  private QuestionRepo questionRepo;
  private AnswerRepo answerRepo;
  private CommentRepo commentRepo;
  private UpvoteRepo upvoteRepo;

  public List<Question> searchQuestionsByDescription(String searchString) {
    return questionRepo.getQuestionByDescription(searchString);
  }

  public List<Answer> getAllAnswersOnAQuestion(Integer questionId) {
    return answerRepo.getAllAnswersOnAQuestion(questionId);
  }

  public Map<Integer, List<Comment>> getAllCommentsOnAnswer(List<Integer> answerIds) {
    List<Comment> comments = commentRepo.getAllCommentsOnAnswerBulk(answerIds);
    Map<Integer, List<Comment>> map = new HashMap<>();
    comments.forEach(comment -> {
      map.computeIfAbsent(comment.getAnswerId(), k -> new ArrayList<>()).add(comment);
    });
    return map;
  }

  public List<Upvote> getAllUpvotesOnQuestion(Integer questionId) {
    return upvoteRepo.getUpvotesOnAQuestion(questionId);
  }

  public Map<Integer, List<Upvote>> getAllUpvotesOnAnswers(List<Integer> answerIds) {
    List<Upvote> upvotes = upvoteRepo.getUpvotesOnAnswerBulk(answerIds);
    Map<Integer, List<Upvote>> map = new HashMap<>();
    upvotes.forEach(upvote -> {
      map.computeIfAbsent(upvote.getUserGenerateId(), k -> new ArrayList<>()).add(upvote);
    });
    return map;
  }
}

package com.learning.lowleveldesign.stackoverflow.model;

import java.util.List;

import com.learning.lowleveldesign.stackoverflow.service.BadgeService;
import com.learning.lowleveldesign.stackoverflow.service.QuestionAnswerService;
import com.learning.lowleveldesign.stackoverflow.service.SearchService;

public class Member extends SystemUser{

  private QuestionAnswerService questionAnswerService;
  private BadgeService badgeService;
  private SearchService searchService;

  public Member(String fname, String lname, Account account) {
    super(fname, lname, account);
  }

  public Question addQuestion(Question question){
    return questionAnswerService.addQuestion(question);
  }

  public void upvoteAQuestion(Integer questionId){
    questionAnswerService.upvote(questionId, getUserId());
  }

  public void upvoteAnAnswer(Integer answerId){
    questionAnswerService.upvote(answerId, getUserId());
  }

  public void upvoteAComment(Integer commentId){
    questionAnswerService.upvote(commentId, getUserId());
  }

  public List<Question> getAllQuestionsSubmittedByUser(){
    return questionAnswerService.getAllQuestionsSubmittedByUser(getUserId());
  }

  public void answerAQuestion(Integer questionId, String answerDescription){
    questionAnswerService.answerAQuestion(questionId, getUserId(), answerDescription);
  }

  public void flagQuestion(Integer questionId, String flagReason){
    questionAnswerService.flagAQuestion(questionId, getUserId(), flagReason);
  }

  public void commentOnAnswer(Integer answerId, String comment){
    questionAnswerService.comment(answerId, getUserId(), comment);
  }

  public List<Question> getQuestions(String searchString){
    return searchService.searchQuestionsByDescription(searchString);
  }

  public List<Badge> getAllBadges(){
    return badgeService.getBadgesForUser(getUserId());
  }

  public boolean restoreQuestion(Integer questionId){
    return true;
  }

  public boolean addQuestionToWatchList(Integer questionId){
    questionAnswerService.addObserver(questionId, getUserId());
    return true;
  }

}

package com.learning.lowleveldesign.stackoverflow.model;

import java.util.List;

import com.learning.lowleveldesign.stackoverflow.service.BadgeService;
import com.learning.lowleveldesign.stackoverflow.service.QuestionAnswerService;

public class Moderator extends SystemUser{

  private QuestionAnswerService questionAnswerService;
  private BadgeService badgeService;
  public Moderator(String fname, String lname, Account account) {
    super(fname, lname, account);
  }

  public Badge addBadge(Badge badge){
    return badgeService.addBadge(badge);
  }

  public void closeQuestion(Integer questionId){
    questionAnswerService.closeQuestion(questionId);
  }

  public void assignBadgeToUser(String userId, Badge badge){
    UserBadge userBadge = new UserBadge(userId, badge.getBadgeId());
    badgeService.assignBadgeToUser(userBadge);
  }

  public List<Question> getAllFlaggedQuestions(){
    return questionAnswerService.getAllFlaggedQuestions();
  }

}

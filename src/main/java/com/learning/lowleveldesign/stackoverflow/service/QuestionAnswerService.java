package com.learning.lowleveldesign.stackoverflow.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.learning.lowleveldesign.stackoverflow.model.Answer;
import com.learning.lowleveldesign.stackoverflow.model.Comment;
import com.learning.lowleveldesign.stackoverflow.model.Flag;
import com.learning.lowleveldesign.stackoverflow.model.Member;
import com.learning.lowleveldesign.stackoverflow.model.Observer;
import com.learning.lowleveldesign.stackoverflow.model.Question;
import com.learning.lowleveldesign.stackoverflow.model.QuestionStatus;
import com.learning.lowleveldesign.stackoverflow.model.Upvote;
import com.learning.lowleveldesign.stackoverflow.repo.AnswerRepo;
import com.learning.lowleveldesign.stackoverflow.repo.CommentRepo;
import com.learning.lowleveldesign.stackoverflow.repo.FlagRepo;
import com.learning.lowleveldesign.stackoverflow.repo.ObserverRepo;
import com.learning.lowleveldesign.stackoverflow.repo.QuestionRepo;
import com.learning.lowleveldesign.stackoverflow.repo.UpvoteRepo;
import com.learning.lowleveldesign.stackoverflow.repo.UserRepo;

public class QuestionAnswerService {
  private QuestionRepo questionRepo;
  private UpvoteRepo upvoteRepo;
  private AnswerRepo answerRepo;
  private FlagRepo flagRepo;
  private CommentRepo commentRepo;
  private ObserverRepo observerRepo;
  private UserRepo userRepo;
  private EmailService emailService;

  public Question addQuestion(Question question) {
    return questionRepo.saveQuestion(question);
  }

  public void upvote(Integer questionId, String userId) {
    Upvote upvote = new Upvote(userId, questionId);
    upvoteRepo.saveUpvote(upvote);
  }

  public void closeQuestion(Integer questionId) {
    Question question = questionRepo.getQuestionById(questionId);
    question.setQuestionStatus(QuestionStatus.CLOSED);
    questionRepo.updateQuestion(question);
    notifyObservers(questionId);
  }

  public List<Question> getAllQuestionsSubmittedByUser(String userId) {
    return questionRepo.getAllQuestionsForAUser(userId);
  }

  public void answerAQuestion(Integer questionId, String userId, String answerDescription) {
    Answer answer = new Answer(userId, new Date(), questionId, answerDescription);
    answerRepo.saveAnswer(answer);
    notifyObservers(questionId);
  }

  private void notifyObservers(Integer questionId) {
    List<Observer> observers = observerRepo.getObserversForEntity(questionId);
    Question question = questionRepo.getQuestionById(questionId);
    List<Member> members = userRepo.getMembersBulk(observers.stream().map(observer->observer.getUserId()).collect(
        Collectors.toList()));
    members.forEach(member-> emailService.sendEmail(member.getAccount().getEmail(), question));
  }

  public void flagAQuestion(Integer questionId, String userId, String flagReason) {
    Flag flag = new Flag(userId, questionId, flagReason);
    flagRepo.saveFlat(flag);
  }

  public void comment(Integer answerId, String userId, String comment) {
    Comment commentObject = new Comment(userId, new Date(), comment, answerId);
    commentRepo.saveComment(commentObject);
  }

  public List<Question> getAllFlaggedQuestions() {
    List<Flag> flags = flagRepo.getAllFlags();
    List<Integer> userGenerateIds = flags.stream().map(flag -> flag.getUserGenerateId()).collect(Collectors.toList());
    return questionRepo.getQuestionsByBulk(userGenerateIds);
  }

  public void addObserver(Integer questionId, String userId) {
    Observer observer = new Observer(userId, questionId);
    observerRepo.saveObserver(observer);
  }
}

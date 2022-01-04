package com.learning.lowleveldesign.splitwise.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.learning.lowleveldesign.splitwise.model.Activity;
import com.learning.lowleveldesign.splitwise.model.ActivityRequest;
import com.learning.lowleveldesign.splitwise.model.User;
import com.learning.lowleveldesign.splitwise.model.UserGroup;
import com.learning.lowleveldesign.splitwise.repo.ActivityRepo;
import com.learning.lowleveldesign.splitwise.repo.UserGroupRepo;
import com.learning.lowleveldesign.splitwise.repo.UserRepo;

public class ActivityService {
  private ActivityRepo activityRepo;
  private UserGroupRepo userGroupRepo;
  private UserRepo userRepo;
  private NotificationService notificationService;

  public void addActivitiesForGroupCreate() {

  }

  public void createActivityForExpenseAddition(ActivityRequest activityRequest) {
    List<User> usersToGenerateActivityFor = new ArrayList<>();
    if (activityRequest.getGroupId() != null) {
      List<String> userIds = userGroupRepo.getUserGroupsByGroupId(activityRequest.getGroupId()).stream()
          .map(userGroup -> userGroup.getUserId()).collect(
              Collectors.toList());
      usersToGenerateActivityFor.addAll(userRepo.getUsersBulk(userIds));
    } else {
      usersToGenerateActivityFor.addAll(userRepo.getUsersBulk(activityRequest.getInvolvedUsers()));
    }
    for (User user : usersToGenerateActivityFor) {
      Activity activity = new Activity(activityRequest.getCreatedByUserId(), new Date(), activityRequest.getAction(),
          user.getId(), activityRequest.getActivityType());
      activityRepo.saveActivity(activity);
      notificationService.sendNotificationToUser(null);
    }
  }
}

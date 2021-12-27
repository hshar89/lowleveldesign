package com.learning.lowleveldesign.stackoverflow.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.learning.lowleveldesign.chess.User;
import com.learning.lowleveldesign.stackoverflow.model.Badge;
import com.learning.lowleveldesign.stackoverflow.model.UserBadge;
import com.learning.lowleveldesign.stackoverflow.repo.BadgeRepo;
import com.learning.lowleveldesign.stackoverflow.repo.UserBadgeRepo;

public class BadgeService {

  private BadgeRepo badgeRepo;
  private UserBadgeRepo userBadgeRepo;

  public Badge addBadge(Badge badge){
    return badgeRepo.saveBadge(badge);
  }

  public void assignBadgeToUser(UserBadge userBadge){
    userBadgeRepo.saveUserBadge(userBadge);
  }

  public List<Badge> getBadgesForUser(String userId) {
    List<UserBadge> userBadges = userBadgeRepo.getUserBadgesByUserId(userId);
    Set<Integer> badgeIds = userBadges.stream().map(userBadge -> userBadge.getBadgeId()).collect(Collectors.toSet());
    return badgeRepo.getBadges(badgeIds);
  }
}

package com.learning.lowleveldesign.stackoverflow.repo;

import java.util.List;

import com.learning.lowleveldesign.stackoverflow.model.UserBadge;

public interface UserBadgeRepo {
  public UserBadge saveUserBadge(UserBadge userBadge);
  public List<UserBadge> getUserBadgesByUserId(String userId);
  public List<UserBadge> getUserBadgesByBadgeId(Integer badgeId);
}

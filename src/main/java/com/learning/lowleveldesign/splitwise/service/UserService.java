package com.learning.lowleveldesign.splitwise.service;

import java.util.List;

import com.learning.lowleveldesign.splitwise.model.Friend;
import com.learning.lowleveldesign.splitwise.repo.FriendRepo;

public class UserService {
  private FriendRepo friendRepo;

  public List<Friend> getAllFriendsForAUser(String userId) {
    return friendRepo.getFriendsByUser(userId);
  }
}

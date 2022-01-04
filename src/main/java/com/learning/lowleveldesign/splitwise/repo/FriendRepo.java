package com.learning.lowleveldesign.splitwise.repo;

import java.util.List;

import com.learning.lowleveldesign.splitwise.model.Friend;

public interface FriendRepo {
  Friend save(Friend friend);
  List<Friend> getFriendsByUser(String userId);
  void updateFriend(Friend friend);
}

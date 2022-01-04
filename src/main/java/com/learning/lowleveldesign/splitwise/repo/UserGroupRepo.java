package com.learning.lowleveldesign.splitwise.repo;

import java.util.List;

import com.learning.lowleveldesign.splitwise.model.UserGroup;

public interface UserGroupRepo {
  UserGroup saveUserGroup(UserGroup userGroup);

  List<UserGroup> getUserGroupsByUserId(String userId);

  List<UserGroup> getUserGroupsByGroupId(String groupId);

  UserGroup getByGroupIdAndUserId(String groupId, String userId);

  boolean deleteRecord(String groupId, String userId);
}

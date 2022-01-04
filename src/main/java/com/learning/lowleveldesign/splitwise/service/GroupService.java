package com.learning.lowleveldesign.splitwise.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.learning.lowleveldesign.splitwise.model.Group;
import com.learning.lowleveldesign.splitwise.model.UserGroup;
import com.learning.lowleveldesign.splitwise.repo.GroupRepo;
import com.learning.lowleveldesign.splitwise.repo.UserGroupRepo;
import com.learning.lowleveldesign.splitwise.repo.UserRepo;

public class GroupService {
  private GroupRepo groupRepo;
  private UserRepo userRepo;
  private UserGroupRepo userGroupRepo;

  public List<Group> findAllGroupsForUser(String userId){
    List<UserGroup> userGroups = userGroupRepo.getUserGroupsByUserId(userId);
    List<String> groupIds = userGroups.stream().map(userGroup -> userGroup.getGroupId()).collect(Collectors.toList());
    return groupRepo.getGroupsBulk(groupIds);
  }

  public Group createGroup(String name, String description, String createdByUserId) {
    Group group = new Group(UUID.randomUUID().toString(), name, description, new Date(), createdByUserId);
    return groupRepo.saveGroup(group);
  }

  public boolean addUsersToGroup(List<String> userIds, String groupId) {
    for(String userId: userIds){
      UserGroup userGroup = new UserGroup(groupId, userId, new Date());
      userGroupRepo.saveUserGroup(userGroup);
    }
    return true;
  }

  public boolean removeAUserFromGroup(String groupId, String userId) {
    UserGroup userGroup = userGroupRepo.getByGroupIdAndUserId(groupId, userId);
    if(userGroup==null){
      throw new IllegalArgumentException("User not part of the group");
    }
    return userGroupRepo.deleteRecord(groupId, userId);
  }

  public boolean deleteGroup(String groupId, String id) {
    Group group = groupRepo.getGroupById(groupId);
    if(!group.getCreatedByUserId().equalsIgnoreCase(id)){
      return false;
    }
    return groupRepo.deleteGroup(groupId);
  }
}

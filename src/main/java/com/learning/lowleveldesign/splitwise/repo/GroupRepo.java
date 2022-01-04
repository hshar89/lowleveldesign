package com.learning.lowleveldesign.splitwise.repo;

import java.util.List;

import com.learning.lowleveldesign.splitwise.model.Group;

public interface GroupRepo {
  Group saveGroup(Group group);

  Group getGroupById(String groupId);

  List<Group> getGroupsBulk(List<String> groupIds);

  boolean deleteGroup(String groupId);
}

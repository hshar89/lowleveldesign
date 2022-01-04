package com.learning.lowleveldesign.splitwise.repo;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.learning.lowleveldesign.splitwise.model.User;

public interface UserRepo {
  User saveUser(User user);

  User getUserById(String userId);

  List<User> getUsersBulk(Collection<String> userIds);
}

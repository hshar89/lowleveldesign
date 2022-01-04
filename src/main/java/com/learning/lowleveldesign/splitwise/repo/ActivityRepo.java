package com.learning.lowleveldesign.splitwise.repo;

import java.util.List;

import com.learning.lowleveldesign.splitwise.model.Activity;

public interface ActivityRepo {
  Activity saveActivity(Activity activity);
  List<Activity> getAllActivitiesForAUser(String userId);
}

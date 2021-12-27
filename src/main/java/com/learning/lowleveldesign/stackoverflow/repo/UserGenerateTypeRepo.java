package com.learning.lowleveldesign.stackoverflow.repo;

import com.learning.lowleveldesign.stackoverflow.model.UserGenerateType;

public interface UserGenerateTypeRepo {
  public UserGenerateType getUserGenerateTypeByCode(Character code);
  public UserGenerateType saveUserGenerateType(UserGenerateType userGenerateType);
}

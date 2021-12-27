package com.learning.lowleveldesign.stackoverflow.repo;

import com.learning.lowleveldesign.stackoverflow.model.UserGenerate;

public interface UserGenerateRepo {
  public UserGenerate saveUserGenerate(UserGenerate userGenerate);
  public UserGenerate getUserGenerateByIdAndType(Integer id, Character code);
}

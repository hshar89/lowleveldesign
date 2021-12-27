package com.learning.lowleveldesign.stackoverflow.repo;

import com.learning.lowleveldesign.stackoverflow.model.Member;
import com.learning.lowleveldesign.stackoverflow.model.Moderator;

public interface UserRepo {

  public Member saveMember(Member member);
  public Moderator saveModerator(Moderator moderator);
  public Member getMemberById(String memberId);

}

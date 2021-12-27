package com.learning.lowleveldesign.chess;

import java.util.UUID;

public class AnonymousUser extends Person{
  private String anonymousUserId;

  public AnonymousUser(String fname, String lname) {
    super(fname, lname);
    this.anonymousUserId = UUID.randomUUID().toString();
  }

  public String getAnonymousUserId() {
    return anonymousUserId;
  }
}

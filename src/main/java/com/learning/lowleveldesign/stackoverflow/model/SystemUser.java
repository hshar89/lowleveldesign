package com.learning.lowleveldesign.stackoverflow.model;

import java.util.UUID;

public class SystemUser extends Person{

  private Account account;
  private String userId;

  public SystemUser(String fname, String lname, Account account) {
    super(fname, lname);
    this.userId = UUID.randomUUID().toString();
    this.account = account;
  }

  public String getUserId() {
    return userId;
  }

  public Account getAccount() {
    return account;
  }

}

package com.learning.lowleveldesign.atmmachine.model;

public class SystemUser extends Person{
  private String userId;
  private Account account;

  public SystemUser(String fname, String lname, String email, String phone, String userId, Account account) {
    super(fname, lname, email, phone);
    this.userId = userId;
    this.account = account;
  }

}

package com.learning.lowleveldesign.chess;

public class SystemUser extends Person{
  private Account account;

  public SystemUser(String fname, String lname, Account account) {
    super(fname, lname);
    this.account = account;
  }

}

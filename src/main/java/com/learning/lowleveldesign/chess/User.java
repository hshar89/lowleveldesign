package com.learning.lowleveldesign.chess;

public class User extends SystemUser{

  private String userId;

  public User(String fname, String lname, Account account) {
    super(fname, lname, account);
  }

  public void setUserId(String id){
    this.userId = id;
  }
}

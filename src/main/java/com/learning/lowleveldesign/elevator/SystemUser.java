package com.learning.lowleveldesign.elevator;

public class SystemUser {
  private String fname;
  private String lname;
  private String userId;
  private String email;

  public SystemUser(String fname, String lname, String userId, String email) {
    this.fname = fname;
    this.lname = lname;
    this.userId = userId;
    this.email = email;
  }
}

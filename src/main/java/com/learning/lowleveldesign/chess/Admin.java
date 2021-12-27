package com.learning.lowleveldesign.chess;

public class Admin extends SystemUser{

  private GamePortal gamePortal;

  public Admin(String fname, String lname, Account account) {
    super(fname, lname, account);
  }

  public void registerUser(User user){
  }

  public void addRobot(Robot robot){

  }
}

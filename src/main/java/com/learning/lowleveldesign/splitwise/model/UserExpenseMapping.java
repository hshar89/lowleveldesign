package com.learning.lowleveldesign.splitwise.model;

public class UserExpenseMapping {
  private String userExpenseId;
  private String owedByUserId;
  private String owedToUserId;
  private double amount;

  public UserExpenseMapping(String userExpenseId, String owedByUserId, String owedToUserId, double amount) {
    this.userExpenseId = userExpenseId;
    this.owedByUserId = owedByUserId;
    this.owedToUserId = owedToUserId;
    this.amount = amount;
  }

  public String getUserExpenseId() {
    return userExpenseId;
  }

  public String getOwedByUserId() {
    return owedByUserId;
  }

  public String getOwedToUserId() {
    return owedToUserId;
  }

  public double getAmount() {
    return amount;
  }
}

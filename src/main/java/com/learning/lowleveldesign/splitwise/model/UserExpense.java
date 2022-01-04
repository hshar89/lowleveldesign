package com.learning.lowleveldesign.splitwise.model;

import java.util.UUID;

public class UserExpense {
  private String userExpenseId;
  private String expenseId;
  private String userId;
  private double share_of_user;
  private double amount_paid_by_user;

  public UserExpense(String expenseId, String userId, double share_of_user, double amount_paid_by_user) {
    this.userExpenseId = UUID.randomUUID().toString();
    this.expenseId = expenseId;
    this.userId = userId;
    this.share_of_user = share_of_user;
    this.amount_paid_by_user = amount_paid_by_user;

  }

  public String getExpenseId() {
    return expenseId;
  }

  public String getUserId() {
    return userId;
  }

  public double getShare_of_user() {
    return share_of_user;
  }

  public double getAmount_paid_by_user() {
    return amount_paid_by_user;
  }

  public String getUserExpenseId() {
    return userExpenseId;
  }
}

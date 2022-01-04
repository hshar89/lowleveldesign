package com.learning.lowleveldesign.splitwise.model;

public class UserExpenseSummary {
  private User summaryGeneratedForUser;
  private User expensesSharedWithUser;
  private double amount;

  public UserExpenseSummary(User summaryGeneratedForUser,
                            User expensesSharedWithUser, double amount) {
    this.summaryGeneratedForUser = summaryGeneratedForUser;
    this.expensesSharedWithUser = expensesSharedWithUser;
    this.amount = amount;
  }

  public User getSummaryGeneratedForUser() {
    return summaryGeneratedForUser;
  }

  public User getExpensesSharedWithUser() {
    return expensesSharedWithUser;
  }

  public double getAmount() {
    return amount;
  }
}

package com.learning.lowleveldesign.splitwise.model;

public class Expense {
  private final String expenseId;
  private final String expensAddedByUserId;
  private final String description;
  private final double amount;
  private final String groupId;

  public Expense(String expenseId, String userId, String description, double amount, String groupId) {
    this.expenseId = expenseId;
    this.expensAddedByUserId = userId;
    this.description = description;
    this.amount = amount;
    this.groupId = groupId;
  }

  public String getExpensAddedByUserId() {
    return expensAddedByUserId;
  }

  public String getExpenseId() {
    return expenseId;
  }

  public String getDescription() {
    return description;
  }

  public double getAmount() {
    return amount;
  }

  public String getGroupId() {
    return groupId;
  }
}

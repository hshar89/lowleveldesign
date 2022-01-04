package com.learning.lowleveldesign.splitwise.model;

import java.util.UUID;

public class UserExpenseMapping {
  private String id;
  private String userExpenseId;
  private String owedByUserId;
  private String owedToUserId;
  private double amount;

  public UserExpenseMapping(String userExpenseId, String owedByUserId, String owedToUserId, double amount) {
    this.id = UUID.randomUUID().toString();
    this.userExpenseId = userExpenseId;
    this.owedByUserId = owedByUserId;
    this.owedToUserId = owedToUserId;
    this.amount = amount;
  }

  public String getId() {
    return id;
  }

  public void setAmount(double amount) {
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

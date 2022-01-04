package com.learning.lowleveldesign.splitwise.model;

import java.util.List;
import java.util.Map;

public class GroupExpenseSummary {
  private String groupId;
  private String expenseDesription;
  private List<User> usersInvolvedInExpense;
  private User addedByUser;
  private double totalAmount;
  private Map<String, Double> userIdToAmountPaid;
  private Map<String, Double> userIdToAmountShare;

  public GroupExpenseSummary(String groupId, String expenseDesription,
                             List<User> usersInvolvedInExpense, User addedByUser, double totalAmount,
                             Map<String, Double> userIdToAmountPaid,
                             Map<String, Double> userIdToAmountShare) {
    this.groupId = groupId;
    this.expenseDesription = expenseDesription;
    this.usersInvolvedInExpense = usersInvolvedInExpense;
    this.addedByUser = addedByUser;
    this.totalAmount = totalAmount;
    this.userIdToAmountPaid = userIdToAmountPaid;
    this.userIdToAmountShare = userIdToAmountShare;
  }

  public String getExpenseDesription() {
    return expenseDesription;
  }

  public List<User> getUsersInvolvedInExpense() {
    return usersInvolvedInExpense;
  }

  public User getAddedByUser() {
    return addedByUser;
  }

  public double getTotalAmount() {
    return totalAmount;
  }

  public Map<String, Double> getUserIdToAmountPaid() {
    return userIdToAmountPaid;
  }

  public Map<String, Double> getUserIdToAmountShare() {
    return userIdToAmountShare;
  }
}

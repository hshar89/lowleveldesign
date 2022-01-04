package com.learning.lowleveldesign.splitwise.model;

import java.util.Map;

public class ExpenseRequest {
  private String added_by_user_id;
  private double amount;
  private Map<String, Amount> userIdWithUserShareAndAmountPaidMap;
  private String groupId;
  private String description;

  public ExpenseRequest(String added_by_user_id, double amount,
                        Map<String, Amount> userIdWithUserShareAndAmountPaidMap,
                        String groupId, String description) {
    this.added_by_user_id = added_by_user_id;
    this.amount = amount;
    this.userIdWithUserShareAndAmountPaidMap = userIdWithUserShareAndAmountPaidMap;
    this.groupId = groupId;
    this.description = description;
  }

  public String getAdded_by_user_id() {
    return added_by_user_id;
  }

  public double getAmount() {
    return amount;
  }

  public Map<String, Amount> getUserIdWithUserShareAndAmountPaidMap() {
    return userIdWithUserShareAndAmountPaidMap;
  }

  public String getGroupId() {
    return groupId;
  }

  public String getDescription() {
    return description;
  }

  public static class Amount{
    private final double userShare;
    private final double amount_pair_by_user;

    public Amount(double userShare, double amount_pair_by_user) {
      this.userShare = userShare;
      this.amount_pair_by_user = amount_pair_by_user;
    }

    public double getUserShare() {
      return userShare;
    }

    public double getAmount_pair_by_user() {
      return amount_pair_by_user;
    }
  }
}

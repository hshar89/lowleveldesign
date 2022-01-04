package com.learning.lowleveldesign.splitwise.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;

import com.learning.lowleveldesign.splitwise.model.Expense;
import com.learning.lowleveldesign.splitwise.model.ExpenseRequest;
import com.learning.lowleveldesign.splitwise.model.GroupExpenseSummary;
import com.learning.lowleveldesign.splitwise.model.User;
import com.learning.lowleveldesign.splitwise.model.UserExpense;
import com.learning.lowleveldesign.splitwise.model.UserExpenseMapping;
import com.learning.lowleveldesign.splitwise.model.UserExpenseSummary;
import com.learning.lowleveldesign.splitwise.repo.ExpenseRepo;
import com.learning.lowleveldesign.splitwise.repo.UserExpenseMappingRepo;
import com.learning.lowleveldesign.splitwise.repo.UserExpenseRepo;
import com.learning.lowleveldesign.splitwise.repo.UserRepo;

public class ExpenseService {
  private ExpenseRepo expenseRepo;
  private UserExpenseRepo userExpenseRepo;
  private UserRepo userRepo;
  private UserExpenseMappingRepo userExpenseMappingRepo;

  public List<GroupExpenseSummary> getAllExpensesForAGroup(String groupId) {
    List<Expense> expenses = expenseRepo.getAllExpensesForAGroup(groupId);
    List<String> expenseIds = expenses.stream().map(expense -> expense.getExpenseId()).collect(Collectors.toList());
    List<UserExpense> userExpenses = userExpenseRepo.getAllUserExpenseByExpenseIdBulk(expenseIds);
    Set<String> userIds = userExpenses.stream().map(userExpense -> userExpense.getUserId()).collect(Collectors.toSet());
    List<User> users = userRepo.getUsersBulk(userIds);
    Map<String, User> userMap = users.stream().collect(Collectors.toMap(user -> user.getId(), user -> user));
    Map<String, List<UserExpense>> expenseIdToUserExpense = new HashMap<>();
    for (UserExpense userExpense : userExpenses) {
      expenseIdToUserExpense.computeIfAbsent(userExpense.getExpenseId(), k -> new ArrayList<>()).add(userExpense);
    }
    List<GroupExpenseSummary> groupExpenseSummaries = new ArrayList<>();
    for (Expense expense : expenses) {
      String expenseId = expense.getExpenseId();
      List<UserExpense> userExpenseList = expenseIdToUserExpense.get(expenseId);
      double totalExpense =
          userExpenseList.stream().map(userExpense -> userExpense.getShare_of_user()).reduce(Double::sum).get();
      Set<String> involvedUserIds = userExpenseList.stream().map(userExpense -> userExpense.getUserId()).collect(
          Collectors.toSet());
      List<User> involvedUsers = new ArrayList<>();
      for (String user : involvedUserIds) {
        involvedUsers.add(userMap.get(user));
      }
      Map<String, Double> userIdToAmountPaid = new HashMap<>();
      Map<String, Double> userIdToAmountDue = new HashMap<>();
      for (UserExpense userExpense : userExpenseList) {
        userIdToAmountPaid.put(userExpense.getUserId(), userExpense.getAmount_paid_by_user());
        userIdToAmountDue.put(userExpense.getUserId(), userExpense.getShare_of_user());
      }
      GroupExpenseSummary groupExpenseSummary =
          new GroupExpenseSummary(groupId, expense.getDescription(), involvedUsers,
              userMap.get(expense.getExpensAddedByUserId()),
              totalExpense, userIdToAmountPaid, userIdToAmountDue);
      groupExpenseSummaries.add(groupExpenseSummary);
    }
    return groupExpenseSummaries;
  }

  public List<UserExpenseSummary> getAllExpensesWithOtherUsersForAGivenUser(String userId) {
    User userInContext = userRepo.getUserById(userId);
    List<UserExpenseMapping> userExpensesWhereUserOwes = userExpenseMappingRepo.getAllExpensesWhereUserOwes(userId);
    List<UserExpenseMapping> userExpensesWhereUserIsOwed = userExpenseMappingRepo.getAllExpensesWhereUserIsOwed(userId);
    Map<String, Double> otherUserToAmountOwed = new HashMap<>();
    for (UserExpenseMapping userExpenseMapping : userExpensesWhereUserOwes) {
      otherUserToAmountOwed.compute(userExpenseMapping.getOwedToUserId(), (k, v) -> v - userExpenseMapping.getAmount());
    }
    for (UserExpenseMapping userExpenseMapping : userExpensesWhereUserIsOwed) {
      otherUserToAmountOwed.compute(userExpenseMapping.getOwedToUserId(), (k, v) -> v + userExpenseMapping.getAmount());
    }
    List<String> otherUserIds =
        otherUserToAmountOwed.entrySet().stream().map(entry -> entry.getKey()).collect(Collectors.toList());
    Map<String, User> otherUsersMap =
        userRepo.getUsersBulk(otherUserIds).stream().collect(Collectors.toMap(user -> user.getId(), user -> user));
    List<UserExpenseSummary> summaries = new ArrayList<>();
    for (Map.Entry<String, Double> entry : otherUserToAmountOwed.entrySet()) {
      UserExpenseSummary userExpenseSummary =
          new UserExpenseSummary(userInContext, otherUsersMap.get(entry.getKey()), entry.getValue());
      summaries.add(userExpenseSummary);
    }
    return summaries;
  }

  public String addExpense(ExpenseRequest expenseRequest) {
    Expense expense = new Expense(UUID.randomUUID().toString(), expenseRequest.getAdded_by_user_id(),
        expenseRequest.getDescription(), expenseRequest.getAmount(), expenseRequest.getGroupId());
    expenseRepo.saveExpense(expense);
    PriorityQueue<BalanceAmount> userWithPositiveBalance = new PriorityQueue<>(
        (o1, o2) -> o2.getAmount() > o1.getAmount() ? 1 : -1);
    PriorityQueue<BalanceAmount> userWithNegativeBalance =
        new PriorityQueue<>((o1, o2) -> o2.getAmount() > o1.getAmount() ? 1 : -1);
    for (Map.Entry<String, ExpenseRequest.Amount> entry : expenseRequest.getUserIdWithUserShareAndAmountPaidMap()
        .entrySet()) {
      ExpenseRequest.Amount amount = entry.getValue();
      UserExpense userExpense = new UserExpense(expense.getExpenseId(), entry.getKey(), amount.getUserShare(),
          amount.getAmount_pair_by_user());
      userExpense = userExpenseRepo.saveUserExpense(userExpense);
      if (amount.getUserShare() > amount.getAmount_pair_by_user()) {
        userWithNegativeBalance.add(new BalanceAmount(entry.getKey(), amount.getUserShare() -
            amount.getAmount_pair_by_user(), userExpense.getUserExpenseId()));
      } else if (amount.getUserShare() < amount.getAmount_pair_by_user()) {
        userWithPositiveBalance.add(new BalanceAmount(entry.getKey(), amount.getAmount_pair_by_user() -
            amount.getUserShare(), userExpense.getUserExpenseId()));
      }
    }
    while (!userWithPositiveBalance.isEmpty()) {
      BalanceAmount pamount = userWithPositiveBalance.poll();
      BalanceAmount namount = userWithNegativeBalance.poll();
      double diff = pamount.getAmount() - namount.getAmount();
      if (diff > 0) {
        pamount.setAmount(diff);
        userWithPositiveBalance.add(pamount);
      } else if (diff < 0) {
        namount.setAmount(diff * (-1d));
        userWithNegativeBalance.add(namount);
      }
      UserExpenseMapping userExpenseMapping = new UserExpenseMapping(namount.getUserExpenseId(), namount.getUserId(),
          pamount.getUserId(), diff);
      userExpenseMappingRepo.saveUserExpenseMapping(userExpenseMapping);
    }
    return expense.getExpenseId();
  }

  public boolean settleDebt(String owedToUserId, String owedByUserId, double amount_to_settle) {
    return false;
  }

  private static class BalanceAmount {
    private String userId;
    private double amount;
    private String userExpenseId;

    public BalanceAmount(String userId, double amount, String userExpenseId) {
      this.userId = userId;
      this.amount = amount;
      this.userExpenseId = userExpenseId;
    }

    public String getUserId() {
      return userId;
    }

    public double getAmount() {
      return amount;
    }

    public String getUserExpenseId() {
      return userExpenseId;
    }

    public void setAmount(double amount) {
      this.amount = amount;
    }
  }

}

package com.learning.lowleveldesign.splitwise.model;

import java.util.List;

import com.learning.lowleveldesign.splitwise.service.ExpenseService;
import com.learning.lowleveldesign.splitwise.service.GroupService;

public class User extends SystemUser{

  private ExpenseService expenseService;
  private GroupService groupService;
  public User(String id, String name, String email, String phone) {
    super(name, email, phone, id);
  }

  public String addExpense(ExpenseRequest expenseRequest){
    return expenseService.addExpense(expenseRequest);
  }

  public List<GroupExpenseSummary> getAllExpensesInAGroup(String groupId){
    return expenseService.getAllExpensesForAGroup(groupId);
  }

  public List<Group> getAllGroupsForAUser(String userId){
    return groupService.findAllGroupsForUser(userId);
  }

  public List<UserExpenseSummary> getExpenseSummaryWithOtherUsers(String userId){
    return expenseService.getAllExpensesWithOtherUsersForAGivenUser(userId);
  }

  public Group createGroup(String name, String description){
    return groupService.createGroup(name, description, getId());
  }

  public boolean addUsersToGroup(List<String> userIds, String groupId){
    return groupService.addUsersToGroup(userIds, groupId);
  }

  public boolean leaveAGroup(String groupId){
    return groupService.removeAUserFromGroup(groupId, getId());
  }

  public boolean deleteAGroup(String groupId){
    return groupService.deleteGroup(groupId, getId());
  }

  public boolean settleDebtBetweenUsers(String owedToUserId, double amount_to_settle){
    return expenseService.settleDebt(owedToUserId, getId(), amount_to_settle);
  }

  public void deleteExpense(String expenseId){
    expenseService.deleteExpense(expenseId);
  }
}

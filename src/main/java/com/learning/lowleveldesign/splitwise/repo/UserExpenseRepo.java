package com.learning.lowleveldesign.splitwise.repo;

import java.util.List;

import com.learning.lowleveldesign.splitwise.model.UserExpense;

public interface UserExpenseRepo {
  UserExpense saveUserExpense(UserExpense userExpense);
  List<UserExpense> getAllUserExpensesByExpenseId(String expenseId);
  List<UserExpense> getAllUserExpensesByUserId(String userId);
  List<UserExpense> getAllUserExpenseByExpenseIdBulk(List<String> expenseIds);
}

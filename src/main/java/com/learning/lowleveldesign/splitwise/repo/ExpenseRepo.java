package com.learning.lowleveldesign.splitwise.repo;

import java.util.List;

import com.learning.lowleveldesign.splitwise.model.Expense;

public interface ExpenseRepo {
  Expense saveExpense(Expense expense);
  Expense getExpenseById(String expenseId);
  List<Expense> getAllExpensesForAGroup(String groupId);
}

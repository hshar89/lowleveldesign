package com.learning.lowleveldesign.splitwise.repo;

import java.util.List;

import com.learning.lowleveldesign.splitwise.model.UserExpenseMapping;

public interface UserExpenseMappingRepo {
  UserExpenseMapping saveUserExpenseMapping(UserExpenseMapping userExpenseMapping);

  List<UserExpenseMapping> getAllExpensesWhereUserOwes(String userId);

  List<UserExpenseMapping> getAllExpensesWhereUserIsOwed(String userId);
}

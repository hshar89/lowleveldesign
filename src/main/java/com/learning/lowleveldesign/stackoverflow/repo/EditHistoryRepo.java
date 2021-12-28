package com.learning.lowleveldesign.stackoverflow.repo;

import java.util.List;

import com.learning.lowleveldesign.stackoverflow.model.EditHistory;

public interface EditHistoryRepo {
  EditHistory saveEditHistory(EditHistory editHistory);
  List<EditHistory> getAllEditHistoryForQuestion(Integer questionId);
}

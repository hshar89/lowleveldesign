package com.learning.lowleveldesign.atmmachine.model;

import java.util.List;

public class WithdrawMoney implements Option<List<Option>, Integer>{
  @Override
  public List<Option> performAction(Integer userInput) {
    return null;
  }
}

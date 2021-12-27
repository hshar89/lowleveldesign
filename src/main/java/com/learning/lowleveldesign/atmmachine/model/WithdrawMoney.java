package com.learning.lowleveldesign.atmmachine.model;

import java.util.List;

public class WithdrawMoney implements Option<List<Option>, Void>{

  @Override
  public List<Option> performAction(Void userInput) {
    return null;
  }
}

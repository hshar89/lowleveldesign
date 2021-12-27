package com.learning.lowleveldesign.atmmachine.model;

public class WithdrawalInput implements UserInput<WithdrawalRequest>{

  private WithdrawalRequest withdrawalRequest;
  @Override
  public WithdrawalRequest getInput() {
    return withdrawalRequest;
  }

  @Override
  public void setInput(WithdrawalRequest amount) {
    this.withdrawalRequest = withdrawalRequest;
  }
}

package com.learning.lowleveldesign.atmmachine.model;

public class MakeWithdrawal implements Option<WithdrawalResponse, WithdrawalRequest>{

  private Bank bank;

  public MakeWithdrawal(Bank bank) {
    this.bank = bank;
  }

  @Override
  public WithdrawalResponse performAction(WithdrawalRequest userInput) {
    if(userInput.getOption() instanceof SavingBankWithdrawal){
      bank.withDrawMoneyFromBankAccount(userInput.getAmount(), userInput.getBankAccountDetail(), AccountType.SAVING);
    }
    return bank.withDrawMoneyFromBankAccount(userInput.getAmount(), userInput.getBankAccountDetail(), AccountType.CURRENT);
  }
}

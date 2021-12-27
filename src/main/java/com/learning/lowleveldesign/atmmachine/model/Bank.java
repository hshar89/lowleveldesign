package com.learning.lowleveldesign.atmmachine.model;

public class Bank {
  private String bankId;
  private String bankname;
  private Address ownerBranchAddress;

  public AuthenticationResponse authenticateCard(Integer pinNumber, BankAccountDetail bankAccountDetail){
    return null;
  }

  public WithdrawalResponse withDrawMoneyFromBankAccount(Integer amount, BankAccountDetail bankAccountDetail, AccountType accountType){
    return null;
  }
}

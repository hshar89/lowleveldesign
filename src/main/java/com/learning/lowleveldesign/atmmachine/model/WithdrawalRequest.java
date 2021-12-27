package com.learning.lowleveldesign.atmmachine.model;

public class WithdrawalRequest {
  private Integer amount;
  private BankAccountDetail bankAccountDetail;
  private Option option;

  public WithdrawalRequest(Integer amount,
                           BankAccountDetail bankAccountDetail,
                           Option option) {
    this.amount = amount;
    this.option = option;
    this.bankAccountDetail = bankAccountDetail;
  }

  public Integer getAmount() {
    return amount;
  }

  public BankAccountDetail getBankAccountDetail() {
    return bankAccountDetail;
  }

  public Option getOption() {
    return option;
  }
}

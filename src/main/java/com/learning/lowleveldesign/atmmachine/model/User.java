package com.learning.lowleveldesign.atmmachine.model;

import java.util.List;

public class User extends Person {
  private AtmMachine atmMachine;
  private Card card;

  public User(String fname, String lname, String email, String phone, AtmMachine atmMachine, Card card) {
    super(fname, lname, email, phone);
    this.atmMachine = atmMachine;
    this.card = card;
  }

  public TransactionDetail startTransaction(Card card) {
    try{
      return atmMachine.startTransaction(card);
    }catch (Exception exception){
      return null;
    }
  }

  public boolean authenticateThroughPin(Integer pinNumber, TransactionDetail transactionDetail){
    try {
      return atmMachine.authenticateCard(pinNumber, transactionDetail);
    } catch (Exception e) {
      return false;
    }
  }

  public List<Option> getAvailableOptions(TransactionDetail transactionDetail){
    return atmMachine.getAvailableOptionsForAccount(transactionDetail);
  }

  public Object performAction(Option option, UserInput userInput){
    return option.performAction(userInput.getInput());
  }

  public BankAccountDetail getBankAccountDetail(TransactionDetail transactionDetail){
    return atmMachine.getBankAccountDetail(transactionDetail);
  }
}

package com.learning.lowleveldesign.atmmachine.model;

import java.util.List;
import java.util.Map;

public class Admin extends SystemUser{
  private AtmMachine atmMachine;
  private Menu menu;

  public Admin(String fname, String lname, String email, String phone, String userId,
               Account account, AtmMachine atmMachine, Menu menu) {
    super(fname, lname, email, phone, userId, account);
    this.atmMachine = atmMachine;
    this.menu = menu;
  }

  public boolean addMoney(Map<Denomination, List<Cash>> amountToAdd){
    return atmMachine.addMoneyInBulk(amountToAdd);
  }

  public void addOptionForBankUser(Option option){
    menu.addOptionToListOne(option);
  }
  public void addOptonForNonBankUser(Option option){
    menu.addOptionsToListTwo(option);
  }
}

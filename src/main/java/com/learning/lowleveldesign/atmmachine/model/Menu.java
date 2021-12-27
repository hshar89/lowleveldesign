package com.learning.lowleveldesign.atmmachine.model;

import java.util.List;

public class Menu {
  private List<Option> optionsBankSameAsAtmBank;
  private List<Option> optionsBankDiff;

  public List<Option> getAvailableOptionsForUser(boolean sameBankAsAtmBank) {
    if(sameBankAsAtmBank){
      return optionsBankSameAsAtmBank;
    }
    return optionsBankDiff;
  }

  public void addOptionToListOne(Option option) {
    optionsBankSameAsAtmBank.add(option);
  }

  public void addOptionsToListTwo(Option option){
    optionsBankDiff.add(option);
  }
}

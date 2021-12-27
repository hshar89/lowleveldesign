package com.learning.lowleveldesign.atmmachine.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CashDispenser {

  private Map<Denomination, List<Cash>> denominationMap;

  public CashDispenser() {
    this.denominationMap = new HashMap<>();
  }

  public void dispenseCash(Integer amountToWithdraw) {
    Map<Denomination, Integer> dispenseCashMap = findOptimumDistributionOfDenominationToDispenseCash(amountToWithdraw);
  }

  private Map<Denomination, Integer> findOptimumDistributionOfDenominationToDispenseCash(Integer amountToWithdraw) {
    return null;
  }

  public boolean addMoney(Denomination denomination, List<Cash> notes) {
    if (denominationMap.containsKey(denomination)) {
      denominationMap.get(denomination).addAll(notes);
    } else {
      denominationMap.put(denomination, notes);
    }
    return true;
  }
}

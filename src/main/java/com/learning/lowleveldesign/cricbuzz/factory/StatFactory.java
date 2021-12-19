package com.learning.lowleveldesign.cricbuzz.factory;

import com.learning.lowleveldesign.cricbuzz.contract.StatCalculator;
import com.learning.lowleveldesign.cricbuzz.impl.TotalRunCalculator;
import com.learning.lowleveldesign.cricbuzz.model.StatType;

public class StatFactory {

  private StatFactory(){

  }
  private static final StatFactory instance = new StatFactory();
  public static StatFactory getInstance(){
    return instance;
  }

  public StatCalculator getStatCalculator(StatType statType){
    if(statType.equals(StatType.TOTALRUNS)){
      return new TotalRunCalculator();
    }
    return null;
  }
}

package com.learning.lowleveldesign.cricbuzz.contract;

public interface StatService <T,R>{
  T getStats(R r);
}

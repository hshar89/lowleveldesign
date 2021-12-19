package com.learning.lowleveldesign.cricbuzz.model;

import java.util.Date;
import java.util.List;

public class Stadium {
  String name;
  Address address;
  int seatingCapacity;
  List<Integer> matchesPlayedInTheStadium;

  public List<Match> matchesPlayedTillNow(){
    return null;
  }
  public List<Match> matchesPlayedBetween(Date startDate, Date endDate){
    return null;
  }
}

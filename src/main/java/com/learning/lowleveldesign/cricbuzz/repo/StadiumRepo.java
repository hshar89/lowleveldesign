package com.learning.lowleveldesign.cricbuzz.repo;

import java.util.List;

import com.learning.lowleveldesign.cricbuzz.model.Stadium;

public interface StadiumRepo {
  boolean saveStadium(Stadium stadium);
  Stadium getStadiumById(int stadiumId);
  List<Integer> matchesPlayedInStadium(int stadiumId);
  boolean addMatchIdToStadium(int matchId, int stadiumId);
}

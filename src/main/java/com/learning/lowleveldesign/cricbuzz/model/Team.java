package com.learning.lowleveldesign.cricbuzz.model;

import java.util.List;

public class Team {
  List<Integer> players;
  String name;
  Owner teamOwner;
  List<Integer> teamStats;
  List<Integer> matchesPlayedByTeam;
  int tournamentId;
}

package com.learning.lowleveldesign.cricbuzz.repo;

import java.util.List;

import com.learning.lowleveldesign.cricbuzz.model.Match;

public interface MatchRepo {
  boolean saveAMatch(Match match);
  Match getMatchById(int matchId);
  List<Match> getAllMatchesForATournament(int tournamentId);
}

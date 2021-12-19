package com.learning.lowleveldesign.cricbuzz.repo;

import java.util.Date;
import java.util.List;

import com.learning.lowleveldesign.cricbuzz.model.Tournament;

public interface TournamentRepo {
  boolean addTournament(Tournament tournament);
  Tournament getTournamentById(int tournamentId);
  List<Tournament> getAllTournamentsBetweenDates(Date startDate, Date endDate);
}

package com.learning.lowleveldesign.cricbuzz.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.learning.lowleveldesign.cricbuzz.model.Match;
import com.learning.lowleveldesign.cricbuzz.model.Team;
import com.learning.lowleveldesign.cricbuzz.model.Tournament;
import com.learning.lowleveldesign.cricbuzz.repo.MatchRepo;
import com.learning.lowleveldesign.cricbuzz.repo.TeamRepo;
import com.learning.lowleveldesign.cricbuzz.repo.TournamentRepo;

public class TournamentService {
  TournamentRepo tournamentRepo;
  TeamRepo teamRepo;
  MatchRepo matchRepo;

  public List<Tournament> getTournamentsAfterDate(Date date) {
    return tournamentRepo.getAllTournamentsBetweenDates(date, new Date());
  }

  public Tournament getTournamentByStartDateAndName(Date startDate, String tournamentName) {
    List<Tournament> tournaments = tournamentRepo.getAllTournamentsBetweenDates(startDate, new Date());
    Optional<Tournament> tournamentOptional =
        tournaments.stream().filter(tournament -> tournament.getName().equalsIgnoreCase(tournamentName)).findFirst();
    return tournamentOptional.isPresent() ? tournamentOptional.get() : null;
  }

  public List<Team> getAllTeamsForATournament(int tournamentId) {
    return teamRepo.getAllTeamsByTournamentId(tournamentId);
  }

  public List<Match> getAllMatchesForATournament(int tournamentId){
    return matchRepo.getAllMatchesForATournament(tournamentId);
  }
}

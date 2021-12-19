package com.learning.lowleveldesign.cricbuzz.repo;

import java.util.List;

import com.learning.lowleveldesign.cricbuzz.model.Team;

public interface TeamRepo {
  boolean createTeam(Team team);
  Team getTeamById(int teamId);
  List<Team> getAllTeamsByTournamentId(int tournamentId);
}

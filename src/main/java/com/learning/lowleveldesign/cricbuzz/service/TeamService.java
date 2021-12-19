package com.learning.lowleveldesign.cricbuzz.service;

import com.learning.lowleveldesign.cricbuzz.model.Team;
import com.learning.lowleveldesign.cricbuzz.repo.TeamRepo;

public class TeamService {
  TeamRepo teamRepo;

  public Team getTeamById(int teamId) {
    return teamRepo.getTeamById(teamId);
  }
}

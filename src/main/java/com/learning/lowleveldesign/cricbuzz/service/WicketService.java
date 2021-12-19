package com.learning.lowleveldesign.cricbuzz.service;

import java.util.List;

import com.learning.lowleveldesign.cricbuzz.model.Inning;
import com.learning.lowleveldesign.cricbuzz.model.Wicket;
import com.learning.lowleveldesign.cricbuzz.repo.WicketRepo;

public class WicketService {
  WicketRepo wicketRepo;
  public List<Wicket> getAllWicketsForAMatch(int matchId){
    return wicketRepo.getWicketByMatch(matchId);
  }

  public List<Wicket> getWicketsByInningAndMatchId(Inning inning, int matchId){
    return wicketRepo.getWicketByMatchIdAndInning(inning, matchId);
  }
}

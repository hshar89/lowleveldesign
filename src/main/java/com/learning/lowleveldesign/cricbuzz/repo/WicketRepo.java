package com.learning.lowleveldesign.cricbuzz.repo;

import java.util.List;

import com.learning.lowleveldesign.cricbuzz.model.Inning;
import com.learning.lowleveldesign.cricbuzz.model.Wicket;

public interface WicketRepo {
  boolean saveAWicket(Wicket wicket);

  Wicket getWicketByBallId(String ballId);

  List<Wicket> getWicketByMatch(int matchId);

  List<Wicket> getWicketByMatchIdAndInning(Inning inning, int matchId);
}

package com.learning.lowleveldesign.cricbuzz.repo;

import java.util.List;

import com.learning.lowleveldesign.cricbuzz.model.Over;

public interface OverRepo {
  boolean saveAnOver(Over over);
  Over getOverById(int overId, int matchId);
  List<Over> getAllOversInAMatch(int matchId);
}

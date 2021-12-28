package com.learning.lowleveldesign.cricbuzz.repo;

import com.learning.lowleveldesign.cricbuzz.model.Stat;

public interface StatRepo {
  boolean createStat(Stat stat);
  Stat getStatById(int statId);
}

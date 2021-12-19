package com.learning.lowleveldesign.cricbuzz.repo;

import com.graph.lld.cricbuzz.model.Stat;

public interface StatRepo {
  boolean createStat(Stat stat);
  Stat getStatById(int statId);
}

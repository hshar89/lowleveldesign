package com.learning.lowleveldesign.cricbuzz.repo;

import com.graph.lld.cricbuzz.model.Empire;

public interface EmpireRepo {
  boolean saveEmpire(Empire empire);
  Empire getEmpireById(int empireId);
}

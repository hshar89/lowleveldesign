package com.learning.lowleveldesign.cricbuzz.repo;

import java.util.List;

import com.learning.lowleveldesign.cricbuzz.model.EmpireInstance;

public interface EmpireInstanceRepo {
  boolean addEmpireInstance(EmpireInstance empireInstance);
  List<Integer> getAllMatchesForAnEmpire(int empireId);
  List<Integer> getAllEmpiresForAMatch(int matchId);
}

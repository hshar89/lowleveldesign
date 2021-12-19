package com.learning.lowleveldesign.cricbuzz.repo;

import java.util.List;

import com.graph.lld.cricbuzz.model.PlayerInstance;

public interface PlayerInstanceRepo {
  boolean addPlayerInstance(PlayerInstance playerInstance);
  List<Integer> getAllPlayerIdsForAMatch(int matchId);
  List<Integer> getAllMatchesPlayedByThePLayer(int playerId);
  List<Integer> getAllTeamsThePlayerHasBeenPartOff(int playerId);
}

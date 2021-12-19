package com.learning.lowleveldesign.cricbuzz.repo;

import java.util.List;

import com.learning.lowleveldesign.cricbuzz.model.Player;

public interface PlayerRepo {
  boolean savePlayer(Player player);
  Player getPlayerById(int playerId);
  List<Player> getPlayersInBulk(List<Integer> plaerIds);
}

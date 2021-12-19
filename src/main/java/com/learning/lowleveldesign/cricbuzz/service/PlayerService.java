package com.learning.lowleveldesign.cricbuzz.service;


import com.learning.lowleveldesign.cricbuzz.model.Player;
import com.learning.lowleveldesign.cricbuzz.repo.PlayerRepo;

public class PlayerService {
  private PlayerRepo playerRepo;
  public Player getPLayerDetails(int playerId){
    return playerRepo.getPlayerById(playerId);
  }
}

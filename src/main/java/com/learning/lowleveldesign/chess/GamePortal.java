package com.learning.lowleveldesign.chess;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GamePortal {
  private Map<String, AnonymousUser> anonymousUserMap;
  private Map<String, User> registeredUser;
  private Map<String, Robot> robotMap;
  private Map<String, Player> playerPool;
  private Map<String, Player> robotPool;
  private Map<String, Match> matches;

  public GamePortal(){
    this.anonymousUserMap = new HashMap<>();
    this.registeredUser = new HashMap<>();
    this.matches = new HashMap<>();
    this.playerPool = new HashMap<>();
  }
  public User registerUser(User user) {
    user.setUserId(UUID.randomUUID().toString());
    return user;
  }

  public AnonymousUser generateAnonymousUser(String fname, String lname){
    AnonymousUser anonymousUser = new AnonymousUser(fname, lname);
    anonymousUserMap.put(anonymousUser.getAnonymousUserId(), anonymousUser);
    return anonymousUser;
  }

  public Match createMatchWithAnotherUser(User user){
    return null;
  }

  public Match createMatchWithRobot(User user){
    return null;
  }

  public Player addToPool(User user){
    return null;
  }

  public Player addToPool(AnonymousUser anonymousUser){
    return null;
  }

  public Player addToPool(Robot robot){
    return null;
  }

}

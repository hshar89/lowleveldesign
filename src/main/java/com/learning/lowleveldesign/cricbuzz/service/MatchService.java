package com.learning.lowleveldesign.cricbuzz.service;

import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

import com.learning.lowleveldesign.cricbuzz.model.Ball;
import com.learning.lowleveldesign.cricbuzz.model.Commentator;
import com.learning.lowleveldesign.cricbuzz.model.Match;
import com.learning.lowleveldesign.cricbuzz.model.Over;
import com.learning.lowleveldesign.cricbuzz.model.Player;
import com.learning.lowleveldesign.cricbuzz.model.Stadium;
import com.learning.lowleveldesign.cricbuzz.model.Team;
import com.learning.lowleveldesign.cricbuzz.model.TossDetail;
import com.learning.lowleveldesign.cricbuzz.repo.BallRepo;
import com.learning.lowleveldesign.cricbuzz.repo.CommentatorInstanceRepo;
import com.learning.lowleveldesign.cricbuzz.repo.CommentatorRepo;
import com.learning.lowleveldesign.cricbuzz.repo.MatchRepo;
import com.learning.lowleveldesign.cricbuzz.repo.OverRepo;
import com.learning.lowleveldesign.cricbuzz.repo.PlayerInstanceRepo;
import com.learning.lowleveldesign.cricbuzz.repo.PlayerRepo;
import com.learning.lowleveldesign.cricbuzz.repo.StadiumRepo;
import com.learning.lowleveldesign.cricbuzz.repo.TeamRepo;
import com.learning.lowleveldesign.cricbuzz.repo.TossRepo;

public class MatchService {
  private MatchRepo matchRepo;
  private PlayerRepo playerRepo;
  private TeamRepo teamRepo;
  private PlayerInstanceRepo playerInstanceRepo;
  private CommentatorInstanceRepo commentatorInstanceRepo;
  private CommentatorRepo commentatorRepo;
  private StadiumRepo stadiumRepo;
  private TossRepo tossRepo;
  private OverRepo overRepo;
  private BallRepo ballRepo;

  public List<Player> getAllPlayersOfATeamForAMatch(int matchId, int teamId) {
    List<Integer> playerIds = playerInstanceRepo.getAllPlayerIdsForAMatch(matchId);
    return playerRepo.getPlayersInBulk(playerIds);
  }

  public Stadium findStadiumForAMatch(int matchId) {
    Match match = matchRepo.getMatchById(matchId);
    return stadiumRepo.getStadiumById(match.getStadiumId());
  }

  public List<Commentator> getAllCommentatorsForAMatch(int matchId) {
    List<Integer> commentatorIds = commentatorInstanceRepo.getAllCommentatorForAMatch(matchId);
    return commentatorRepo.getAllCommentatorsInBulk(commentatorIds);
  }

  public TossDetail getTossDetailsForMatch(int matchId) {
    return tossRepo.getTossByMatchId(matchId);
  }

  public boolean addTossDetails(TossDetail tossDetail) {
    return tossRepo.saveAToss(tossDetail);
  }

  public Pair<Team, Team> getTeamsParticipatingInAMatch(int matchId) {
    Match match = matchRepo.getMatchById(matchId);
    Team teamA = teamRepo.getTeamById(match.getTeamAId());
    Team teamB = teamRepo.getTeamById(match.getTeamBId());
    return Pair.of(teamA, teamB);
  }

  public List<Over> getAllOversPartOfMatch(int matchId) {
    return overRepo.getAllOversInAMatch(matchId);
  }

  public List<Ball> getAllBallsForAMatch(int matchId) {
    return ballRepo.getBallsForAMatch(matchId);
  }
}

package com.learning.lowleveldesign.cricbuzz.model;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;

import com.learning.lowleveldesign.cricbuzz.service.BallService;
import com.learning.lowleveldesign.cricbuzz.service.MatchService;
import com.learning.lowleveldesign.cricbuzz.service.OverService;
import com.learning.lowleveldesign.cricbuzz.service.RunService;
import com.learning.lowleveldesign.cricbuzz.service.TeamService;
import com.learning.lowleveldesign.cricbuzz.service.TournamentService;
import com.learning.lowleveldesign.cricbuzz.service.WicketService;

public class User extends Person {
  private TournamentService tournamentService;
  private MatchService matchService;
  private OverService overService;
  private BallService ballService;
  private WicketService wicketService;
  private RunService runService;
  private TeamService teamService;

  public List<Tournament> getUpcomingTournaments(Date startDate) {
    return tournamentService.getTournamentsAfterDate(startDate);
  }

  public Tournament getTournamentByNameAndDate(Date startDate, String nameOfTournament) {
    return tournamentService.getTournamentByStartDateAndName(startDate, nameOfTournament);
  }

  public List<Team> getTeamsForATournament(int tournamentId) {
    return tournamentService.getAllTeamsForATournament(tournamentId);
  }

  public List<Match> getAllMatchesInATournament(int tournamentId) {
    return tournamentService.getAllMatchesForATournament(tournamentId);
  }

  public List<Player> getPlayersOfATeamParticipatingInAMatch(int matchId, int teamId) {
    return matchService.getAllPlayersOfATeamForAMatch(matchId, teamId);
  }

  public Stadium getStadiumDetailsForAMatch(int matchId) {
    return matchService.findStadiumForAMatch(matchId);
  }

  public List<Commentator> getCommentatorsForAMatch(int matchId) {
    return matchService.getAllCommentatorsForAMatch(matchId);
  }

  public Pair<Team, Team> getTeamsParticipatingInAMatch(int matchId) {
    return matchService.getTeamsParticipatingInAMatch(matchId);
  }

  public TossDetail getTossDetailsForAMatch(int matchId) {
    return matchService.getTossDetailsForMatch(matchId);
  }

  public List<Over> getAllOversInAMatch(int matchId) {
    return matchService.getAllOversPartOfMatch(matchId);
  }

  public List<Ball> getAllBallsInAnOver(int overId, int matchId) {
    return overService.getAllBallsInAnOver(overId, matchId);
  }

  public List<Commentary> getCommentariesForAnOver(int overId, int matchId) {
    return overService.getAllCommentatriesForAnOver(overId, matchId);
  }

  public Commentary getCommentaryPerBall(String ballId) {
    return ballService.getCommentaryPerBall(ballId);
  }

  public Ball getLatestBallInMatch(int matchId) {
    return ballService.getLatestBallOfAMatch(matchId);
  }

  public List<Wicket> getAllWicketsForAMatch(int matchId) {
    return wicketService.getAllWicketsForAMatch(matchId);
  }

  public List<Run> getAllFoursInAMatch(int matchId) {
    List<Ball> balls = matchService.getAllBallsForAMatch(matchId);
    return runService.getRunsByScoreAndMatchId(4,
        balls.stream().map(ball -> ball.getBallId()).collect(Collectors.toList()));
  }

  public Team getTeamByInningAndMatch(Inning inning, int matchId) {
    TossDetail tossDetail = matchService.getTossDetailsForMatch(matchId);
    if (Inning.FIRST.equals(inning)) {
      return teamService.getTeamById(tossDetail.getBattingTeamIdFirstInning());
    }
    return teamService.getTeamById(tossDetail.getBattingTeamIdSecondInning());
  }

  public List<Wicket> getAllWicketsTakenInAInninigOfMatch(Inning inning, int matchId) {
    return wicketService.getWicketsByInningAndMatchId(inning, matchId);
  }

  public List<Stat> getStatsForAPlayer(int playerId) {
    return null;
  }

  public List<Match> getRecentMatches(int pageSize){
    return null;
  }

}

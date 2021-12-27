package com.learning.lowleveldesign.chess;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.tuple.Pair;

public class Knight extends ChessPiece{

  private static final Map<String, Map<PieceColor, Queue<Pair<Integer, Integer>>>> mapOfHorsePieces = new ConcurrentHashMap<>();

  public static void initialIzeInstanceWithMatch(String matchId){
    if(mapOfHorsePieces.containsKey(matchId)){
      return;
    }
    Map<PieceColor, Queue<Pair<Integer, Integer>>> piecesMap = new HashMap<>();
    Pair<Integer, Integer> p1 = Pair.of(0, 1);
    Pair<Integer, Integer> p2 = Pair.of(0, 6);
    Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
    queue.add(p1);
    queue.add(p2);
    piecesMap.put(PieceColor.WHITE, queue);

    Pair<Integer, Integer> p3 = Pair.of(7, 1);
    Pair<Integer, Integer> p4 = Pair.of(7, 6);
    Queue<Pair<Integer, Integer>> queue2 = new LinkedList<>();
    queue2.add(p3);
    queue2.add(p4);
    piecesMap.put(PieceColor.BLACK, queue2);
    mapOfHorsePieces.put(matchId, piecesMap);
  }

  public static ChessPiece getInstance(Integer pieceId, String matchId, PieceColor pieceColor){
    Pair<Integer, Integer> initialPosition = mapOfHorsePieces.get(matchId).get(pieceColor).poll();
    if(initialPosition==null){
      return null;
    }
    Knight knight = new Knight(pieceId, pieceColor, initialPosition);
    return knight;
  }
  private Knight(int pieceId, PieceColor pieceColor, Pair<Integer, Integer> initialPosition) {
    super(pieceId, pieceColor, initialPosition, false);
  }

  @Override
  public boolean isValidMove(Move move) {
    if(!(move instanceof TwoAndHalfMove)){
      return false;
    }
    TwoAndHalfMove twoAndHalfMove = (TwoAndHalfMove) move;
    if(!(twoAndHalfMove.getDirection()==Direction.DOWNLEFT || twoAndHalfMove.getDirection()==Direction.DOWNRIGHT)){
      return false;
    }
    return true;
  }
}

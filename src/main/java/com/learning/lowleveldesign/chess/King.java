package com.learning.lowleveldesign.chess;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.tuple.Pair;

public class King extends ChessPiece{

  private static final Map<String, Map<PieceColor, Queue<Pair<Integer, Integer>>>> mapOfHorsePieces = new ConcurrentHashMap<>();

  private King(int pieceId, PieceColor pieceColor,
              Pair<Integer, Integer> currentPosition) {
    super(pieceId, pieceColor, currentPosition, true);
  }

  public static void initialIzeInstanceWithMatch(String matchId){
    if(mapOfHorsePieces.containsKey(matchId)){
      return;
    }
    Map<PieceColor, Queue<Pair<Integer, Integer>>> piecesMap = new HashMap<>();
    Pair<Integer, Integer> p1 = Pair.of(0, 4);
    Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
    queue.add(p1);
    piecesMap.put(PieceColor.WHITE, queue);

    Pair<Integer, Integer> p3 = Pair.of(7, 4);
    Queue<Pair<Integer, Integer>> queue2 = new LinkedList<>();
    queue2.add(p3);
    piecesMap.put(PieceColor.BLACK, queue2);
    mapOfHorsePieces.put(matchId, piecesMap);
  }

  public static ChessPiece getInstance(Integer pieceId, String matchId, PieceColor pieceColor){
    Pair<Integer, Integer> initialPosition = mapOfHorsePieces.get(matchId).get(pieceColor).poll();
    if(initialPosition==null){
      return null;
    }
    King king = new King(pieceId, pieceColor, initialPosition);
    return king;
  }

  @Override
  public boolean isValidMove(Move move) {
    return false;
  }
}

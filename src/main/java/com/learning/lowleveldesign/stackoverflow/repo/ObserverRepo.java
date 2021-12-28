package com.learning.lowleveldesign.stackoverflow.repo;

import java.util.List;

import com.learning.lowleveldesign.stackoverflow.model.Observer;

public interface ObserverRepo {
  Observer saveObserver(Observer observer);
  List<Observer> getObserversForEntity(Integer entityId);
}

package com.learning.lowleveldesign.atmmachine.model;

public interface Option<T, R> {
  public T performAction(R userInput);
}

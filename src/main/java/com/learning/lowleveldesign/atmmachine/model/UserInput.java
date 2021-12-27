package com.learning.lowleveldesign.atmmachine.model;

public interface UserInput<T> {
  public T getInput();
  public void setInput(T t);
}

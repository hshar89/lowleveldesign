package com.learning.lowleveldesign.elevator;

public interface Button<T> {
  public void performAction(T object);
}

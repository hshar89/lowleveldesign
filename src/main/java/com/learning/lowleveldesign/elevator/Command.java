package com.learning.lowleveldesign.elevator;

public class Command {
  private final Integer floorNum;

  public Command(Integer floorNum) {
    this.floorNum = floorNum;
  }

  public Integer getFloorNum() {
    return floorNum;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Command command = (Command) o;

    return floorNum != null ? floorNum.equals(command.floorNum) : command.floorNum == null;
  }

  @Override
  public int hashCode() {
    return floorNum != null ? floorNum.hashCode() : 0;
  }
}

package com.learning.lowleveldesign.atmmachine.model;

import java.util.UUID;

public class TransactionDetail {
  private String transactionId;

  public TransactionDetail(){
    this.transactionId = UUID.randomUUID().toString();
  }
}

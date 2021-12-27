package com.learning.lowleveldesign.atmmachine.model;

public class AuthenticationResponse {
  private int responseId;
  private boolean isSameBankAsAtm;
  private boolean isAuthenticationSuccess;

  public AuthenticationResponse(int responseId, boolean isSameBankAsAtm, boolean isAuthenticationSuccess) {
    this.responseId = responseId;
    this.isAuthenticationSuccess = isAuthenticationSuccess;
    this.isSameBankAsAtm = isSameBankAsAtm;
  }

  public int getResponseId() {
    return responseId;
  }

  public boolean isSameBankAsAtm() {
    return isSameBankAsAtm;
  }

  public boolean isAuthenticationSuccess() {
    return isAuthenticationSuccess;
  }
}

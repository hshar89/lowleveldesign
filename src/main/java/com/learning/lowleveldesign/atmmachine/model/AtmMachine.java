package com.learning.lowleveldesign.atmmachine.model;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class AtmMachine {
  private String machineId;
  private Address address;
  private Integer totalCurrentAmount;
  private String bankId;
  private ATMType atmType;
  private Keypad keypad;
  private DisplayScreen displayScreen;
  private CashDispenser cashDispenser;

  private UserCardTransaction currentCardInstance;
  private Scanner scanner;
  private Bank bank;
  private Menu menu;

  public AtmMachine(Address address, String bankId, ATMType atmType, Scanner scanner, Bank bank) {
    this.machineId = UUID.randomUUID().toString();
    this.address = address;
    this.bankId = bankId;
    this.atmType = atmType;
    this.scanner = scanner;
    this.bank = bank;
    this.totalCurrentAmount = 0;
    this.cashDispenser = new CashDispenser();
  }

  public boolean addMoneyInBulk(Map<Denomination, List<Cash>> denominationMap) {
    for (Map.Entry<Denomination, List<Cash>> entry : denominationMap.entrySet()) {
      cashDispenser.addMoney(entry.getKey(), entry.getValue());
      this.totalCurrentAmount += entry.getKey().getValue() * entry.getValue().size();
    }
    return true;
  }

  public BankAccountDetail readCardDetails(Card card) {
    return scanner.readCard(card);
  }

  public TransactionDetail startTransaction(Card card) throws Exception {
    BankAccountDetail bankAccountDetail = readCardDetails(card);
    if (currentCardInstance != null) {
      throw new Exception();
    }
    TransactionDetail transactionDetail = new TransactionDetail();
    this.currentCardInstance = new UserCardTransaction(card, bankAccountDetail, transactionDetail);
    return transactionDetail;
  }

  public boolean closeCurrentTransaction(TransactionDetail transactionDetail) {
    this.currentCardInstance = null;
    return true;
  }

  public boolean authenticateCard(Integer pinNumber, TransactionDetail transactionDetail) throws Exception {
    if (transactionDetail != currentCardInstance.getTransactionDetail()) {
      throw new Exception();
    }
    AuthenticationResponse authenticationResponse =
        bank.authenticateCard(pinNumber, currentCardInstance.getBankAccountDetail());
    currentCardInstance.setSameBankAsAtmBank(authenticationResponse.isSameBankAsAtm());
    currentCardInstance.setIsAuthenticated(authenticationResponse.isAuthenticationSuccess());
    return authenticationResponse.isAuthenticationSuccess();
  }

  public List<Option> getAvailableOptionsForAccount(TransactionDetail transactionDetail) {
    return menu.getAvailableOptionsForUser(currentCardInstance.isSameBankAsAtmBank());
  }

  public BankAccountDetail getBankAccountDetail(TransactionDetail transactionDetail) {
    return currentCardInstance.getBankAccountDetail();
  }


  private static class UserCardTransaction {
    private Card card;
    private BankAccountDetail bankAccountDetail;
    private TransactionDetail transactionDetail;
    private boolean isAuthenticated;
    private boolean isSameBankAsAtmBank;
    private long startInstant;
    private long expiryInstant;

    public UserCardTransaction(Card card, BankAccountDetail bankAccountDetail,
                               TransactionDetail transactionDetail) {
      this.card = card;
      this.bankAccountDetail = bankAccountDetail;
      this.transactionDetail = transactionDetail;
      this.startInstant = System.currentTimeMillis();
      this.expiryInstant = startInstant + 10000;
    }

    public void setIsAuthenticated(boolean isAuthenticated) {
      this.isAuthenticated = isAuthenticated;
    }

    public Card getCard() {
      return card;
    }

    public BankAccountDetail getBankAccountDetail() {
      return bankAccountDetail;
    }

    public TransactionDetail getTransactionDetail() {
      return transactionDetail;
    }

    public boolean isSameBankAsAtmBank() {
      return isSameBankAsAtmBank;
    }

    public boolean isAuthenticated() {
      return isAuthenticated;
    }

    public void setSameBankAsAtmBank(boolean sameBankAsAtmBank) {
      isSameBankAsAtmBank = sameBankAsAtmBank;
    }
  }
}

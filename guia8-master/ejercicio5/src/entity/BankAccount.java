package entity;

public class BankAccount {
    private int accountNumber;
    private int clientID;
    private String clientName;
    private double currentBalance;
    public BankAccount() {
    }
    public BankAccount(int accountNumber, int clientID, String clientName, double currentBalance) {
        this.accountNumber = accountNumber;
        this.clientID = clientID;
        this.clientName = clientName;
        this.currentBalance = currentBalance;
    }
    public String getClientName() {
        return clientName;
    }
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    public int getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    public int getClientID() {
        return clientID;
    }
    public void setClientID(int clientID) {
        this.clientID = clientID;
    }
    public double getCurrentBalance() {
        return currentBalance;
    }
    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }
}

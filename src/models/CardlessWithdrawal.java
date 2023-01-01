package models;

public class CardlessWithdrawal {
    private int referenceID;
    private int pinCode;
    private double amount;
    private String sender;

    public CardlessWithdrawal() {
    }

    public CardlessWithdrawal(int referenceID, int pinCode, double amount, String sender) {
        this.referenceID = referenceID;
        this.pinCode = pinCode;
        this.amount = amount;
        this.sender = sender;
    }

    public int getReferenceID() {
        return referenceID;
    }

    public void setReferenceID(int referenceID) {
        this.referenceID = referenceID;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}

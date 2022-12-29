package models;

import java.util.Date;

public class DebitCard {
    private long cardNum;
    private Date expirationDate;
    private int cvc;
    private int pin;
    private Account providesAccessTo;

    public DebitCard() {
    }

    public DebitCard(long cardNum, Date expirationDate, int cvc, int pin) {
        this.cardNum = cardNum;
        this.expirationDate = expirationDate;
        this.cvc = cvc;
        this.pin = pin;
    }

    public DebitCard(long cardNum, Date expirationDate, int cvc, int pin, Account providesAccessTo) {
        this.cardNum = cardNum;
        this.expirationDate = expirationDate;
        this.cvc = cvc;
        this.pin = pin;
        this.providesAccessTo = providesAccessTo;
    }

    public long getCardNum() {
        return cardNum;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public Account providesAccessTo() {
        return providesAccessTo;
    }

    public void setProvidesAccessTo(Account providesAccessTo) {
        this.providesAccessTo = providesAccessTo;
    }

    public boolean tryPin(int pin) {
        return pin == this.pin;
    }


}

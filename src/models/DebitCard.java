package models;

import java.util.ArrayList;
import java.util.Date;

public class DebitCard {
    private long cardNum;
    private Date expirationDate;
    private int cvc;
    private int pin;
    private Customer owner;
    private Bank managedBy;

    public DebitCard() {
    }

    public DebitCard(long cardNum, Date expirationDate, int cvc,int pin) {
        this.cardNum = cardNum;
        this.expirationDate = expirationDate;
        this.cvc = cvc;
        this.pin=pin;
    }
    public DebitCard(long cardNum, Date expirationDate, int cvc,int pin, Customer owner, Bank managedBy) {
        this.cardNum = cardNum;
        this.expirationDate = expirationDate;
        this.cvc = cvc;
        this.pin=pin;
        this.owner = owner;
        this.managedBy = managedBy;
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

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public Bank getManagedBy() {
        return managedBy;
    }

    public void setManagedBy(Bank managedBy) {
        this.managedBy = managedBy;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}

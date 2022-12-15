package models;

import java.util.ArrayList;

public class Account {
    private int accountNum;
    private double balance;
    private Customer owner;
    private Bank managedBy;

    private ArrayList<DebitCard> cards;

    public Account() {
    }

    public Account(int accountNum, double balance, Customer owner, Bank managedBy) {
        this.accountNum = accountNum;
        this.balance = balance;
        this.owner = owner;
        this.managedBy = managedBy;
    }

    public Account(int accountNum, double balance, Customer owner, Bank managedBy, ArrayList<DebitCard> cards) {
        this.accountNum = accountNum;
        this.balance = balance;
        this.owner = owner;
        this.managedBy = managedBy;
        this.cards = cards;
    }

    public int getAccountNum() {
        return accountNum;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public ArrayList<DebitCard> getCards() {
        return cards;
    }

    public void setCards(ArrayList<DebitCard> cards) {
        this.cards = cards;
    }

    public double checkBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Bank getManagedBy() {
        return managedBy;
    }

    public void setManagedBy(Bank managedBy) {
        this.managedBy = managedBy;
    }

    public boolean withdraw(double Amount) {
        if (balance >= Amount) {
            balance -= Amount;
            return true;
        } else {
            return false;
        }
    }

    public void deposit(double Amount) {
        balance += Amount;
    }
}
